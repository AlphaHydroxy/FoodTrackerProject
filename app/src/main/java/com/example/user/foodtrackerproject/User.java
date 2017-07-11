package com.example.user.foodtrackerproject;

import java.io.Serializable;

/**
 * Created by user on 07/07/2017.
 */

public class User implements Serializable{

    private String name;
    private String gender;
    private int weight;

    public User(String name, String gender, int weight){
        this.name = name;
        this.gender = gender;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
