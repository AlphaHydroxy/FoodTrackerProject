package com.example.user.foodtrackerproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 11/07/2017.
 */

public class MainActivityAdapter extends ArrayAdapter<EatFood>{

    public MainActivityAdapter(Context context, ArrayList<EatFood> eatFoods){
        super(context, 0, eatFoods);
    }

    public View getView(int position, View listItemView, ViewGroup parent){
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
            EatFood addFood = getItem(position);

            TextView food = (TextView)listItemView.findViewById(R.id.new_food);


//            String foodString = "";
//            for(EatFood eatFood : )





            food.setText(addFood.getFood().getName().toString());
            listItemView.setTag(addFood.getFood());
            return listItemView;

        }
    }
