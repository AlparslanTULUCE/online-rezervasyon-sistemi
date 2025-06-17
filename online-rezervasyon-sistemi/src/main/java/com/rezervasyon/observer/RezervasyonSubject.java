package com.rezervasyon.observer;

public interface RezervasyonSubject {
    void gozlemciEkle(RezervasyonObserver observer);
    void gozlemciCikar(RezervasyonObserver observer);
    void gozlemcileriBilgilendir();
}
