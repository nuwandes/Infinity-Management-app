package com.apextech.infinitynewdawn.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.apextech.infinitynewdawn.R;

import java.util.Calendar;

public class SplashActivity extends AppCompatActivity {

    private TextView txtMainAppName, txtCopyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txtMainAppName = findViewById(R.id.txtTitle_splash_activity);
        txtCopyright = findViewById(R.id.txtCopyright_splash_activity);

        txtCopyright.setText("Copyright "+ String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) +" Apex Technologies Private Limited");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }

        }, 2000);
    }
}