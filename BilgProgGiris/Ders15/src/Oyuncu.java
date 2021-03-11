
import javax.swing.JPanel;


public class Oyuncu {

    private String isim;
    private Kartlar el;
    private int puan, bahisSayisi, alinanEl;

    public Oyuncu() {
        this.isim = "";
        this.el = new Kartlar();
        this.puan = 0;
        this.bahisSayisi = 0;
        this.alinanEl = 0;
    }

    public Oyuncu(String isim) {
        this.isim = isim;
        this.el = new Kartlar();
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Kartlar getEl() {
        return el;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getBahisSayisi() {
        return bahisSayisi;
    }

    public void setBahisSayisi(int bahisSayisi) {
        this.bahisSayisi = bahisSayisi;
    }

    public int getAlinanEl() {
        return alinanEl;
    }

    public void setAlinanEl(int alinanEl) {
        this.alinanEl = alinanEl;
    }

    public void kartlariAc() {
        for (int k = 0; k < getEl().kartSayisi(); k++) {
            getEl().kartGoster(k).kartAc();
        }
    }

    public void kartlariPasifYap() {
        for (int k = 0; k < getEl().kartSayisi(); k++) {
            this.el.kartGoster(k).setEnabled(false);
        }
    }

    public void kartlariAktifYap() {
        for (int k = 0; k < getEl().kartSayisi(); k++) {
            this.el.kartGoster(k).setEnabled(true);
        }
    }

    // Burada yapay zekayı geliştirmek gerekli
    public int hangiKartOynar(String seri) {
        Kartlar ihtimaller = new Kartlar();
        // Aynı seride kart var mı?
        for (int k = 0; k < this.getEl().kartSayisi(); k++) {
            if (this.el.kartGoster(k).getSeri().equals(seri)) {
                ihtimaller.kartEkle(this.el.kartGoster(k));
            }
        }
        if (ihtimaller.kartSayisi() == 0) { // Aynı seride kart yok
            // Maça var mı?
            for (int k = 0; k < this.getEl().kartSayisi(); k++) {
                if (this.el.kartGoster(k).getSeri().equals("Maça")) {
                    ihtimaller.kartEkle(this.el.kartGoster(k));
                }
            }
            if (ihtimaller.kartSayisi() == 0) { // Maça da yok
                // eldeki tüm kağıtlar olabilir
                for (int k = 0; k < this.getEl().kartSayisi(); k++) {
                    ihtimaller.kartEkle(this.el.kartGoster(k));
                }
            }
        }
        // ihtimaller arasından rastgele bir kart seçilir
        int secilenKart = (int) (Math.random() * ihtimaller.kartSayisi());
        Kart secilen = ihtimaller.kartGoster(secilenKart);
        System.out.println(this.isim + " Seçilen kart: " + secilen.textKartBilgisi());
     
        // seçilen kartın elde hangi indekste olduğunu bulmalıyız
        int secilenID = -1;
        for (int k = 0; k < this.getEl().kartSayisi(); k++) {
            if (this.el.kartGoster(k).getNo() == ihtimaller.kartGoster(secilenKart).getNo()) {
                secilenID = k;
            }
        }
        return secilenID;
    }
}
