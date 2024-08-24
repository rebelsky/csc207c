import java.util.Comparator;
import java.util.Arrays;

/**
 * ChatGPT's version of TimSort.  Updated by SamR.
 *
 * I gave ChatGPT the prompt 
 *   please write me a generic TimSort in Java * with comments
 *
 * I learned that 
 *
 * * The code that ChatGPT was trainined on made some strange design
 *   decisions (e.g., why does our sorter have an `arr` class; why did
 *   the original extend comparable?); 
 * * Naming is strange (what's "binaryInsertionSort"?)
 * * The documentation sucks (what's "the specified range"; does it 
 *    include left and right?);
 * * The supplid code ignores key aspects of TimSort, such as not 
 *   re-allocating * the merge arrays. 
 * * It includes a main method (why?).
 * * It's slower than my Quicksort.
 * * It optimizes things that probably aren't worth optimizing, such
 *   as by using bitwise operators in `minRunLength`.
 *
 * Perhaps I need to improve my prompts to ChatGPT. 
 */
public class ChatTimSort implements Sorter {

  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  // The minimum size of a chunk before performing a binary insertion sort
  private static final int MIN_MERGE = 32;

  // +-------------+-------------------------------------------------
  // | Class Field |
  // +-------------+

  public static Sorter SORTER = new ChatTimSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  // Constructor
  ChatTimSort() { }

  // Perform binary insertion sort on the specified range of the array
  private <T> void binaryInsertionSort(T[] arr, Comparator<? super T> order,
      int left, int right) {
    for (int i = left + 1; i <= right; i++) {
      T key = arr[i];
      int j = Math.abs(Arrays.binarySearch(arr, left, i, key, order) + 1);
      System.arraycopy(arr, j, arr, j + 1, i - j);
      arr[j] = key;
    }
  }

  // Merge two adjacent runs
  private <T> void mergeRuns(T[] arr, Comparator<? super T> order) {
    int n = arr.length;
    int minRun = minRunLength(n);

    for (int i = 0; i < n; i += minRun) {
      int end = Math.min(i + minRun - 1, n - 1);
      binaryInsertionSort(arr, order, i, end);
    }

    for (int size = minRun; size < n; size = 2 * size) {
      for (int left = 0; left < n; left += 2 * size) {
        int mid = left + size - 1;
        // SR: I'd love an explanation of the nexst calculation
        int right = Math.min((left + 2 * size - 1), (n-1));
        if (mid < right) {
          merge(arr, order, left, mid, right);
        }
      }
    }
  }

  // Merge two adjacent runs
  private <T> void merge(T[] arr, Comparator<? super T> order,
       int left, int mid, int right) {
    int leftSize = mid - left + 1;
    int rightSize = right - mid;

    T[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
    T[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

    int i = 0, j = 0, k = left;

    while (i < leftSize && j < rightSize) {
      if (order.compare(leftArr[i],rightArr[j]) <= 0) {
        arr[k++] = leftArr[i++];
      } else {
        arr[k++] = rightArr[j++];
      }
    }

    while (i < leftSize) {
      arr[k++] = leftArr[i++];
    }

    while (j < rightSize) {
      arr[k++] = rightArr[j++];
    }
  }

  // Calculate the minimum run length for an array of size n
  private int minRunLength(int n) {
    int r = 0;
    while (n >= MIN_MERGE) {
      r |= (n & 1);
      n >>= 1;
    }
    return n + r;
  }

  // Public method to perform TimSort on the array
  public <T> void sort(T[] values, Comparator<? super T> order) {
    mergeRuns(values, order);
  }

} // class ChatTimSort
