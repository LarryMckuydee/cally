package com.larryco.cally.repositories;

import com.larryco.cally.models.ProductManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productManagerRepository")
public interface ProductManagerRepository extends JpaRepository<ProductManager, Long>{
    ProductManager findByEmail(String email);
    ProductManager findById(String id);
}