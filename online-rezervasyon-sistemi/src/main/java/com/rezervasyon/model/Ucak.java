package com.rezervasyon.model;

import java.time.LocalDateTime;

public class Ucak extends Arac {
    private String ucakKodu;
    private String havayolu;

    public Ucak(String ucakKodu, String havayolu, String kalkisYeri, String varisYeri,
                LocalDateTime kalkisZamani, LocalDateTime varisZamani,
                double fiyat, int toplamKoltuk) {
        super("UCAK", kalkisYeri, varisYeri, kalkisZamani, varisZamani, fiyat, toplamKoltuk);
        this.ucakKodu = ucakKodu;
        this.havayolu = havayolu;
    }

    public String getUcakKodu() {
        return ucakKodu;
    }

    public String getHavayolu() {
        return havayolu;
    }

    @Override
    public String toString() {
        return String.format("Uçak: %s - %s -> %s (%s - %s) - %s TL",
                ucakKodu, kalkisYeri, varisYeri,
                kalkisZamani.toLocalDate(), varisZamani.toLocalDate(),
                fiyat);
    }
}
