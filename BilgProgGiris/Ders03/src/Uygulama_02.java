// sayı tek mi çift mi
public class Uygulama_02 {
    public static void main(String[] args) {
        int sayi = 54;
        // birler basamağı için sayının 10 modunu alıyoruz
        int b = sayi % 10; 
        // VEYA ifadesi || Klavyeden AltGr+(><) 
        // tek eşit atama için çift eşit kontrol içindir
        if(b==0 || b==2 || b==4 || b==6 || b==8) {
            System.out.println(sayi + " ÇİFT");
        } else {
            System.out.println(sayi + " TEK");
        }
    }
}
