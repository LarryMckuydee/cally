package com.larryco.cally.repositories;

import com.larryco.cally.models.TechnicalLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("technicalLeadRepository")
public interface TechnicalLeadRepository extends JpaRepository<TechnicalLead, Long>{
    TechnicalLead findByEmail(String email);
    TechnicalLead findById(String id);
}