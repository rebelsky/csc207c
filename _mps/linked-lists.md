---
title: Mini-Project 8
subtitle: Linked lists, revisited
summary: |
  In this assignment, you will revisit our implementation of doubly-linked
  lists, considering the effects of a well-known variant.
link: true
nextyear: |
  Make students update all iterators (instead of failing fast).
---
*Collaboration*: You must work alone on this project. You may, however, consult with anyone you wish.

As you no doubt discovered in the [lab on doubly linked lists](../labs/doubly-linked-lists), we often end up with a surprising number of special cases. For example, we often have special cases for when the iterator is at the beginning of the list or at the end of the list.

A pair of strategies often help eliminate special cases.

* First, we add a special "dummy" node that can never be removed. The client can never access the node or its value (and doesn't even know that it's there), but it helps with our implementation.
* Second, we make the list "circularly linked". That is, the node containing the last value in the list is followed by the dummy node and the node containing the first element in the list is preceded by the dummy node.

Why is this helpful?

Consider the case in which we want to add a value using an iterator. In most situations, the implementation is obvious.

```
  this.prev = this.prev.insertAfter(val);
  this.update = null;
  ++SimpleDLL.this.size;
  ++this.pos;
```

However, when the iterator is conceptually before the first element (and we didn't have the dummy node), we need to do something slightly different.

```
  if (this.prev == null) {
    this.prev = this.next.insertBefore(val);
    SimpleDLL.this.front = this.prev;
  } // front of list
  else {
    this.prev = this.prev.insertAfter(val);
  } // normal case
```

Okay, it's not that complicated. But it was still a special case. And we had to think about it.

If, instead, we had a dummy node, `this.prev` would be the dummy node when we were before the first element. Hence, we no longer need the special case for "no previous node".

It turns out that we will see similar advantages in almost every case.

Part one: Implement circularly-linked, doubly-linked lists with a dummy node
----------------------------------------------------------------------------

The title says it all. Implement this strategy. Call your class `SimpleCDLL` and make sure it implements the `SimpleList` interface from the lab.

In your `README.md` file, write a paragraph or two on how using a dummy node (and circular linking) simplified the code.

I would recommend that you start with the code in [the lab repo](https://github.com/Grinnell-CSC207/lab-linked-lists), but you can also start from scratch.

Part two: Add a "fail fast" strategy
------------------------------------

As you might expect, when there are multiple iterators in a list, a change to the list by one iterator might invalidate the state of other iterators. For example, consider the following list. (You may assume we've only been moving iterators forward.)


```  
 "A"  "B"  "C"  "D"  "E"
         i1   i3
         i2
```

As the illustration suggests, both `i1` and `i2` are between `B` and `C` in the list and `i3` is between `C` and `D`. If there have been no other changes to the list, we may assume that they got there through two or three calls to `next` (two for `i1` and `i2`, three for `i3`).

Now, let's consider some potential modifications to the list.

Suppose we call `i1.add("X")`. The normal policy for adding elements is that you add immediately before the iterator (and after the prior element). So our list will now look like this (at least conceptually).

```  
 "A"  "B" "X"  "C"  "D"  "E"
             i1   i3
             i2
```

Let's check out the code we were using for `add`. (Ideally, you've made this better by adding a dummy node.)

```
      public void add(T val) throws UnsupportedOperationException {
        // Special case: The list is empty)
        if (SimpleDLL.this.front == null) {
          SimpleDLL.this.front = new Node2<T>(val);
          this.prev = SimpleDLL.this.front;
        } // empty list
        // Special case: At the front of a list
        else if (prev == null) {
          this.prev = this.next.insertBefore(val);
          SimpleDLL.this.front = this.prev;
        } // front of list
        // Normal case
        else {
          this.prev = this.prev.insertAfter(val);
        } // normal case

        // Note that we cannot update
        this.update = null;

        // Increase the size
        ++SimpleDLL.this.size;

        // Update the position.  (See SimpleArrayList.java for more of
        // an explanation.)
        ++this.pos;
      } // add(T)
```

Adding the `"X"` changes `i1.pos`. But it doesn't change `i2.pos`. Hence, even thought `i1` and `i2` are conceptually at the same location, calls to `i1.previousIndex()` and `i2.previousIndex()` will return different values, as will calls to `i1.nextIndex()` and `i2.nextIndex()`.

Perhaps more importantly, adding the "X" changes `i1.prev` but not `i2.prev`. Hence, `i1.prev` and `i2.prev` will have different values. That can create all sorts of confusion, such as if we call `i2.remove()`.

We will see similar issues if, instead of adding before `i1` or `i2`, we remove before `i3`. In this case, `i1.next` and `i2.next` will still refer to the node that contains `"C"`, even though that node is no longer in the list.

If we continue using all three iterators, chaos may soon ensue. What should we do as designers/implementers. There are at least three basic choices.

* The "fingers crossed" approach: Things "as is" and expect the client programmer(s) to handle the potential dangers, waiting until something goes wrong to report an error.
* The "safety first" approach: Require each change from one iterator to update *all* iterators.
* The "fail fast" approach: Require that each iterator that has been "invalidated" by a change to report an error if the client attempts to use that iterator.

Note that the "fail fast" approach is much like the "fingers crossed" approach, except that we get earlier notice when something has gone wrong, which _should_ make it easier to debug our code.

Although the "safety first" approach may seem safer, it can also create some conceptual confusions. For example, if you've checked the position of an iterator and then check it again without moving the iterator, it seems like the position should be the same. But "safety first" means that it could change based on another iterator. That makes it almost impossible to prove things about the code.

Hence, the most common design approach to this kind of situation is to use a "fail fast" approach. For example, here's what the designers of Java say in [the documentation for the ArrayList class]({{ site.java_api }}/java/util/ArrayList.html ):

> The iterators returned by this class's `iterator` and `listIterator` methods are _fail-fast_: if the list is structurally modified at any time after the iterator is created, in any way except through the iterator's own `remove` or `add` methods, the iterator will throw a [ConcurrentModificationException]({{ site.java_api }}/java/util/ConcurrentModificationException.html). Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.


**For this part of the assignment, you should implement the "fail fast" policy**. That is, if one iterator changes a list by adding or removing an element, it should invalidate all other iterators. Each method in the iterator should check if the iterator is valid and, if not, throw an `ConcurrentModificationException`.

How do we invalidate an iterator? There are two common strategies. 

* You can use a counter to keep track of the number of changes to the list. When you create an iterator, you save that number. When you call a method, it should compare the saved number to the list's; if they differ, you should fail fast.
* You can keep a list of all the iterators for a list and mark them as invalid. Of course, that assumes that you have a structure to list values. And we're building such a structure. So this solution is a bit weird.

I'd recommend that you use the counter strategy. But if you want to use an array (or even an `ArrayList` to keep track of all the iterators), that's okay, too.

---

## Rubric

Submissions that fail to meet any of these requirements will get an I.

```
[ ] Includes the specified `.java` files, correctly named.  (They should
    be in the appropriate package.)
[ ] Each class has an introductory Javadoc comment that indicates
    the author and purpose. 
[ ] Includes a `README.md` file that contains the appropriate information 
    (authors, purpose, acknowledgements if appropriate, link to GitHub,
    instructions for running).
[ ] All files compile correctly.
[ ] The files have the correct structure (e.g., all the `.java` files are
    in a `src` directory or somewhere below it).
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```
[ ] Passes the **M** tests.
[ ] Appears to follow Google Java style guidelines for indentation and such.
[ ] There is no cruft in the repo (e.g., temp files, `.DS_Store`, etc).
[ ] Uses a dummy node.
[ ] Uses a circularly linked list.
[ ] Includes a summary of the benefits of using a dummy node and a 
    circularly linked list.
[ ] All the methods in the `ListIterator` object throw a `ConcurrentModificationException` when appropriate (should be checked by the tests).
```

### Exceeds expectations

```
[ ] Passes the **E** tests.
[ ] All (or most) repeated code has been factored out into individual methods.
    In particular, the "fail fast" code should be in a single method.
[ ] All or most variable names are appropriate.
```

## Questions and answers

_A place for Sam to log the questions he gets about this assignment and
the answers he develops._

Does the `set` method "structurally modify" the list and therefore invalidate all the iterators?

> No. Iterators should continue to work after a call to `set`. (At least that's what the design documents for `ArrayList` seem to suggest.)
