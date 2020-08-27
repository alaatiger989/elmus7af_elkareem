package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerSourah.Presenter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;
import com.example.elmus7af_elkareem.DatabaseRoom.TafseerAyats;
import com.example.elmus7af_elkareem.ParentsModel.SourahDataParentModel;
import com.example.elmus7af_elkareem.ReadingSourah.Model.ReadingSourahModel;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerSourah.Model.TafseerSourahModel;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerSourah.View.ITafseerSourahView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TafseerSourahPresenter {

    private ITafseerSourahView tafseerSourahView;
    private List<TafseerAyats> tafseerAyats = new ArrayList<>();
    private TafseerSourahModel tafseerSourahModel = new TafseerSourahModel();
    private  Context context;
    private MediaPlayer audioPlayer;
    public TafseerSourahPresenter(ITafseerSourahView tafseerSourahView) {
        this.tafseerSourahView = tafseerSourahView;
    }

    public void getTafseerAyats(Context context){
        this.context = context;
        AppDatabase database = AppDatabase.getInstance(context);
        tafseerAyats.addAll(database.tafseerAyatsDao().getSourahAyat(SourahDataParentModel.getNumberOfCurrentSourah()));
        tafseerSourahView.onGettingTafseerAyah(tafseerAyats);
    }

    public void filterSourah(String filterString)
    {
        final String query = filterString.toString().toLowerCase().trim();
        final ArrayList<TafseerAyats> filteredList = new ArrayList<>();

        tafseerSourahModel.getOriginalIndexForTafseerSourah().clear();
        for (int i = 0; i < tafseerAyats.size(); i++) {

            final String searchWAyah = tafseerAyats.get(i).getAyahText().toLowerCase();
            final String searchWTafseerText = tafseerAyats.get(i).getTafseerText().toLowerCase();
            final String searchWAyahNumber = String.valueOf(tafseerAyats.get(i).getAyahNumber()).toLowerCase();

            if (searchWAyah.contains(query) || searchWTafseerText.contains(query)|| searchWAyahNumber.equalsIgnoreCase(query)) {
                filteredList.add(tafseerAyats.get(i));
                tafseerSourahModel.getOriginalIndexForTafseerSourah().add(i+1);
                tafseerSourahView.onGettingTafseerAyah(filteredList);
            }
        }
    }

    public void handlingClickOnTafseerItem(int position)
    {
        if (tafseerSourahModel.getOriginalIndexForTafseerSourah().size() == 0)
        {
            tafseerSourahView.beforeSearch(context , position);
        }
        else{

            tafseerSourahView.onSearch(context , tafseerSourahModel.getOriginalIndexForTafseerSourah().get(position)-1);
        }
    }
    public void initAudioForTafseerItem(int position)
    {
        // I put them again to get the data from files
        File file = new File(context.getExternalFilesDir(""),"/Souar");
        File file2 = new File(context.getExternalFilesDir(""),"/Ayats");
        if (file.exists() && file2.exists())
        {

            if (audioPlayer!=null && audioPlayer.isPlaying())
            {
                audioPlayer.reset();
                try {
                    audioPlayer.setDataSource(file2.toString()+"/"+ SourahDataParentModel.getNumberOfCurrentSourah()+"/"+(position+1)+".mp3");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    audioPlayer.prepare();
                    audioPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                audioPlayer = new MediaPlayer();
                audioPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    audioPlayer.setDataSource(file2.toString()+"/"+ SourahDataParentModel.getNumberOfCurrentSourah()+"/"+(position+1)+".mp3");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    audioPlayer.prepare();
                    audioPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            DrawerLayout drawer = ReadingSourahModel.getDrawer();
            drawer.openDrawer(GravityCompat.START);
        }
    }

    public void stopAudioInBackPressed() {
        if (audioPlayer!=null && audioPlayer.isPlaying())
        {
            audioPlayer.stop();
        }
    }



}
