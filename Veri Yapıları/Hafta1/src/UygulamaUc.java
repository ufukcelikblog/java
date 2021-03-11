public class UygulamaUc {
  public static void main(String[] args) {
    Object[] dizi = new Object[3];
    dizi[0] = "Ali CAN"; // String
    dizi[1] = true;      // boolean
    dizi[2] = 12.56;     // double
    for(int k=0; k<dizi.length; k++) {
      System.out.println(k + ". eleman = " + dizi[k]);
    }
  }
}
