package com.apextech.infinitynewdawn.data.models;

import java.util.List;

public class GenericResponse<T> {

    String status;
    List<T> data;
    int systemCode;

    public GenericResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(int systemCode) {
        this.systemCode = systemCode;
    }
}
