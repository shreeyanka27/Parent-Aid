package com.example.sampleat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WalkthroughActivity extends AppCompatActivity {

    private int[] images = {R.drawable.feeding, R.drawable.bfeeding, R.drawable.sleep,R.drawable.diaper, R.drawable.doctor, R.drawable.shopping};
    private String[] descriptions = {"Track your child's nutritional goals and feeding time!", "Track your feeding times!", "Track your baby's sleep schedule!", "Track your baby's poop!", "Book a pediatrician appointment!", "Shop for all your baby's needs!"};
    private int currentIndex = 0;

    private ImageView imageView;
    private TextView descriptionView;
    private Button nextButton,bt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        imageView = findViewById(R.id.walkthrough_image);
        descriptionView = findViewById(R.id.walkthrough_description);
        nextButton = findViewById(R.id.walkthrough_next_button);
        bt8 = (Button) findViewById(R.id.button8);

        // Set the first image and description
        imageView.setImageResource(images[0]);
        descriptionView.setText(descriptions[0]);

        // Add a click listener to the next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex++;

                // If there are more images to show, update the image and description
                if (currentIndex < images.length) {
                    imageView.setImageResource(images[currentIndex]);
                    descriptionView.setText(descriptions[currentIndex]);
                }
                // Otherwise, start the main activity
                else {
                    Intent intent = new Intent(WalkthroughActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WalkthroughActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
