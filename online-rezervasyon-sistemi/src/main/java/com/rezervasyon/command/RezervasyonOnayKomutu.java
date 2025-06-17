package com.rezervasyon.command;

import com.rezervasyon.model.Rezervasyon;

public class RezervasyonOnayKomutu implements RezervasyonKomutu {
    private Rezervasyon rezervasyon;

    public RezervasyonOnayKomutu(Rezervasyon rezervasyon) {
        this.rezervasyon = rezervasyon;
    }

    @Override
    public void calistir() {
        if (rezervasyon == null) {
            throw new IllegalStateException("Onaylanacak rezervasyon bulunamadı");
        }
        rezervasyon.onayla();
    }

    @Override
    public void geriAl() {
        if (rezervasyon != null) {
            rezervasyon.iptalEt();
        }
    }
}
