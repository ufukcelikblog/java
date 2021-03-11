import java.util.LinkedList;
import java.util.Queue;

public class UygulamaUc {
  public static void main(String[] args) {
    Queue<Integer> kuyruk = new LinkedList<>();
    kuyruk.add(25); kuyruk.add(8); 
    kuyruk.add(2); kuyruk.add(19);
    // Kuyruk bpoş değilse
    while(!kuyruk.isEmpty()) {
      System.out.println("Sıradaki eleman: " + kuyruk.peek());
      System.out.println("Alınan eleman: " + kuyruk.poll());      
    }
  }
}
