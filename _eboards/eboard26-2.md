---
title: "Eboard 26 (Section 2): Graphs"
number: 26
section: eboards
held: 2024-12-05
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
    * Questions
* Tree traversal
* Dijskstra's shortest path algorithm
* Lab(s)

Preliminaries
-------------

### News / Notes / Etc.

* Class work
    * The graders are still working on catching up. They've been hit by
      end-of-semester busy-ness.
    * I have dropped MP 11.
    * I have dropped one of the LAs (design patterns).
    * Because I have not caught up on tokens, everyone has infinitely 
      many tokens.  (You may not use tokens to make up for missing readings, 
      labs, pre-reflections, or post-reflections.)
    * I've added redos for all the mini-projects so that you can fix things 
      you already know are wrong (or submit them if you did not submit
      them the first time).
* Preregistration
    * Multiple second-years did not get a CS class in the spring. I don't
      know how many. The CS department isn't happy about this result, but
      don't really have a way to address it.
    * We plan to have more faculty next year, so we hope that (a) we won't
      have the problem again and (b) those who need two courses in one
      semester next year will be able to get two courses.
* Lots of TPS today to prepare you for labs.

### Upcoming work

* Thursday, 2024-12-05
    * [MP 10](../mps/mp10) due.
    * [Submit MP10 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5380849)
