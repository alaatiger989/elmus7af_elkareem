package com.example.elmus7af_elkareem.ReadingSourah.View.ui.home.Presenter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;
import com.example.elmus7af_elkareem.ParentsModel.SourahDataParentModel;
import com.example.elmus7af_elkareem.ReadingSourah.Model.ReadingSourahModel;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.home.View.IHomeSourahView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HomeSourahPresenter {
    private IHomeSourahView homeSourahView;
    private Context context;
    private MediaPlayer audioPlayer;
    public HomeSourahPresenter(IHomeSourahView homeSourahView) {
        this.homeSourahView = homeSourahView;
    }

    public List<QuranWdefaultSheikh> gettingSourahAyats()
    {

        AppDatabase database = AppDatabase.getInstance(this.context);
        List<QuranWdefaultSheikh> quranWdefaultSheikhs = new ArrayList<>();


        quranWdefaultSheikhs.addAll(database.quranDao().getSourahAyat(SourahDataParentModel.getNumberOfCurrentSourah()));


        return quranWdefaultSheikhs;
    }

    public void sendingAyatsToView(Context context)
    {
        this.context = context;
        gettingSourahAyats();
        homeSourahView.onGettingAyats(gettingSourahAyats());
    }

    public void gettingAyahDetails(String numberOfAyah)
    {

        AppDatabase database = AppDatabase.getInstance(context);
        List<QuranWdefaultSheikh> quranWdefaultSheikhs = new ArrayList<>();
        quranWdefaultSheikhs.addAll(database.quranDao().getAyahDetails(SourahDataParentModel.getNumberOfCurrentSourah() , numberOfAyah));
        homeSourahView.onGettingAyahDetails(quranWdefaultSheikhs.get(0).getARABIC_AYAH_TEXT());
    }

    public void gettingAyahAudio(Context context, String numberOfAyah)
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
                    audioPlayer.setDataSource(file2.toString()+"/"+ SourahDataParentModel.getNumberOfCurrentSourah()+"/"+numberOfAyah+".mp3");

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
                    audioPlayer.setDataSource(file2.toString()+"/"+ SourahDataParentModel.getNumberOfCurrentSourah()+"/"+numberOfAyah+".mp3");

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
