package com.example.user.foodtrackerproject;

import java.io.Serializable;

/**
 * Created by user on 07/07/2017.
 */

public class Food implements Serializable{

    private String name;
    private double carbohydrate;
    private double protein;
    private double fat;

    public Food(String name, double carbohydrate, double protein, double fat){
        this.name = name;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }
}
