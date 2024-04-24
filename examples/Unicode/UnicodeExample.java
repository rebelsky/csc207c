public class UnicodeExample {
  public static void main(String[] args) {
    for (String str : args) {
      int i = Integer.parseInt(str,16);
      System.err.println(Character.toChars(i));
    } // for
  } // main(String[])
} // class UnicodeExample
