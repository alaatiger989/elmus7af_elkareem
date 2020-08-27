package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerSourah.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elmus7af_elkareem.DatabaseRoom.TafseerAyats;
import com.example.elmus7af_elkareem.R;
import com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerSourah.Presenter.TafseerSourahPresenter;

import java.util.ArrayList;
import java.util.List;

public class TafseerSourahListAdapter extends RecyclerView.Adapter<TafseerSourahListAdapter.TafseerAyahDataHolder> {


    private List<TafseerAyats> tafseerAyahResponses= new ArrayList<>();
    private Context context;
    private TafseerSourahPresenter tafseerSourahPresenter;
    @NonNull
    @Override
    public TafseerAyahDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tafseer_ayah_item, parent, false
                );

        return new TafseerAyahDataHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TafseerAyahDataHolder holder, int position) {
            holder.ayahText.setText(tafseerAyahResponses.get(position).getAyahText());
            holder.tafseerAyahText.setText(tafseerAyahResponses.get(position).getTafseerText());

            holder.ayahText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tafseerSourahPresenter.handlingClickOnTafseerItem(position);
                }
            });
    }

    @Override
    public int getItemCount() {
        return tafseerAyahResponses.size();
    }


    public void setList(Context context, List<TafseerAyats> tafseerAyahResponses, TafseerSourahPresenter tafseerSourahPresenter)
    {
        this.context =context;
        this.tafseerAyahResponses = tafseerAyahResponses;
        this.tafseerSourahPresenter = tafseerSourahPresenter;
        notifyDataSetChanged();
    }
    public class TafseerAyahDataHolder extends RecyclerView.ViewHolder{
        TextView tafseerAyahText;
        TextView ayahText;

        public TafseerAyahDataHolder(@NonNull View itemView) {
            super(itemView);
            tafseerAyahText = itemView.findViewById(R.id.tafseer_ayah_text);
            ayahText = itemView.findViewById(R.id.ayah_text);
        }
    }
}
