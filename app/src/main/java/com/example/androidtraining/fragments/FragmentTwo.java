package com.example.androidtraining.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.androidtraining.FragmentsActivity;
import com.example.androidtraining.databinding.FragmentTwoBinding;

public class FragmentTwo extends Fragment {
    private static final String TAG = FragmentTwo.class.getSimpleName();
    private PassData passData;
    private FragmentTwoBinding binding;

    public FragmentTwo() {
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
        binding = FragmentTwoBinding.inflate(inflater, container, false);
        initUI();
        return binding.getRoot();
    }

    private void initUI() {
        if (getArguments() != null) {
            String message = "Integer type message: " + getArguments().getInt("To" + getClass().getSimpleName());
            binding.fragmentTwoText.setText(message);
        }

        binding.buttonFragmentTwoSendResponse.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("From" + getClass().getSimpleName(), 100);
            passData.passData(bundle, this);
        });
    }
}