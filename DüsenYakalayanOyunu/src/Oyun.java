
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Oyun extends JFrame implements KeyListener, ActionListener {

  private Yakalayan ykl;
  private Dusen dsn[];
  private int en, boy; // çerçeve en ve boy
  private Timer zaman;

  public Oyun(int en, int boy) {
    this.en = en;
    this.boy = boy;
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    super.setSize(this.en, this.boy);
    super.setLayout(null);
    super.setLocationRelativeTo(null);
    // yakalayan obje çerçeveye ekleyelim
    ykl = new Yakalayan(this.en / 2, this.boy - 60, 60, 10);
    super.add(ykl);
    // düşen objeler çerçeveye ekleyelim
    dsn = new Dusen[10]; // düşen obje dizisi
    for (int k = 0; k < dsn.length; k++) {
      int dX = (int) (Math.random() * this.en);
      int dY = -(int) (Math.random() * 1000);
      int dEn = (int) (Math.random() * 10) + 2; // 2-10 arasında en
      int dBoy = (int) (Math.random() * 10) + 2; // 2-10 arasında boy
      int dHiz = (int) (Math.random() * 5) + 1; // 1-5 arasında hız
      dsn[k] = new Dusen(dX, dY, dEn, dBoy, Color.blue, dHiz);
      super.add(dsn[k]);
    }
    super.addKeyListener(this);
    zaman = new Timer(10, this); // sınıfımızı zaman nesnesi içine alıyoruz
    zaman.start();
    super.setVisible(true);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // burada birşey yapmıyoruz
  }

  @Override
  public void keyPressed(KeyEvent e) {
    ykl.tusTiklandi(e);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    ykl.tusBirakildi(e);
  }

  public static void main(String[] args) {
    Oyun o = new Oyun(400, 600);
  }
  
  @Override
  // zaman nesnesi sürekli bu metodu çalıştırıyor
  public void actionPerformed(ActionEvent e) {
    ykl.hareketEt();
    for (int k = 0; k < dsn.length; k++) {
      // düşen obje yakalanmadıysa
      if (!dsn[k].getYakalandi()) {
        dsn[k].hareketEt();
        if (ykl.yakaladi(dsn[k])) { // düşen objeyi yakaladı ise
          dsn[k].setYakalandi(true);
          dsn[k].setVisible(false);
          ykl.buyult(dsn[k].getWidth()); // düşen objenin genişliği kadar büyütüyoruz
        }
        // düşen obje çerçeve dışına çıktı ise
        if (dsn[k].getY() > this.boy) {
          // düşen objenin yarı genişliği kadar küçültüyoruz
          ykl.kucult(dsn[k].getWidth() / 2);
          if (ykl.getWidth() < 1) { // oyunu kaybettik
            zaman.stop();
            JOptionPane.showMessageDialog(null, "!!! Oyun Bitti");
          }
          // düşen objeyi yeniden ekrana alıyoruz
          int X = (int) (Math.random() * this.en);
          int Y = -(int) (Math.random() * 1000);
          int E = (int) (Math.random() * 10) + 2; // 2-10 arasında en
          int B = (int) (Math.random() * 10) + 2; // 2-10 arasında boy
          dsn[k].setBounds(X, Y, E, B);
        }
      }
    }
  }

}
