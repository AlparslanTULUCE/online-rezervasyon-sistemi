package com.rezervasyon.observer;

import com.rezervasyon.model.Rezervasyon;

public class EmailBildirimObserver implements RezervasyonObserver {
    private String email;

    public EmailBildirimObserver(String email) {
        this.email = email;
    }

    @Override
    public void guncelle(Rezervasyon rezervasyon) {
        if (rezervasyon != null) {
            String mesaj = String.format(
                    "Sayın %s %s,\n\n" +
                            "Rezervasyonunuzun durumu güncellendi:\n" +
                            "Rezervasyon ID: %s\n" +
                            "Araç: %s\n" +
                            "Koltuk No: %d\n" +
                            "Durum: %s\n\n" +
                            "İyi yolculuklar dileriz.",
                    rezervasyon.getKullanici().getAd(),
                    rezervasyon.getKullanici().getSoyad(),
                    rezervasyon.getId(),
                    rezervasyon.getArac().toString(),
                    rezervasyon.getKoltukNo(),
                    rezervasyon.getDurum()
            );
            // Gerçek uygulamada email gönderme işlemi burada yapılır
            System.out.println("Email gönderildi: " + email);
            System.out.println(mesaj);
        }
    }
}
