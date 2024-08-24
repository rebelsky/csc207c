import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    TextBlock tb1 = new HFlip(new HFlip(new HFlip(new HFlip(new TextLine("a")))));
    TextBlock tb2 = new HFlip(new HFlip(new TextLine("a")));
    TextBlock tb3 = new TextLine("a");
    TextBlock tb4 = new HFlip(new HFlip(new HFlip(new HFlip(new TextLine("a")))));

    pen.println("tb1.eqv(tb2): " + tb1.eqv(tb2));
    pen.println("tb1.eqv(tb3): " + tb1.eqv(tb3));
    pen.println("tb1.eqv(tb4): " + tb1.eqv(tb4));

    pen.println("tb2.eqv(tb1): " + tb2.eqv(tb1)); // True b/c TextLine is dumb
    pen.println("tb3.eqv(tb1): " + tb3.eqv(tb1)); // True b/c TextLine is dumb
    pen.println("tb4.eqv(tb1): " + tb4.eqv(tb1)); // True

    pen.close();
  } // main

  public static void oldmain(String[] args) throws Exception {
  } // main(String[])

} // class TBExpt
