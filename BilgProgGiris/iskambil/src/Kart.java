
import javax.swing.ImageIcon;

public class Kart {
  private final int no;
  private final int deger;
  private final String seri; // Kupa, Maça, Karo, Sinek
  private final String isim; // A,1,2,3,4,5,6,7,8,9,10,J,Q,K
  private final ImageIcon resim;
  
  public Kart(int no, int deger, String seri, String isim, ImageIcon resim) {
    this.no = no;
    this.deger = deger;
    this.seri = seri;
    this.isim = isim;
    this.resim = resim;
  }
  
  public int getNo() {
    return this.no;
  }

  public int getDeger() {
    return deger;
  }

  public String getSeri() {
    return seri;
  }

  public String getIsim() {
    return isim;
  }

  public ImageIcon getResim() {
    return resim;
  }
  
  @Override
  public String toString() {
    return seri + " " + isim + "\nDeğeri = " + deger;
  }
}
