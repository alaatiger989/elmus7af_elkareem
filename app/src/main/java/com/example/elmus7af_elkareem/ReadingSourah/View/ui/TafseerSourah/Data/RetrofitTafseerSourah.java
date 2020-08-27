package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerSourah.Data;

import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.Model.TafseerAyahResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitTafseerSourah {
    @GET("tafseer/{tafseerId}/{numberOfSourah}/{numberOfAyah}")
    Call<TafseerAyahResponse> getTafseerDetails(
            @Path("tafseerId")
            String tafseerId,
            @Path("numberOfSourah")
            String numberOfSourah,
            @Path("numberOfAyah")
            String numberOfAyah
    );
}
