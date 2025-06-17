package com.rezervasyon.model;

import java.time.LocalDateTime;

public class Otobus extends Arac {
    private String plaka;
    private String firma;

    public Otobus(String plaka, String firma, String kalkisYeri, String varisYeri,
                  LocalDateTime kalkisZamani, LocalDateTime varisZamani,
                  double fiyat, int toplamKoltuk) {
        super("OTOBUS", kalkisYeri, varisYeri, kalkisZamani, varisZamani, fiyat, toplamKoltuk);
        this.plaka = plaka;
        this.firma = firma;
    }

    public String getPlaka() {
        return plaka;
    }

    public String getFirma() {
        return firma;
    }

    @Override
    public String toString() {
        return String.format("Otobüs: %s - %s -> %s (%s - %s) - %s TL",
                plaka, kalkisYeri, varisYeri,
                kalkisZamani.toLocalDate(), varisZamani.toLocalDate(),
                fiyat);
    }
}
