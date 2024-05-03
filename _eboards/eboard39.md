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
* Quick group time (if time)

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
  _Middle of Everywhere_ (maybe Lebanon)

Peer

Wellness

* Sunday, 2024-05-05, 10:00am--6:00pm, Mac Field.
  _Bubble Soccer_. (It takes almost as long as cricket!)
* Friday, 2024-05-10, 5:00pm--??:??pm, Merrill Park West.
  _CS Picnic!_ Survey forthcoming.

Misc

* Saturday, 2024-05-04 (aka "Star Wars Day"), 10:00am--11:00pm, Central Campus.
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

Questions
---------

### Administrative

### LAs

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

Designing a graph ADT
---------------------

_TPS: PUM_ (yay TLAs)

### Philosophy

### Use cases

### Methods

#### Constructors

#### Accessors

#### Mutators

#### Additional

Implementing graphs
-------------------

_TPS: LIA_ (yay TLAs)

