package edu.grinnell.csc207;

/**
 * Some assorted utilities.
 */
public class Utils {
  /**
   * The scale factor used in converting Celsius to Fahrenheit.
   */
  private static final double C2F_FACTOR = 9.0 / 5.0;

  /**
   * The offset used in converting Fahrenheit to Celsius.
   */
  private static final int C2F_OFFSET = 32;

  /**
   * Convert Celsius to Fahrenheit.
   *
   * @param c
   *  The temperature in Celsius.
   * @return The temperature in Fahrenheit.
   */
  public static int c2f(int c) {
    return (int) (c * C2F_FACTOR) + C2F_OFFSET;
  } // c2f(int)
} // class Utils
