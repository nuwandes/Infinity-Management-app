package com.apextech.infinitynewdawn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apextech.infinitynewdawn.R;

public class DailySundryAdapter extends RecyclerView.Adapter {


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.daily_sundry_row_item, parent, false);
        DailySundryViewHolder dailySundryViewHolder = new DailySundryViewHolder(listItem);
        return dailySundryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 50;
    }
}

class DailySundryViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout llBackground;

    public DailySundryViewHolder(@NonNull View itemView) {
        super(itemView);

        this.llBackground = (LinearLayout) itemView.findViewById(R.id.llDailySundry_row_item);
    }
}
