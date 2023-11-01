import java.util.ArrayList;
import java.util.ListIterator;

/**
 * A quick experiment with iterators.
 */
public class IteratorExperiment {
  public static void main(String[] args) {
    ArrayList<String> al = new ArrayList<String>();
    ListIterator<String> it = al.listIterator();

    it.add("A");
    it.add("B");
    it.add("C");

    System.err.println(al.toString());

    ListIterator<String> it1 = al.listIterator();
    ListIterator<String> it2 = al.listIterator();
    it1.next();
    it2.next();
    it1.add("D");

    System.err.println("Experiment one");
    System.err.println(al.toString());
    System.err.println(it2.next());

  } // main(String[])
} // class IteratorExperiment
