package edu.grinnell.csc207;

import java.io.PrintWriter;

/**
 * A sample class.
 */
public class Sample {
  /**
   * Do something boring, such as printing a message.
   *
   * @param args
   *   The array of command-line arguments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("Hello Sample");
    pen.close();
  } // main(String[])
} // class Sample
