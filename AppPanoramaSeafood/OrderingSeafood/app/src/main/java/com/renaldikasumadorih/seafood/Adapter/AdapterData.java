package com.renaldikasumadorih.seafood.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.renaldikasumadorih.seafood.Model.ModelData;
import com.renaldikasumadorih.seafood.R;

import java.util.List;

/**
 * Created by INEU on 21/05/2017.
 */

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private List<ModelData> mItems;
    private Context contex;

    public AdapterData (Context contex, List<ModelData> items){
        this.mItems = items;
        this.contex = contex;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_tampil_pesan,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelData md = mItems.get(position);
        holder.tvnama.setText(md.getNama());
        holder.tvstatus.setText(md.getStatus());
        holder.tvwaktu.setText(md.getWaktu());
        holder.md = md;

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        TextView tvnama, tvstatus, tvwaktu;
        ModelData md;
        public HolderData (View view){
            super(view);
            tvnama = (TextView) view.findViewById(R.id.txtnama);
            tvwaktu = (TextView) view.findViewById(R.id.txtwaktu);
            tvstatus = (TextView) view.findViewById(R.id.txtstatus);

        }
    }
}
