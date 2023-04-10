package com.apextech.infinitynewdawn.data.interfaces;

import com.apextech.infinitynewdawn.data.models.GenericResponse;
import com.apextech.infinitynewdawn.data.models.WeighmentRequest;
import com.apextech.infinitynewdawn.data.models.WeighmentResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface WeighmentService {

    @POST("weighment/index")
    Call<GenericResponse<WeighmentResponse>> getWeighments(@Header("Authorization") String authToken, @Header("imeino") String imeiNo, @Body WeighmentRequest weighmentRequest);

}
