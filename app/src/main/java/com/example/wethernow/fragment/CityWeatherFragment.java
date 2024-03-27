package com.example.wethernow.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.wethernow.adapters.HourlyAdapter;
import com.example.wethernow.databinding.FragmentCityWeatherBinding;
import com.example.wethernow.models.modelsforecast.Forecastday;
import com.example.wethernow.models.modelsforecast.FutureForecast;
import com.example.wethernow.models.weather.Weather;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class CityWeatherFragment extends Fragment {

    private FragmentCityWeatherBinding binding;
    private HourlyAdapter hourlyAdapter;
    private RecyclerView rvHourly;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCityWeatherBinding.inflate(inflater,container,false);
           requestFutureWeather();
           requestCurrentWeather();
           unitRecyclerView();
           binding.btnmap.setOnClickListener(v-> {
            MapFragment mapFragment = new MapFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, mapFragment, "fidThisFragment").addToBackStack(null)
                    .commit();
       });
        binding.btn7NextDays.setOnClickListener(v -> {
            WeekWeatherFragment weekWeatherFragment = new WeekWeatherFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,weekWeatherFragment,"fingThisFagment").addToBackStack(null)
                    .commit();
        });
        return binding.getRoot();


    }

    private void unitRecyclerView() {
     binding.rvHourly.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,true));
     hourlyAdapter = new HourlyAdapter(new ArrayList<>());
     rvHourly = new RecyclerView(rvHourly.getContext());
     binding.rvHourly.setAdapter(hourlyAdapter);
    }



    private void requestFutureWeather() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String URL = "http://api.weatherapi.com/v1/current.json?key=13c3af20c3e545d79f3125407240401\" +\n" +
                "                \" &q=Dnipropetrovsk&aqi=no";
        StringRequest getRequest = new StringRequest(Request.Method.GET,URL,response -> {
            Gson gson = new Gson();
            Weather weather = gson.fromJson(response,Weather.class);
            ArrayList<Weather> weathers = new ArrayList<>((Collection) weather.getCurrent());
            hourlyAdapter.setHourlyAdapters(weathers);
        },

                error -> Log.d("ERROR", "error" + error.toString())
        ){

            @Override
            public Map<String,String> getHeaders() {
                return new HashMap<>();
            }
        };
        requestQueue.add(getRequest);
        }

    private void requestCurrentWeather() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String URL = "http://api.weatherapi.com/v1/current.json?key=13c3af20c3e545d79f3125407240401\" +\n" +
                "\" &q=Dnipropetrovsk&aqi=no";
        StringRequest getRequest = new StringRequest(Request.Method.GET,URL, response -> {
            Gson gson = new Gson();
            Weather weather = gson.fromJson(response,Weather.class);
            setDataToViwes(weather);
        },

                error -> Log.d("ERROR","error" + error.toString())
                ){

            @Override
            public  Map<String,String> getHeaders(){
                return  new HashMap<>();
            }
        };
        requestQueue.add(getRequest);
        }




    private void setDataToViwes(Weather weather) {
        binding.tvDate.setText(weather.getCurrent().getLast_updated());
    }
}

