package com.example.sampleat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard extends AppCompatActivity {
 FirebaseUser user;
 FirebaseAuth auth;
 TextView display1;
 Button log, know;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ImageView image1= findViewById(R.id.diapers);
        ImageView image2= findViewById(R.id.feeding);
        ImageView image3= findViewById(R.id.bfeeding);
        ImageView image4= findViewById(R.id.sleep);
        ImageView image5= findViewById(R.id.doctor);
        ImageView image6= findViewById(R.id.shopping);

        display1= findViewById(R.id.textView29);
        log= findViewById(R.id.logout);
        auth= FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        know= findViewById(R.id.button11);
        if (user==null){
            Intent intent= new Intent(getApplicationContext() ,MainActivity.class);
            startActivity(intent);
            finish();
        }

        else{
           display1.setText(user.getEmail());
        }

        know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Dashboard.this ,Helpdesk.class);
                startActivity(intent);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Diaper.class);
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Feeding.class);
                startActivity(intent);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Bfeeding.class);
                startActivity(intent);
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Sleeping.class);
                startActivity(intent);
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Doctor.class);
                startActivity(intent);
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Shopping.class);
                startActivity(intent);
            }
        });





    }
}