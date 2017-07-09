package com.example.user.foodtrackerproject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 07/07/2017.
 */

public class MealTime {

    private String name;
    DateFormat dateFormat = new SimpleDateFormat("EE dd/MMM/yyyy HH:mm");
    Date now = new Date();

    public MealTime(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void showTime(){
        System.out.println(dateFormat.format(now));

    }
}
