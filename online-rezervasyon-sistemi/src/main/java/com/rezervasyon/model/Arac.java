package com.rezervasyon.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public abstract class Arac {
    protected String id;
    protected String aracTipi;
    protected String kalkisYeri;
    protected String varisYeri;
    protected LocalDateTime kalkisZamani;
    protected LocalDateTime varisZamani;
    protected double fiyat;
    protected int toplamKoltuk;
    protected Set<Integer> rezerveEdilmisKoltuklar;

    public Arac(String aracTipi, String kalkisYeri, String varisYeri,
                LocalDateTime kalkisZamani, LocalDateTime varisZamani,
                double fiyat, int toplamKoltuk) {
        this.id = java.util.UUID.randomUUID().toString();
        this.aracTipi = aracTipi;
        this.kalkisYeri = kalkisYeri;
        this.varisYeri = varisYeri;
        this.kalkisZamani = kalkisZamani;
        this.varisZamani = varisZamani;
        this.fiyat = fiyat;
        this.toplamKoltuk = toplamKoltuk;
        this.rezerveEdilmisKoltuklar = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getAracTipi() {
        return aracTipi;
    }

    public String getKalkisYeri() {
        return kalkisYeri;
    }

    public String getVarisYeri() {
        return varisYeri;
    }

    public LocalDateTime getKalkisZamani() {
        return kalkisZamani;
    }

    public LocalDateTime getVarisZamani() {
        return varisZamani;
    }

    public double getFiyat() {
        return fiyat;
    }

    public int getToplamKoltuk() {
        return toplamKoltuk;
    }

    public boolean koltukMevcutMu(int koltukNo) {
        return koltukNo > 0 && koltukNo <= toplamKoltuk &&
                !rezerveEdilmisKoltuklar.contains(koltukNo);
    }

    public void koltukRezerveEt(int koltukNo) {
        if (koltukMevcutMu(koltukNo)) {
            rezerveEdilmisKoltuklar.add(koltukNo);
        }
    }

    public void koltukIptalEt(int koltukNo) {
        rezerveEdilmisKoltuklar.remove(koltukNo);
    }

    public Set<Integer> getMevcutKoltuklar() {
        Set<Integer> mevcutKoltuklar = new HashSet<>();
        for (int i = 1; i <= toplamKoltuk; i++) {
            if (!rezerveEdilmisKoltuklar.contains(i)) {
                mevcutKoltuklar.add(i);
            }
        }
        return mevcutKoltuklar;
    }
}
