package com.apextech.infinitynewdawn.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.SlidingDrawer;
import android.widget.Spinner;
import android.widget.TextView;

import com.apextech.infinitynewdawn.R;
import com.apextech.infinitynewdawn.adapters.ChecklistSundryAdapter;
import com.apextech.infinitynewdawn.data.api.APIClient;
import com.apextech.infinitynewdawn.data.models.ChecklistSundryResponse;
import com.apextech.infinitynewdawn.data.models.GenericResponse;
import com.apextech.infinitynewdawn.data.models.ChecklistSundryRequest;
import com.apextech.infinitynewdawn.data.models.WeighmentResponse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChecklistSundryActivity extends AppCompatActivity {

    private ImageButton btnDailyWeighmentRow, btnDailySundryRow, btnDailyf2fRow, btnBoughtLeafRow, btnFactoryWeighmentRow, btnChecklistPluckingRow;
    private ImageButton btnHome, btnBack;
    private ImageButton btnFilter;
    private RecyclerView rvChecklistSundry;
    private SlidingDrawer slidingDrawer;
    private TextView txtDate;
    private Calendar myCalendar = Calendar.getInstance();
    private Spinner spinnerDivisionFilter, spinnerSupervisorFilter;
    private Button btnSDok, btnSDdefault;
    ChecklistSundryAdapter checklistSundryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist_sundry);

        //Sliding Drawer
        slidingDrawer = findViewById(R.id.slidingDrawer_checklist_sundry);
        btnFilter = findViewById(R.id.btnFilter_checklist_sundry);

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateOpen();
            }
        });

        //Spinner Filters with Dummy Data
        spinnerDivisionFilter = findViewById(R.id.spinnerDivisions_checklist_sundry);
        spinnerSupervisorFilter = findViewById(R.id.spinnerSupervisors_checklist_sundry);

        String[] divisions = new String[]{"All Divisions", "Upper Division","Stafford Division","Lower Division"};

        ArrayAdapter<String> filterDivisionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, divisions);
        spinnerDivisionFilter.setAdapter(filterDivisionAdapter);

        String[] supervisors = new String[]{"All Supervisors","Niroshan","R Ramakrishna","P Letchumi"};

        ArrayAdapter<String> filterSupervisorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, supervisors);
        spinnerSupervisorFilter.setAdapter(filterSupervisorAdapter);

        btnSDok = findViewById(R.id.btnSDok_checklist_sundry);
        btnSDok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateClose();
            }
        });

        btnSDdefault = findViewById(R.id.btnSDdefault_checklist_sundry);
        btnSDdefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDivisionFilter.setSelection(0);
                spinnerSupervisorFilter.setSelection(0);
            }
        });

        //Recycler View with it's Adapters
        rvChecklistSundry = findViewById(R.id.rvCheckListSundry_activity_checklist_sundry);
        checklistSundryAdapter = new ChecklistSundryAdapter();
        rvChecklistSundry.setHasFixedSize(true);
        rvChecklistSundry.setLayoutManager(new LinearLayoutManager(this));

        getChecklistData();

        //Date Filter
        txtDate = findViewById(R.id.txtDate_activity_checklist_sundry);
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
        btnDailyWeighmentRow = findViewById(R.id.btnDailyWeighmentRow_activity_checklist_sundry);
        btnDailyWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyWeighmentIntent = new Intent(v.getContext(), AllDivisionsDailyWeighmentActivity.class);
                dailyWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyWeighmentIntent);
            }
        });

        btnDailySundryRow = findViewById(R.id.btnDailySundryRow_activity_checklist_sundry);
        btnDailySundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailySundryIntent = new Intent(v.getContext(), AllDivisionsDailySundryActivities.class);
                dailySundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailySundryIntent);
            }
        });

        btnDailyf2fRow = findViewById(R.id.btnDailyF2FWeighmentRow_activity_checklist_sundry);
        btnDailyf2fRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyF2FIntent = new Intent(v.getContext(), AllDivisionsDailyF2FWeighmentActivity.class);
                dailyF2FIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyF2FIntent);
            }
        });

        btnBoughtLeafRow = findViewById(R.id.btnBoughtLeafRow_activity_checklist_sundry);
        btnBoughtLeafRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent boughtLeafIntent = new Intent(v.getContext(), BoughtLeafActivity.class);
                boughtLeafIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(boughtLeafIntent);
            }
        });

        btnFactoryWeighmentRow = findViewById(R.id.btnFactoryWeighmentRow_activity_checklist_sundry);
        btnFactoryWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent factoryWeighmentIntent = new Intent(v.getContext(), FactoryWeighmentsActivity.class);
                factoryWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(factoryWeighmentIntent);
            }
        });

        btnChecklistPluckingRow = findViewById(R.id.btnChecklistPluckingRow_activity_checklist_sundry);
        btnChecklistPluckingRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistPluckingIntent = new Intent(v.getContext(), ChecklistPluckingActivity.class);
                checklistPluckingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistPluckingIntent);
            }
        });

        btnHome = findViewById(R.id.imgbtnHome_activity_checklist_sundry);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), DashboardActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
        btnBack = findViewById(R.id.btnBack_activity_checklist_sundry);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), DashboardActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
    }

    private void getChecklistData() {

        ChecklistSundryRequest checklistSundryRequest = new ChecklistSundryRequest();
        checklistSundryRequest.setPlantationId(1);
        checklistSundryRequest.setDate("2023-01-09");
        checklistSundryRequest.setEstateId(4);
        checklistSundryRequest.setDivisionId(7);
        checklistSundryRequest.setSupervisorId(1428);
        checklistSundryRequest.setTypeId(1);

        String token = "Bearer "+"DXlkoeM52UceFpZZedIgOjhugzvt2qrs6mOfcEEkVX9IE5pCqmqF80vUFM0fjArTkolijMwzudUKYfIj";
        String imeiNo = "ab777777";

        Call<GenericResponse<ChecklistSundryResponse>> checklistSundryList = APIClient.getCheckListSundryService().getChecklistSundry(token, imeiNo, checklistSundryRequest);

        checklistSundryList.enqueue(new Callback<GenericResponse<ChecklistSundryResponse>>() {
            @Override
            public void onResponse(Call<GenericResponse<ChecklistSundryResponse>> call, Response<GenericResponse<ChecklistSundryResponse>> response) {

                if(response.isSuccessful()){

                    List<ChecklistSundryResponse> checklistSundryResponses = response.body().getData();

                    checklistSundryAdapter.setChecklistSundryData(checklistSundryResponses);
                    rvChecklistSundry.setAdapter(checklistSundryAdapter);
                }
            }

            @Override
            public void onFailure(Call<GenericResponse<ChecklistSundryResponse>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
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