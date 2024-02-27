package com.example.wethernow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.wethernow.adapters.FutureAdapter;
import com.example.wethernow.databinding.ActivityMainBinding;
import com.example.wethernow.models7.Climate;
import com.example.wethernow.modelsforecast.Forecastday;
import com.example.wethernow.modelsforecast.FutureForecast;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private  ActivityMainBinding binding;
    private Climate globallyWeather;
    private RecyclerView.Adapter adapterTomorrow;
    private RecyclerView recyclerView;
    private FutureAdapter futureAdapter;
    private FutureAdapter setItemsToAdapter;

    private Object getForecastday;

    ImageView imgGlide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        requestWithSomeHttHeaders();

        ImageView imgGLide = findViewById(R.id.ImageViewSunnyCloudy);
        Glide.with(this).load("https://cdn.weatherapi.com/weather/64x64/night/248.png").into(imgGLide);

        binding.BtnBackMain.setOnClickListener(v -> {
          //  Intent intent = new Intent()//
        });

    }
    private void requestAdapter(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URl = "\n" +
                "http://api.weatherapi.com/v1/forecast.json?key=" +
                "13c3af20c3e545d79f3125407240401 &q=Dnipropetrovsk&days=7&aqi=no&alerts=no";
        StringRequest getRequest = new StringRequest(Request.Method.GET, URl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                FutureForecast futureForecast = gson.fromJson(response, FutureForecast.class);
                Log.d("Forecast",futureForecast.getForecast().getForecastday().toString());
                ArrayList<Forecastday> forecastdays = new ArrayList<Forecastday>();
                forecastdays.addAll(futureForecast.getForecast().getForecastday());
                futureAdapter.setitemsToAdapter(forecastdays);
            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERROR","error=>" + error.toString());
                    }
                }
        ){

            @Override
            public Map<String, String> getHeaders()
                    throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        requestQueue.add(getRequest);

    }


    private void requestWithSomeHttHeaders() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://api.weatherapi.com/v1/forecast.json?key=13c3af20c3e545d79f3125407240401" +
                "&q=Dnipropetrovsk&days=qi=no&alerts=no";
        StringRequest getRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Climate locallyweather = gson.fromJson(response, Climate.class);
                globallyWeather = locallyweather;
                setDataToViews();
            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERROR","error=>" + error.toString());

                    }
                }
        ){

            @Override
            public Map<String, String> getHeaders()
                    throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        requestQueue.add(getRequest);
    }

    private void setDataToViews() {
        Log.d("glide TAG", "https:weatherapi.com/weather/64x64/night/248.png" + globallyWeather.getCurrent().getCondition().getIcon());
        Glide.with(MainActivity.this).load("https:" + globallyWeather.getCurrent().getCondition().getIcon()).into(binding.ImageViewSunnyCloudy);
        binding.TextViewDegreeMain.setText(String.valueOf(globallyWeather.getCurrent().getTemp_c() + "°C" ));
        binding.TextViewDegreeRain.setText(String.valueOf(globallyWeather.getCurrent().getPressure_in() + "%"));
        binding.TextViewWindyDegree.setText(String.valueOf(globallyWeather.getCurrent().getWind_mph() + "M/C"));
        binding.TextViewHumidityDegreeMain.setText(String.valueOf(globallyWeather.getCurrent().getHumidity() + "%"));
    }
    private void initRecyclerView(){
        binding.RecylerViewFuture.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        futureAdapter  = new FutureAdapter(new ArrayList<Forecastday>());
        binding.RecylerViewFuture.setAdapter(futureAdapter);
        ArrayList<Forecastday> items = new ArrayList<Forecastday>();


        recyclerView = findViewById(R.id.RecylerViewFuture);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));


    }


}