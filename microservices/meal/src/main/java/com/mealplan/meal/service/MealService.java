package com.mealplan.meal.service;

import com.mealplan.meal.entity.Meal;
import com.mealplan.meal.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;

    public List<Meal> getAllMeals(){
        return mealRepository.findAll();
    }
}
