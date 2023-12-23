package com.example.sampleat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Feeding extends AppCompatActivity {

    private CheckBox milkCheckbox;
    private CheckBox softCheeseCheckbox;
    private CheckBox cerealsCheckbox;
    private CheckBox appleCheckbox;
    private CheckBox bananaCheckbox;
    private CheckBox mangoCheckbox;
    private CheckBox avocadoCheckbox;
    private CheckBox melonCheckbox;
    private CheckBox beansCheckbox;

    private TimePicker currentTime;
    private CheckBox potatoCheckbox;
    private CheckBox tomatoCheckbox;
    private CheckBox carrotCheckbox;
    private CheckBox cucumberCheckbox;
    private TextView pureedVegetablesEditText;

    private TableLayout feedingTable;
    private TextView totalCaloriesTextView;
    DatabaseHelper myDb;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding);

        // Initialize UI elements
        milkCheckbox = findViewById(R.id.milkCheckBox);
        softCheeseCheckbox = findViewById(R.id.softCheeseCheckBox);
        cerealsCheckbox = findViewById(R.id.cerealsCheckBox);
        appleCheckbox = findViewById(R.id.appleCheckBox);
        bananaCheckbox = findViewById(R.id.bananaCheckBox);
        mangoCheckbox = findViewById(R.id.mangoCheckBox);
        avocadoCheckbox = findViewById(R.id.avocadoCheckBox);
        melonCheckbox = findViewById(R.id.melonCheckBox);
        beansCheckbox = findViewById(R.id.beansCheckBox);
        potatoCheckbox = findViewById(R.id.potatoCheckBox);
        tomatoCheckbox = findViewById(R.id.tomatoCheckBox);
        carrotCheckbox = findViewById(R.id.carrotCheckBox);
        cucumberCheckbox = findViewById(R.id.cucumberCheckBox);
        pureedVegetablesEditText = findViewById(R.id.pureedVegetablesTextView);
        totalCaloriesTextView = findViewById(R.id.totalCaloriesTextView);
        feedingTable=findViewById(R.id.dataTable2);
        myDb=new DatabaseHelper(this);
        // Set up button click listener
        Button recordButton = findViewById(R.id.recordButton);
        Button dontknow = findViewById(R.id.button6);
        dontknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Feeding.this, nutrition.class);
                startActivity(intent);
            }
        });
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calculate total calories
                int totalCalories = 0;
                if (milkCheckbox.isChecked()) {
                    totalCalories += 42;
                }
                if (softCheeseCheckbox.isChecked()) {
                    totalCalories += 402;
                }
                if (cerealsCheckbox.isChecked()) {
                    totalCalories += 370;
                }
                if (appleCheckbox.isChecked()) {
                    totalCalories += 89;
                }
                if (bananaCheckbox.isChecked()) {
                    totalCalories += 89;
                }
                if (mangoCheckbox.isChecked()) {
                    totalCalories += 60;
                }
                if (avocadoCheckbox.isChecked()) {
                    totalCalories += 23;
                }
                if (melonCheckbox.isChecked()) {
                    totalCalories += 68;
                }


                if (beansCheckbox.isChecked()) {
                    totalCalories += 48;
                }
                if (potatoCheckbox.isChecked()) {
                    totalCalories += 88;
                }
                if (tomatoCheckbox.isChecked()) {
                    totalCalories += 38;
                }
                if (carrotCheckbox.isChecked()) {
                    totalCalories += 41;
                }
                if (cucumberCheckbox.isChecked()) {
                    totalCalories += 15;
                }

                // Display total calories
                totalCaloriesTextView.setText(String.format("Total calories: %d", totalCalories));

                TableRow newRow = new TableRow(getApplicationContext());

                currentTime = findViewById(R.id.timePicker);
                int hr = currentTime.getCurrentHour();
                int min = currentTime.getCurrentMinute();

                TextView time = new TextView(getApplicationContext());
                time.setText(String.valueOf(hr) + ":" + String.valueOf(min));
                time.setBackgroundResource(R.drawable.cell_border); // Set background drawable for cell borders
                time.setPadding(5, 5, 5, 5); // Set padding for cell content
                newRow.addView(time);

                TextView TCalorie = new TextView(getApplicationContext());
                TCalorie.setText(String.valueOf(totalCalories));
                TCalorie.setBackgroundResource(R.drawable.cell_border); // Set background drawable for cell borders
                TCalorie.setPadding(5, 5, 5, 5); // Set padding for cell content
                newRow.addView(TCalorie);
                String timeText = String.format("%02d:%02d", hr, min);
                String caloriesText = String.valueOf(totalCalories);
                feedingTable.addView(newRow, 1);
                AddFoodData(timeText,caloriesText);

            }


        });
    }




    public void  AddFoodData (String tt, String ct){

        boolean isInserted = myDb.insertFeedingData(tt,ct);
       if(isInserted==true)
           Toast.makeText(Feeding.this, "Data inserted", Toast.LENGTH_SHORT).show();
      else
          Toast.makeText(Feeding.this, "Data not inserted", Toast.LENGTH_SHORT).show();
    }


}






