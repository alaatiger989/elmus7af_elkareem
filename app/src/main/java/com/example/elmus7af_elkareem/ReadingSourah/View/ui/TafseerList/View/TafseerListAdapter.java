package com.example.elmus7af_elkareem.ReadingSourah.View.ui.TafseerList.View;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elmus7af_elkareem.DatabaseRoom.AppDatabase;
import com.example.elmus7af_elkareem.DatabaseRoom.TafseerAyats;
import com.example.elmus7af_elkareem.DatabaseRoom.TafseerNames;
import com.example.elmus7af_elkareem.R;

import java.util.ArrayList;
import java.util.List;

public class TafseerListAdapter extends RecyclerView.Adapter<TafseerListAdapter.TafseerDataHolder>{
    List<TafseerNames> tafseerListResponse =new ArrayList<>();
    List<TafseerAyats> tafseerAyats = new ArrayList<>();
    private Context context;
    private AppDatabase database;
    @NonNull
    @Override
    public TafseerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tafseer_item, parent, false
                );
         database = AppDatabase.getInstance(context);
        return new TafseerDataHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TafseerDataHolder holder, int position) {

        List<TafseerAyats> tafseerAyats = new ArrayList<>();
        AppDatabase database = AppDatabase.getInstance(context);

        tafseerAyats.addAll(database.tafseerAyatsDao().getTafseerIds());
        if (tafseerAyats.get(0).getTafseer_ID().equalsIgnoreCase(String.valueOf(position+1)) )
        {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#303F9F"));
        }
        else {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#056834"));
        }

        holder.tafseerName.setText(tafseerListResponse.get(position).getTAFSEER_NAME());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 new GettingTafseerData(context , (position+1)).execute(114);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tafseerListResponse.size();
    }

    public void setList(Context context, List<TafseerNames> tafseerListResponse)
    {
        this.context =context;
        this.tafseerListResponse = tafseerListResponse;

        notifyDataSetChanged();
    }
    public class TafseerDataHolder extends RecyclerView.ViewHolder{
        TextView tafseerName;
        CardView cardView;
        public TafseerDataHolder(@NonNull View itemView) {
            super(itemView);
            tafseerName = itemView.findViewById(R.id.tafseer_name);
            cardView = itemView.findViewById(R.id.card_tafseer_name);
        }
    }
}
