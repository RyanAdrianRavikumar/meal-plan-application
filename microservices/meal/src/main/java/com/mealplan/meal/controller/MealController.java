package com.mealplan.meal.controller;

import com.mealplan.meal.entity.Meal;
import com.mealplan.meal.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealController {

    @Autowired
    MealService mealService;

    public List<Meal> getAllMeals(){
        return mealService.getAllMeals();
    }
}
