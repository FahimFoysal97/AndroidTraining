package com.example.androidtraining.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.androidtraining.FragmentsActivity;
import com.example.androidtraining.databinding.FragmentFourBinding;
import com.example.androidtraining.fragments.model.Person;

public class FragmentFour extends Fragment {
    private PassData passData;
    private FragmentFourBinding binding;

    public FragmentFour() {
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
        binding = FragmentFourBinding.inflate(inflater, container, false);
        initUI();
        return binding.getRoot();
    }

    private void initUI() {
        if (getArguments() != null) {
            String message = "String type message: " + getArguments().getSerializable("To" + getClass().getSimpleName());
            binding.fragmentFourText.setText(message);
        }

        binding.buttonFragmentFourSendResponse.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("From" + getClass().getSimpleName(), new Person("Foysal", 11428, true));
            passData.passData(bundle, this);
        });
    }
}