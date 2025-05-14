package com.mealplan.restaurant.service;

import com.mealplan.restaurant.entity.Restaurant;
import com.mealplan.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(int id){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()){
            return restaurant.get();
        }
        return null;
    }

    public String deleteRestaurantById(int id){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()){
            restaurantRepository.deleteById(id);
            return "Restaurant Successfully Deleted!";
        }
        return "Failed To Delete Restaurant.";
    }
}
