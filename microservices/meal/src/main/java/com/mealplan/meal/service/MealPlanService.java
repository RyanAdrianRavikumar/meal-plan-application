package com.mealplan.meal.service;

import com.mealplan.meal.entity.MealPlan;
import com.mealplan.meal.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealPlanService {

    @Autowired
    MealPlanRepository mealPlanRepository;

    public List<MealPlan> getAllMealPlans(){
        return mealPlanRepository.findAll();
    }
}
