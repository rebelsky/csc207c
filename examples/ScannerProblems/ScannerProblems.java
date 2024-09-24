import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Some fun with scanners.
 */
public class ScannerProblems {
  /**
   * Process a string.
   *
   * @param str
   *   The string to process.
   *
   * @return the processed string
   */
  public static String process(String str) {
    return "[" + str + "]";
  } // process(String)

  /**
   * A typical input loop.
   */
  public static void typicalLoop() throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner scanner = new Scanner(System.in);

    try {
      while (true) {
        pen.print("> ");
        pen.flush();
        String response = scanner.nextLine();
        pen.println(process(response));
      } // while
    } catch (Exception e) { 
      // We're done
    } // try/catch

    scanner.close();
    pen.close();
  } // typicalLoop()

  /**
   * Our revised input loop.
   */
  public static void revisedLoop() throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextLine()) {
      pen.print("> ");
      pen.flush();
      String response = scanner.nextLine();
      pen.println(process(response));
    } // while

    scanner.close();
    pen.close();
  } // revisedLoop

  /**
   * Another revised loop.
   */
  public static void yaRevisedLoop() {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner scanner = new Scanner(System.in);

    do {
      pen.print("> ");
      pen.flush();
      String response = scanner.nextLine();
      pen.println(process(response));
    } while (scanner.hasNextLine());

    scanner.close();
    pen.close();
  } // yaRevisedLoop()

  /**
   * Our revised input loop.
   */
  public static void rerevisedLoop() throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner scanner = new Scanner(System.in);

    pen.print("> ");
    pen.flush();
    while (scanner.hasNextLine()) {
      String response = scanner.nextLine();
      pen.println(process(response));
      pen.print("> ");
      pen.flush();
    } // while

    scanner.close();
    pen.close();
  } // rerevisedLoop

  /**
   * Do all the work.
   *
   * @param args
   *   Command-line arguments (ignored).
   */
  public static void main(String[] args) throws Exception {
    yaRevisedLoop();
  } // main(String[])
} // class ScannerProblems
