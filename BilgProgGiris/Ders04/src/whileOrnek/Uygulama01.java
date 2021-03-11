/*
 * Paket ismi 
 */
package whileOrnek;

public class Uygulama01 {
    public static void main(String[] args) {
        int sayac = 0; // faktöriyeli alınacak sayı
        int faktoryel = 1;
        System.out.print(sayac + " faktöryel = ");
        while(sayac > 0) {
            faktoryel *= sayac--;
        }
        System.out.println(faktoryel);
    }
}
