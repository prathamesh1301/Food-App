package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FoodInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);
        Intent intent=getIntent();
        TextView food_name_info=findViewById(R.id.food_name_info);
        ImageView food_img=findViewById(R.id.food_image_info);
        TextView food_desc=findViewById(R.id.food_desc);



        food_desc.setText(intent.getStringExtra("desc"));
        food_desc.setMovementMethod(new ScrollingMovementMethod());
        food_name_info.setText(intent.getStringExtra("name"));
        String url=intent.getStringExtra("url");
        Picasso.get().load(url).error(R.mipmap.ic_launcher).into(food_img);

    }
}