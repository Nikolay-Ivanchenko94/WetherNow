package com.example.wethernow.modelsforecast;

import java.util.List;

public class Forecastday {
   private String date;
   private Long date_epoch;
   private Day day;
    private Astro astro;
    List<Hour> hour;
   private Condition condition;

   public Forecastday(Day day, Astro astro, Condition condition) {
       this.astro = astro;
       this.day = day;
       this.condition = condition;
   }

   public String getDate() {
    return date;
   }
   public void setDate(String date) {
    this.date = date;
   }
   public Long getDate_epoch() {
    return date_epoch;
   }
   public void setDate_epoch(String date_epoch1) {
    this.date_epoch = date_epoch;
   }
   public Day getDay(){
       return day;
   }
  public void setDay(){
       this.day = day;
  }
  public Astro getAstro(){
       return astro;
  }
  public void setAstro(){
       this.astro = astro;
  }

  public List<Hour> getHour(){
       return hour;
  }
  public void setHour(List<Hour> hour) {
       this.hour = hour;
  }

  public Condition getCondition(){
       return condition;
  }
  public void setCondition(){
       this.condition = condition;
  }
}
