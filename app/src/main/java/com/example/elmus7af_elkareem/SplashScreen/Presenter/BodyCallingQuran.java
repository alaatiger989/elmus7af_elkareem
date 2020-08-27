package com.example.elmus7af_elkareem.SplashScreen.Presenter;

import android.content.Context;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;
import com.example.elmus7af_elkareem.SplashScreen.Data.QuranRetrofit.RetrofitClientQuran;
import com.example.elmus7af_elkareem.SplashScreen.Model.QuranModel.QuranResponse;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BodyCallingQuran {

    public List<QuranWdefaultSheikh> quranWdefaultSheikhList = new ArrayList<>();
    public AppDatabase db;
    public BodyCallingQuran(final Context context)
    {
        db = AppDatabase.getInstance(context);
        Call<QuranResponse> call = RetrofitClientQuran.getInstance().getSourahs().getQuran();
        call.enqueue(new Callback<QuranResponse>() {
            @Override
            public void onResponse(Call<QuranResponse> call, Response<QuranResponse> response) {
                QuranResponse quranResponse = response.body();
                try{
                    if(quranResponse.getCode() == 200)
                    {

                        try{
                            for (int i = 0 ; i < quranResponse.getData().getSurahsList().size() ; i++)
                            {
                                for (int k = 0; k < quranResponse.getData().getSurahsList().get(i).getAyahsList().size() ; k++)
                                {
                                    quranWdefaultSheikhList.add(new QuranWdefaultSheikh(Integer.parseInt(quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getNumberInApi())
                                            ,quranResponse.getData().getSurahsList().get(i).getEnglishName()
                                            ,quranResponse.getData().getSurahsList().get(i).getNumberOfSourah()
                                            ,quranResponse.getData().getSurahsList().get(i).getArabicName()
                                            ,quranResponse.getData().getSurahsList().get(i).getRevelationType()
                                            , "ar.alafasy"
                                            ,"El Afasy"
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getAudio()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getAyah()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getNumberInSourah()
                                            ,String.valueOf(quranResponse.getData().getSurahsList().get(i).getAyahsList().size())
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getNumberInApi()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getJuz()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getSajda()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getPage()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getHizbQuarter()
                                    ));

                                }
                                try {
                                    db.quranDao().insertAll(quranWdefaultSheikhList);
                                    quranWdefaultSheikhList = new ArrayList<>();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<QuranResponse> call, Throwable t) {
                new BodyCallingQuran(context);

            }
        });
    }
}
