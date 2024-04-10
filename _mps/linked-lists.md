---
title: Mini-Project 8
subtitle: Linked lists, revisited
summary: |
  In this assignment, you will revisit our implementation of doubly-linked
  lists, considering the effects of a well-known variant.
link: true
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

I would recommend that you start with the code in the lab repo, but you can also start from scratch.

Part two: Add a "fail fast" strategy
------------------------------------

_Instructions forthcoming._

---

## Rubric

Submissions that fail to meet any of these requirements will get an I.

```
[ ] Includes the specified `.java` files, correctly named.  (They should
    be in the appropriate package.)
[ ] Each class has an introductory Javadoc comment that indicates
    the author and purpose. 
[ ] Includes a `README.md` file that contains the appropriate information 
    (authors, purpose, acknowledgements if appropriate, link to GitHub).
[ ] All files compile correctly.
[ ] The files have the correct structure (e.g., all the `.java` files are
    in a `src` directory or somewhere below it).
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```
[ ] Appears to follow Google Java style guidelines for indentation and such.
[ ] There is no cruft in the repo (e.g., temp files, `.DS_Store`, etc).
[ ] _More to follow._
```

### Exceeds expectations

```
[ ] All (or most) repeated code has been factored out into individual methods.
[ ] All or most variable names are appropriate.
[ ] More forthcoming.
```

## Questions and answers

_A place for Sam to log the questions he gets about this assignment and
the answers he develops._

