package com.example.wethernow.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wethernow.R;
import com.example.wethernow.database.HourDB;

import java.util.ArrayList;

public class HoursAdapter extends RecyclerView.Adapter<HoursAdapter.viewHolder> {


    ArrayList<HourDB> items;
    public HoursAdapter(ArrayList<HourDB> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HoursAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inFlate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_hourly,parent,false);
        return new HoursAdapter.viewHolder(inFlate);
    }
    public void setItemsToAdapter(ArrayList<HourDB> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull HoursAdapter.viewHolder holder, int position) {
        holder.tvTemp.setText(String.valueOf(items.get(position).getTemp_c()));
        holder.tvTime.setText(String.valueOf(items.get(position).getTime()));
        Glide.with(holder.itemView.getContext()).load("https" + items.get(position).getIcon()).into(holder.ivPicPath); ///
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {


        TextView tvTemp,tvTime; 
        ImageView ivPicPath;
        public viewHolder(@NonNull View itemView) {
            super(itemView);


            tvTime = itemView.findViewById(R.id.tvTime);
            tvTemp = itemView.findViewById(R.id.tvTemp);
            ivPicPath = itemView.findViewById(R.id.ivPicPath);

        }
    }
}
