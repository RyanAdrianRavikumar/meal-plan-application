package com.mealplan.delivery.driver.service;

import com.mealplan.delivery.driver.entity.DeliveryDriver;
import com.mealplan.delivery.driver.repository.DeliveryDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryDriverService {

    @Autowired
    DeliveryDriverRepository deliveryDriverRepository;

    public List<DeliveryDriver> getAllDeliveryDrivers(){
        return deliveryDriverRepository.findAll();
    }
}
