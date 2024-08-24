import java.io.PrintWriter;

/**
 * A quick hack to explore some limits in Java.
 */
public class Limits {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
    pen.println("Long.MAX_VALUE:    " + Long.MAX_VALUE);
    pen.close();
  }
} // class Limits
