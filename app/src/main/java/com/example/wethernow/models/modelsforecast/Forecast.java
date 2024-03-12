package com.example.wethernow.models.modelsforecast;

import java.util.List;

public class Forecast {

    List<Forecastday> forecastday;

    public Forecast(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }
    public List<Forecastday> getForecastday(){
        return  forecastday;
    }
    public void setForecastday(List<Forecastday> forecastday){
        this.forecastday = forecastday;
    }
}
