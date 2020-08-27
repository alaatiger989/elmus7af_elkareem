package com.example.elmus7af_elkareem.NotificationHandling;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.elmus7af_elkareem.R;



public class NotificationGenerator {
    private MediaSessionCompat mediaSession;
    private NotificationManagerCompat notificationManager;

    public void cancelNotification(Context context)
    {
        notificationManager = NotificationManagerCompat.from(context);
        notificationManager.cancelAll();
    }

    public void DownloadNotification(final Context context)
    {

        notificationManager = NotificationManagerCompat.from(context);
        Bitmap artwork = BitmapFactory.decodeResource(context.getResources(), R.drawable.quran_logo);

        Intent activityIntent = new Intent(context, ReceiverToDownload.class);
        PendingIntent contentIntent = PendingIntent.getBroadcast(context, 0, activityIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        final NotificationCompat.Builder nc = new NotificationCompat.Builder(context , NotificationChannels.CHANNEL_1_ID);

        nc.setSmallIcon(R.drawable.quran_logo);
        nc.setContentTitle("المصحف");
        nc.setContentText("Download in progress");
        nc.setLargeIcon(artwork);
        nc.addAction(R.drawable.quran_logo, "Download", contentIntent);

        nc.setPriority(NotificationCompat.PRIORITY_HIGH);
        nc.setOnlyAlertOnce(true);
        nc.setOngoing(true);
        nc.setOnlyAlertOnce(true);
//        nc.setProgress(progressMax , 0 , false);



        notificationManager.notify(1, nc.build());


    }

    public void DownloadBtnClicked(Context context)
    {
        notificationManager = NotificationManagerCompat.from(context);
        Bitmap artwork = BitmapFactory.decodeResource(context.getResources(), R.drawable.quran_logo);

        Intent activityIntent = new Intent(context, ReceiverToDownload.class);
        PendingIntent contentIntent = PendingIntent.getBroadcast(context, 0, activityIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        final NotificationCompat.Builder nc = new NotificationCompat.Builder(context , NotificationChannels.CHANNEL_1_ID);

        nc.setSmallIcon(R.drawable.quran_logo);
        nc.setContentTitle("المصحف");
        nc.setContentText("Download in progress");
        nc.setLargeIcon(artwork);


        nc.setPriority(NotificationCompat.PRIORITY_HIGH);
        nc.setOnlyAlertOnce(true);
        nc.setOngoing(false);
        nc.setOnlyAlertOnce(true);

        notificationManager.notify(1, nc.build());



    }

    public void DownloadCompleted(Context context)
    {
        notificationManager = NotificationManagerCompat.from(context);
        Bitmap artwork = BitmapFactory.decodeResource(context.getResources(), R.drawable.quran_logo);


        final NotificationCompat.Builder nc = new NotificationCompat.Builder(context , NotificationChannels.CHANNEL_1_ID);

        nc.setSmallIcon(R.drawable.quran_logo);
        nc.setContentTitle("المصحف");
        nc.setContentText("Download is Finished");
        nc.setLargeIcon(artwork);
        nc.setPriority(NotificationCompat.PRIORITY_HIGH);
        nc.setOnlyAlertOnce(true);
        nc.setOngoing(false);
        nc.setOnlyAlertOnce(true);

        notificationManager.notify(1, nc.build());

    }

}
