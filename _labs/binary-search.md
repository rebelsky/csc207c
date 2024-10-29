---
title: Linear and binary search in Java
repo: <https://github.com/Grinnell-CSC207/lab-search-maven>
summary: |
  In today's laboratory, you will explore issues pertaining to
  search in Java.  Along the way, you will not only consider the
  search algorithms, but explore some program design issues
  in Java.
---
_Warning! This lab was newly rewritten in Fall 2024. There may be infelicities. Please send corrections to SamR._

Preparation
-----------

_Driver for preparation: **A**_

a. Open [the corresponding reading](../readings/search.html) in another window.

b. Open [the documentation for `Predicate`]({{ site.java_api }}/java/util/function/Predicate.html)

c. Fork and clone the starter code for this lab from {{ page.repo }}.

d. Update the `README.md` file to include your name and the URL of your fork.

e. Commit and push your changes.

```text
git add README.md
git status
git commit -m "Add our names to the README."
git pull
git push
```

f. Open the repository in VSCode.

Exercises
---------

### Exercise 1: Generalized linear search, revisited 

_Driver: **B**_

You may recall from the reading that we often search arrays for values (or just the first value) that meets some predicate.  At the end of the discussion, we noted that it would be even more general to implement a linear search for arbitrary iterable objects.

a. Open `edu.grinnell.csc207.util.SearchUtils.java` and `edu.grinnell.csc207.experiments.SearchExperiments`.

b. Read the documentation for `search` in `SearchUtils.java`.

c. You will note that `SearchExperiments.java` has an array called `tmp` and an `ArrayList` called `strings`. We convert the array to an `ArrayList` because `ArrayList` objects are iterable while arrays are not. (Don't ask; I don't know the reason.)

Add to the `main` method a command to search `strings` for the first element that is fewer than five letters. (You should not take advantage of your knowledge of what the word is.) It should look something like

```java
    String ex1c = SearchUtils.search(strings, ...);
```

or, if you feel like being a bit more thorough,

```java
    try {
      String ex1c = SearchUtils.search(strings, ...);
      pen.println("The first string of fewer than five letters is " + ex1c);
    } catch (Exception e) {
      pen.println("There are no strings of fewer than five letters.");
    } // try/catch
```

d. Compile and run your code to make sure that you got the syntax right. Since you haven't implemented `search` yet, you will likely see an exception (or a report of an exception).

```text
mvn compile -q
mvn exec:java -q
```

e. Implement the `search` procedure.

f. Recompile and run your code to see if it runs as expected.

g. What string do you think the following expression will find?

```java
    try {
      String ex1g = SearchUtils.search(strings, (s) -> s.length() == 6);
      pen.println("The first string of exactly six letters is " + ex1g);
    } catch (Exception e) {
      pen.println("There are no strings of exactly six letters.");
    } // try/catch
```

h. Confirm your answer experimentally.

i. Write an expression to find the first element of `strings` that contains a `u`.  (You may find the `contains` method in the `String` class useful.)

j. Do you expect to be able to use search with `tmp`?  Why or why
not.

k. Check your answer experimentally.

l. Save and push your changes. Make sure to add your names to these files if you haven't done so already.

```text
git add src/main/java/edu/grinnell/csc207/util/SearchUtils.java 
git add src/main/java/edu/grinnell/csc207/experiments/SearchExperiments.java 
git status
git commit -m "Implement search method for iterables."
git pull
git push
```

### Exercise 2: Testing binary search, phase one

_Driver: **A**_

a. Consider the specification of `binarySearch` in `SearchUtils.java`, which
we have repeated here.

```java
/**
 * Search for val in values, return the index of an instance of val.
 *
 * @param values
 *   A sorted array of integers
 * @param val
 *   An integer we're searching for
 * @return
 *   index, an index of val (if one exists)
 * @throws Exception
 *   If there is no i s.t. values[i] == val
 * @pre
 *   values is sorted in increasing order.  That is, values[i] <
 *   values[i+1] for all reasonable i.
 * @post
 *   values[index] == val
 */
public static int binarySearch(int[] vals, int val) throws Exception {
  return 0;     // STUB
} // binarySearch
```

b. Open `TestSearch.java` (in the obvious place) and review the code.

c. What do you expect to happen when we run the tests? Will the tests succeed or fail? If they fail, which part of each test will fail?

