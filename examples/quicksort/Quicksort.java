import java.util.Arrays;
import java.util.Comparator;

/**
 * Simple experiments with Quicksort.
 *
 * @Samuel A. Rebelsky.
 */
public class Quicksort {

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

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
    int mid = lb + (ub - lb)/2;
    return mid;
  } // partition

  /**
   * Swap two elements in an array.
   */
  private static <T> void swap(T[] vals, int i, int j) {
    T tmp = vals[i];
    vals[i] = vals[j];
    vals[j] = tmp;
  } // swap(T[], int, int)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run some experiments.
   */
  public static void main(String[] args) {
    Integer[][] integerInputs = new Integer[][] { 
      // An example from the reading
      new Integer[] { 3, 9, 2, 8, 6, 4, 1, 7, 5 },
      // Some repetition
      new Integer[] { 1, 2, 3, 1, 2, 3, 1, 2, 3 },
      // Some other repetition
      new Integer[] { 3, 2, 1, 3, 2, 1, 3, 2, 1 },
      // The empty array
      new Integer[] { },
      // A singleton array
      new Integer[] { 1 },
      // Values in order
      new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
      // Values in reverse order
      new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 },
      // Something in between
      new Integer[] { 1, 3, 5, 7, 9, 8, 6, 4, 2 }
    };
    Comparator<Integer> compareInts = (x,y) -> x.compareTo(y);

    for (int i = 0; i < integerInputs.length; i++) {
      Integer[] vals = integerInputs[i];
      partitionExperiment(Arrays.copyOf(vals, vals.length), compareInts);
      sortExperiment(Arrays.copyOf(vals, vals.length), compareInts);
    } // for
  } // main(String[])

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+

  /**
   * A partition experiment.
   */
  public static <T> void partitionExperiment(T[] vals, Comparator<? super T> order) {
    System.err.println("Partitioning: " + Arrays.toString(vals));
    int pivotLoc = Quicksort.partition(vals, order, 0, vals.length);
    System.err.println("Partitioned:  " + Arrays.toString(vals));
    if (vals.length > 0) {
      System.err.println("  Pivot is " + vals[pivotLoc] + " at position " + pivotLoc);
    }
    System.err.println();
  } // partitionExperiment

  /**
   * A sort experiment.
   */
  public static <T> void sortExperiment(T[] vals, Comparator<? super T> order) {
    System.err.println("Sorting: " + Arrays.toString(vals));
    Quicksort.quicksort(vals, order, 0, vals.length);
    System.err.println("Sorted:  " + Arrays.toString(vals));
    System.err.println();
  } // sortExperiment

  // +-----------+---------------------------------------------------
  // | Quicksort |
  // +-----------+

  /**
   * Sort the values in indices [lb..ub) of values using order to compare values.
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

  public static <T> void quicksort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length);
  } // quicksort

} // class Quicksort
