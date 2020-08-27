package com.example.elmus7af_elkareem.SplashScreen.Data.TafseerRetrofit;

import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerSourah.Data.RetrofitTafseerSourah;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientTafseerList {
    private static String BASE_URL = "http://api.quran-tafseer.com/";

    private static RetrofitClientTafseerList mInstance;
    private Retrofit retrofit;

    private RetrofitClientTafseerList()
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
    public static synchronized RetrofitClientTafseerList getInstance()
    {
        if(mInstance == null )
            mInstance = new RetrofitClientTafseerList();
        return  mInstance;
    }


    public RetrofitTafseerList getTafseerApi(){return  retrofit.create(RetrofitTafseerList.class);}
    public RetrofitTafseerSourah getTafseerAyah(){return  retrofit.create(RetrofitTafseerSourah.class);}
}
