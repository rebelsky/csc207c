import java.io.PrintWriter;

public class HashCodes {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (String str : args) {
      pen.println(str + ": " + (str.hashCode() % 41));
    } // for
    pen.close();
  } // main(String[])
} // class HashCodes
