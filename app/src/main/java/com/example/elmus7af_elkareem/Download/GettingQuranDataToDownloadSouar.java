package com.example.elmus7af_elkareem.Download;

import android.content.Context;
import android.util.Log;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GettingQuranDataToDownloadSouar {
    private   AppDatabase db;
    private List<QuranWdefaultSheikh> quranWdefaultSheikhList = new ArrayList<>();

    private static final String TAG = "GettingToDownloadSouar";
    protected void GettingData(Context context)
    {
        db = AppDatabase.getInstance(context);

        for (int i = 1 ; i<=114 ; i++)
        {
            quranWdefaultSheikhList.addAll(db.quranDao().getSourahDetails(String.valueOf(i)));
        }

        File file = new File(context.getExternalFilesDir(""),"/Souar/114.mp3");
        //Download Souars
        for (int i = 1  ; i<=quranWdefaultSheikhList.size() ; i++ )
        {
            new DownloadSouarFirebase(context , String.valueOf(i));


        }
    }
}
