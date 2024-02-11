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
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    MutableLine block = new MutableLine("Hello");

    TextBlock boxed = new BoxedBlock(block);
    TextBlock doublyboxed = new BoxedBlock(boxed);

    TextBlock result = new VComposition(boxed, doublyboxed);

    // Print out the block
    TBUtils.print(pen, result);

    // Change the value of block.
    block.set("goodbye");
    TBUtils.print(pen, result);

    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
