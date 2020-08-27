package com.example.elmus7af_elkareem.SplashScreen.Presenter;

import android.content.Context;


import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.TafseerNames;
import com.example.elmus7af_elkareem.SplashScreen.Data.TafseerRetrofit.RetrofitClientTafseerList;

import com.example.elmus7af_elkareem.SplashScreen.Model.TafseerIDsModel.TafseerListResponse;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.View.ITafseerListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BodyCallingTafsserIDs {
    List<TafseerNames> tafseerNames = new ArrayList<>();
    public BodyCallingTafsserIDs(final Context context)
    {
        AppDatabase database = AppDatabase.getInstance(context);
        Call<List<TafseerListResponse>> call = RetrofitClientTafseerList.getInstance().getTafseerApi().getTafseerDetails();
        call.enqueue(new Callback<List<TafseerListResponse>>() {
            @Override
            public void onResponse(Call<List<TafseerListResponse>> call, Response<List<TafseerListResponse>> response) {
                List<TafseerListResponse> tafseerListResponse = response.body();
                for (int i = 0 ; i < tafseerListResponse.size() ; i++)
                {
                    tafseerNames.add(new TafseerNames(String.valueOf(tafseerListResponse.get(i).getId()),tafseerListResponse.get(i).getName(),tafseerListResponse.get(i).getAuthor(),tafseerListResponse.get(i).getBookName()));
                }
                database.tafseerIdDao().insertAll(tafseerNames);
            }

            @Override
            public void onFailure(Call<List<TafseerListResponse>> call, Throwable t) {
                new BodyCallingTafsserIDs(context);
            }
        });
    }
}
