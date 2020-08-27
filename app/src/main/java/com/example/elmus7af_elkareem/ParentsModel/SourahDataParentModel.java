package com.example.elmus7af_elkareem.ParentsModel;

public abstract class SourahDataParentModel {

    private static String nameOfCurrentSourah;
    private static String numberOfCurrentSourah;
    private static String numberOfAyatsOfCurrentSourah;
    private static String juzOfCurrent;


    public static String getNameOfCurrentSourah() {
        return nameOfCurrentSourah;
    }

    public static void setNameOfCurrentSourah(String nameOfCurrentSourah) {
        SourahDataParentModel.nameOfCurrentSourah = nameOfCurrentSourah;
    }

    public static String getNumberOfCurrentSourah() {
        return numberOfCurrentSourah;
    }

    public static void setNumberOfCurrentSourah(String numberOfCurrentSourah) {
        SourahDataParentModel.numberOfCurrentSourah = numberOfCurrentSourah;
    }

    public static String getNumberOfAyatsOfCurrentSourah() {
        return numberOfAyatsOfCurrentSourah;
    }

    public static void setNumberOfAyatsOfCurrentSourah(String numberOfAyatsOfCurrentSourah) {
        SourahDataParentModel.numberOfAyatsOfCurrentSourah = numberOfAyatsOfCurrentSourah;
    }

    public static String getJuzOfCurrent() {
        return juzOfCurrent;
    }

    public static void setJuzOfCurrent(String juzOfCurrent) {
        SourahDataParentModel.juzOfCurrent = juzOfCurrent;
    }
}
