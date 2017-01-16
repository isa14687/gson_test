package com.example.isa.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.isa.myapplication.api.ApiModel;
import com.example.isa.myapplication.api.ApiModelImp;
import com.example.isa.myapplication.api.body.ApiBody;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiModel apiModel = ApiModelImp.create();

        apiModel.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<ApiBody>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("onCompleted", "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("onError", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(List<ApiBody> apiBody) {
                        Log.d("onNext", "onNext: " + apiBody.get(0).getTitle());
                        Log.d("onNext", "onNext: " + apiBody.get(0).getAuthor());
                        Log.d("onNext", "onNext: " + apiBody.get(0).getId());
                    }
                });
    }
}
