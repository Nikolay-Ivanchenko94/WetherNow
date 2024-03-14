package com.example.wethernow.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wethernow.R;
import com.example.wethernow.models.modelsforecast.Forecastday;

import java.util.ArrayList;

public class FutureAdapter extends RecyclerView.Adapter<FutureAdapter.viewHolder> {

    ArrayList<Forecastday> items;
    public
    FutureAdapter(ArrayList<Forecastday> items) {
        this.items = items;
    }



    @NonNull
    @Override
    public FutureAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inFlate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_future,parent,false);
        return new viewHolder(inFlate);
    }

    public void setItemsToAdapter(ArrayList<Forecastday> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull FutureAdapter.viewHolder holder, int position) {
        // String holderStatus = getConditionName(items.get(position).getCondition().getCode());//
        //holder.tvStatus.setText(holderStatus);//
        holder.tvDay.setText(String.valueOf(items.get(position).getDate()));
        //  holder.TextViewStatus.setText(String.valueOf(items.get(position).getDay().getCondition().getText()));//
        holder.tvHigh.setText(String.valueOf(items.get(position).getDay().getMaxtemp_c()));
        holder.tvLow.setText(String.valueOf(items.get(position).getDay().getMintemp_c()));
        // Glide.with(holder.itemView.getContext()).load("https:" + items.get(position).getCondition().getIcon()).into(holder.ivPicFuture);//
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvDay,tvStatus,tvLow,tvHigh;
        ImageView ivPicFuture;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tvDay = itemView.findViewById(R.id.tvDay);
            tvStatus= itemView.findViewById(R.id.tvStatus);
            tvHigh = itemView.findViewById(R.id.tvHigh);
            tvLow = itemView.findViewById(R.id.tvLow);
            ivPicFuture = itemView.findViewById(R.id.ivPicFuture);

        }
    }
}
