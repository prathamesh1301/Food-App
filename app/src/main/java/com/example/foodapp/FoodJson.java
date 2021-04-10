package com.example.foodapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodJson {
    @SerializedName("categories")
    private List<FoodModel> foodItemList;

    public List<FoodModel> getFoodItemList() {
        return foodItemList;
    }
}
