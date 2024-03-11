package com.example.wethernow.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wethernow.R;
import com.example.wethernow.adapters.HourlyAdapter;
import com.example.wethernow.databinding.ActivityMainDniproBinding;
import com.example.wethernow.databinding.FragmentKievBinding;
import com.example.wethernow.domains.Hourly;
import com.example.wethernow.fragments.KievFragment;
import com.example.wethernow.models.weather.Weather;

import java.util.ArrayList;

public class ActivityMainDnipro extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;

    private RecyclerView recyclerView;
    private FragmentKievBinding _binding;


  private ActivityMainDniproBinding binding;
  private KievFragment kievFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainDniproBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        unitRecyclerView();

        binding.btnnext7days.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainDnipro.this, KievFragment.class);
        startActivity(intent);}
        );
        binding.BtnGeolocation.setOnClickListener(v ->{Intent intent = new Intent(ActivityMainDnipro.this, MainActivity.class);}
        );

        KievFragment kievFragment = new KievFragment();

        ImageView imgGlide = findViewById(R.id.imageviewcloudy);


        Glide.with(this).load("https://cdn-icons-png.freepik.com/512/4150/4150897.png").into(imgGlide);
    }

    private void unitRecyclerView() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly(-3, "14:00", "cloudyicon"));
        items.add(new Hourly(-4, "15:00", "sunnyicon"));
        items.add(new Hourly(-1, "16:00", "iconwindy"));
        items.add(new Hourly(-7, "17:00", "rainicon"));
        items.add(new Hourly(-1, "18:00", "snowicon"));
        items.add(new Hourly(-3, "19:00", "stormicon"));

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        adapterHourly= new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);

    }


}

