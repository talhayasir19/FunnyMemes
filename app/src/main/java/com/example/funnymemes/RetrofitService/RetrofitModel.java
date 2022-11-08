package com.example.funnymemes.RetrofitService;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RetrofitModel {

    @SerializedName("id")
    public int id;

    @SerializedName("title")
    public String title;

    @SerializedName("image")
    public String imageUrl;

    public RetrofitModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
