package com.mealplan.restaurant.service;

import com.mealplan.restaurant.entity.Restaurant;
import com.mealplan.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultRestaurantService implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public DefaultRestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(int id){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()){
            return restaurant.get();
        }
        return null;
    }

    @Override
    public String deleteRestaurantById(int id){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()){
            restaurantRepository.deleteById(id);
            return "Restaurant Successfully Deleted!";
        }
        return "Failed To Delete Restaurant.";
    }

    @Override
    public ResponseEntity<String> updateRestaurantById(int id, Restaurant updatedRestaurant){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);

        if(restaurant.isPresent()){
            Restaurant existingRestaurant = restaurant.get();
            existingRestaurant.setName(updatedRestaurant.getName());
            existingRestaurant.setOwnerName(updatedRestaurant.getOwnerName());
            existingRestaurant.setPhone(updatedRestaurant.getPhone());
            existingRestaurant.setEmail(updatedRestaurant.getEmail());
            existingRestaurant.setPassword(updatedRestaurant.getPassword());

            try {
                String base64Image = updatedRestaurant.getImage();
                byte[] imageBytes = Base64.getDecoder().decode(base64Image);
                Blob imageBlob = new SerialBlob(imageBytes);
                existingRestaurant.setImage(imageBlob);
            } catch (SQLException ex){
                ex.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed To Update Image.");
            }
            restaurantRepository.save(existingRestaurant);
            return ResponseEntity.ok("Restaurant Updated Successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant Not Found!");
    }
}
