package com.example.elmus7af_elkareem.Download;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.elmus7af_elkareem.NotificationHandling.NotificationGenerator;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DownloadSouarFirebase{
    private long downloadId;
    Context context;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    private static int count = 1 ;
    private static final String TAG = "DownloadSouarFirebase";




    public DownloadSouarFirebase(Context context , String numberOfSouarh) {
            this.context = context;

            storageReference = firebaseStorage.getInstance().getReference();
            ref = storageReference.child("Souar/"+numberOfSouarh+".mp3");
            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                        downloadFiles(numberOfSouarh,uri);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

    }

    private void downloadFiles(String numberOfSouarh , Uri uri) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setDestinationInExternalFilesDir(context , "Souar",numberOfSouarh+".mp3");
        request.setDescription("سورة" + " " + numberOfSouarh + " .mp3");
        downloadManager.enqueue(request);


    }


}
