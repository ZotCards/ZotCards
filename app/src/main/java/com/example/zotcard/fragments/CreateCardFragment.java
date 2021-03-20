package com.example.zotcard.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.zotcard.R;


public class CreateCardFragment extends Fragment {

    public static final String TAG = "CreateCardActivity";
    private EditText input_question;
    private EditText input_answer;
    private EditText input_deck_name;
    private Button btn_addCard;



    public CreateCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        input_question = view.findViewById(R.id.input_question);
        input_answer = view.findViewById(R.id.input_answer);
        input_deck_name = view.findViewById(R.id.input_deck_name);
        btn_addCard = view.findViewById(R.id.btn_addCard);

        btn_addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = input_question.getText().toString();
                String answer = input_answer.getText().toString();
                String deck_name = input_deck_name.getText().toString();
                addCard(deck_name,question,answer);
            }
        });


    }

    private void addCard(String deck_name, String question, String answer) {
    }
}
