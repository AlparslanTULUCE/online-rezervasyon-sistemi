package com.rezervasyon.model;

public class Koltuk {
    private int koltukNo;
    private boolean mevcut;
    private String sinif; // Ekonomi, Business, First Class, vb.

    public Koltuk(int koltukNo, String sinif) {
        this.koltukNo = koltukNo;
        this.mevcut = true;
        this.sinif = sinif;
    }

    public int getKoltukNo() {
        return koltukNo;
    }

    public boolean isMevcut() {
        return mevcut;
    }

    public void setMevcut(boolean mevcut) {
        this.mevcut = mevcut;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }
}
