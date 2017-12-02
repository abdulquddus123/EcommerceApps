package com.sokhbazar.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sokhbazar.Interface.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Areyen on 7/31/2017.
 */

public class RetrofitApiClient {

    private static final String BASE_URL = "http://sokhbazar.com"; //address of your remote server.
    private static Retrofit retrofit = null;
    private static Retrofit getRetrofitInstance() {

        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static ApiInterface getApiInterface() {
        return getRetrofitInstance().create(ApiInterface.class);
    }

}

