package com.example.wethernow.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
   public interface HourDao {

    @Insert
    public void insertHourDBList(List<HourDB> hourDB);

    @Query("SELECT * FROM HourDB")
    public List<HourDB> getHourDBList();


}
