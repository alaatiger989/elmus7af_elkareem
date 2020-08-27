package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerSourah.View;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.elmus7af_elkareem.DatabaseRoom.TafseerAyats;
import com.example.elmus7af_elkareem.ParentsModel.SourahDataParentModel;
import com.example.elmus7af_elkareem.R;
import com.example.elmus7af_elkareem.ReadingSourah.Model.ReadingSourahModel;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerSourah.Presenter.TafseerSourahPresenter;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class TafseerSourahFragment extends Fragment implements ITafseerSourahView{

    private TextView sourahName;
    private RecyclerView tafseerAyatRecyclerView;
    private EditText editTextSearch;
    private TafseerSourahPresenter tafseerSourahPresenter;

    public TafseerSourahFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tafseer_sourah, container, false);


        editTextSearch = v.findViewById(R.id.edittext_search);
        sourahName = v.findViewById(R.id.sourah_name);
        tafseerAyatRecyclerView = v.findViewById(R.id.tafseer_ayat_recyclerView);

        sourahName.setText(SourahDataParentModel.getNameOfCurrentSourah());
        tafseerSourahPresenter = new TafseerSourahPresenter(this);
        tafseerSourahPresenter.getTafseerAyats(getContext());
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tafseerSourahPresenter.filterSourah(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        return v;
    }


    @Override
    public void onGettingTafseerAyah(List<TafseerAyats> tafseerAyats) {
        TafseerSourahListAdapter listTafseerAdapter = new TafseerSourahListAdapter();
        listTafseerAdapter.setList(getContext() , tafseerAyats , tafseerSourahPresenter);
        tafseerAyatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        tafseerAyatRecyclerView.setHasFixedSize(true);
        tafseerAyatRecyclerView.setAdapter(listTafseerAdapter);
    }

    @Override
    public void beforeSearch(Context context , int position) {
        tafseerSourahPresenter.initAudioForTafseerItem(position);
    }

    @Override
    public void onSearch(Context context , int position) {
        tafseerSourahPresenter.initAudioForTafseerItem(position);
    }

    @Override
    public void onStop() {
        super.onStop();
        tafseerSourahPresenter.stopAudioInBackPressed();
    }
}
