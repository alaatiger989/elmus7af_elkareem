package com.example.elmus7af_elkareem.Download;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.util.Log;

public class DownloadJobService extends JobService {
    private static final String TAG = "DownloadJobService";
    private boolean jobCancelled = false;
    private Context context;


    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.i(TAG , "Job Started");
        doBackgroundWork(jobParameters);
        return true;
    }

    private void doBackgroundWork(JobParameters parameters)
    {
        this.context = ContextModel.getContext();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new DownloadAudioFilesAll(context);
                    jobFinished(parameters , false);
                }catch (Exception e)
                {

                }

            }
        }).start();
    }
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.i(TAG , "Job of Downloading Souar is Cancelled before Completion");
        jobCancelled = true;
        return true;
    }
}
