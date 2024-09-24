---
title: Mini-Project 4
subtitle: Associative arrays
repo: <https://github.com/Grinnell-CSC207/mp-associative-arrays-maven>
summary: |
  We build our first data structure.  Along the way, we practice with
  generics/parametric polymorphism.
collaboration: |
  Each student should submit their own responses to this project. You may
  consult other students in the class as you develop your solution.  If you
  receive help from anyone, make sure to cite them in your responses.
link: true
---
# {{ page.title }} : {{ page.subtitle }}

_Please do not read over this mini-project until we have discussed it in class._

## Introduction

An _associative array_ is a common data structure, similar to the association lists (or hashes) that you may have learned about in CSC-151.  Since it's a data structure, we'll start by considering the layout of the associative array in memory.

In essence, an associative array is an (expandable) array of key/value pairs, intended to support looking up values by key.  I think of them something like the following:

```
        +---+
  size: | 3 |
        +---+

  pairs:
  +---+                                                +---+---+
  | *-------------------------------------------------> | * | * |
  +---+                                +---+---+        +-|-+-|-+
  | *--------------------------------> | * | * |          |   v
  +---+              +---+---+         +-|-+-|-+          | +----------+
  | *--------------> | * | * |           |   v            | | V value0 |
  +---+              +-|-+-|-+           | +----------+   | +----------+
  | / |                |   v             | | V value1 |   v
  +---+                | +----------+    | +----------+ +--------+
  | / |                | | V value2 |    |              | K key0 |
  +---+                | +----------+    v              +--------+
  | / |                |               +--------+
  +---+                |               | K key1 |
  |   |                v               +--------+
    .                +--------+
    .                | K key2 |
    .                +--------+
```

That is, we have an array of Key/Value pairs along with an accompanying `size` field to keep track of how many pairs are in the array.  The array may have some empty space, which we fill with `null` values.  In the diagram, we've put all the nulls at the end.  However, you might decide that it's more natural to leave some nulls in the middle.

Associative arrays are most frequently used to implement the `Dictionary` or `Map` abstract data types.  Both are names for structures that allow you to store associate values with corresponding keys.  (Each key has only one value; multiple valeus may have the same key.)

The central methods for such types include the following:

`void set(K key, V value)`
  : Set the value associated with a given key.  If there is already another value associated with the given key, this new value replaces that value.

`V get(K key)`
  : Get the value associated with a given key.  If there is no such key, throws an exception.

`boolean hasKey(K key)`
  : Determines if the given key appears in the associative array.

`void remove(K key)`
  : Remove the key/value pair associated with the given key.  If the key does not appear in the associative array, does nothing.

`int size()`
  : Determine how many key/value pairs are currently stored in the associative array.

`String toString()`
  : Return a string of the form `"{ key0: value0, key1: value1, ... keyn: valuen }"`  If the array is empty, you should return `"{}"`.

As you might expect, the first four procedures will need to iterate the array of key/value pairs, stopping when they find a matching key or run out of pairs.  We normally use the `equals` method to determine matching keys.

## Getting ready

Fork and clone the repository at {{ page.repo }}. Update the `README.md` and push the updated `README` to GitHub.

Make sure to accept the invitation to our testing repo. If you don't receive one, contact SamR.

Fork and clone that repository, too. The clone of the testing repo should end up as the folder `associative-arrays/tests`.

```text
cd /home/USERNAME/CSC207/MPs/MP3/associative-arrays     # Fill in dir
git clone ... tests
```

## Testing

## The assignment

1. Add at least three tests, including one edge case, to the shared `TestAssociativeArrays.java` repository.  Please name them with a form like `lastFirstTest1()`, `lastFirstTest2()`, and `lastFirstEdge1()`.  For example, mine would be `rebelskySamuelTest1()`, `rebelskySamuelTest2()`, and `rebelskySamuelEdge1()`.

    _Make sure that your tests do not break the test suite!_

    Do not test the `toString` method; there are too many potential
    orders for the K/v pairs.

2. Implement an `AssociativeArray<K,V>` class in Java.  You may _not_ use any other Java classes that provide similar features; you must rely on an underlying plain Java array of `KVPair<K,V>` objects.

## Rubric

_I plan to revisit this rubric._

### Redo or above

Submissions that fail to meet any of these requirements will get an I.

```text
[ ] Passes all the R tests.
[ ] Each class has an introductory Javadoc comment that indicates
    the author and purpose.
[ ] Includes a `README.md` file that contains the appropriate information
    (authors, purpose, acknowledgements if appropriate)
[ ] All files compile correctly.
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```text
[ ] Passes all the M tests.
[ ] No more than ten errors from `mvn checkstyle:check`.
[ ] Added three tests to the `AssociativeArrayTests.java` file.
[ ] One of those three tests is an edge case (preferably named as such).
[ ] The `toString()` method appears to behave correctly. (Since the ordering
    of key/value paiss is somewhat open, we can't readily check this with
    unit tests.)
```

### Exemplary / Exceeds expectations

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an M.

```text
[ ] Passes all of the E tests.
    [ ] Handles `null` keys in `set`, `get`, and `hasKey`.
[ ] All (or most) repeated code has been factored out into individual
    methods.
[ ] All or most variable names are appropriate.
```

Testing
-------

I may not provide a separate test suite for this assignment. Rather, we will rely on the collaborative tests to catch errors. (I may, however, write a test suite for the graders to use. You should try to make sure that your collaborative suite catches all reasonable errors and edge cases.

You should make sure to add an upstream linke for your repository so that you can pull any changes I make (including adding tests).

First, type the following. (You will only do this once in each clone.)

```
git remote add https://github.com/Grinnell-CSC207/mp-blocks-maven
```

Then, each time I tell you that I've updated the tests, you will type the following.

```
git fetch upstream
git merge upstream/main
```

Questions and Answers
---------------------

_Forthcoming._

Acknowledgements
----------------

I figured out the Maven setup for separate projects from this page: <https://stackoverflow.com/questions/1627211/how-to-set-up-maven-for-two-separate-projects-that-depend-on-the-same-jar>.
