package com.example.zotcard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

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
                createAccount(username,password);
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

    // Bundle this user alongside the activity?
    private void gotoLoginActivity(FirebaseUser user)
    {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }


    private void createAccount(String email, String password){
        LoginActivity.mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = LoginActivity.mAuth.getCurrentUser();
                            gotoLoginActivity(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }

                        // ...
                    }
                });
    }




}

