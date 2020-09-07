package com.example.elmus7af_elkareem.Download;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

public class JobScheduler {

    private Context context;
    private static final String TAG = "JobScheduler";


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void scheduleJob(Context context) {

        ComponentName componentName = new ComponentName(context, DownloadJobService.class);

        JobInfo info = new JobInfo.Builder(123, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setRequiresStorageNotLow(true)
                .build();
        android.app.job.JobScheduler scheduler = (android.app.job.JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        int resultCode = scheduler.schedule(info);
        if(resultCode == android.app.job.JobScheduler.RESULT_SUCCESS)
        {
            Log.i(TAG , "Job Scheduled");
        }
        else{
            Log.i(TAG , "Job Scheduling Failed");
        }
    }
    protected void cancelJob(Context context)
    {
        android.app.job.JobScheduler scheduler = (android.app.job.JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        scheduler.cancel(123);
        Log.i(TAG , "Job Cancelled");
    }

}
