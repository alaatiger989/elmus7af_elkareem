package com.example.elmus7af_elkareem.SplashScreen.View;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.MainView.View.MainViews;
import com.example.elmus7af_elkareem.NotificationHandling.NotificationGenerator;
import com.example.elmus7af_elkareem.R;
import com.example.elmus7af_elkareem.SplashScreen.Presenter.BodyCallingQuran;
import com.example.elmus7af_elkareem.SplashScreen.Presenter.SplashPresenter;

import java.io.File;

public class GettingQuranData extends AsyncTask<Integer,Integer,String> {
     Context context;
    ProgressDialog progressDialog;
    IMainView mainView;
    public GettingQuranData(Context context , IMainView mainView)
    {
        this.context = context;
        this.mainView =mainView;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context ,R.style.MyTheme);
        progressDialog.setMax(114);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.setIcon(R.drawable.quran_logo);
        progressDialog.setTitle("Please Wait ...");
        progressDialog.setMessage("تحميل البيانات النصية");
        progressDialog.show();

    }
    @Override
    protected String doInBackground(Integer... integers) {
        AppDatabase db = AppDatabase.getInstance(context);
        if (db.quranDao().getCount() == 6236)
        {
            return "تم تحميل البيانات النصية بنجاح";
        }
        else{
            SplashPresenter splashPresenter = new SplashPresenter(mainView);
            splashPresenter.DownloadData();
            splashPresenter.DownloadTafseerId();
            for (int i = 0 ; i < integers[0] ; i++)
            {
                publishProgress(i *100 /100);
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return "Please Click on Download";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        progressDialog.setProgress(0);
        progressDialog.dismiss();

        Intent intent = new Intent(context , MainViews.class);
        context.startActivity(intent);



    }

}
