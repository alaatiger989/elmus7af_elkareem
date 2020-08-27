package com.example.elmus7af_elkareem.DatabaseRoom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface DAO{

    @Dao
    interface Quran{
        @Query("SELECT * FROM quran")
        List<QuranWdefaultSheikh> getQuran();

        @Query("SELECT * FROM quran WHERE sourah_number LIKE :sourahNumber LIMIT 1")
        List<QuranWdefaultSheikh> getSourahDetails(String sourahNumber);

        @Query("SELECT * FROM quran WHERE sourah_number LIKE :sourahNumber")
        List<QuranWdefaultSheikh> getSourahAyat(String sourahNumber);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(QuranWdefaultSheikh sourah);
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(List<QuranWdefaultSheikh> sourahs);

        @Query("SELECT COUNT(*) FROM quran")
        int getCount();

        @Query("Select * FROM quran WHERE sourah_number LIKE :sourahNumber AND number_in_sourah LIKE :numberInSourah")
        List<QuranWdefaultSheikh> getAyahDetails(String sourahNumber , String numberInSourah);

    }

    @Dao
    interface tafseerId{
        @Query("SELECT * FROM tafseer_ids")
        List<TafseerNames> getTafseerIds();

        @Query("SELECT * FROM tafseer_ids WHERE tafseer_id LIKE :tafseerId LIMIT 1")
        List<TafseerNames> getTafseerDetails(String tafseerId);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(TafseerNames tafseerName);
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(List<TafseerNames> tafseerNames);

        @Query("SELECT COUNT(*) FROM tafseer_ids")
        int getCount();

    }

    @Dao
    interface tafseerAyats{
        @Query("SELECT * FROM tafseer_ayats")
        List<TafseerAyats> getTafseerIds();

        @Query("SELECT * FROM tafseer_ayats WHERE tafseer_id LIKE :tafseerId")
        List<TafseerAyats> getTafseerDetails(String tafseerId);

        @Query("SELECT * FROM tafseer_ayats WHERE tafseer_id LIKE :tafseerId LIMIT 1")
        List<TafseerAyats> getFirstTafseerDetails(String tafseerId);

        @Query("SELECT * FROM tafseer_ayats WHERE sourah_number LIKE :sourahNumber")
        List<TafseerAyats> getSourahAyat(String sourahNumber);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(TafseerAyats tafseerAyat);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(List<TafseerAyats> tafseerAyats);

        @Query("SELECT COUNT(*) FROM tafseer_ayats")
        int getCount();

        @Query("Delete from tafseer_ayats")
        void delete();
    }

}


