
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetOrnek {
  public static void main(String[] args) {
    HashSet<String> hs = new HashSet<String>();
    hs.add("Ahmet");
    hs.add("Veli");
    hs.add("Zeynep");
    Iterator<String> itr = hs.iterator();
    while(itr.hasNext()) {
      System.out.println(itr.next());
    }
    
    Set<String> lhs = new LinkedHashSet<>();
    lhs.add("Ahmet");
    lhs.add("Veli");
    lhs.add("Zeynep");
    
    Set<String> ts = new TreeSet<>();
    ts.add("Ahmet");
    ts.add("Veli");
    ts.add("Zeynep");
    itr = ts.iterator();
    while(itr.hasNext()) {
      System.out.println(itr.next());
    }
    hs.remove("Veli");
    System.out.println("HashSet sayısı: " + hs.size());
    
  }
}
