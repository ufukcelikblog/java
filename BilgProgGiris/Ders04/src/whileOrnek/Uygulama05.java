package whileOrnek;

/**
 * Bileşik faiz örnek
 * formül = Birikimli Tutar = anapara x (1+faiz) ^ dönem
 */
public class Uygulama05 {
    public static void main(String[] args) {        
        int anapara = 100;
        double faiz = 0.05; // faiz %5
        int donem = 24;
        int k=0;
        while(k<=donem) {
            double birikimliTutar = anapara * Math.pow(1+faiz, k);
            System.out.println(k + ". dönem sonu: " + birikimliTutar);
            k++;
        }
    }
}
