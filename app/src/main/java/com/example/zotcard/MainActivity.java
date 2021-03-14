package com.example.zotcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.zotcard.fragments.CreateDeckFragment;
import com.example.zotcard.fragments.DecksFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()){
                    case R.id.action_create:
                        //TODO: update fragment
                        Toast.makeText(MainActivity.this, "Create!", Toast.LENGTH_SHORT).show();
                        fragment = new CreateDeckFragment();
                        break;
                    case R.id.action_decks:
                    default:
                        Toast.makeText(MainActivity.this, "Decks!", Toast.LENGTH_SHORT).show();
                        fragment = new DecksFragment();
                        break;
                }

                fragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_decks);
    }
}

