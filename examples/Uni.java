import java.io.PrintWriter;

/**
 * A quick experiment in converting hex strings to unicode.
 *
 * @author Samuel A. Rebelsky
 * @author Students of CSC-207 2024Fa
 */
public class Uni {
  /**
   * Convert a hex string to unicode.
   */
  public static String convert(String hex) {
    return new String(Character.toChars(Integer.valueOf(hex, 16)));
  } // convert

  /**
   * Read all of the hex strings on the command line and convert them to
   * unicode.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (String arg : args) {
      pen.print(convert(arg));
      pen.print(" ");
      pen.flush();
    } // for
    pen.println();
    pen.close();
  } // main(String[])
} // class Uni
