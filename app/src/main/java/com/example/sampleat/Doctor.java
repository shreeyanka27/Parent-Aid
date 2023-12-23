package com.example.sampleat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Doctor extends AppCompatActivity {
Button bt1, bt2,bt3,bt4,bt5,bt6;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        CardView cardView1 = findViewById(R.id.cardView1);
        bt1= findViewById(R.id.bookAppointmentButton1);
        bt3= findViewById(R.id.bookAppointmentButton3);
        bt4= findViewById(R.id.bookAppointmentButton4);
        bt5= findViewById(R.id.bookAppointmentButton5);
        bt6= findViewById(R.id.bookAppointmentButton6);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Doctor.this, "Successful", Toast.LENGTH_SHORT).show();

            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Doctor.this, "Successful", Toast.LENGTH_SHORT).show();

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Doctor.this, "Successful", Toast.LENGTH_SHORT).show();

            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Doctor.this, "Successful", Toast.LENGTH_SHORT).show();

            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Doctor.this, "Successful", Toast.LENGTH_SHORT).show();

            }
        });
    }




}

