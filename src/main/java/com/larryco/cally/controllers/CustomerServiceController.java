package com.larryco.cally.controllers;


import com.larryco.cally.models.CustomerService;
import com.larryco.cally.services.CustomerServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CustomerServiceController {
    @Autowired
    private CustomerServiceService customerService;
  
    @GetMapping("/customer_services")
    public List<CustomerService> all() {
       return customerService.getAllCustomerServices();
    }
  
    @PostMapping("/customer_services")
    public ResponseEntity<CustomerService> createCustomerService (@Valid @RequestBody CustomerService customer) {
        return ResponseEntity.ok(customerService.saveCustomerService(customer));
    }
  
    @PutMapping("/customer_services/{id}")
    public ResponseEntity<CustomerService> updateCustomerService(@Valid @RequestBody CustomerService customer,
      @PathVariable(value= "id") Long id) {
          return ResponseEntity.ok(customerService.updateCustomerService(customer, id));
      }
  
    @DeleteMapping("/customer_services/{id}")
    public ResponseEntity<?> deleteMemeber(@PathVariable Long id) {
      Map<String,String> response = new HashMap<String,String>();
      if(customerService.deleteCustomerService(id)) {
        response.put("status", "success");
        response.put("message", "customer deleted successfully");
         return ResponseEntity.ok(response);
      } else {
        response.put("status", "error");
        response.put("message", "Somthing went wrong when delete the customer");
        return ResponseEntity.status(500).body(response);
      }
    }
}