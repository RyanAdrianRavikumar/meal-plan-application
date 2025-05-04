package com.mealplan.customer.controller;

import com.mealplan.customer.dto.LoginRequest;
import com.mealplan.customer.entity.Customer;
import com.mealplan.customer.entity.CustomerAddress;
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

    @PostMapping(path = "/customers/login")
    public String customerLogin(@RequestBody LoginRequest loginRequest){
        System.out.println("Received email: " + loginRequest.getCustomerEmail());
        System.out.println("Received password: " + loginRequest.getCustomerPassword());
        return customerService.customerLogin(loginRequest.getCustomerEmail(), loginRequest.getCustomerPassword());
    }

    @PostMapping(path = "/customers/register")
    public String customerRegistration(@RequestBody Customer customer){
        return customerService.customerRegistration(customer);
    }

    @PostMapping(path = "/customers/address")
    public String setCustomerAddressing(@RequestBody CustomerAddress customerAddress){
        return customerService.setCustomerAddressing(customerAddress);
    }

    @PutMapping(path = "/customers/{customerId}/address")
    public String updateAddressByCustomerId(@PathVariable int customerId, @RequestBody CustomerAddress customerAddress){
        return customerService.updateAddressByCustomerId(customerId, customerAddress);
    }
}
