package com.example.elmus7af_elkareem.SplashScreen.Model.QuranModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuranData {
    @SerializedName("surahs")
    private List<Surahs> surahsList;


    public void setSurahsList(List<Surahs> surahsList) {
        this.surahsList = surahsList;
    }

    public List<Surahs> getSurahsList() {
        return surahsList;
    }
}
