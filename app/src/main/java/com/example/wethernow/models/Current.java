package com.example.wethernow.models;

public class Current {

    private long last_update_epoch;
    private String last_updated;
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
    private int humidity;
    private int cloud;
    private double feelslike_c;
    private double feelslike_f;
    private double vis_km;
    private double vis_mile;
    private double uv;
    private double gust_mph;
    private double gust_kph;


    public long getLast_update_epoch() {
        return last_update_epoch;
    }

    public void setLast_update_epoch(long last_update_epoch) {
        this.last_update_epoch = last_update_epoch;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String longUpdated) {
        this.last_updated = last_updated;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double setTemp_c) {
        this.temp_c = temp_c;
    }

    public double getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(double setTemp_f) {
        this.temp_f = temp_f;
    }

    public int getIs_day() {
        return is_day;
    }

    public void setIs_day(int is_day) {
        this.is_day = is_day;
    }
    public Current(Condition condition) {
        this.condition = condition;
    }
    public Condition getCondition() {
        return condition;
    }
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public double getWind_mph() {
        return wind_mph;
    }

    public void setWind_mph(double setWind_mph) {
        this.wind_mph = wind_mph;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(double setWind_kph) {
        this.wind_kph = wind_kph;
    }

    public int getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(int wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }
    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }
    public double getPressure_mb() {
        return pressure_mb;
    }
    public void setPressure_mb(double pressure_mb) {
        this.pressure_mb = pressure_mb;
    }
    public double getPressure_in (){
        return pressure_in;
    }
    public void setPressure_in(double pressure_in) {
        this.pressure_in = pressure_in;
    }
    public double getPrecip_mm () {
        return precip_mm;
    }
    public void setPrecip_mm(double precip_mm) {
        this.pressure_in = precip_mm;
    }
    public double getPrecip_in() {
        return precip_in;
    }
    public void setPrecip_in(double precip_in) {
        this.pressure_in = precip_in;
    }
    public int getHumidity() {
        return humidity;
    }
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public int getCloud() {
        return cloud;
    }
    public void setCloud(int cloud) {
        this.cloud = cloud;
    }
    public double getFeelslike_c() {
        return feelslike_c;
    }
    public void setFeelslike_c(double feelslike_c) {
        this.feelslike_c = feelslike_c;
    }
    public double getFeelslike_f() {
        return feelslike_f;
    }
    public void setFeelslike_f(double feelslike_f) {
        this.feelslike_f = feelslike_f;
    }
    public double getVis_km () {
        return vis_km;
    }
    public void setVis_km() {
        this.vis_km = vis_km;
    }
    public double getVis_mile() {
        return vis_mile;
    }
    public void setVis_mile(double vis_mile) {
        this.vis_mile = vis_mile;
    }
    public double getUv() {
        return uv;
    }
    public void setUv(double uv) {
        this.uv = uv;
    }
    public double getGust_mph() {
        return gust_mph;
    }
    public void setGust_mph(double gust_mph) {
        this.gust_mph = gust_mph;
    }
    public double getGust_kph() {
        return gust_kph;
    }
    public void setGust_kph(double gust_kph) {
        this.gust_kph = gust_kph;
    }
    public Current(long last_update_epoch, String last_updated, double temp_c, double temp_f, int is_day, double wind_mph,
                   double wind_kph, int wind_degree, String wind_dir, double
                           pressure_mb, double pressure_in, double precip_mm,
                   double precip_in, int humidity, int cloud, double feelslike_c, double feelslike_f, double vis_km
    , double vis_mile, double uv, double gust_mph, double gust_kph) {
       this.last_update_epoch = last_update_epoch;
       this.last_updated = last_updated;
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
       this.humidity = humidity;
       this.cloud = cloud;
       this.feelslike_c = feelslike_c;
       this.feelslike_f = feelslike_f;
       this.vis_km = vis_km;
       this.vis_mile = vis_mile;
       this.uv = uv;
       this.gust_mph = gust_mph;
       this.gust_kph = gust_kph;
    }
}
