package com.example.elmus7af_elkareem.ReadingSourah.Presenter;

import android.content.Context;

import com.example.elmus7af_elkareem.NotificationHandling.NotificationGenerator;
import com.example.elmus7af_elkareem.ParentsModel.DataParentModel;
import com.example.elmus7af_elkareem.ReadingSourah.View.IReadingSourah;

import java.io.File;

public class ReadingSourahPresenter {
    private IReadingSourah readingSourah;
    private Context context;
    public ReadingSourahPresenter(IReadingSourah readingSourah) {
        this.readingSourah = readingSourah;
    }


    public void showDownloadMenuItemNav(Context context)
    {
        this.context = context;
        if (DataParentModel.isAudioDataDownloaded())
        {

            readingSourah.hideDownloadItem(false);
        }
        else{
            readingSourah.activateDownloadItem(true);
        }
    }

    public void showNotificationDownloadManager()
    {
        if (DataParentModel.isAudioDataDownloaded())
        {
            readingSourah.hideDownloadItem(true);
        }
        else{
            new NotificationGenerator().DownloadNotification(context);

        }

    }
}
