package com.example.user.foodtrackerproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddMealActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener{

    EditText foodNameEditor;
    ArrayList<String> inputArray = new ArrayList<String>();

    Button date_time;
    TextView show_date_time;

    RadioButton radio_breakfast, radio_lunch, radio_dinner, radio_snack, radio_beverage;
    DatePickerDialog datePicker;
    int day, month, year;
    int dayFinal, monthFinal, yearFinal;

    ArrayAdapter adapter;

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
        save = (Button) findViewById(R.id.save_btn);

        foodNameEditor = (EditText) findViewById(R.id.foodinput);
        show_date_time = (TextView) findViewById(R.id.show_date_time);
        date_time = (Button) findViewById(R.id.date_time_picker);

        radio_breakfast = (RadioButton)findViewById(R.id.radio_breakfast);
        radio_lunch = (RadioButton)findViewById(R.id.radio_lunch);
        radio_dinner = (RadioButton)findViewById(R.id.radio_dinner);
        radio_snack = (RadioButton)findViewById(R.id.radio_snack);
        radio_beverage = (RadioButton)findViewById(R.id.radio_snack);

        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);

        datePicker = new DatePickerDialog(AddMealActivity.this, AddMealActivity.this, year, month, day);

        date_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                year = cal.get(Calendar.YEAR);
                month = cal.get(Calendar.MONTH);
                day = cal.get(Calendar.DAY_OF_MONTH);
                AddMealActivity.this.datePicker.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedMealName = AddMealActivity.this.getSelectedMeal();

                ArrayList<MealTime> selectedMealTimes = AddMealActivity.this.getSelectedMealTimes();

                Date date = AddMealActivity.this.getSelectedDate();
                EatFood eatFoodEvent = new EatFood();
                eatFoodEvent.setFood(new Food(selectedMealName, 0 ,0,0));
                eatFoodEvent.setMealTime(selectedMealTimes.get(0));
                eatFoodEvent.setUser(new User("Jia", "Female", 56));
            }
        });
    }

    public boolean ifNoInput(EditText editText){
        if(foodNameEditor == null){
            editText.setError(editText.getHint()+"required field");
            return false;
        } else {
            editText.setError(null);
            return true;
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1 + 1;
        dayFinal = i2;

        Calendar cal = Calendar.getInstance();
        show_date_time.setText(dayFinal + "/" + monthFinal + "/" + yearFinal);
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
        return super.onOptionsItemSelected(item);
    }

    private Date getSelectedDate() {
        return new Date(this.datePicker.getDatePicker().getYear(),
                this.datePicker.getDatePicker().getMonth(),
                this.datePicker.getDatePicker().getDayOfMonth());
    }

    private ArrayList<MealTime> getSelectedMealTimes() {
        ArrayList<MealTime> selectedMealTimes = new ArrayList<MealTime>();

        if (radio_breakfast.isChecked()) {
            selectedMealTimes.add(new MealTime("Breakfast"));
        }
        if (radio_lunch.isChecked()) {
            selectedMealTimes.add(new MealTime("Lunch"));
        }
        if (radio_dinner.isChecked()) {
            selectedMealTimes.add(new MealTime("Dinner"));
        }
        if (radio_snack.isChecked()) {
            selectedMealTimes.add(new MealTime("Snack"));
        }
        if (radio_beverage.isChecked()) {
            selectedMealTimes.add(new MealTime("Beverage"));
        }
        return selectedMealTimes;
    }

    private String getSelectedMeal() {
        return this.foodNameEditor.getText().toString();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
