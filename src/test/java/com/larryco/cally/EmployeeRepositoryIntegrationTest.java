package com.larryco.cally;

import com.larryco.cally.models.CustomerService;
import com.larryco.cally.models.Employee;
import com.larryco.cally.repositories.CustomerServiceRepository;
import com.larryco.cally.repositories.EmployeeRepository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestEntityManager
@Transactional
public class EmployeeRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private CustomerServiceRepository customerServiceRepository;

    @Test
    public void whenFindByFirstName_thenReturnEmployee() {
        //given
        CustomerService customerService = new CustomerService();
        customerService.setEmail("larry@gmail.com");
        customerService.setName("Oleg");

        entityManager.persist(customerService);
        entityManager.flush();

        // fetch customerService
        CustomerService found = customerServiceRepository.findByEmail("larry@gmail.com");

        // then
        assertThat(found.getName())
          .isEqualTo(customerService.getName());
    }
}