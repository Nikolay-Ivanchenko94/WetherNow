package com.example.wethernow.fragment;

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
import com.example.wethernow.adapters.Adapters;
import com.example.wethernow.adapters.HourlyAdapter;
import com.example.wethernow.databinding.FragmentCityWeatherBinding;
import com.example.wethernow.models.modelsforecast.Forecastday;
import com.example.wethernow.models.modelsforecast.FutureForecast;
import com.example.wethernow.models.modelsforecast.Hour;
import com.example.wethernow.models.weather.Weather;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CityWeatherFragment extends Fragment {

    private FragmentCityWeatherBinding binding;
    private HourlyAdapter hourlyAdapter;
    private Adapters adapters;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
           binding = FragmentCityWeatherBinding.inflate(inflater,container,false);
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

        requestHourlyForecast();
        requestForecastWeather();
        requestCurrentWeather();
        unitRecyclerView();
        requestRecyclerView();
        requestWeatherAdapter();



        return binding.getRoot();


    }

    private void requestRecyclerView() {
        binding.rvHourly.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true));
        adapters = new Adapters(new ArrayList<>());
        binding.rvHourly.setAdapter(adapters);
    }

    private void requestWeatherAdapter() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String URL = "https://api.weatherapi.com/v1/forecast.json?key=13c3af20c3e545d79f3125407240401&q=Dnipropetrovsk&days=qi=no&alerts=no";
        StringRequest getRequest = new StringRequest(Request.Method.GET, URL, response -> {
            Gson gson = new Gson();
            FutureForecast futureForecast = gson.fromJson(response, FutureForecast.class);
            ArrayList<Forecastday> forecastdays = new ArrayList<>(futureForecast.getForecast().getForecastday());
            hourlyAdapter.setHourlyAdapters(forecastdays);

        },
                error -> Log.d("ERROR", "error" + error.toString())
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
        String URL = "https://api.weatherapi.com/v1/current.json?key=13c3af20c3e545d79f3125407240401&q=Dnipropetrovsk&days=qi=no&alerts=no";
        StringRequest getRequest = new StringRequest(Request.Method.GET, URL, response -> {
            Gson gson = new Gson();
            Weather weather = gson.fromJson(response,Weather.class);
            setDataToViews(weather);

        },
                error -> Log.d("ERROR", "error" + error.toString())
        ){
            @Override
            public Map<String, String> getHeaders() {
                return new HashMap<>();
            }
        };
        requestQueue.add(getRequest);
    }

    private void setDataToViews(Weather weather) {
        Glide.with(CityWeatherFragment.this).load("https:" + weather.getCurrent().getCondition().getIcon()).into(binding.ivSunnyCloudy);
        binding.tvDnipro.setText(String.valueOf(weather.getLocation().getname()));
        binding.tvSnow.setText(String.valueOf(weather.getCurrent().getCondition().getText()));
        binding.tvDate.setText(String.valueOf(weather.getCurrent().getLast_updated()));
        binding.tvDegree.setText(String.valueOf(weather.getCurrent().getTemp_c() + "°"));
        binding.tvDegreeRain.setText(String.valueOf(weather.getCurrent().getPrecip_in() + "%"));
        binding.tvWindyDegree.setText(String.valueOf(weather.getCurrent().getWind_degree() + "M/C"));
        binding.tvHumidityDegree.setText(String.valueOf(weather.getCurrent().getHumidity() + "%"));
    }

    private void requestForecastWeather() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String URL = "https://api.weatherapi.com/v1/forecast.json?key=13c3af20c3e545d79f3125407240401&q=Dnipropetrovsk&days=qi=no&alerts=no";
        StringRequest getRequest = new StringRequest(Request.Method.GET, URL, response -> {
            Gson gson = new Gson();
            FutureForecast futureForecast = gson.fromJson(response, FutureForecast.class);
        },
                error -> Log.d("ERROR", "error" + error.toString())
        ) {
            @Override
            public Map<String, String> getHeaders() {
                return new HashMap<>();
            }
        };
        requestQueue.add(getRequest);
    }

    private void unitRecyclerView() {
        binding.rvHourly.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true));
        hourlyAdapter = new HourlyAdapter(new ArrayList<>());
        binding.rvHourly.setAdapter(hourlyAdapter);
    }

    private void requestHourlyForecast() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String URL = "https://api.weatherapi.com/v1/forecast.json?key=13c3af20c3e545d79f3125407240401&q=Dnipropetrovsk&days=qi=no&alerts=no";
        StringRequest getRequest = new StringRequest(Request.Method.GET, URL, response -> {
            Gson gson = new Gson();
            FutureForecast futureForecast = gson.fromJson(response,FutureForecast.class);
            ArrayList<Forecastday> forecastdays = new ArrayList<>(futureForecast.getForecast().getForecastday());
            hourlyAdapter.setHourlyAdapters(forecastdays);
        },

                error -> Log.d("ERROR", "error" + error.toString())

        ) {
            @Override
            public Map<String, String> getHeaders() {
                return new HashMap<>();
            }
        };
        requestQueue.add(getRequest);


    }
}


