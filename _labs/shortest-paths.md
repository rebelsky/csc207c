---
title: Shortest paths
repo: <https://github.com/Grinnell-CSC207/graphs>
summary: |
  We explore techniques for finding the shortest path in a graph.
current: true
---
Preparation
-----------

If you haven't done so already, fork and clone the repository at {{ page.repo }} and then import it into your IDE.

Exercises
---------

### Exercise 1: Prim's algorithm

If you have not done so already, implement Prim's algorithm.  See [the prior lab](../labs/minimum-spanning-trees) for details.

### Exercise 2: Planning for Dijkstra's algorithm

As you may recall, Dijsktra's algorithm works something like the following:

```text
To find the shortest path from SOURCE to SINK,
  Indicate that all vertices have infinite distance from SOURCE
  Indicate that SOURCE has a distance of 0 from itself
  While unmarked(SINK) and there exists an unmarked node with finite distance
    Find the nearest unmarked vertex, U
    Mark U
    For each unmarked neighbor, V, of U
      If distanceTo(U) + edgeWeight(U,V) < distanceTo(V)
        Note that the best known path to V is the path to U plus the
          edge from U to V.
        Update the distance to V
  Report the path to sink, if there is one
```

a. How will you represent the path to each vertex?

b. How will you represent the distance (sum of edge weights) from the
source to each vertex?

c. How will you "find the nearest unknown vertex", particularly
given that the distance of vertices can change?

d. How will you mark vertices?

### Exercise 3: Implementing Dijkstra's algorithm

Implement a method, `shortestPath(int source, int sink)`, that finds the shortest path from `source` to `sink` in the current graph.

If you're unsure about how to deal with various aspects of the algorithm, you can find some notes at the end of this lab.

### Exercise 4: Experiments

Write a few experiments or tests to ensure that your implementation does, indeed, find the shortest path.  You can likely find some good graphs by doing a Web search for "shortest path example".  (Make sure to cite!)

For those with extra time
-------------------------

If you find that you have extra time, implement Kruskal's MST algorithm.

Some notes on implementing Dijkstra's algorithm
-----------------------------------------------

### Finding "the nearest unknown vertex"

While it is tempting to use Java's built-in
[`PriorityQueue`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/PriorityQueue.html)
for our collection of unmarked neighbors, there are some subtleties involved.  As we noted, the priority of a vertex can change as we find new paths.  How do we handle that?  If we were using a heap and had a link to the node in the heap, we could "heap up" from that location.  Of course, that changes the positions of other nodes, which would be problematic.

One strategy is to do without the `PriorityQueue`, keep a list of unmarked vertices, and do a linear search on that list.

Another strategy is to use the `PriorityQueue`, but re-insert the vertex with its new priority each time we update the priority.  Doing so means that when we remove vertices from the queue, we will need to recheck their priority.

### Paths

You will likely find it easiest to represent the paths with an array of incoming edges, as we did in the `path` method in `Graph.java`.

### Other data structures

You will likely find it easiest to represent the distance as an array of integers.

To determine whether a vertex is known or unknown, you can either use the `mark` method or check whether there is an incoming edge to the vertex (using the array just mentioned).
