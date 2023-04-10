package com.apextech.infinitynewdawn.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.apextech.infinitynewdawn.R;
import com.apextech.infinitynewdawn.adapters.ChecklistPluckingAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ChecklistPluckingActivity extends AppCompatActivity {

    private ImageButton btnDailyWeighmentRow, btnDailySundryRow, btnDailyf2fRow, btnBoughtLeafRow, btnFactoryWeighmentRow, btnChecklistSundryRow;
    private ImageButton btnHome, btnBack;
    private ImageButton btnFilter;
    private RecyclerView rvChecklistPlucking;
    private SlidingDrawer slidingDrawer;
    private TextView txtDate;
    private Calendar myCalendar = Calendar.getInstance();
    private Spinner spinnerDivisionFilter, spinnerSupervisorFilter;
    private Button btnSDok, btnSDdefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist_plucking);

        //Sliding Drawer
        slidingDrawer = findViewById(R.id.slidingDrawer_checklist_plucking);
        btnFilter = findViewById(R.id.btnFilter_checklist_plucking);

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateOpen();
            }
        });

        //Spinner Filters with Dummy Data
        spinnerDivisionFilter = findViewById(R.id.spinnerDivisions_checklist_plucking);
        spinnerSupervisorFilter = findViewById(R.id.spinnerSupervisors_checklist_plucking);

        String[] divisions = new String[]{"All Divisions", "Upper Division","Stafford Division","Lower Division"};

        ArrayAdapter<String> filterDivisionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, divisions);
        spinnerDivisionFilter.setAdapter(filterDivisionAdapter);

        String[] supervisors = new String[]{"All Supervisors","Niroshan","R Ramakrishna","P Letchumi"};

        ArrayAdapter<String> filterSupervisorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, supervisors);
        spinnerSupervisorFilter.setAdapter(filterSupervisorAdapter);

        btnSDok = findViewById(R.id.btnSDok_checklist_plucking);
        btnSDok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateClose();
            }
        });

        btnSDdefault = findViewById(R.id.btnSDdefault_checklist_plucking);
        btnSDdefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDivisionFilter.setSelection(0);
                spinnerSupervisorFilter.setSelection(0);
            }
        });

        //Recycler View with its adapter
        rvChecklistPlucking = findViewById(R.id.rvCheckListPlucking_activity_checklist_plucking);
        ChecklistPluckingAdapter checklistPluckingAdapter = new ChecklistPluckingAdapter();
        rvChecklistPlucking.setHasFixedSize(true);
        rvChecklistPlucking.setLayoutManager(new LinearLayoutManager(this));
        rvChecklistPlucking.setAdapter(checklistPluckingAdapter);

        btnDailyWeighmentRow = findViewById(R.id.btnDailyWeighmentRow_activity_checklist_plucking);
        btnDailyWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyWeighmentIntent = new Intent(v.getContext(), AllDivisionsDailyWeighmentActivity.class);
                dailyWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyWeighmentIntent);
            }
        });

        //Date Filter
        txtDate = findViewById(R.id.txtDate_activity_checklist_plucking);
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
        btnDailySundryRow = findViewById(R.id.btnDailySundryRow_activity_checklist_plucking);
        btnDailySundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailySundryIntent = new Intent(v.getContext(), AllDivisionsDailySundryActivities.class);
                dailySundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailySundryIntent);
            }
        });

        btnDailyf2fRow = findViewById(R.id.btnDailyF2FWeighmentRow_activity_checklist_plucking);
        btnDailyf2fRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyF2FIntent = new Intent(v.getContext(), AllDivisionsDailyF2FWeighmentActivity.class);
                dailyF2FIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyF2FIntent);
            }
        });

        btnBoughtLeafRow = findViewById(R.id.btnBoughtLeafRow_activity_checklist_plucking);
        btnBoughtLeafRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent boughtLeafIntent = new Intent(v.getContext(), BoughtLeafActivity.class);
                boughtLeafIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(boughtLeafIntent);
            }
        });

        btnFactoryWeighmentRow = findViewById(R.id.btnFactoryWeighmentRow_activity_checklist_plucking);
        btnFactoryWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent factoryWeighmentIntent = new Intent(v.getContext(), FactoryWeighmentsActivity.class);
                factoryWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(factoryWeighmentIntent);
            }
        });

        btnChecklistSundryRow = findViewById(R.id.btnChecklistSundryRow_activity_checklist_plucking);
        btnChecklistSundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistSundryIntent = new Intent(v.getContext(), ChecklistSundryActivity.class);
                checklistSundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistSundryIntent);
            }
        });

        btnHome = findViewById(R.id.imgbtnHome_activity_checklist_plucking);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), DashboardActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
        btnBack = findViewById(R.id.btnBack_activity_checklist_plucking);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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