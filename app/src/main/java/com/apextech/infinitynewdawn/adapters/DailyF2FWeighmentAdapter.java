package com.apextech.infinitynewdawn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apextech.infinitynewdawn.R;

public class DailyF2FWeighmentAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.daily_f2f_weighment_row_item, parent, false);
        DailyF2FWeighmentViewHolder dailyF2FWeighmentViewHolder = new DailyF2FWeighmentViewHolder(listItem);
        return dailyF2FWeighmentViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

class DailyF2FWeighmentViewHolder extends RecyclerView.ViewHolder {

    public DailyF2FWeighmentViewHolder(@NonNull View itemView) {
        super(itemView);
    }

}

