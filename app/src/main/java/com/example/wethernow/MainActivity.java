package com.example.wethernow;

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
        setContentView(binding.getRoot());
        requestCurrentWeather();
        initRecyclerView();
        requestFutureForecast();
    }

    private void requestCurrentWeather() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "https://api.weatherapi.com/v1/forecast.json?key=13c3af20c3e545d79f3125407240401" +
                "&q=Dnipropetrovsk&days=qi=no&alerts=no";
        StringRequest getRequest = new StringRequest(Request.Method.GET, URL, response -> {
            Gson gson = new Gson();
            Weather weather = gson.fromJson(response, Weather.class);
            setDataToViews(weather);
        },

                error -> Log.d("ERROR","error=>" + error.toString())
        ){

            @Override
            public Map<String, String> getHeaders() {
                return new HashMap<>();
            }
        };
        requestQueue.add(getRequest);
    }

    private void requestFutureForecast(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URl = "\n" +
                "https://api.weatherapi.com/v1/forecast.json?key=" +
                "13c3af20c3e545d79f3125407240401 &q=Dnipropetrovsk&days=7&aqi=no&alerts=no";
        StringRequest getRequest = new StringRequest(Request.Method.GET, URl, response -> {
            Gson gson = new Gson();
            FutureForecast futureForecast = gson.fromJson(response, FutureForecast.class);
            ArrayList<Forecastday> forecastdays = new ArrayList<>(futureForecast.getForecast().getForecastday());
            futureAdapter.setItemsToAdapter(forecastdays);
        },

                error -> Log.d("ERROR","error=>" + error.toString())
        ){

            @Override
            public Map<String, String> getHeaders() {
                return new HashMap<>();
            }
        };
        requestQueue.add(getRequest);

    }




    private void setDataToViews(Weather climate) {
        Glide.with(MainActivity.this).load("https:" + climate.getCurrent().getCondition().getIcon()).into(binding.ImageViewSunnyCloudy);
        binding.TextViewDegreeMain.setText(climate.getCurrent().getTemp_c() + "°C");
        binding.TextViewDegreeRain.setText(climate.getCurrent().getPressure_in() + "%");
        binding.TextViewWindyDegree.setText(climate.getCurrent().getWind_mph() + "M/C");
        binding.TextViewHumidityDegreeMain.setText(climate.getCurrent().getHumidity() + "%");
    }
    private void initRecyclerView(){
        binding.RecylerViewFuture.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        futureAdapter  = new FutureAdapter(new ArrayList<>());
        binding.RecylerViewFuture.setAdapter(futureAdapter);
    }
}