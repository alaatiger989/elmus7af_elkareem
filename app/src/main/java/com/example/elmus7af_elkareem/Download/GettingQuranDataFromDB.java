package com.example.elmus7af_elkareem.Download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;
import com.example.elmus7af_elkareem.NotificationHandling.NotificationGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class GettingQuranDataFromDB {
    public AppDatabase db;
    public List<QuranWdefaultSheikh> quranWdefaultSheikhList = new ArrayList<>();

    @SuppressLint("CheckResult")
    public GettingQuranDataFromDB(Context context) {
        db = AppDatabase.getInstance(context);
//        quranWdefaultSheikhList.addAll(db.quranDao().getQuran());

        for (int i = 1 ; i<=114 ; i++)
        {
            quranWdefaultSheikhList.addAll(db.quranDao().getSourahDetails(String.valueOf(i)));
        }

        for (int i = 1  ; i<=quranWdefaultSheikhList.size() ; i++ )
        {
            new DownloadSouarFirebase(context , String.valueOf(i));
        }




        //Download Ayats
        for (int i = 1 ; i <= quranWdefaultSheikhList.size() ; i++)
        {
            Log.i("elmushafDB" , "Iam in Sourah "+ i + " and number of ayats are : "+quranWdefaultSheikhList.get(i-1).getNUMBER_OF_AYATS() );


            for(int k = 1 ; k<= Integer.parseInt(quranWdefaultSheikhList.get(i-1).getNUMBER_OF_AYATS()) ; k++)
            {
                    new DownloadAyatsFirebase(context , String.valueOf(i) , String.valueOf(k));
            }

        }
    }








}
