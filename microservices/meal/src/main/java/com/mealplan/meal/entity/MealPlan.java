package com.mealplan.meal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "meal_plan")
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "duration_days")
    private int durationDays;

    @Column(name = "meals_per_day")
    private int mealsPerDay;

    @Column(name = "is_custom")
    private boolean isCustom;

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public int getMealsPerDay() {
        return mealsPerDay;
    }

    public void setMealsPerDay(int mealsPerDay) {
        this.mealsPerDay = mealsPerDay;
    }

    public boolean isCustom() {
        return isCustom;
    }

    public void setCustom(boolean custom) {
        isCustom = custom;
    }
}
