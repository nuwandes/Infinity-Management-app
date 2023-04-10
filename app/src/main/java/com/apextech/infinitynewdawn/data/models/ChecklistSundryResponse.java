package com.apextech.infinitynewdawn.data.models;

import com.google.gson.annotations.SerializedName;

public class ChecklistSundryResponse {

    @SerializedName("field_code")
    String fieldCode;

    @SerializedName("field_id")
    String fieldId;

    @SerializedName("internal_no")
    String employeeNumber;

    @SerializedName("name")
    String employeeName;

    @SerializedName("work_type_code")
    String workType;

    @SerializedName("WorkCode_code")
    String workCode;

    @SerializedName("work_code_id")
    String workCodeId;

    @SerializedName("in_datetime")
    String checkInTime;

    @SerializedName("out_datetime")
    String checkOutTime;

    String duration;

    @SerializedName("supervisor_name")
    String supervisorName;

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public String getWorkCodeId() {
        return workCodeId;
    }

    public void setWorkCodeId(String workCodeId) {
        this.workCodeId = workCodeId;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }
}
