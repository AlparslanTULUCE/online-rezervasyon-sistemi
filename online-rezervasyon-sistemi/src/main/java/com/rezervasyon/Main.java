package com.rezervasyon;

import com.rezervasyon.model.*;
import com.rezervasyon.factory.AracFactory;
import com.rezervasyon.service.RezervasyonService;
import com.rezervasyon.observer.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Servis oluştur
        RezervasyonService rezervasyonService = new RezervasyonService();

        // Kullanıcı kaydet
        Kullanici kullanici = rezervasyonService.kullaniciKaydet(
                "Ahmet", "Yılmaz", "ahmet@example.com", "sifre123"
        );

        // Bildirim sistemlerini kaydet
        rezervasyonService.bildirimSistemiKaydet(
                new EmailBildirimObserver(kullanici.getEmail())
        );
        rezervasyonService.bildirimSistemiKaydet(
                new SMSBildirimObserver("5551234567")
        );

        // Otobüs oluştur
        Otobus otobus = (Otobus) AracFactory.aracOlustur(
                "OTOBUS",
                "İstanbul",
                "Ankara",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(6),
                150.0,
                45,
                "34ABC123",
                "Metro Turizm"
        );
        rezervasyonService.aracEkle(otobus);

        // Uçak oluştur
        Ucak ucak = (Ucak) AracFactory.aracOlustur(
                "UCAK",
                "İstanbul",
                "Antalya",
                LocalDateTime.now().plusDays(2),
                LocalDateTime.now().plusDays(2).plusHours(1),
                500.0,
                180,
                "TK1234",
                "Türk Hava Yolları"
        );
        rezervasyonService.aracEkle(ucak);

        // Araç ara
        System.out.println("\nMevcut Seferler:");
        System.out.println("İstanbul -> Ankara:");
        for (Arac arac : rezervasyonService.aracAra("İstanbul", "Ankara")) {
            System.out.println(arac);
        }

        System.out.println("\nİstanbul -> Antalya:");
        for (Arac arac : rezervasyonService.aracAra("İstanbul", "Antalya")) {
            System.out.println(arac);
        }

        // Rezervasyon oluştur
        System.out.println("\nRezervasyon oluşturuluyor...");
        Rezervasyon rezervasyon = rezervasyonService.rezervasyonOlustur(
                kullanici.getId(),
                otobus.getId(),
                15
        );

        // Rezervasyon onayla
        System.out.println("\nRezervasyon onaylanıyor...");
        rezervasyonService.rezervasyonOnayla(rezervasyon.getId());

        // Kullanıcının rezervasyonlarını listele
        System.out.println("\nKullanıcının rezervasyonları:");
        for (Rezervasyon r : rezervasyonService.kullaniciRezervasyonlariGetir(kullanici.getId())) {
            System.out.printf("Rezervasyon ID: %s\n", r.getId());
            System.out.printf("Araç: %s\n", r.getArac());
            System.out.printf("Koltuk No: %d\n", r.getKoltukNo());
            System.out.printf("Durum: %s\n", r.getDurum());
            System.out.println();
        }

        // Rezervasyon iptal et
        System.out.println("Rezervasyon iptal ediliyor...");
        rezervasyonService.rezervasyonIptalEt(rezervasyon.getId());

        // Son komutu geri al
        System.out.println("\nSon komut geri alınıyor...");
        rezervasyonService.sonKomutuGeriAl();

        // Son geri alınan komutu tekrar çalıştır
        System.out.println("\nSon geri alınan komut tekrar çalıştırılıyor...");
        rezervasyonService.sonGeriAlinanKomutuTekrarCalistir();
    }
}
