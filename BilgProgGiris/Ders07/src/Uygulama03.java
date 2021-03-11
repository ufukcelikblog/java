
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Uygulama03 {
  public static void main(String[] args) {
    ImageIcon resim = new ImageIcon("src/iskambil/k11.png");
    Object dugmeler[] = {"Evet","Hayır","ÇIKIŞ"};
    int tercih = JOptionPane.showOptionDialog(null, 
            "Bir tercih yapınız", // mesaj
            "TERCİH", // başlık
            JOptionPane.DEFAULT_OPTION, // seçenek türü
            JOptionPane.INFORMATION_MESSAGE, // mesaj türü
            null, // ikon
            dugmeler, // düğmeler objesi
            dugmeler[2]); // varsayılan seçenek düğmesi
    System.out.println("Indeks:" + tercih + " TERCİH=" + dugmeler[tercih]);
  }
}
