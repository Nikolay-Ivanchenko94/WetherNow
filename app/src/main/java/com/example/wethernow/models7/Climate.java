package com.example.wethernow.models7;
public class Climate {
    private Current current;
    private Location location;

    public Climate(Current current1) {
        this.current = current1;
        this.location = location;
    }
    public Current getCurrent() {
        return current;
    }
    public void setCurrent(Current current) {
        this.current = current;
    }

    public Location getLocation1() {
        return location;
    }

    public void Location1(Location location1) {
        this.location = location;
    }
}
