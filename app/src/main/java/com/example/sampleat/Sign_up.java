package com.example.sampleat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sign_up extends AppCompatActivity {
    Button confirm_butt;
    DatabaseHelper myDb;
    private EditText name,email,phone,username,password,cpassword;
    private Button register_now;
    FirebaseAuth mAuth;
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
        setContentView(R.layout.activity_sign_up);
        mAuth= FirebaseAuth.getInstance();
        register_now = findViewById(R.id.button4);
        password = (EditText) findViewById(R.id.editTextTextPassword2);
        cpassword = (EditText) findViewById(R.id.editTextTextPassword4);
        phone = (EditText) findViewById(R.id.editTextPhone);
        name = (EditText) findViewById(R.id.editTextTextPersonName2);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        username = (EditText) findViewById(R.id.editTextTextPersonName5);
        confirm_butt =findViewById(R.id.confirm_button);
       myDb=new DatabaseHelper(this);
       //AddUserData();
        confirm_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email1= email.getText().toString();
                String password1= password.getText().toString();
                String name1= name.getText().toString();
                String phone1= phone.getText().toString();
                String username1= username.getText().toString();
                String cpassword1= cpassword.getText().toString();
                if(TextUtils.isEmpty( name1)){Toast.makeText(getApplicationContext(),"Enter name!",Toast.LENGTH_SHORT).show();}
                if(TextUtils.isEmpty(phone1)){Toast.makeText(getApplicationContext(),"Enter phone!",Toast.LENGTH_SHORT).show();}
                if(TextUtils.isEmpty(email1)){Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_SHORT).show();}
                if(TextUtils.isEmpty(username1)){Toast.makeText(getApplicationContext(),"Enter username!",Toast.LENGTH_SHORT).show();}
                if(TextUtils.isEmpty( password1)){Toast.makeText(getApplicationContext(),"Enter password!",Toast.LENGTH_SHORT).show();}
                if(TextUtils.isEmpty(cpassword1)){Toast.makeText(getApplicationContext(),"Confirm Password!",Toast.LENGTH_SHORT).show();}
                //if (string1 != null && !string1.equals(string2)


                if(password1 !=null && !password1.equals(cpassword1)){Toast.makeText(getApplicationContext(), "Passwords do not match!",Toast.LENGTH_SHORT).show();}

                else{
                    Toast.makeText(getApplicationContext(),"CLICK ON THE REGISTER BUTTON NOW!",Toast.LENGTH_SHORT).show();

                }
            }
        });






    register_now.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //String text = editText.getText().toString();
            String email1= email.getText().toString();
            String password1= password.getText().toString();
            mAuth.createUserWithEmailAndPassword(email1, password1)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //  Log.d(TAG, "createUserWithEmail:success");
                                // FirebaseUser user = mAuth.getCurrentUser();
                                //updateUI(user);
                                Toast.makeText(getApplicationContext(), "Registration Successful!",Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(getApplicationContext() ,MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                //  Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Sign_up.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                // updateUI(null);
                            }
                        }
                    });
            Toast.makeText(getApplicationContext(), " Check your registered email ID",Toast.LENGTH_SHORT).show();
            AddUserData();
            Intent intent= new Intent(Sign_up.this ,MainActivity.class);
            startActivity(intent);
            finish();
        }
    });
    }


    public void  AddUserData (){
        boolean isInserted = myDb.insertUserData(name.getText().toString(),email.getText().toString(),phone.getText().toString(),username.getText().toString());
        if(isInserted==true)
            Toast.makeText(Sign_up.this, "Data inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Sign_up.this, "Data not inserted", Toast.LENGTH_SHORT).show();
    }


    }

