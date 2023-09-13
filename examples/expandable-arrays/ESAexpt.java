import java.io.PrintWriter;
import grinnell.csc207.fa2023.ExpandableStringArray;

public class ESAexpt {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String def = "IT'S NOT MY FAULT, IT'S NOT YOUR FAULT, IT'S JUST DEFAULT";
    ExpandableStringArray esa = new ExpandableStringArray(def);

    // Check that lots of values are set to the default value
    for (int i = 0; i < 30; i++) {
      if (! def.equals(esa.get(i))) {
        pen.println("Default value not stored at position " + i);
      } // if
    } // for

    // A simple set experiment
    pen.println("Setting the value at position 1 to 'one'");
    esa.set(1, "one");
    pen.println("get(1): " + esa.get(1));
    pen.println("size(): " + esa.size());

    // Get a value outside the size
    pen.println("\nGetting a value outside the size");
    pen.println("get(3): " + esa.get(3));

    // Get a value beyond the length
    pen.println("\nGetting a value beyond the length");
    pen.println("get(100): " + esa.get(100));

    // Force expansion
    pen.println("\nForcing expansion");
    esa.set(18, "expand, dammit");
    pen.println("get(18): " + esa.get(18));
    pen.println("size(): " + esa.size());

    // Negative indices
    pen.println("\nGetting negative indices");
    pen.println("get(-8): " + esa.get(-8));
    if (false) {
      pen.println("\nSetting negative indices");
      esa.set(-8, "NEGATIVE");
      pen.println("get(-8): " + esa.get(-8));
    } // if

    // Let's add a few things to the end
    pen.println("\nAdding to the end");
    esa.addToEnd("eh");
    esa.addToEnd("bee");
    esa.addToEnd("see");
    pen.println("size(): " + esa.size());
    pen.println("get(19): " + esa.get(19));
    pen.println("get(20): " + esa.get(20));
    pen.println("get(21): " + esa.get(21));
    pen.println("get(22): " + esa.get(22));
    pen.println("get(23): " + esa.get(23));
    pen.println("get(24): " + esa.get(24));

    // Make sure that setting a smaller index doesn't change the size.
    pen.println("\nSetting index 5");
    esa.set(5, "five");
    pen.println("get(5): " + esa.get(5));
    pen.println("size(): " + esa.size());

  } // main (String[])
} // class ESAexpt
