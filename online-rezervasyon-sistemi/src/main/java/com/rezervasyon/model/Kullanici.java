package com.rezervasyon.model;

import java.util.ArrayList;
import java.util.List;

public class Kullanici {
    private String id;
    private String ad;
    private String soyad;
    private String email;
    private String sifre;
    private String rol; // ADMIN, KULLANICI
    private List<Rezervasyon> rezervasyonlar;

    public Kullanici(String ad, String soyad, String email, String sifre) {
        this.id = java.util.UUID.randomUUID().toString();
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.sifre = sifre;
        this.rol = "KULLANICI";
        this.rezervasyonlar = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getEmail() {
        return email;
    }

    public String getSifre() {
        return sifre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Rezervasyon> getRezervasyonlar() {
        return rezervasyonlar;
    }

    public void rezervasyonEkle(Rezervasyon rezervasyon) {
        rezervasyonlar.add(rezervasyon);
    }

    public boolean adminMi() {
        return "ADMIN".equals(rol);
    }
}
