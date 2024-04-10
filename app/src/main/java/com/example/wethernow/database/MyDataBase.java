package com.example.wethernow.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {HourDB.class}, version = 2)
public abstract  class MyDataBase extends RoomDatabase {
    public abstract HourDao hourDao();
}
