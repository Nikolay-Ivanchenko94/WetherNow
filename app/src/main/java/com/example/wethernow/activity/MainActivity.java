package com.example.wethernow.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.wethernow.adapters.FutureAdapter;
import com.example.wethernow.databinding.ActivityMainBinding;
import com.example.wethernow.models.weather.Weather;
import com.example.wethernow.models.modelsforecast.Forecastday;
import com.example.wethernow.models.modelsforecast.FutureForecast;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private  ActivityMainBinding binding;
    private FutureAdapter futureAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
    }
}