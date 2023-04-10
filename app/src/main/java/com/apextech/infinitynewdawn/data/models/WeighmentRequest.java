package com.apextech.infinitynewdawn.data.models;

import com.google.gson.annotations.SerializedName;

public class WeighmentRequest {

    @SerializedName("plantationid")
    int plantationId;

    @SerializedName("last_updated_at")
    String lastUpdatedAt;

    @SerializedName("estateid")
    int estateId;

    @SerializedName("divisionid")
    int divisionId;

    public int getPlantationId() {
        return plantationId;
    }

    public void setPlantationId(int plantationId) {
        this.plantationId = plantationId;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setEstateId(int estateId) {
        this.estateId = estateId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }
}
