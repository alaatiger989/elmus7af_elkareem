package com.example.elmus7af_elkareem.ReadingSourah.View.ui.home.View;

import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;

import java.util.List;

public interface IHomeSourahView {
    void onGettingAyats(List<QuranWdefaultSheikh> quranWdefaultSheikhs);
    void onGettingAyahDetails(String ayah);
}
