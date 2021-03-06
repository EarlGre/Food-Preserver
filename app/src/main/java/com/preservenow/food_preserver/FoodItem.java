package com.preservenow.food_preserver;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodItem implements Parcelable {
    public static final Creator<FoodItem> CREATOR = new Creator<FoodItem>() {
        @Override
        public FoodItem createFromParcel(Parcel in) {
            return new FoodItem(in);
        }

        @Override
        public FoodItem[] newArray(int size) {
            return new FoodItem[size];
        }
    };
    private String title;
    private String canningMethod;
    private String dryingMethod;
    private String freezingMethod;
    private int priority;
    private String picture;
    private String canPicture;
    private String type;

    public FoodItem() {
        //empty constructor needed
    }

    public FoodItem(String title, String canningMethod, String dryingMethod, String freezingMethod, int priority, String picture, String canPicture, String type) {
        this.title = title;
        this.canningMethod = canningMethod;
        this.dryingMethod = dryingMethod;
        this.freezingMethod = freezingMethod;
        this.priority = priority;
        this.picture = picture;
        this.canPicture = canPicture;
        this.type = type;
    }

    protected FoodItem(Parcel in) {
        title = in.readString();
        canningMethod = in.readString();
        dryingMethod = in.readString();
        freezingMethod = in.readString();
        priority = in.readInt();
        picture = in.readString();
        canPicture = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public String getCanningMethod() {
        return canningMethod;
    }

    public String getDryingMethod() {
        return dryingMethod;
    }

    public String getFreezingMethod() {
        return freezingMethod;
    }

    public int getPriority() {
        return priority;
    }

    public String getPicture() {
        return picture;
    }

    public String getCanPicture() {
        return canPicture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(canningMethod);
        dest.writeString(dryingMethod);
        dest.writeString(freezingMethod);
        dest.writeInt(priority);
        dest.writeString(picture);
        dest.writeString(canPicture);
        dest.writeString(type);
    }
}

