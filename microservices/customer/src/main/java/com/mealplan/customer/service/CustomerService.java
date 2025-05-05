package com.mealplan.customer.service;

import com.mealplan.customer.entity.Customer;
import com.mealplan.customer.entity.CustomerAddress;
import com.mealplan.customer.repository.CustomerAddressRepository;
import com.mealplan.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerAddressRepository customerAddressRepository;

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
            return "Email already in use.";
        }

        customerRepository.save(customer);
        return "Customer registered successfully.";
    }

    //saves customer's address
    public String setCustomerAddressing(CustomerAddress customerAddress){
        Optional<Customer> customer = customerRepository.findById(customerAddress.getCustomer().getCustomerId());

        if(customer.isPresent()){
            customerAddress.setCustomer(customer.get());
            customerAddressRepository.save(customerAddress);
            return "Customer address details saved.";
        } else {
            return "Customer not found.";
        }
    }

    public String updateAddressByCustomerId(int customerId, CustomerAddress newAddressData){
        Optional<CustomerAddress> existingAddress = customerAddressRepository.findByCustomer_CustomerId(customerId);
        Optional<Customer> customer = customerRepository.findById(customerId);

        if(existingAddress.isPresent() && customer.isPresent()){
            CustomerAddress customerAddress = existingAddress.get();
            customerAddress.setAddressLine(newAddressData.getAddressLine());
            customerAddress.setCity(newAddressData.getCity());
            customerAddress.setState(newAddressData.getState());
            customerAddress.setPostalCode(newAddressData.getPostalCode());
            customerAddress.setCountry(newAddressData.getCountry());
            customerAddress.setPrimary(newAddressData.isPrimary());

            customerAddressRepository.save(customerAddress);
            return "Customer address details updated.";
        } else {
            return "Customer or address not found";
        }
    }
}
