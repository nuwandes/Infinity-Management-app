package com.apextech.infinitynewdawn.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.apextech.infinitynewdawn.R;

public class DashboardActivity extends AppCompatActivity {

    private ImageButton btnDailyWeightmentActivities, btnDailySundryActivities, btnDailyF2FWeighmentActivities, btnBoughtLeaf, btnFactoryWeighments, btnChecklistSundry, btnChecklistPlucking;
    private TextView estateNameText;
    private TextView welcomeText;
    private Button btnSummary;
    private Button btnAlert;
    private TextView txtAlertNo;
    private String token, imeiNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_two);

        estateNameText = findViewById(R.id.txtEstateName_activity_dashboard);

        welcomeText = findViewById(R.id.txtWelcome_activity_dashboard);

        /*SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String username = sp.getString("username", "");

        if (!Objects.equals(username, "")) {
            welcomeText.setText("Hello Mr. " + username);
        } else {
            welcomeText.setText("Hello");
        }*/

        btnDailyWeightmentActivities = findViewById(R.id.btnDailyWeightmentActivities_activity_dashboard);
        btnDailySundryActivities = findViewById(R.id.btnDailySundryActivities_activity_dashboard);
        btnDailyF2FWeighmentActivities = findViewById(R.id.btnDailyF2FWeighment_activity_dashboard);
        btnBoughtLeaf = findViewById(R.id.btnBoughtLeaf_activity_dashboard);
        btnFactoryWeighments = findViewById(R.id.btnFactoryWeighment_activity_dashboard);
        btnChecklistSundry = findViewById(R.id.btnChecklistSundry_activity_dashboard);
        btnChecklistPlucking = findViewById(R.id.btnChecklistPlucking_activity_dashboard);
        btnSummary = findViewById(R.id.btnSummary_activity_dashboard);
        btnAlert = findViewById(R.id.imgbtnAlert_activity_dashboard);
        txtAlertNo = findViewById(R.id.txtAlertNo_activity_dashboard);

        txtAlertNo.setText("10");

        btnSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent summaryActivityIntent = new Intent(DashboardActivity.this, SummaryActivity.class);
                startActivity(summaryActivityIntent);
            }
        });

        btnDailyWeightmentActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Call<List<WeighmentResponse>>*/

                Intent weighmentActivityIntent = new Intent(DashboardActivity.this, AllDivisionsDailyWeighmentActivity.class);
                startActivity(weighmentActivityIntent);
            }
        });

        btnDailySundryActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sundryActivityIntent = new Intent(DashboardActivity.this, AllDivisionsDailySundryActivities.class);
                startActivity(sundryActivityIntent);
            }
        });

        btnDailyF2FWeighmentActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f2fweighmentActivityIntent = new Intent(DashboardActivity.this, AllDivisionsDailyF2FWeighmentActivity.class);
                startActivity(f2fweighmentActivityIntent);
            }
        });

        btnBoughtLeaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent boughtLeafActivityIntent = new Intent(DashboardActivity.this, BoughtLeafActivity.class);
                startActivity(boughtLeafActivityIntent);
            }
        });

        btnFactoryWeighments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent factoryWeighmentsIntent = new Intent(DashboardActivity.this, FactoryWeighmentsActivity.class);
                startActivity(factoryWeighmentsIntent);
            }
        });

        btnChecklistSundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistSundryIntent = new Intent(DashboardActivity.this, ChecklistSundryActivity.class);
                startActivity(checklistSundryIntent);
            }
        });

        btnChecklistPlucking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklistPluckingIntent = new Intent(DashboardActivity.this, ChecklistPluckingActivity.class);
                startActivity(checklistPluckingIntent);
            }
        });

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alertIntent = new Intent(DashboardActivity.this, AlertActivity.class);
                startActivity(alertIntent);
            }
        });
    }

    /*@Override
    public void onBackPressed(){

    }*/
}