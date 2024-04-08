package com.example.wethernow.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.wethernow.models.modelsforecast.FutureForecast;

@Database(entities = {FutureForecast.class}, version = 1)
public abstract  class MyDataBase extends RoomDatabase {
    public abstract FutureWeatherDao futureWeatherDao();
}
