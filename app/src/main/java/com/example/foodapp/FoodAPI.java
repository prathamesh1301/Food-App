package com.example.foodapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodAPI {
    @GET("https://www.themealdb.com/api/json/v1/1/categories.php")
    Call<FoodJson> getFoodList();
}
