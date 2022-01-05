
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class Yakalayan extends JLabel {

  private int x, y, ivmeX, ivmeY;

  public Yakalayan(int x, int y, int en, int boy) {
    this.x = x;
    this.y = y;
    this.setBounds(x, y, en, boy);
    this.setOpaque(true);
    this.setBackground(Color.black);
  }

  public boolean yakaladi(JLabel obje) {
    int buX = this.getX();
    int buY = this.getY();
    int buEn = this.getWidth(); // genişliği aldık
    int buBoy = this.getHeight(); // yüksekliği aldık
    buEn += buX;
    buBoy += buY;

    int objeX = obje.getX();
    int objeY = obje.getY();
    int objeEn = obje.getWidth();
    int objeBoy = obje.getHeight();
    objeEn += objeX;
    objeBoy += objeY;

    return ((objeEn < objeX || objeEn > buX)
            && (objeBoy < objeY || objeBoy > buY)
            && (buEn < buX || buEn > objeX)
            && (buBoy < buY || buBoy > objeY));
  }

  public void hareketEt() {
    this.x += ivmeX;// objenin x koordinatını ivme kadar değiştiriyoruz
    this.y += ivmeY;// objenin y koordinatını ivme kadar değiştiriyoruz
    this.setLocation(this.x, this.y);
  }
  
  public void tusTiklandi(KeyEvent e) {
    int tus = e.getKeyCode(); // tıklanan tuşun ASCCI kodunu alıyoruz
    if(tus == 37) ivmeX -= 1; // sol ok tuşu tıklandı
    if(tus == 38) ivmeY -= 1; // yukarı ok tuşu tıklandı
    if(tus == 39) ivmeX += 1; // sağ ok tuşu tıklandı
    if(tus == KeyEvent.VK_DOWN) ivmeY += 1; // aşağı ok tuşu tıklandı
  }
  
  public void tusBirakildi(KeyEvent e) {
    int tus = e.getKeyCode(); // tıklanan tuşun ASCCI kodunu alıyoruz
    if(tus == 37) ivmeX = 0; // sol ok tuş bırakıldı.
    if(tus == 38) ivmeY = 0; 
    if(tus == 39) ivmeX = 0; 
    if(tus == 40) ivmeY = 0; 
  }
  
  public void buyult(int dg) {
    this.setBounds(this.getX(), this.getY(), this.getWidth()+dg, this.getHeight());
  }
  public void kucult(int dg) {
    this.setBounds(this.getX(), this.getY(), this.getWidth()-dg, this.getHeight());
  }
}
