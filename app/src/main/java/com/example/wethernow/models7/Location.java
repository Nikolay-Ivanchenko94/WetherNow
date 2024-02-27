package com.example.wethernow.models7;

public class Location {

    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String tz_id;
    private String locatime_epoch;
    private String localtime;


    public Location(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

    public String getregion() {
        return region;
    }
    public void setregion(String region) {
        this.region = region;
    }

    public String getcountry() {
        return  country;
    }
    public void setcountry(String country) {
        this.country = country;
    }
    public double getLat() {
        return lat;
    }
    public void setLat() {
        this.lat = lat;
    }
    public double getLon() {
        return  lon;
    }
    public void setLon() {
        this.lon = lon;
    }
    public String getTz_id() {
        return tz_id;
    }
    public void setTz_id() {
        this.tz_id = tz_id;
    }
    public String getLocaltime() {
        return localtime;
    }
    public void setLocaltime() {
        this.localtime = localtime;
    }
    public String getLocatime_epoch() {
        return  locatime_epoch;
    }
    public void setLocatime_epoch() {
        this.locatime_epoch = locatime_epoch;
    }
    public Location(String name, String region, String country, double lat, double lon, String tz_id, String locatime_epoch, String locatime) {
        this.country = country;
        this.name = name;
        this.region = region;
        this.lat = lat;
        this.lon = lon;
        this.tz_id = tz_id;
        this.locatime_epoch = locatime_epoch;
        this.localtime = locatime;
    }
}
