package com.apextech.infinitynewdawn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apextech.infinitynewdawn.R;

public class FactoryWeighmentAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.factory_weighments_row_item, parent, false);
        FactoryWeighmentViewHolder factoryWeighmentViewHolder = new FactoryWeighmentViewHolder(listItem);
        return factoryWeighmentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}

class FactoryWeighmentViewHolder extends RecyclerView.ViewHolder {
    public FactoryWeighmentViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}

