
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Batak_01 implements ActionListener {

    private final String[] seri = {"Kupa", "Sinek", "Karo", "Maça"};
    private final String[] isim = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final String[] oyuncuAdlar = {"Sen", "Ali", "Yasemin", "Cem"};

    private final JFrame crv = new JFrame("BATAK");
    private JLabel etkYeniEl = new JLabel("EL = 0");
    private JButton dgmYeniEl = new JButton("Yeni El");
    private JLabel etkYeniTur = new JLabel("TUR = 0");
    private JButton dgmYeniTur = new JButton("Yeni Tur");
    private Kartlar deste = new Kartlar();
    private Kartlar yer = new Kartlar();
    private Oyuncu[] oyuncular = new Oyuncu[4];
    private JLabel[] etkAdlar = new JLabel[4];
    private JLabel[] etkBahisler = new JLabel[4];
    private int oynananElSayisi, oynananTurSayisi;
    private final Object[] bahisSecenekleri = {"0", "1", "2", "3", "4", "5", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

    public Batak_01() {
        guiBaslat();
    }

    public void guiBaslat() {
        // çerçeve özellikleri
        crv.setLayout(null);
        crv.setSize(980, 700);
        crv.setLocationRelativeTo(null);
        crv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // yeni el başlatma düğme ve etiket özellikleri
        etkYeniEl.setBounds(260, 250, 100, 50);
        etkYeniEl.setFont(new Font("Arial", Font.BOLD, 18));
        crv.add(etkYeniEl);
        dgmYeniEl.setBounds(250, 300, 100, 50);
        dgmYeniEl.setFont(new Font("Arial", Font.BOLD, 18));
        dgmYeniEl.addActionListener(this);
        crv.add(dgmYeniEl);

        // yeni tur başlatma düğme ve etiket özellikleri
        etkYeniTur.setBounds(660, 250, 100, 50);
        etkYeniTur.setFont(new Font("Arial", Font.BOLD, 18));
        crv.add(etkYeniTur);
        dgmYeniTur.setBounds(650, 300, 120, 50);
        dgmYeniTur.setFont(new Font("Arial", Font.BOLD, 18));
        dgmYeniTur.addActionListener(this);
        dgmYeniTur.setEnabled(false);
        crv.add(dgmYeniTur);

        yeniDesteKartlariOlustur();

        // oyuncuları oluşturma
        for (int o = 0; o < oyuncular.length; o++) {
            oyuncular[o] = new Oyuncu(oyuncuAdlar[o]);
        }

        // oyuncu ad etiketlerini oluşturma
        for (int no = 0; no < etkAdlar.length; no++) {
            etkAdlar[no] = new JLabel(oyuncular[no].getIsim());
            etkAdlar[no].setFont(new Font("Arial", Font.BOLD, 18));
        }
        etkAdlar[0].setBounds(400, 470, 100, 50);
        etkAdlar[1].setBounds(30, 70, 100, 50);
        etkAdlar[2].setBounds(370, 0, 100, 50);
        etkAdlar[3].setBounds(870, 70, 100, 50);
        // bilgi etiketlerini çerçeveye ekleme
        crv.add(etkAdlar[0]);
        crv.add(etkAdlar[1]);
        crv.add(etkAdlar[2]);
        crv.add(etkAdlar[3]);
        
        // oyuncu bahis etiketlerini oluşturma
        for (int no = 0; no < etkBahisler.length; no++) {
            etkBahisler[no] = new JLabel(oyuncular[no].getBahisSayisi() + " / " + oyuncular[no].getAlinanEl());
            etkBahisler[no].setFont(new Font("Arial", Font.BOLD, 18));
        }
        etkBahisler[0].setBounds(500, 470, 100, 50);
        etkBahisler[1].setBounds(30, 100, 100, 50);
        etkBahisler[2].setBounds(500, 0, 1000, 50);
        etkBahisler[3].setBounds(870, 100, 100, 50);
        // bilgi etiketlerini çerçeveye ekleme
        crv.add(etkBahisler[0]);
        crv.add(etkBahisler[1]);
        crv.add(etkBahisler[2]);
        crv.add(etkBahisler[3]);

        oynananElSayisi = 0;
        oynananTurSayisi = 0;

        crv.setVisible(true);
    }

    public void yeniDesteKartlariOlustur() {
        // deste oluşturma
        int id = 0;
        for (int s = 0; s < seri.length; s++) {
            for (int i = 0; i < isim.length; i++) {
                int deger = i > 7 ? 10 : i + 2;
                deste.kartEkle(new Kart(id, deger, seri[s], isim[i], "resimler67x100"));
                id++;
            }
        }
        deste.karistir();
        for (int k = 0; k < 52; k++) {
            deste.kartGoster(k).setLocation(470, 270);
            deste.kartGoster(k).addActionListener(this);
            //deste.kartGoster(k).kartAc();
            crv.add(deste.kartGoster(k));
        }
    }

    public void kartlariDagit() {
        for (int o = 0; o < oyuncular.length; o++) {
            for (int k = 0; k < 13; k++) {
                oyuncular[o].getEl().kartEkle(deste.kartAl());
            }
        }
        oyuncular[0].getEl().seriKucuktenBuyuge();
        oyuncular[0].kartlariAc();
        for (int id = 0; id < oyuncular[0].getEl().kartSayisi(); id++) {
            oyuncular[0].getEl().kartGoster(id).setLocation(id * 70 + 30, 530);
        }
        for (int id = 0; id < oyuncular[1].getEl().kartSayisi(); id++) {
            oyuncular[1].getEl().kartGoster(id).setLocation(30, 150 + id * 20);
        }
        for (int id = 0; id < oyuncular[2].getEl().kartSayisi(); id++) {
            oyuncular[2].getEl().kartGoster(id).setLocation(id * 30 + 250, 50);
        }
        for (int id = 0; id < oyuncular[3].getEl().kartSayisi(); id++) {
            oyuncular[3].getEl().kartGoster(id).setLocation(870, 150 + id * 20);
        }

        for (int no = 0; no < 4; no++) {
            if (no == 0) {
                int iddia = JOptionPane.showOptionDialog(crv, "Kaç el kazanırsınız?", "BAHİS ?",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bahisSecenekleri, bahisSecenekleri[0]);
                oyuncular[no].setBahisSayisi(iddia - 2);
            } else {
                oyuncular[no].setBahisSayisi(oyuncuBahisHesapla(no));
            }
            etkBahisler[no].setText(oyuncular[no].getBahisSayisi() + " / " + oyuncular[no].getAlinanEl());
        }

    }

    public int oyuncuBahisHesapla(int no) {
        int bahis = 0;
        for (int k = 0; k < oyuncular[no].getEl().kartSayisi(); k++) {
            if (oyuncular[no].getEl().kartGoster(k).getSeri().equals("Maça")) {
                bahis++;
            }
        }
        return bahis;
    }

    public String textKartBilgisi(Kart k) {
        String text = "";
        switch (k.getSeri()) {
            case "Kupa":
                text = "\u2665";
                break;
            case "Sinek":
                text = "\u2663";
                break;
            case "Karo":
                text = "\u2666";
                break;
            case "Maça":
                text = "\u2660";
                break;
        }
        return text + "_" + isim;
    }

    public String htmlKartBilgisi(Kart k) {
        String html = "";
        switch (k.getSeri()) {
            case "Kupa":
                html = "<html><h3 style='color:red'>&hearts;" + k.getIsim() + "</h3></html>";
                break;
            case "Sinek":
                html = "<html><h3 style='color:black'>&clubs;" + k.getIsim() + "</h3></html>";
                break;
            case "Karo":
                html = "<html><h3 style='color:red'>&diams;" + k.getIsim() + "</h3></html>";
                break;
            case "Maça":
                html = "<html><h3 style='color:red'>&spades;" + k.getIsim() + "</h3></html>";
                break;
        }
        return html + "_" + isim;
    }

    public void yerdekiKartlariTemizle() {
        for (int k = 0; k < yer.kartSayisi(); k++) {
            yer.kartGoster(k).setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Batak_01();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(dgmYeniEl)) {
            oynananElSayisi++;
            etkYeniEl.setText("EL = " + oynananElSayisi);
            oynananTurSayisi++;
            etkYeniTur.setText("TUR = " + oynananTurSayisi);
            yerdekiKartlariTemizle();
            yer.kartlarAl();
            dgmYeniEl.setEnabled(false);
            kartlariDagit();
        }
        if (e.getSource().equals(dgmYeniTur)) {
            oynananTurSayisi++;
            etkYeniTur.setText("TUR = " + oynananTurSayisi);
            dgmYeniTur.setEnabled(false);
            yerdekiKartlariTemizle();
            yer.kartlarAl();
            oyuncular[0].kartlariAktifYap();
        }
        for (int k = 0; k < oyuncular[0].getEl().kartSayisi(); k++) {
            if (e.getSource().equals(oyuncular[0].getEl().kartGoster(k))) {
                yer.kartEkle(oyuncular[0].getEl().kartAl(k));
                yer.kartGoster(yer.kartSayisi() - 1).setLocation(470, 340);
                yer.kartGoster(yer.kartSayisi() - 1).kartAc();
                oyuncular[0].kartlariPasifYap();
                for (int o = 1; o < 4; o++) {
                    int rs = (int) (Math.random() * oyuncular[o].getEl().kartSayisi());
                    yer.kartEkle(oyuncular[o].getEl().kartAl(rs));
                    yer.kartGoster(yer.kartSayisi() - 1).setLocation(330 + o * 70, 200 + (o % 2) * 70);
                    yer.kartGoster(yer.kartSayisi() - 1).kartAc();
                }
                if (oynananTurSayisi < 13) {
                    dgmYeniTur.setEnabled(true);
                } else {
                    yeniDesteKartlariOlustur();
                    dgmYeniEl.setEnabled(true);
                    oynananTurSayisi = 0;
                }
            }
        }

    }
}
