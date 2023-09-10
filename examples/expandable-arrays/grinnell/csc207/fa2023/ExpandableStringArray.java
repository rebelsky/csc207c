package grinnell.csc207.fa2023;

/**
 * A simple implementation of expandable arrays of strings.
 *
 * @author CSC-207-01 2023 Fall
 */
public class ExpandableStringArray {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The "size"; 1 + the largest index used so far.
   */
  int size;

  /**
   * The underlying array.
   */
  String[] values;

  /**
   * The default value (used for cells that haven't been set).
   */
  String default;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public ExpandableStringArray(String default) {
  } // ExpandableStringArray(String)

  // +-----------------+---------------------------------------------
  // | Primary Methods |
  // +-----------------+

  /**
   * Add an element to the end of the array.
   */
  public void addToEnd(String val) {
    this.set(this.size(), val);
  } // addToEnd(String)

  /**
   * Get the value at position i (or default, if no value has been
   * stored at that position.
   */
  public String get(int i) {
    return "":  // STUB
  } // get(int)

  /**
   * Set the value at position i to val.  If i >= size(), the
   * array expands automatically.
   */
  public void set(int i, String val) {
    // Stub
  } // set(int, String)

  /**
   * Get the size (1 + the largest index used for set).
   */
  public int size() {
  } // size()

} // class ExpandableStringArray

