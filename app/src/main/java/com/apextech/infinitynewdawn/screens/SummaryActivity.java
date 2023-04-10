package com.apextech.infinitynewdawn.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import com.apextech.infinitynewdawn.R;
import com.apextech.infinitynewdawn.adapters.SummaryDivisionsAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SummaryActivity extends AppCompatActivity {

    private Button btnDashboard;
    private TextView txtDate;
    private Calendar myCalendar = Calendar.getInstance();
    private RecyclerView rvSummaryDivisions;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        btnDashboard = findViewById(R.id.btnDashboard_activity_summary);
        btnDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

        btnBack = findViewById(R.id.btnBack_activity_summary);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

        SummaryDivisionsAdapter summaryDivisionsAdapter = new SummaryDivisionsAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rvSummaryDivisions = findViewById(R.id.rv_summary_divisions);
        rvSummaryDivisions.setHasFixedSize(true);
        rvSummaryDivisions.setLayoutManager(linearLayoutManager);
        rvSummaryDivisions.setAdapter(summaryDivisionsAdapter);

        //Date Filter
        txtDate = findViewById(R.id.txtDate_activity_summary);
        txtDate.setText(String.valueOf(myCalendar.get(Calendar.DATE)+" /"+(myCalendar.get(Calendar.MONTH)+1)+" /"+myCalendar.get(Calendar.YEAR)));

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateDate();
            }
        };
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(v.getContext(), date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void openDashboard() {
        Intent dashboardIntent = new Intent(SummaryActivity.this, DashboardActivity.class);
        dashboardIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(dashboardIntent);
    }

    private void updateDate(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        txtDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    @Override
    public void onBackPressed(){

    }
}