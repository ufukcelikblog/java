// Fibonacci serisi
// 0 1 1 2 3 5 8 13 21 34 55 89 
public class Uygulama06 {
    public static void main(String[] args) {
        long s1 = 1, s2 = 1;
        System.out.print(s1 + " " + s2);
        for(long k=2; k<50; k++) {
            long yeni = s1 + s2;
            System.out.print(" " + yeni);
            s1 = s2;
            s2 = yeni;
        }
    }
}
