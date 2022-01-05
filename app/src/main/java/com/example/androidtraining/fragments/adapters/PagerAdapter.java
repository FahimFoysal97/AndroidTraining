package com.example.androidtraining.fragments.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.androidtraining.FragmentsActivity;
import com.example.androidtraining.fragments.model.Person;

public class PagerAdapter extends FragmentPagerAdapter {
    private final int totalTabs;
    private final FragmentsActivity activity;

    public PagerAdapter(FragmentsActivity activity, FragmentManager fragmentManager, int totalTabs) {
        super(fragmentManager);
        this.activity = activity;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return activity.getFragmentFromFragmentList(position);
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public void sendMessageToTheFragment(Fragment fragment, String message) {
        Bundle bundle = new Bundle();
        bundle.putString("To" + fragment.getClass().getSimpleName(), message);
        fragment.setArguments(bundle);
    }

    public void sendMessageToTheFragment(Fragment fragment, int message) {
        Bundle bundle = new Bundle();
        bundle.putInt("To" + fragment.getClass().getSimpleName(), message);
        fragment.setArguments(bundle);
    }

    public void sendMessageToTheFragment(Fragment fragment, boolean message) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("To" + fragment.getClass().getSimpleName(), message);
        fragment.setArguments(bundle);
    }

    public void sendMessageToTheFragment(Fragment fragment, char message) {
        Bundle bundle = new Bundle();
        bundle.putChar("To" + fragment.getClass().getSimpleName(), message);
        fragment.setArguments(bundle);
    }

    public void sendMessageToTheFragment(Fragment fragment, Person message) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("To" + fragment.getClass().getSimpleName(), message);
        fragment.setArguments(bundle);
    }
}
