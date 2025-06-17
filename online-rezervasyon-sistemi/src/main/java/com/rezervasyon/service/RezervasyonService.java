package com.rezervasyon.service;

import com.rezervasyon.model.*;
import com.rezervasyon.command.*;
import com.rezervasyon.observer.*;
import java.util.*;

public class RezervasyonService {
    private Map<String, Kullanici> kullanicilar;
    private Map<String, Arac> araclar;
    private Map<String, Rezervasyon> rezervasyonlar;
    private RezervasyonKomutYoneticisi komutYoneticisi;
    private RezervasyonBildirimSistemi bildirimSistemi;

    public RezervasyonService() {
        this.kullanicilar = new HashMap<>();
        this.araclar = new HashMap<>();
        this.rezervasyonlar = new HashMap<>();
        this.komutYoneticisi = new RezervasyonKomutYoneticisi();
        this.bildirimSistemi = new RezervasyonBildirimSistemi();
    }

    public Kullanici kullaniciKaydet(String ad, String soyad, String email, String sifre) {
        Kullanici kullanici = new Kullanici(ad, soyad, email, sifre);
        kullanicilar.put(kullanici.getId(), kullanici);
        return kullanici;
    }

    public Arac aracEkle(Arac arac) {
        araclar.put(arac.getId(), arac);
        return arac;
    }

    public Rezervasyon rezervasyonOlustur(String kullaniciId, String aracId, int koltukNo) {
        Kullanici kullanici = kullanicilar.get(kullaniciId);
        Arac arac = araclar.get(aracId);

        if (kullanici == null || arac == null) {
            throw new IllegalArgumentException("Kullanıcı veya araç bulunamadı");
        }

        RezervasyonOlusturKomutu komut = new RezervasyonOlusturKomutu(kullanici, arac, koltukNo);
        komutYoneticisi.komutCalistir(komut);
        Rezervasyon rezervasyon = komut.getRezervasyon();
        rezervasyonlar.put(rezervasyon.getId(), rezervasyon);
        bildirimSistemi.rezervasyonGuncelle(rezervasyon);
        return rezervasyon;
    }

    public void rezervasyonIptalEt(String rezervasyonId) {
        Rezervasyon rezervasyon = rezervasyonlar.get(rezervasyonId);
        if (rezervasyon != null) {
            RezervasyonIptalKomutu komut = new RezervasyonIptalKomutu(rezervasyon);
            komutYoneticisi.komutCalistir(komut);
            bildirimSistemi.rezervasyonGuncelle(rezervasyon);
        }
    }

    public void rezervasyonOnayla(String rezervasyonId) {
        Rezervasyon rezervasyon = rezervasyonlar.get(rezervasyonId);
        if (rezervasyon != null) {
            RezervasyonOnayKomutu komut = new RezervasyonOnayKomutu(rezervasyon);
            komutYoneticisi.komutCalistir(komut);
            bildirimSistemi.rezervasyonGuncelle(rezervasyon);
        }
    }

    public void bildirimSistemiKaydet(RezervasyonObserver observer) {
        bildirimSistemi.gozlemciEkle(observer);
    }

    public List<Arac> aracAra(String kalkisYeri, String varisYeri) {
        List<Arac> sonuclar = new ArrayList<>();
        for (Arac arac : araclar.values()) {
            if (arac.getKalkisYeri().equalsIgnoreCase(kalkisYeri) &&
                    arac.getVarisYeri().equalsIgnoreCase(varisYeri)) {
                sonuclar.add(arac);
            }
        }
        return sonuclar;
    }

    public List<Rezervasyon> kullaniciRezervasyonlariGetir(String kullaniciId) {
        Kullanici kullanici = kullanicilar.get(kullaniciId);
        return kullanici != null ? kullanici.getRezervasyonlar() : new ArrayList<>();
    }

    public void sonKomutuGeriAl() {
        komutYoneticisi.sonKomutuGeriAl();
    }

    public void sonGeriAlinanKomutuTekrarCalistir() {
        komutYoneticisi.sonGeriAlinanKomutuTekrarCalistir();
    }
}
