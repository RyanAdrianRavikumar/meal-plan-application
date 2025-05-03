package com.mealplan.customer.controller;

import com.mealplan.customer.entity.Customer;
import com.mealplan.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(path = "/customers/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @PutMapping(path = "/customers/{id}")
    public String updateCustomerById(@PathVariable int id, @RequestBody Customer updatedCustomer){
        return customerService.updateCustomerById(id, updatedCustomer);
    }

    @DeleteMapping(path = "/customers/{id}")
    public String deleteCustomerById(@PathVariable int id){
        return customerService.deleteCustomerById(id);
    }
}
