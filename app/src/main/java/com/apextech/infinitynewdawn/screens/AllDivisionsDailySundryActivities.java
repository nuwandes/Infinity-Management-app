package com.apextech.infinitynewdawn.screens;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.SlidingDrawer;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apextech.infinitynewdawn.R;
import com.apextech.infinitynewdawn.adapters.DailySundryAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AllDivisionsDailySundryActivities extends AppCompatActivity {

    //Initialize Variables

    private RecyclerView rvDailySundry;
    private SearchView searchViewSundry;
    private TextView txtDate;
    private ImageButton btnDailyWeighmentRow, btnDailyf2fRow, btnBoughtLeafRow, btnFactoryWeighmentRow, btnChecklistSundryRow, btnChecklistPluckingRow;
    private ImageButton btnHome, btnBack;
    private Calendar calendar = Calendar.getInstance();
    private SlidingDrawer slidingDrawer;
    private ImageButton btnFilter;
    private Spinner spinnerDivisionFilter;
    private Button btnSDok, btnSDdefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_divisions_daily_sundry_activities);

        //Sliding Drawer
        slidingDrawer = findViewById(R.id.slidingDrawer_daily_sundry);
        btnFilter = findViewById(R.id.btnFilter_daily_sundry);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateOpen();
            }
        });

        //Spinners for the filters
        spinnerDivisionFilter = findViewById(R.id.spinnerDivision_daily_sundry_activity);
        String[] divisions = new String[]{"All Divisions", "Division 1", "Division 2", "Division 3"};

        ArrayAdapter<String> filterAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, divisions);
        spinnerDivisionFilter.setAdapter(filterAdapter);

        btnSDok = findViewById(R.id.btnSDok_daily_sundry);
        btnSDok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateClose();
            }
        });

        btnSDdefault = findViewById(R.id.btnSDdefault_daily_sundry);
        btnSDdefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDivisionFilter.setSelection(0);
            }
        });

        //Search bar
        searchViewSundry = findViewById(R.id.searchView_activity_all_divisions_daily_sundry_activities);

        //RecyclerView and it's adapters
        DailySundryAdapter dailySundryAdapter = new DailySundryAdapter();

        rvDailySundry = findViewById(R.id.rvDailySundry_activity_all_divisions_daily_sundry);
        rvDailySundry.setHasFixedSize(true);
        rvDailySundry.setLayoutManager(new LinearLayoutManager(this));
        rvDailySundry.setAdapter(dailySundryAdapter);

        //Date filter
        txtDate = findViewById(R.id.txtDate_activity_daily_sundry);
        txtDate.setText(String.valueOf(calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR)));

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                updateDate();
            }
        };
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(v.getContext(), date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //Bottom Row Image Button Intents
        btnDailyWeighmentRow = findViewById(R.id.btnDailyWeighmentRow_activity_daily_sundry);
        btnDailyWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyWeighmentIntent = new Intent(v.getContext(), AllDivisionsDailyWeighmentActivity.class);
                dailyWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyWeighmentIntent);
            }
        });

        btnDailyf2fRow = findViewById(R.id.btnDailyF2FWeighmentRow_activity_daily_sundry);
        btnDailyf2fRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyF2FIntent = new Intent(v.getContext(), AllDivisionsDailyF2FWeighmentActivity.class);
                dailyF2FIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyF2FIntent);
            }
        });

        btnBoughtLeafRow = findViewById(R.id.btnBoughtLeafRow_activity_daily_sundry);
        btnBoughtLeafRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent boughtLeafIntent = new Intent(v.getContext(), BoughtLeafActivity.class);
                boughtLeafIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(boughtLeafIntent);
            }
        });

        btnFactoryWeighmentRow = findViewById(R.id.btnFactoryWeighmentRow_activity_daily_sundry);
        btnFactoryWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent factoryWeighmentIntent = new Intent(v.getContext(), FactoryWeighmentsActivity.class);
                factoryWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(factoryWeighmentIntent);
            }
        });

        btnChecklistSundryRow = findViewById(R.id.btnChecklistSundryRow_activity_daily_sundry);
        btnChecklistSundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistSundryIntent = new Intent(v.getContext(), ChecklistSundryActivity.class);
                checklistSundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistSundryIntent);
            }
        });

        btnChecklistPluckingRow = findViewById(R.id.btnChecklistPluckingRow_activity_daily_sundry);
        btnChecklistPluckingRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistPluckingIntent = new Intent(v.getContext(), ChecklistPluckingActivity.class);
                checklistPluckingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistPluckingIntent);
            }
        });

        btnHome = findViewById(R.id.imgbtnHome_activity_daily_sundry);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), DashboardActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });

        btnBack = findViewById(R.id.btnBack_activity_daily_sundry);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    //Date Format
    public void updateDate() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        txtDate.setText(dateFormat.format(calendar.getTime()));
    }

    //Configure what happens on physical button back pressed
    @Override
    public void onBackPressed() {

    }
}