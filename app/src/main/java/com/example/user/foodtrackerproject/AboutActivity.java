package com.example.user.foodtrackerproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.user.foodtrackerproject.R.id.about;

public class AboutActivity extends AppCompatActivity {

    TextView flowers_i;
    TextView flowers_ii;
    TextView aboutTitle;
    TextView aboutName;
    TextView aboutCohort;
    TextView cohortNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        flowers_i = (TextView)findViewById(R.id.flowers_1);
        flowers_ii = (TextView)findViewById(R.id.flowers_2);
        aboutTitle = (TextView)findViewById(R.id.created_by);
        aboutName = (TextView)findViewById(R.id.about_name);
        aboutCohort = (TextView)findViewById(R.id.about_cohort);
        cohortNum = (TextView)findViewById(R.id.cohort_num);
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
