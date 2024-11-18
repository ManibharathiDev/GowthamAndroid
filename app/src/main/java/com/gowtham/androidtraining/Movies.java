package com.gowtham.androidtraining;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Movies implements Parcelable
{
    private String title;
    private String description;
    private int duration;
    private String journer;
    private String rating;

    protected Movies(Parcel in) {
        title = in.readString();
        description = in.readString();
        duration = in.readInt();
        journer = in.readString();
        rating = in.readString();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public Movies() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getJourner() {
        return journer;
    }

    public void setJourner(String journer) {
        this.journer = journer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(duration);
        parcel.writeString(journer);
        parcel.writeString(rating);
    }
}
