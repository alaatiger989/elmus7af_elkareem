package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.View;

import com.example.elmus7af_elkareem.DatabaseRoom.TafseerNames;
import com.example.elmus7af_elkareem.SplashScreen.Model.TafseerIDsModel.TafseerListResponse;

import java.util.List;

public interface ITafseerListView {
    void onGettingTafseerResponse(List<TafseerNames> tafseerResponse);
    void isDataDownloaded(boolean result);
}
