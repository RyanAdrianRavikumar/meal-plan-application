package com.mealplan.restaurant.service;

import com.mealplan.restaurant.entity.Restaurant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantService {
    public List<Restaurant> getAllRestaurants();
    public Restaurant getRestaurantById(int id);
    public String deleteRestaurantById(int id);
    public ResponseEntity<String> updateRestaurantById(int id, Restaurant updatedRestaurant);

}
