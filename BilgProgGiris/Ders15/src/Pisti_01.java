
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Pisti_01 implements ActionListener {

    private final String[] seri = {"Kupa", "Sinek", "Karo", "Maça"};
    private final String[] isim = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private JFrame crv;
    private Kartlar deste;
    private Kartlar yer;
    private final Oyuncu[] oyuncular;
    private JButton dgmYeniEl;
    private JButton dgmYeniTur;
    private boolean insanOynadi;
    private boolean yeniEl;
    private int turSayisi, elSayisi;

    public Pisti_01() {
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
            deste.kartGoster(k).setLocation(0, 0);
            deste.kartGoster(k).addActionListener(this);
            //deste.kartGoster(k).kartAc();
            crv.add(deste.kartGoster(k));
        }
        yer = new Kartlar();
        oyuncular = new Oyuncu[4];
        for (int o = 0; o < oyuncular.length; o++) {
            oyuncular[o] = new Oyuncu("O-" + (o + 1));
        }

        dgmYeniEl = new JButton("Yeni El");
        dgmYeniEl.setBounds(0, 120, 100, 50);
        dgmYeniEl.addActionListener(this);
        crv.add(dgmYeniEl);
        dgmYeniTur = new JButton("Yeni Tur");
        dgmYeniTur.setBounds(0, 300, 100, 50);
        dgmYeniTur.addActionListener(this);
        dgmYeniTur.setVisible(false);
        turSayisi = 3;
        elSayisi = 4;
        crv.add(dgmYeniTur);
        crv.setVisible(true);
    }

    public void kartlariDagit() {
        for (int o = 0; o < oyuncular.length; o++) {
            System.out.println("Oyuncu: " + oyuncular[o].getIsim());
            for (int k = 0; k < 4; k++) {
                oyuncular[o].getEl().kartEkle(deste.kartAl());
            }
        }
        for (int id = 0; id < oyuncular[0].getEl().kartSayisi(); id++) {
            oyuncular[0].getEl().kartGoster(id).setLocation(id * 70 + 100, 450);
        }
        oyuncular[0].kartlariAc();
        turSayisi--;
        elSayisi = 4;
    }

    public void yerdekiKartlariTemizle() {
        for (int k = 0; k < yer.kartSayisi(); k++) {
            yer.kartGoster(k).setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Pisti_01();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(dgmYeniEl)) {
            System.out.println("Tur = " + turSayisi);
            yerdekiKartlariTemizle();
            yer.kartlarAl();
            dgmYeniEl.setVisible(false);
            if (turSayisi > 0) {
                kartlariDagit();
            } else {
                System.out.println("Oyun Bitti");
            }
        }
        if (e.getSource().equals(dgmYeniTur)) {
            System.out.println("El = " + elSayisi);
            dgmYeniTur.setVisible(false);
            if (elSayisi > 0) {
                yerdekiKartlariTemizle();
                yer.kartlarAl();
                oyuncular[0].kartlariAktifYap();
            }
        }
        for (int k = 0; k < oyuncular[0].getEl().kartSayisi(); k++) {
            if (e.getSource().equals(oyuncular[0].getEl().kartGoster(k))) {
                yer.kartEkle(oyuncular[0].getEl().kartAl(k));
                yer.kartGoster(yer.kartSayisi() - 1).setLocation(340, 300);
                yer.kartGoster(yer.kartSayisi() - 1).kartAc();
                oyuncular[0].kartlariPasifYap();
                for (int o = 1; o < 4; o++) {
                    int rs = (int) (Math.random() * oyuncular[o].getEl().kartSayisi());
                    yer.kartEkle(oyuncular[o].getEl().kartAl(rs));
                    yer.kartGoster(yer.kartSayisi() - 1).setLocation(200 + o * 70, 100 + (o % 2) * 100);
                    yer.kartGoster(yer.kartSayisi() - 1).kartAc();
                }
                elSayisi--;
                if (elSayisi > 0) {
                    dgmYeniTur.setVisible(true);
                } else {
                    dgmYeniEl.setVisible(true);
                }
            }
        }

    }
}
