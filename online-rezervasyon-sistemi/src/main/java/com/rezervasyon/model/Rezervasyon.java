package com.rezervasyon.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Rezervasyon {
    private String id;
    private Kullanici kullanici;
    private Arac arac;
    private int koltukNo;
    private LocalDateTime rezervasyonTarihi;
    private String durum; // ONAYLANDI, IPTAL_EDILDI, BEKLEMEDE

    public Rezervasyon(Kullanici kullanici, Arac arac, int koltukNo) {
        this.id = UUID.randomUUID().toString();
        this.kullanici = kullanici;
        this.arac = arac;
        this.koltukNo = koltukNo;
        this.rezervasyonTarihi = LocalDateTime.now();
        this.durum = "BEKLEMEDE";
    }

    public String getId() {
        return id;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public Arac getArac() {
        return arac;
    }

    public int getKoltukNo() {
        return koltukNo;
    }

    public LocalDateTime getRezervasyonTarihi() {
        return rezervasyonTarihi;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public void onayla() {
        this.durum = "ONAYLANDI";
        arac.koltukRezerveEt(koltukNo);
    }

    public void iptalEt() {
        this.durum = "IPTAL_EDILDI";
        arac.koltukIptalEt(koltukNo);
    }
}