* Friday, 2024-12-06
    * [Submit post-reflection for MP10](https://www.gradescope.com/courses/818402/assignments/5380852)
* Monday, 2024-12-09
    * Reading: Two algorithms for minimum spanning trees
        * [Wikipedia: Prim's Algorithm](https://en.wikipedia.org/wiki/Prim%27s_algorithm)
        * [Wikipedia: Kruskal's Algorithm](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm)
    * [Submit reading response for class 27](https://www.gradescope.com/courses/818402/assignments/5413491)
    * [Submit lab writeup from class 26](https://www.gradescope.com/courses/818402/assignments/5413493)
    * [SoLA 12](../los/sola12) due
        * New: [ADT/DS #1: Lists](https://www.gradescope.com/courses/818402/assignments/5412255)
        * New: [ADT/DS #4: Priority queues](https://www.gradescope.com/courses/818402/assignments/5402118)
        * New: [ADT/DS #6: Hash tables](https://www.gradescope.com/courses/818402/assignments/5402119)
        * New: [ADT/DS #8: Heaps](https://www.gradescope.com/courses/818402/assignments/5402114)
        * New: [Algorithms #5: Heap sort](https://www.gradescope.com/courses/818402/assignments/5402117)
        * Dropped: OOP #07: Design Patterns
* Thursday, 2024-12-12
    * MP redos
* Saturday, 2024-12-14
    * Late MP redos
* Monday, 2024-12-16
    * [SoLA 13](../los/sola13) due
        * New: ADT/DS #9: Graphs
        * New: Algorithms #8: Graph and tree traversal
        * New: Algorithms #9: Shortest path
        * New: Algorithms #10: Greed
        * New: Algorithms #11: Divide and conquer
* Friday, 2024-12-20
    * MP redos
    * [SoLA 14](../los/sola14) due.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Thursday, 2024-12-05, 4:00--5:00 p.m., Science 3821
  _CS Extras_
* Sunday, 2024-12-08, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_

#### Cultural

* Friday and Saturday, Wall Theatre.
  _One-act festivals_
* Sunday, 2:00 p.m., Sebring-Lewis.
  _Grinnell Singers_

#### Multicultural

* Friday, 2024-12-06, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: ???_ 

#### Peer

#### Wellness

* Friday, 2024-12-06, 9:00 a.m.--3:00 p.m., CRSSJ.
  _Holiday baking_.
* Saturday, ???, Harris.
  _Winter Waltz_

#### Misc

* Friday, 2:30--3:50 p.m, HSSC N1112
  _Alumni Careers: Albert Owusu-Asare_
  **Sam recommends highly.**

### Other good things (no tokens)

Questions
---------

### Administrative

**Can we get an I on an MP and still get an A?**

> No. You must get to R on all your MPs (and to E and M on some).

### MP10

**Are there tests for MP10?**

> Nope.

**Can we ignore Sam's checkstyle issues?**

> Yes.

### Graphs

### Miscellaneous

Graph traversal
---------------

_TPS_

Suppose you start at one vertex in the graph and want to find all the vertices
you can reach from that vertex. What approach(es) might you take?

* Note: We'll have to keep track of what we've gone through because there
  may be loops. ("Marked" - `marked(Vertex v)` and `mark(Vertex v)`
  and `unmark(Vertex v)`)
* We'll want to grab all of the neighbors of a vertex and traverse them.
* We could use a stack (or a queue) or we could use recursion.

```java
void printReachable(PrintWriter pen, Vertex v) {
  unmarkAll();
  printReachableHelper(pen, v);
} // void

void printReachableHelper(PrintWriter pen, Vertex v) {
  List<Vertex> neighbors = v.getNeighbors();
  mark(v);
  pen.println(v);
  for (Vertex neighbor : neighbors) {
    if (!marked(neighboard)) {
      printReachableHelper(pen, neighbor);
    } // if
  } // for
} // printReadable(PrintWriter, Vertex)
```

How is graph traversal similar to tree traversal?

* They are really similar. The same goal of going through all the nodes
* The algorithms are essentially the same (if we ignore marking).

How is graph traversal different than tree traversal?

* In binary search trees, we have a fixed approach (we are just looking
  for a particular value).
* In graphs, we can have more than two neighbors, while in binary trees
  we have at most two children (and one parent).
* Graphs can loop back on themselves: Hence, we need to ensure that we
  don't repeat values. (Mark needed.)
* In graphs, we can start traversal anywhere; in trees, we start at the root.

Dijkstra's shortest path algorithm
----------------------------------

_TPS_

What is the shortest path problem?

* Inputs: A weighted (directed) graph, a starting point and an ending point.
* Outputs: A path from the starting point to the ending point (assuming
  one exists)
* Characteristics: This path is no longer than any other path ("shorter than")

What are the core ideas of Dijkstra's algorithm?

* NO: Choose the shortest edge we haven't used yet
* Keep track of the shortest distance we've found to each vertex.
* Choose the shortest of those distances (of the unmarked vertices).

### The algorithm

```text
To find the shortest path from SOURCE to SINK,
  Indicate that all vertices have infinite distance from SOURCE
  Indicate that SOURCE has a distance of 0 from itself
  While unmarked(SINK) and there exists an unmarked node with finite distance from SOURCE
    Find the nearest unmarked vertex, U
    Mark U
    For each unmarked neighbor, V, of U
      If distanceTo(U) + edgeWeight(U,V) < distanceTo(V)
        Note that the best known path to V is the path to U plus the
          edge from U to V.
        Update the distance to V
  Report the path to SINK, if there is one
```

Implementing Dijkstra's shortest path algorithm
-----------------------------------------------

_TPS_

Assume that you have full access to the `Graph` class that I provided (e.g., that you can even look at the internals).

### a. How will you represent/store the distance (sum of edge weights) from the source to each vertex?

* Add an integer field to our vertex class.
    * Unfortunately, we have no vertex class in our Graph implementation.
* Use a hash table or other dictionary implementation to map vertices
  to distances.
* In the graph implementation, vertices are generally represented as
  small integers.
    * We could just use an array to map vertices to distances.

### b. How will you represent/store the (shortest) path to each vertex?

* Array of lists, where the lists represent the paths
* Just the prior node, because we can follow them back to the root.

### c. How will you efficiently "find the nearest unmarked vertex", particularly given that the distance of vertices can change?

* Scan through the values in distance, only paying attention to the unmarked
* Keep a list of unmarked, scan through the values in that, looking up
  distances in the distance table.
* Both of those are O(n)
* Finding the nearest unmarked vertex could be a job for a priority queue
* We could use a heap, which gives us O(logn).
* However, priorities change.
* So you'll probably just scan the array of distances.

### d. How will you mark vertices?

* Use sets
* Use the `mark` method in the Graph class.

### e. Is there a value for "box" in our example that makes it possible to
have a shorter path from A to D?

* Yes, a negative number. Hence, we restrict ourselves to graphs with
  non-negative edge weights.

Labs
----

Two labs today! You'll probably only get one (or less) done.

Make sure that your repo ends with `-maven`.

I don't know why VSCode won't let you run the code.

If you're using marks, it's probably a good idea to clear all of the marks
at the beginning (or the end) (or both).

If you're writing an iterator for reachable, you'll probably need a stack or
a queue for the unprocessed reachable nodes.

Same partners next class (and maybe next Thursday). You'll work on shortest 
path and then MST.
