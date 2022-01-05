package com.example.androidtraining.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.androidtraining.FragmentsActivity;
import com.example.androidtraining.databinding.FragmentThreeBinding;

public class FragmentThree extends Fragment {
    private static final String TAG = FragmentThree.class.getSimpleName();
    private PassData passData;
    private FragmentThreeBinding binding;

    public FragmentThree() {
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
        binding = FragmentThreeBinding.inflate(inflater, container, false);
        initUI();
        return binding.getRoot();
    }

    private void initUI() {
        if (getArguments() != null) {
            String message = "Boolean type message: " + getArguments().getBoolean("To" + getClass().getSimpleName());
            binding.fragmentThreeText.setText(message);
        }

        binding.buttonFragmentThreeSendResponse.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putBoolean("From" + getClass().getSimpleName(), true);
            passData.passData(bundle, this);
        });
    }
}