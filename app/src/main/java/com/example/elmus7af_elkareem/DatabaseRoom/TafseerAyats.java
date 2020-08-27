package com.example.elmus7af_elkareem.DatabaseRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tafseer_ayats")
public class TafseerAyats {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "tafseer_id")
    public String Tafseer_Number;
    @ColumnInfo(name = "tafseer_name")
    public String TAFSEER_NAME;
    @ColumnInfo(name = "ayah_number")
    public int ayahNumber;
    @ColumnInfo(name = "tafseer_text")
    public String tafseerText;
    @ColumnInfo(name = "ayah_text")
    public String ayahText;
    @ColumnInfo(name = "sourah_number")
    public String sourahNumber;

    public TafseerAyats(int id , String Tafseer_Number, String TAFSEER_NAME, int ayahNumber, String tafseerText, String ayahText, String sourahNumber) {
        this.id = id;
        this.Tafseer_Number = Tafseer_Number;
        this.TAFSEER_NAME = TAFSEER_NAME;
        this.ayahNumber = ayahNumber;
        this.tafseerText = tafseerText;
        this.ayahText = ayahText;
        this.sourahNumber = sourahNumber;
    }

    public int getId(){return id;}
    public String getTafseer_ID() {
        return Tafseer_Number;
    }

    public String getTAFSEER_NAME() {
        return TAFSEER_NAME;
    }

    public int getAyahNumber() {
        return ayahNumber;
    }

    public String getTafseerText() {
        return tafseerText;
    }

    public String getAyahText() {
        return ayahText;
    }

    public String getSourahNumber() {
        return sourahNumber;
    }
}
