package com.example.androidtraining.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.androidtraining.FragmentsActivity;
import com.example.androidtraining.databinding.FragmentOneBinding;

public class FragmentOne extends Fragment {
    private static final String TAG = FragmentOne.class.getSimpleName();
    private PassData passData;
    private FragmentOneBinding binding;

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        passData = (FragmentsActivity) getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOneBinding.inflate(inflater, container, false);
        initUI();
        return binding.getRoot();
    }

    private void initUI() {
        if (getArguments() != null) {
            String message = "String type message: " + getArguments().getString("To" + getClass().getSimpleName());
            binding.fragmentOneText.setText(message);
        }

        binding.buttonFragmentOneSendResponse.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("From" + getClass().getSimpleName(), "Button pressed in " + getClass().getSimpleName());
            passData.passData(bundle, this);
        });
    }
}