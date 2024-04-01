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
import com.example.wethernow.adapters.HoursAdapter;
import com.example.wethernow.adapters.HoursAdapter;
import com.example.wethernow.databinding.FragmentCityWeatherBinding;
import com.example.wethernow.models.modelsforecast.FutureForecast;
import com.example.wethernow.models.modelsforecast.Hour;
import com.example.wethernow.models.weather.Weather;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CityWeatherFragment extends Fragment {

    private FragmentCityWeatherBinding binding;
    private HoursAdapter hoursAdapters;

    private ApiService service;

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);

        requestCurrentWeather();
        initRecyclerView();
        requestHourList();



        return binding.getRoot();


    }

    private void initRecyclerView() {
        binding.rvHourly.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,true));
        hoursAdapters = new HoursAdapter(new ArrayList<>());
        binding.rvHourly.setAdapter(hoursAdapters);
    }


    private void requestHourList() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String URL = "https://api.weatherapi.com/v1/forecast.json?key=13c3af20c3e545d79f3125407240401&q=Dnipropetrovsk&days=qi=no&alerts=no";
        StringRequest getRequest = new StringRequest(Request.Method.GET, URL, response -> {
            Gson gson = new Gson();
            FutureForecast futureForecast = gson.fromJson(response, FutureForecast.class);
            ArrayList<Hour> hours = new ArrayList<>(futureForecast.getForecast().getForecastday().get(0).getHour());
            hoursAdapters.setItemsToAdapter(hours);

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
        service.getCurrentWeather().enqueue(new retrofit2.Callback<Weather>() {
            @Override
            public void onResponse(retrofit2.Call<Weather> call, retrofit2.Response<Weather> response) {
                if (response.isSuccessful() && response.body() != null){
                    setDataToViews(response.body());
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Weather> call, Throwable t) {
                Log.d("ERROR", "error" + t.toString());
            }
        });
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





    }


