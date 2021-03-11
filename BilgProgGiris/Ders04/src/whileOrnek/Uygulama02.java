package whileOrnek;

public class Uygulama02 {
    public static void main(String[] args) {
        int sayac = 0;
        int faktoryel = 1;
        do {
            faktoryel *= sayac--;
        } while(sayac > 0);
        System.out.println("Sonuç = " + faktoryel);
    }
    
}
