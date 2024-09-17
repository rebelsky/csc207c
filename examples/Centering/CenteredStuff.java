import java.io.PrintWriter;
import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * Demonstration of centering (a subtype polymorphism example).
 */
public class CenteredStuff {
  public static void printCentered(PrintWriter pen, Object thing, int width) {
    String thingString = thing.toString();
    pen.println(" ".repeat((width - thingString.length())/2) + thingString);
  } // printCentered(PrintWriter, Object, int)

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    printCentered(pen, "Hello World", 80);
    printCentered(pen, "A longer string than the previous one", 80);
    printCentered(pen, new BigInteger("12321541232112"), 80);
    printCentered(pen, new BigDecimal("42.11"), 80);
    pen.close();
  } // main(String[])
} // CenteredStuff
