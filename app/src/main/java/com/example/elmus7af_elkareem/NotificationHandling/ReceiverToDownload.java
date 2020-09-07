package com.example.elmus7af_elkareem.NotificationHandling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.KeyCharacterMap;

import androidx.annotation.RequiresApi;


import com.example.elmus7af_elkareem.Download.DownloadAudioFilesAll;



public class ReceiverToDownload extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {


        new NotificationGenerator().DownloadBtnClicked(context);
        new DownloadAudioFilesAll(context);

    }
}
