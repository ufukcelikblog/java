
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Oyun implements ActionListener {
  private JFrame crv;
  private JButton dgm[];
  private JButton yeni;
  private JLabel etk;
  private int ds = 5, rs, hak;
  
  public Oyun(int d) {
    ds = d;
    crv = new JFrame("Define Tarlası");
    dgm = new JButton[ds * ds]; // dizi tanımladık
    yeni = new JButton("Yeni Oyun"); // düğme tanımladık
    etk = new JLabel("Bir yerde hazine var. Bulabilir misin?");
  }
  public void basla() {
    hak = ds;
    crv.setLayout(null);
    crv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    crv.setSize(300, 300); // genişlik, yükseklik
    crv.setLocationRelativeTo(null); // ekran ortası
    etk.setBounds(50, 10, 300, 30);
    crv.add(etk);
    yeni.setBounds(100, 50, 100, 30);
    yeni.addActionListener(this);
    crv.add(yeni);
    for(int x=0; x <(ds*ds); x++) {
      dgm[x] = new JButton("");
      dgm[x].setBounds((x%ds)*30+50, (x/ds)*30+100, 30, 30);
      dgm[x].addActionListener(this);
      crv.add(dgm[x]);
    }
    crv.setVisible(true);
    rs = (int)(Math.random()*(ds*ds));
    System.out.println("rs = " + rs);
  }
  
  public void aktifYap() {
    for(int x=0; x<(ds*ds); x++) {
      dgm[x].setEnabled(true);
      dgm[x].setBackground(null);
    }
  }
  
  public void pasifYap() {
    for(int x=0; x<(ds*ds); x++) {
      dgm[x].setEnabled(false);
    }
  }
  
  public static void main(String[] args) {
    Oyun o = new Oyun(20);
    o.basla();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == yeni) {
      hak = ds;
      rs = (int)(Math.random() * (ds*ds));
      System.out.println("rs = " + rs);
      aktifYap();
    }
    if(hak != 0) {
      hak--;
      etk.setText(hak + " hakkınız kaldı");
      for(int x=0; x<(ds*ds); x++) {
        if(e.getSource() == dgm[x]) {
          dgm[x].setEnabled(false);
          if(x == rs) {
            dgm[x].setBackground(Color.green);
            etk.setText("BRAVOOO!!!");
            pasifYap();
          }
        }
      }
    } else { // hak kalmadı oyun bitti
      etk.setText("Bulamadınız!!!");
      dgm[rs].setBackground(Color.red);
      pasifYap();
    }
  }
}
