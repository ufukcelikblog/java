
import javax.swing.ImageIcon;

public class Deste {
  private final String[] seri = {"Kupa","Sinek","Karo","Maça"};
  private final String[] isim = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
  private int kartSayisi;
  private Kart[] kartlar;
  
  public Deste() {
    kartlar = new Kart[52];
    kartSayisi = 0;
    for(int s=0; s<seri.length; s++) {
      for(int i=0; i<isim.length; i++) {
        int deger = i > 9 ? 10 : i+1;
        kartlar[kartSayisi] = new Kart(kartSayisi, deger, seri[s], isim[i],
          new ImageIcon(getClass().getResource("/resimler67x100/"+seri[s]+"_"+isim[i]+".png")));
        kartSayisi++;
      }
    }
    System.out.println("Deste oluştu!" + kartSayisi + " adet kart var.");
  }
  
  public Kart kartVer() {
    if(kartSayisi > 0) {
      kartSayisi--;
      System.out.println("Kalan kart = " + kartSayisi);
      return kartlar[kartSayisi];
    } else {
      return null;
    }
  }

  public Kart kartGoster(int no) {
    return kartlar[no];
  }
  
  public int getKartSayisi() {
    return kartSayisi;
  }
  
  public void karistir() {
    int i;
    for(int k=0; k<kartlar.length; k++) {
      i = (int)(Math.random() * kartlar.length); // 0-52 arasında rastgele bir indeks
      Kart tmp = kartlar[k];
      kartlar[k] = kartlar[i];
      kartlar[i] = tmp;
    }
    kartSayisi = 52;
  }
}
