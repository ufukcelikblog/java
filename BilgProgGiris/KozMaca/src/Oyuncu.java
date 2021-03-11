
public class Oyuncu {

    private Kartlar kartlar;
    private String isim;
    private int el, bahis, puan;

    public Oyuncu(String isim) {
        this.kartlar = new Kartlar();
        this.isim = isim;
        this.el = 0;
        this.bahis = 0;
        this.puan = 0;
    }

    public String bilgiTEXT() {
        return isim + "\n EL: " + el + "\n BAHİS: " + bahis + "\n PUAN: " + puan;
    }

    public Kartlar getKartlar() {
        return kartlar;
    }

    public void setKartlar(Kartlar kartlar) {
        this.kartlar = kartlar;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getEl() {
        return el;
    }

    public void setEl(int el) {
        this.el = el;
    }

    public int getBahis() {
        return bahis;
    }

    public void setBahis(int bahis) {
        this.bahis = bahis;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public void kartlariAc() {
        for (int k = 0; k < kartlar.kartSayisi(); k++) {
            kartlar.kartGoster(k).kartAc();
        }
    }

    public void kartlariPasifYap() {
        for (int k = 0; k < getKartlar().kartSayisi(); k++) {
            kartlar.kartGoster(k).setEnabled(false);
        }
    }

    public void kartlariAktifYap() {
        for (int k = 0; k < getKartlar().kartSayisi(); k++) {
            this.kartlar.kartGoster(k).setEnabled(true);
        }
    }

    public void seridekiKartlariAktifYap(String seri) {
        boolean seriVarmi = false;
        boolean macaVarmi = false;
        for (int k = 0; k < getKartlar().kartSayisi(); k++) {
            if (kartlar.kartGoster(k).getSeri().equals(seri)) {
                kartlar.kartGoster(k).setEnabled(true);
                seriVarmi = true;
            }
            if (kartlar.kartGoster(k).getSeri().equals("Maça")) {
                macaVarmi = true;
            }
        }
        if(!seriVarmi){ // seride kart yoksa
            if(macaVarmi) {
                for (int k = 0; k < getKartlar().kartSayisi(); k++) {
                    if (kartlar.kartGoster(k).getSeri().equals("Maça")) {
                        kartlar.kartGoster(k).setEnabled(true);
                    }
                }
            } else {
                kartlariAktifYap();
            }
        }
    }
    
    public int rastgeleKagitID() {
        return (int) (Math.random() * this.kartlar.kartSayisi());
    }

    public void bahisHesapla() {
        int bahis = 0;
        for (int k = 0; k < this.getKartlar().kartSayisi(); k++) {
            if (this.getKartlar().kartGoster(k).getSeri().equals("Maça")) {
                bahis++;
            }
        }
        this.bahis = bahis;
    }

    public void puanHesapla() {
        // oyuncu battı bahis kadar ceza puanı
        if (this.el < this.bahis) {
            this.puan -= this.bahis * 10;
        } else {
            this.puan += this.el * 10 + this.bahis;
        }
    }

    public int hangiKartOynar(String seri) {
        Kartlar ihtimaller = new Kartlar();
        for(int k=0; k<kartlar.kartSayisi(); k++) {
            if(kartlar.kartGoster(k).getSeri().equals(seri)) {
                ihtimaller.kartEkle(kartlar.kartGoster(k));
            }
        }
        if(ihtimaller.kartSayisi() == 0) { // Aynı seride kart yok
            // Maça var mı?
            for (int k = 0; k < this.getKartlar().kartSayisi(); k++) {
                if (this.kartlar.kartGoster(k).getSeri().equals("Maça")) {
                    ihtimaller.kartEkle(this.kartlar.kartGoster(k));
                }
            }
            if (ihtimaller.kartSayisi() == 0) { // Maça da yok
                // eldeki tüm kağıtlar olabilir
                for (int k = 0; k < this.getKartlar().kartSayisi(); k++) {
                    ihtimaller.kartEkle(this.kartlar.kartGoster(k));
                }
            }
        }
        // ihtimaller arasından rastgele bir kart seçilir
        int secilenKart = (int) (Math.random() * ihtimaller.kartSayisi());
        Kart secilen = ihtimaller.kartGoster(secilenKart);
        // seçilen kartın elde hangi indekste olduğunu bulmalıyız
        int secilenID = -1;
        for (int k = 0; k < this.getKartlar().kartSayisi(); k++) {
            if (kartlar.kartGoster(k).getNo() == ihtimaller.kartGoster(secilenKart).getNo()) {
                secilenID = k;
            }
        }
        return secilenID;
    }
}
