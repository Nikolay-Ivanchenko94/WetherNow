package com.example.wethernow.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.wethernow.R;
import com.example.wethernow.activity.MainActivity;
import com.example.wethernow.adapters.FutureAdapter;
import com.example.wethernow.databinding.FragmentCityWeatherBinding;
import com.example.wethernow.models.modelsforecast.Forecastday;
import com.example.wethernow.models.modelsforecast.FutureForecast;
import com.example.wethernow.models.weather.Weather;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CityWeatherFragment extends Fragment {

    private FragmentCityWeatherBinding binding;
    private FutureAdapter futureAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCityWeatherBinding.inflate(inflater,container,false);
        requestFutureForecast();
        requestCurrentWeather();
        initRecyclerView();
        return binding.getRoot();

        binding.btnmap.setOnClickListener(v -> {Intent intent = new Intent(CityWeatherFragment.this, MapFragment.class);
        });
        binding.btn7nextdays.setOnClickListener(v -> {Intent intent = new Intent(CityWeatherFragment.this, WeekWeatherFragment.class)});
    }



    private void requestFutureForecast() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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


    private void requestCurrentWeather() {

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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

    private void setDataToViews(Weather climate) {
        Glide.with(CityWeatherFragment.this).load("https:" + climate.getCurrent().getCondition().getIcon()).into(binding.ImageViewSunnyCloudy);
        binding.TextViewDegreeMain.setText(climate.getCurrent().getTemp_c() + "°C");
        binding.TextViewDegreeRain.setText(climate.getCurrent().getPressure_in() + "%");
        binding.TextViewWindyDegree.setText(climate.getCurrent().getWind_mph() + "M/C");
        binding.TextViewHumidityDegreeMain.setText(climate.getCurrent().getHumidity() + "%");
    }

    private void initRecyclerView() {
        binding.RecylerViewFuture.setLayoutManager(new LinearLayoutManager(getContext() ,LinearLayoutManager.VERTICAL,true));
        futureAdapter  = new FutureAdapter(new ArrayList<>());
        binding.RecylerViewFuture.setAdapter(futureAdapter);
    }


}