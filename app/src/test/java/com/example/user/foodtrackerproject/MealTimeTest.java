package com.example.user.foodtrackerproject;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 07/07/2017.
 */

public class MealTimeTest {

    MealTime mealTime;

    @Before
    public void before(){
        mealTime = new MealTime("lunch");
    }

    @Test
    public void typeOfMeal() throws Exception {
        assertEquals("lunch", mealTime.getName());
    }

//    @Test
//    public void name() throws Exception {
//        Date now = new Date();
//        assertEquals(Mon 01/01/2000 00:00, mealTime.showTime();
//    }
}
