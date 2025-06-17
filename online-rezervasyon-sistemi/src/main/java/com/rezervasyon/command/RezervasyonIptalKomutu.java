package com.rezervasyon.command;

import com.rezervasyon.model.Rezervasyon;

public class RezervasyonIptalKomutu implements RezervasyonKomutu {
    private Rezervasyon rezervasyon;

    public RezervasyonIptalKomutu(Rezervasyon rezervasyon) {
        this.rezervasyon = rezervasyon;
    }

    @Override
    public void calistir() {
        if (rezervasyon == null) {
            throw new IllegalStateException("İptal edilecek rezervasyon bulunamadı");
        }
        rezervasyon.iptalEt();
    }

    @Override
    public void geriAl() {
        if (rezervasyon != null) {
            rezervasyon.onayla();
        }
    }
}