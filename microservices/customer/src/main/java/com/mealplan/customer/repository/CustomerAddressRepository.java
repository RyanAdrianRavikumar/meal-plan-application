package com.mealplan.customer.repository;

import com.mealplan.customer.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {
    Optional<CustomerAddress> findByCustomer_CustomerId(int customerId);

}
