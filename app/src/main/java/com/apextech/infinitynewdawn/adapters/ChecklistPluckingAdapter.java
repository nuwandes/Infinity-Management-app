package com.apextech.infinitynewdawn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apextech.infinitynewdawn.R;

public class ChecklistPluckingAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.checklist_plucking_row_item, parent, false);
        ChecklistPluckingViewHolder checklistPluckingViewHolder = new ChecklistPluckingViewHolder(listItem);
        return checklistPluckingViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 25;
    }
}
class ChecklistPluckingViewHolder extends RecyclerView.ViewHolder {

    public ChecklistPluckingViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}