package com.example.sampleat;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class Bfeeding extends AppCompatActivity {
    private TextView tvTime;
    private TableLayout feedingTable;
    private TimePicker currentTime;
    private Button recordButton,dontknow;
    DatabaseHelper myDb;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bfeeding);
        feedingTable=findViewById(R.id.dataTable2);
        recordButton = findViewById(R.id.recordButton);
        dontknow = findViewById(R.id.button6);
        myDb=new DatabaseHelper(this);
        dontknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://walnuthillobgyn.com/blog/everything-you-need-to-know-about-breastfeeding/#:~:text=After%20delivery%2C%20you%20should%20breastfeed,baby%20gets%20enough%20to%20eat."); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableRow newRow = new TableRow(getApplicationContext());

                // Get current date
                SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
                String currentDate = sdf1.format(new Date());

                // Create and add date TextView to the new row
                TextView date = new TextView(getApplicationContext());
                date.setText(currentDate);
                date.setBackgroundResource(R.drawable.cell_border); // Set background drawable for cell borders
                date.setPadding(5, 5, 5, 5); // Set padding for cell content
                newRow.addView(date);

                // Get current time
                currentTime = findViewById(R.id.timePicker);
                int hr = currentTime.getCurrentHour();
                int min = currentTime.getCurrentMinute();

                // Create and add time TextView to the new row
                TextView time = new TextView(getApplicationContext());
                time.setText(String.valueOf(hr) + ":" + String.valueOf(min));
                time.setBackgroundResource(R.drawable.cell_border); // Set background drawable for cell borders
                time.setPadding(5, 5, 5, 5); // Set padding for cell content
                newRow.addView(time);
                String ct = String.format("%02d:%02d", hr, min);
                String tt=date.getText().toString();
                AddBreastFeedingData(tt,ct);
                feedingTable.addView(newRow, 1);
            }
        });



//
//}
    }


    public void  AddBreastFeedingData (String tt, String ct){

        boolean isInserted = myDb.insertBFeedingData(tt,ct);
        if(isInserted==true)
            Toast.makeText(Bfeeding.this, "Data inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Bfeeding.this, "Data not inserted", Toast.LENGTH_SHORT).show();
    }


}