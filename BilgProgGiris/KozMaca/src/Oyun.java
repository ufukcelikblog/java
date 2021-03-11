
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Oyun implements ActionListener {

    private final String[] seri = {"Kupa", "Sinek", "Karo", "Maça"};
    private final String[] isim = {"2", "3", "4", "5",
        "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final String[] oyuncuAdlar = {"Sen", "Ali", "Canan", "Koray"};

    private final JFrame crv = new JFrame("KOZ MAÇA");
    private Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resimler67x100/masa.png"));
    private final Font font = new Font("Arial", Font.BOLD, 14);
    private final JButton dgmYeniOyun = new JButton("Yeni Oyun");
    private final JButton dgmYeniEl = new JButton("Yeni El");
    private final Kartlar deste = new Kartlar();
    private final Kartlar yer = new Kartlar();
    private final Oyuncu[] oyuncular = new Oyuncu[4];
    private final JTextArea[] bilgiler = new JTextArea[4];
    private int toplamOyunSayisi, toplamElSayisi, toplamTurSayisi, turOyuncuID;
    private String turSeri;
    private final Object[] bahisSecenekleri = {"0", "1", "2", "3", "4", "5", "4", "5", "6",
        "7", "8", "9", "10", "11", "12", "13"};

    public Oyun() {
        // arka plan görseli
        crv.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });
        // çerçeve özellikleri
        crv.setLayout(null);
        crv.setSize(995, 730);
        crv.setResizable(false);
        crv.setLocationRelativeTo(null);
        crv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // yeni oyun başlatma düğme özellikleri
        dgmYeniOyun.setBounds(350, 490, 120, 30);
        dgmYeniOyun.setFont(font);
        dgmYeniOyun.addActionListener(this);
        crv.add(dgmYeniOyun);
        // yeni el başlatma düğme özellikleri
        dgmYeniEl.setBounds(350, 530, 120, 30);
        dgmYeniEl.setFont(font);
        dgmYeniEl.addActionListener(this);
        dgmYeniEl.setEnabled(false);
        crv.add(dgmYeniEl);

        yeniDesteKartlariOlustur();

        // oyuncuları oluşturma
        for (int o = 0; o < oyuncular.length; o++) {
            oyuncular[o] = new Oyuncu(oyuncuAdlar[o]);
            bilgiler[o] = new JTextArea(oyuncular[o].bilgiTEXT());
            bilgiler[o].setEditable(false);
            bilgiler[o].setFont(font);
        }
        bilgiler[0].setBounds(500, 490, 80, 70);
        bilgiler[1].setBounds(40, 140, 80, 70);
        bilgiler[2].setBounds(280, 60, 80, 70);
        bilgiler[3].setBounds(870, 130, 80, 70);
        // bilgi etiketlerini çerçeveye ekleme
        crv.add(bilgiler[0]);
        crv.add(bilgiler[1]);
        crv.add(bilgiler[2]);
        crv.add(bilgiler[3]);

        crv.revalidate();
        crv.repaint();
        crv.setVisible(true);

        toplamOyunSayisi = 0;
        toplamElSayisi = 0;
        toplamTurSayisi = 0;
        turOyuncuID = 0;
    }

    public void yeniDesteKartlariOlustur() {
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
            deste.kartGoster(k).setLocation(750, 450);
            deste.kartGoster(k).addActionListener(this);
            //deste.kartGoster(k).kartAc();
            crv.add(deste.kartGoster(k));
        }
    }

    public static void main(String[] args) {
        new Oyun();
    }

    public void yerdekiKartlariTemizle() {
        for (int k = 0; k < yer.kartSayisi(); k++) {
            yer.kartGoster(k).setVisible(false);
        }
    }

    public void kartlariDagit() {
        for (int id = 0; id < oyuncular.length; id++) {
            for (int k = 0; k < 13; k++) {
                oyuncular[id].getKartlar().kartEkle(deste.kartAl());
                // kart hangi oyuncuya aitse onu belirliyoruz
                oyuncular[id].getKartlar().kartGoster(oyuncular[id].getKartlar().kartSayisi() - 1).setKartKimin(id);
            }
        }
        oyuncular[0].getKartlar().seriKucuktenBuyuge();
        oyuncular[0].kartlariAc();
        for (int id = 0; id < oyuncular[0].getKartlar().kartSayisi(); id++) {
            crv.add(oyuncular[0].getKartlar().kartGoster(id));
            oyuncular[0].getKartlar().kartGoster(id).setLocation(id * 70 + 30, 570);
        }
        // bahis belirleme
        for (int no = 0; no < 4; no++) {
            if (no == 0) {
                int iddia = JOptionPane.showOptionDialog(crv, "Kaç el kazanırsınız?", "BAHİS ?",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        bahisSecenekleri, bahisSecenekleri[0]);
                oyuncular[no].setBahis(iddia);
            } else {
                oyuncular[no].bahisHesapla();
            }
            bilgiler[no].setText(oyuncular[no].bilgiTEXT());
        }
    }

    public int kazananKartID() {
        int[] derece = new int[4];
        // kartları derecelendiriyoruz. 
        // Mod ile sırasını buluyorz. 
        // Maça var ise sırasını 10 ile çarpıyoruz
        for (int k = 0; k < yer.kartSayisi(); k++) {
            if (yer.kartGoster(k).getSeri().equals("Maça")) {
                derece[k] = 10 * (yer.kartGoster(k).getNo() % 13);
            } else {
                derece[k] = yer.kartGoster(k).getNo() % 13;
            }
        }
        int enBuyukKartID = 0;
        for (int k = 1; k < yer.kartSayisi(); k++) {
            if (derece[k] > derece[enBuyukKartID]) {
                enBuyukKartID = k;
            }
        }
        return enBuyukKartID;
    }

    public void puanlarHesapla() {
        for (int id = 0; id < 4; id++) {
            oyuncular[id].puanHesapla();
            bilgiler[id].setText(oyuncular[id].bilgiTEXT());
            oyuncular[id].setEl(0);
            oyuncular[id].setBahis(0);
        }
    }

    public void elOynat(int oyuncuID) {
        if (toplamTurSayisi < 4) {
            if (oyuncuID == 0) {
                if (toplamTurSayisi == 0) {
                    oyuncular[0].kartlariAktifYap();
                } else {
                    oyuncular[0].seridekiKartlariAktifYap(turSeri);
                }
            } else {
                yer.kartEkle(oyuncular[oyuncuID].getKartlar().kartAl(oyuncular[oyuncuID].hangiKartOynar(turSeri)));
                yer.kartGoster(yer.kartSayisi() - 1).setLocation(50 + oyuncuID * 200, 220 + (oyuncuID % 2) * 100);
                yer.kartGoster(yer.kartSayisi() - 1).kartAc();
                toplamTurSayisi++;
                turOyuncuID++;
                if (this.turOyuncuID > 3) {
                    this.turOyuncuID = 0;
                }
                elOynat(turOyuncuID);
            }
        } else {
            // Tur bitti. Kazanın kim
            int kazananKart = kazananKartID();
            int kazananOyuncu = yer.kartGoster(kazananKart).getKartKimin();
            yer.kartGoster(kazananKart).setBorder(BorderFactory.createLineBorder(Color.cyan, 3));
            oyuncular[kazananOyuncu].setEl(oyuncular[kazananOyuncu].getEl() + 1);
            bilgiler[kazananOyuncu].setText(oyuncular[kazananOyuncu].bilgiTEXT());
            turOyuncuID = kazananOyuncu; // kazanan yeni tura başlar
            toplamTurSayisi = 0;

            if (toplamElSayisi < 13) { // Yeni EL başlasın
                dgmYeniEl.setText("Yeni El");
                dgmYeniEl.setEnabled(true);
            } else { // Yeni OYUN başlasın
                puanlarHesapla();
                yeniDesteKartlariOlustur();
                dgmYeniOyun.setText("Yeni Oyun");
                dgmYeniOyun.setEnabled(true);
                toplamElSayisi = 0;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(dgmYeniOyun)) {
            toplamOyunSayisi++;
            this.dgmYeniOyun.setText("OYUN = " + toplamOyunSayisi);
            toplamElSayisi++;
            dgmYeniEl.setText("EL = " + toplamElSayisi);
            yerdekiKartlariTemizle();
            yer.kartlarAl();
            dgmYeniOyun.setEnabled(false);
            kartlariDagit();
        }
        if (e.getSource().equals(dgmYeniEl)) {
            toplamElSayisi++;
            dgmYeniEl.setText("EL = " + toplamElSayisi);
            dgmYeniEl.setEnabled(false);
            yerdekiKartlariTemizle();
            yer.kartlarAl();
            if (turOyuncuID != 0) {
                turSeri = seri[(int) (Math.random() * 4)];
            }
            elOynat(turOyuncuID);
        }
        // oyuncu hangi kartı oynadı
        for (int k = 0; k < oyuncular[0].getKartlar().kartSayisi(); k++) {
            if (e.getSource().equals(oyuncular[0].getKartlar().kartGoster(k))) {
                turSeri = oyuncular[0].getKartlar().kartGoster(k).getSeri();
                yer.kartEkle(oyuncular[0].getKartlar().kartAl(k));
                yer.kartGoster(yer.kartSayisi() - 1).setLocation(450, 370);
                //yer.kartGoster(yer.kartSayisi() - 1).kartAc();
                oyuncular[0].kartlariPasifYap();
                toplamTurSayisi++;
                turOyuncuID++;
                elOynat(turOyuncuID);
            }
        }
    }
}
