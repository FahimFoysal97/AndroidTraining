package com.example.androidtraining.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.androidtraining.FragmentsActivity;
import com.example.androidtraining.databinding.FragmentFiveBinding;

public class FragmentFive extends Fragment {
    private PassData passData;
    private FragmentFiveBinding binding;

    public FragmentFive() {
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
        binding = FragmentFiveBinding.inflate(inflater, container, false);
        initUI();
        return binding.getRoot();
    }

    private void initUI() {
        if (getArguments() != null) {
            String message = "String type message: " + getArguments().getChar("To" + getClass().getSimpleName());
            binding.fragmentFiveText.setText(message);
        }

        binding.buttonFragmentFiveSendResponse.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putChar("From" + getClass().getSimpleName(), 'B');
            passData.passData(bundle, this);
        });
    }
}