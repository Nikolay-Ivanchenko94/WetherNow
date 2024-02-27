package com.example.wethernow.models.weather;

public class Condition {

    private String text;
    private String icon;
    private int code;



    public String getText() {
        return text;
    }
    public void setText() {
        this.text = text;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon () {
        this.icon = icon;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
}
