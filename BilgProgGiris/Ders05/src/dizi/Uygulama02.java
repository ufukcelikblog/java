package dizi;

public class Uygulama02 {
  public static void main(String[] args) {
    int sayi[] = new int[100];
    for(int k=0; k<sayi.length; k++) {
      sayi[k] = (int)(Math.random()*100)+1;
    }
    for(int k=0; k<sayi.length; k++) {
      System.out.println(k + ". eleman: " + sayi[k]);
    }
  }  
}
