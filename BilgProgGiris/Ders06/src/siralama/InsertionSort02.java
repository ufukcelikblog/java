package siralama;

import java.util.Arrays;

/**
 *
 * @author ucelik
 */
public class InsertionSort02 {
  public static void main(String[] args) {
    int sayi[] = {13, 12, 6, 10, 9, 6, 4, 7};
    System.out.println(Arrays.toString(sayi));
    // Arrays.sort(sayi);
    // System.out.println(Arrays.toString(sayi));
    
    for(int x=1; x<sayi.length; x++) {
      int deger = sayi[x];
      int y = x - 1;
      for( ; y>=0; y--) {
        if(deger > sayi[y]) {
          sayi[y+1] = sayi[y];
        } else {
          break;
        }
      }
      sayi[y+1] = deger;
    }
    System.out.println(Arrays.toString(sayi));
  }
}
