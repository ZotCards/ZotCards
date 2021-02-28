package com.example.zotcard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText input_user;
    private EditText input_password;
    private Button btn_login;
    private TextView link_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_user= findViewById(R.id.input_user);
        input_password = findViewById(R.id.input_password);
        btn_login = findViewById(R.id.btn_login);
        link_signup = findViewById(R.id.link_signup);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = input_user.getText().toString();
                String password = input_password.getText().toString();
                loginUser(username,password);
            }
        });

        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"IDK ahh help");
                goSignUpActivity();

            }
        });


    }

    private void goSignUpActivity() {
        Intent i = new Intent(this,SignUpActivity.class);
        startActivity(i);
    }


    private void loginUser(String username, String password){
        finish();

    }

}
