---
title: "Eboard 39: Graphs"
number: 39
section: eboards
held: 2024-05-03
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Questions
* Modeling problems with graphs
* Some graph terminology
* Designing a graph ADT
* Implementing that ADT (if time)

Preliminaries
-------------

### Upcoming work

* Friday, 2024-05-03, 11:00pm, MP10 post-reflection.
    * [_Submit MP10 post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4405177)
* Friday, 2024-05-03, 11:00pm, New set of LAs, repeated + old LAs
* Sunday, 2024-05-05, 11:00pm, Readings
    * [Tree traversal](../readings/tree-traversal)
    * [Wikipedia on Dijsktra's algorithm](https://en.wikipedia.org/wiki/Dijkstra's_algorithm)
* Friday, 2024-05-10, 11:00pm, New set of LAs, repeated + old LAs

### Tokens

* Tuesday, 2024-05-07, noon, Some PDR.
  _CS Table: CS Humor_.
* Tuesday, 2024-05-07, 8:00pm, Science 3819.
  _Mentor Session_. Make Elene and Sam happy. Show up to mentor sessions!

Cultural

* Most days, 2024-04-xx and 2024-05-xx, 11am-6pm,
  Grinnell College Museum of Art.
  _BAX 2024_. Shouldn't it be BAE?
* Friday, 2024-05-03, 4:00--5:00pm, HSSC N1170.
  _Middle of Everywhere_ (Lebanon)

Peer

Wellness

* Sunday, 2024-05-05, 3:00pm--5:00pm, Somewhere.
  _Bubble Soccer_. 
* Friday, 2024-05-10, 5:00pm--??:??pm, Merrill Park West.
  _CS Picnic!_ Survey forthcoming.

Misc

* Saturday, 2024-05-04 (aka "Star Wars Day"), 12:30pm--8:00pm, Central Campus.
  _The Grinnellian._

### Other good things to do (no tokens)

* Friday, 2024-05-03, 3:00--5:00pm, Softball Complex.
  _Softball vs. Lawrence_.
* Friday, 2024-05-03, 5:00--7:00pm, Softball Complex.
  _Softball vs. Lawrence_.
* Saturday, 2024-05-04, 2200--4:00pm, Softball Complex.
  _Softball vs. Illinois_.
  (Because three games against the same team in one weekend is absurd.)

### Other questionable things (no tokens)

* Saturday, 2024-05-04 (aka "Star Wars Day"), noon--5:00pm, Cleveland Beach.
  _Alice in Wonderland_.

### Friday PSA

* Please be moderate in all you do, even LAs.
* Consent is essential.

Questions
---------

### Administrative

When are we getting those back?

> I don't know.

How many redos?

> At least one, due at 5pm on the 17th.

What is my other question?

> Will I pass?

Will I pass?

> Probably. Almost certainly.

Could you put up a third MP1? It appears that I destroyed my code
when fixing it.

> Teams message me to remind me because I will forget otherwise.

> Reminder me if I haven't done so in twelve hours or if I get the
  MP number wrong.

Can you lower the number of LAs we need for an A?

> Ask me again next Friday.

How many LAs are there?

> Um ... 48.

Some gaslight question about arguing for a grade.

> You can argue about your MP grades.

Have you seen bandersnatch?

> No.

### LAs

Can you move the LA due date to Saturday night?

> Sure. I would not recommend doing LAs after Alice. Although maybe it
  would amuse me.

> And I suppose Alice is okay straight.

Do I need any code for the "IDE" LA?

> No. Just explain what an IDE is and suggest how you have taken advantage
  of the IDE features of VSCode.

Didn't we do a quiz in class for the recursive running time LA?

> Yes. But they ended up with my 151 quizzes and then got shredded.

> That's okay, you can do it again.

What should use a source for the composition LA?

> Composition is the concept that one object (class) can be built from other
  objects (classes). Put that in your own words and then give me an example
  that shows you've done it.

Where should we be using PUM or PM or P?

> Any time you have to design or describe an ADT: Stacks, Queues, Lists,
  Priority Queues, Dictionaries, (Heaps), Graphs. Also the "Design an
  ADT". Maybe Iterators.

What chances will we have to complete LAs?

> Due on May 3; returned May 6.

> Due on May 10; returned on May 13.

> Due on May 17 at 5pm.

> Maybe due on May 14, returned on May 16.

You changed the heaps one. Could I just implement heaps?

> Sure.

### Misc

Modeling problems with graphs
-----------------------------

* A core issue of CS (or at least computer programming): Take real-world
  problems and solve them computationally.
* We like to build "models" that let us represent the problem in the
  computer, often stripping away extraneous details.
* A lot of problems, particularly geographic problems, lead to
  structures we call "graphs".

### Sample problems

