import java.io.PrintWriter;

/**
 * A simple experiment using fractions.
 *
 * @author Samuel A. Rebelsky.
 * @author YOUR NAME HERE
 */
public class FractionExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    Fraction f1;
    f1 = new Fraction(3, 10);
    Fraction f2;
    f2 = new Fraction(2, 5);
    pen.println("First fraction: " + f1);
    pen.println("Second fraction: " + f2);
    pen.println("Sum: " + (f1.add(f2)));
  } // main(String[])
} // class FractionExpt
