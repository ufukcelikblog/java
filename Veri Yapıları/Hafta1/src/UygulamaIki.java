import java.util.Arrays;
public class UygulamaIki {
  public static void main(String[] args) {
    int[] not = {45,63,57,92,28,60,70,80,100,45,27};
    int[] kNot = new int[not.length];
    for(int x=0; x<not.length; x++) {
      kNot[x] = not[x];
    }
    int[] kopNot = not;
    int[] not2 = new int[5];
    System.arraycopy(not, 3, not2, 0, 5);
    for(int x=0; x<not2.length; x++) {
      System.out.print(" - " + not2[x]);
    }
    System.out.println("");
    Arrays.sort(not);
    for(int x=0; x<not.length; x++)
      System.out.print(" - " + not[x]);
  }
}
