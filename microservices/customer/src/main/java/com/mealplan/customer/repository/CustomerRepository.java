package com.mealplan.customer.repository;

import com.mealplan.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerByCustomerEmail(String customerEmail);

    @Query("SELECT c.customerEmail FROM Customer c WHERE c.customerId = :customerId")
    String findEmailById(@Param("customerId") int customerId);
}
