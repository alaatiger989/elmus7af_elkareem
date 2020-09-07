package com.example.elmus7af_elkareem.Download;

import android.content.Context;

public class ContextModel {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        ContextModel.context = context;
    }
}
