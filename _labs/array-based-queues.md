---
title: Queues, arrays, and priority queues
repo: <https://github.com/Grinnell-CSC207/lab-linear-structures-maven>
summary: |
  In this laboratory, you will have an opportunity to ground your
  understanding of queues, particularly of the array-based
  implementation of queues.  You will also continue to explore
  some other related topics.
javadoc:
  - "[`java.util.Comparator`]({{ site.java_api }}/java/util/Comparator.html)"
  - "[`java.util.PriorityQueue`]({{ site.java_api }}/java/util/PriorityQueue.html)"
---

Preparation
-----------

a. Open the [reading on linear structures](../readings/linear-structures), the [reading on queues](../readings/queues), the [reading on priority queues](../readings/linear), and the [reading on wrapper classes](../readings/wrappers) in new tabs.

b. If you haven't already done so, fork and clone the repo at {{ page.repo }}. Make sure to use the SSH link for cloning.

c. If you haven't already done so, update the `README.md` file and push the updated `README.md`. (You will likely need to add a new partner to the repo.)

Exercises
---------

### Exercise 1: Code reading

_Driver: **A**_

Read through `ArrayBasedQueue.java`.  You will note that the iterator is not yet implemented.  That's okay; we'll talk about iterators in the near future.  More importantly, you may also note a few subtle (or not so subtle) bugs.  If you do, write them down.  If not, that's okay, too; we'll work them out in the lab.

### Exercise 2: Some basic experiments

_Driver: **A**_

Look at `ArrayBasedQueueExperiment.java`.  Take notes as to what the queue should look like at each step of the first series of procedure calls.  

You may also want to revisit the `ReportingLinearStructure` class to recall how it works.

Run `ArrayBasedQueueExpt` and see if you get the output that you expect.

### Exercise 3: Squashing bugs

_Driver: **A**_

You've probably determined that there seem to be some significant bugs in the queue implementation.  Can you tell where they are?

You might learn a bit more about the bug by adding a call to `expt.put("d")` before the first call to `expt.get()`.

Do your best to correct the first bug: `get` and `peek` don't seem to return the correct value after some point.  If you need a hint as to where to look, ask your instructor or mentor.

Once you've fixed the bug, make sure to commit and push your updated code. (You might choose a better commit message than we chose.)

```text
git add src/main/java/edu/grinnell/csc207/linear/ArrayBasedQueue.java 
git status
git commit -m "Squash a bug or two in ArrayBasedQueue"
git pull
git push
```

### Exercise 4: Wrap-around in arrays

_Driver: **B**_

If you uncomment the second section of code in `ArrayBasedQueueExperiment.java` and reduce the size of the queue to, say, 4, you may find that the queue fills before it should.  (You may also have dealt with that issue.)

How do we fix that problem?  Normally, we "wrap around", so that the back of the queue goes to the front of the array.  For example, if we have seven items in a queue, and the front is at 4, then the item 0 is at 4; item 1 is at 5; item 2 is at 6; item 3 is at 7; item 4 can't be at 8 (there is no index 8), so we wrap it around to index 0; item 5 is at 1, item 6 is at 2, and the back of the queue is at 3.

Rewrite your code so that elements wrap in the specified way.  You'll need to change `back`.  You may also need to change the code for `isEmpty` and `isFull`.

Once you've added support for "wrap around", make sure to commit and push your updated code. (You might choose a better commit message than we chose.)

```text
git add src/main/java/edu/grinnell/csc207/linear/ArrayBasedQueue.java 
git status
git commit -m "Array-based queues now wrap-around"
git pull
git push
```

### Exercise 5: Extending the reporter

_Driver: **B**_

The [reading on wrapper classes](../readings/wrappers) suggested that we could make a one-parameter constructor for something liked `ReportingLinearStructure` that (a) sets `pen` to a `PrintWriter` that prints to stderr, and (b) sets `name` to the class name of the wrapped class and what appears to be a useful identifier.

Add that constructor and verify that it works as advertised.  If not, figure out how to correct it.

Commit and push your changes.

```text
git add src/main/java/edu/grinnell/csc207/linear/ReportingLinearStructure.java 
git status
git commit -m "Add new constructor for ReportingLinearStructure"
git pull
git push
```

