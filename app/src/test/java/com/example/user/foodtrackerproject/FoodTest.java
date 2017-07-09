package com.example.user.foodtrackerproject;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 07/07/2017.
 */

public class FoodTest {

    Food food;

    @Before
    public void before(){
        food = new Food("spaghetti", 31.0, 2.0, 0.9);
    }

    @Test
    public void showMeal() throws Exception {
        assertEquals("spaghetti", food.getName());
    }

    @Test
    public void showCarbIntake() throws Exception {
        assertEquals(31.0, food.getCarbohydrate());
    }

    @Test
    public void showProteinIntake() throws Exception {
        assertEquals(2.0, food.getProtein());
    }

    @Test
    public void showFatIntake() throws Exception {
        assertEquals(0.9, food.getFat());
    }
}
