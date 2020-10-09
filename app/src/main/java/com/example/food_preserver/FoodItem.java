package com.example.food_preserver;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodItem implements Parcelable {
    private String title;
    private String description;
    private int priority;
    private String picture;

    public FoodItem() {
        //empty constructor needed
    }

    public FoodItem(String title, String description, int priority, String picture) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.picture = picture;
    }

    protected FoodItem(Parcel in) {
        title = in.readString();
        description = in.readString();
        priority = in.readInt();
        picture = in.readString();
    }

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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public String getPicture() { return picture; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(priority);
        dest.writeString(picture);
    }
}

