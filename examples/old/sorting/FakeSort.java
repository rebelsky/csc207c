import java.util.Comparator;

/**
 * Something that fails to sort.  Intended primarily to allow us to wath
 * tests fail.
 *
 * @author Samuel A. Rebelsky
 */

public class FakeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new FakeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  FakeSort() {
  } // FakeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // Cross your fingers and hope it's already sorted.
  } // sort(T[], Comparator<? super T>
} // class FakeSort
