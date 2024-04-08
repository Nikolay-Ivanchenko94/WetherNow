package com.example.wethernow.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.wethernow.models.modelsforecast.FutureForecast;

import java.util.List;

@Dao
public interface FutureWeatherDao {

    @Insert
    public void insertFutureWeather(FutureForecast futureForecast);

    @Query("SELECT * FROM FutureForecast")
    public List<FutureForecast> getFutureForecast();


}
