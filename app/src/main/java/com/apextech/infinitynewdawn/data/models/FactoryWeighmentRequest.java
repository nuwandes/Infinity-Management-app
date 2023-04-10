package com.apextech.infinitynewdawn.data.models;

import com.google.gson.annotations.SerializedName;

public class FactoryWeighmentRequest {

    @SerializedName("plantationid")
    int plantationId;

    String date;

    @SerializedName("estateid")
    int estateId;
}