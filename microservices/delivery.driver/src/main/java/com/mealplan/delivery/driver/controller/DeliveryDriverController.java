package com.mealplan.delivery.driver.controller;

import com.mealplan.delivery.driver.entity.DeliveryDriver;
import com.mealplan.delivery.driver.service.DeliveryDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveryDriverController {

    @Autowired
    DeliveryDriverService deliveryDriverService;

    @GetMapping(path = "/drivers/all")
    public List<DeliveryDriver> getAllDeliveryDrivers(){
        return deliveryDriverService.getAllDeliveryDrivers();
    }
}
