package com.example.user.foodtrackerproject;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 07/07/2017.
 */

public class UserTest {

    User user;

    @Before
    public void before() {
        user = new User("Jia", "female", 56);
    }

    @Test
    public void getUsersName(){
        assertEquals("Jia", user.getName());
    }

    @Test
    public void getUsersGender(){
        assertEquals("female", user.getGender());
    }

    @Test
    public void getUsersWeight(){
        assertEquals(56, user.getWeight());
    }

}
