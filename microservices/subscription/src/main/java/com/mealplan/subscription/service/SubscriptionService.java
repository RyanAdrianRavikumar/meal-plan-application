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

    public String deleteSubscriptionById(int id){
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(id);

        if(optionalSubscription.isPresent()){
            subscriptionRepository.deleteById(id);
            return "Subscription successfully deleted.";
        }
        return "Failed to delete subscription.";
    }

    public String updateSubscriptionById(int id, Subscription updatedSubscription){
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(id);

        if(optionalSubscription.isPresent()){
            Subscription existiingSubscription = optionalSubscription.get();
            existiingSubscription.setCustomerId(updatedSubscription.getCustomerId());
            existiingSubscription.setPlanId(updatedSubscription.getPlanId());
            existiingSubscription.setStartDate(updatedSubscription.getStartDate());
            existiingSubscription.setEndDate(updatedSubscription.getEndDate());
            existiingSubscription.setStatus(updatedSubscription.getStatus());

            subscriptionRepository.save(existiingSubscription);
            return "Subscription updated successfully.";
        }
        return "Could not find subscription.";
    }

    public Subscription createSubscription(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }
}
