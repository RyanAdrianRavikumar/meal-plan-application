package com.mealplan.meal.controller;

import com.mealplan.meal.entity.MealPlan;
import com.mealplan.meal.service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealPlanController {

    @Autowired
    MealPlanService mealPlanService;

    @GetMapping(path = "/mealPlans")
    public List<MealPlan> getAllMealPlans(){
        return mealPlanService.getAllMealPlans();
    }
}
