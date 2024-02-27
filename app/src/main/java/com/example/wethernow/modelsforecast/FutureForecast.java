package com.example.wethernow.modelsforecast;

import com.example.wethernow.models.Current;
import com.example.wethernow.models.Location;
import com.example.wethernow.modelsforecast.Forecast;

public class FutureForecast {

    private Current current;
    private Location location;
    private Forecast forecast;

    public Current getCurrent(){
        return current;
    }
    public void setCurrent(){
        this.current = current;
    }
    public Location getLocation(){
        return location;
    }
    public void setLocation(){
        this.location = location;
    }
    public Forecast getForecast(){
        return  forecast;
    }
    public void setForecast(){
        this.forecast = forecast;
    }



}
