package com.apextech.infinitynewdawn.data.models;

import com.google.gson.annotations.SerializedName;

public class FactoryWeighmentResponse {

    @SerializedName("factory_estate_id")
    int factoryEstateId;

    @SerializedName("estate_id")
    int estateId;

    @SerializedName("division_id")
    int divisionId;

    @SerializedName("field_id")
    int fieldId;

    @SerializedName("field_officer_id")
    int factoryOfficerId;

    @SerializedName("container_type_id")
    int containerTypeId;

    @SerializedName("container_count")
    int containerCount;

    @SerializedName("scale_weight")
    String grossWeight;

    @SerializedName("total_empty_container_weight")
    String containerDeduction;

    @SerializedName("moisture_kg")
    String moistureDeduction;

    String totalDeductions;

    @SerializedName("rounded_net_weight")
    int roundedNetWeight;

    @SerializedName("weighing_datetime")
    String weighmentTime;

    public int getFactoryEstateId() {
        return factoryEstateId;
    }

    public void setFactoryEstateId(int factoryEstateId) {
        this.factoryEstateId = factoryEstateId;
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

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getFactoryOfficerId() {
        return factoryOfficerId;
    }

    public void setFactoryOfficerId(int factoryOfficerId) {
        this.factoryOfficerId = factoryOfficerId;
    }

    public int getContainerTypeId() {
        return containerTypeId;
    }

    public void setContainerTypeId(int containerTypeId) {
        this.containerTypeId = containerTypeId;
    }

    public int getContainerCount() {
        return containerCount;
    }

    public void setContainerCount(int containerCount) {
        this.containerCount = containerCount;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getContainerDeduction() {
        return containerDeduction;
    }

    public void setContainerDeduction(String containerDeduction) {
        this.containerDeduction = containerDeduction;
    }

    public String getMoistureDeduction() {
        return moistureDeduction;
    }

    public void setMoistureDeduction(String moistureDeduction) {
        this.moistureDeduction = moistureDeduction;
    }

    public String getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(String totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public int getRoundedNetWeight() {
        return roundedNetWeight;
    }

    public void setRoundedNetWeight(int roundedNetWeight) {
        this.roundedNetWeight = roundedNetWeight;
    }

    public String getWeighmentTime() {
        return weighmentTime;
    }

    public void setWeighmentTime(String weighmentTime) {
        this.weighmentTime = weighmentTime;
    }
}
