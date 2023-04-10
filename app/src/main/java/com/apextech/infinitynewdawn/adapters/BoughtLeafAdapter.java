package com.apextech.infinitynewdawn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apextech.infinitynewdawn.R;

public class BoughtLeafAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.bought_leaf_row_item, parent,false);
        BoughtLeafViewHolder boughtLeafViewHolder = new BoughtLeafViewHolder(listItem);
        return boughtLeafViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
class BoughtLeafViewHolder extends RecyclerView.ViewHolder {

    public BoughtLeafViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}