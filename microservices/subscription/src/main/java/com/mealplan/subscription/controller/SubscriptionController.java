package com.mealplan.subscription.controller;

import com.mealplan.subscription.entity.Subscription;
import com.mealplan.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping(path = "/subscriptions")
    public List<Subscription> getAllSubscriptions(){
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping(path = "/subscriptions/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable int id){
        Subscription subscription = subscriptionService.getSubscriptionById(id);
        if(subscription != null){
            return ResponseEntity.ok(subscription);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/subscriptions/{id}")
    public String deleteSubscriptionById(@PathVariable int id){
        return subscriptionService.deleteSubscriptionById(id);
    }

    @PutMapping(path = "/subscriptions/{id}")
    public String updateSubscriptionById(@PathVariable int id, @RequestBody Subscription updatedSubscription){
        return subscriptionService.updateSubscriptionById(id, updatedSubscription);
    }

    @PostMapping(path = "/subscriptions")
    public Subscription createSubscription(Subscription subscription){
        return subscriptionService.createSubscription(subscription);
    }
}
