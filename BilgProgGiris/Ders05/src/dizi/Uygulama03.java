package dizi;
public class Uygulama03 {
  public static void main(String[] args) {
    int zar[] = new int[6]; 
    for(int k=0; k<500; k++) {
      int rs = (int)(Math.random()*6); 
      zar[rs]++;
    }
    for(int z=0; z<zar.length; z++) {
      for(int y=1; y<=zar[z]; y++) {
        System.out.print("=");
      }
      System.out.println(" Zar "+ (z+1) + " = " + zar[z] + " defa geldi");
    }
  }  
}
