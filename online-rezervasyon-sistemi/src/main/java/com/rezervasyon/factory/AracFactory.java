package com.rezervasyon.factory;

import com.rezervasyon.model.Arac;
import com.rezervasyon.model.Otobus;
import com.rezervasyon.model.Ucak;
import java.time.LocalDateTime;

public class AracFactory {
    public static Arac aracOlustur(String aracTipi, String kalkisYeri, String varisYeri,
                                   LocalDateTime kalkisZamani, LocalDateTime varisZamani,
                                   double fiyat, int toplamKoltuk, String... ekBilgiler) {
        switch (aracTipi.toUpperCase()) {
            case "OTOBUS":
                if (ekBilgiler.length < 2) {
                    throw new IllegalArgumentException("Otobüs için plaka ve firma bilgisi gerekli");
                }
                return new Otobus(ekBilgiler[0], ekBilgiler[1], kalkisYeri, varisYeri,
                        kalkisZamani, varisZamani, fiyat, toplamKoltuk);

            case "UCAK":
                if (ekBilgiler.length < 2) {
                    throw new IllegalArgumentException("Uçak için uçak kodu ve havayolu bilgisi gerekli");
                }
                return new Ucak(ekBilgiler[0], ekBilgiler[1], kalkisYeri, varisYeri,
                        kalkisZamani, varisZamani, fiyat, toplamKoltuk);

            default:
                throw new IllegalArgumentException("Geçersiz araç tipi: " + aracTipi);
        }
    }
}