* You are a 911 dispatcher and need to send an ambulance to an
  address, from which ambulance depot do you send it?
* It has snowed.  A lot.  All of the streets are impassible.
  What's the minimal set of streets we should clear so that the
  fire department can reach every corner in town?
* You work for the census.  You need to visit every house in
  Powesheik county.  What's the most efficient path to visit all
  of those houses?
    * _Can_ you visit all of those houses?

### Abstraction

* What do these problems have in common?
* A bunch of "locations"
* Some locations are connected to each other.
* We sometimes assign a number to a connection:
    * Cost to remove a log
    * Time to get from to another
    * Capacity

Graph terminology
-----------------

A _graph_ is a collection of _vertices_ and _edges_ that connect them.
CLRS write this as $(V,E)$.  $E$ is a subset of $V$x$V$.

* We typically say that a graph has $n$ vertices and $m$ edges.
    * We might say that a graph has $v$ vertices and $e$ edges.
* We typically permit only one edge from one vertex to another.
* We don't typically permit edges from a vertex to itself.

_Please do not use "vertice" as the singular of "vertices"._

We often label the vertices of the graph.

* A, B, C, D, E
* v1 v2 v3

### Weighted graphs

In a _weighted graph_ every edge has an associated numeric "weight",
representing some cost associated with the edge.

* For our geographic examples, that might be the distance between two 
  locations or the time it takes to get between the two locations.
* We may sometimes associate more than one value with an edge, such as
  both a cost and a cpacity.
* In most situations, we require that weights be non-negative.
* Weights can be integers or reals. Surprisingly, using (conceptual)
  reals can make some problems more difficult.

### Directed graphs

In a _directed graph_, edges have a direction. That is, just because 
we can get directly from A to B, we can't necessarily get from B to A.

* You can think of these as one-way streets.

A guide to TLAs
---------------

* TLA: Three-letter acronym
* ADT: Abstract data type
* TPS: Think, Pair, Share
* PUM: Philosophy, Use Cases, Methods (I'd appreciate a better TLA)
* LIA: Layout, Implementation, Analysis (I'd appreciate a better TLA)
* CAM: Constructors, Accessors, Mutators

Designing a directed, weighted, graph ADT
-----------------------------------------

_TPS: PUM_ (yay TLAs)

### Philosophy

Something with vertices and weighted, directed edges.

### Use cases

See above

### Methods

#### Constructors

* `Graph()` - Create a new, empty graph.

#### Accessors

* `int numEdges()`
* `int numVertices()`
* `boolean isEmpty()`
* `Iterable<Vertex> vertices()`
* `Iterable<Edge> edges()`
* `Iterable<Edge> edgesFrom(Vertex v)`
* `Iterable<Edge> edgesTo(Vertex v)`
* `boolean containsVertex(Vertex v)`
* `boolean containsEdge(Vertex source, Vertex target)`
* `int edgeWeight(Vertex source, Vertex target)`
    * Throws an exception if there is no such edge

#### Mutators

* `void addVertex(Vertex v)` (vs `Vertex addVertex()`)
* `void removeVertex(Vertex v)`
    * Also removes all the edges
* `void addEdge(Vertex source, Vertex target, int weight);`
    * If we have not previously added `source` (or `target`), this
      could throw an exception. *our choice*
    * Alternately, we could automatically add `source` and `target`
    * If we already have an edge between `source` and `target`, this
      will change the weight of that edge.
* `void removeEdge(Vertex source, Vertex target)`

#### Observations

It will be difficult to develop an implementation that makes all of
these efficient. So we may want multiple implementations.

We could think about this in other ways, such as by having our vertices
contain a list of outgoing (or incoming or just adjacent) edges.

Implementing graphs
-------------------

_TPS: LIA_ (yay TLAs)

### Strategy one: Each vertex has a list of outgoing edges

Layout: See above and below

```
public class Graph {
  Dictionary<VertexName,Vertex> vertices;
} // Graph

public class Vertex {
  VertexName name;
  List<Edge> outgoingEdges;
} // class Vertex

public class Edge {
  VertexName source;
  VertexName target;
  int weight;
} // class Edge
```

Implementation + Analysis

* `addEdge(VerteName source, VertexName target, int weight);`
    * Create a new instance of edge. O(1)
    * Look up the source in the hash table. O(1)
    * Find the matching edge O(n)
        * If there's a matching edge, replace the weight/edge O(1)
        * Otherwise, Add it to the list. O(1)
* addVertex
* edgeWeight

### Strategy one alternate: 

* Each vertex contains a hash table of edges (rather than a list)

### Strategy two: Edge list

Make a list of all the edges in the graph

### Strategy three: Adjacency matrix

Create an nxn matrix of weights.  

### Strategy four: Hash table with Vertex*Vertex keys
