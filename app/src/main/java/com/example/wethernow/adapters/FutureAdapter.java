package com.example.wethernow.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wethernow.R;
import com.example.wethernow.modelsforecast.Forecastday;

import java.util.ArrayList;

public class FutureAdapter extends RecyclerView.Adapter<FutureAdapter.viewHolder> {

    ImageView imgGlide;
    private FutureAdapter globalFutureAdapter;

    Context context;

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

    void setitemToAdapter(ArrayList<Forecastday> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull FutureAdapter.viewHolder holder, int position) {
        // String holderStatus = getConditionName(items.get(position).getCondition().getCode());//
        //holder.TextViewStatus.setText(holderStatus);//
        holder.TextViewDay.setText(String.valueOf(items.get(position).getDate()));
        //  holder.TextViewStatus.setText(String.valueOf(items.get(position).getDay().getCondition().getText()));//
        holder.TextViewHigh.setText(String.valueOf(items.get(position).getDay().getMaxtemp_c()));
        holder.TextViewLow.setText(String.valueOf(items.get(position).getDay().getMintemp_c()));
        // Glide.with(holder.itemView.getContext()).load("https:" + items.get(position).getCondition().getIcon()).into(holder.ImageViewPicFuture);//
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public void
    setitemsToAdapter(ArrayList<Forecastday> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView TextViewDay,TextViewStatus,TextViewLow,TextViewHigh;
        ImageView ImageViewPicFuture;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            TextViewDay = itemView.findViewById(R.id.TextViewDay);
            TextViewStatus= itemView.findViewById(R.id.TextViewStatus);
            TextViewHigh = itemView.findViewById(R.id.TextViewHigh);
            TextViewLow = itemView.findViewById(R.id.TextViewLow);
            ImageViewPicFuture = itemView.findViewById(R.id.ImageViewPicFuture);

        }
    }
}
