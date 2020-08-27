package com.example.elmus7af_elkareem.DatabaseRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tafseer_ids")
public class TafseerNames {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "tafseer_id")
    public String Tafseer_Number;
    @ColumnInfo(name = "tafseer_name")
    public String TAFSEER_NAME;
    @ColumnInfo(name = "tafseer_author")
    public String TAFSEER_AUTHOR;
    @ColumnInfo(name = "tafseer_book_name")
    public String TAFSEER_BOOK_NAME;

    public TafseerNames(String Tafseer_Number, String TAFSEER_NAME, String TAFSEER_AUTHOR, String TAFSEER_BOOK_NAME) {
        this.Tafseer_Number = Tafseer_Number;
        this.TAFSEER_NAME = TAFSEER_NAME;
        this.TAFSEER_AUTHOR = TAFSEER_AUTHOR;
        this.TAFSEER_BOOK_NAME = TAFSEER_BOOK_NAME;
    }

    public String getTafseer_ID() {
        return Tafseer_Number;
    }

    public String getTAFSEER_NAME() {
        return TAFSEER_NAME;
    }

    public String getTAFSEER_AUTHOR() {
        return TAFSEER_AUTHOR;
    }

    public String getTAFSEER_BOOK_NAME() {
        return TAFSEER_BOOK_NAME;
    }
}
