
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class demo_01 implements ActionListener {

  private final String[] seri = {"Kupa", "Sinek", "Karo", "Maça"};
  private final String[] isim = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

  private JFrame crv;
  private Kartlar deste;
  private Kartlar yer;
  private Kartlar el;
  private JButton dgmKartVer;

  public demo_01() {
    crv = new JFrame("DEMO");
    crv.setLayout(null);
    crv.setSize(1000, 600);
    crv.setLocationRelativeTo(null);
    crv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // deste oluşturma
    deste = new Kartlar();
    int id = 0;
    for (int s = 0; s < seri.length; s++) {
      for (int i = 0; i < isim.length; i++) {
        int deger = i > 9 ? 10 : i + 1;
        deste.kartEkle(new Kart(id, deger, seri[s], isim[i], "resimler67x100"));
        id++;
      }
    }
    deste.karistir();
    for (int k = 0; k < 52; k++) {
      deste.kartGoster(k).setLocation(k * 15, 0);
      deste.kartGoster(k).addActionListener(this);
      //deste.kartGoster(k).kartAc();
      crv.add(deste.kartGoster(k));
    }
    yer = new Kartlar();
    el = new Kartlar();

    dgmKartVer = new JButton("KART VER");
    dgmKartVer.setBounds(0, 120, 100, 50);
    dgmKartVer.addActionListener(this);

    crv.add(dgmKartVer);
    crv.setVisible(true);
  }

  public static void main(String[] args) {
    new demo_01();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(dgmKartVer)) {
      el.kartEkle(deste.kartAl());
      for (int id = 0; id < el.kartSayisi(); id++) {
        el.kartGoster(id).setLocation(id * 67, 450);
        el.kartGoster(id).kartAc();
      }
    }
    for (int k = 0; k < el.kartSayisi(); k++) {
      if (e.getSource().equals(el.kartGoster(k))) {
        yer.kartEkle(el.kartAl(k));
        yer.kartGoster(yer.kartSayisi() - 1).setLocation(50 + yer.kartSayisi() * 67, 200);
      }
    }
  }
}
