package com.example.wethernow.fragment;


public class Weather {


    String degree;
    String weather;
    String degreeRain;
    String degreeWindy;
    String degreeHumidity;

    public Weather(){
    }
    public Weather(String degree,String weather,String degreeRain,
                   String degreeWindy,String degreeHumidity) {
        this.degree = degree;
        this.weather = weather;
        this.degreeRain = degreeRain;
        this.degreeWindy = degreeWindy;
        this.degreeHumidity = degreeHumidity;
    }
    public String getWeather(){
        return  weather;
    }
    public void setWeather(){
        this.weather = weather;
    }


}
