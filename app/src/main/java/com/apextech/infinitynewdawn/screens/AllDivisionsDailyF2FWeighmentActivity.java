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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apextech.infinitynewdawn.R;
import com.apextech.infinitynewdawn.adapters.DailyF2FWeighmentAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AllDivisionsDailyF2FWeighmentActivity extends AppCompatActivity {

    //Initialize Variables

    private RecyclerView rvDailyF2FWeighment;
    private ImageButton btnDailyWeighmentRow, btnDailySundryRow, btnBoughtLeafRow, btnFactoryWeighmentRow, btnChecklistSundryRow, btnChecklistPluckingRow;
    private ImageButton btnHome, btnBack, btnFilter;
    private SlidingDrawer slidingDrawer;
    private TextView txtDate;
    private Calendar myCalendar = Calendar.getInstance();
    private Spinner spinnerDivisionFilter;
    private Button btnSDok, btnSDdefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_divisions_daily_f2f_weighment);

        //Sliding Drawer
        slidingDrawer = findViewById(R.id.slidingDrawer_activity_daily_f2f);
        btnFilter = findViewById(R.id.btnfilter_activity_daily_f2f);

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateOpen();
            }
        });

        //Spinner Filters with Dummy Data
        spinnerDivisionFilter = findViewById(R.id.spinnerDivision_daily_f2f_activity);
        String[] divisions = new String[]{"All Divisions", "Division 1", "Division 2", "Division 3"};

        ArrayAdapter<String> filterAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, divisions);
        spinnerDivisionFilter.setAdapter(filterAdapter);

        btnSDok = findViewById(R.id.btnSDok_daily_f2f);
        btnSDok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateClose();
            }
        });

        btnSDdefault = findViewById(R.id.btnSDdefault_daily_f2f);
        btnSDdefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDivisionFilter.setSelection(0);
            }
        });

        //RecyclerView and Adapters related
        DailyF2FWeighmentAdapter dailyF2FWeighmentAdapter = new DailyF2FWeighmentAdapter();

        rvDailyF2FWeighment = findViewById(R.id.rvDailyF2FWeighment_activity_all_divisions_daily_f2f_weighment);
        rvDailyF2FWeighment.setHasFixedSize(true);
        rvDailyF2FWeighment.setLayoutManager(new LinearLayoutManager(this));
        rvDailyF2FWeighment.setAdapter(dailyF2FWeighmentAdapter);

        txtDate = findViewById(R.id.txtDate_activity_daily_F2F);
        txtDate.setText(String.valueOf(myCalendar.get(Calendar.DATE) + " /" + (myCalendar.get(Calendar.MONTH) + 1) + " /" + myCalendar.get(Calendar.YEAR)));

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
        btnDailyWeighmentRow = findViewById(R.id.btnDailyWeighmentRow_activity_daily_f2f_weighment);
        btnDailyWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyWeighmentIntent = new Intent(v.getContext(), AllDivisionsDailyWeighmentActivity.class);
                dailyWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyWeighmentIntent);
            }
        });

        btnDailySundryRow = findViewById(R.id.btnDailySundryRow_activity_daily_f2f_weighment);
        btnDailySundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailySundryIntent = new Intent(v.getContext(), AllDivisionsDailySundryActivities.class);
                dailySundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailySundryIntent);
            }
        });

        btnBoughtLeafRow = findViewById(R.id.btnBoughtLeafRow_activity_daily_f2f_weighment);
        btnBoughtLeafRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent boughtLeafIntent = new Intent(v.getContext(), BoughtLeafActivity.class);
                boughtLeafIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(boughtLeafIntent);
            }
        });

        btnFactoryWeighmentRow = findViewById(R.id.btnFactoryWeighmentRow_activity_daily_f2f_weighment);
        btnFactoryWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent factoryWeighmentIntent = new Intent(v.getContext(), FactoryWeighmentsActivity.class);
                factoryWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(factoryWeighmentIntent);
            }
        });

        btnChecklistSundryRow = findViewById(R.id.btnChecklistSundryRow_activity_daily_f2f_weighment);
        btnChecklistSundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistSundryIntent = new Intent(v.getContext(), ChecklistSundryActivity.class);
                checklistSundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistSundryIntent);
            }
        });

        btnChecklistPluckingRow = findViewById(R.id.btnChecklistPluckingRow_activity_daily_f2f_weighment);
        btnChecklistPluckingRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistPluckingIntent = new Intent(v.getContext(), ChecklistPluckingActivity.class);
                checklistPluckingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistPluckingIntent);
            }
        });

        btnHome = findViewById(R.id.imgbtnHome_activity_daily_f2f_weighment);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), DashboardActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });

        btnBack = findViewById(R.id.btnBack_activity_daily_f2f_weighment);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //Date Format
    private void updateDate() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        txtDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    //Configure what happens on physical button back pressed
    @Override
    public void onBackPressed() {

    }
}