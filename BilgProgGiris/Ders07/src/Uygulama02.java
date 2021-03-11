
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Uygulama02 {
  public static void main(String[] args) {
    ImageIcon resim = new ImageIcon("src/iskambil/k11.png");
    JLabel etiket = new JLabel("Sinek J");
    etiket.setIcon(resim);
    JOptionPane.showMessageDialog(null, etiket);
  }
}
