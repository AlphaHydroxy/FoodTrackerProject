package com.example.user.foodtrackerproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<EatFood> allTheEatenFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences("ADDEDFOOD", Context.MODE_PRIVATE);
//        SharedPreferences.Editor delete = sharedPref.edit();
//        delete.clear();
//        delete.apply();

        String eatenFood = sharedPref.getString("AllTheEatenFood", new ArrayList<EatFood>().toString());
        Log.d("Food String", eatenFood);

        Gson gson = new Gson();
        TypeToken<ArrayList<EatFood>> foodArrayList = new TypeToken<ArrayList<EatFood>>(){};
        ArrayList<EatFood> allTheEatenFood = gson.fromJson(eatenFood, foodArrayList.getType());
        Log.d("myFood", allTheEatenFood.toString());
        if(getIntent().getExtras() != null) {
            EatFood newFood = (EatFood) getIntent().getSerializableExtra("food");

            allTheEatenFood.add(newFood);
            Log.d("myFood", allTheEatenFood.toString());
        }

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("AllTheEatenFood", gson.toJson(allTheEatenFood));
        editor.apply();

        MainActivityAdapter mainActivityAdapter = new MainActivityAdapter(this, allTheEatenFood);
        ListView listview = (ListView)findViewById(R.id.launcherlist);
        listview.setAdapter(mainActivityAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_meal) {
            Intent intent = new Intent(this, AddMealActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
