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
    public void setId(int id ){
        this.id = id;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }
    public String getIcon(){
        return icon;
    }
    public void setIcon(String icon){
        this.icon = icon;
    }
    public double getTemp_c(){
        return temp_c;
    }
    public void setTemp_c(double temp_c){
        this.temp_c = temp_c;
    }
}
