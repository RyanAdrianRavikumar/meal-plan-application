package com.mealplan.delivery.driver.controller;

import com.mealplan.delivery.driver.entity.DeliveryDriver;
import com.mealplan.delivery.driver.service.DeliveryDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryDriverController {

    @Autowired
    DeliveryDriverService deliveryDriverService;

    @GetMapping(path = "/drivers/all")
    public List<DeliveryDriver> getAllDeliveryDrivers(){
        return deliveryDriverService.getAllDeliveryDrivers();
    }

    @PostMapping(path = "/drivers")
    public String registerDriver(@RequestBody DeliveryDriver deliveryDriver){
        return deliveryDriverService.registerDriver(deliveryDriver);
    }

    @GetMapping(path = "/drivers/{id}")
    public DeliveryDriver getDeliveryDriverById(@PathVariable int id){
        return deliveryDriverService.getDeliveryDriverById(id);
    }

    @DeleteMapping(path = "/drivers/{id}")
    public String deleteDriverById(@PathVariable int id){
        return deliveryDriverService.deleteDriverById(id);
    }

    @PutMapping(path = "/drivers/{id}")
    public String updateDeliveryDriver(@PathVariable int id, @RequestBody DeliveryDriver updatedDeliveryDriver){
        return deliveryDriverService.updateDeliveryDriver(id, updatedDeliveryDriver);
    }
}
