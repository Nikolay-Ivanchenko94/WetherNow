package com.example.wethernow.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.wethernow.R;
import com.example.wethernow.databinding.FragmentCityWeatherBinding;


public class CityWeatherFragment extends Fragment {

    private FragmentCityWeatherBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCityWeatherBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }
}