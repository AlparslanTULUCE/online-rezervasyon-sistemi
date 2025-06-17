package com.rezervasyon.command;

import com.rezervasyon.model.Rezervasyon;
import com.rezervasyon.model.Kullanici;
import com.rezervasyon.model.Arac;

public class RezervasyonOlusturKomutu implements RezervasyonKomutu {
    private Rezervasyon rezervasyon;
    private Kullanici kullanici;
    private Arac arac;
    private int koltukNo;

    public RezervasyonOlusturKomutu(Kullanici kullanici, Arac arac, int koltukNo) {
        this.kullanici = kullanici;
        this.arac = arac;
        this.koltukNo = koltukNo;
    }

    @Override
    public void calistir() {
        if (!arac.koltukMevcutMu(koltukNo)) {
            throw new IllegalStateException("Seçilen koltuk müsait değil");
        }
        rezervasyon = new Rezervasyon(kullanici, arac, koltukNo);
        kullanici.rezervasyonEkle(rezervasyon);
    }

    @Override
    public void geriAl() {
        if (rezervasyon != null) {
            rezervasyon.iptalEt();
        }
    }

    public Rezervasyon getRezervasyon() {
        return rezervasyon;
    }
}
