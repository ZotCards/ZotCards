package com.example.zotcard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreateDeckActivity extends AppCompatActivity {
    private Button btn_createDeck;
    private Button btn_editDeck;
    private Button btn_addCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_deck);

        btn_createDeck = findViewById(R.id.btn_createDeck);
        btn_editDeck = findViewById(R.id.btn_editDeck);
        btn_addCard = findViewById(R.id.btn_addCard);

        btn_createDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_editDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
