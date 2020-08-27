package com.example.elmus7af_elkareem.ReadingList.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;
import com.example.elmus7af_elkareem.R;
import com.example.elmus7af_elkareem.ReadingList.Model.ReadingListModel;
import com.example.elmus7af_elkareem.ReadingList.Presenter.ReadingListPresenter;
import com.example.elmus7af_elkareem.ReadingSourah.Model.ReadingSourahModel;
import com.example.elmus7af_elkareem.ReadingSourah.View.ReadingSourah;

import java.util.List;

import butterknife.BindView;

public class ListSouarFragment extends Fragment implements IReadingListView{




    private RecyclerView listSouarRecyclerView;
    private EditText searchEditText;
    private ReadingListPresenter readingListPresenter;

    private ReadingListModel readingListModel = new ReadingListModel();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list_souar, container, false);
        listSouarRecyclerView = v.findViewById(R.id.list_souar_recyclerView);
        searchEditText = v.findViewById(R.id.edittext_search);

        readingListPresenter = new ReadingListPresenter(this);
        readingListPresenter.getSouarFromDatabase(getContext());
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                readingListPresenter.filterSourah(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        return v;
    }

    @Override
    public void onGetSouarDetails(List<QuranWdefaultSheikh> quranWdefaultSheikhs) {

        ListSouarAdapter listSouarAdapter = new ListSouarAdapter();
        listSouarAdapter.setList(quranWdefaultSheikhs , getContext() , readingListPresenter);
        listSouarRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        listSouarRecyclerView.setAdapter(listSouarAdapter);
    }

    @Override
    public void beforeSearch(Context context) {
        Intent intent = new Intent( context , ReadingSourah.class);
        context.startActivity(intent);

    }

    @Override
    public void onSearch(Context context) {
        Intent intent = new Intent( context , ReadingSourah.class);
        context.startActivity(intent);
        readingListModel.getOriginalIndexForReadingList().clear();
    }
}
