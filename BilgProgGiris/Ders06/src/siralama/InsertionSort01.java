package siralama;

/**
 * Yerleştir Sıralama Algoritması
 * @author ucelik
 */
public class InsertionSort01 {
  public static void main(String[] args) {
    int sayi[] = {13, 12, 6, 10, 9, 6, 4, 7};
    int uzunluk = sayi.length;
    for(int x=1; x<uzunluk; ++x) {
      int deger = sayi[x];
      int y = x - 1;
      while(y>=0 && sayi[y] > deger) {
        sayi[y+1] = sayi[y];
        y = y - 1;
      }
      sayi[y+1] = deger;
    }
    for(int k : sayi) System.out.print(k+","); 
    
    
  }
}
