package com.example.wethernow.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wethernow.R;
import com.example.wethernow.models.modelsforecast.Forecastday;
import com.example.wethernow.models.weather.Weather;

import java.util.ArrayList;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.viewHolder> {

    ArrayList<Forecastday> items;
    public
    HourlyAdapter(ArrayList<Forecastday> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public HourlyAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inFlate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_hourly,parent,false);
        return new viewHolder(inFlate);
    }

  public void setHourlyAdapters(ArrayList<Forecastday> items) {
        this.items = items;
        notifyDataSetChanged();
  }


    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.viewHolder holder, int position) {
        holder.tvTemp.setText(String.valueOf(items.get(position).getDay().getAvgtemp_c()));

           }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView tvTime,tvTemp;
        ImageView ivPicPath;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tvTime = itemView.findViewById(R.id.tvTime);
            tvTemp = itemView.findViewById(R.id.tvTemp);
            ivPicPath = itemView.findViewById(R.id.ivPicFuture);


        }
    }
}
