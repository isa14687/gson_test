package com.example.isa.myapplication.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by isa on 2017/1/15.
 */

public class ApiModelImp {
    private ApiModelImp() {
    }

    public static ApiModel create() {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(List.class, new ListJsonDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://192.168.0.105:3000/")
                .build();
        return retrofit.create(ApiModel.class);
    }
}
