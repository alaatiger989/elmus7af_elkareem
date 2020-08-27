package com.example.elmus7af_elkareem.SplashScreen.Data.TafseerRetrofit;

import com.example.elmus7af_elkareem.SplashScreen.Model.TafseerIDsModel.TafseerListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitTafseerList {
    @GET("tafseer")
    Call<List<TafseerListResponse>> getTafseerDetails();
}
