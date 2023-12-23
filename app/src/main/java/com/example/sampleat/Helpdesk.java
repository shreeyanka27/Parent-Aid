package com.example.sampleat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Helpdesk extends AppCompatActivity {


    private Spinner spinner;
    private EditText editText1;
    private Button submitBtn,contact1;

    private String[] spinnerOptions = {
            "Baby's Diet Chart",
            "Baby's Nutrition",
            "Breastfeeding and Pumping",
            "Irregular Bowels",
            "Body Rashes" ,
            "Relaxing music",
            "Choose best clothes"
    };

    private String[] urls = {
            "https://www.mfine.co/indian-baby-food-chart/",
            "https://www.cdc.gov/nutrition/infantandtoddlernutrition/index.html",
            "https://www.who.int/health-topics/breastfeeding#tab=tab_1",
            "https://medlineplus.gov/ency/article/003125.htm",
            "https://www.healthline.com/health/how-to-spot-and-take-care-of-your-babys-rash",
            "https://www.youtube.com/watch?v=HbwFeL2eBMg",
            "https://sewguide.com/fabric-for-baby-clothes-childrens-clothes/"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpdesk);

        spinner = findViewById(R.id.dropdown);
        editText1 = findViewById(R.id.editText);
        submitBtn = findViewById(R.id.submitBtn);
        contact1 = findViewById(R.id.contact);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Helpdesk.this, contact.class);
                startActivity(intent);
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // Handle spinner item selection
                String selectedItem = spinnerOptions[position];
                if (selectedItem.equals("Baby's Diet Chart")) {
                    openWebPage(urls[0]);
                } else if (selectedItem.equals("Baby's Nutrition")) {
                    openWebPage(urls[1]);
                } else if (selectedItem.equals("Breastfeeding and Pumping")) {
                    openWebPage(urls[2]);
                } else if (selectedItem.equals("Irregular Bowels")) {
                    openWebPage(urls[3]);
                } else if (selectedItem.equals("Body Rashes")) {
                    openWebPage(urls[4]);
                }
                else if (selectedItem.equals("Relaxing music")) {
                    openWebPage(urls[5]);
                }
                else if (selectedItem.equals("Choose best clothes")) {
                    openWebPage(urls[6]);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = editText1.getText().toString().trim();
                if (!query.isEmpty()) {
                    // Process user query
                    Toast.makeText(Helpdesk.this, "Your query be addressed soon", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(Helpdesk.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}