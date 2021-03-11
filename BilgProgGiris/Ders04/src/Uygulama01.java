public class Uygulama01 {
    public static void main(String[] args) {
        for(int k=1; k<10; k++) {
            System.out.print("- " + k + " ");
        }
        System.out.println("");
        int m=1;
        for(; m<=10; m+=2) {
            System.out.print("- " + m + " ");
        }
        System.out.println("");
        for(int satir=1; satir<=10; satir++) {
            for(int yildiz=1; yildiz<=satir; yildiz++) {
                System.out.print(" *");
            }   
            System.out.println("");
        }   
    }
}
