package com.larryco.cally.repositories;

import com.larryco.cally.models.CustomerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customerServiceRepository")
public interface CustomerServiceRepository extends JpaRepository<CustomerService, Long>{
    CustomerService findByEmail(String email);
    CustomerService findById(String id);
}