import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class UygulamaIki {
  public static void main(String[] args) {
    List<String> cicekList = new ArrayList<>();
    cicekList.add("Gül"); cicekList.add("Menekşe");
    cicekList.add("Papatya"); cicekList.add("Lale");
    System.out.println(cicekList);
    cicekList.remove(0);
    System.out.println(cicekList);
    System.out.println("1. Çiçek = " + cicekList.get(0));
    
    List<String> liste2 = new ArrayList<>(cicekList);
    liste2.add("Orkide"); liste2.add(" Nilüfer");
    System.out.println(liste2);
    liste2.add(2, "Zambak");
    System.out.println(liste2);
    ListIterator<String> li = liste2.listIterator();
    while(li.hasNext()) {
      System.out.println("List: " + li.next());
    }    
  }
}
