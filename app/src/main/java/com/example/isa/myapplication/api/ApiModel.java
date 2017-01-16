package com.example.isa.myapplication.api;

import com.example.isa.myapplication.api.body.ApiBody;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by isa on 2017/1/15.
 */

public interface ApiModel {
    @GET("comments")
    Observable<List<ApiBody>> getData();
}
