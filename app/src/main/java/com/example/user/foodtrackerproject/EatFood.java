package com.example.user.foodtrackerproject;

import java.io.Serializable;
import java.text.DateFormat;

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

    public String toString(){
      return "User: " + this.user.getName() + " | Weight: " + user.getWeight() + "kg" + "\nFood : " + food.getName() + "\nMeal Time: "  +  mealTime.getPrimary() + " "  + mealTime.getSecondary() + "\n" + "Date : " + mealTime.getDate();
    }
}
