package com.mealplan.meal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "meal_plan_meals")
@IdClass(MealPlanMealId.class)
public class MealPlanMeals {

    @Id
    private int planId;

    @Id
    private int mealId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planId", insertable = false, updatable = false)
    private MealPlan mealPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mealId", insertable = false, updatable = false)
    private Meal meal;

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
