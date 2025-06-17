package com.rezervasyon.observer;

import com.rezervasyon.model.Rezervasyon;
import java.util.ArrayList;
import java.util.List;

public class RezervasyonBildirimSistemi implements RezervasyonSubject {
    private List<RezervasyonObserver> gozlemciler;
    private Rezervasyon sonRezervasyon;

    public RezervasyonBildirimSistemi() {
        this.gozlemciler = new ArrayList<>();
    }

    @Override
    public void gozlemciEkle(RezervasyonObserver observer) {
        gozlemciler.add(observer);
    }

    @Override
    public void gozlemciCikar(RezervasyonObserver observer) {
        gozlemciler.remove(observer);
    }

    @Override
    public void gozlemcileriBilgilendir() {
        for (RezervasyonObserver observer : gozlemciler) {
            observer.guncelle(sonRezervasyon);
        }
    }

    public void rezervasyonGuncelle(Rezervasyon rezervasyon) {
        this.sonRezervasyon = rezervasyon;
        gozlemcileriBilgilendir();
    }
}
