import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UygulamaIki extends JFrame implements ActionListener {
  JButton dugme1, dugme2; // Global değişken
  // kurucu metot (void veya return değil)
  public UygulamaIki() {
    super("2. form"); // JFrame burda süper sınıftır
    // this komutu extends edilen sınıfı temsil eder
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300, 200);
    this.setLayout(null);
    
    dugme1 = new JButton("Düğme 1 tıkla");
    dugme1.setBounds(70, 30, 120, 30);
    // düğmeyi dinlemeye başladı
    dugme1.addActionListener(this);
    this.add(dugme1);

    dugme2 = new JButton("Düğme 2 TIKLA");
    dugme2.setBounds(100, 70, 120, 30);
    // düğmeyi dinlemeye başladı
    dugme2.addActionListener(this);
    this.add(dugme2);
    
    this.setVisible(true);
  }
  
  public static void main(String[] args) {
    UygulamaIki ufuk = new UygulamaIki();
  }

  @Override
  public void actionPerformed(ActionEvent olayNesnesi) {
    if(olayNesnesi.getSource() == dugme1) {
      JOptionPane.showMessageDialog(null, "Düğme 1 tıklandı");
    }
    if(olayNesnesi.getSource() == dugme2) {
      JOptionPane.showMessageDialog(null, "Düğme 2 tıklandı");
    }
  }
   
}
