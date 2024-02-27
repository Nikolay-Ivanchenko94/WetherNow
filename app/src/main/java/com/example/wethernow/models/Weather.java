package com.example.wethernow.models;

public class Weather {
    public char[] getString;
    private Location location;
    private Current current;


    public Weather(Location location, Current current) {
        this.current = current;
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }
    public void  setLocation(Location location) {
        this.location = location;
    }
    public Current getCurrent() {
        return current;
    }
    public void setCurrent(Current current) {
        this.current = current;
    }

    public char[] getString(int cloudy) {
        return new char[0];
    }
}
