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
    * Next on Sam's grading schedule: New LAs from SoLA 12, MP 8, SoLA 12
* Today is another "Let's make sure you've thought about things before
  beginning lab" day.

### Upcoming work

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

* Thursday, 2024-12-12, 4:00--5:00 p.m., Science ????
  _CS Extras_

#### Cultural

#### Multicultural

#### Peer

#### Wellness

#### Misc

### Other good things (no tokens)

Questions
---------

### Administrative

**I've missed way too many readings / labs / metas. What do I do?**

> Let's chat.

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

> Yes.

**Maybe give more visual examples to help explain, for instance, the
minimum spanning tree?**

> Yes.

**Do these algorithms work with all values, zero or greater, or only positive values?**

> Zero or greater. We generally require that the graph have only non-negative 
  values to find an MST.

. You can always convert a graph with negative edges to one with nonnegative
  edges by adding the inverse of the smallest value.

### Miscellaneous

MSTs
----

Prim's
------

Kruskal's
---------

Greed as a design strategy
--------------------------

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

a. What will you use for the priority queue? (Hint: Look at preexisting
Java llibraries.)

b. What comparator will you use to order edges by weight?

c. Prim's requires undirected graphs. How will you accommodate that issue?

d. How will you represent the MST?

e. How will you pick a random starting vertex?

f. How will you grab the remaining edge with lowest weight?

g. How will you determine if a vertex is in the MST?

h. How will you print out the MST.

Lab
---
