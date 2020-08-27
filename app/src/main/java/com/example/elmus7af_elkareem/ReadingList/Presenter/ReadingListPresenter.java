package com.example.elmus7af_elkareem.ReadingList.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.DAO;
import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;
import com.example.elmus7af_elkareem.ParentsModel.SourahDataParentModel;
import com.example.elmus7af_elkareem.ReadingList.Model.ReadingListModel;
import com.example.elmus7af_elkareem.ReadingList.View.IReadingListView;

import java.util.ArrayList;
import java.util.List;

public class ReadingListPresenter{
    private IReadingListView readingListView;
    private List<QuranWdefaultSheikh> quranWdefaultSheikhs;
    private ReadingListModel readingListModel = new ReadingListModel();
    public ReadingListPresenter(IReadingListView readingListView) {
        this.readingListView = readingListView;
    }

    public void getSouarFromDatabase(Context context)
    {
        AppDatabase database = AppDatabase.getInstance(context);
        quranWdefaultSheikhs = new ArrayList<>();
        for (int i = 1 ; i <= 114 ; i ++)
        {
            quranWdefaultSheikhs.addAll(database.quranDao().getSourahDetails(String.valueOf(i)));
        }
        readingListView.onGetSouarDetails(quranWdefaultSheikhs);
    }

    public void filterSourah(String filterString)
    {
        final String query = filterString.toString().toLowerCase().trim();
        final ArrayList<QuranWdefaultSheikh> filteredList = new ArrayList<>();

        readingListModel.getOriginalIndexForReadingList().clear();
        for (int i = 0; i < quranWdefaultSheikhs.size(); i++) {

            final String searchWEnglishName = quranWdefaultSheikhs.get(i).getARABIC_NAME().toLowerCase();
            final String searchWArabicName = quranWdefaultSheikhs.get(i).getSOURAH_NAME().toLowerCase();
            final String searchWEnglishType = quranWdefaultSheikhs.get(i).getREVELATION_TYPE().toLowerCase();
            final String searchWSourahNumber = quranWdefaultSheikhs.get(i).getSOURAH_NUMBER().toLowerCase();
            if (searchWEnglishName.contains(query) || searchWArabicName.contains(query)|| searchWSourahNumber.equalsIgnoreCase(query) || searchWEnglishType.contains(query) ) {
                filteredList.add(quranWdefaultSheikhs.get(i));
                readingListModel.getOriginalIndexForReadingList().add(i+1);
                readingListView.onGetSouarDetails(filteredList);
            }
        }



    }

    public void handlingClickOnSourahItem(Context context, String numberOfSourah, String arabic_name, String number_of_ayats)
    {

        if (readingListModel.getOriginalIndexForReadingList().size() == 0)
        {
            SourahDataParentModel.setNumberOfCurrentSourah(numberOfSourah);
            SourahDataParentModel.setNameOfCurrentSourah(arabic_name);
            SourahDataParentModel.setNumberOfAyatsOfCurrentSourah(number_of_ayats);
            readingListView.beforeSearch(context);
        }
        else{
            SourahDataParentModel.setNumberOfCurrentSourah(String.valueOf(readingListModel.getOriginalIndexForReadingList().get(Integer.parseInt(numberOfSourah)-1)));
            SourahDataParentModel.setNameOfCurrentSourah(arabic_name);
            SourahDataParentModel.setNumberOfAyatsOfCurrentSourah(number_of_ayats);
            readingListView.onSearch(context);
        }

    }
}
