package com.apextech.infinitynewdawn.data.interfaces;

import com.apextech.infinitynewdawn.data.models.ChecklistSundryRequest;
import com.apextech.infinitynewdawn.data.models.ChecklistSundryResponse;
import com.apextech.infinitynewdawn.data.models.GenericResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ChecklistSundryService {

    @POST("checklist/sundry")
    Call<GenericResponse<ChecklistSundryResponse>> getChecklistSundry(@Header("Authorization") String authToken,
                                                                      @Header("imeino") String imeiNo,
                                                                      @Body ChecklistSundryRequest checklistSundryRequest);
}
