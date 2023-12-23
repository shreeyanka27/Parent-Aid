package com.example.sampleat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000; // Time in milliseconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        ImageView imageView = findViewById(R.id.splash_image_view);
        TextView textView = findViewById(R.id.splash_text_view);

        // Animation for the image view
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        imageView.startAnimation(animation);

        // Animation for the text view
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        textView.startAnimation(animation2);

        // Handler to delay the start of the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainPage.this, WalkthroughActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);


    }
}