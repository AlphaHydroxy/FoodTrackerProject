package com.example.user.foodtrackerproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText addedFood;
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addedFood = (EditText)findViewById(R.id.foodinput);
        show = (ListView)findViewById(R.id.launcherlist);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

//    public void getFood(View listItem) {
//        Movie movie = (Movie) listItem.getTag();
//        Log.d("Movie Title: ", movie.getFood());
//        Intent intent = new Intent(this, FavourtiesActivity.class);
//        intent.putExtra("movie", movie);
//        startActivity(intent);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_meal) {
            Intent intent = new Intent(this, AddMealActivity.class);
            startActivity(intent);

//            show.setAdapter(adapter);
        }
//        if (item.getItemId() == R.id.click_me) {
//            Toast.makeText(this, R.string.toast_is_toast, Toast.LENGTH_LONG).show();
//            return true;
//        }
//        if (item.getItemId() == R.id.action_login){
//            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
//        }
        return super.onOptionsItemSelected(item);
    }

}
