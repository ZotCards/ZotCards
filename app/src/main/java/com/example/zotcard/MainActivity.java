package com.example.zotcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zotcard.Activities.CardActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnDeck1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDeck1 = findViewById(R.id.Deck1);

        btnDeck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}