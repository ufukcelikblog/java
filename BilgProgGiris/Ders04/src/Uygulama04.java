public class Uygulama04 {
    public static void main(String[] args) {
        int sayi = 11;
        int k = sayi;
        for( ; k>0; k-=2) {
            System.out.println("k="+k);
        }
        System.out.println("k="+k);
        if(k<0) {
            System.out.println(sayi + " TEK");
        } else {
            System.out.println(sayi + " ÇİFT");
        }
    }
}
