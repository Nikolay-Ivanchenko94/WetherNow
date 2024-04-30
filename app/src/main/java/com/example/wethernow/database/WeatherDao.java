package com.example.wethernow.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WeatherDao {

    @Insert
    public void insertHourDBList(List<WeatherDB> weatherDBS);

    @Query("SELECT * FROM WeatherDB")
    public List<WeatherDB> getWeatherDBS();
}
