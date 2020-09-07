package com.example.elmus7af_elkareem.ParentsModel;

public abstract class DataParentModel {
    private static boolean textDataDownloaded;
    private static boolean audioDataDownloaded;
    private static boolean souarAudioDataDownloaded;

    public static boolean isSouarAudioDataDownloaded() {
        return souarAudioDataDownloaded;
    }

    public static void setSouarAudioDataDownloaded(boolean souarAudioDataDownloaded) {
        DataParentModel.souarAudioDataDownloaded = souarAudioDataDownloaded;
    }

    public static boolean isTextDataDownloaded() {
        return textDataDownloaded;
    }

    public static void setTextDataDownloaded(boolean textDataDownloaded) {
        DataParentModel.textDataDownloaded = textDataDownloaded;
    }

    public static boolean isAudioDataDownloaded() {
        return audioDataDownloaded;
    }

    public static void setAudioDataDownloaded(boolean audioDataDownloaded) {
        DataParentModel.audioDataDownloaded = audioDataDownloaded;
    }
}
