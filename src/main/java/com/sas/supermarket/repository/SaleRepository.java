package com.sas.supermarket.repository;
import com.sas.supermarket.model.Sale; import org.springframework.data.jpa.repository.JpaRepository; import java.time.LocalDateTime; import java.util.List;
public interface SaleRepository extends JpaRepository<Sale,Long>{ List<Sale> findAllByOrderByCreatedAtDesc(); List<Sale> findByCreatedAtBetween(LocalDateTime a,LocalDateTime b); }