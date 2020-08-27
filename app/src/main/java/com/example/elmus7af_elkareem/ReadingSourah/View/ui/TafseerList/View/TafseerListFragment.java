package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elmus7af_elkareem.DatabaseRoom.TafseerNames;
import com.example.elmus7af_elkareem.R;
import com.example.elmus7af_elkareem.SplashScreen.Model.TafseerIDsModel.TafseerListResponse;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.Presenter.TafseerListPresenter;

import java.util.List;

public class TafseerListFragment extends Fragment implements ITafseerListView {




    private RecyclerView tafseerRecyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tafseer_list, container, false);
        tafseerRecyclerView = root.findViewById(R.id.tafseer_recyclerView);
        TafseerListPresenter tafseerListPresenter = new TafseerListPresenter(this);
        tafseerListPresenter.checkDataDownloaded(getContext());
        tafseerListPresenter.initListOfTafseerNames();
        return root;
    }


    @Override
    public void onGettingTafseerResponse(List<TafseerNames> tafseerListResponse) {
        TafseerListAdapter listTafseerAdapter = new TafseerListAdapter();
        listTafseerAdapter.setList(getContext() , tafseerListResponse);
        tafseerRecyclerView.setLayoutManager(new GridLayoutManager(getContext() , 2));
        tafseerRecyclerView.setAdapter(listTafseerAdapter);
    }

    @Override
    public void isDataDownloaded(boolean result) {

    }


}