### Exercise 6: Testing

_Driver: **B**_

Up to now, we've been exploring our linear structures by manually comparing actual output to expected output.  As we've learned, computers are much better than humans at identifying trouble spots.

a. Read through the `PriorityQueue` interface we've provided to refresh your understanding of how priority queues are supposed to behave.

b. Unfortunately (or perhaps fortunately), it is difficult to write a test suite for an interface.  So you will instead write a test suite for `BuiltinPriorityQueue`, which is similar to the `JUPQadapter` from [the reading on wrapper classes](../readings/wrappers).  

Your test suite should be sufficiently sophisticated that you can be relatively confident that it will catch appropriate errors.

The `PriorityQueue` interface tells you how they should behave, so the only additional information you need is the constructor, which has the following form.

```java
  /**
   * Create a new priority queue that holds up to capacity elements and 
   * uses order to compare elements.
   */
  public BuiltinPriorityQueue(int capacity, Comparator<T> order) throws Exception {
    // ...
  } // BuiltinPriorityQueue(int capacity, Comparator<T>)
```

Here are a few comparators you may find useful.  (In the future, we'll learn how to write these more concisely using lambdas or anonymous inner classes.)

```java
class StringComparator implements Comparator<String> {
  public int compare(String str1, String str2) {
    // Efficiency hack: If two strings occupy the same memory
    // they are equal.
    if (str1 == str2) { return 0; }
    // Safety check: If either string is null, compareTo may fail,
    // so we make sure neither is null.  We treat null as "smaller"
    // than any other string.
    if (str1 == null) { return -1; }
    if (str2 == null) { return 1; }
    // Finally, we can use the built-in `compareTo` method.
    return str1.compareTo(str2);
  } // compare(String, STring)
} // StringComparator

class IntComparator implements Comparator<Integer> {
  public int compare(Integer i, Integer j) {
    // While this method sometimes gets implemented as i-j, that
    // implementation presents overflow risks, so we choose a
    // somewhat more verbose approach.
    if (i < j) { return -1; }
    else if (j < i) { return 1; }
    else return 0;
  } // compare(Integer, Integer)
} // IntegerComparator
```

Add, commit, and push your test suite.

### Exercise 7: Adapting classes

_Driver: **B**_

a. Remind yourself of the methods specified by our `LinearStructure` interface.

b. Skim through the documentation on the standard Java implementation of priority queues, available at <{{ site.java_api }}/java/util/PriorityQueue.html>.

c. Discuss with your partner how you would write an adapter class to make the built in priority queues match the desired behavior of our priority queue interface.

d. Look at `BuiltinPriorityQueue.java` to see how our implementation matches your design. 

e. Run your test suite.

For those with extra time
-------------------------

If you are fortunate enough to have some extra time, you might 
consider doing any of the following.

### Extra 1: Linked queues

If you did not finish implementing linked queues in [the previous lab](../labs/linear-structures), do so now.

### Extra 2: Array-based priority queues

a. Read through ArrayBasedPriorityQueue.java. You will note that the iterator is not yet implemented and that prioritization is not yet implemented.

b. Make some notes to yourself as to how you might finish implementing the `put` and `get` methods.

c. As [the reading](../readings/priority-queues) noted, there are two basic strategies for implementing priority queues in arrays.

* You can keep the values in order from lowest priority to highest priority. In this case, the put method must ensure that the elements in the array are stored in order. (You can probably use a variant of the insert method from insertion sort to achieve that goal.) * You can keep the values in arbitrary order and search for the highest-priorty element whenever we call get or peek.

Pick one and finish the implementation.

### Acknowledgements

Execises 1-4 are taken primarily from [a lab on array-based queues from 
CSC 207 2014F](https://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2014F/labs/array-based-queues)

Exercise 7 and Extra 2 are taken primarily from [a lab on priority
queues from CSC 207
2014F](https://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2014F/labs/priority-queues)

The remaining exercises are new to this lab, which I think came from the spring 2019 section of 207.

The lab was rewritten somewhat in Fall 2024 to better incorporate maven and GitHub.

All of these materials were written by Samuel A. Rebelsky.
