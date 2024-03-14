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
        //holder.textViewStatus.setText(holderStatus);//
        holder.textViewDay.setText(String.valueOf(items.get(position).getDate()));
        //  holder.TextViewStatus.setText(String.valueOf(items.get(position).getDay().getCondition().getText()));//
        holder.textViewHigh.setText(String.valueOf(items.get(position).getDay().getMaxtemp_c()));
        holder.textViewLow.setText(String.valueOf(items.get(position).getDay().getMintemp_c()));
        // Glide.with(holder.itemView.getContext()).load("https:" + items.get(position).getCondition().getIcon()).into(holder.ImageViewPicFuture);//
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textViewDay,textViewStatus,textViewLow,textViewHigh;
        ImageView imageViewPicFuture;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textViewDay = itemView.findViewById(R.id.textViewDay);
          ///  textViewStatus= itemView.findViewById(R.id.textViewStatus);///
            textViewHigh = itemView.findViewById(R.id.textViewHigh);
            textViewLow = itemView.findViewById(R.id.textViewLow);
            imageViewPicFuture = itemView.findViewById(R.id.imageViewPicFuture);

        }
    }
}
