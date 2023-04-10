package com.apextech.infinitynewdawn.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.SlidingDrawer;
import android.widget.Spinner;
import android.widget.TextView;

import com.apextech.infinitynewdawn.R;
import com.apextech.infinitynewdawn.adapters.DailyWeighmentAdapter;
import com.apextech.infinitynewdawn.data.api.APIClient;
import com.apextech.infinitynewdawn.data.models.GenericResponse;
import com.apextech.infinitynewdawn.data.models.WeighmentRequest;
import com.apextech.infinitynewdawn.data.models.WeighmentResponse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllDivisionsDailyWeighmentActivity extends AppCompatActivity {

    //Initialize Variables

    private RecyclerView rvDailyWeighment;
    private ImageButton btnDailySundryRow, btnDailyf2fRow, btnBoughtLeafRow, btnFactoryWeighmentRow, btnChecklistSundryRow, btnChecklistPluckingRow;
    private ImageButton btnHome, btnBack;
    private ImageButton btnFilter;
    private TextView txtDate;
    private TextView txtTotGrossWeight, txtTotStndDeduction, txtTotExtraDeduction, txtTotRoundedNetWeight;
    private Calendar myCalendar = Calendar.getInstance();
    private Spinner spinnerDivisionFilter, spinnerSessionFilter;
    private Button btnSDok, btnSDDefault;
    private SlidingDrawer slidingDrawer;
    DailyWeighmentAdapter dailyWeighmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_divisions_daily_weighment);

        //Sliding Drawer
        slidingDrawer = findViewById(R.id.slidingDrawer_activity_daily_weighment);

        btnFilter = findViewById(R.id.imgbtnFilter_activity_daily_weighment);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateOpen();
            }
        });

        //Spinners for the filters with dummy data
        spinnerDivisionFilter = findViewById(R.id.spinnerDivision_daily_weighment_activity);
        String[] divisions = new String[]{"All Divisions", "Upper Division","Stafford Division","Lower Division"};

        ArrayAdapter<String> filterDivisionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, divisions);
        spinnerDivisionFilter.setAdapter(filterDivisionAdapter);

        spinnerSessionFilter = findViewById(R.id.spinnerSessionNo_daily_weighment_activity);
        String[] sessions = new String[]{"All Sessions","Session 1","Session 2","Session 3"};

        ArrayAdapter<String> filterAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sessions);
        spinnerSessionFilter.setAdapter(filterAdapter);

        btnSDok = findViewById(R.id.btnSDok_daily_weighment);
        btnSDok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingDrawer.animateClose();
            }
        });

        btnSDDefault = findViewById(R.id.btnSDdefault_daily_weighment);
        btnSDDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDivisionFilter.setSelection(0);
                spinnerSessionFilter.setSelection(0);
            }
        });
