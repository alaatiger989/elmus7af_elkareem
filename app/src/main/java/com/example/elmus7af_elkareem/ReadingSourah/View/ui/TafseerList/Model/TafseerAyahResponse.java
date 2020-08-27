package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.Model;

import com.google.gson.annotations.SerializedName;

public class TafseerAyahResponse {
    @SerializedName("tafseer_id")
    private int tafseerId;
    @SerializedName("tafseer_name")
    private String tafseerName;
    @SerializedName("ayah_number")
    private int ayahNumber;
    @SerializedName("text")
    private String tafseerText;




    public TafseerAyahResponse(int tafseerId, String tafseerName, int ayahNumber, String tafseerText) {
        this.tafseerId = tafseerId;
        this.tafseerName = tafseerName;
        this.ayahNumber = ayahNumber;
        this.tafseerText = tafseerText;
    }


    public int getTafseerId() {
        return tafseerId;
    }

    public String getTafseerName() {
        return tafseerName;
    }

    public int getAyahNumber() {
        return ayahNumber;
    }

    public String getTafseerText() {
        return tafseerText;
    }
}
