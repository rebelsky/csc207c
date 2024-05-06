---
title: Graph traversal
repo: <https://github.com/Grinnell-CSC207/graphs>
summary: |
  We explore techniques for traversing graphs.
---
Preparation
-----------

Fork and clone the repository at {{ page.repo }}.  Import it into VSCode.

### Read the code

_Driver: **A**_

a. Scan through the code so that you understand what methods are available and what approaches are used.  Make notes on areas that are likely to be problematic.

b. Summarize the key design decisions in this implementation of graphs.

c. Suppose we wanted to work with unweighted, directed graphs.  What decisions would we need to make or what strategies would we have to use in the client?

d. Suppose we wanted to work with weighted, undirected graphs.  What decisions would we need to make or what strategies would we have to use in the client?

e. Suppose the code was written quickly by a programmer who was behind on sleep.  What are likely trouble spots in the code?

Exercises
---------

### Exercise 1: A simple experiment

_Driver: **B**_

The file `GraphExperiment.java` contains a series of experiments with the `Graph` class.

a. Skim the file to make sure you understand what the experiments are exploring.

b. Run the experiment to see that the correct graphs are built.

c. Add a few experiments of your own to explore the trouble spots you identified in the prior problems.

### Exercise 2: Improved dumping

_Driver: **A**_

You will note that there is a `dump` procedure in the `Graph` class.  That procedure prints out vertices and edges using vertex numbers.  Write a new version of `dump` that prints out vertices and edges using vertex names.

### Exercise 3: What can I reach?

_Driver: **B**_

Write a procedure, `reachableFrom(PrintWriter pen, int vertex)`, that prints out a list of all the vertices reachable from a starting point.  A vertex, `v`, is reachable from a vertex, `u`, if there is a path from `u` to `v`.  

Conduct a few experiments to see if your procedure works correctly.

You can use depth-first search or breadth-first search.

*Note*: You will likely need to find a way to mark vertices to indicate that you've printed them out (or otherwise processed them) so that you don't process them a second time. You can use the `mark` operations provided, you can use a hash table, you can use an array or arraylist, or you can use something else of your choosing.

### Exercise 4: What can I reach? revisited

_Driver: **A**_

Write a procedure, `Iterable<Integer> reachable(int vertex)`, that returns an iterable that returns an iterator of all the vertices reachable from a vertex.

You need only implement the `hasNext` and `next` methods. You also need not worry about `ConcurentModificationException`s.

For those with extra time
-------------------------

_If you fnd that you have extra time, you might want to try one or more
of the following exercises._

### Extra 1: What can I reach? re-revisited

Write a procedure, `pathsFrom(PrintWriter pen, int vertex)`, that prints out all the vertices reachable from a vertex *and* a path to each vertex.  (There may be multiple paths to each vertex; you should only print out one.)  For example, your output might look something like the following, showing that `a` can reach `b`, `c`, `d`, and `e`, using the paths shown.

```text
a -> b
a -> b -> c
a -> d
a -> b -> c -> e
```

### Extra 2: What can I reach? re-re-revisited

Write a variant of `pathsFrom` that uses whichever searching strategy you did not use in the original version.  (If you used breadth-first search, implement depth-first search.  If you used depth-first search, implement breadth-first search.)
