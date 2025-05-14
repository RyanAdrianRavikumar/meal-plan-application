package com.mealplan.restaurant.controller;

import com.mealplan.restaurant.entity.Restaurant;
import com.mealplan.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Restaurant getRestaurantById(int id){
        return restaurantService.getRestaurantById(id);
    }

    @DeleteMapping(path = "restaurants/{id}")
    public String deleteRestaurantById(int id){
        return restaurantService.deleteRestaurantById(id);
    }
}
