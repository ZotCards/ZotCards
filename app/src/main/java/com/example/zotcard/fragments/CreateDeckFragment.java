package com.example.zotcard.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.zotcard.CreateCardActivity;
import com.example.zotcard.R;


public class CreateDeckFragment extends Fragment {

    private Button btn_createDeck;
    private Button btn_editDeck;
    private Button btn_addCard;

    public CreateDeckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_deck, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        btn_createDeck = view.findViewById(R.id.btn_createDeck);
        btn_editDeck = view.findViewById(R.id.btn_editDeck);
        btn_addCard = view.findViewById(R.id.btn_addCard);

        btn_createDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateCardFragment fragment = new CreateCardFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.flContainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

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