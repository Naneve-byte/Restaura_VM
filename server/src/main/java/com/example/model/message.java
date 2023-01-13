package com.example.model;

import java.io.Serializable;

public class message implements Serializable {
    private int meja;

    public int getMeja() {
        return meja;
    }

    public void setMeja(int meja) {
        this.meja = meja;
    }

    private String ORDER;
    private String Waktu;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    private String table;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    private String TotalHarga;
    private String order;
    private String waktu;
    private String Pembayaran;

    public String getORDER() {
        return ORDER;
    }

    public void setORDER(String ORDER) {
        this.ORDER = ORDER;
    }

    public String getTotalHarga() {
        return TotalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        TotalHarga = totalHarga;
    }

    public String getPembayaran() {
        return Pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        Pembayaran = pembayaran;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }


}