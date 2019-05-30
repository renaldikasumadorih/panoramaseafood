package com.renaldikasumadorih.seafood.Model;

/**
 * Created by INEU on 01/06/2017.
 */

public class ModelData {
    String id, nama, tlp, alamat, food, waktu, status;

    public ModelData(){}

    public ModelData(String id, String nama, String tlp, String alamat, String food, String waktu, String status) {
        this.id = id;
        this.nama = nama;
        this.tlp = tlp;
        this.alamat = alamat;
        this.food = food;
        this.waktu = waktu;
        this.status = status;
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

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
