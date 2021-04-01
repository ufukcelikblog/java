import java.util.*;

public class QueueOrnek {

  public static void main(String[] args) {
    Queue<String> q1 = new LinkedList<>();
    Queue<Integer> q2 = new PriorityQueue<>();
    
    ArrayDeque q = new ArrayDeque();
    q.add("Ali"); q.add(34); 
    System.out.println(q);
    q.addFirst("Java");
    q.addLast("PHP");
    System.out.println(q);
    
    System.out.println(q.poll());
    System.out.println(q);
    System.out.println(q.contains(34));
    
    for(Object eleman : q) {
      System.out.println(eleman);
    }
  }

}
