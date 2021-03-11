
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class demo_02 implements ActionListener {

  private final String[] seri = {"Kupa", "Sinek", "Karo", "Maça"};
  private final String[] isim = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

  private JFrame crv;
  private Kartlar deste;
  private Kartlar yer;
  private final Oyuncu[] oyuncular;
  private JButton dgmKartVer;
  private JButton dgmYeniEl;
  private boolean insanOynadi;
  private boolean yeniEl;

  public demo_02() {
    crv = new JFrame("DEMO 2");
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
    oyuncular = new Oyuncu[4];
    for (int o = 0; o < oyuncular.length; o++) {
      oyuncular[o] = new Oyuncu("O-" + (o + 1));
    }

    dgmKartVer = new JButton("KART VER");
    dgmKartVer.setBounds(0, 120, 100, 50);
    dgmKartVer.addActionListener(this);
    crv.add(dgmKartVer);
    dgmYeniEl = new JButton("SONRAKİ EL");
    dgmYeniEl.setBounds(0, 300, 100, 50);
    dgmYeniEl.addActionListener(this);
    //dgmYeniEl.setVisible(false);
    crv.add(dgmYeniEl);

    crv.setVisible(true);
  }

  public void kartlariDagit() {
    for (int o = 0; o < oyuncular.length; o++) {
      System.out.println("Oyuncu: " + oyuncular[o].getIsim());
      for (int k = 0; k < 4; k++) {
        oyuncular[o].getEl().kartEkle(deste.kartAl());
      }
    }
  }

  public void bekle(int sn) {
    try {
      Thread.sleep(sn);
    } catch (InterruptedException ie) {
      System.out.println("Hata: " + ie.toString());
    }
  }

  public void basla() {
    for (int tur = 1; tur <= 3; tur++) {
      System.out.println(tur + ". TUR");
      kartlariDagit();
      insanOynadi = false;
      oyuncular[0].kartlariAc();
      for (int k = 0; k < 4; k++) {
        oyuncular[0].getEl().kartGoster(k).setLocation(250 + k * 70, 450);
      }
      // kartlar yere atılıyor
      for (int e = 0; e < 4; e++) {
        do {
          System.out.println("Sıra insanda");
        } while (!insanOynadi);
        insanOynadi = false;
        oyuncular[0].kartlariPasifYap();
        for (int o = 1; o < 4; o++) {
          int rs = (int) (Math.random() * oyuncular[o].getEl().kartSayisi());
          yer.kartEkle(oyuncular[o].getEl().kartAl(rs));
          yer.kartGoster(yer.kartSayisi() - 1).setLocation(300 + (o / 2) * 70, 200 + (o % 2) * 100);
        }
        yeniEl = false;
        dgmYeniEl.setVisible(true);
        do {
          System.out.println("Yeni El Başlatın");
        } while (!yeniEl);
        oyuncular[0].kartlariAktifYap();
        yer.kartlarAl();
      }

    }
  }

  public static void main(String[] args) {
    new demo_02();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(dgmKartVer)) {
      basla();
    }
    if (e.getSource().equals(dgmYeniEl)) {
      yeniEl = true;
      dgmYeniEl.setVisible(false);
    }
    Kartlar oyuncuKartlar = oyuncular[0].getEl();
    for (int k = 0; k < oyuncuKartlar.kartSayisi(); k++) {
      if (e.getSource().equals(oyuncuKartlar.kartGoster(k))) {
        yer.kartEkle(oyuncuKartlar.kartAl(k));
        yer.kartGoster(yer.kartSayisi() - 1).setLocation(300, 300);
        insanOynadi = true;
      }
    }

  }
}
