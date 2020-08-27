package com.example.elmus7af_elkareem.NotificationHandling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.elmus7af_elkareem.Download.GettingQuranDataFromDB;


public class ReceiverToDownload extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        new NotificationGenerator().DownloadBtnClicked(context);
        new GettingQuranDataFromDB(context);

    }
}
