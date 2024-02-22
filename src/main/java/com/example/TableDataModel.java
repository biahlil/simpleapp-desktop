package com.example;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableDataModel {
    private final SimpleIntegerProperty kodeBarang;
    private final SimpleStringProperty namaBarang;
    private final SimpleIntegerProperty jumlah;
    private final SimpleIntegerProperty harga;

    public TableDataModel(int kodeBarang, String namaBarang, int jumlah, int harga) {
        this.kodeBarang = new SimpleIntegerProperty(kodeBarang);
        this.namaBarang = new SimpleStringProperty(namaBarang);
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.harga = new SimpleIntegerProperty(harga);
    }

    public int getKodeBarang() { return kodeBarang.get(); }
    public String getNamaBarang() { return namaBarang.get(); }
    public int getJumlah() { return jumlah.get(); }
    public int getHarga() { return harga.get(); }
}