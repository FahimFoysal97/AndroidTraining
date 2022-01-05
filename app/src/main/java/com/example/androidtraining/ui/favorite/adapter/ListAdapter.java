package com.example.androidtraining.ui.favorite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining.R;
import com.example.androidtraining.ui.favorite.model.Photograph;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    Context context;
    List<Photograph> photographList;

    public ListAdapter(Context context, List<Photograph> photographList){
        this.context = context;
        this.photographList = photographList;
    }

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.photograph_adapter_layout, null);
        return new ListAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, int position) {
        Photograph photograph = photographList.get(position);
        holder.textViewName.setText(photograph.getName());
        holder.textViewPhotographer.setText(photograph.getPhotographerName());
        holder.imageViewPhotograph.setImageResource(photograph.getImage());
    }

    @Override
    public int getItemCount() {
        return photographList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName, textViewPhotographer;
        //TextView textViewPhotographer;
        ImageView imageViewPhotograph;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.photograph_name);
            textViewPhotographer = itemView.findViewById((R.id.photographer_name));
            imageViewPhotograph = itemView.findViewById(R.id.photograph_image);
        }
    }
}
