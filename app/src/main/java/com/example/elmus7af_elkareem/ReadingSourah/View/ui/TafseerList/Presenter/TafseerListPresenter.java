package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.Presenter;

import android.content.Context;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.TafseerNames;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.View.ITafseerListView;

import java.util.ArrayList;
import java.util.List;

public class TafseerListPresenter {
    private ITafseerListView tafseerView;
    private Context context;

    private List<TafseerNames> tafseerNames = new ArrayList<>();
    public TafseerListPresenter(ITafseerListView tafseerView) {
        this.tafseerView = tafseerView;

    }

    public void checkDataDownloaded(Context context) {
        this.context = context;
        AppDatabase database = AppDatabase.getInstance(context);
        tafseerNames.addAll(database.tafseerIdDao().getTafseerIds());
        if (database.tafseerIdDao().getCount() > 0)
        {
            tafseerView.isDataDownloaded(true);
        }
        else{
            tafseerView.isDataDownloaded(false);
        }
    }

    public void initListOfTafseerNames() {

        tafseerView.onGettingTafseerResponse(tafseerNames);
    }
}
