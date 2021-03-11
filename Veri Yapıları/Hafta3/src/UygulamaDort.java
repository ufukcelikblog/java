
import java.util.HashMap;
import java.util.LinkedHashMap;

public class UygulamaDort {
  // HashMap
  public static void main(String[] args) {
    // <key,value> = <anahtar, değer>
    HashMap<Integer,String> renk = new HashMap<>(3,0.5f);
    renk.put(25, "Siyah"); renk.put(5, "Mavi");
    renk.put(18, "Sarı"); renk.put(41, "Yeşil");
    System.out.println(renk);
    System.out.println(renk.get(18));
    
    LinkedHashMap<Character,Integer> lhm = new LinkedHashMap<>();
    for(int k=65; k<=90; k++) {
      lhm.put((char)k, k);
      System.out.println(lhm);
    }
    
  }
}
