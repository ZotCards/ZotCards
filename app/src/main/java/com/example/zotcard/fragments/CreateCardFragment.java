package com.example.zotcard.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zotcard.Model.CardModel;
import com.example.zotcard.Model.DeckModel;
import com.example.zotcard.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;


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

        initHashMap();

        ArrayList<CardModel> mockData = generateMockData();
        DeckModel deck = new DeckModel("1","Introduction to CS","Jee Kim", mockData);

        mDatabase.child("test").setValue("hello");
        mDatabase.child("deck").setValue(mockData);
        mDatabase.child("test_deck_1").setValue(deck);


    }

    private ArrayList<CardModel> generateMockData()
    {
        ArrayList<CardModel> deck = new ArrayList<>();

        CardModel card1 = new CardModel("Print 'hello world' in Python", "print('Hello World')");
        CardModel card2 = new CardModel("Create an if-else statement", "if (condition) {} else {}");
        CardModel card3 = new CardModel("Name a data structure", "Stacks, Heaps, Arrays, Vectors, HashMaps, Sets");

        deck.add(card1);
        deck.add(card2);
        deck.add(card3);

        return deck;
    }


    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase = database.getReference();
    private HashMap<String, String> DeckMapping = new HashMap<String, String>();

    /*
        Initializes the hash map with {test_deck_1: Computer Science, test_deck_2: Spanish test_deck_3: Math, test_deck_4: French ...
     */
    private void initHashMap()
    {
        DeckMapping.put("Computer Science", "test_deck_1");
        DeckMapping.put("Spanish", "test_deck_2");
        DeckMapping.put("Math", "test_deck_3");
        DeckMapping.put("French", "test_deck_4");
    }




    private void readCountFromDB(String deck_name, String question, String answer)
    {
        mDatabase.child(deck_name).child("size").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    size = Integer.parseInt(String.valueOf(task.getResult().getValue()));

                    CardModel newCard = new CardModel(question, answer );
                    Log.d(TAG, "Card Object is" + newCard.frontSide + " " + newCard.backSide);
                    mDatabase.child(deck_name).child("deck").child(Integer.toString(size)).setValue(newCard);


                    size += 1;
                    Log.d(TAG, "Size of deck is : " + size);
                    mDatabase.child(deck_name).child("size").setValue(Integer.toString(size));
//                    if (size == null)
//                    {
//                        Log.d("Integer.getInteger()", "Failed conversion of string to int.");
//                    }
                }
            }
        });

    }
    //https://firebase.google.com/docs/database/web/read-and-write
    /*
        (1) We need to get in contact with Firebase DB [x]
        (2) We need to then verify that deck_name exists within the database endpoint [x]
        (3) Create a CardModel Object (question, answer) [x]
        (4) Grab the "count" from the DB (hard_code the endpoint) [x]
        (5) Add the card to the DB (count, CardObject) [x]
        (6) Increment the count by one [x]
        (7) Update the new count in the DB [x]
     */
    public int size;

    private void addCard(String deck_name, String question, String answer) {
        mDatabase = FirebaseDatabase.getInstance().getReference();

        String realName = DeckMapping.get(deck_name);
        if (realName == null)
        {
            Toast.makeText(getContext(), "Invalid deck name",Toast.LENGTH_SHORT).show();
            return;
        }
        readCountFromDB(realName, question, answer);

//        mDatabase.child("deck").setValue(mockData);
//        mDatabase.child("test_deck_1").setValue(deck);
    }

    private void writeCardToDB() {
    }
}
