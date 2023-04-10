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
import com.apextech.infinitynewdawn.adapters.FactoryWeighmentAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FactoryWeighmentsActivity extends AppCompatActivity {

    private RecyclerView rvFactoryWeighments;
    private ImageButton btnDailyWeighmentRow, btnDailySundryRow, btnDailyf2fRow, btnBoughtLeafRow, btnChecklistSundryRow, btnChecklistPluckingRow;
    private ImageButton btnHome, btnBack;
    private ImageButton btnFilter;
    private SlidingDrawer slidingDrawer;
    private TextView txtDate;
    private Calendar myCalendar = Calendar.getInstance();
    private Spinner spinnerEstateFilter, spinnerDivisionFilter;
    private Button btnSDok, btnSDdefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_weighments);

        //Sliding Drawer
        btnFilter = findViewById(R.id.btnFilter_factory_weighments);
        slidingDrawer = findViewById(R.id.slidingDrawer_factory_weighments);

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateOpen();
            }
        });

        //Spinner Filter with Dummy data
        spinnerEstateFilter = findViewById(R.id.spinnerEstates_factory_weighments);
        spinnerDivisionFilter = findViewById(R.id.spinnerDivisions_factory_weighments);

        spinnerEstateFilter = findViewById(R.id.spinnerEstates_factory_weighments);
        String[] estates = new String[]{"All Estates", "Ragalla", "High Forest"};

        ArrayAdapter<String> estateFilterAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, estates);
        spinnerEstateFilter.setAdapter(estateFilterAdapter);

        spinnerDivisionFilter = findViewById(R.id.spinnerDivisions_factory_weighments);
        String[] divisions = new String[]{"All Divisions", "Division 1", "Division 2", "Division 3"};

        ArrayAdapter<String> divisionFilterAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, divisions);
        spinnerDivisionFilter.setAdapter(divisionFilterAdapter);

        btnSDok = findViewById(R.id.btnSDok_factory_weighments);
        btnSDok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateClose();
            }
        });

        btnSDdefault = findViewById(R.id.btnSDdefault_factory_weighments);
        btnSDdefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerEstateFilter.setSelection(0);
                spinnerDivisionFilter.setSelection(0);
            }
        });

        //Recycler View with it's Adapter
        rvFactoryWeighments = findViewById(R.id.rvFactoryWeighment_activity_factory_weighment);

        FactoryWeighmentAdapter factoryWeighmentAdapter = new FactoryWeighmentAdapter();

        rvFactoryWeighments.setHasFixedSize(true);
        rvFactoryWeighments.setLayoutManager(new LinearLayoutManager(this));
        rvFactoryWeighments.setAdapter(factoryWeighmentAdapter);

        btnDailyWeighmentRow = findViewById(R.id.btnDailyWeighmentRow_activity_factory_weighment);
        btnDailyWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyWeighmentIntent = new Intent(v.getContext(), AllDivisionsDailyWeighmentActivity.class);
                dailyWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyWeighmentIntent);
            }
        });

        //Date Filter
        txtDate = findViewById(R.id.txtDate_activity_factory_weighments);
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

        //Bottom Row Image Buttons
        btnDailySundryRow = findViewById(R.id.btnDailySundryRow_activity_factory_weighment);
        btnDailySundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailySundryIntent = new Intent(v.getContext(), AllDivisionsDailySundryActivities.class);
                dailySundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailySundryIntent);
            }
        });

        btnDailyf2fRow = findViewById(R.id.btnDailyF2FWeighmentRow_activity_factory_weighment);
        btnDailyf2fRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyF2FIntent = new Intent(v.getContext(), AllDivisionsDailyF2FWeighmentActivity.class);
                dailyF2FIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyF2FIntent);
            }
        });

        btnBoughtLeafRow = findViewById(R.id.btnBoughtLeafRow_activity_daily_factory_weighment);
        btnBoughtLeafRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent boughtLeafIntent = new Intent(v.getContext(), BoughtLeafActivity.class);
                boughtLeafIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(boughtLeafIntent);
            }
        });

        btnChecklistSundryRow = findViewById(R.id.btnChecklistSundryRow_activity_factory_weighment);
        btnChecklistSundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistSundryIntent = new Intent(v.getContext(), ChecklistSundryActivity.class);
                checklistSundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistSundryIntent);
            }
        });

        btnChecklistPluckingRow = findViewById(R.id.btnChecklistPluckingRow_activity_factory_weighment);
        btnChecklistPluckingRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistPluckingIntent = new Intent(v.getContext(), ChecklistPluckingActivity.class);
                checklistPluckingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistPluckingIntent);
            }
        });

        btnHome = findViewById(R.id.imgbtnHome_activity_factory_weighment);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), DashboardActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });

        btnBack = findViewById(R.id.btnBack_activity_factory_weighments);
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
    private void updateDate() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        txtDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    //Configure what happens on Back pressed
    @Override
    public void onBackPressed() {

    }
}