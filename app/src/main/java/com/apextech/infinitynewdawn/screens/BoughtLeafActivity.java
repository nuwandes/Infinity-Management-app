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
import android.widget.SlidingDrawer;
import android.widget.TextView;

import com.apextech.infinitynewdawn.R;
import com.apextech.infinitynewdawn.adapters.BoughtLeafAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BoughtLeafActivity extends AppCompatActivity {

    private ImageButton btnDailyWeighmentRow, btnDailySundryRow, btnDailyf2fRow, btnFactoryWeighmentRow, btnChecklistSundryRow, btnChecklistPluckingRow;
    private ImageButton btnHome, btnBack;
    private ImageButton btnFilter;
    private RecyclerView rvBoughtLeaf;
    private SlidingDrawer slidingDrawer;
    private TextView txtDate;
    private Calendar myCalendar = Calendar.getInstance();
    private Button btnSDok, btnSDdefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bought_leaf);

        //Sliding Drawer
        slidingDrawer = findViewById(R.id.slidingDrawer_bought_leaf);
        btnFilter = findViewById(R.id.btnFilter_bought_leaf);

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateOpen();
            }
        });

        btnSDok = findViewById(R.id.btnSDok_bought_leaf);
        btnSDok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateClose();
            }
        });

        //Recycler View with it's adapter
        rvBoughtLeaf = findViewById(R.id.rvBoughtLeaf_activity_bought_leaf);
        BoughtLeafAdapter boughtLeafAdapter = new BoughtLeafAdapter();
        rvBoughtLeaf.setHasFixedSize(true);
        rvBoughtLeaf.setLayoutManager(new LinearLayoutManager(this));
        rvBoughtLeaf.setAdapter(boughtLeafAdapter);

        //Date Filter
        txtDate = findViewById(R.id.txtDate_activity_bought_leaf);
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

        //Bottom Row Image Button Intents
        btnDailyWeighmentRow = findViewById(R.id.btnDailyWeighmentRow_activity_bought_leaf);
        btnDailyWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyWeighmentIntent = new Intent(v.getContext(), AllDivisionsDailyWeighmentActivity.class);
                dailyWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyWeighmentIntent);
            }
        });

        btnDailySundryRow = findViewById(R.id.btnDailySundryRow_activity_bought_leaf);
        btnDailySundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailySundryIntent = new Intent(v.getContext(), AllDivisionsDailySundryActivities.class);
                dailySundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailySundryIntent);
            }
        });

        btnDailyf2fRow = findViewById(R.id.btnDailyF2FWeighmentRow_activity_bought_leaf);
        btnDailyf2fRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyF2FIntent = new Intent(v.getContext(), AllDivisionsDailyF2FWeighmentActivity.class);
                dailyF2FIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyF2FIntent);
            }
        });

        btnFactoryWeighmentRow = findViewById(R.id.btnFactoryWeighmentRow_activity_bought_leaf);
        btnFactoryWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent factoryWeighmentIntent = new Intent(v.getContext(), FactoryWeighmentsActivity.class);
                factoryWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(factoryWeighmentIntent);
            }
        });

        btnChecklistSundryRow = findViewById(R.id.btnChecklistSundryRow_activity_bought_leaf);
        btnChecklistSundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistSundryIntent = new Intent(v.getContext(), ChecklistSundryActivity.class);
                checklistSundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistSundryIntent);
            }
        });

        btnChecklistPluckingRow = findViewById(R.id.btnChecklistPluckingRow_activity_bought_leaf);
        btnChecklistPluckingRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistPluckingIntent = new Intent(v.getContext(), ChecklistPluckingActivity.class);
                checklistPluckingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistPluckingIntent);
            }
        });

        btnHome = findViewById(R.id.imgbtnHome_activity_bought_leaf);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), DashboardActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });

        btnBack = findViewById(R.id.btnBack_activity_bought_leaf);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), DashboardActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
    }

    //Date Format
    private void updateDate(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        txtDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    //Configure what happens on back pressed
    @Override
    public void onBackPressed() {

    }
}