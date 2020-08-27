package com.example.elmus7af_elkareem.DatabaseRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quran")
public class QuranWdefaultSheikh {
    @PrimaryKey(autoGenerate = true)
    public int id;

    /**************  Data of Each Sourah  **************/
    @ColumnInfo(name = "sourah_english_name")
    public String SOURAH_NAME;

    @ColumnInfo(name = "sourah_number")
    public String SOURAH_NUMBER;


    @ColumnInfo(name = "sourah_arabic_name")
    public String ARABIC_NAME;

    @ColumnInfo(name = "revelationType")
    public String REVELATION_TYPE;
    /****************************************************/

    /****************** Identifier of Sheikh *****************/
    @ColumnInfo(name = "sheikh_id")
    public String sheikhId;

    @ColumnInfo(name = "sheikh_name")
    public String sheikhName;
   /***************************************************************/

    /***************** Ayats Of Each Sourah *************/
    @ColumnInfo(name = "audio")
    public String audio;

    @ColumnInfo(name = "ar_ayats")
    public String ARABIC_AYAH_TEXT;

    @ColumnInfo(name = "number_in_sourah")
    public String NUMBER_IN_SOURAH;

    @ColumnInfo(name = "number_of_ayats")
    public String NUMBER_OF_AYATS;

    @ColumnInfo(name = "number_in_api")
    public String NUMBER_IN_API;

    @ColumnInfo(name = "juz")
    public String JUZ;

    @ColumnInfo(name = "sajda")
    public String SAJDA;

    @ColumnInfo(name = "page")
    public String PAGE;

    @ColumnInfo(name = "hizb_qurater")
    public String HIZB_QUARTER;

    public QuranWdefaultSheikh(int id, String SOURAH_NAME, String SOURAH_NUMBER, String ARABIC_NAME, String REVELATION_TYPE, String sheikhId, String sheikhName, String audio, String ARABIC_AYAH_TEXT, String NUMBER_IN_SOURAH, String NUMBER_OF_AYATS, String NUMBER_IN_API, String JUZ, String SAJDA, String PAGE, String HIZB_QUARTER) {
        this.id = id;
        this.SOURAH_NAME = SOURAH_NAME;
        this.SOURAH_NUMBER = SOURAH_NUMBER;
        this.ARABIC_NAME = ARABIC_NAME;
        this.REVELATION_TYPE = REVELATION_TYPE;
        this.sheikhId = sheikhId;
        this.sheikhName = sheikhName;
        this.audio = audio;
        this.ARABIC_AYAH_TEXT = ARABIC_AYAH_TEXT;
        this.NUMBER_IN_SOURAH = NUMBER_IN_SOURAH;
        this.NUMBER_OF_AYATS = NUMBER_OF_AYATS;
        this.NUMBER_IN_API = NUMBER_IN_API;
        this.JUZ = JUZ;
        this.SAJDA = SAJDA;
        this.PAGE = PAGE;
        this.HIZB_QUARTER = HIZB_QUARTER;
    }

    public int getId() {
        return id;
    }

    public String getSOURAH_NAME() {
        return SOURAH_NAME;
    }

    public String getSOURAH_NUMBER() {
        return SOURAH_NUMBER;
    }

    public String getARABIC_NAME() {
        return ARABIC_NAME;
    }

    public String getREVELATION_TYPE() {
        return REVELATION_TYPE;
    }

    public String getSheikhId() {
        return sheikhId;
    }

    public String getSheikhName() {
        return sheikhName;
    }

    public String getAudio() {
        return audio;
    }

    public String getARABIC_AYAH_TEXT() {
        return ARABIC_AYAH_TEXT;
    }

    public String getNUMBER_IN_SOURAH() {
        return NUMBER_IN_SOURAH;
    }

    public String getNUMBER_OF_AYATS() {
        return NUMBER_OF_AYATS;
    }

    public String getNUMBER_IN_API() {
        return NUMBER_IN_API;
    }

    public String getJUZ() {
        return JUZ;
    }

    public String getSAJDA() {
        return SAJDA;
    }

    public String getPAGE() {
        return PAGE;
    }

    public String getHIZB_QUARTER() {
        return HIZB_QUARTER;
    }
}
