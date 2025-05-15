package com.mealplan.restaurant.controller;

import com.mealplan.restaurant.entity.Restaurant;
import com.mealplan.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping(path = "/restaurants")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping(path = "/restaurants/{id}")
    public Restaurant getRestaurantById(@PathVariable int id){
        return restaurantService.getRestaurantById(id);
    }

    @DeleteMapping(path = "restaurants/{id}")
    public String deleteRestaurantById(@PathVariable int id){
        return restaurantService.deleteRestaurantById(id);
    }

    @PutMapping(path = "/restaurants/{id}")
    public ResponseEntity<String> updateRestaurantById(@PathVariable int id, @RequestBody Restaurant updatedRestaurant){
        return restaurantService.updateRestaurantById(id, updatedRestaurant);
    }
}