d. Check your answer experimentally.

e. Add a few tests of your own.

f. Commit your changes.

```text
git add src/test/java/edu/grinnell/csc207/TestSearch.java
git status
git commit -m "Add a few more tests."
git pull
git push
```

### Exercise 3: Implementing binary search

_Driver: **A**_

Although the reading introduced a variety of techniques for designing generalized binary search algorithms, it's probably easiest to start by focusing on a single type.

a. Implement the `binarySearch(int[], int)` method and verify that it passes the tests we've written so far. If your last name starts with a letter between A and M (inclusive) you should implement binary search iteratively. If your last name starts with a letter between N and Z (inclusive), you should implement binary search recursively.

b. Commit and save your changes.

```text
git add src/main/java/edu/grinnell/csc207/util/SearchUtils.java
git status
git commit -m "Implement binary search."
git pull
git push
```

### Exercise 4: Testing binary search, phase two

_Driver: **B**_

Evidence suggests that (a) many programmers have difficulty implementing binary search correctly and (b) many programmers do only casual testing of their binary search algorithm.  However, it's really easy to write a relatively comprehensive test suit for binary search. Here's one I learned by reading Jon Bentley's _Programming Pearls_.

```java
For each s from 1 to 32
  Create an array of size s, containing the values 0, 2, 4, ... 2*(s-1)
  For all i from 0 to s-1, inclusive
      // Make sure that value 2*i is in position i
      assert(binarySearch(2*i, array) == i)
      // Make sure that odd values are not in the array
      assertException(binarySearch(2*i+1, array))
  assertException(binarySearch(-1, array))
```

I've found this test very useful.  A surprising number of pieces of code fail just one or two of the many assertions in this test.

Note also that `assert` and `assertException` are not intended to be real procedures. Rather, they indicate what you should be checking. You should call `assertBinarySearchFinds` and `assertBinarySearchFails` instead.

a. Implement this test.  

b. If the test finds any bugs in your implementation of binary search, repair those bugs.

c. Commit your changes.

```text
git add src/test/java/edu/grinnell/csc207/TestSearch.java
git status
git commit -m "Add systematic tests of binary search."
git pull
git push
```

*Citation:* This test is closely based on one suggested by Jon Bentley in a _Programming Pearls_ column.

### Exercise 5: Care In checking midpoints

_Driver: **A**

As binary search is phrased in the reading, when we note that the middle element is not equal to the target value, we either set `ub` to `mid-1` or `lb` to `mid+1` (perhaps both).  But programmers often get confused by the need for the `+1` and `-1`.

Determine experimentally what happens if you leave out the `+1` and `-1`.  Explain why that result happens.

### Exercise 6: An alternate approach

_Driver: **B**_

In implementing binary search, you either wrote a loop or a recursive procedure.  Write a second version of binary search that uses the other approach.

### Exercise 7: "Timing" search

_Driver: **A**_

In theory, binary search should take $$O(log_2n)$$ steps.  Does it really?  Augment each of your methods so that it counts the number of repetitions (loop) or calls (recursive procedure).  It's probably easiest to create global variables that you set to 0, and then increment at the top of the loop body or at the start of the procedure.

Build some moderately large arrays (at least 1000 elements) to verify that you get the expected running times. (I would recommend doing so in the experiments, rather than the tests.)

For those with extra time
-------------------------

_If you find that you have extra time, you might try the following
exercises._

### Extra 1: Generic binary search

Implement a generic binary search that takes a comparator as a parameter.  Once again, it should return the index of a value that we've found (or should throw an exception if no such character exists).

```java
public static <T> int binarySearch(T[] values, T value, Comparator<T> compare) throws Exception {
  // ...
} // binarySearch
```

### Extra 2: Testing generic binary search

How could we test our generic binary search?  We could rewrite our tests.  Alternately, we could rewrite our integer `binarySearch` method to call this method.  Try the latter.

### Extra 3: Searching arrays of strings.

Use the generic `binarySearch` procedure to search the array of strings you created at the start of this lab.

Citations
---------

This lab is based on [a similar lab from the Spring 2024 section of CSC-207]((https://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2014F/labs/binary-search.html). That lab, in turn, is closely based on [a similar lab from the Fall 2014 section of 207](https://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2014F/labs/search.html).  
