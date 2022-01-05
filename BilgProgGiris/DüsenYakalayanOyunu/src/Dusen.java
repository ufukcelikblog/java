
import java.awt.Color;
import javax.swing.JLabel;

public class Dusen extends JLabel {
  private int hiz; // düşen objenin hızı
  private boolean yakalandi; //yakalandı ise TRUE değilse FALSE
  
  public Dusen(int x, int y, int en, int boy, Color renk, int hiz) {
    this.hiz = hiz;
    this.setOpaque(true);
    this.setBounds(x, y, en, boy);
    this.setBackground(renk);
  }
  
  public void hareketEt() {
    this.setLocation(this.getX(), this.getY() + hiz);
  }
  
  public void setYakalandi(boolean y) {
    this.yakalandi = y;
  }
  
  public boolean getYakalandi() {
    return this.yakalandi;
  }
}
