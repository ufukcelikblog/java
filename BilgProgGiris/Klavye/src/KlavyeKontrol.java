
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KlavyeKontrol implements KeyListener {

  private JFrame crv;
  private JLabel etk, engel;
  private boolean carpti;

  public KlavyeKontrol() {
    carpti = false;
    crv = new JFrame("Klavye Kontrolü");
    crv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    crv.setLayout(null);
    crv.setSize(500, 300);
    crv.setLocationRelativeTo(null);

    etk = new JLabel("TUŞ: ");
    etk.setOpaque(true);
    etk.setBackground(Color.cyan);
    etk.setBounds(100, 50, 150, 30);

    engel = new JLabel();
    engel.setOpaque(true);
    engel.setBounds(200, 150, 100, 30);
    engel.setBackground(Color.red);

    crv.add(etk);
    crv.add(engel);
    crv.addKeyListener(this);
    crv.setVisible(true);
  }

  // etiketim objeye çarptı mı?
  public boolean carpti(JLabel obje) {
    int etkX = etk.getX();
    int etkY = etk.getY();
    int etkEn = etk.getWidth();
    int etkBoy = etk.getHeight();
    etkEn += etkX;
    etkBoy += etkY;

    int objeX = obje.getX();
    int objeY = obje.getY();
    int objeEn = obje.getWidth();
    int objeBoy = obje.getHeight();
    objeEn += objeX;
    objeBoy += objeY;

    // çarpışma kontrolü (collision detect)
    return ((objeEn < objeX || objeEn > etkX)
            && (objeBoy < objeY || objeBoy > etkY)
            && (etkEn < etkX || etkEn > objeX)
            && (etkBoy < etkY || etkBoy > objeY));
  }

  public static void main(String[] args) {
    KlavyeKontrol oyun = new KlavyeKontrol();
  }

  @Override
  public void keyTyped(KeyEvent e) { // yazma
    
  }

  @Override
  public void keyPressed(KeyEvent e) { // tuşa basma
    if(carpti(engel)) {
      carpti = true;
    } else {
      carpti = false;
    }
    if (!carpti(engel)) {
      int x = etk.getX(); // nesnenin X koordinatını alır
      int y = etk.getY(); // nesnenin Y koordinatını alır
      etk.setText("TUŞ: " + e.getKeyCode() + " X=" + x + " Y=" + y);
      // aşağı ok tuşuna basıldı ASCII = 40
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        if (y < 231) {
          etk.setBounds(x, y + 5, 150, 30);
        }
      }
      // yukarı ok tuşuna basıldı ASCII = 38
      if (e.getKeyCode() == 38) {
        if (y > 0) {
          etk.setBounds(x, y - 5, 150, 30);
        }
      }
      // sol ok tuşuna basıldı ASCII = 37
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        if (x > 0) {
          etk.setBounds(x - 5, y, 150, 30);
        }
      }
      // sağ ok tuşuna basıldı ASCII = 39
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        if (x < 350) {
          etk.setBounds(x + 5, y, 150, 30);
        }
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent e) { // tuşu bırakma
    carpti = false;
  }

}
