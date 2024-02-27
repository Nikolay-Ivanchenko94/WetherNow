package com.example.wethernow.models.modelsforecast;

import com.example.wethernow.models.weather.Condition;

public class Day {
    private double maxtemp_c;
    private double maxtemp_f;
    private double mintemp_c;
    private double mintemp_f;
    private double avgtemp_c;
    private double avgtemp_f;
    private double maxwind_mph;
    private double maxwind_kph;
    private double totalprecip_mm;
    private double totalprecip_in;
    private double totalsnow_cm;
    private double avgvis_km;
    private double avgvis_miles;
    private double avghumidity;
    private int daily_will_it_rain;
    private int daily_chance_of_rain;
    private int daily_will_it_snow;
    private int daily_chance_of_snow;
    private Condition condition;
    private double uv;


    public double getMaxtemp_c(){
        return maxtemp_c;
    }
    public void setMaxtemp_c(){
        this.maxtemp_c = maxtemp_c;
    }
    public double getMaxtemp_f(){
        return maxtemp_f;
    }
    public void setMaxtemp_f(){
        this.maxtemp_f = maxtemp_f;
    }
    public double getMintemp_c(){
        return mintemp_c;
    }
    public void setMintemp_c(){
        this.mintemp_c = mintemp_c;
    }
    public double getMintemp_f(){
        return mintemp_f;
    }
    public void setMintemp_f(){
        this.mintemp_f = mintemp_f;
    }
    public double getAvgtemp_c(){
        return avgtemp_c;
    }
    public void setAvgtemp_c(){
        this.avgtemp_c = avgtemp_c;
    }
    public double getAvgtemp_f(){
        return avgtemp_f;
    }
    public void setAvgtemp_f(){
        this.avgtemp_f = avgtemp_f;
    }
    public double getMaxwind_mph(){
        return maxwind_mph;
    }
    public void setMaxwind_mph(){
        this.maxwind_mph = maxwind_mph;
    }
    public double getMaxwind_kph(){
        return  maxwind_kph;
    }
    public void setMaxwind_kph(){
        this.maxwind_kph = maxwind_kph;
    }
    public double getTotalprecip_mm(){
        return totalprecip_mm;
    }
    public void setTotalprecip_mm(){
        this.totalprecip_mm = totalprecip_mm;
    }
    public double getTotalprecip_in(){
        return  totalprecip_in;
    }
    public void setTotalprecip_in(){
        this.totalprecip_in = totalprecip_in;
    }
    public double getTotalsnow_cm(){
        return totalsnow_cm;
    }
    public void setTotalsnow_cm(){
        this.totalsnow_cm = totalsnow_cm;
    }
    public double getAvgvis_km(){
        return avgvis_km;
    }
    public void setAvgvis_km(){
        this.avgvis_km = avgvis_km;
    }
    public double getAvgvis_miles(){
        return avgvis_miles;
    }
    public void setAvgvis_miles(){
        this.avgvis_miles = avgvis_miles;
    }
    public double getAvghumidity(){
        return avghumidity;
    }
    public void setAvghumidity(){
        this.avghumidity = avghumidity;
    }
    public int getDaily_will_it_rain(){
        return daily_will_it_rain;
    }
    public void setDaily_will_it_rain(){
        this.daily_will_it_rain = daily_will_it_rain;
    }
    public int getDaily_chance_of_rain(){
        return daily_chance_of_rain;
    }
    public void setDaily_chance_of_rain(){
        this.daily_will_it_rain = daily_will_it_rain;
    }
    public int getDaily_will_it_snow(){
        return daily_will_it_snow;
    }
    public void setDaily_will_it_snow(){
        this.daily_will_it_snow = daily_will_it_snow;
    }
    public int getDaily_chance_of_snow(){
        return daily_chance_of_snow;
    }
    public Condition getCondition(){
        return condition;
    }
    public void setCondition(){
        this.condition = condition;
    }
    public double getUv(){
        return uv;
    }
    public void setuv(){
        this.uv = uv;
    }
    public Day(double maxtemp_c, double maxtemp_f, double mintemp_c,
               double mintemp_f, double avgtemp_c, double avgtemp_f,
               double maxwind_mph, double maxwind_kph, double totalprecip_mm,
               double totalprecip_in, double totalsnow_cm, double avgvis_km,
               double avgvis_miles, double avghumidity, int daily_will_it_rain,
               int daily_chance_of_rain, int daily_will_it_snow, int daily_chance_of_snow, double uv) {



               this.maxtemp_c = maxtemp_c;
               this.maxtemp_f = maxtemp_f;
               this.mintemp_c = mintemp_c;
               this.mintemp_f = mintemp_f;
               this.avgtemp_c = avgtemp_c;
               this.avgtemp_f = avgtemp_f;
               this.maxwind_mph = maxwind_mph;
               this.maxwind_kph = maxwind_kph;
               this.totalprecip_mm = totalprecip_mm;
               this.totalprecip_in = totalprecip_in;
               this.totalsnow_cm = totalsnow_cm;
               this.avgvis_km = avgvis_km;
               this.avgvis_miles = avgvis_miles;
               this.avghumidity = avghumidity;
               this.daily_will_it_rain = daily_will_it_rain;
               this.daily_chance_of_rain = daily_chance_of_rain;
               this.daily_will_it_snow = daily_will_it_snow;
               this.daily_chance_of_snow = daily_chance_of_snow;
    }
   }


