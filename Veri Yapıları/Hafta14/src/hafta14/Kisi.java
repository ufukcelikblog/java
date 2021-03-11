
package hafta14;

import java.time.LocalDate;

public class Kisi {
    private String ad;
    private String soyad;
    private LocalDate tarih;
    private String eposta;
    private String telefon;
    private String adres;
    private int postakod;
    private String sehir;

    public Kisi(String ad, String soyad, LocalDate tarih, String eposta, 
            String telefon, String adres, int postakod, String sehir) {
        this.ad = ad;
        this.soyad = soyad;
        this.tarih = tarih;
        this.eposta = eposta;
        this.telefon = telefon;
        this.adres = adres;
        this.postakod = postakod;
        this.sehir = sehir;
    }
    
    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getPostakod() {
        return postakod;
    }

    public void setPostakod(int postakod) {
        this.postakod = postakod;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
    
}
