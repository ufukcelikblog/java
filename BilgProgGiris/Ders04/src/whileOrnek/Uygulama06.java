package whileOrnek;

import javax.swing.JOptionPane;

/**
 * Sayı Tahmin Oyunu
 */
public class Uygulama06 {
    
    public static void main(String[] args) {
        // bilgisayar 1 ile 100 arasında rastgele bir syı tutuyor
        int rs = (int)(Math.random() * 100) + 1;
        System.out.println("rs = " + rs);
        int tahmin;
        do {
            String t = JOptionPane.showInputDialog("TAHMİN ET");
            tahmin = Integer.parseInt(t);
        } while(tahmin != rs);
        JOptionPane.showMessageDialog(null, "TEBRİKLER");
    }
}
