package com.example.wethernow.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wethernow.R;
import com.example.wethernow.domains.Hourly;

import java.util.ArrayList;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.viewHolder> {

    ArrayList<Hourly> items;
    Context  context;


    public HourlyAdapter(ArrayList<Hourly> items) {
        this.items = items;
    }

    @NonNull
    public HourlyAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inFlate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder,parent,false);
        context=parent.getContext();
        return new viewHolder(inFlate);
    }

    public void onBindViewHolder(@NonNull HourlyAdapter.viewHolder holder, int position) {
        holder.textviewhour.setText(items.get(position).getHour());
        holder.textviewtemp.setText(items.get(position).getTemp()+"°");
    }

    public int getItemCount() {
        return items.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder{

        TextView textviewhour,textviewtemp;
        ImageView imageviewpic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textviewhour =itemView.findViewById(R.id.textviewhour);
            textviewtemp= itemView.findViewById(R.id.textviewtemp);
            imageviewpic = itemView.findViewById(R.id.imageviewpic);

        }

    }
}
