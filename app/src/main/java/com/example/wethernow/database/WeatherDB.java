package com.example.wethernow.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WeatherDB {

    @PrimaryKey(autoGenerate = true)
   private String name;
   private String text;

   private  String last_updated;

    private double precip_in;
    private double temp_c;
    private int wind_degree;

    private int humidity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public double getPrecip_in() {
        return precip_in;
    }

    public void setPrecip_in(double precip_in) {
        this.precip_in = precip_in;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public int getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(int wind_degree) {
        this.wind_degree = wind_degree;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
