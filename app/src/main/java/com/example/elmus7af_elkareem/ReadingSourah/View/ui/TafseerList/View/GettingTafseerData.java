package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.View;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.TafseerAyats;
import com.example.elmus7af_elkareem.R;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.Presenter.SendDataToDownloadTafseer;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerSourah.View.TafseerSourahFragment;

import java.util.ArrayList;
import java.util.List;

public class GettingTafseerData extends AsyncTask<Integer,Integer,String> {
     Context context;
    ProgressDialog progressDialog;
    int tafseerId;
    private List<TafseerAyats> tafseerAyats = new ArrayList<>();
    private AppDatabase database = AppDatabase.getInstance(context);
    private static final String TAG = "GettingTafseerData";
    public GettingTafseerData(Context context, int tafseerId)
    {
        this.context = context;
        this.tafseerId = tafseerId;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
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

        // Get Data of Chosen Tafseer
        tafseerAyats.addAll(database.tafseerAyatsDao().getTafseerDetails(String.valueOf(tafseerId)));
        Log.i(TAG , " There tafseer Size : " + tafseerAyats.size() );
        // Tafseer Not Existed
        if (tafseerAyats.size() == 0 )
        {
            SendDataToDownloadTafseer sendDataToDownloadTafseer = new SendDataToDownloadTafseer();
            sendDataToDownloadTafseer.DownloadTafseerAyats(context , tafseerId);
            for (int i = 0 ; i < integers[0] ; i++)
            {
                publishProgress(i *100 /100);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        else{
            return tafseerAyats.get(0).getTAFSEER_NAME();
        }
//        if (tafseerAyats.size()!=0 && tafseerAyats.get(0).getTafseer_ID().equalsIgnoreCase(String.valueOf(tafseerId)) && database.tafseerAyatsDao().getCount() == 6236)
//        {
//            return tafseerAyats.get(0).getTAFSEER_NAME();
//        }
//        else{
//            SendDataToDownloadTafseer sendDataToDownloadTafseer = new SendDataToDownloadTafseer();
//            sendDataToDownloadTafseer.DownloadTafseerAyats(context , tafseerId);
//            for (int i = 0 ; i < integers[0] ; i++)
//            {
//                publishProgress(i *100 /100);
//                try {
//                    Thread.sleep(600);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        return "تم تحميل التفسير بنجاح";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context , s , Toast.LENGTH_LONG).show();
        progressDialog.setProgress(0);
        progressDialog.dismiss();


        Fragment fragment = new TafseerSourahFragment();
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_tafseer_list, fragment);

        fragmentTransaction.commit();



    }

}
