package com.example.elmus7af_elkareem.SplashScreen.Model.QuranModel;

import com.example.elmus7af_elkareem.SplashScreen.Model.ParentModel;
import com.google.gson.annotations.SerializedName;

public class QuranResponse extends ParentModel {

    @SerializedName("data")
    private QuranData quranData;

    public QuranResponse(int code, String status, QuranData data) {
        this.code = code;
        this.status = status;
        this.quranData = data;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public QuranData getData() {
        return quranData;
    }

}
