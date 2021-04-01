
import java.util.*;

public class ListOrnek {

  public static void main(String[] args) {
    List<Integer> al = new ArrayList<>();
    /*
      List<String> ll = new LinkedList<>();
      List<Double> v = new Vector<>();
      List<String> s = new Stack<>();
     */
    al.add(15); al.add(22); al.add(34);
    System.out.println(al);
    al.remove(0);
    System.out.println(al);
    
    Stack<String> s = new Stack<>();
    s.push("BMW"); 
    s.push("Toyota"); 
    s.push("Jaguar");
    System.out.println(s);
    String enSon = s.peek();
    System.out.println(s);
    System.out.println(enSon);
    int sira = s.search("Jaguar");
    System.out.println("SIRA = " + sira);
  }
}
