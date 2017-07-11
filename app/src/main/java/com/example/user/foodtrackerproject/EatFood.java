package com.example.user.foodtrackerproject;

import java.io.Serializable;

import static android.R.attr.name;

/**
 * Created by user on 07/07/2017.
 */

public class EatFood implements Serializable{

    User user;
    MealTime mealTime;
    Food food;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MealTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(MealTime mealTime) {
        this.mealTime = mealTime;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
