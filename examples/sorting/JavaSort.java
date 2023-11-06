import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using the built-in Java sorting routine.
 *
 * @author Samuel A. Rebelsky
 */

public class JavaSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new JavaSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  JavaSort() {
  } // JavaSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    Arrays.sort(values, order);
  } // sort(T[], Comparator<? super T>
} // class JavaSort
