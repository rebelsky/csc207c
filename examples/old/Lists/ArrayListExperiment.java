import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Attempts to understand iterators and lists in Java.
 */
public class ArrayListExperiment {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    ArrayList<String> arr = new ArrayList<String>();
    ListIterator<String> lit1 = arr.listIterator();

    lit1.add("a");
    lit1.add("b");
    lit1.add("c");

    pen.println("Original");
    pen.println(arr.toString());

    ListIterator<String> lit2 = arr.listIterator();
    lit2.next();
    lit2.next();
    lit2.set("x");
    pen.println("After setting the second element to x");
    pen.println(arr.toString());
   
    lit2.set("y");
    pen.println("After setting the second element to y");
    pen.println(arr.toString());

    lit2.remove();
    pen.println("After removing");
    pen.println(arr.toString());

    pen.close();
  } // main
} // class ArrayListExperiment
