public class UygulamaBir {
  // kendisine gönderilen bir dizinin en büyüğünü bulan metot
  public static void EnBüyük(int[] dz) {
    int eb = 0;
    for(int k=0; k < dz.length; k++) {
      if(dz[k] > eb) {
        eb = dz[k];
      }
    }
    System.out.println("En Büyük = " + eb);
  }
  
  public static double Ortalama(int[] dz) {
    double toplam = 0;
    for(int k=0; k<dz.length; k++) {
      toplam += dz[k];
    }
    return toplam / dz.length;
  }
          
  public static void main(String[] args) {
    int maas[] = {1250,4500,6200,5400,7300,2900};
    System.out.println("Çalışan sayısı : " + maas.length);
    EnBüyük(maas);
    System.out.println("Ortalama Maaş = " + Ortalama(maas));
  }
}
