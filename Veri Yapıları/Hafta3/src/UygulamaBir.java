import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class UygulamaBir {
  public static void main(String[] args) {
    // HashSet 
    HashSet<String> hSet = new HashSet<>();
    hSet.add("Ufuk"); hSet.add("Ali");
    hSet.add("Zeynep"); hSet.add("Ayşe");
    
    Iterator<String> ite = hSet.iterator();
    while(ite.hasNext()) {
      System.out.println("HasSet : " + ite.next());
    }
    // LinkedHashSet
    LinkedHashSet<String> lhs = new LinkedHashSet<>();
    lhs.add("Ufuk"); lhs.add("Ali"); 
    lhs.add("Zeynep"); lhs.add("Ayşe");
    System.out.println(lhs);
    // TreeSet
    TreeSet<String> ts = new TreeSet<>();
    ts.add("Ufuk"); ts.add("Ali");
    ts.add("Zeynep"); ts.add("Ayşe");
    System.out.println(ts);
  }
}
