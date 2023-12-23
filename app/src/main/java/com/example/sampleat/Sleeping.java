package com.example.sampleat;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Sleeping extends AppCompatActivity {
    private TextView timerTextView;
    private TextView historyTextView;
    private Button startButton;
    private Button endButton;
    private Button historyButton;
    private Handler handler = new Handler();
    private long startTime;
    private long elapsedTime;
    private static final int MAX_NAPS = 10;
    private ArrayList<Long> naps = new ArrayList<>();
    private TableLayout historyTable;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleeping);
        timerTextView = findViewById(R.id.timerTextView);
        historyTextView = findViewById(R.id.historyTextView);
        startButton = findViewById(R.id.startButton);
        endButton = findViewById(R.id.endButton);
        historyTable = findViewById(R.id.historyTableLayout);
        historyTable.setHorizontalScrollBarEnabled(true);
        historyTable.setScrollbarFadingEnabled(false);
        myDb=new DatabaseHelper(this);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                handler.postDelayed(updateTimerRunnable, 0);
                startButton.setEnabled(false);
            }
        });
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(updateTimerRunnable);
                elapsedTime = SystemClock.uptimeMillis() - startTime;
                timerTextView.setText("Total time: " + getTimeString(elapsedTime));
                naps.add(elapsedTime);
                startButton.setEnabled(true);
                updateHistoryTable();
            }
        });

    }

    private Runnable updateTimerRunnable = new Runnable() {
        @Override
        public void run() {
            elapsedTime = SystemClock.uptimeMillis() - startTime;
            timerTextView.setText(getTimeString(elapsedTime));
            handler.postDelayed(this, 1000);
        }
    };

    private String getTimeString(long millis) {
        int seconds = (int) (millis / 1000) % 60;
        int minutes = (int) ((millis / (1000 * 60)) % 60);
        int hours = (int) ((millis / (1000 * 60 * 60)) % 24);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    @SuppressLint({"ResourceType", "UseCompatLoadingForDrawables"})
    private void updateHistoryTable() {
        historyTable.removeViews(1,historyTable.getChildCount() - 1);

        // Add header row
        //TableRow headerRow = new TableRow(this);
        //TextView dateHeader = new TextView(this);
        //dateHeader.setText("Current Date");
        //dateHeader.setGravity(Gravity.CENTER);
//        headerRow.addView(dateHeader);
//        TextView startTimeHeader = new TextView(this);
//        startTimeHeader.setText("Start Time");
//        startTimeHeader.setGravity(Gravity.CENTER);
//        headerRow.addView(startTimeHeader);
//        TextView stopTimeHeader = new TextView(this);
//        stopTimeHeader.setText("Stop Time");
//        stopTimeHeader.setGravity(Gravity.CENTER);
//        headerRow.addView(stopTimeHeader);
//        TextView elapsedTimeHeader = new TextView(this);
//        elapsedTimeHeader.setText("Elapsed Time");
//        elapsedTimeHeader.setGravity(Gravity.CENTER);
//        headerRow.addView(elapsedTimeHeader);
//        historyTable.addView(headerRow);

        // Add nap entries
        for (int i = naps.size() - 1; i >= 0 && i >= naps.size() - MAX_NAPS; i--) {
            long napTime = naps.get(i);
            Date endDate = new Date(System.currentTimeMillis() - napTime);
            Date startDate = new Date(endDate.getTime() - napTime);
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", Locale.getDefault());
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
            String formattedEndDate = sdf.format(endDate);
            String formattedDate = sdf1.format(endDate);
            String formattedStartDate = sdf.format(startDate);
            String formattedNapTime = getTimeString(napTime);

            TableRow row = new TableRow(this);
            row.setPadding(10,0,0,0);
            TextView dateView = new TextView(this);
            dateView.setBackground(getResources().getDrawable(R.drawable.cell_border));
            dateView.setText(formattedDate);
            dateView.setPadding(10, 10, 10, 10);
            row.addView(dateView);

            TextView startTimeView = new TextView(this);
            startTimeView.setText(formattedStartDate);
            startTimeView.setBackground(getResources().getDrawable(R.drawable.cell_border));
            startTimeView.setPadding(10, 10, 10, 10);
            row.addView(startTimeView);

            TextView stopTimeView = new TextView(this);
            stopTimeView.setText(formattedEndDate);
            stopTimeView.setBackground(getResources().getDrawable(R.drawable.cell_border));
            stopTimeView.setPadding(10, 10, 10, 10);
            row.addView(stopTimeView);

            TextView napTimeView = new TextView(this);
            napTimeView.setText(formattedNapTime);
            napTimeView.setBackground(getResources().getDrawable(R.drawable.cell_border));
            napTimeView.setGravity(Gravity.CENTER);
            napTimeView.setPadding(10, 10, 10, 10);
            row.addView(napTimeView);

            historyTable.addView(row); // Add row at index 1 to put it above header row
            String stime=startTimeView.getText().toString();
            String stotime=stopTimeView.getText().toString();
            String ntime=napTimeView.getText().toString();
            AddSleepingData(formattedStartDate,stime,stotime,ntime);
        }
    }



    public void  AddSleepingData ( String date,String stime,String stotime,String elaptime){

        boolean isInserted = myDb.insertSleepingData(date,stime,stotime,elaptime);
        if(isInserted==true)
            Toast.makeText(Sleeping.this, "Data inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Sleeping.this, "Data not inserted", Toast.LENGTH_SHORT).show();
    }
}
