package com.example.elmus7af_elkareem.SplashScreen.Model.QuranModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Surahs {
    @SerializedName("number")
    public String numberOfSourah;
    @SerializedName("name")
    public String arabicName;
    @SerializedName("englishName")
    public String englishName;
    @SerializedName("englishNameTranslation")
    public String englishNameTranslation;
    @SerializedName("revelationType")
    public String revelationType;
    @SerializedName("numberOfAyahs")
    private int numberOfAyahs;
    @SerializedName("ayahs")
    public List<Ayahs> ayahsList;

    public int getNumberOfAyahs() {
        return numberOfAyahs;
    }

    public void setNumberOfAyahs(int numberOfAyahs) {
        this.numberOfAyahs = numberOfAyahs;
    }

    public String getEnglishNameTranslation() {
        return englishNameTranslation;
    }

    public void setEnglishNameTranslation(String englishNameTranslation) {
        this.englishNameTranslation = englishNameTranslation;
    }


    public void setNumberOfSourah(String numberOfSourah) {
        this.numberOfSourah = numberOfSourah;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public void setRevelationType(String revelationType) {
        this.revelationType = revelationType;
    }

    public void setAyahsList(List<Ayahs> ayahsList) {
        this.ayahsList = ayahsList;
    }

    public String getNumberOfSourah() {
        return numberOfSourah;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getArabicName() {
        return arabicName;
    }

    public String getRevelationType() {
        return revelationType;
    }

    public List<Ayahs> getAyahsList() {
        return ayahsList;
    }
}
