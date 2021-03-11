package siralama;

/**
 * Seçimli Sıralama
 * @author ucelik
 */
public class SelectionSort {
  public static void main(String[] args) {
    int sayilar[] = {7,12,8,9};
    System.out.println("X\tY\tminID\tsayi[X]\tsayi[Y]\tDizi");
    for(int x=0; x<sayilar.length-1; x++) {
      int minID = x;
      for(int y=x+1; y<sayilar.length; y++) {
        System.out.print(x+"\t"+y+"\t"+minID+"\t"+sayilar[x]+"\t"+sayilar[y]+"\t");
        if(sayilar[y] < sayilar[minID]) {
          minID = y;
        }
        for(int k : sayilar) System.out.print(k+",");
        System.out.println("");
      }
      int gecici = sayilar[minID];
      sayilar[minID] = sayilar[x];
      sayilar[x] = gecici;
    }
    
    for(int k : sayilar) {
      System.out.print(k + ",");
    }
  }
}
