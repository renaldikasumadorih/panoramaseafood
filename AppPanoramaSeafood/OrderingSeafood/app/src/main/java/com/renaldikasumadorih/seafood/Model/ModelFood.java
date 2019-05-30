package com.renaldikasumadorih.seafood.Model;

/**
 * Created by ERVAN on 21/05/2017.
 */
public class ModelFood {
    String id, nama, stok, harga, gambar, deskripsi;

    public ModelFood(){}

    public ModelFood(String id, String nama, String stok, String harga, String gambar, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
