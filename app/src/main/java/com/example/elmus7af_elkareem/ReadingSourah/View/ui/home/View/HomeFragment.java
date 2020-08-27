package com.example.elmus7af_elkareem.ReadingSourah.View.ui.home.View;

import android.os.Bundle;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;
import com.example.elmus7af_elkareem.R;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.home.Presenter.HomeSourahPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeFragment extends Fragment implements IHomeSourahView{


    TextView sourahName, sourahAyats , sourahBasmalah;
    View root;
    HomeSourahPresenter homeSourahPresenter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        sourahAyats = root.findViewById(R.id.sourah_ayats);
        sourahName = root.findViewById(R.id.sourah_name);
        sourahBasmalah = root.findViewById(R.id.sourah_basmalah);
        homeSourahPresenter = new HomeSourahPresenter(this);
        homeSourahPresenter.sendingAyatsToView(getContext());

        return root;
    }

    @Override
    public void onGettingAyats(List<QuranWdefaultSheikh> quranWdefaultSheikhs) {
        sourahName.setText(quranWdefaultSheikhs.get(0).getARABIC_NAME());
        for (int i = 0 ; i < quranWdefaultSheikhs.size() ; i++)
        {
            if (i==0)
            {
                int len = quranWdefaultSheikhs.get(i).ARABIC_AYAH_TEXT.length();
                String basmla = quranWdefaultSheikhs.get(i).ARABIC_AYAH_TEXT.substring(0 , 38)  ;
                String continueAyah =  quranWdefaultSheikhs.get(i).ARABIC_AYAH_TEXT.substring(38 , len);
                sourahAyats.append(continueAyah + "\uF069" + (i+1) + "\uF070" );
            }
            else {
                String continueAyah = quranWdefaultSheikhs.get(i).getARABIC_AYAH_TEXT();
                sourahAyats.append(continueAyah + "\uF069" + (i+1) + "\uF070");
            }
        }
        init();
        quranWdefaultSheikhs = new ArrayList<>();
    }

    @Override
    public void onGettingAyahDetails(String ayah) {
        Toast.makeText(getContext() , ayah , Toast.LENGTH_LONG).show();
    }

    List<Integer> listForStart ,listForEnd;
    private   int start ,end;
    private void init() {
        String definition = sourahAyats.getText().toString().trim();
        TextView definitionView;
        definitionView = root.findViewById(R.id.sourah_ayats);
        definitionView.setMovementMethod(LinkMovementMethod.getInstance());
        definitionView.setText(definition, TextView.BufferType.SPANNABLE);
        Spannable spans = (Spannable) definitionView.getText();
        String T = definitionView.getText().toString();
        listForStart = new ArrayList<>();
        listForEnd = new ArrayList<>();
        for(int i = 0; i<T.length();i++){ //getting the list completed
            if(T.charAt(i)=='\uF069'){ //found a space //go backwards unti
                listForEnd.add(i);

            }
            if (T.charAt(i)=='\uF070')
            {
                listForStart.add(i);

            }

        }
        for (int i = 0 ; i < listForStart.size() ; i++)
        {
            start = listForEnd.get(i);
            end = listForStart.get(i)+1;
            String possibleWord = definition.substring(start,end);
            ClickableSpan clickSpan = getClickableSpan(possibleWord);
                spans.setSpan(clickSpan, listForEnd.get(i), end,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }
    private ClickableSpan getClickableSpan(final String word) {
        return new ClickableSpan() {
            String mWord;
            {
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(word);
                while(m.find()) {
                    mWord = m.group();
                }
            }
            @Override
            public void onClick(View widget) {
                homeSourahPresenter.gettingAyahAudio(requireContext(), mWord);
            }

            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
            }
        };
    }



    @Override
    public void onStop() {
        super.onStop();
        homeSourahPresenter.stopAudioInBackPressed();

    }
}
