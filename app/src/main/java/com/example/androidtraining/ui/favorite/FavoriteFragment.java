package com.example.androidtraining.ui.favorite;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidtraining.R;
import com.example.androidtraining.ui.favorite.adapter.ListAdapter;
import com.example.androidtraining.ui.favorite.model.Photograph;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {

    private static final String TAG = "Favorite Fragment";
    private FavoriteViewModel mViewModel;
    private RecyclerView recyclerView;
    private final String[] photographNames = {"Android1", "Android2", "Android3"};
    private final String[] photographers = {"Photographer of Android1", "Photographer of Android2", "Photographer of Android3"};
    private final int[] images = {R.drawable.ic_android1, R.drawable.ic_android2, R.drawable.ic_android3};
    List<Photograph> photographList = new ArrayList<>();

    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite, container, false);
        initUI(rootView);
        getData();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);
        // TODO: Use the ViewModel
    }

    void initUI(View rootView){
        recyclerView = rootView.findViewById(R.id.favorites_fragment_recyclerview);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    void getData(){
        for(int i=0; i< photographNames.length; i++){
            photographList.add(new Photograph(photographNames[i], photographers[i], images[i]));
        }
        //Log.i(TAG, "getData: "+photographList.get(0).getName());
        generateList();
    }

    private void generateList() {
        recyclerView.setAdapter(new ListAdapter(getContext() ,photographList));
        //Log.i(TAG, "generateList: "+recyclerView);
    }

}