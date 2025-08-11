package com.mealplan.delivery.driver.repository;

import com.mealplan.delivery.driver.entity.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver, Integer> {
}
