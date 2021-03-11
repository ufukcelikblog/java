package whileOrnek;

/**
 * Basit Faiz Örnek
 */
public class Uygulama04 {
    public static void main(String[] args) {
        int anapara = 100;
        double faiz = 0.05; // faiz oranı %5
        int dönem = 24; // 24 aylık
        int k=0;
        while(k<=dönem){
            double dsTutar = anapara * (1 + (faiz*k));
            System.out.println(k + " dönem sonu tutar: " + dsTutar);
            k++;
        }
    }
}
