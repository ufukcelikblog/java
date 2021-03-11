package oyun;

import javax.swing.JOptionPane;

/**
 * Sayı Tahmin Oyunu
 *
 * @author ucelik
 */
public class SayiTahmin {

  public static void main(String[] args) {
    boolean oyunDevam = true;
    int GenelPuan = 0;
    // bir tur başlangıcı
    while (oyunDevam) {
      int rs = (int) (Math.random() * 100) + 1;
      System.out.println("Rastgele Sayı = " + rs);
      int denemePuan = 10;
      int tahmin = 0;
      for (int hak = 10; hak > 0; hak--) {
        boolean hataliGiris = false;
        do {
          try {
            String t = JOptionPane.showInputDialog("Bir sayı tahmin et");
            tahmin = Integer.parseInt(t);
            hataliGiris = false;
          } catch (NumberFormatException hata) {
            JOptionPane.showMessageDialog(null, "Lütfen sayı giriniz",
                    "HATA - SAYI GİRİLMELİ", JOptionPane.ERROR_MESSAGE);
            hataliGiris = true;
          }
        } while (hataliGiris);
        if (tahmin < rs) {
          JOptionPane.showMessageDialog(null, "KÜÇÜK sayı girdiniz",
                  "KÜÇÜK", JOptionPane.WARNING_MESSAGE);
          denemePuan--;
        }
        if (tahmin > rs) {
          JOptionPane.showMessageDialog(null, "BÜYÜK sayı girdiniz",
                  "BÜYÜK", JOptionPane.WARNING_MESSAGE);
          denemePuan--;
        }
        if (tahmin == 0) {
          break;
        }
        if (tahmin == rs) {
          JOptionPane.showMessageDialog(null, "BRAVOOO !!! \n"
                  + (10 - hak) + ". denemede bildin.\n"
                  + "Puanın = " + denemePuan,
                  "!!! BİLDİNİZ !!!", JOptionPane.INFORMATION_MESSAGE);
          break;
        }
        GenelPuan += denemePuan;
      } // tahmin girişleri bitti
      int cevap = JOptionPane.showConfirmDialog(null, "Tekrar oynamak ister misin?");
      if (cevap == 1) {
        oyunDevam = false;
      }
    } // oyun döngüsü bitişi
    JOptionPane.showMessageDialog(null, "GENEL PUAN = " + GenelPuan + "\nOyun Bitti");
  }
}
