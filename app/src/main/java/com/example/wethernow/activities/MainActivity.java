package com.example.wethernow.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.wethernow.R;
import com.example.wethernow.adapters.FutureAdapter;
import com.example.wethernow.databinding.ActivityMainBinding;
import com.example.wethernow.domains.FutureDomain;
import com.example.wethernow.domains.Hourly;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  ActivityMainBinding binding;
    public RecyclerView recyclerView;

    private RecyclerView.Adapter adapterTomorrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initRecyclerView();

    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items=new ArrayList<>();


        items.add(new FutureDomain("Суб","stormicon",15,8));
        items.add(new FutureDomain("Нед","cloudyicon",10,5));
        items.add(new FutureDomain("Пон","windyicon",7,3));
        items.add(new FutureDomain("Вів","sunnyicon",5,2));
        items.add(new FutureDomain("Сер","rainicon",0,-4));
        items.add(new FutureDomain("Чет","sunnycloudy",2,-2));
        items.add(new FutureDomain("П'ят","snowicon",-5,-10));


        recyclerView =findViewById(R.id.RecylerViewFuture);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        adapterTomorrow = new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);
    }

}
