
public class Kartlar {

    private Kart[] kartlar;

    public Kartlar() {
        kartlar = new Kart[0];
    }

    public int kartSayisi() {
        return kartlar.length;
    }

    public void kartEkle(Kart kart) {
        // yeni bir kopya dizi
        Kart[] kopyaKartlar = new Kart[kartSayisi() + 1];
        System.arraycopy(kartlar, 0, kopyaKartlar, 0, kartSayisi());
        kopyaKartlar[kopyaKartlar.length - 1] = kart;
        kartlar = new Kart[kopyaKartlar.length];
        System.arraycopy(kopyaKartlar, 0, kartlar, 0, kopyaKartlar.length);
    }

    public Kart[] kartlarAl() {
        Kart[] kopyaKartlar = new Kart[kartSayisi()];
        for (int k = 0; k < kartSayisi(); k++) {
            kopyaKartlar[k] = kartlar[k];
        }
        kartlar = new Kart[0];
        return kopyaKartlar;
    }

    public void kartCikar(int kartNo) {
        Kart[] kopyaKartlar = new Kart[kartSayisi() - 1];
        int kopNo = 0, orjNo = 0;
        do {
            if (orjNo != kartNo) {
                kopyaKartlar[kopNo] = kartlar[orjNo];
                kopNo++;
            }
            orjNo++;
        } while (kopNo < kopyaKartlar.length);
        kartlar = new Kart[kopyaKartlar.length];
        System.arraycopy(kopyaKartlar, 0, kartlar, 0, kopyaKartlar.length);
    }

    public Kart kartAl(int no) {
        if (no <= kartSayisi()) {
            System.out.println(no + " numaralı kart alındı");
            Kart kart = kartlar[no];
            kartCikar(no);
            return kart;
        } else {
            System.out.println(no + " numaralı kart YOK");
            return null;
        }
    }

    public Kart kartAl() {
        if (kartSayisi() >= 0) {
            System.out.println("Üstteki kart alındı");
            Kart kart = kartlar[kartSayisi() - 1];
            kartCikar(kartSayisi() - 1);
            System.out.println("Kart Bilgisi: " + kart.toString());
            return kart;
        } else {
            System.out.println("Kart YOK");
            return null;
        }
    }

    public Kart kartGoster(int no) {
        return kartlar[no];
    }

    public void karistir() {
        int i;
        for (int k = 0; k < kartlar.length; k++) {
            // 0-52 arasında rastgele bir indeks
            i = (int) (Math.random() * kartlar.length);
            Kart tmp = kartlar[k];
            kartlar[k] = kartlar[i];
            kartlar[i] = tmp;
        }
    }

    // Kupa A,2,3,4,5,6,7,8,9,10,J,Q,K,Sinek A,2,3,4,5,6,7,8,9,10,J,Q,K,
    public void seriBuyuktenKucuge() {
        for (int k = 0; k < kartSayisi(); k++) {
            for (int x = 0; x < kartSayisi(); x++) {
                if (kartlar[k].getNo() > kartlar[x].getNo()) {
                    Kart temp = kartlar[k];
                    kartlar[k] = kartlar[x];
                    kartlar[x] = temp;
                }
            }
        }
    }

    public void seriKucuktenBuyuge() {
        for (int k = 0; k < kartSayisi(); k++) {
            for (int x = 0; x < kartSayisi(); x++) {
                if (kartlar[k].getNo() < kartlar[x].getNo()) {
                    Kart temp = kartlar[k];
                    kartlar[k] = kartlar[x];
                    kartlar[x] = temp;
                }
            }
        }
    }

    public void isimBuyuktenKucuge() {
        for (int k = 0; k < kartSayisi(); k++) {
            for (int x = 0; x < kartSayisi(); x++) {
                if (kartlar[k].getNo() % 13 > kartlar[x].getNo() % 13) {
                    Kart temp = kartlar[k];
                    kartlar[k] = kartlar[x];
                    kartlar[x] = temp;
                }
            }
        }
    }

    public void isimKucuktenBuyuge() {
        for (int k = 0; k < kartSayisi(); k++) {
            for (int x = 0; x < kartSayisi(); x++) {
                if (kartlar[k].getNo() % 13 < kartlar[x].getNo() % 13) {
                    Kart temp = kartlar[k];
                    kartlar[k] = kartlar[x];
                    kartlar[x] = temp;
                }
            }
        }
    }
}
