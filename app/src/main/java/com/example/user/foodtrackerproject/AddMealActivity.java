package com.example.user.foodtrackerproject;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddMealActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener{

    EditText foodNameEditor;
    ArrayList<MealTime> foodInputArray = new ArrayList<>();

    Button date_time;
    TextView show_date;

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
        show_date = (TextView) findViewById(R.id.show_date_time);
        date_time = (Button) findViewById(R.id.date_time_picker);

        radio_breakfast = (RadioButton)findViewById(R.id.radio_breakfast);
        radio_lunch = (RadioButton)findViewById(R.id.radio_lunch);
        radio_dinner = (RadioButton)findViewById(R.id.radio_dinner);
        radio_snack = (RadioButton)findViewById(R.id.radio_snack);
        radio_beverage = (RadioButton)findViewById(R.id.radio_beverage);

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

                EatFood eatFoodEvent = new EatFood();
                eatFoodEvent.setFood(new Food(selectedMealName, 0 ,0,0));
                foodInputArray.add(new MealTime(getSelectedMeal()));
                foodInputArray.add(new MealTime(onDateSet(datePicker, i, i1, i2)));
                eatFoodEvent.setMealTime(selectedMealTimes.get(0));
                eatFoodEvent.setUser(new User("Jia", "Female", 56));
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1 + 1;
        dayFinal = i2;
        show_date.setText(dayFinal + "/" + monthFinal + "/" + yearFinal);
        show_date.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    private ArrayList<MealTime> getSelectedMealTimes() {

        if (radio_breakfast.isChecked()) {
            foodInputArray.add(new MealTime("Breakfast"));
        }
        if (radio_lunch.isChecked()) {
            foodInputArray.add(new MealTime("Lunch"));
        }
        if (radio_dinner.isChecked()) {
            foodInputArray.add(new MealTime("Dinner"));
        }
        if (radio_snack.isChecked()) {
            foodInputArray.add(new MealTime("Snack"));
        }
        if (radio_beverage.isChecked()) {
            foodInputArray.add(new MealTime("Beverage"));
        }
        return foodInputArray;
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

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.add_meal) {
//            Intent intent = new Intent(this, AddMealActivity.class);
//            startActivity(intent);
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    private Date getSelectedDate() {
//        return new Date(this.datePicker.getDatePicker().getYear(),
//                this.datePicker.getDatePicker().getMonth(),
//                this.datePicker.getDatePicker().getDayOfMonth());
//    }

//    public boolean ifNoInput(EditText editText){
//        if(foodNameEditor == null){
//            editText.setError(editText.getHint()+"required field");
//            return false;
//        } else {
//            editText.setError(null);
//            return true;
//        }
//    }