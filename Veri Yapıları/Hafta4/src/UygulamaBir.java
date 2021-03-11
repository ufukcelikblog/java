import javax.swing.JFrame;
import javax.swing.JLabel;

public class UygulamaBir {
  public static void main(String[] args) {
    // Yeni bir çerçeve
    JFrame formUfuk = new JFrame("1. Form");
    // çerçeve kapatılınca ana metot sonlansın
    formUfuk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // çerçenin boyutları (genişlik, yükseklik)
    formUfuk.setSize(300, 200);
    // çerçevenin yerleşim düzeni ayarlıyoruz
    formUfuk.setLayout(null);
    // etiket tanımlıyoruz
    JLabel etiket = new JLabel("MERHABA");
    // x koordinat, y koordinat, genişlik, yükseklik
    etiket.setBounds(50, 75, 100, 30);
    // etiketi forma ekliyoruz
    formUfuk.add(etiket);
    // çerçeve görünsün
    formUfuk.setVisible(true);
    
    
    UygulamaIki c1 = new UygulamaIki();
  }
}
