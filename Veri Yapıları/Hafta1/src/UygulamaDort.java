public class UygulamaDort {
  public static void main(String[] args) {
    Object[][] personel = {
      {"Ahmet KARA", 40, 4800, "İmalat"},
      {"Ayşe CAN", 28, 5200.78, "İnsan Kaynakları"},
      {"Fatma GÜL", 18, 6200, "Muhasebe"},
      {"Mehmet ÇELİK", 38, 3200.56, "İmalat"},
      {"Veli KAÇAR", 26, 7000, "Muhasebe"},
      {"Ali CAN", 42, 6952.94, "Muhasebe"}
    };
    System.out.println("Çalışan sayısı : " + personel.length);
    System.out.println("Nitelik Sayısı : " + personel[0].length);
    int perMuhasebe = 0;
    for(int k=0; k<personel.length; k++) {
      System.out.println(personel[k][3]);
      if(personel[k][3].equals("Muhasebe")) perMuhasebe++;
    }
    System.out.println("Muhasebe Çalışanları Sayısı : " + perMuhasebe);
  }
}
