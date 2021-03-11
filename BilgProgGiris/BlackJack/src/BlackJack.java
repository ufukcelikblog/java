


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BlackJack {

  public static void main(String[] args) {
    boolean oyunDevam = true;
    Object etiketBahis[] = {"5 TL", "10 TL", "20 TL", "50 TL", "100 TL", "200 TL", "ÇIKIŞ"};
    Object etiketOyun[] = {"Kağıt AL", "BEKLE"};

    int bilgisayarPuan;
    String bilgisayarMesaj;
    JPanel bilgisayarPanel = new JPanel();
    boolean bilgisayarDevam;
    boolean bilgisayarAS = false;

    int oyuncuPara = 1000;
    int oyuncuPuan;
    int bahis = 0;
    String oyuncuMesaj;
    JPanel oyuncuPanel = new JPanel();
    boolean oyuncuDevam;
    boolean oyuncuAS = false;

    int kartNo, kartPuan;
    String durumMesaj;
    Object oyunPanel[] = new Object[5];

    do {
      System.out.println("*************  YENİ OYUN  *************");
      int bahisSecim;
      bahisSecim = JOptionPane.showOptionDialog(null,
              "<html><h1>BlackJack Oyunu</h1></html>\n"
                      + "Kağıtları toplamı 21 veya 21'e en yakın olan kazanır.\n"
                      + "Bilgisayarın kağıtları toplamı en az 17 olmalıdır.\n"
                      + "<html><h1>Lütfen bahsinizi seçin !!!</html></h1>",
              "BlackJack Bahis Seçimi",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.WARNING_MESSAGE,
              new ImageIcon(BlackJack.class.getResource("resimler/logo.png")),
              etiketBahis, etiketBahis[0]);
      switch (bahisSecim) {
        case 0:
          bahis = 5;
          break;
        case 1:
          bahis = 10;
          break;
        case 2:
          bahis = 20;
          break;
        case 3:
          bahis = 50;
          break;
        case 4:
          bahis = 100;
          break;
        case 5:
          bahis = 200;
          break;
        case 6:
          System.exit(0);
          break;
      }
      System.out.println("Bahis = " + bahis);
      durumMesaj = "Bahis = " + bahis + "\nParanız = " + oyuncuPara;

      bilgisayarPuan = 0;
      bilgisayarDevam = true;
      // Bilgisayar 1. kart çekiliyor
      kartNo = (int) (Math.random() * 52) + 1;
      System.out.print("Bilgisayar\tKartNO = " + kartNo + "\t");
      switch (kartNo % 13) {
        case 0:
          kartPuan = 10;
          break; // K geldi kartPuan = 10
        case 1:
          kartPuan = 11;
          bilgisayarAS = true;
          break; // AS geldi kartPuan = 11
        case 11:
        case 12:
          kartPuan = 10;
          break; // J veya Q geldi
        default:
          kartPuan = kartNo % 13;
          break; // 
      }
      System.out.print("KartPUAN  = " + kartPuan + "\t");
      bilgisayarPuan += kartPuan;
      bilgisayarPanel.add(new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k" + kartNo + ".png"))));
      System.out.println("TOPLAM PUAN  = " + bilgisayarPuan);
      // Bilgisayar 2. kağıt kapalı gösterilir.
      JLabel kapaliKagit = new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k0.png")));
      bilgisayarPanel.add(kapaliKagit);
      bilgisayarMesaj = "Bilgisayar = " + bilgisayarPuan + " Puan";
      
      oyuncuPuan = 0;
      oyuncuDevam = true;
      // Oyuncu 1. kart 
      kartNo = (int) (Math.random() * 52) + 1;
      System.out.print("Oyuncu\tKartNO = " + kartNo + "\t");
      switch (kartNo % 13) {
        case 0:
          kartPuan = 10;
          break; // K geldi kartPuan = 10
        case 1:
          kartPuan = 11;
          oyuncuAS = true;
          break; // AS geldi kartPuan = 11
        case 11:
        case 12:
          kartPuan = 10;
          break; // J veya Q geldi
        default:
          kartPuan = kartNo % 13;
          break; // 
      }
      System.out.print("KartPUAN = " + kartPuan + "\t");
      oyuncuPuan += kartPuan;
      oyuncuPanel.add(new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k" + kartNo + ".png"))));
      System.out.println("Toplam PUAN  = " + oyuncuPuan);

      // Oyuncu 2. kartNo
      kartNo = (int) (Math.random() * 52) + 1;
      System.out.print("Oyuncu\tKartNO = " + kartNo + "\t");
      switch (kartNo % 13) {
        case 0:
          kartPuan = 10;
          break; // K geldi kartPuan = 10
        case 1:
          kartPuan = 11;
          oyuncuAS = true;
          break; // AS geldi kartPuan = 11
        case 11:
        case 12:
          kartPuan = 10;
          break; // J veya Q geldi
        default:
          kartPuan = kartNo % 13;
          break; // 
      }
      System.out.print("KartPUAN = " + kartPuan + "\t");
      oyuncuPuan += kartPuan;
      oyuncuPanel.add(new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k" + kartNo + ".png"))));
      System.out.println("Toplam PUAN  = " + oyuncuPuan);
      oyuncuMesaj = "Oyuncu = " + oyuncuPuan + " Puan";

      if (oyuncuPuan >= 21) { // oyuncu bitirdi kart çekmeye gerek yok
        oyuncuDevam = false;
        bilgisayarDevam = false;
      }

      // oyuncu oynamaya başladı
      while (oyuncuDevam) {
        oyunPanel[0] = bilgisayarMesaj;
        oyunPanel[1] = bilgisayarPanel;
        oyunPanel[2] = durumMesaj;
        oyunPanel[3] = oyuncuPanel;
        oyunPanel[4] = oyuncuMesaj;

        int kartSecim = JOptionPane.showOptionDialog(null, oyunPanel, "BlackJack Oyunu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null,
                etiketOyun, etiketOyun[0]);

        if (kartSecim == 1) { // BEKLE seçildi kartNo almaz
          oyuncuDevam = false;
        } else {    // Oyuncu yeni kartNo aldı
          kartNo = (int) (Math.random() * 52) + 1;
          switch (kartNo % 13) {
            case 0:
              kartPuan = 10;
              break; // K geldi kartPuan = 10
            case 1:
              kartPuan = 11;
              oyuncuAS = true;
              break; // AS geldi kartPuan = 11
            case 11:
            case 12:
              kartPuan = 10;
              break; // J veya Q geldi
            default:
              kartPuan = kartNo % 13;
              break; // 
          }
          System.out.print("Oyuncu\tKartNO = " + kartNo + "\tKartPUAN = " + kartPuan + "\t");
          oyuncuPuan += kartPuan;
          oyuncuPanel.add(new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k" + kartNo + ".png"))));
          if (oyuncuAS && oyuncuPuan > 21) { // oyuncuda AS var ama puanı 21'den büyük. AS=1 sayılır
            oyuncuPuan -= 10;
            oyuncuAS = false;
          }
          System.out.println("Toplam PUAN = " + oyuncuPuan);
          oyuncuMesaj = "Oyuncu = " + oyuncuPuan + " Puan";
        }

        if (oyuncuPuan >= 21) { // oyuncu bitirdi kart çekmeye gerek yok...
          oyuncuDevam = false;
          bilgisayarDevam = false;
        }
      }

      // bilgisayar oynamaya başladı. Kapalı kağıtı kaldıralım
      bilgisayarPanel.remove(kapaliKagit);
      while (bilgisayarDevam) {
        if (bilgisayarPuan < 17) {
          // Bilgisayar yeni kartNo
          kartNo = (int) (Math.random() * 52) + 1;
          switch (kartNo % 13) {
            case 0:
              kartPuan = 10;
              break; // K geldi kartPuan = 10
            case 1:
              kartPuan = 11;
              bilgisayarAS = true;
              break; // AS geldi kartPuan = 11
            case 11:
            case 12:
              kartPuan = 10;
              break; // J veya Q geldi
            default:
              kartPuan = kartNo % 13;
              break; // 
          }
          System.out.print("Bilgisayar\tKartNO = " + kartNo + "\tKartPUAN = " + kartPuan + "\t");
          bilgisayarPuan += kartPuan;
          bilgisayarPanel.add(new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k" + kartNo + ".png"))));
          if (bilgisayarAS && bilgisayarPuan > 21) { // bilgisayarda AS var ama puanı 21'den büyük. AS=1 sayılır
            bilgisayarPuan -= 10;
            bilgisayarAS = false;
          }
          System.out.println("Toplam PUAN = " + bilgisayarPuan);
          bilgisayarMesaj = "Bilgisayar = " + bilgisayarPuan + " Puan";
        } else {
          bilgisayarDevam = false;
        }
      }

      // Durum Kontrol
      String durum;
      if (oyuncuPuan == 21 || bilgisayarPuan > 21) {
        oyuncuPara += bahis;
        durum = "KAZANDINIZ";
      } else if (oyuncuPuan > 21 || bilgisayarPuan == 21) {
        oyuncuPara -= bahis;
        durum = "KAYBETTİNİZ";
      } else if(oyuncuPuan == bilgisayarPuan) {
        durum = "BERABERE";
      } else {
        if (oyuncuPuan < bilgisayarPuan) {
          oyuncuPara -= bahis;
          durum = "KAYBETTİNİZ";
        } else {
          oyuncuPara += bahis;
          durum = "KAZANDINIZ";
        }
      }
      durumMesaj = "Bahis = " + bahis + "\n<html><h1>!!! " + durum + " !!!</h1></html>\nParanız=" + oyuncuPara;
      oyunPanel[0] = bilgisayarMesaj;
      oyunPanel[1] = bilgisayarPanel;
      oyunPanel[2] = durumMesaj;
      oyunPanel[3] = oyuncuPanel;
      oyunPanel[4] = oyuncuMesaj;
      JOptionPane.showMessageDialog(null, oyunPanel);
      bilgisayarPanel.removeAll();
      oyuncuPanel.removeAll();
    } while (oyunDevam);

    JOptionPane.showMessageDialog(null, "Kalan Paranız = " + oyuncuPara);
  }
}
