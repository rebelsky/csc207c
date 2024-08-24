import java.io.PrintWriter;

/**
 * A simple illustration of Java's for-each loop with arrays.
 */
public class ForEach {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String[] names = new String[] { "Jane", "Jack", "Julie", "John" };
    for (String name : names) {
      pen.println("Hello, " + name);
    } // for
    pen.close();
  } // main(String[])
} // class ForEach
