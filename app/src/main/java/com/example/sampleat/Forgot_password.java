package com.example.sampleat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Forgot_password extends AppCompatActivity {
    private Button bt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        bt5= (Button) findViewById(R.id.button5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), " Check your registered email ID",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(Forgot_password.this ,MainActivity.class);
                    startActivity(intent);
                }


            }
        );
    }
}