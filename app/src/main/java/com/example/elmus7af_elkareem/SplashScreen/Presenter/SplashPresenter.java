package com.example.elmus7af_elkareem.SplashScreen.Presenter;

import android.content.Context;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.ParentsModel.DataParentModel;
import com.example.elmus7af_elkareem.SplashScreen.View.IMainView;

import java.io.File;

public class SplashPresenter {
    private IMainView mainView;
    private Context context;
    public SplashPresenter(IMainView mainView) {
        this.mainView = mainView;
    }

    public boolean checkTextDownloadedData(Context context){

        AppDatabase database = AppDatabase.getInstance(context);
        if (database.quranDao().getCount() == 6236)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public void checkFilesOfAudio()
    {
        File file = new File(context.getExternalFilesDir(""),"/Souar");
        File file2 = new File(context.getExternalFilesDir(""),"/Ayats");
        if (file.exists() && file2.exists())
        {
            DataParentModel.setAudioDataDownloaded(true);
        }
        else{

            DataParentModel.setAudioDataDownloaded(false);
        }
    }
    //To View
    public void getResultOfCheck(Context context)
    {
        this.context = context;
        DataParentModel.setTextDataDownloaded(checkTextDownloadedData(context));
        mainView.onGetResultOfCheck(checkTextDownloadedData(context));
    }

    public void DownloadData(){
        new BodyCallingQuran(context);
    }
    public void DownloadTafseerId(){new BodyCallingTafsserIDs(context);}


}
