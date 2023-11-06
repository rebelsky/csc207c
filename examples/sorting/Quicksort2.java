import java.util.Arrays;
import java.util.Comparator;

/**
 * An implementation of Quicksort.
 *
 * @author Samuel A. Rebelsky.
 */
public class Quicksort2 implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * It's a singleton class!
   */
  public static Sorter SORTER = new Quicksort2();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Enforce singleton class (outside of this package).
   */
  Quicksort2() {
  } // Quicksort2()

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  public <T> void sort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length);
  } // sort

  // +----------------+----------------------------------------------
  // | Helper methods |
  // +----------------+

  /**
   * Determine if values at three locs are in increasing order.
   */
  private static <T> boolean inOrder(T[] vals, Comparator<? super T> order, int i, int j, int k) {
    return (order.compare(vals[i],vals[j]) <= 0) && 
      (order.compare(vals[j],vals[k]) <= 0);
  } // inOrder(T[], Comparator, int, int, int)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  private static <T> int partition(T[] vals, Comparator<? super T> order, int lb, int ub) {
    // Special case: Empty subarray
    if (lb >= ub) {
      return lb;
    } // special case

    // Identify the pivot
    int mi = lb + (ub-lb)/2;
    int pivotLoc;
    if (inOrder(vals, order, lb, mi, ub-1) || inOrder(vals, order, ub-1, mi, lb)) {
      pivotLoc = mi;
    } else if (inOrder(vals, order, mi, lb, ub-1) || inOrder(vals, order, ub-1, lb, mi)) {
      pivotLoc = lb;
    } else {
      pivotLoc = ub-1;
    }
    T pivot = vals[pivotLoc];

    // Move the pivot to the front of the array.
    swap(vals, lb, pivotLoc);

    // Set the bounds
    int small = lb+1;
    int large = ub;

    // Do the main work
    while (small < large) {
      // Advance small as appropriate
      if (order.compare(vals[small], pivot) <= 0) {
        small++;
      } 
      // Retreat large as appropriate
      else if (order.compare(vals[large-1], pivot) > 0) {
        large--;
      }
      // If neither moves, swap and move pointers
      else {
        swap(vals, small++, --large);
      }
    } // while

    // Move the pivot to the correct location
    pivotLoc = small - 1;
    swap(vals, lb, pivotLoc);

    // And we're done
    return pivotLoc;
  } // partition

  /**
   * Swap two elements in an array.
   */
  public static <T> void swap(T[] vals, int i, int j) {
    T tmp = vals[i];
    vals[i] = vals[j];
    vals[j] = tmp;
  } // swap(T[], int, int)

  /**
   * Sort the values in indices [lb..ub) of values using order to compare 
   * values.
   */
  private static <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    // Subarrays of one element or fewer are sorted.
    if (lb >= ub-1) {
      return;
    } else {
      int mid = partition(values, order, lb, ub);
      quicksort(values, order, lb, mid);
      quicksort(values, order, mid+1, ub);
    } // if/else
  } // quicksort(T[], Comparator, int, int)

} // class Quicksort2
