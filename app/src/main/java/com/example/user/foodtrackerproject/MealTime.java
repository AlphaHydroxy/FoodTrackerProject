package com.example.user.foodtrackerproject;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.R.attr.name;

/**
 * Created by user on 07/07/2017.
 */

public class MealTime implements Serializable {

    private String primary;
    private String secondary;
    private Date date;

    public MealTime(String primary, String secondary, Date mealDate){
        this.primary = primary;
        this.secondary = secondary;
        this.date = mealDate;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }
    public String getDate() {
        String weekDay;
        SimpleDateFormat dayFormat = new SimpleDateFormat("EE dd-MM-YY", Locale.UK);
        Calendar calendar = Calendar.getInstance();
        weekDay = dayFormat.format(calendar.getTime());
        return weekDay;
    }

    public void setDate(Date mealDate) {
        this.date = mealDate;
    }
}