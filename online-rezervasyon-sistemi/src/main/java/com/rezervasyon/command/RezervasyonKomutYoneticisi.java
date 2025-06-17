package com.rezervasyon.command;

import java.util.Stack;

public class RezervasyonKomutYoneticisi {
    private Stack<RezervasyonKomutu> komutlar;
    private Stack<RezervasyonKomutu> geriAlinanKomutlar;

    public RezervasyonKomutYoneticisi() {
        this.komutlar = new Stack<>();
        this.geriAlinanKomutlar = new Stack<>();
    }

    public void komutCalistir(RezervasyonKomutu komut) {
        komut.calistir();
        komutlar.push(komut);
        geriAlinanKomutlar.clear();
    }

    public void sonKomutuGeriAl() {
        if (!komutlar.isEmpty()) {
            RezervasyonKomutu komut = komutlar.pop();
            komut.geriAl();
            geriAlinanKomutlar.push(komut);
        }
    }

    public void sonGeriAlinanKomutuTekrarCalistir() {
        if (!geriAlinanKomutlar.isEmpty()) {
            RezervasyonKomutu komut = geriAlinanKomutlar.pop();
            komut.calistir();
            komutlar.push(komut);
        }
    }
}
