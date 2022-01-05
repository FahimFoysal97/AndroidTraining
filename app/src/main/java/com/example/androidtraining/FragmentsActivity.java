package com.example.androidtraining;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.androidtraining.databinding.ActivityFragmentsBinding;
import com.example.androidtraining.fragments.FragmentFive;
import com.example.androidtraining.fragments.FragmentFour;
import com.example.androidtraining.fragments.FragmentOne;
import com.example.androidtraining.fragments.FragmentThree;
import com.example.androidtraining.fragments.FragmentTwo;
import com.example.androidtraining.fragments.PassData;
import com.example.androidtraining.fragments.adapters.PagerAdapter;
import com.example.androidtraining.fragments.model.Person;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FragmentsActivity extends AppCompatActivity implements PassData {
    private static final String TAG = "FragmentsActivity";
    private ActivityFragmentsBinding activityFragmentsBinding;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private final List<Fragment> fragmentList = new ArrayList<>();
    private TabLayout tabLayout;

    @Override
    protected void onStart() {
        super.onStart();
        pagerAdapter.sendMessageToTheFragment(getFragmentFromFragmentList(0), "Message for FragmentOne");
        pagerAdapter.sendMessageToTheFragment(getFragmentFromFragmentList(1), 100);
        pagerAdapter.sendMessageToTheFragment(getFragmentFromFragmentList(2), true);
        pagerAdapter.sendMessageToTheFragment(getFragmentFromFragmentList(3), new Person("Foysal", 11428, true));
        pagerAdapter.sendMessageToTheFragment(getFragmentFromFragmentList(4), 'B');
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFragmentsBinding = ActivityFragmentsBinding.inflate(getLayoutInflater());
        setContentView(activityFragmentsBinding.getRoot());
        initUI();
    }

    private void initUI() {
        instantiateFragmentObjects();
        tabLayout = activityFragmentsBinding.fragmentsLayoutTabLayout;
        viewPager = activityFragmentsBinding.fragmentsLayoutTabView;
        addTabsToTabLayout();
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        pagerAdapter = new PagerAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        //assignFragmentsToTheLayout();
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        sendMessageToTheFragments();
    }

    private void instantiateFragmentObjects() {
        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());
        fragmentList.add(new FragmentThree());
        fragmentList.add(new FragmentFour());
        fragmentList.add(new FragmentFive());
    }

    private void addTabsToTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Frag1").setIcon(R.drawable.ic_frag1));
        tabLayout.addTab(tabLayout.newTab().setText("Frag2").setIcon(R.drawable.ic_frag2));
        tabLayout.addTab(tabLayout.newTab().setText("Frag3").setIcon(R.drawable.ic_frag3));
        tabLayout.addTab(tabLayout.newTab().setText("Frag4").setIcon(R.drawable.ic_frag4));
        tabLayout.addTab(tabLayout.newTab().setText("Frag5").setIcon(R.drawable.ic_frag5));
    }

    private void assignFragmentsToTheLayout() {
        for (int i = 0; i < fragmentList.size(); i++)
            initiateFragmentTransaction(getFragmentFromFragmentList(i), R.id.fragments_layout_tab_view);
    }

    private void sendMessageToTheFragments() {
        pagerAdapter.sendMessageToTheFragment(getFragmentFromFragmentList(0), "");
        pagerAdapter.sendMessageToTheFragment(getFragmentFromFragmentList(1), 0);
        pagerAdapter.sendMessageToTheFragment(getFragmentFromFragmentList(2), false);
        pagerAdapter.sendMessageToTheFragment(getFragmentFromFragmentList(3), new Person());
        pagerAdapter.sendMessageToTheFragment(getFragmentFromFragmentList(4), 'b');
    }

    private void sendMessageToTheFragment(Fragment fragment, String message) {
        Bundle bundle = new Bundle();
        bundle.putString("To" + fragment.getClass().getSimpleName(), message);
        fragment.setArguments(bundle);
    }

    private void sendMessageToTheFragment(Fragment fragment, int message) {
        Bundle bundle = new Bundle();
        bundle.putInt("To" + fragment.getClass().getSimpleName(), message);
        fragment.setArguments(bundle);
    }

    private void sendMessageToTheFragment(Fragment fragment, boolean message) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("To" + fragment.getClass().getSimpleName(), message);
        fragment.setArguments(bundle);
    }

    private void sendMessageToTheFragment(Fragment fragment, char message) {
        Bundle bundle = new Bundle();
        bundle.putChar("To" + fragment.getClass().getSimpleName(), message);
        fragment.setArguments(bundle);
    }

    private void sendMessageToTheFragment(Fragment fragment, Person message) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("To" + fragment.getClass().getSimpleName(), message);
        fragment.setArguments(bundle);
    }

    public Fragment getFragmentFromFragmentList(int position) {
        return fragmentList.get(position);
    }

    private void initiateFragmentTransaction(Fragment fragment, int container) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void passData(Bundle bundle, Fragment fragment) {
        if (bundle != null) {
            Object obj = bundle.get("From" + fragment.getClass().getSimpleName());
            Log.i(TAG, "From: " + fragment.getClass().getSimpleName() +
                    "\nType: " + obj.getClass().getSimpleName() + "\nResponse: " + obj);
        }
    }
}