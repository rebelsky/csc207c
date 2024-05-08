---
title: "Eboard 41: MSTs"
number: 41
section: eboards
held: 2024-05-08
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Detour: LAs
* Two MST algorithms
* Questions
* Lab

Preliminaries
-------------

* You should have received an announcement about grading last night. In
  short.
    * Please do not spend time on MP redos. MPs will not negatively
      affect your grade.
    * Your grade will depend primarily on the number of LAs you get
      correct.
    * Everyone passes.
    * You can debate your grade with me.
* I will be working from home tomorrow afternoon, so office hours will be
  online.
* Please plan to show up for class on Friday! I'll make sure to reserve
  time at the start of Friday's class for LA questions.
    * If you will not be in class on Friday, I have a task for you to
      complete today.
* Friday will be LA questions + some debriefing + community task + 
  EOCEs. I'll make the EOCEs available after Friday's class for those
  of you who can't make it.

### Upcoming work

* Saturday, 2024-05-11, 11:00pm, New set of LAs, repeated + old LAs
* Tuesday, 2024-05-14, 11:00pm, LA redos
* Friday, 2024-05-17, 5:00pm, LA redos (final chance)

### Tokens

Academic

* Thursday, 2024-05-09, 4:00--5:00pm, Science 3819.  
  _CS Extras: Sarah Barks (Internships and Jobs)_

Cultural

* Most days, 2024-04-xx and 2024-05-xx, 11am-6pm,
  Grinnell College Museum of Art.
  _BAX 2024_. 

Multicultural

Peer

Wellness

* Friday, 2024-05-10, 5:00pm--??:??pm, Merrill Park West.
  _CS Picnic!_ 

Misc

### Other good things to do (no tokens)

### Other questionable things (no tokens)

LA Notes
--------

### Coding style

* **Decompose!** You learned decomposition in CSC-151. You should continue
  to decompose in all your coding. For example, insertion sort should 
  have an explicit `insert` method.
* **Don't repeat yourself!** I'm stunned at how many of you repeated the
  code for swapping again and again and again.
* **Document!** You methods should have documentation that explains what
  they are supposed to do and what they return. How else will your client
  know what your code is doing/returning? 
    * Also: Document any tricky bits within your code.
* **Use meaningful names!** There's rarely a good reason to use one-letter
  variable names.
* **Follow language standards.** For example, field names, variable names,
  parameter names, method names, and package names in Java should all 
  start with a lowercase letter (or, once in a while, with an underscore). 
  Class names, interface names, and type variables start with a capital letter.
    * Don't confuse your reader.

### Discussing recursion

I saw way too many narratives that included descriptions like this:

> The array to be sorted is divided into two halves recursively until each 
  subarray has only one element.

In discussing recursion, focus on what the recursive call is. The reader
should understand that the typical base case is one or two elements. For
most of the "divide and conquer" sorting algorithms, dividing until you
reach one element isn't the key idea. It's that you recursively sort the
two halves.

_Trust the magic recursion fairy!_

### Particular LAs

#### Divide and conquer

* **Decomposition** is the idea of breaking a complex problem into
  smaller parts.
* **Divide and conquer** is an algorithm design strategy related
  to decomposition, but that involves breaking the *input* into
  smaller parts.
* There are divide-and-conquer algorithms that do not involve sorting.

#### Loop invariants

* Loop invariants tell us something about the state of the system.
  (Usually something relatively formal.)
    * "State of the system" -> "values of variables"
    * We show that they hold before the loop begins.
    * We assume they hold at the start of each loop iteration.
    * We show that they hold at the end of each loop iteration.
* Loop invariants are *not* the loop termination condition.
* Ideally, knowing that the invariant still holds and that the loop has
  terminated tells us that we've achieved the desired result.
* For example (no using this on the LA)

```
int x = 0;
int y = 0;
while (y < 100) {
  // Invariant: x = 2*y
  y += 1;
  x += 2;
  // 2*(y+1) = 2*y + 2, hence we've maintained the invariant
  // x = 2*y
} 
// Loop has terminated. So y is at least 100. x must be at least 200.
```

* For example (I suppose you can use this if you write your own version)

```
// I have an array. I'll be iterating over the array.
//          i
// +--------+--------------+
// | sorted |  unknown     |
// +--------+--------------+
//  All values in unknown are at least as large as the largest
//  value in sorted.
int i = 0;
for (int i = 0; i < n; i++) {
  // To maintain the invariant, I must find the smallest value
  // in unknown
  swap(arr, i, findSmallest(arr, i));
  // I can safely at that value to the end of sorted and know that
  // it's still sorted.
  // It's smaller than everything else in unknown, so I've preserved
  // the second half of the invariant.
} // for
```

#### IDE

* "I used Intellisense regularly."  Um ... we did say not to use
  AI coding assistants.
    * It's okay; it's just basic autocomplete.

Questions
---------

### Administrative

### LAs

How much detail do we need to do on graph LAs?

> Yes, you should probably strive for an implementation for MST and
  shortest path and traversal.

> Whoops. The graph LAs just disappeared.

Do we really need to give an implementation of graphs?

> No. Sketch one (in words).

I got a .999/1 on an LA. What's up with that?

> Um ... it should either be 1 or 0. I'll look into that. OOP #1.

### Misc

Minimum Spanning Tree
---------------------

_TPS_

### What is an MST?

A spanning tree that is the minimum weight among all spaninng trees.

What is a spanning tree?

> A tree that connects all the nodes in the graph

> No cycles!

> Note: Graph theory (or just intuition) tells us that there are n-1
  edges in any spanning tree. (Assuming there are n vertices.)

Like the street plowing problem: What's the cheapest set of streets to
plow that allow us to get to every corner?

### What is Kruskal's algorithm?

1. Put all the edges in a well-designed priority queue (say, a heap).

2. <strike>Initialize trees (that we're not sure about)</strike>

3. Repeat until every vertex is connected (or we run out of edges)

    * Add the smallest-value edge that doesn't create a cycle.

Note: Sorting is O(mlogm)

Question: How do we know if an edge creates a cycle?

* "Magic"
* We can use a data structure that helps us identify the connected component
  to which each vertex belongs.
* A connected component is a set of nodes connected by edges in which you
  can get from each node to every other node.

### What is Prim's algorithm?

1. Pick a vertex.

2. Choose the smallest edge connected to that vertex. Add it to our MST.

3. Repeately add the smallest edge connected to our MST that does not
   create a cycle.

In Prim's how do we tell if they create a cycle?

We should mark the vertices adjacent to an edge each time we add an
edge. If we try to add an edge both of whose vertices are already
marked, we know it will create a cycle.

### How are they similar? How are they different?

Similar

* Both look for the next smallest edge from some set.
    * Kruskal's: All edges
    * Prim's: Edges that are connected to our current MST.
* Both greedy
* Both add edges only when they don't create a cycle.

Differences

* The focus is more on vertices in Prim's; more on edges in Kruskal's.
* Prim's grows a single tree; Kruskal's grows independent tress that
  eventually connect.
Labs
----
