public class Uygulama_05 {
    public static void main(String[] args) {
        int sayi = 12;
        int kalan = sayi % 2;
        switch(kalan) {
            case 0: System.out.println(sayi + " ÇİFT"); break;
            case 1: System.out.println(sayi + " TEK"); break;
        }
    }
}
