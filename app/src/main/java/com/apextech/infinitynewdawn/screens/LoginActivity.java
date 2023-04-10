package com.apextech.infinitynewdawn.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apextech.infinitynewdawn.R;
import com.apextech.infinitynewdawn.data.api.APIClient;
import com.apextech.infinitynewdawn.data.models.LoginRequest;
import com.apextech.infinitynewdawn.data.models.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    /*Button btnTest;*/
    private Button btnLogin;
    private EditText editTextUsername;
    EditText editTextPassword;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin_activity_login);
        editTextUsername = findViewById(R.id.txtUsername_activity_login);
        editTextPassword = findViewById(R.id.txtPassword_activity_login);

        /*sharedPreferences = getSharedPreferences( "MyUserPrefs", Context.MODE_PRIVATE);*/

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(editTextUsername.getText().toString()) || TextUtils.isEmpty(editTextPassword.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Username and Password cannot be Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    login();
                }

                /*Intent dashboard = new Intent(LoginActivity.this, DashboardActivity.class);
                String username = editTextUsername.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.commit();


                startActivity(dashboard);*/

            }
        });
    }
    public void login(){

        ProgressDialog loginProgress = new ProgressDialog(this);
        loginProgress.setMessage("Logging In ...");
        loginProgress.show();

        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        /*SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.apply();*/

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);

        Call<LoginResponse> loginResponseCall = APIClient.getLoginService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                assert response.body() != null;
                if (response.body().getStatus().equals("SUCCESS")){

                    Intent dashboard = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(dashboard);

                    Toast.makeText(LoginActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    loginProgress.dismiss();
                }

                else {
                    loginProgress.dismiss();
                    Toast.makeText(LoginActivity.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                Toast.makeText(LoginActivity.this, "Throwable "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}