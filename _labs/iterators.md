---
title: Iterators
repo: <https://github.com/Grinnell-CSC207/linear-structures>
summary: |
  We explore mechanisms for constructing iterators in Java.  We
  also touch a bit on anonymous inner classes.
javadoc:
  - "[`java.util.Comparator`]({{ site.java_api }}/java/util/Comparator.html)"
  - "[`java.util.PriorityQueue`]({{ site.java_api }}/java/util/PriorityQueue.html)"
  - "[`java.util.Iterator`]({{ site.java_api }}/java/util/Iterator.html)"
  - "[`java.util.Iteratable`]({{ site.java_api }}/java/util/Iteratable.html)"
---

Useful documentation
--------------------

* [`java.util.Comparator`]({{ site.java_api }}/java/util/Comparator.html)
* [`java.util.PriorityQueue`]({{ site.java_api }}/java/util/PriorityQueue.html)
* [`java.util.Iterator`]({{ site.java_api }}/java/util/Iterator.html)
* [`java.util.Iteratable`]({{ site.java_api }}/java/util/Iteratable.html)

Preparation
-----------

If you have not done so already, fork and clone the repo at <https://github.com/Grinnell-CSC207/linear-structures>.

Exercises
---------

### Exercise 1: Anonymous comparators

_Driver: **A**_

Write a new class with a `main` method that creates a priority queue
of strings that is ordered by string length, adds a few strings,
and then removes the strings.  

You may use either `java.util.PriorityQueue` or `BuiltinPriorityQueue`
for your priority queue.

You should use an anonymous inner class to build the comparator for the
priority queue.  If your `compare` method is presented with two 
equal-length strings, it should compare them alphabetically.

### Exercise 2: Iterating array-based structures

_Driver: **A**_

As you may recall, the `ArrayBasedStack` class has two fields, an
array called `values` and an integer called `size`.

a. Sketch (that is, make notes on but do not write the Java code for)
an iterator for the `ArrayBasedStack` class. (You do not need to turn
in your notes._

b. Compare your answer to the iterator presented in `ArrayBasedStack.java`.

### Exercise 3: Iterating linked structures

_Driver: **B**_

As you may recall, the `LinkedQueue` class has two fields,
`front` and `back`, each of which reference a node.

a. Sketch (that is, make notes on but do not write the Java code for)
an iterator for the `LinkedQueue` class. (Once again, you do not need
to turn in your notes.)

b. Compare your answer to the iterator presented in `LinkedQueue.java`.

### Exercise 4: Iterating array-based queues

_Driver: **B**_

You may have noted that the `ArrayBasedQueue` class lacks an iterator.
**Write one**.  Your iterator should present the elements starting and
the front of the queue and ending at the back.

Your code will likely look something like the following.

```java
public ArrayBasedQueue<T> implements ... {
  // ...
  Iterator<T> iterator() {
    return new ArrayBasedQueueIterator<T>(this);
  } // iterator()
  // ...
} // ArrayBasedQueue<T>

private ArrayBasedQueueIterator<T> implements Iterator<T> {
  ArrayBasedQueue<T> abq;
  int i;

  public ArrayBasedQueueIterator(ArrayBasedQueue<T> abq) {
    this.abq = abq;
    this.i = 0;
  }

  // ... this.abq.values[pos] ...
} // ArrayBasedQueueIterator<T>
```

What to submit
--------------

Upload your answers to exercises 1 and 4. That is, upload the new file you created in exercise 1 and the modified version of `ArrayBasedQueue`.

For those with extra time 
-------------------------

If you find that you have extra time, you should attempt the following.

### Extra 1: Implementing `remove` in array-based queues

You may have noted that `java.util.Iterator` provides a `remove` method.
Implement that method for your iterator for `ArrayBasedQueue`.

### Extra 2: Anonymous iterators

Convert your iterator for array-based queues to an anonymous inner
class.  You should now be able to do without the field that refers
back to the associated array-based queue.

### Extra 3: Implementing `remove` in linked queues

Implement the `remove` method for the iterator for `LinkedQueue`.  

_Note_: This is a pain in the neck and may involve special cases.

Acknowledgements
----------------

This lab was newly written in spring 2019.  It was revised somewhat in 
Fall 2023 and Spring 2024.
