import java.util.Arrays;

public class TimSort<T extends Comparable<T>> {

    // The minimum size of a chunk before performing a binary insertion sort
    private static final int MIN_MERGE = 32;

    // The array to be sorted
    private T[] arr;

    // Constructor
    public TimSort(T[] arr) {
        this.arr = arr;
    }

    // Perform binary insertion sort on the specified range of the array
    private void binaryInsertionSort(int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T key = arr[i];
            int j = Math.abs(Arrays.binarySearch(arr, left, i, key) + 1);
            System.arraycopy(arr, j, arr, j + 1, i - j);
            arr[j] = key;
        }
    }

    // Merge two adjacent runs
    private void mergeRuns() {
        int n = arr.length;
        int minRun = minRunLength(n);

        for (int i = 0; i < n; i += minRun) {
            int end = Math.min(i + minRun - 1, n - 1);
            binaryInsertionSort(i, end);
        }

        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n-1));
                if (mid < right) {
                    merge(left, mid, right);
                }
            }
        }
    }

    // Merge two adjacent runs
    private void merge(int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        T[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        T[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
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
    public void sort() {
        mergeRuns();
    }

    // Main method for testing the implementation
    public static void main(String[] args) {
        Integer[] arr = { 5, 1, 9, 3, 7, 6, 8, 2, 4, 0 };
        TimSort<Integer> timSort = new TimSort<>(arr);
        timSort.sort();

        System.out.println(Arrays.toString(arr));
    }
}
