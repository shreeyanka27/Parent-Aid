package com.example.sampleat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Shopping extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        ImageView image1= findViewById(R.id.diapers);
        ImageView image2= findViewById(R.id.feeding);
        ImageView image3= findViewById(R.id.bfeeding);
        ImageView image4= findViewById(R.id.sleep);
        ImageView image5= findViewById(R.id.doctor);
        ImageView image6= findViewById(R.id.shopping);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.amazon.in/s?k=bABY+MEDICINES&rh=p_72%3A1318476031&dc&crid=1M4IGU7Z18KDX&qid=1683886595&rnid=1318475031&sprefix=baby+medicines%2Caps%2C337&ref=sr_nr_p_ru_0&ds=v1%3ApdGa%2BSM6oow6iO5rASEYdQkyvPmW9XZgD78CiB5N9LQ"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.amazon.in/s?k=bABY+FOOD&rh=p_72%3A1318476031&dc&crid=1CTK3CYOZ0TGQ&qid=1683886470&rnid=1318475031&sprefix=baby+fo%2Caps%2C398&ref=sr_nr_p_ru_0&ds=v1%3A8XG4gJTJONnS%2Fqzb2xO%2BuI11dZCdL89t6cqhJ4adS6k"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.amazon.in/s?k=baby+supplement&sprefix=bABY+SUPPLE%2Caps%2C239&ref=nb_sb_ss_ts-doa-p_2_11"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.amazon.in/s?k=bABY+CRADLE&crid=1PQAGABOJVZV2&sprefix=baby+cradl%2Caps%2C237&ref=nb_sb_noss_2"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.amazon.in/s?k=bABY+DIAPER&rh=p_72%3A1318476031&dc&crid=12MDYZ4FIAZPS&qid=1683886514&rnid=1318475031&sprefix=baby+diaper%2Caps%2C311&ref=sr_nr_p_72_1&ds=v1%3A2ORezXhw4RPYjZD6TuOpJrEibzed7fd371zEtCuv3Is"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.amazon.in/s?k=bABY+CLOTHES&rh=p_72%3A1318476031&dc&crid=3LEANCY1L1SLG&qid=1683886703&rnid=1318475031&sprefix=baby+clothe%2Caps%2C239&ref=sr_nr_p_ru_0&ds=v1%3A5ijie%2FlBu3ZF3CRt8XRRq1ZdnWIfZSburn7Ap7J3r0s"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });





    }
}

