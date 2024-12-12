---
title: "Eboard 28 (Section 2): Wrapping up"
number: 28
section: eboards
held: 2024-12-12
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
* The semester in review
* Collaborative activity, part one
* EOCEs
* Collaborative activity, part two
* Nearly final thoughts
* Lab(s)

Preliminaries
-------------

### News / Notes / Etc.

* WARNING! Friday the 13th falls on a Friday this month.
* We have a somewhat mixed up schedule for the last day of class.
  I'm going to give final thoughts *before* your return to the 
  shortest path lab. That way, those who don't want to stay and finish
  the lab don't have to.
* As I mentioned in email, missing readings, labs, and metacognitive
  reflections will not affect your final grade. That means that I will
  base your final grade only on the number of LAs you satisfactorily
  complete and the distribution of your MPs.
* Since a few folks accidentally submitted to the "final chance" MPs, I've
  hidden those until Monday morning.
* Optimistic grading plans
    * Friday: SoLA 12
    * Saturday: MP 8 (40 submissions x 15 min/submission = 10 hours)
    * Sunday, MP 10 (see above)
    * Monday and Tuesday: SoLA 13, MP redos
* Going through the post reflections, I saw a lot of "I should have asked
  questions earlier" (and a few "I'm glad I asked questions of Sam/the
  evening tutors/the mentors"). Feel free to reach out with questions,
  particularly on Teams. If I don't respond within 12 hours, ping me.

### Upcoming work

* Thursday, 2024-12-12
    * MP redos
* Sunday, 2024-12-15
    * Late MP redos
* Monday, 2024-12-16
    * [SoLA 13](../los/sola13) due
        * [ADT/DS #9: Graphs](https://www.gradescope.com/courses/818402/assignments/5442577)
        * [Algorithms #8: Graph and tree traversal](https://www.gradescope.com/courses/818402/assignments/5442584)
        * [Algorithms #9: Shortest path](https://www.gradescope.com/courses/818402/assignments/5442590)
        * [Algorithms #10: Greed](https://www.gradescope.com/courses/818402/assignments/5442593)
        * [Algorithms #11: Divide and conquer](https://www.gradescope.com/courses/818402/assignments/5442594)
        * If you notice any LA redo opportunities missing, please let me know.
* Friday, 2024-12-20, 5:00 p.m.
    * MP redos
    * [SoLA 14](../los/sola14) due.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Thursday, 2024-12-12, 4:00--5:00 p.m., Science ????.
  _CS Extras_
* Sunday, 2024-12-15, 7:00--8:00 p.m., Science 3819.
  _Mentor Sessions_

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

**When you finish grading SoLA 12, will we get another grade report?**

> Yes.

**When you finish grading SoLA 13, will we get another grade report?**

> Yes.

**When you finish grading SoLA 14, will we get another grade report?**

> Yes.

**If we need help finishing a lab, who do we ask for help?**

> Evening tutors, if they are available.

> Sam on Teams.

> Classmates.

**What happens if the graders don't grade MP7 and MP9 promptly?**

> Sam will probably work longer days and catch those up.

**Can we have another mentor session during finals week?**

> DM me if you'd like one, and I'll consider it.

**If we forgot the `CHANGES.txt` files on previous redos, should we resubmit?**

> Nah.

### Graphs

**When would we use these algorithms?**

> Dijkstra's algorithm is likely at the root of Google Maps and such.

> MSTs might be used to decide which streets to prioritize in case of
  a snowstorm so that emergency workers can reach every house (or
  at least every corner).

> MSTs can also be used to prioritize connections to restore in an
  electrical grid.

**Can you tell me more about the "fail fast" policy for iterators?**

> If we change a graph (or any structure, for that matter) while we're 
  iterating it, the iterator may no longer correctly show the rest
  of the graph (structure). A "fail fast" policy suggests that as soon
  as the graph changes, the iterator should become invalid and report
  so.

**How else might we represent a graph?**

> Another common approach is to use an adjacency matrix, a matrix whose
  rows and columns are labeled with vertex names/numbers and whose values
  are the distance between the two vertices.

> We could also use nodes and a linked structure.

**Why would we choose one representation over another?**

> The approach we used in class (a variant of adjacency lists) is good
  when you want to iterate edges (either edges from particular nodes
  or all edges). However, it's not as good when you want to pick pairs
  of vertices and find the distance between them.

> Adjacency matrices are good when you want to find the distances between
  pairs of vertices (it's O(1)). However, they require a lot of space
  and are not quite as efficient for iterating edges.

> I'm sure that at this point in your career, you can perform similar
  analyses.

### Miscellaneous

The semester in review
----------------------

See the list of LOs. There are fifty! of them.

But we've also learned some other things ...

* Java
    * Lambdas
    * For-each
    * Anonymous inner classes [x2]
    * ...
* Broader things
    * How to show someone that you understand a (programming) topic
    * You have awesome classmates
    * You should pay attention to your wellness
    * ...
* Other
    * Debugging ...
    * Using GitHub (not just the collaboration thing, but broader things)
        * Using Git well so that your collaborator doesn't hate you
        * Push regularly, don't push broken code, consider branching
    * Drawing diagrams can help you better understand code
    * Reach out and ask questions when you get stuck; if you're stuck for
      ten minutes, you'll probably still be stuck ten hours later
    * When you don't want to answer questions, go to the bathroom
    * Collaboration practices 
    * Optimizing (or at least improving) algorithms
    * Manage time efficiently [x2]
    * Using remote.cs.grinnell.edu
    * Style!
    * "UH" - "Use Help"
    * "UM" - "Use Math"
    * How to read your old code for ideas (or LA solutions)
    * Decomposition (Practice)

Collaborative activity, part one
--------------------------------



EOCEs
-----

Collaborative activity, part two
--------------------------------

Nearly final thoughts
---------------------

Lab: Dijkstra's shortest path
-----------------------------

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

**How might you keep track of the best known distance to each vertex?**

An array of distances, indexed by vertex number.

```
int[] distances = new int[vertices.length];
```

or

```
Integer[] distances = new Integer[vertices.length];
```

**How might you keep track of the path that gives that distance?**

```
// The preceding vertex in the shortest path to each vertex
int[] prevNode = new int[vertices.length];
```

or

```
// The last edge in the shortest path to each vertex
Edge[] incoming = new Edge[vertices.length];
```

or

```
// The shortest known path to each vertex
List<Edge> shortestPaths = new List<Edge>[vertices.length];
```

**How might you find the nearest unmarked vertex?**

We use a for loop to iterate through the `distances` array.

At each point, we make sure that the distance is not "infinity" and
that the node is not marked. If so, we compare to the best we've seen.

**How might you find all the edges from a vertex?**

We use `Graph.edgesFrom(vertex)`.

