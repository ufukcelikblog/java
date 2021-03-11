
import javax.swing.JOptionPane;

public class denemeOyun {
  public static void main(String[] args) {
    Deste d1 = new Deste();
    d1.karistir();
    for(int k=0; k<10; k++) {
      JOptionPane.showMessageDialog(
              null, 
              d1.kartGoster(d1.getKartSayisi()-1).toString(), 
              "KART",
              JOptionPane.PLAIN_MESSAGE,
              d1.kartVer().getResim());
    }
  }
}
