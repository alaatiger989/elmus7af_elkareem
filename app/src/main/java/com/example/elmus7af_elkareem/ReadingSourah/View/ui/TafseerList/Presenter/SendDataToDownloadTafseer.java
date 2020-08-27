package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.Presenter;

import android.content.Context;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;
import com.example.elmus7af_elkareem.DatabaseRoom.TafseerAyats;
import com.example.elmus7af_elkareem.DatabaseRoom.TafseerNames;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SendDataToDownloadTafseer {
    List<TafseerNames> tafseerNames = new ArrayList<>();

    List<QuranWdefaultSheikh> quranWdefaultSheikhs = new ArrayList<>();
    List<TafseerAyats> tafseerAyats = new ArrayList<>();
    private  int i , n ,k;
    public void DownloadTafseerAyats(Context context, int tafseerId){
        AppDatabase database = AppDatabase.getInstance(context);
        tafseerAyats.addAll(database.tafseerAyatsDao().getTafseerDetails(String.valueOf(tafseerId)));
        if (database.quranDao().getCount() == 6236 && database.tafseerIdDao().getCount() > 0 && tafseerAyats.size()!=6236)
        {
            database.tafseerAyatsDao().delete();
                try {
                    for (k = 1 ; k <= 114 ;k++ )
                    {
                        quranWdefaultSheikhs = new ArrayList<>();
                        quranWdefaultSheikhs.addAll(database.quranDao().getSourahAyat(String.valueOf(k)));

                        for (n = 1 ; n <= quranWdefaultSheikhs.size() ; n++)
                        {
                            new BodyCallingTafseerAyah(context , String.valueOf(tafseerId) , k , n ,quranWdefaultSheikhs.get(n-1).getARABIC_AYAH_TEXT() , quranWdefaultSheikhs.get(n-1).getNUMBER_IN_API());
                        }


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        else {


        }
    }

}
