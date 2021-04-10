package com.example.foodapp;

import com.google.gson.annotations.SerializedName;

public class FoodModel {
    @SerializedName("idCategory")
    private String id;

    @SerializedName("strCategory")
    private String name;

    @SerializedName("strCategoryThumb")
    private String imageUrl;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    @SerializedName("strCategoryDescription")
    private String desc;
}
