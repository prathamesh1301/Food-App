package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    FoodAPI foodAPI;
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/categories.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        foodAPI=retrofit.create(FoodAPI.class);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        getFood();


    }

   private void getFood(){
        Call<FoodJson> foodJsonCall=foodAPI.getFoodList();
        foodJsonCall.enqueue(new Callback<FoodJson>() {
            @Override
            public void onResponse(Call<FoodJson> call, Response<FoodJson> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Response Failed,code: "+response.code(), Toast.LENGTH_SHORT).show();
                   return;
                }else{
                    FoodJson foodJson=response.body();
                    List<FoodModel> foodModelList=foodJson.getFoodItemList();
                    adapter=new RecyclerAdapter(foodModelList,MainActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<FoodJson> call, Throwable t) {

            }
        });
   }
}