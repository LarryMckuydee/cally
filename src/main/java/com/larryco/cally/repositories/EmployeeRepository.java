package com.larryco.cally.repositories;

import com.larryco.cally.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("EmployeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Employee findByEmail(String email);
    Employee findById(String id);
}