package com.example.zotcard.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ritesh Shakya on 8/21/2016.
 */

public class CardModel implements Parcelable {

    public String frontSide;
    public String backSide;

    public CardModel()
    {

    }

    /*
     * @param frontSide        Front side of the card
     * @param backSide         Backside of card
     */
    @SuppressWarnings("unused")
    public CardModel(String frontSide, String backSide) {
        this.frontSide = frontSide;
        this.backSide = backSide;
    }

    public String getFrontSide() {
        return frontSide;
    }

    public String getBackSide() {
        return backSide;
    }


    /**
     * @param in Parcelable object returned on state changes.
     */
    private CardModel(Parcel in) {
        frontSide = in.readString();
        backSide = in.readString();
    }

    /**
     * Create new object of state changes.
     */
    public static final Creator<CardModel> CREATOR = new Creator<CardModel>() {
        @Override
        public CardModel createFromParcel(Parcel in) {
            return new CardModel(in);
        }

        @Override
        public CardModel[] newArray(int size) {
            return new CardModel[size];
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
        parcel.writeString(frontSide);
        parcel.writeString(backSide);
    }

}
