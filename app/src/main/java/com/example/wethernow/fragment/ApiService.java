package com.example.wethernow.fragment;

import com.example.wethernow.models.weather.Weather;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v1/current.json?key=13c3af20c3e545d79f3125407240401&q=Dnipropetrovsk&days=qi=no&alerts=no")
    Call<Weather> getCurrentWeather();
}
