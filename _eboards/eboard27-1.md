---
title: "Eboard 27 (Section 1): Minimum spanning trees"
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
      New LAs from SoLA 12, MP 8, SoLA 12
* Today is another "Let's make sure you've thought about things before
  beginning lab" day.

### Upcoming work

* Thursday, 2024-12-12
    * MP redos
* Sunday, 2024-12-14
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

* Thursday, 2024-12-12, 4:00--5:00 p.m., Science ????
  _CS Extras_

#### Cultural

#### Multicultural

#### Peer

* Monday, December 16, 2:30--4:30pm, The HSSC Kernel.
  _FGLI Study Break (with hot cocoa and apple cider)_

#### Wellness

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

> Almost certinaly.

**Can I turn in third redos even if I don't turn in the second redo?**

> Of course.

**Do third redos cost tokens?**

> Yes. All redos after the first cost tokens. However, you have infinte
  tokens.

**So the only thing that will affect my grade based on LAs and MPs
  are the missing labs, readings, and metas?**

> Yes.

**How many LAs are there?**

> Whoops. There are 49. Since I miscounted, I'm not increasing the LA
  requirements for each grade. (You should, of course, all strive for
  49.)

**How do I make an appointment with you?**

> Suggest a time on Outlook scheduler.

> Email me to see when I'm available.

> Talk to me after class.

**Will SoLA 12 be graded before SoLA 13?**

> Yes.

**If I have something ungraded from an old SoLA, what should I do?**

> Let me know. I didn't think I missed anything.

**I don't remember implementing priority queues. What should I do on
  the LA?**

> It's fine if you summarize a design you made.

### Graphs

**Does it matter where we start in Prim’s algorithm?**

> Nope. It works with any starting vertex.

**When is Kruskal’s better than Prim’s, or the other way around?**

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

A spanning tree is a tree that connects all of the vertices in the graph.

A minimum spanning tree is the smallest of all such trees for that graph.

We normally look for MSTs in undirected weighted graphs.

Prim's
------

_TPS_

```text
Pick a random vertex
Add the shortest edge from that vertex to the MST
Repeatedly:
  Add the shortest edge attached to the partial MST that doesn't create
    a cycle
Until all vertices are in the MST.
```

How do we (efficiently) tell if we have a cycle?

* Mark nodes when we add them to the MST, so we can just check whether
  both ends of a candidate edge are marked.

Kruskal's
---------

_TPS_

Basic algorithm?

```text
Repeat
  add the shortest edge that won't form a cycle
Until we've added n-1 edges
```

How do we (efficiently) tell if we have a cycle?

* Does the marking algorithm work? No!
* Use a special mark for each tree
    * Somehow, combine those marks when we connect two trees
    * Go through the whole combined tree, remarking: O(n)
* Use your favorite tree traversal algorithm to see if there is a path
  from the vertex at one side of the edge to the vertex at the other
  side of the edge: O(n)
* Take 301: Make the special mark take O(logn) or even expected less
  than that. "Union Find"

Greed as a design strategy
--------------------------

Problem: Find the "optimal" something (shortest)

Strategy: Pick the "local" optimum

For example, when making change in the US, if you want the fewest coins,
you first take as many quarters as possible, then as many dimes, then
as many nickles, and then the pennies.

83 cents: three quarters, leaves 8 cents, one nickle, leaves three cents,
  three pennies.

Is there another situation in which we repeatedly find the smallest/largest
in order to solve a problem?

* Part of heap down: We swap with the higher-priority child.
* Selection sort: Repeatedly find the smallest remaining value

We now have two "big picture" design strategies:

* Greed
* Divide and conquer

Implementing Prim's MST Algorithm
---------------------------------

```text
Pick a random vertex
Add all of the edges from that vertex to REMAINING
While edges remain
  Grab the remaining edge with the lowest weight
  If either vertex is not in the minimum-spanning tree
    Add the edge to MST
    Mark both vertices
    Add all the edges from that vertex to REMAINING
      (arguably, you should only add those that don't lead back to the MST)
```

_TPS_

Assume that you have full access to the `Graph` class that I provided (e.g., that you can even look at the internals).

a. What will you use for the priority queue? (Hint: Look at preexisting
Java libraries.)

b. What comparator will you use to order edges by weight?

c. Prim's requires undirected graphs. How will you accommodate that issue?

d. How will you represent the MST?

e. How will you pick a random starting vertex?

f. How will you grab the remaining edge with lowest weight?

We have a priority queue. Duh

g. How will you determine if a vertex is in the MST? 

Marking.

h. How will you print out the MST?

Lab
---

Do the Dijkstra's lab first.  If you happen finish, try the MST lab.
