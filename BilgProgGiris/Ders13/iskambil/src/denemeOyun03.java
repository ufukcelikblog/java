
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class denemeOyun03 {
  public static void main(String[] args) {
    JPanel elPanel = new JPanel();
    Deste deste = new Deste();
    deste.karistir();
    
    El oyuncu = new El(13);
    for(int k=0; k<oyuncu.getToplamKartSayisi(); k++) {
      oyuncu.kartEkle(deste.kartVer());
      elPanel.add(new JLabel(oyuncu.kartGoster(k).getResim()));
    }
    JOptionPane.showMessageDialog(null, elPanel);
    
    oyuncu.isimKucuktenBuyuge();
    elPanel.removeAll();
    for(int k=0; k<oyuncu.getToplamKartSayisi(); k++) {
      elPanel.add(new JLabel(oyuncu.kartGoster(k).getResim()));
    }
    JOptionPane.showMessageDialog(null, elPanel);
  }
}
