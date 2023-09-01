import java.io.PrintWriter;

/**
 * Add all the fractions provided on the command line
 *
 * @author Samuel A. Rebelsky.
 * @author YOUR NAME HERE
 */
public class FractionSum {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    Fraction sum = new Fraction(0,1);   // Zero
    for (String arg : args) {
      sum = sum.add(new Fraction(arg));
    } // for
    pen.println(sum);
  } // main(String[])
} // class FractionExpt
