package com.sas.supermarket.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) @NotBlank private String code;
 @Column(nullable=false) @NotBlank private String name;
 private String category;
 @Column(nullable=false,precision=12,scale=2) @NotNull @DecimalMin("0.01") private BigDecimal price;
 @Min(0) private int stock;
 @Min(0) private int lowStockLevel=5;
 protected Product(){}
 public Long getId(){return id;} public String getCode(){return code;} public String getName(){return name;}
 public String getCategory(){return category;} public BigDecimal getPrice(){return price;} public int getStock(){return stock;} public int getLowStockLevel(){return lowStockLevel;}
 public void setCode(String x){code=x;} public void setName(String x){name=x;} public void setCategory(String x){category=x;} public void setPrice(BigDecimal x){price=x;} public void setStock(int x){stock=x;} public void setLowStockLevel(int x){lowStockLevel=x;}
 public void addStock(int n){if(n<1)throw new IllegalArgumentException("Quantity must be positive");stock+=n;}
 public void deductStock(int n){if(n<1||n>stock)throw new IllegalArgumentException("Insufficient stock");stock-=n;}
}