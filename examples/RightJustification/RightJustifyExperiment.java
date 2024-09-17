import java.io.PrintWriter;

import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * Experiments with right justification.
 */
public class RightJustifyExperiment {
   public static void rightJustify(PrintWriter pen, Object obj, int width) {
      String str = obj.toString();
      String result;
      if (str.length() > width) {
        result = str.substring(0, width);
      } else {
        result = " ".repeat(width - str.length()) + str;
      }  
      pen.println(result);
    } // rightJustify

    public static void main(String[] arg) {
      PrintWriter pen = new PrintWriter(System.out, true);

      rightJustify(pen, "Hello", 60);
      rightJustify(pen, "A much longer string", 60);
      rightJustify(pen, new BigInteger("1326341234123125123"), 60);
      rightJustify(pen, new BigDecimal("12.11"), 60);
      rightJustify(pen, pen, 60);

      pen.close();
    } // main(String[])
} // class RightJustifyExperiment
