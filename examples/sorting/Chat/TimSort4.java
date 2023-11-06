import java.util.Comparator;

/**
 * This class implements TimSort algorithm with a Comparator.
 * TimSort is a hybrid sorting algorithm derived from merge sort and insertion sort.
 * It is designed to perform well on many kinds of real-world data.
 *
 * @param <T> the type of elements to be sorted
 */
public class TimSort<T> {

    private static final int MIN_MERGE = 32;

    private final Comparator<? super T> comparator;
    private final T[] arr;
    private final Object[] leftArr;
    private final Object[] rightArr;

    /**
     * Constructs a TimSort object with the specified array and Comparator.
     *
     * @param arr        the array to be sorted
     * @param comparator the Comparator used to compare elements
     */
    public TimSort(T[] arr, Comparator<? super T> comparator) {
        this.arr = arr;
        this.comparator = comparator;
        this.leftArr = new Object[arr.length];
        this.rightArr = new Object[arr.length];
    }

    /**
     * Sorts the array using TimSort algorithm.
     */
    public void sort() {
        int n = arr.length;
        if (n < 2) return;
        int minRun = minRunLength(n);
        for (int i = 0; i < n; i += minRun) {
            int end = Math.min(i + minRun, n);
            insertionSort(i, end);
        }
        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size;
                int right = Math.min(left + 2 * size, n);
                if (mid < right) {
                    merge(left, mid, right);
                }
            }
        }
    }

    /**
     * Determines the minimum run length for the input size.
     *
     * @param n the size of the input
     * @return the minimum run length
     */
    private int minRunLength(int n) {
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    /**
     * Performs an insertion sort on a portion of the array.
     *
     * @param left  the left index of the portion to sort
     * @param right the right index of the portion to sort
     */
    private void insertionSort(int left, int right) {
        for (int i = left + 1; i < right; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= left && comparator.compare(key, arr[j]) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Merges two sorted portions of the array.
     *
     * @param left the left index of the first portion
     * @param mid  the right index of the first portion and left index of the second portion
     * @param right the right index of the second portion
     */
    private void merge(int left, int mid, int right) {
        int len1 = mid - left;
        int len2 = right - mid;
        System.arraycopy(arr, left, leftArr, 0, len1);
        System.arraycopy(arr, mid, rightArr, 0, len2);

        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (comparator.compare((T) leftArr[i], (T) rightArr[j]) <= 0) {
                arr[k++] = (T) leftArr[i++];
            } else {
                arr[k++] = (T) rightArr[j++];
            }
        }
        while (i < len1) {
            arr[k++] = (T) leftArr[i++];
        }
        while (j < len2) {
            arr[k++] = (T) rightArr[j++];
        }
    }
}
