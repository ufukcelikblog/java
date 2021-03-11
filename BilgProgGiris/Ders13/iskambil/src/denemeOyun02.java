
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class denemeOyun02 {
  public static void main(String[] args) {
    JPanel desteSiraliPanel = new JPanel(new GridLayout(4,13));
    JPanel desteKarisikPanel = new JPanel(new GridLayout(4,13));
    
    Deste deste = new Deste();
    for(int k=0; k<52; k++) {
      desteSiraliPanel.add(new JLabel(deste.kartVer().getResim()));
    }
    deste.karistir();
    for(int k=0; k<52; k++) {
      desteKarisikPanel.add(new JLabel(deste.kartVer().getResim()));
    }
    
    Object oyunPanel[] = new Object[2];
    oyunPanel[0] = desteSiraliPanel;
    oyunPanel[1] = desteKarisikPanel;
    Object etiket[] = {"ÇIKIŞ"};
    JOptionPane.showOptionDialog(null, oyunPanel, "İSKAMBİL", 
            0, 0, null, etiket, etiket[0]);
  }
  
}
