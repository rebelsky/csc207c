---
title: "Eboard 26 (Section 1): Graphs"
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
* The shortest path algorithm
* Lab(s)

Preliminaries
-------------

### News / Notes / Etc.

* Class work
    * I have dropped MP 11.
    * I have dropped one of the LAs (design patterns).
    * Because I have not caught up on tokens, everyone has infinitely 
      many tokens.  (You may not use tokens to make up for missing readings, 
      labs, pre-reflections, or post-reflections.)
    * I've added redos for all the mini-projects so that you can fix things 
      you already know are wrong (or submit them if you did not submit
      them the first time).
    * The graders are still working on catching up. They've been hit by
      end-of-semester busy-ness.
* Preregistration
    * Multiple second-years did not get a CS class in the spring. I don't
      know how many. The CS department isn't happy about this result, but
      don't really have a way to address it.
    * We plan to have more faculty next year, so we hope that (a) we won't
      have the problem again and (b) those who need two courses next year
      will be able to get two courses.
* Lots of TPS today to prepare you for lab

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

#### Multicultural

* Friday, 2024-12-06, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: ???_ 

#### Peer

* Friday and Saturday, Wall Theatre.
  _One-act festivals_
* Friday and Saturday, all day (1 hour suffices), Osgood Natatorium.
  _Pioneers Swim Meet_
* Sunday, 2:00 p.m., Sebring-Lewis.
  _Grinnell Singers_

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

> No.

### MP10

**Are there tests for MP10?**

> Nope.

### Graphs

### Miscellaneous

Graph traversal
---------------

_TPS_

Suppose you start at one vertex in the graph and want to find all the vertices
you can reach from that vertex. What approach(es) might you take?

* Side note: We'll need to keep track of the nodes we've already visited
  so that we don't cycle forever. (I'll call this marking.)
* Approach one: Recurse on all the vertices you can reach from the current
  one.
* Approach two: Use a stack instead of recursion.
* Approach three: Use a queue instead of recursion.
* Note: Approaches one and two do a depth-first traversal of the graph.
  Approach three does a breadth-first traversal

```java
void traverseRecursive(PrintWriter pen, Vertex v) {
  if (!marked(v)) { // Probably not be necessary
    mark(v);
    pen.println(v);
    for (Vertex neighbor : v.neighbors()) {
      if (!marked(neighbor)) {
        traverseRecursive(pen, neighbor);
      } // if
    } // for
  } // if
} // traverseRecursive
```

How is graph traversal similar to tree traversal?

* We start at one vertex and move to "children".

How is graph traversal different than tree traversal?

* We have to keep track of "marked" vertices so that we don't repeat
  a vertex.
* Trees don't have cycles.

Dijkstra's shortest path algorithm
----------------------------------

_TPS_

What is a shortest path?

* Inputs: Two vertices in a graph, source and sink; a (directed) weighted
  graph with only non-negative edges
* Outputs: A path from source to sink, if it exists
* Characteristics: The sum of the edge weights on the path is less than
  of equal to the sum of the edge weights on any other path from source to
  sink.

What are the core ideas of Dijkstra's algorithm?

* Work your way out from the source
* Keep track of the distance to every vertex we can (potentially) reach
* NO: Choose the least weighted edge at every step
* YES: Choose the nearest vertex
* We'll probably have to mark nodes as we go

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

### a. How will you represent the distance (sum of edge weights) from the source to each vertex?

* An array that maps vertex number to distance. [Good]
* If we are storing the path, we could recalculate at each step (expensive)
* A hash table that maps vertex to distance.

### b. How will you represent the (shortest) path to each vertex?

* A list of edges / vertices from start to the vertex.
    Each time, we probably have to do something like path.clone().append(edge).
* An array that maps vertex number to predecessor on the shortest path. [Good]

### c. How will you efficiently "find the nearest unmarked vertex", particularly given that the distance of vertices can change?

* Look through the array from a using the "obvious" algorithm. O(n) [Good]
* Use a heap, where priority is shorter distance O(logn)
    * Unfortunately, priorities changes

### d. How will you mark vertices?

* We have a `mark` method in the Graph class.

Labs
----

Two labs today!

Make sure that your repo ends with `-maven`.

I don't know why VSCode won't let you run the code.

If you're using marks, it's probably a good idea to clear all of the marks
at the beginning (or the end) (or both).

If you're writing an iterator for reachable, you'll probably need a stack or
a queue for the unprocessed reachable nodes.

Same partners next class (and maybe next Thursday). You'll work on shortest 
path and then MST.
