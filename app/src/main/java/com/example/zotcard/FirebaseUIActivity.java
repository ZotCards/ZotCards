package com.example.zotcard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zotcard.Model.CardModel;
import com.example.zotcard.Model.DeckModel;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class FirebaseUIActivity extends AppCompatActivity {


    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase;


    private static final int RC_SIGN_IN = 1;
    // Choose authentication providers
    List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.EmailBuilder().build());

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);

        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(), RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_u_i);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        ArrayList<CardModel> mockData = generateMockData();
        DeckModel deck = new DeckModel("1","Introduction to CS","Jee Kim", mockData);



        mDatabase.child("test").setValue("hello");
        mDatabase.child("deck").setValue(mockData);
        mDatabase.child("test_deck_1").setValue(deck);

    }

    public void recieveDeck(String deckID)
    {
        mDatabase.child("deck").child(deckID).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));


                }
            }
        });
    }


    private JSONObject createDeckJSON(JSONObject card_json) {
        JSONObject outer_most_json = new JSONObject();
        JSONObject deck_json = new JSONObject();
        try
        {
            outer_most_json.put("deck", deck_json);
            deck_json.put("card_array", card_json);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return outer_most_json;
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

//    private void readCardData()
//    {
//        mDatabase.child("decks").child(userId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    Log.e("firebase", "Error getting data", task.getException());
//                }
//                else {
//                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                }
//            }
//        });
//    }

    private JSONObject createCardJSON(ArrayList<CardModel> cards)
    {
        JSONObject cardJSON = new JSONObject();
        JSONObject result = new JSONObject();
        for (int i = 0; i < cards.size(); ++i)
        {
            CardModel card = cards.get(i);
            // Grab the CardModels
                // [front, back, author, objectid]
            String front = card.getFrontSide();
            String back = card.getBackSide();

            try {
                result.put("front", front);
                result.put("back", back);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }

            try {
                cardJSON.put(Integer.toString(i), result);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        return cardJSON;
    }





}