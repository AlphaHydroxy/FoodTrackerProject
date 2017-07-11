package com.example.user.foodtrackerproject;

import java.io.Serializable;

/**
 * Created by user on 07/07/2017.
 */

public class FoodTracker implements Serializable {

    EatFood eatFood;

    public EatFood getEatFood() {
        return eatFood;
    }

    public void setEatFood(EatFood eatFood) {
        this.eatFood = eatFood;
    }
}
