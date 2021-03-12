package com.example.zotcard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateCardActivity extends AppCompatActivity {
    public static final String TAG = "CreateCardActivity";
    private EditText input_question;
    private EditText input_answer;
    private Button btn_addCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_cards_within_deck);

        input_question = findViewById(R.id.input_question);
        input_answer = findViewById(R.id.input_answer);
        btn_addCard = findViewById(R.id.btn_addCard);

        btn_addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = input_question.getText().toString();
                String answer = input_answer.getText().toString();
                addCard(question,answer);
            }
        });
    }

    private void addCard(String question, String answer) {
        //add card to deck
    }

}