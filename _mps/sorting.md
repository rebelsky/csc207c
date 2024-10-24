---
title: Mini-Project 8
subtitle: Sorting out sorting
summary: |
  In this assignment, you will further explore the implementation 
  of sorting algorithms.
repository: https://github.com/Grinnell-CSC207/sorting-mini-project
collaboration: |
  Each student should submit their own responses to this project. You may
  consult other students in the class as you develop your solution.  If you
  receive help from anyone, make sure to cite them in your responses. 
link: true
---
# {{ page.title }} : {{ page.subtitle }}

_This assignment is still in draft form._

Summary: {{ page.summary }}

Repository: <{{ page.repository }}>

## Background: A generic sorting interface

As you might expect, we want to be able to switch sorting algorithms depending on a variety of circumstances, particularly characteristics we know about the data (e.g., that they are mostly in order or perhaps mostly reverse sorted).  Hence, rather than writing static `sort` methods, it may be more useful to define a generic `Sorter` interface and use that.  You may even recall that we wrote such an interface.  Here's a slight variant of that interface.

```
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
```

## Part one: Testing

As I hope you know by now, when writing a small or medium-sized function or class, we should begin by writing test cases for the function or class.

In the file `SortTester.java`, add at least five test cases for `Sorter<T>` objects.

## Part two: Insertion sort

Create a new class, `InsertionSort`, that implements insertion sort.  The repo should include a framework for the class.

## Part three: Merge sort

In class, you implemented (or started to implement) merge sort.  Create a new class, `MergeSort`, that implements merge sort.  The repo should include a framework for the class.

## Part four: Quicksort

In class, you implemented (or started to implement) Quicksort.  Create a new class, `QuickSort`, that implements Quicksort.  The repo should include a framework for the class. (We'll be doing some of this in class immediately after break.)

## Part five: Your own sort

In practice, one of the most popular sorting algorithms in TimSort.  You should read [the original documentation for TimSort](https://github.com/python/cpython/blob/main/Objects/listsort.txt) as a starting point in understanding it (it's good practice to read the documentation that programmers write for other programmers), but you might find the [Wikipedia page](https://en.wikipedia.org/wiki/Timsort) a bit more comprehensible.

Using the ideas from TimSort or anything else you find, implement the fastest (in practice) sorting algorithm you can come up with.

We will hold a competition in class to see whose sorting algorithm wins on different kinds of inputs.  Winners will receive acclaim from their instructor, mentors, and classmates.

Please name your class `LastFirstSort`.  For example, mine would be `RebelskySamuelSort`.

On this part of the mini-project, _and **only** on this part of the mini-project, you may use ChatGPT or other LLM as a programming assistant.  If you do so, make sure to provide appropriate citations.  I'd appreciate it if you'd also add a short note about the experience of using ChatGPT.

Note that your sorting mechanism is expected to be efficient in most cases. You should strive for no worse than O(n^2).

## Rubric

### Redo or above

Submissions that fail to meet any of these requirements will get an I.

```
[ ] Includes the specified `.java` files, correctly named.  (They should
    be in the appropriate package.)
[ ] Each class has an introductory Javadoc comment that indicates
    the author and purpose. 
[ ] Includes a `README.md` file that contains the appropriate information 
    (authors, purpose, acknowledgements if appropriate)
[ ] All files compile correctly.
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```
[ ] Appears to follow Google Java style guidelines for indentation and such.
[ ] All sorting routines pass Sam's tests (conveniently available in
    examples/sorting/SortTools.java).
    [ ] Insertion sort
    [ ] Merge sort
    [ ] Quicksort
    [ ] Your own sort
[ ] Added new tests to `SortTests.java`.
```

### Exceeds expectations

```
[ ] All (or most) repeated code has been factored out into individual methods.
[ ] All or most variable names are appropriate.
[ ] `SortTester.java` algorithmically generates multiple tests.
[ ] Particularly good/clever individual sorting method.  (Basically,
    anything that's expected O(nlogn).
[ ] All sorts work with the empty array.
[ ] Only makes one helper array in `MergeSort`.
```

## Questions and answers

Does my sort have to be stable?

> Nope.

Can I use ChatGPT on this assignment?

> As per class policies, you may NOT use ChatGPT on parts 1--4.  I have,
  however, made an exemption to class policies for Part 5.  You may
  use ChatGPT on Part 5 provided you cite it and provide a short 
  narrative about your experience doing so.

Can I talk to my peers about the assignment?

> Of course.
