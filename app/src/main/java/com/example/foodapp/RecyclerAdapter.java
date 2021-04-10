package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    private List<FoodModel> foodModels;
    private Context context;

    public RecyclerAdapter(List<FoodModel> foodModels, Context context) {
        this.foodModels = foodModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.element_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FoodModel model=foodModels.get(position);
        holder.food_name.setText(model.getName());
        Picasso.get().load(model.getImageUrl()).error(R.mipmap.ic_launcher).into(holder.food_image);
        Intent intent=new Intent(context,FoodInfo.class);
        intent.putExtra("name",model.getName());
        intent.putExtra("desc",model.getDesc());
        intent.putExtra("url",model.getImageUrl());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView food_image;
        TextView food_name;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            food_name=itemView.findViewById(R.id.food_name);
            food_image=itemView.findViewById(R.id.food_image);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }

}
