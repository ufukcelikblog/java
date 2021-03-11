
public class El {
  private Kart kartlar[];
  private int toplamKartSayisi;
  private int eldekiKartSayisi;
  private int kartIndeks;
  
  public El(int kartSayisi) {
    this.toplamKartSayisi = kartSayisi;
    this.kartIndeks = 0;
    this.eldekiKartSayisi = 0;
    kartlar = new Kart[this.toplamKartSayisi];
  }
  
  public void kartEkle(Kart kart) {
    if(kartIndeks == toplamKartSayisi) {
      System.out.println("Kart verilemez");
    } else {
      kartlar[kartIndeks] = kart;
      kartIndeks++;
      eldekiKartSayisi++;
    }
  }
  public void kartSil(int id) {
    kartlar[id] = null;
    eldekiKartSayisi--;
  }
  
  public Kart kartGoster(int id) {
    return kartlar[id];
  }
  
  public int getEldekiKartSayisi() {
    return this.eldekiKartSayisi;
  }
  
  public int getToplamKartSayisi() {
    return this.toplamKartSayisi;
  }
  
  // Kupa A,2,3,4,5,6,7,8,9,10,J,Q,K,Sinek A,2,3,4,5,6,7,8,9,10,J,Q,K,
  public void seriBuyuktenKucuge() {
    for(int k = 0; k < eldekiKartSayisi; k++) {
      for(int x = 0; x < eldekiKartSayisi; x++) {
        if(kartlar[k].getNo() > kartlar[x].getNo()){
          Kart temp = kartlar[k];
          kartlar[k] = kartlar[x];
          kartlar[x] = temp;
        }
      }
    }
  }

  public void seriKucuktenBuyuge() {
    for(int k = 0; k < eldekiKartSayisi; k++) {
      for(int x = 0; x < eldekiKartSayisi; x++) {
        if(kartlar[k].getNo() < kartlar[x].getNo()){
          Kart temp = kartlar[k];
          kartlar[k] = kartlar[x];
          kartlar[x] = temp;
        }
      }
    }
  }

  public void isimBuyuktenKucuge() {
    for(int k = 0; k < eldekiKartSayisi; k++) {
      for(int x = 0; x < eldekiKartSayisi; x++) {
        if(kartlar[k].getNo()%13 > kartlar[x].getNo()%13) {
          Kart temp = kartlar[k];
          kartlar[k] = kartlar[x];
          kartlar[x] = temp;
        }
      }
    }
  }

  public void isimKucuktenBuyuge() {
    for(int k = 0; k < eldekiKartSayisi; k++) {
      for(int x = 0; x < eldekiKartSayisi; x++) {
        if(kartlar[k].getNo()%13 < kartlar[x].getNo()%13) {
          Kart temp = kartlar[k];
          kartlar[k] = kartlar[x];
          kartlar[x] = temp;
        }
      }
    }
  }
  
}
