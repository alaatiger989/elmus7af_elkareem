package com.example.elmus7af_elkareem.SplashScreen.Data.QuranRetrofit;

import com.example.elmus7af_elkareem.SplashScreen.Model.QuranModel.QuranResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RetrofitQuran {


    @GET("ar.alafasy")
    Call<QuranResponse> getQuran();
}
