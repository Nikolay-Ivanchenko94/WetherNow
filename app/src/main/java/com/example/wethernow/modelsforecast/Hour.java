package com.example.wethernow.modelsforecast;

import com.example.wethernow.modelsforecast.Condition;

public class Hour {
    private long time_epoch;
    private String time;
    private double temp_c;
    private double temp_f;
    private int is_day;

    private Condition condition;
    private double wind_mph;
    private double wind_kph;
    private int wind_degree;
    private String wind_dir;
    private double pressure_mb;
    private double pressure_in;
    private double precip_mm;
    private double precip_in;
    private double snow_cm;
    private int humidity;
    private int cloud;
    private double feelslike_c;
    private double feelslike_f;
    private double windchill_c;
    private double windchill_f;
    private double heatindex_c;
    private double heatindex_f;
    private double dewpoint_c;
    private double dewpoint_f;
    private int will_it_rain;
    private int chance_of_rain;
    private int will_it_snow;
    private int change_of_snow;
    private double vis_km;
    private  double vis_miles;
    private double gust_mph;

    private double gust_kph;
    private double uv;

    public long getTime_epoch() {
        return time_epoch;
    }
    public void setTime_epoch() {
        this.time_epoch = time_epoch;
    }
    public String getTime() {
        return time;
    }
    public void setTime() {
        this.time = time;
    }
    public double getTemp_c() {
        return temp_c;
    }
    public void setTemp_c() {
        this.temp_c = temp_c;
    }
    public double getTemp_f() {
        return  temp_f;
    }
    public void setTemp_f() {
        this.temp_f = temp_f;
    }
    public int getIs_day() {
        return is_day;
    }
    public void setIs_day() {
        this.is_day = is_day;
    }
    public double getWind_mph() {
        return wind_mph;
    }
    public void setWind_mph() {
        this.wind_mph = wind_mph;
    }
    public double getWind_kph() {
        return wind_kph;
    }
    public void setWind_kph(){
        this.wind_kph = wind_kph;
    }
    public int getWind_degree() {
        return  wind_degree;
    }
    public void setWind_degree() {
        this.wind_degree = wind_degree;
    }
    public String getWind_dir(){
        return wind_dir;
    }
    public void setWind_dir(){
        this.wind_dir = wind_dir;
    }
    public double getPressure_mb(){
        return pressure_mb;
    }
    public void setPressure_mb(){
        this.pressure_mb = pressure_mb;
    }
    public double getPressure_in(){
        return pressure_in;
    }
    public double getSnow_cm() {
        return snow_cm;
    }
    public void setSnow_cm() {
        this.snow_cm = snow_cm;
    }
    public int getHumidity() {
        return humidity;
    }
    public void setHumidity() {
        this.humidity = humidity;
    }
    public int getCloud() {
        return cloud;
    }
    public void setCloud() {
        this.cloud = cloud;
    }
    public double getFeelslike_c() {
        return feelslike_c;
    }
    public void setFeelslike_c() {
        this.feelslike_c = feelslike_c;
    }
    public double getFeelslike_f() {
        return feelslike_f;
    }
    public void setFeelslike_f() {
        this.feelslike_f = feelslike_f;
    }
    public int getWill_it_rain() {
        return will_it_rain;
    }
    public void setWill_it_rain(){
        this.will_it_rain = will_it_rain;
    }
    public int getChance_of_rain() {
        return chance_of_rain;
    }
    public void setChance_of_rain() {
        this.chance_of_rain = chance_of_rain;
    }
    public double getVis_km() {
        return vis_km;
    }
    public void setVis_km() {
        this.vis_km = vis_km;
    }
    public double getVis_miles() {
        return vis_miles;
    }
    public void setVis_miles() {
        this.vis_miles = vis_miles;
    }
    public double getGust_mph(){
        return gust_mph;
    }
    public void setGust_mph() {
        this.gust_mph = gust_mph;
    }
    public double getGust_kph() {
        return  gust_kph;
    }
    public void setGust_kph() {
        this.gust_kph = gust_kph;
    }
    public double getUv() {
        return uv;
    }
    public void setUv(){
        this.uv = uv;
    }
    public Hour(long time_epoch, String time, double temp_c, double temp_f,
                int is_day, double wind_mph, double wind_kph, int wind_degree,
                String wind_dir, double pressure_mb, double pressure_in,
                double precip_mm, double precip_in, double snow_cm, int humidity,
                int cloud, double feelslike_c, double feelslike_f, double windchill_c,
                double windchill_f, double heatindex_c, double heatindex_f,
                double dewpoint_c, double dewpoint_f, int will_it_rain, int chance_of_rain,
                int will_it_snow, int change_of_snow, double vis_km, double vis_miles, double gust_kph,
                double gust_mph, double uv) {


        this.time_epoch = time_epoch;
        this.time = time;
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.is_day = is_day;
        this.wind_mph = wind_mph;
        this.wind_kph = wind_kph;
        this.wind_degree = wind_degree;
        this.wind_dir = wind_dir;
        this.pressure_mb = pressure_mb;
        this.pressure_in = pressure_in;
        this.precip_mm = precip_mm;
        this.precip_in = precip_in;
        this.snow_cm = snow_cm;
        this.humidity = humidity;
        this.cloud = cloud;
        this.feelslike_c = feelslike_c;
        this.feelslike_f = feelslike_f;
        this.windchill_c = windchill_c;
        this.windchill_f = windchill_f;
        this.heatindex_c = heatindex_c;
        this.heatindex_f = heatindex_f;
        this.dewpoint_c = dewpoint_c;
        this.dewpoint_f = dewpoint_f;
        this.will_it_rain = will_it_rain;
        this.chance_of_rain = chance_of_rain;
        this.will_it_snow = will_it_snow;
        this.change_of_snow = change_of_snow;
        this.vis_km = vis_km;
        this.vis_miles = vis_miles;
        this.gust_kph = gust_kph;
        this.gust_mph = gust_mph;
        this.uv = uv;
}
    }
