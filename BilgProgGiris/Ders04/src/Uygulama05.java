// Asal sayı bulmak
public class Uygulama05 {
    public static void main(String[] args) {
        int sayi = 13;
        // başlangıçta asal kabul ediyorum
        boolean asal = true; 
        for(int k=2; k<sayi/2; k++) {
            // sayının bölünenlerini kontrol ediyoruz
            if(sayi % k == 0) asal = false;
        }
        if(asal) System.out.println(sayi + " ASAL");
        else System.out.println(sayi + " ASAL DEĞİL");
    }
}
