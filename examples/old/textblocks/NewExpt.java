import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class NewExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    MutableLine block = new MutableLine("Hello");

    // Have fun boxing
    TextBlock box = new BoxedBlock(new VComposition(block, 
                                                    new BoxedBlock(block)));

    // Print out the block
    TBUtils.print(pen, box);

    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class NewExpt
