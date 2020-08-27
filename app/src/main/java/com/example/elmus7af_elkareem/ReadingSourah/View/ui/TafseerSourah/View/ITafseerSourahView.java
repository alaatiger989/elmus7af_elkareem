package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerSourah.View;

import android.content.Context;

import com.example.elmus7af_elkareem.DatabaseRoom.TafseerAyats;

import java.util.List;

public interface ITafseerSourahView {
    void onGettingTafseerAyah(List<TafseerAyats> tafseerAyats);
    void beforeSearch(Context context , int position);
    void onSearch(Context context , int position);
}
