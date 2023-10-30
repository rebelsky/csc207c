---
title: Quicksort
summary: |
  In this lab, you will implement Quicksort, an efficient in-place
  sorting algorithm.
copyright:  Copyright &copy; Anya Vostinar, Peter-Michael Osera, and Samuel A. Rebelsky.
copyright_message: |
  This work is licensed under a Creative Commons Attribution-NonCommercial
  4.0 International License.  To view a copy of this license, visit
  <http://creativecommons.org/licenses/by-nc/4.0/>.
link: true
---
In this lab we will implement the Quicksort algorithm. 

Let us first review the main steps in Quicksort:

* Choose a pivot element
* Partition the sub-array according to the pivot.
* Recursively Quicksort the two partitioned halves of the sub-array.

## The partition operation

We will start this lab by first implementing the partition operation. For this part of the lab, we will fill in the following definition of the partition operation:

```java
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
  private static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    ...
  } // partition
```

The partition operation takes a sub-array (like merge sort, denoted by a lower bound, `lb`, and an upper bound, `ub`).

Let's assume the array we want to partition has the shape below. (That is, here's the invariant.)

```text
+----------+--+-------------+--------------------+------------+---------+
|   ???    | p| values <= p | unprocessed values | values > p |   ???   |
+----------+--+-------------+--------------------+------------+---------+
           |  |             |                    |            |
           lb lb+1          small                large        ub
```

Following the partition operation, we want the modified array to have the following properties (1) all the elements *less than* the pivot are to the left of the pivot, and (2) all the elements *greater than or equal to* the pivot are to the right.

At the end of the of the main loop of the partition operation, we expect
the array to look like this.

```text
+----------+--+----------------------+------------------------+---------+
|   ???    | p|     values <= p      |      values > p        |   ???   |
+----------+--+----------------------+------------------------+---------+
           |  |                                               |
           lb lb+1                                            ub
```

To perform this operation in linear time, we will employ a *two-fingered* approach. Let's visualize this operation with a sample array.

```text
+---+---+---+---+---+---+---+---+---+
| 3 | 9 | 2 | 8 | 6 | 4 | 1 | 7 | 5 |
+---+---+---+---+---+---+---+---+---+
```

### Step 1: Picking and placing the pivot

There are a variety of techniques for picking the value to use as the pivot.  Ideally, we'd use the _median_ value.  Unfortunately, there's no quick way to find the median.  Hence, we typically use a random element or an easy to pick element.  Surprisingly (or not so surprisingly, the midpoint usually works well.

For the array above, let's say we choose the element 6 as our pivot. Because we are sorting the array *in-place*, we want to first swap the pivot 6 with the first element of the array (or the sub-array, if we're using it within Quicksort). Now we can consider partitioning every element but the last of the array according to the pivot.

```text
+---+---+---+---+---+---+---+---+---+
| 6 | 9 | 2 | 8 | 3 | 4 | 1 | 7 | 5 |
+---+---+---+---+---+---+---+---+---+
```

### Step 2: Pointer Initialization

