package com.example.elmus7af_elkareem.SplashScreen.Data.QuranRetrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientQuran {
    private static String BASE_URL = "http://api.alquran.cloud/v1/quran/";

    private static RetrofitClientQuran mInstance;
    private Retrofit retrofit;

    private RetrofitClientQuran()
    {
        retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(new OkHttpClient().newBuilder()
                            .connectTimeout(200, TimeUnit.SECONDS)
                            .readTimeout(200, TimeUnit.SECONDS)
                            .build())
                    .build();

    }
    public static synchronized RetrofitClientQuran getInstance()
    {
        if(mInstance == null )
            mInstance = new RetrofitClientQuran();
        return  mInstance;
    }


    public RetrofitQuran getSourahs(){return  retrofit.create(RetrofitQuran.class);}

}
