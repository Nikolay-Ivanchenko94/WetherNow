package com.example.wethernow.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wethernow.R;
import com.example.wethernow.databinding.FragmentCityWeatherBinding;
import com.example.wethernow.databinding.FragmentWeekWeatherBinding;


public class WeekWeatherFragment extends Fragment {

    private FragmentWeekWeatherBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWeekWeatherBinding.inflate(inflater,container,false);
        return binding.getRoot();
        binding.Bnt7Days.setOnClickListener(v ->{Intent intent = new Intent(WeekWeatherFragment.this, CityWeatherFragment.class)});
        binding.BtnMap.setOnClickListener(v -> {Intent intent = new Intent(WeekWeatherFragment.this, MapFragment.class)});

    }
}
