package com.example.wethernow.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.wethernow.R;
import com.example.wethernow.databinding.ActivityMainBinding;
import com.example.wethernow.fragment.CityWeatherFragment;

public class MainActivity extends AppCompatActivity {
    private  ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        Fragment cityFragmentWather = new CityWeatherFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,cityFragmentWather).commit();



    }
}