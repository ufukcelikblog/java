
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBilgi extends JPanel {
  private Oyuncu oyuncu;
  private JLabel etkBahis;
  private JLabel etkEl;
  private JLabel etkPuan;

  public PanelBilgi(Oyuncu oyuncu) {
    this.oyuncu = oyuncu;
    etkBahis = new JLabel("Bahis: " + oyuncu.getBahisSayisi());
    etkEl = new JLabel("El: " + oyuncu.getAlinanEl());
    etkPuan = new JLabel("Puan: " + oyuncu.getPuan());
    this.add(etkBahis);
    this.add(etkEl);
    this.add(etkPuan);
  } 

  
  public void guncelle() {
    etkBahis.setText("Bahis: " + oyuncu.getBahisSayisi());
    etkEl.setText("El: " + oyuncu.getAlinanEl());
    etkPuan.setText("Puan: " + oyuncu.getPuan());
    this.revalidate();
    this.repaint();
  }
  
  
}
