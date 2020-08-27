package com.example.elmus7af_elkareem.ReadingList.View;

import android.content.Context;

import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;

import java.util.List;

public interface IReadingListView {
    void onGetSouarDetails(List<QuranWdefaultSheikh> quranWdefaultSheikhs);

    void beforeSearch(Context context);
    void onSearch(Context context);

}
