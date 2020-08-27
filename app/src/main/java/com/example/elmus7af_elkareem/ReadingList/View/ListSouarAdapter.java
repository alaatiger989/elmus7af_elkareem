package com.example.elmus7af_elkareem.ReadingList.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elmus7af_elkareem.DatabaseRoom.QuranWdefaultSheikh;
import com.example.elmus7af_elkareem.ParentsModel.SourahDataParentModel;
import com.example.elmus7af_elkareem.R;
import com.example.elmus7af_elkareem.ReadingList.Model.ReadingListModel;
import com.example.elmus7af_elkareem.ReadingList.Presenter.ReadingListPresenter;
import com.example.elmus7af_elkareem.ReadingSourah.View.IReadingSourah;
import com.example.elmus7af_elkareem.ReadingSourah.View.ReadingSourah;

import java.util.ArrayList;
import java.util.List;

public class ListSouarAdapter extends RecyclerView.Adapter<ListSouarAdapter.QuranDataHolder> {
    private List<QuranWdefaultSheikh> surahs = new ArrayList<>();
    private Context context;
    private ReadingListPresenter readingListPresenter;
    public MutableLiveData<String> recyclerViewFilled = new MutableLiveData<>();

    @NonNull
    @Override
    public ListSouarAdapter.QuranDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sourah_item, parent, false
                );
        return new QuranDataHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuranDataHolder holder, int position) {

        holder.sourahVerses.setText(surahs.get(position).getNUMBER_OF_AYATS() + " Verses");
        holder.sourahName.setText(surahs.get(position).getARABIC_NAME());
        holder.sourahType.setText(surahs.get(position).getREVELATION_TYPE());
        if (surahs.get(position).getREVELATION_TYPE().equalsIgnoreCase("Meccan"))
        {
            holder.sourah_img_type.setImageResource(R.drawable.meccan);
        }
        else{
            holder.sourah_img_type.setImageResource(R.drawable.maadina);
        }
        holder.cardSourah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readingListPresenter.handlingClickOnSourahItem(context,String.valueOf(position+1) , surahs.get(position).getARABIC_NAME() ,surahs.get(position).getNUMBER_OF_AYATS() );
            }
        });

    }



    @Override
    public int getItemCount() {
        return surahs.size();
    }

    public void setList(List<QuranWdefaultSheikh> surahs, Context context, ReadingListPresenter readingListPresenter) {
        this.surahs = surahs;
        this.context = context;
        this.readingListPresenter = readingListPresenter;
        recyclerViewFilled.setValue("true");
        notifyDataSetChanged();
    }



    public class QuranDataHolder extends RecyclerView.ViewHolder{
        CardView cardSourah;
        ImageView sourah_img_type;
        TextView sourahName , sourahType , sourahVerses ;
        public QuranDataHolder(@NonNull View itemView) {
            super(itemView);
            sourahName = itemView.findViewById(R.id.sourah_name);
            sourahType =itemView.findViewById(R.id.sourah_type);
            sourahVerses = itemView.findViewById(R.id.sourah_verses);
            cardSourah = itemView.findViewById(R.id.card_sourah);
            sourah_img_type = itemView.findViewById(R.id.sourah_img_type);
        }
    }
}
