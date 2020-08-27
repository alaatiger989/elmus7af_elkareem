package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.TafseerAyats;
import com.example.elmus7af_elkareem.SplashScreen.Data.TafseerRetrofit.RetrofitClientTafseerList;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.Model.TafseerAyahResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BodyCallingTafseerAyah {
    private List<TafseerAyats> tafseerAyahResponses = new ArrayList<>();

    public BodyCallingTafseerAyah(Context context, String tafseer_id, int sourahNumber, int ayahNumber, String arabic_ayah_text , String numberOfAyahInApi) {
        AppDatabase database = AppDatabase.getInstance(context);
        try {
            Call<TafseerAyahResponse> call = RetrofitClientTafseerList.getInstance().getTafseerAyah().getTafseerDetails(
                    tafseer_id , String.valueOf(sourahNumber) , String.valueOf(ayahNumber));

            call.enqueue(new Callback<TafseerAyahResponse>() {
                @Override
                public void onResponse(Call<TafseerAyahResponse> call, Response<TafseerAyahResponse> response) {
                    TafseerAyahResponse tafseerAyahResponse = response.body();

                    tafseerAyahResponses.add(new TafseerAyats(
                            Integer.parseInt(numberOfAyahInApi),
                            tafseer_id,
                            tafseerAyahResponse.getTafseerName()
                            ,ayahNumber
                            , tafseerAyahResponse.getTafseerText()
                            , arabic_ayah_text
                            ,String.valueOf(sourahNumber)));

                    database.tafseerAyatsDao().insertAll(tafseerAyahResponses);
                }
                @Override
                public void onFailure(Call<TafseerAyahResponse> call, Throwable t) {
                    new BodyCallingTafseerAyah(context, tafseer_id, sourahNumber, ayahNumber, arabic_ayah_text, numberOfAyahInApi);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
