package com.apextech.infinitynewdawn.data.interfaces;

import com.apextech.infinitynewdawn.data.models.LoginRequest;
import com.apextech.infinitynewdawn.data.models.LoginResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface LoginService {

    @POST("mobile/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

}
