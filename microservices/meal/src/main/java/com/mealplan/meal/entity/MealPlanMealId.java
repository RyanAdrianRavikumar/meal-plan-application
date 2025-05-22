package com.mealplan.meal.entity;

import java.io.Serializable;
import java.util.Objects;

public class MealPlanMealId implements Serializable {

    private int planId;
    private int mealId;

    public MealPlanMealId() {}

    public MealPlanMealId(int planId, int mealId) {
        this.planId = planId;
        this.mealId = mealId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MealPlanMealId)) return false;
        MealPlanMealId that = (MealPlanMealId) o;
        return planId == that.planId && mealId == that.mealId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, mealId);
    }
}
