package com.mealplan.subscription.service;

import com.mealplan.subscription.entity.Subscription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SubscriptionService {
    public List<Subscription> getAllSubscriptions();
    public Subscription getSubscriptionById(int id);
    public String deleteSubscriptionById(int id);
    public String updateSubscriptionById(int id, Subscription updatedSubscription);
    public Subscription createSubscription(Subscription subscription);
}
