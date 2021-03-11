public class Uygulama03 {
    public static void main(String[] args) {
        System.out.println("1-100 arasında basamakları aynı olan sayılar");
        for(int k=11; k<=100; k+=11) {
            System.out.print(" " + k);
        }
        System.out.println("");
        System.out.println("1-100 arasında basamakları farklı olan sayılar");
        for(int k=10; k<=100; k++) {
           int b = k % 10; // birler basamağı
           int o = (k - b) / 10; // onlar basamağı
           if(b != o) {
               System.out.print(" " + k);
           }
        }
    }
}
