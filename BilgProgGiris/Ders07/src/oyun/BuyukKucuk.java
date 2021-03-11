package oyun;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BuyukKucuk {
  public static void main(String[] args) {
    // dizinin tanımlanması
    JLabel deste[] = new JLabel[53]; 
    for(int no=0; no<deste.length; no++) {
      // dizi elemanın tanımlaması
      deste[no] = new JLabel(new ImageIcon("src/iskambil/k" + no + ".png"));   
    }
    int puan = 0;
    boolean oyunDevam = true;
    Object dugmeler[] = {"Küçük", "Büyük", "ÇIKIŞ"};
    int eskiKagitNo = (int)(Math.random() * 52) + 1; // ilk kağıt
    int yeniKagitNo = 0;
    do {
      Object ekran[] = new Object[2];
      ekran[0] = deste[eskiKagitNo];
      ekran[1] = deste[yeniKagitNo];
      int cevap = JOptionPane.showOptionDialog(null, ekran, 
              "Küçük Büyük Oyunu", 
              JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
              null, dugmeler, dugmeler[2]);
      int mod = eskiKagitNo % 13; // bir seride 13 kağıt var
      int eskiKagitDeger = mod == 0 ? 13 : mod;
      eskiKagitNo = yeniKagitNo;
      yeniKagitNo = (int)(Math.random() * 52) + 1;
      mod = yeniKagitNo % 13;
      int yeniKagitDeger = mod == 0 ? 13 : mod;
      // Küçük seçildi
      if(cevap == 0 && yeniKagitDeger < eskiKagitDeger) puan += 2; 
      else if(cevap == 1 && yeniKagitDeger > eskiKagitDeger) puan += 2;
      else puan--;
      if(cevap == 2) oyunDevam = false;
    } while(oyunDevam);
    JOptionPane.showMessageDialog(null, "PUAN = " + puan);
  }
}
