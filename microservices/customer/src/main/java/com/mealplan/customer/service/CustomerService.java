package com.mealplan.customer.service;

import com.mealplan.customer.entity.Customer;
import com.mealplan.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomerById(int id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }
        return null;
    }

    public String updateCustomerById(int id, Customer updatedCustomer){
        Optional<Customer> validCustomer = customerRepository.findById(id);
        if(validCustomer.isPresent()){
            Customer customer = validCustomer.get();
            customer.setCustomerName(updatedCustomer.getCustomerName());
            customer.setCustomerEmail(updatedCustomer.getCustomerEmail());
            customer.setCustomerPhone(updatedCustomer.getCustomerPhone());
            customer.setCustomerPassword(updatedCustomer.getCustomerPassword());

            customerRepository.save(customer);
            return "Customer updated successfully.";
        } else {
            return "Customer not found.";
        }
    }

    public String deleteCustomerById(int id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            customerRepository.deleteById(id);
            return "Customer deleted successfully.";
        }
        return "Customer not found.";
    }

    public String customerLogin(String email, String password){
        Customer validCustomer = customerRepository.findCustomerByCustomerEmail(email);
        System.out.println("Checking login for email: " + email);
        System.out.println("Found customer: " + validCustomer);
        if(validCustomer != null){
            if(password.equals(validCustomer.getCustomerPassword())){
                return "Login successful.";
            } else {
                return "Invalid password.";
            }
        }

        return "Customer not found.";
    }

    public String customerRegistration(Customer customer){
        if(customerRepository.findCustomerByCustomerEmail(customer.getCustomerEmail()) != null){
            return "Email already in use";
        }

        customerRepository.save(customer);
        return "Customer registered successfully.";
    }
}
