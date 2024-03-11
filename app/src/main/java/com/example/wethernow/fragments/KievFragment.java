package com.example.wethernow.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wethernow.R;
import com.example.wethernow.databinding.ActivityMainDniproBinding;
import com.example.wethernow.databinding.FragmentKievBinding;

public class KievFragment extends Fragment {

private FragmentKievBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentKievBinding.inflate(getLayoutInflater());
        binding = FragmentKievBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }



}