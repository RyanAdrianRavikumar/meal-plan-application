package com.mealplan.subscription.controller;

import com.mealplan.subscription.entity.Subscription;
import com.mealplan.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public Subscription getSubscriptionById(@PathVariable int id){
        return subscriptionService.getSubscriptionById(id);
    }
}
