package com.mealplan.customer.controller;

import com.mealplan.customer.dto.LoginRequest;
import com.mealplan.customer.entity.Customer;
import com.mealplan.customer.entity.CustomerAddress;
import com.mealplan.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> customerLogin(@RequestBody LoginRequest loginRequest){
        //log received credentials for debugging
        System.out.println("Received email: " + loginRequest.getCustomerEmail());
        System.out.println("Received password: " + loginRequest.getCustomerPassword());

        String result = customerService.customerLogin(loginRequest.getCustomerEmail(), loginRequest.getCustomerPassword());

        if(result.equals("Login successful.")){
            return ResponseEntity.ok(result);
        } else if(result.equals("Invalid password.")){
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        } else if(result.equals("Customer not found.")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }

    @PostMapping(path = "/customers/register")
    public ResponseEntity<String> customerRegistration(@RequestBody Customer customer){
        String result = customerService.customerRegistration(customer);

        if(result.equals("Customer registered successfully.")){
            return ResponseEntity.ok(result);
        } else if(result.equals("Email already in use.")){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
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
