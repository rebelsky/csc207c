package grinnell.csc207.fa2023;

/**
 * A simple implementation of expandable arrays of strings.
 *
 * @author CSC-207-01 2023 Fall
 */
public class ExpandableStringArray {
  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  private static final int INITIAL_ARRAY_SIZE = 16;

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
  String defaultValue;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public ExpandableStringArray(String defaultValue) {
    this.values = new String[INITIAL_ARRAY_SIZE];
    this.defaultValue = defaultValue;
    this.size = 0;
    for (int i = 0; i < this.values.length; i++) {
      this.values[i] = defaultValue;
    } // for
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
   * Get the value at position i (or defaultValue, if no value has been
   * stored at that position.
   */
  public String get(int i) {
    if ((i < 0) || (i >= this.values.length)) {
      return this.defaultValue;
    } else {
      return this.values[i];
    } // if ... else
  } // get(int)

  /**
   * Set the value at position i to val.  If i >= size(), the
   * array expands automatically.
   */
  public void set(int i, String val) {
    // If the index is too large
    if (i >= this.values.length) {
      // Build a new array and copy it over
      String[] newvalues = new String[i+1];
      for (int j = 0; j < this.values.length; j++) {
        newvalues[j] = this.values[j];
      } // for
      for (int j = this.values.length; j < i; j++) {
        newvalues[j] = this.defaultValue;
      } // for
      this.values = newvalues;
    } // if
    this.values[i] = val;
    this.size = Math.max(this.size, i+1);
  } // set(int, String)

  /**
   * Get the size (1 + the largest index used for set).
   */
  public int size() {
    return this.size;
  } // size()

} // class ExpandableStringArray

