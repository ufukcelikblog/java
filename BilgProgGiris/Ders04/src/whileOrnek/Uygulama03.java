package whileOrnek;

import javax.swing.JOptionPane;

public class Uygulama03 {
    public static void main(String[] args) {
        String kad, sifre;
        do {
            kad = JOptionPane.showInputDialog("Kullanıcı Adı");
            sifre = JOptionPane.showInputDialog("Şifre");
        } while(!kad.equals("ufuk") || !sifre.equals("123"));
        JOptionPane.showMessageDialog(null, "HOŞGELDİN");
    }
}
