package dizi;

public class Uygulama04 {
  public static void main(String[] args) {
    int sayi[] = {2,5,6,8,4,7};
    int uzunluk = sayi.length;
    int enBuyuk = sayi[0]; // ilk elemanı en büyük kabül ediyoruz
    int enKucuk = sayi[0]; // ilk elemanı en küçük kabül ediyoruz
    for(int k=1; k<uzunluk; k++) {
      if(sayi[k] > enBuyuk) enBuyuk = sayi[k];
      if(sayi[k] < enKucuk) enKucuk = sayi[k];
    }
    System.out.println("En Büyük = " + enBuyuk);
    System.out.println("En Küçük = " + enKucuk);
  }
}
