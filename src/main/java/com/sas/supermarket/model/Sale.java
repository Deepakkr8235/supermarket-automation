package com.sas.supermarket.model;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDateTime; import java.util.*;
@Entity @Table(name="sales")
public class Sale {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String billNumber;
 @Column(nullable=false) private String paymentMethod;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal total;
 @Column(nullable=false) private LocalDateTime createdAt;
 @OneToMany(mappedBy="sale",cascade=CascadeType.ALL,orphanRemoval=true) private List<SaleItem> items=new ArrayList<>();
 protected Sale(){}
 public Sale(String bill,String method,BigDecimal total){this.billNumber=bill;this.paymentMethod=method;this.total=total;this.createdAt=LocalDateTime.now();}
 public void addItem(SaleItem i){items.add(i);i.setSale(this);}
 public Long getId(){return id;} public String getBillNumber(){return billNumber;} public String getPaymentMethod(){return paymentMethod;} public BigDecimal getTotal(){return total;} public LocalDateTime getCreatedAt(){return createdAt;} public List<SaleItem> getItems(){return items;}
}