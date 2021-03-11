
package siralama;

/**
 * Kabarcık Sıralama Algoritması
 * @author ucelik
 */
public class BubbleSort {
  public static void main(String[] args) {
    int sayi[] = {13,12,6,10,9,6,4,7};
    int uzunluk = sayi.length;
    System.out.println("X\tY\tsayi[X]\tsayi[Y]\tDizi");
    for(int x=0; x<uzunluk-1; x++) {
      for(int y=x+1; y<uzunluk; y++) {
        if(sayi[x] > sayi[y]) {
          int gecici = sayi[x];
          sayi[x] = sayi[y];
          sayi[y] = gecici;
        }
        System.out.print(x + "\t" + y + "\t" + sayi[x]+"\t"+sayi[y]+"\t");
        for(int k=0; k<uzunluk; k++) System.out.print(sayi[k] + ","); 
        System.out.println("");        
      }
    }
    for(int k=0; k<uzunluk; k++) {
      System.out.print(sayi[k] + ", ");
    }
  }          
}
