package dizi;

import javax.swing.JOptionPane;

public class Uygulama05 {
  public static void main(String[] args) {
    String birler[] = {"","bir","iki","üç","dört","beş",
                       "altı","yedi","sekiz","dokuz"};
    String onlar[] = {"", "on","yirmi","otuz","kırk","elli",
                      "altmış","yetmiş","seksen","doksan"};
    int sayi=0;
    do {
      try {
        String s = JOptionPane.showInputDialog("4 basamaklı bir sayı giriniz");
        if(s.length() != 4) s = "0";
        sayi = Integer.parseInt(s);
        /*
        int bolum = sayi;
        int basamak = 0;
        while(bolum > 0) {
          basamak++;
          bolum = bolum / 10;
        }
        if(basamak != 4) sayi = 0;
        */
      } catch(NumberFormatException hata) {
        JOptionPane.showMessageDialog(null, "Lütfen sayı giriniz!!!", 
                "HATA", JOptionPane.ERROR_MESSAGE);
      }      
    } while(sayi == 0);
    
    int bir = sayi % 10;
    int on = (sayi / 10) % 10;
    int yuz = (sayi / 100) % 10;
    int bin = sayi / 1000;
    System.out.println(bir + " " + on + " " + yuz + " " + bin);
    String Turkce = "";
    Turkce += birler[bin] + " bin ";
    Turkce += birler[yuz] + " yüz ";
    Turkce += onlar[on] + " ";
    Turkce += birler[bir];
    System.out.println(sayi + " = " + Turkce);
  }
}
