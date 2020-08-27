package com.example.elmus7af_elkareem.SplashScreen.Model.QuranModel;

import com.google.gson.annotations.SerializedName;

public class Ayahs {
    @SerializedName("number")
    public String numberInApi;
    @SerializedName("audio")
    public String audio;
    @SerializedName("text")
    public String ayah;
    @SerializedName("numberInSurah")
    public String numberInSourah;
    @SerializedName("juz")
    public String juz;
    @SerializedName("page")
    public String page;
    @SerializedName("hizbQuarter")
    public String hizbQuarter;
    @SerializedName("\"sajda\"")
    public String sajda;

    public String getSajda() {
        return sajda;
    }

    public void setSajda(String sajda) {
        this.sajda = sajda;
    }

    public String getNumberInApi() {
        return numberInApi;
    }


    public void setNumberInApi(String numberInApi) {
        this.numberInApi = numberInApi;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public void setAyah(String ayah) {
        this.ayah = ayah;
    }

    public void setNumberInSourah(String numberInSourah) {
        this.numberInSourah = numberInSourah;
    }

    public void setJuz(String juz) {
        this.juz = juz;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setHizbQuarter(String hizbQuarter) {
        this.hizbQuarter = hizbQuarter;
    }



    public String getAudio() {
        return audio;
    }

    public String getAyah() {
        return ayah;
    }

    public String getNumberInSourah() {
        return numberInSourah;
    }

    public String getJuz() {
        return juz;
    }

    public String getPage() {
        return page;
    }

    public String getHizbQuarter() {
        return hizbQuarter;
    }




}
