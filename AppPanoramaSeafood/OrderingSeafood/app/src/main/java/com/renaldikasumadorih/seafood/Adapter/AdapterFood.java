package com.renaldikasumadorih.seafood.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.renaldikasumadorih.seafood.Model.ModelFood;
import com.renaldikasumadorih.seafood.R;
import com.renaldikasumadorih.seafood.detail_food;

import java.util.List;

/**
 * Created by ERVAN on 21/05/2017.
 */

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.HolderFood>{
    private List<ModelFood> fitem;
    private Context konteks;

    public AdapterFood (Context konteks, List<ModelFood> item){
        this.fitem = item;
        this.konteks = konteks;
    }

    @Override
    public HolderFood onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main,parent, false);
        HolderFood holderFood = new HolderFood(layout);
        return holderFood;
    }

    @Override
    public void onBindViewHolder(HolderFood holder, int position) {
        ModelFood mf = fitem.get(position);
        holder.tvinama.setText(mf.getNama());
        holder.tvistok.setText(mf.getStok());
        holder.tviharga.setText(mf.getHarga());
        Glide.with(konteks).load(mf.getGambar()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgvfood);
        holder.mf = mf;
    }

    @Override
    public int getItemCount() {
        return fitem.size();
    }


    class HolderFood extends RecyclerView.ViewHolder{
        TextView tvinama, tviharga, tvistok;
        ImageView imgvfood;
        ModelFood mf;

        public HolderFood (View view){
            super(view);

            tvinama = (TextView) view.findViewById(R.id.txnama);
            tvistok = (TextView) view.findViewById(R.id.txstok);
            tviharga = (TextView) view.findViewById(R.id.txharga);
            imgvfood = (ImageView) view.findViewById(R.id.imgfood);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent makanan = new Intent(konteks, detail_food.class);
                    makanan.putExtra("makanan", 1);
                    makanan.putExtra("id", mf.getId());
                    makanan.putExtra("nama", mf.getNama());
                    makanan.putExtra("stok", mf.getStok());
                    makanan.putExtra("harga", mf.getHarga());
                    makanan.putExtra("deskripsi", mf.getDeskripsi());
                    makanan.putExtra("gambar", mf.getGambar());

                    konteks.startActivity(makanan);
                }
            });
        }
    }

}
