public class UygulamaBir {
  public static void main(String[] args) {
    Object[][] personel = {
      {"Ahmet KARA", 40, 4800, "İmalat"},
      {"Ayşe CAN", 28, 5200.78, "İK"},
      {"Fatma GÜL", 18, 6200, "Finans"},
      {"Mehmet ÇELİK", 38, 3200.56, "İmalat"},
      {"Veli KAÇAR", 26, 7000, "Finans"},
      {"Ali CAN", 42, 6952.94, "Finans"}
    };
    Object[] departman = new Object[personel.length];
    for(int k=0; k<personel.length; k++) {
      departman[k] = personel[k][3];
    }
    Object[] bosDizi = new Object[departman.length];
    for(int x=0; x<departman.length; x++) {
      boolean depBosDizideVar = false;
      for(int y=0; y<bosDizi.length; y++) {
        if(departman[x].equals(bosDizi[y])) {
          depBosDizideVar = true;          
        }
      } // bosDizi döngüsü bitti
      if(depBosDizideVar == false) {
        for(int k=0; k<bosDizi.length; k++) {
          if(bosDizi[k] == null) {
            bosDizi[k] = departman[x];
            break;
          }
        }
      }
    } // departman döngüsü bitti
    
    int departmanSayisi = 0;
    for(int z=0; z<bosDizi.length; z++) {
      if(bosDizi[z] != null) {
        departmanSayisi++;
        System.out.println(z + ". departman = " + bosDizi[z]);
      }
    }
    System.out.println("Departman Sayısı = " + departmanSayisi);
    
    // DepartmanBilgi Adı,Eleman,MinMaas,MakMaas,OrtMaas
    Object[][] deptBilgi = new Object[departmanSayisi][5];
      
    for(int k=0; k<deptBilgi.length; k++) {
      deptBilgi[k][0] = bosDizi[k];
      int deptPerSayi = 0;
      double deptMinMaas = 100000;
      double deptMakMaas = 0;
      double deptTopMaas = 0;
      for(int d=0; d<departman.length; d++) {
        if(deptBilgi[k][0].equals(departman[d])) {
          deptPerSayi++;
          deptTopMaas += Double.parseDouble(personel[d][2].toString());
          if(Double.parseDouble(personel[d][2].toString()) < deptMinMaas) {
            deptMinMaas = Double.parseDouble(personel[d][2].toString());
          }
          if(Double.parseDouble(personel[d][2].toString()) > deptMakMaas) {
            deptMakMaas = Double.parseDouble(personel[d][2].toString());
          }          
        }
      }
      deptBilgi[k][1] = deptPerSayi;
      deptBilgi[k][2] = deptMinMaas;
      deptBilgi[k][3] = deptMakMaas;
      deptBilgi[k][4] = deptTopMaas / deptPerSayi;
    }
    System.out.println("Bölüm\tEleman\tMinMaas\tMakMaas\tOrtMaas");
    for(int x=0; x<deptBilgi.length; x++) {
      for(int y=0; y<deptBilgi[x].length; y++) {
        System.out.print(deptBilgi[x][y] + "\t");
      }
      System.out.println("");
    }
  }
}
