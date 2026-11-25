package com.sas.supermarket.controller;
import com.sas.supermarket.dto.CheckoutRequest; import com.sas.supermarket.model.*; import com.sas.supermarket.repository.*; import com.sas.supermarket.service.SupermarketService;
import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api") public class ApiController {
 private final ProductRepository products; private final SaleRepository sales; private final SupermarketService service;
 public ApiController(ProductRepository p,SaleRepository s,SupermarketService v){products=p;sales=s;service=v;}
 @GetMapping("/dashboard") public Map<String,Object> dashboard(){return service.dashboard();}
 @GetMapping("/products") public List<Product> list(@RequestParam(required=false) String q){return products.findAll().stream().filter(p->q==null||q.isBlank()||(p.getName()+" "+p.getCode()+" "+p.getCategory()).toLowerCase().contains(q.toLowerCase())).toList();}
 @PostMapping("/products") public ResponseEntity<Product> create(@Valid @RequestBody Product p){return ResponseEntity.status(201).body(service.saveProduct(p));}
 @PutMapping("/products/{id}") public Product update(@PathVariable Long id,@Valid @RequestBody Product p){return service.update(id,p);}
 @DeleteMapping("/products/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){if(!products.existsById(id))return ResponseEntity.notFound().build();products.deleteById(id);return ResponseEntity.noContent().build();}
 @PostMapping("/products/{id}/stock") public Map<String,String> stock(@PathVariable Long id,@RequestBody Map<String,Integer> b){service.stockIn(id,b.getOrDefault("quantity",0));return Map.of("message","Stock updated");}
 @PostMapping("/checkout") public ResponseEntity<Sale> checkout(@Valid @RequestBody CheckoutRequest r){return ResponseEntity.status(201).body(service.checkout(r));}
 @GetMapping("/sales") public List<Sale> sales(){return sales.findAllByOrderByCreatedAtDesc();}
 @ExceptionHandler(IllegalArgumentException.class) public ResponseEntity<Map<String,String>> error(Exception e){return ResponseEntity.badRequest().body(Map.of("error",e.getMessage()));}
}