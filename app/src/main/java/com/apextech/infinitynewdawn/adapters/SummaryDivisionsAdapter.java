package com.apextech.infinitynewdawn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apextech.infinitynewdawn.R;

public class SummaryDivisionsAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.summary_details_layout, parent, false);
        SummaryDivisionViewHolder summaryDivisionViewHolder = new SummaryDivisionViewHolder(listItem);
        return summaryDivisionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

class SummaryDivisionViewHolder extends RecyclerView.ViewHolder {

    TextView txtDivisionName;

    public SummaryDivisionViewHolder(@NonNull View itemView) {
        super(itemView);

        this.txtDivisionName = (TextView) itemView.findViewById(R.id.txt_DivisionName_summary_details_layout);

        txtDivisionName.setText("Lower Division");

    }
}
