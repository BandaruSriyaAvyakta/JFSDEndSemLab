
package com.klef.jfsd.exam.controller;

import com.klef.jfsd.exam.model.Customer;
import com.klef.jfsd.exam.repository.CustomerRepository;
import com.klef.jfsd.exam.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    // Insert Customer
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // Update Customer Name and Address
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestParam String name, @RequestParam String address) {
        return customerService.updateCustomer(id, name, address);
    }

    // Fetch All Customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
