package com.example.wethernow.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.example.wethernow.R;
import com.example.wethernow.adapters.HoursAdapter;
import com.example.wethernow.database.HourDB;
import com.example.wethernow.database.MyDataBase;
import com.example.wethernow.database.WeatherDB;
import com.example.wethernow.databinding.FragmentCityWeatherBinding;
import com.example.wethernow.models.modelsforecast.FutureForecast;
import com.example.wethernow.models.modelsforecast.Hour;
import com.example.wethernow.models.weather.Weather;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CityWeatherFragment extends Fragment {

    private FragmentCityWeatherBinding binding;
    private HoursAdapter hoursAdapters;
    private ApiService service;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
           binding = FragmentCityWeatherBinding.inflate(inflater,container,false);
           binding.btnmap.setOnClickListener(v-> {
            MapFragment mapFragment = new MapFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, mapFragment, "fidThisFragment").addToBackStack(null)
                    .commit();
       });
        binding.btn7NextDays.setOnClickListener(v -> {
            WeekWeatherFragment weekWeatherFragment = new WeekWeatherFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,weekWeatherFragment,"fingThisFagment").addToBackStack(null)
                    .commit();
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);



        requestCurrentWeather();
        initRecyclerView();
        requestHour();





        return binding.getRoot();


    }

    private void requestHour() {
        service.getForecastWeather().enqueue(new retrofit2.Callback<FutureForecast>() {
            @Override
            public void onResponse(retrofit2.Call<FutureForecast> call, retrofit2.Response<FutureForecast> response) {
                if (response.isSuccessful() && response.body() != null){
                    FutureForecast futureForecast = response.body();
                    ArrayList<Hour> hours = new ArrayList<>(futureForecast.getForecast().getForecastday().get(0).getHour());



                    MyDataBase db = Room.databaseBuilder(getActivity().getApplicationContext(),
                            MyDataBase.class, "database-name").build();


                    List<HourDB> hourDBList = new ArrayList<>();
                    for (Hour hour : hours) {
                        HourDB hourDB = new HourDB();
                        hourDB.setTime(hour.getTime());
                        hourDB.setTemp_c(hour.getTemp_c());
                        hourDB.setIcon(hour.getCondition().getIcon());
                        hourDBList.add(hourDB);
                    }
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.execute(() -> {
                        db.hourDao().insertHourDBList(hourDBList);
                        List<HourDB> hourDBS = db.hourDao().getHourDBList();
                        getActivity().runOnUiThread(() -> {
                            hoursAdapters.setItemsToAdapter(new ArrayList<>(hourDBS));
                        });
                    });
                }
            }

            @Override
            public void onFailure(Call<FutureForecast> call, Throwable t) {
                Log.d("ERROR", "error" + t.toString());
            }


        });
    }

    private void initRecyclerView() {
        binding.rvHourly.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,true));
        hoursAdapters = new HoursAdapter(new ArrayList<>());
         binding.rvHourly.setAdapter(hoursAdapters);
    }





    private void requestCurrentWeather() {
        service.getCurrentWeather().enqueue(new retrofit2.Callback<Weather>() {
            @Override
            public void onResponse(retrofit2.Call<Weather> call, retrofit2.Response<Weather> response) {
                if (response.isSuccessful() && response.body() != null){

                    MyDataBase myDataBase = Room.databaseBuilder(getActivity().getApplicationContext(),
                            MyDataBase.class, "database-name").build();


                    ArrayList<WeatherDB> weatherDBSList = new ArrayList<>();
                    Weather weather = response.body();
                    WeatherDB weatherDB = new WeatherDB();
                    weatherDB.setName(weather.getLocation().getname());
                    weatherDB.setLast_updated(weather.getCurrent().getLast_updated());
                    weatherDB.setText(weather.getCurrent().getCondition().getText());
                    weatherDB.setTemp_c(weather.getCurrent().getTemp_c());
                    weatherDB.setPrecip_in(weather.getCurrent().getPrecip_in());
                    weatherDB.setWind_degree(weather.getCurrent().getWind_degree());
                    weatherDB.setHumidity(weather.getCurrent().getHumidity());


                    weatherDBSList.add(weatherDB);

                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.execute(() -> {

                        myDataBase.weatherDao().insertWeatherDBList(weatherDBSList);
                        List<WeatherDB> weatherDBS = myDataBase.weatherDao().getWeatherDBS();
                        getActivity().runOnUiThread(() -> {
                            setDataToViews(weatherDB);
                        });
                    });

                }




            }


            @Override
            public void onFailure(retrofit2.Call<Weather> call, Throwable t) {
                Log.d("ERROR", "error" + t.toString());
            }
         });
    }

   private void setDataToViews(WeatherDB weather) {
        binding.tvDnipro.setText(String.valueOf(weather.getName()));
        Glide.with(CityWeatherFragment.this).load("https:" + weather.getIcon()).into(binding.ivSunnyCloudy);
        binding.tvSnow.setText(String.valueOf(weather.getText()));
        binding.tvDate.setText(String.valueOf(weather.getLast_updated()));
        binding.tvDegree.setText(String.valueOf(weather.getTemp_c() + "°"));
        binding.tvDegreeRain.setText(weather.getPrecip_in() + "%");
        binding.tvWindyDegree.setText(weather.getWind_degree() + "M/C");
        binding.tvHumidityDegree.setText(String.valueOf(weather.getHumidity() + "%"));

    }





    }