Our implementation will use `small` and `large` to keep track of the sub-array limits (everything to the left of `small` is less than or equal to the pivot; everything to the right of `large` is greater than or equal to the pivot.  We can initialize our pointers to keep track of the left and right indices relative to the sub-array limits.  

```text
+---+---+---+---+---+---+---+---+---+
| 6 | 9 | 2 | 8 | 3 | 4 | 1 | 7 | 5 |
+---+---+---+---+---+---+---+---+---+
|   |                               |
lb  small                           ub
                                    large
```

### Step 3: Compare and Swap

Now we will repeatedly compare elements on the left- and right-hand sides of the array and place them in the correct position relative to the pivot. In our array, the first swap occurs when we find an element on the left that is greater than the pivot, and on the right that is lesser than the pivot.  Remarkably, it's our first pair of elements (the one immediately to the right of `small` and the one immediately to the left of `large`).

```text
+---+---+---+---+---+---+---+---+---+
| 6 | 9 | 2 | 8 | 3 | 4 | 1 | 7 | 5 |
+---+---+---+---+---+---+---+---+---+
|   |                               |
lb  |                               ub
    small                           large
```

We swap those two elements and move the boundaries.

```text
+---+---+---+---+---+---+---+---+---+
| 6 | 5 | 2 | 8 | 3 | 4 | 1 | 7 | 9 |
+---+---+---+---+---+---+---+---+---+
|       |                       |   |
lb      |                       |   ub
        small                   large
```

Conveniently, the next element on the left is less than or equal to the pivot, so we can advance `small`.

```text
+---+---+---+---+---+---+---+---+---+
| 6 | 5 | 2 | 8 | 3 | 4 | 1 | 7 | 9 |
+---+---+---+---+---+---+---+---+---+
|           |                   |   |
lb          |                   |   ub
            small               large
```

Similarly, we can move the large boundary down over the 7.

```text
+---+---+---+---+---+---+---+---+---+
| 6 | 5 | 2 | 8 | 3 | 4 | 1 | 7 | 9 |
+---+---+---+---+---+---+---+---+---+
|           |               |       |
lb          |               |       ub
            small           large    
```

And swap.

```text
+---+---+---+---+---+---+---+---+---+
| 6 | 5 | 2 | 1 | 3 | 4 | 8 | 7 | 9 |
+---+---+---+---+---+---+---+---+---+
|               |       |           |
lb              |       |           ub
                small   large    
```

We advance the small boundary over the next few small elements.

```text
+---+---+---+---+---+---+---+---+---+
| 6 | 5 | 2 | 1 | 3 | 4 | 8 | 7 | 9 |
+---+---+---+---+---+---+---+---+---+
|                       |           |
lb                      |           ub
                        large    
                        small
```

What next?


### Step 4: Termination

What would be an appropriate condition to terminate the loop body?  (The picture above should give you a clue.

### Step 5: Wrapping up

When you're done, you should swap the pivot into the location it
belongs (in this version, at the right of the <= elements).  You will
then return the index of the pivot.

```text
+---+---+---+---+---+---+---+---+---+
| 4 | 5 | 2 | 1 | 3 | 6 | 8 | 7 | 9 |
+---+---+---+---+---+---+---+---+---+
|                     ^ |           |
lb                      |           ub
                        large    
                        small
```

### Step 6 Test: cases

And now to check our code! Experiment your code with common-case as well as edge-case scenarios. Does your code return the correct partitioning if the pivot is set to the smallest or the largest element in the list?

Here's one example to get you started.

```
  /**
   * Run some experiments.
   */
  public static void main(String[] args) {
    Integer[] vals0 = new Integer[] { 3, 9, 2, 8, 6, 4, 1, 7, 5 };
    Comparator<Integer> compareInts = (x,y) -> x.compareTo(y);

    partitionExperiment(vals0, compareInts);
  } // main(String[])

  /**
   * A partition experiment.
   */
  public static <T> void partitionExperiment(T[] vals, Comparator<? super T> order) {
    System.err.println("Original:    " + Arrays.toString(vals));
    int pivotLoc = Quicksort.partition(vals, order, 0, vals.length);
    System.err.println("Partitioned: " + Arrays.toStrings(vals));
    System.err.println("Pivot is " + vals[pivotLoc] + " at position " + pivotLoc);
  } // partitionExperiment
```

## Writing `quicksort`

Now that we have implemented the partition operation, all that remains is to recursively apply the partition operation on our input array! Write an implementation of Quicksort that has the following definition:

```java
  /**
   * Sort the values in values using order to compare values.
   */
  public static <T> void quicksort(T[] values, Comparator<? super T> order) 
```

Note that we will also need to write a helper quicksort implementation which would take in the array bounds to recursively sort through the left and right sub-arrays.

```java
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
```

That makes it easy to write the primary `quicksort`.

```java
  public static <T> void quicksort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length);
  } // quicksort
```

### Testing

Check your code once again across both common-case and edge-case scenarios to make sure your sorting algorithm works.

## Choosing a pivot

Finally, we consider our choice of pivot. We have seen from the readings, that a poor choice of pivot can affect the run time of our Quicksort implementation and that a good choice of pivot would be the median of the list. A computationally efficient implementation is to use Median of three to select our pivot using the first, the middle, and the last elements of the array. Consider the following questions before proceeding to implement Median of three:

* What is the order complexity of Quicksort assuming the pivot is the largest element of the list?
* Is the median a better choice of the pivot than the mean? If so why?
* Is median of three always better than the worst-case scenario?

Write an implementation of median-of-three that has the following signature:

```java
private static int medianOfThree(int[] arr, int left, int right)
```

## Extension: Quickselect

_For the few of you who have extra time._

Let's say we wanted to select the kth smallest element in an unsorted list. How would we go about finding this element? Given a set of *n* distinct numbers and the number *k*, 1 <= *k* <= *n*, the selection problem computes the **kth order statistic**, or kth smallest number in the set of numbers.

We will now proceed to implement Quickselect which has a slight variation on Quicksort. The intuition in Quickselect is that we prune the sub-arrays where we know that the `k`th value will not be found.

1\. Pick a pivot at random from the input array.

2\. Partition the array into sub-arrays as before and count the number of elements, L, in the left sub-array.

```text
    [< pivot][ ][> pivot]
     —— L— pivot
```

3\. Selection: In this operation, we want to use the results of the partition, to select the sub-array where we will find the kth smallest value. a. If L is equal to k-1 then the pivot is the kth smallest value! b. If L is greater than k-1 then recursively call select on the left sub-array. c. If L is less than k-1 then recursively call select on the right sub-array.

Write the `select` operation of Quickselect:

```java
private static int select(int[] arr, int k)
```

## Acknowledgements

This lab is copied nearly verbatim from a similar lab by Anya Vostinar
and Peter-Michael Osera.
