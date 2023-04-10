package com.apextech.infinitynewdawn.data.models;

import com.google.gson.annotations.SerializedName;

public class ChecklistSundryRequest {

    @SerializedName("plantationid")
    int plantationId;

    String date;

    @SerializedName("estateid")
    int estateId;

    @SerializedName("divisionid")
    int divisionId;

    @SerializedName("supervisorid")
    int supervisorId;

    @SerializedName("typeid")
    int typeId;

    public int getPlantationId() {
        return plantationId;
    }

    public void setPlantationId(int plantationId) {
        this.plantationId = plantationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
