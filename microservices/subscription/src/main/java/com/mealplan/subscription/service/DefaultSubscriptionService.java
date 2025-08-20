package com.mealplan.subscription.service;

import com.mealplan.subscription.entity.Subscription;
import com.mealplan.subscription.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultSubscriptionService implements SubscriptionService{

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public DefaultSubscriptionService(SubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<Subscription> getAllSubscriptions(){
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription getSubscriptionById(int id){
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(id);
        if(optionalSubscription.isPresent()){
            return optionalSubscription.get();
        }
        return null;
    }

    @Override
    public String deleteSubscriptionById(int id){
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(id);
        if(optionalSubscription.isPresent()){
            subscriptionRepository.deleteById(id);
            return "Subscription successfully deleted.";
        }
        return "Failed to delete subscription.";
    }

    @Override
    public String updateSubscriptionById(int id, Subscription updatedSubscription){
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(id);
        if(optionalSubscription.isPresent()){
            Subscription existingSubscription = optionalSubscription.get();

            existingSubscription.setCustomerId(updatedSubscription.getCustomerId());
            existingSubscription.setPlanId(updatedSubscription.getPlanId());
            existingSubscription.setStartDate(updatedSubscription.getStartDate());
            existingSubscription.setEndDate(updatedSubscription.getEndDate());
            existingSubscription.setStatus(updatedSubscription.getStatus());

            subscriptionRepository.save(existingSubscription);
            return "Subscription successfully updated.";
        }
        return "Failed to update subscription.";
    }

    @Override
    public Subscription createSubscription(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }
}
