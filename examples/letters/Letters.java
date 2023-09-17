import java.io.PrintWriter;

public class Letters {
  public static boolean americanLowerCase(char ch) {
    return ((ch >= 'a') && (ch <= 'z'));
  }
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    pen.println("'a' is a lowercase letter: " + americanLowerCase('a'));
    pen.println("'q' is a lowercase letter: " + americanLowerCase('q'));
    pen.println("'2' is a lowercase letter: " + americanLowerCase('2'));
  } // main
} // class Letters
