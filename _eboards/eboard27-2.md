---
title: "Eboard 27 (Section 2): Minimum spanning trees"
number: 27
section: eboards
held: 2024-12-10
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
* Minimum spanning trees
* Prim's algorithm
* Kruskal's algorithm
* Greed as algorithm design strategy
* Preparing to implement Prim's
* Lab(s)

Preliminaries
-------------

### News / Notes / Etc.

* Class work
    * Partial grade reports distributed last night
    * MP5 and MP6 returned
    * Next on grader's grading schedule: MP 7, MP 9
    * Next on Sam's grading schedule: Remaining labs, readings, metas.
      New LAs from SoLA 12, MP 8, SoLA 12, MP10.
    * Next up on someone's grading schedule: Redo of MP3 and MP4.
* Today is another "Let's make sure you've thought about things before
  beginning lab" day.

### Upcoming work

* Thursday, 2024-12-12
    * MP redos
* Sunday, 2024-12-15
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
        * No new LAs.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Thursday, 2024-12-12, 4:00--5:00 p.m., Science ????
  _CS Extras_

#### Cultural

#### Multicultural

#### Peer

#### Wellness

* Monday, December 16, 2:30--4:30pm, The HSSC Kernel.
  _FGLI Study Break (with hot cocoa and apple cider)_

#### Misc

### Other good things (no tokens)

Questions
---------

### Administrative

**I've missed way too many readings / labs / metas. What do I do?**

> Let's chat.

**The reports are missing the most recent labs, readings, and metas, right?**

> Yes.

**Can I assume that if I turned in a lab, reading, and/or meta, I'm getting
  a satisfactory for it?**

> Almost certainly.

**Can I turn in third redos even if I don't turn in the second redo?**

> Of course.

**Do third redos cost tokens?**

> Yes. All redos after the first cost tokens. However, you have infinte
  tokens.

**So the only thing that will affect my grade based on LAs and MPs
  are the missing labs, readings, and metas?**

> Yes.

**How many LAs are there?**

> I thought there were 47. Whoops. There are 49. Since I miscounted, 
  I'm not increasing the LA requirements for each grade. (You should, 
  of course, all strive for 49.)

**How do I make an appointment with you?**

> Suggest a time on Outlook scheduler.

> Email me or Teams Message me to see when I'm available.

> Talk to me after class.

**Will SoLA 12 be graded before SoLA 13?**

> Yes.

**If I have something ungraded from an old SoLA, what should I do?**

> Let me know. I didn't think I missed anything.

**I don't remember implementing priority queues. What should I do on
  the LA?**

> It's fine if you summarize a design you made.

Have the MP3 and MP4 redos been graded yet?

> No.

What if I didn't reuse any code on a mini-project or lab?

> So you didn't use any of Sam's code?

> Or any of Prof. Baker's code?

What if I didn't reuse that code ethically?

> It's good that you only need to get 45/49.

> And work on your ethics.

> You could also write "I should have ..."

There are some MPs that have not been returned but nonetheless have
a grade on the grade report.

> Computers are sentient and malicious.

> Don't panic.

### Graphs

**Does it matter where we start in Prim's algorithm?**

> Nope. It works with any starting vertex.

**When is Kruskal’s better than Prim's, or the other way around?**

> Whichever we can more easily implement is better.  (Alternately, 
  whichever of our implementations generally runs faster is better.)

> I find Prim's easier to implement, since we need more structures
  to check for cycles.

**Can you explain more of what's meant by weighted and unweighted/directed
and undirected?**

> Weighted: Each edge has a weight which represents the "cost" of following
  that edge.

> Unweighted: No weight on edges (all are the same).

> Directed: Edgs are "one-way" (like one-way streets).

> Undirected: Edges are two-way.

**Maybe give more visual examples to help explain, for instance, the
minimum spanning tree?**

> Yes.

**Do these algorithms work with all values, zero or greater, or only 
  positive values?**

> Zero or greater. We generally require that the graph have only non-negative 
  values to find an MST.

> You can always convert a graph with negative edges to one with nonnegative
  edges by adding the inverse of the smallest value.

### Miscellaneous

MSTs
----

_TPS_

* Spanning tree is a collection of edges that connect all the vertices.
    * There are no cycles, so it can be interpreted as a tree.
