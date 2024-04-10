package com.example.wethernow.database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HourDB {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String time;
    private double temp_c;
    private String icon;



    public int getId(){
        return id;
    }
    public void setId(){
        this.id = id;
    }
    public String getTime(){
        return time;
    }
    public void setTime(){
        this.time = time;
    }
    public String getIcon(){
        return icon;
    }
    public void setIcon(){
        this.icon = icon;
    }
}
