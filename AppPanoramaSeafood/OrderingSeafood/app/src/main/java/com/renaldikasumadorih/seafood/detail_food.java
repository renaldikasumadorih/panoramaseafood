package com.renaldikasumadorih.seafood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;


public class detail_food extends AppCompatActivity {
    EditText nama, stok, harga, gambar, deskripsi;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);

        Intent food = getIntent();
        int makanan = food.getIntExtra("makanan", 0);
        String intent_nama = food.getStringExtra("nama");
        String intent_stok = food.getStringExtra("stok");
        String intent_harga = food.getStringExtra("harga");
        String intent_deskripsi = food.getStringExtra("deskripsi");

        stok = (EditText) findViewById(R.id.fostok);
        harga = (EditText) findViewById(R.id.foharga);
        deskripsi = (EditText) findViewById(R.id.fodesk);
        nama = (EditText) findViewById(R.id.fonama);
        pd = new ProgressDialog(detail_food.this);



        if (makanan == 1) {
            nama.setText(intent_nama);
            stok.setText(intent_stok);
            harga.setText(intent_harga);
            deskripsi.setText(intent_deskripsi);
        }
    }


}