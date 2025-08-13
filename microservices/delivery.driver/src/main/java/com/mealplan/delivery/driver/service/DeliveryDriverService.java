package com.mealplan.delivery.driver.service;

import com.mealplan.delivery.driver.entity.DeliveryDriver;
import com.mealplan.delivery.driver.repository.DeliveryDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryDriverService {

    @Autowired
    DeliveryDriverRepository deliveryDriverRepository;

    public List<DeliveryDriver> getAllDeliveryDrivers(){
        return deliveryDriverRepository.findAll();
    }

    public String registerDriver(DeliveryDriver deliveryDriver){
        if(deliveryDriver.getEmail() != null){
            return "Email address already in use.";
        }

        deliveryDriverRepository.save(deliveryDriver);
        return "Delivery driver successfully registered!";
    }

    public DeliveryDriver getDeliveryDriverById(int id){
        Optional<DeliveryDriver> deliveryDriverOptional = deliveryDriverRepository.findById(id);
        if(deliveryDriverOptional.isPresent()){
            DeliveryDriver deliveryDriver = deliveryDriverOptional.get();
            return deliveryDriver;
        } else {
            return null;
        }
    }

    public String deleteDriverById(int id){
        Optional<DeliveryDriver> deliveryDriverOptional = deliveryDriverRepository.findById(id);
        if(deliveryDriverOptional.isPresent()){
            deliveryDriverRepository.deleteById(id);
            return "Delivery driver successfully deleted!";
        }
        return "Failed to delivery driver.";
    }

    public String updateDeliveryDriver(int id, DeliveryDriver updatedDeliveryDriver){
        Optional<DeliveryDriver> existingDeliveryDriver = deliveryDriverRepository.findById(id);

        if(existingDeliveryDriver.isPresent()){
            DeliveryDriver existingDriver = existingDeliveryDriver.get();

            existingDriver.setName(updatedDeliveryDriver.getName());
            existingDriver.setEmail(updatedDeliveryDriver.getEmail());
            existingDriver.setPhone(updatedDeliveryDriver.getPhone());
            existingDriver.setVehicleType(updatedDeliveryDriver.getVehicleType());
            existingDriver.setAvailability(updatedDeliveryDriver.getAvailability());

            deliveryDriverRepository.save(existingDriver);
            return "Delivery driver successfully updated!";
        } else{
            return "Delivery driver not found.";
        }
    }
}
