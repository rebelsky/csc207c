---
title: Mini-Project 8
subtitle: Sorting out sorting
summary: |
  In this assignment, you will further explore the implementation 
  of sorting algorithms.
repo: https://github.com/Grinnell-CSC207/mp-sorting-maven
collaboration: |
  Each student should submit their own responses to this project. You may
  consult other students in the class as you develop your solution.  If you
  receive help from anyone, make sure to cite them in your responses. 
link: true
---
# {{ page.title }} : {{ page.subtitle }}

_This assignment has been significantly updated for Fall 2024. It likely contains imperfections. If you notice any, please let SamR know._

Summary: {{ page.summary }}

Repository: <{{ page.repo }}>

## Background: A generic sorting interface

As you might expect, we want to be able to switch sorting algorithms depending on a variety of circumstances, particularly characteristics we know about the data (e.g., that they are mostly in order or perhaps mostly reverse sorted).  Hence, rather than writing static `sort` methods, it may be more useful to define a generic `Sorter` interface and use that.  Here's one such interface.

```java
/**
 * Things that know how to sort arrays of values.
 *
 * @author Samuel A. Rebelsky
 *
 * @param <T>
 *   The type of value in the array.
 */
public interface Sorter<T> {
  /**
   * Sort an array in place.
   *
   * @param values
   *   an array to sort.
   *
   * @post
   *   The array has been sorted according to some order (often
   *   one given to the constructor).
   * @post
   *   For all i, 0 < i < vals.length,
   *     order.compare(vals[i-1], vals[i]) <= 0
   */
  public void sort(T[] values);
} // interface Sorter<T>
```

## Preparation

a. Fork the repository at {{ page.repo }}.

b. Clone that repository.

```text
cd ~/CSC207/MPs                 # Or the directory of your choice
git clone git@github.com:USERNAME/mp-sorting-maven.git
```

c. Open the project in VSCode.

d. Update the `README.md` appropriately.

e. Push the updated `README` to GitHub.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-sorting-maven
git add README.md
git status
git commit -m "Update README."
git pull
git push
```

f. Add an upstream repository just in case I make changes.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-sorting-maven
git remote add upstream https://github.com/Grinnell-CSC207/mp-sorting-maven
```

In the future, you can grab changes using the following.

```text
git fetch upstream
git merge upstream/main
```

You can also just click the **Sync Fork** button on your GitHub page for the fork.

## Part one: Testing

As I hope you know by now, when writing a small or medium-sized function or class, we should begin by writing test cases for the function or class.

In the file `SortTester.java`, add at least five test cases for `Sorter<T>` objects. (The system is designed so that every test you put in `SortTester` is now available to test all four sorting algorithms.)

## Part two: Implement common sorts

### Insertion sort

Create a new class, `InsertionSort`, that implements insertion sort.  The repo should include a framework for the class.

### Selection sort

Create a new class, `SelectionSort`, that implements insertion sort.  The repo should include a framework for the class.

### Merge sort

Create a new class, `MergeSort`, that implements merge sort.  The repo should include a framework for the class.

### Quicksort

Create a new class, `QuickSort`, that implements Quicksort.  The repo should include a framework for the class.

Once you've identified a pivot, I would recommend that you use the Dutch National Flag algorithm to partition the subarray into (a) things less than the pivot, (b) things equal to the pivot, and (c) things greater than the pivot.

## Part three: Your own sort

In practice, the best sorting algorithms do something a bit more clever. For example, it may be good to switch from merge sort to insertion sort once you reach a small enough subarray, or one that is mostly ordered.

Write your own sorting algorithm that attempts to do better than all of the prior $$O(nlogn)$$ sorting algorithms. You might pre-scan the input to look for patterns that suggest a particular algorithm, you might switch algorithms for small enough arrays, you might find something else clever to do.

Please name your class `LastFirstSort`.  For example, mine would be `RebelskySamuelSort`. Please do not reference methods in your other classes.

Include a description of your approach in your README file.

You should also add a tester for your sort to make sure that it works correctly. (The pattern of the other testers should make that straightforward.)

I will hold a competition to see whose sorting algorithm wins on different kinds of inputs. Winners will receive acclaim as well as an extra token or two.

On this part of the mini-project, _and **only** on this part of the mini-project_, you may use Copilot or other LLM as a programming assistant.  If you do so, make sure to provide appropriate citations.  I'd also appreciate it if you'd also add a short note about the experience of using CoPilot.

Note that your sorting mechanism is expected to be efficient in most cases. You should strive for no worse than $$O(n^2)$$.

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
[ ] Added new tests to `SortTests.java`.
[ ] No more than fifteen errors from `mvn checkstyle:check`.
[ ] Appears to follow Google Java style guidelines for indentation and such.
[ ] All sorting routines pass Sam's tests (conveniently available in
    `SortTools.java`.
    [ ] Insertion sort
    [ ] Selection sort
    [ ] Merge sort
    [ ] Quicksort
    [ ] Your own sort
[ ] `README.md` includes a description of the new sorting algorithm.
```

### Exceeds expectations

```
[ ] All (or most) repeated code has been factored out into individual methods.
[ ] All or most variable names are appropriate.
[ ] No more than five errors from `mvn checkstyle:check`.
[ ] One or more of the new tests in `SortTester.java` algorithmically 
    generates multiple tests.
[ ] Appropriately decomposes each sorting algorithm.
    [ ] Insertion sort has a separate `insert` method.
    [ ] Selection sort has a separate `select` method.
    [ ] Merge sort has a separate `merge` method.
    [ ] Quicksort has a separate `partition` method.
[ ] All sorts work with the empty array.
[ ] Only makes one helper array in `MergeSort`.
```

## Questions and answers

**Does my sort have to be stable?**

> Nope.

**Can I use ChatGPT, Copilot, or similar AI tool on this assignment?**

> As per class policies, you may NOT use ChatGPT on parts one and two. I have, however, made an exemption to class policies for Part three.  You may use ChatGPT on Part three provided you cite it and provide a short narrative about your experience doing so.

**Can I talk to my peers about the assignment?**

> Of course.

## Additional notes

The project also includes an (untested and still under development) version of a `SortTools` class. That class can be used to find arrays large enough that sorting is worth timing. It can also be used to run simple competitions between different sorters.

Here's a typical session (to be updated once Sam implements some sorting algorithms).

```text
$ mvn compile -q
$ java -cp target/classes edu.grinnell.csc207.main.SortTools time edu.grinnell.csc207.sorting.Quicksorter
```

