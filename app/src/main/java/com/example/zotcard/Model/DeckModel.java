package com.example.zotcard.Model;


import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jee Kim on 3/13/2021.
 */

public class DeckModel implements Parcelable {

    public String deckID;
    public String deckName;
    public String author;
    public ArrayList<CardModel> deck;
    public long size;


    /**
     * Default Constructor.
     */
    @SuppressWarnings("unused")
    public DeckModel() {

    }

    /**
     * Firebase uses this constructor for initializing class.
     *
     * @param deckID       ID of the deck
     * @param deckName     Human-Readable name
     * @param author       Username of card owner
     * @param deck         List<Cards>
     */
    @SuppressWarnings("unused")
    public DeckModel(String deckID, String deckName, String author, ArrayList<CardModel> deck) {
        this.deckID = deckID;
        this.deckName = deckName;
        this.author = author;
        this.deck = deck;
    }

    public String getDeckID() {
        return deckID;
    }

    public String getDeckName() {
        return deckName;
    }

    public String getAuthor() {
        return author;
    }

    public ArrayList<CardModel> getDeck() {
        return deck;
    }

    public long getSize() {
        return deck.size();
    }

    /**
     * @param in Parcelable object returned on state changes.
     */
    private DeckModel(Parcel in) {
        deckID = in.readString();
        deckName = in.readString();
        author = in.readString();
        deck = in.createTypedArrayList(CardModel.CREATOR);
    }


    /**
     * Create new object of state changes.
     */
    public static final Creator<DeckModel> CREATOR = new Creator<DeckModel>() {
        @Override
        public DeckModel createFromParcel(Parcel in) {
            return new DeckModel(in);
        }

        @Override
        public DeckModel[] newArray(int size) {
            return new DeckModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Parcelable object written on state changes.
     *
     * @param parcel Parcelable object in which state changes are written.
     * @param i      Flags used to storing Parcelable object
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(deckID);
        parcel.writeString(deckName);
        parcel.writeString(author);
        parcel.writeTypedList(deck);
    }

}
