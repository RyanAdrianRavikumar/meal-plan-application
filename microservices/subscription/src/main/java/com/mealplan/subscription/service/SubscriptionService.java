package com.mealplan.subscription.service;

import com.mealplan.subscription.entity.Subscription;
import com.mealplan.subscription.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public List<Subscription> getAllSubscriptions(){
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(int id){
        Optional<Subscription> subscriptionOptional = subscriptionRepository.findById(id);

        if(subscriptionOptional.isPresent()){
            return subscriptionOptional.get();
        }
        return null;
    }
}
