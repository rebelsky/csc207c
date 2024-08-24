/**
 * Fun experiments with text blocks and equivalency.
 */
public class HFlip implements TextBlock {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The block we're flipping.
   */
  TextBlock flipme;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public HFlip(TextBlock tb) {
    this.flipme = tb;
  } // HFlip(TextBlock)

  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception {
    return "";
  } // row(int i)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return 1;
  } // height();

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return 0;
  } // width()

  /**
   * Determine if we are structurally equivalent to another block.
   */
  public boolean eqv(TextBlock other) {
    return (other instanceof HFlip) &&
           (this.flipme.eqv(((HFlip) other).flipme));
  } // eqv(TextBlock)
} // class HFlip
