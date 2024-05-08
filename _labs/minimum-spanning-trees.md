---
title: Minimum spanning trees
repo: <https://github.com/Grinnell-CSC207/graphs>
summary: |
  We explore techniques for building minimum spanning trees
---
Preparation
-----------

If you have not done so already, fork and clone the repository at {{ page.repo }}.  Import it into your IDE.

Exercises
---------

### Exercise 1: Priority queues

_Driver: **A**_

As you may recall, all of the MST algorithms rely on some sort of priority queue that allows you to find the smallest edge in a set of edges (the whole set of edges or the edges in Kruskal's; those adjacent to the partial MST in Prim's).

a. Identify an appropriate implementation of priority queues in Java.

b. Sketch how you will use that implementation to order edges by weight.

### Exercise 2: From directed to undirected

_Driver: **B**_

As you may recall, Prim's algorithm is intended to work with undirected graphs, rather than directed graphs.  

How will you accommodate that issue in your code?

### Exercise 3: Parts of Prim's algorithm

_Driver: **A**_

As you may recall, Prim's algorithm relies on two structures (beyond the graph): a priority queue of edges left to process and a collection of the edges already determined to be in the MST.  We'll call the first thing `REMAINING` and the second `mst`.

The algorithm goes something like the following.

```text
Pick a random vertex
Add all of the edges from that vertex to REMAINING
While edges remain
  Grab the remaining edge with the lowest weight
  If either vertex is not in the minimum-spanning tree
    Add the edge to MST
    Add all the edges from that vertex to REMAINING
      (arguably, you should only add those that don't lead back to the MST)
```

How will you implement each of the following steps? Make sure to take notes.

a. Represent the MST.  (Remember it's a collection of edges.)

b. Pick a random vertex.

c. Grab the remaining edge with lowest weight.

d. Determine if a vertex is in the MST.

e. Print out the MST.

### Exercise 4: Implementing Prim's algorithm

_Driver: **B**_

Implement Prim's algorithm.  If you are unsure about any of the steps suggested above, you can discuss them with your instructor or mentor, review our suggestions at the end of this lab, or both.

You'll note that we've left it explicitly unstated as to where you implement Prim's algorithm and what parameters it should take. You are at the stage of your career where you should be able to consider reasonable alternatives.

### Exercise 5: Testing your implementation

_Driver: **A**_

Write some experiments or tests to see how well your implementation works.

For those with extra time
-------------------------

If you find that you have extra time, implement Kruskal's MST algorithm.

Suggested strategies
--------------------

### Undirected graphs

To deal with non-directional edges, we can just make sure that we always add pairs of edges (both directions).  Once an edge is in the MST, it doesn't matter what it's direction is.

* Option 1: Add an `addUndirectedEdge` method to the `Graph` classwhich
  adds directed edges in both directions.
* Option 2: Subclass the `Graph` class and override `addEdge` to add
  directed edges in both directions..
* Option 3: Use the `UndirectedGraph` class, which does the same thing
  as option 2 for you.

### Remaining edges

You can use a `[java.util.PriorityQueue](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/PriorityQueue.html)` of `Edge` objects to keep track of which edges remain.  You'll need to supply a `Comparator` for `Edge` objects, which will look something like the following:

    (e1,e2) -> e1.weight().compareTo(e2.weight())

### Edges in the MST

You can use an `ArrayList` to keep track of the edges in the MST.

### Vertices in the MST

You can determine whether or not a vertex is in the MST by marking vertices in the graph as they are added to the MST.  (Note: You will need to clear the marks before you begin.)

### Your starting vertex

If you are implementing Prim's algorithm within the `Graph` class (or one of its descendants), you can randomly select a non-null element from `vertices`.  Alternately, you can choose the first (or last) non-null element.

### Printing values

Since `ArrayList` objects have a `toString` method, you don't need to do anything special to print out the MST.

### Where to put Prim's

There are two basic options to where you should put your implementation of Prim's

You could create a new class (e.g., `GraphAlgorithms`) and put it there. 

You could put it within the `Graph` class.

I suppose you could put it within the `Edge` class, but that seems the least sensible option.

Personally, I prefer creating a new class.

### Parameters

What parameters should Prim's have? It could take a graph as a parameter. It could take a list of edges as a parameter. It could take the name of a file that contains a list of edges as a parameter.
