package com.apextech.infinitynewdawn.data.models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    private String status;
    private String name;
    private String email;

    @SerializedName("user_id")
    private int userId;

    @SerializedName("plantation_group_id")
    private int plantationGroupId;

    @SerializedName("api_token")
    private String apiToken;

    private int systemCode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUser_id() {
        return userId;
    }

    public void setUser_id(int user_id) {
        this.userId = user_id;
    }

    public int getPlantation_group_id() {
        return plantationGroupId;
    }

    public void setPlantation_group_id(int plantation_group_id) {
        this.plantationGroupId = plantation_group_id;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

}
