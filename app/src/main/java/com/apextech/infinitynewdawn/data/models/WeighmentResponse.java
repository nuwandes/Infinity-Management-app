package com.apextech.infinitynewdawn.data.models;

import com.google.gson.annotations.SerializedName;

public class WeighmentResponse {

    private String status;

    @SerializedName("division_id")
    private int divisionId;

    @SerializedName("field_id")
    int fieldId;

    @SerializedName("internal_no")
    String internalNo;

    @SerializedName("employee_id")
    int employeeId;

    @SerializedName("work_code_id")
    int workCodeId;

    @SerializedName("session_no")
    int sessionNo;

    @SerializedName("original_gross")
    float originalGross;

    @SerializedName("calculated_moisture")
    float calculatedMoisture;

    @SerializedName("additional_deduction")
    int additionalDeduction;

    @SerializedName("rounded_net_weight")
    int roundedNetWeight;

    public String getStatus() {
        return status;
    }

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getInternalNo() {
        return internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getWorkCodeId() {
        return workCodeId;
    }

    public void setWorkCodeId(int workCodeId) {
        this.workCodeId = workCodeId;
    }

    public int getSessionNo() {
        return sessionNo;
    }

    public void setSessionNo(int sessionNo) {
        this.sessionNo = sessionNo;
    }

    public float getOriginalGross() {
        return originalGross;
    }

    public void setOriginalGross(float originalGross) {
        this.originalGross = originalGross;
    }

    public float getCalculatedMoisture() {
        return calculatedMoisture;
    }

    public void setCalculatedMoisture(float calculatedMoisture) {
        this.calculatedMoisture = calculatedMoisture;
    }

    public int getAdditionalDeduction() {
        return additionalDeduction;
    }

    public void setAdditionalDeduction(int additionalDeduction) {
        this.additionalDeduction = additionalDeduction;
    }

    public int getRoundedNetWeight() {
        return roundedNetWeight;
    }

    public void setRoundedNetWeight(int roundedNetWeight) {
        this.roundedNetWeight = roundedNetWeight;
    }

}