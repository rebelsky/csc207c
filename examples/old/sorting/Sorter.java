import java.util.Comparator;

/**
 * Things that know how to sort homogeneous collections.
 */
public interface Sorter {
  /**
   * Sort an array in place.
   *
   * @param vals, an array to sort.
   * @param order, the order by which to sort the values.
   * @return
   *    The same array, now sorted.
   * @pre
   *    order can be applied to any two values in vals.
   * @pre
   *    VALS = vals.
   * @post
   *    vals is a permutation of VALS.
   * @post
   *    For all i, 0 < i < vals.length,
   *      order.compare(vals[i-1], vals[i]) <= 0
   */
  public <T> void sort(T[] values, Comparator<? super T> order);
} // interface Sorter