* Minimum spanning tree is the smallest of all spanning trees for the
  graph.

Prim's
------

_TPS_

```text
pick a vertex
pick the smallest weight edge from that vertex
add the edge to the MST
repeatedly
  find the smallest weight edge out of the MST 
  if the edge does not lead back to the MST
    add that edge to the MST
until all of the vertices are in the MST
```

How do we tell if an edge leads back to the MST?

> Option 1: Store a HashSet of vertices in the tree. Expected O(1)

> Option 2: We can iterate the list of the edges, seeing if there's
  an edge. O(n)

> Option 3: Mark vertices. O(1)

Kruskal's
---------

_TPS_

Basic algorithm

Kind of like Prim's, except we build a forest instead of a single tree

```text
while there are disconnected vertices
  add the smallest edge that doesn't create a cycle
```

How do you tell if you've created a cycle?

* Union-Find, but we don't understand that. O(logn) (or even better,
  with some improvements)
* We could mark each tree in the forest with a different mark
    * When we combine two trees, we remark all of the vertices with
      a new tree mark O(n)
* We could do a tree traversal to see if we can get from the vertex
  at one end of the edge to the other end of the edge O(n)

That's hard, so we're going to skip implementing this algorithm 

Greed as a design strategy
--------------------------

When trying to find "the largest" or "the smallest", it is often good
practice to grab something that seems locally "largest" or "smallest".

* Prim's: Smallest attached thing
* Kruskal's: Smallest thing overall
* Shortest path: Choosing the smallest "next" edge doesn't work.
* Shortest path: Choosing the "nearest neighbor" does work.

Second major design strategy. (Our first was: Divide and conquer.)

Are there other algorithms that have something like "greed" as an approach.

* Selection sort - Repeatedly grabs largest or smallest value.
* Heaps make it easy for us to grab the largest or smallest value.

Implementing Prim's MST Algorithm
---------------------------------

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

_TPS_

Assume that you have full access to the `Graph` class that I provided (e.g., that you can even look at the internals).

a. How can we tell if a vertex is in the MST?

We can mark vertices when we add them.

b. Prim's requires undirected graphs. How will you accommodate that issue?

We can use the undirected edges in the graph class. (We hope they are there.)

Alternately, add two directed edges going in opposite directions for each
undirected edge.

c. How will you represent the MST?

A linked list or arraylist of edges that are in the MST.

d. How will you pick a random starting vertex?

e. How will you grab the remaining edge with lowest weight?

We could put all the remaining edges in a list and search that list.

We could put all the remaining edges in a priority queue (heap) and use its
`get` method.

f. How will you print out the MST?

Lab
---

Do the Dijkstra's lab first.  If you happen to finish, try the MST lab.

Dijkstra's questions
--------------------

```text
To find the shortest path from SOURCE to SINK,
  Indicate that all vertices have infinite distance from SOURCE
  Indicate that SOURCE has a distance of 0 from itself
  While unmarked(SINK) and there exists an unmarked node with finite distance fr
om SOURCE
    Find the nearest unmarked vertex, U
    Mark U
    For each unmarked neighbor, V, of U
      If distanceTo(U) + edgeWeight(U,V) < distanceTo(V)
        Note that the best known path to V is the path to U plus the
          edge from U to V.
        Update the distance to V
  Report the path to SINK, if there is one
```

**How are you keeping track of the best known distance to each vertex?**

An array of distances, indexed by vertex number.

```
int[] distances = new int[vertices.length];
```

or

```
Integer[] distances = new Integer[vertices.length];
```

**How are you keeping track of the path that gives that distance?**

```
// The preceding vertex in the shortest path to each vertex
int[] prevNode = new int[vertices.length];
```

or

```
// The last edge in the shortest path to each vertex
Edge[] incoming = new Edge[vertices.length];
```

**How are you finding the nearest unmarked vertex?**

We have the things above and ...

We keep track of the best one we've seen.

We use a for loop to iterate through the `distance` array.

At each point, we make sure that the distance is not "infinity" and
that the node is not marked. If so, we compare to the best we've seen.

**How are you finding all the edges from a vertex?**

We use `Graph.edgesFrom(vertex)`.
