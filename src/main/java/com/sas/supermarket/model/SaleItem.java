package com.sas.supermarket.model;
import jakarta.persistence.*; import java.math.BigDecimal;
@Entity @Table(name="sale_items")
public class SaleItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="sale_id") private Sale sale;
 private Long productId; private String productName; private int quantity;
 @Column(precision=12,scale=2) private BigDecimal unitPrice,subtotal;
 protected SaleItem(){}
 public SaleItem(Long id,String name,int qty,BigDecimal price,BigDecimal sub){productId=id;productName=name;quantity=qty;unitPrice=price;subtotal=sub;}
 void setSale(Sale s){sale=s;}
 public Long getId(){return id;} public Long getProductId(){return productId;} public String getProductName(){return productName;} public int getQuantity(){return quantity;} public BigDecimal getUnitPrice(){return unitPrice;} public BigDecimal getSubtotal(){return subtotal;}
}