package com.example.zotcard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";
    private EditText input_user;
    private EditText input_password;
    private Button btn_signup;
    private TextView link_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        input_user= findViewById(R.id.input_user);
        input_password = findViewById(R.id.input_password);
        btn_signup = findViewById(R.id.btn_signup);
        link_login = findViewById(R.id.link_login);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = input_user.getText().toString();
                String password = input_password.getText().toString();
                signupUser(username,password);
            }
        });

        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLoginActivity();

            }
        });


    }

    private void goLoginActivity() {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }


    private void signupUser(String username, String password){

    }




}

