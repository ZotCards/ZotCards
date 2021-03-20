package com.example.zotcard.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zotcard.Activities.Algebra2CardActivity;
import com.example.zotcard.Activities.CardActivity;
import com.example.zotcard.Activities.FrenchCardActivity;
import com.example.zotcard.Activities.SpanishCardActivity;
import com.example.zotcard.R;

public class DecksFragment extends Fragment {

    private Button Deck1;
    private Button Deck2;
    private Button Deck3;
    private Button Deck4;


    public DecksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_decks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Deck1 = view.findViewById(R.id.Deck1);
        Deck2 = view.findViewById(R.id.Deck2);
        Deck3 = view.findViewById(R.id.Deck4);
        Deck4 = view.findViewById(R.id.Deck4);

        Deck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Button1!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), SpanishCardActivity.class);
                startActivity(intent);

            }
        });

        Deck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Button2!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), Algebra2CardActivity.class);
                startActivity(intent);

            }
        });

        Deck3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Button3!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), FrenchCardActivity.class);
                startActivity(intent);

            }
        });

        Deck4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Button4!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), CardActivity.class);
                startActivity(intent);

            }
        });
    }
}