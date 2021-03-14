package com.example.zotcard.Model;

import android.os.Parcel;
import android.os.Parcelable;


        import android.os.Parcel;
        import android.os.Parcelable;

/**
 * Created by Jee Kim on 3/13/2021.
 */

public class UserModel implements Parcelable {

    public String frontSide;
    public String backSide;
    public String userName;
    public String objectID;


    /**
     * Default Constructor.
     */
    @SuppressWarnings("unused")
    public UserModel() {

    }

    /**
     * Firebase uses this constructor for initializing class.
     *
     * @param frontSide        Front side of the card
     * @param backSide         Backside of card
     * @param userName         Username of card owner
     * @param objectid         ID of the card
     */
    @SuppressWarnings("unused")
    public UserModel(String frontSide, String backSide, String userName, String objectid) {
        this.frontSide = frontSide;
        this.backSide = backSide;
        this.userName = userName;
        this.objectID = objectid;
    }

    public String getFrontSide() {
        return frontSide;
    }

    public String getBackSide() {
        return backSide;
    }

    public String getUserName() {
        return userName;
    }

    public String getObjectID() {
        return objectID;
    }

    /**
     * @param in Parcelable object returned on state changes.
     */
    private UserModel(Parcel in) {
        frontSide = in.readString();
        backSide = in.readString();
        userName = in.readString();
        objectID = in.readString();
    }

    /**
     * Create new object of state changes.
     */
    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
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
        parcel.writeString(userName);
        parcel.writeString(objectID);
    }

}
