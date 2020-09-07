package com.example.elmus7af_elkareem.ParentsPresenter;

import java.io.File;

public class FolderSize {

    public static long getFolderSize(File file) {
        long size = 0;
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                size += getFolderSize(child);
            }
        } else {
            size = file.length();
        }
        return size;
    }
}
