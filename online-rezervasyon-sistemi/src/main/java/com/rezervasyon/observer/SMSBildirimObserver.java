package com.rezervasyon.observer;

import com.rezervasyon.model.Rezervasyon;

public class SMSBildirimObserver implements RezervasyonObserver {
    private String telefon;

    public SMSBildirimObserver(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public void guncelle(Rezervasyon rezervasyon) {
        if (rezervasyon != null) {
            String mesaj = String.format(
                    "Rezervasyon durumu güncellendi: %s - %s - Koltuk: %d - Durum: %s",
                    rezervasyon.getArac().toString(),
                    rezervasyon.getId(),
                    rezervasyon.getKoltukNo(),
                    rezervasyon.getDurum()
            );
            // Gerçek uygulamada SMS gönderme işlemi burada yapılır
            System.out.println("SMS gönderildi: " + telefon);
            System.out.println(mesaj);
        }
    }
}
