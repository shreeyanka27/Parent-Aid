package com.example.sampleat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText text1,text2;
    private Button bt1,bt2,bt3;
    private TextView text3;

    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent= new Intent(getApplicationContext() ,Dashboard.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1= (EditText) findViewById(R.id.editTextTextPersonName);
        text2= (EditText) findViewById(R.id.editTextTextPassword);
        bt1= (Button) findViewById(R.id.button);
        bt2= (Button) findViewById(R.id.button2);
        bt3= (Button) findViewById(R.id.button3);
        text3= (TextView) findViewById(R.id.textView2) ;
        mAuth = FirebaseAuth.getInstance();


        bt1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1= text1.getText().toString();
                String password1= text2.getText().toString();
                if(TextUtils.isEmpty(email1)){
                    Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_SHORT).show();}
                if(TextUtils.isEmpty(password1)){Toast.makeText(getApplicationContext(),"Enter password!",Toast.LENGTH_SHORT).show();}
                else{

                    mAuth.signInWithEmailAndPassword(email1, password1)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(MainActivity.this, "Signed In.",
                                                Toast.LENGTH_SHORT).show();

                                        Intent intent= new Intent(getApplicationContext() ,Dashboard.class);
                                        startActivity(intent);
                                        finish();
                                    } else {

                                        Toast.makeText(MainActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                }
            }
        });







        bt2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(MainActivity.this ,Sign_up.class);
                startActivity(intent);

            }
        });
        bt3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(MainActivity.this ,Forgot_password.class);
                startActivity(intent);

            }
        });


    }
}
