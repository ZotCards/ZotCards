package com.example.zotcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    void mainActivityIntent(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    void CreateDeckActivityIntent(){
        Intent i = new Intent(this,CreateDeckActivity.class);
        startActivity(i);
    }
}