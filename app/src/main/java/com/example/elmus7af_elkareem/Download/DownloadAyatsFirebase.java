package com.example.elmus7af_elkareem.Download;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

public class DownloadAyatsFirebase {
    private long downloadId;
    Context context;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    public static int counter = 1;


    public DownloadAyatsFirebase(Context context, String numberOfSourah, String numberOfAyah) {
        this.context = context;

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Ayats/"+numberOfSourah+"/"+numberOfAyah+".mp3");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                downloadFiles(numberOfSourah,uri , numberOfAyah);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    private void downloadFiles(String numberOfSouarh , Uri uri , String numberOfAyah) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setDestinationInExternalFilesDir(context , "Ayats/"+numberOfSouarh,numberOfAyah+".mp3");
        downloadManager.enqueue(request);
    }
}
