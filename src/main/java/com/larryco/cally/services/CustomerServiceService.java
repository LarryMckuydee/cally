package com.larryco.cally.services;

import com.larryco.cally.models.CustomerService;
import com.larryco.cally.repositories.CustomerServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("customerServiceService")
public class CustomerServiceService {
    @Autowired
    private CustomerServiceRepository customerServiceRepository;
 
    public CustomerService findCustomerServiceByEmail(String email) {
        return customerServiceRepository.findByEmail(email);
    }
 
    public List<CustomerService> getAllCustomerServices() {
        return customerServiceRepository.findAll();
    }
 
    public CustomerService saveCustomerService(CustomerService customerService) {
        return customerServiceRepository.save(customerService);
    }
 
    public CustomerService updateCustomerService(CustomerService customerService, Long id) {
      CustomerService updateCustomerService = customerServiceRepository.findById(id).orElse(null);
      if(updateCustomerService != null) {
          updateCustomerService.setName(customerService.getName());
          updateCustomerService.setEmail(customerService.getEmail());
      }
      final CustomerService mycustomerService = customerServiceRepository.save(updateCustomerService);
      return mycustomerService;
    }
 
    public Boolean deleteCustomerService (Long id) {
       CustomerService delCustomerService  = customerServiceRepository.findById(id).orElse(null);
       if(delCustomerService != null) {
           customerServiceRepository.delete(delCustomerService);
           return true;
       }
       return false;
    }
}