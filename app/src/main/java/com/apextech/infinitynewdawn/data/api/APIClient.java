package com.apextech.infinitynewdawn.data.api;

import com.apextech.infinitynewdawn.data.interfaces.ChecklistSundryService;
import com.apextech.infinitynewdawn.data.interfaces.LoginService;
import com.apextech.infinitynewdawn.data.interfaces.WeighmentService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://dev.infinity.com.lk/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static LoginService getLoginService(){
        LoginService loginService = getRetrofit().create(LoginService.class);
        return loginService;
    }

//    public static EstateService getEstateService(){
//        EstateService estateService = getRetrofit().create(EstateService.class);
//        return estateService;
//    }

    public static WeighmentService getWeighmentService(){
        WeighmentService weighmentService = getRetrofit().create(WeighmentService.class);
        return weighmentService;
    }

    public static ChecklistSundryService getCheckListSundryService(){
        ChecklistSundryService checklistSundryService = getRetrofit().create(ChecklistSundryService.class);
        return checklistSundryService;
    }

}
