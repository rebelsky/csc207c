import java.io.PrintWriter;

public class SumThing {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    int sum = 0;
    for (int val : new int[] { 1, 2, 3, 4, 5}) {
      sum += val;
    } // for
    pen.println(sum);
    pen.close();
  } // main(String[]
} // class SumThing