/*
        final Button handleButton = (Button) findViewById(R.id.handle);
        simpleSlidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                handleButton.setText("Close");
            }
        });
        // implement setOnDrawerCloseListener event
        simpleSlidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                // change the handle button text
                handleButton.setText("Open");
            }
        });*/

        //RecyclerView and it's Adapters

        rvDailyWeighment = findViewById(R.id.rvDailyWeighment_activity_all_divisions_daily_weighment);
        rvDailyWeighment.setHasFixedSize(true);
        rvDailyWeighment.setLayoutManager(new LinearLayoutManager(this));

        dailyWeighmentAdapter = new DailyWeighmentAdapter();
        getAllWeighments();

        //Date Filter
        txtDate = findViewById(R.id.txtDate_activity_daily_weighment);
        txtDate.setText(String.valueOf(myCalendar.get(Calendar.DATE) + " /" + (myCalendar.get(Calendar.MONTH)+1) + " /" + myCalendar.get(Calendar.YEAR)));

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

        btnDailySundryRow = findViewById(R.id.btnDailySundryRow_activity_daily_weighment);
        btnDailySundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailySundryIntent = new Intent(v.getContext(), AllDivisionsDailySundryActivities.class);
                dailySundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailySundryIntent);
            }
        });

        btnDailyf2fRow = findViewById(R.id.btnDailyF2FWeighmentRow_activity_daily_weighment);
        btnDailyf2fRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyF2FIntent = new Intent(v.getContext(), AllDivisionsDailyF2FWeighmentActivity.class);
                dailyF2FIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dailyF2FIntent);
            }
        });

        btnBoughtLeafRow = findViewById(R.id.btnBoughtLeafRow_activity_daily_weighment);
        btnBoughtLeafRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent boughtLeafIntent = new Intent(v.getContext(), BoughtLeafActivity.class);
                boughtLeafIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(boughtLeafIntent);
            }
        });

        btnFactoryWeighmentRow = findViewById(R.id.btnFactoryWeighmentRow_activity_daily_weighment);
        btnFactoryWeighmentRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent factoryWeighmentIntent = new Intent(v.getContext(), FactoryWeighmentsActivity.class);
                factoryWeighmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(factoryWeighmentIntent);
            }
        });

        btnChecklistSundryRow = findViewById(R.id.btnChecklistSundryRow_activity_daily_weighment);
        btnChecklistSundryRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistSundryIntent = new Intent(v.getContext(), ChecklistSundryActivity.class);
                checklistSundryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistSundryIntent);
            }
        });

        btnChecklistPluckingRow = findViewById(R.id.btnChecklistPluckingRow_activity_daily_weighment);
        btnChecklistPluckingRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistPluckingIntent = new Intent(v.getContext(), ChecklistPluckingActivity.class);
                checklistPluckingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(checklistPluckingIntent);
            }
        });

        btnHome = findViewById(R.id.imgbtnHome_activity_daily_weighment);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), DashboardActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });

        btnBack = findViewById(R.id.btnBack_activity_daily_weighment);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), DashboardActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
    }

    private void getAllWeighments() {

        WeighmentRequest weighmentRequest = new WeighmentRequest();
        weighmentRequest.setPlantationId(1);
        weighmentRequest.setLastUpdatedAt("2023-01-09");
        weighmentRequest.setEstateId(4);
        weighmentRequest.setDivisionId(7);

        String token = "Bearer "+"DXlkoeM52UceFpZZedIgOjhugzvt2qrs6mOfcEEkVX9IE5pCqmqF80vUFM0fjArTkolijMwzudUKYfIj";
        String imeiNo = "ab777777";

        Call<GenericResponse<WeighmentResponse>> weighmentsList = APIClient.getWeighmentService().getWeighments(token, imeiNo, weighmentRequest);

        weighmentsList.enqueue(new Callback<GenericResponse<WeighmentResponse>>() {
            @Override
            public void onResponse(Call<GenericResponse<WeighmentResponse>> call, Response<GenericResponse<WeighmentResponse>> response) {

                if(response.isSuccessful()){

                    List<WeighmentResponse> weighmentResponses = response.body().getData();

                    dailyWeighmentAdapter.setWeighmentData(weighmentResponses);
                    rvDailyWeighment.setAdapter(dailyWeighmentAdapter);

/*
                    int count = dailyWeighmentAdapter.getItemCount();
                    float totalGross = 0, totalStandardDeduction = 0;
                    int totalExtraDeduction = 0, totalRoundedNetWeight = 0;
                    int i;
                    for (i = 0; i < count; i++){
                        */
/*totalGross = totalGross + weighmentResponses.get(i).getOriginalGross();*//*

                        totalExtraDeduction = totalExtraDeduction + weighmentResponses.get(i).getAdditionalDeduction();


                    }*/
                }
            }

            @Override
            public void onFailure(Call<GenericResponse<WeighmentResponse>> call, Throwable t) {
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.searchView_activity_all_divisions_daily_weighment_activities){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    //Configure what happens on physical button back pressed
    @Override
    public void onBackPressed() {

    }
}