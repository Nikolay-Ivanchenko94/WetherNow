package com.example.wethernow.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {HourDB.class,WeatherDB.class}, version = 3)
public abstract  class MyDataBase extends RoomDatabase {
    public abstract HourDao hourDao();

    public abstract WeatherDao weatherDao();
}
