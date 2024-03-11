package com.example.wethernow.models.weather;

import android.provider.ContactsContract;

import com.example.wethernow.models.modelsforecast.Day;
import com.example.wethernow.models.modelsforecast.Forecast;
import com.example.wethernow.models.modelsforecast.Forecastday;

import java.util.Date;

public class WeatherDay {


    private Day day;
    private Date date;

    private Forecast forecast;

    public Day getDay(){
        return day;
    }
    public void setDay(){
        this.day = day;
    }
    public Date getDate(){
        return  date;
    }
    public void setDate(){
        this.date = date;
    }
   public Forecast getForecast(){
        return  forecast;
   }
   public void setForecast(){
        this.forecast = forecast;
   }
}
