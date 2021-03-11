
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Kart extends JButton {

    private final int no;
    private final int deger;
    private final String seri; // Kupa, Maça, Karo, Sinek
    private final String isim; // A,2,3,4,5,6,7,8,9,10,J,Q,K
    private final String klasör;
    private ImageIcon resim;

    public Kart(int no, int deger, String seri, String isim, String klasör) {
        this.no = no;
        this.deger = deger;
        this.seri = seri;
        this.isim = isim;
        this.klasör = klasör;
        this.resim = new ImageIcon(getClass().getResource("/" + klasör + "/bosKart.png"));
        super.setIcon(resim);
        super.setBounds(0, 0, resim.getIconWidth(), resim.getIconHeight());
    }

    public int getNo() {
        return this.no;
    }

    public int getDeger() {
        return deger;
    }

    public String getSeri() {
        return seri;
    }

    public String getIsim() {
        return isim;
    }

    public ImageIcon getResim() {
        return resim;
    }

    public void kartAc() {
        this.resim = new ImageIcon(getClass().getResource("/" + klasör + "/" + seri + "_" + isim + ".png"));
        this.setIcon(resim);
    }

    public String textKartBilgisi() {
        String text = "";
        switch (this.seri) {
            case "Kupa":
                text = "\u2665";
                break;
            case "Sinek":
                text = "\u2663";
                break;
            case "Karo":
                text = "\u2666";
                break;
            case "Maça":
                text = "\u2660";
                break;
        }
        return text + "-" + this.isim;
    }

    public String htmlKartBilgisi() {
        String html = "";
        switch (getSeri()) {
            case "Kupa":
                html = "<html><h3 style='color:red'>&hearts;" + getIsim() + "</h3></html>";
                break;
            case "Sinek":
                html = "<html><h3 style='color:black'>&clubs;" + getIsim() + "</h3></html>";
                break;
            case "Karo":
                html = "<html><h3 style='color:red'>&diams;" + getIsim() + "</h3></html>";
                break;
            case "Maça":
                html = "<html><h3 style='color:red'>&spades;" + getIsim() + "</h3></html>";
                break;
        }
        return html + "-" + this.isim;
    }

    @Override
    public String toString() {
        return seri + " " + isim + " Değeri = " + deger;
    }
}
