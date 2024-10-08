---
title: Iterators
repo: <https://github.com/Grinnell-CSC207/lab-linear-structures-maven>
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

If you have not done so already, fork and clone the repo at {{ page.repo }}.

Add today's lab partner to the `README.md` and push it.

Exercises
---------

### Exercise 1: Iterating array-based structures

_Driver: **A**_

As you may recall, the `ArrayBasedStack` class has two fields, an array called `values` and an integer called `size`.

a. Sketch (that is, make take notes on a whiteboard or piece of paper) an iterator for the `ArrayBasedStack` class. (You do not need to turn in your notes.)

b. Compare your answer to the iterator presented in `ArrayBasedStack.java`.

### Exercise 2: Iterating linked structures

_Driver: **B**_

As you may recall, the `LinkedQueue` class has two fields, `front` and `back`, each of which reference a node.

a. Sketch (that is, take notes on a piece of paper or whiteboard) an iterator for the `LinkedQueue` class. (Once again, you do not need to turn in your notes.)

b. Compare your answer to the iterator presented in `LinkedQueue.java`.

### Exercise 3: Iterating array-based queues

_Driver: **A**_

You may have noted that the `ArrayBasedQueue` class lacks an iterator.  **Write one**.  Your iterator should present the elements starting and the front of the queue and ending at the back. You should implement only the `next` and `hasNext` methods.

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

Commit and push your changes.

```text
git add src/main/java/edu/grinnell/csc207/linear/ArrayBasedQueue.java
git status
git commit -m "Add an interator for array-based queues."
git pull
git push
```

### Exercise 4: Implementing `remove` in array-based queues

_Driver: **B**_

You may have noted that `java.util.Iterator` provides a `remove` method.  Implement that method for your iterator for `ArrayBasedQueue`.

Commit and push your code.

```text
git add src/main/java/edu/grinnell/csc207/linear/ArrayBasedQueue.java
git status
git commit -m "Add remove to the iterator for ArrayBasedQueue."
git pull
git push
```


Submitting your work
--------------------

Answer questions on Gradescope.

For those with extra time 
-------------------------

If you find that you have extra time, you should attempt the following.

### Extra 1: Anonymous iterators

Convert your iterator for array-based queues to an anonymous inner class.  You should now be able to do without the field that refers back to the associated array-based queue.

### Extra 2: Implementing `remove` in linked queues

Implement the `remove` method for the iterator for `LinkedQueue`.  

_Note_: This is a pain in the neck and may involve special cases.
