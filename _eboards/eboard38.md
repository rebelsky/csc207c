---
title: "EBoard 38: Graphs"
number: 38
section: eboards
held: 2023-11-29
link: true
---
# {{ page.title }}

**Warning** This class is being recorded (and transcribed) (assuming Teams succeeds).

_Approximate overview_

* Administrivia
* Questions
* Modeling problems with graphs
* Graph terminology
* A Graph ADT
* Implementing graphs

Administrivia
-------------

* Today is a talk day, not a lab day.

### Upcoming Token activities

Academic

* Wednesday, 2023-11-29, 7:30pm, 3815, _Special bonus mentor session_.

Cultural

* Thursday, 2023-11-30, 11am, JRC 101: _Let's talk institutional memory_.

Peer

* Friday, 2023-12-01, 5:30pm, Natatorium: _Swimming (Pioneer Classic)_.
* Friday, 2023-12-01, 5:00pm, Field House: _Indoor track and field_.
* Saturday, 2023-12-02, all day, Natatorium: _Swimming (Pioneer Classic)_.

Wellness

* Friday, 2023-12-01, 7:00--9:00pm, Gardner, _SHIC "Positive Play" Game Night_.
* Monday, 2023-12-04, 4:00--5:00pm, HSSC North Atrium, _Therapy Dogs_.

Misc

* Please fill in the peer educator evaluations

### Other good things (no tokens)

### Upcoming work

* Thursday: Mini-project 9
* Reading for Friday: CLRS ?.

Questions
---------

### Graphs

### Heaps

### MP9

### Administrative

Could you tell the infamous "Grading in SamR's first Data Structures and
Algorithms in Java" story?

> Sure.

Modeling problems with graphs
-----------------------------

* Core issue of CS (or at least computer programming): Take real-worl
  problems and solve them computationally.
* We like to build "models" that let us represent the problem in the
  computer, often stripping away extraneous details.
* A lot of problems, particularly geographic problems, lead to 
  structures we call "graphs".

Some sample problems:

* You are a 911 dispatcher and need to send an ambulance to an
  address, from which depot do you send it?
* It has snowed.  A lot.  All of the streets are impassible.
  What's the minimal set of streets we should clear so that the 
  fire department can reach every corner in town? 
* You work for the census.  You need to visit every house in 
  Powesheik county.  What's the most efficient path to visit all
  of those houses?
    * _Can_ you visit all of those houses?

Abstraction

* What do these commons have in problem?

Graph terminology
-----------------

A graph is a collection of vertices and edges that connect them.
CLRS write this as $(V,E)$.

* We typically say that a graph has $n$ vertices and $m$ edges.
    * We might say that a graph has $v$ vertices and $e$ edges.
* We typically permit only one edge from one vertex to another.
* We don't typically permit edges from a vertex to itself.

### Weighted graphs

* Every edge has an associated "weight", representing some cost
  associated with the edge.
    * For our geographic examples, that might be the distance
      between two locations or the time it takes to get
      between the two locations.
* In most situations, we require that weights be non-negative.

### Directed graphs

* In directed graphs, edges may only go in one direction.

### More formal definition (not formal enough)

A directed weighted graph $G$, is a pair of sets, $(V,E)$ in which

* $V$ is finite.
* $E$ is a subset of $VxVxReal$.  
    * Each edge triplet has three values: the vertex the edge
      comes from, the vertex the edge goes two, and the weight.
     * Sometimes we require the edge weights be integers.

Designing a Graph ADT
---------------------

Yay! It's time for PUM!

* Philosophy: Represent a variety of problems that can be naturally
  modeled with graphs.
* Uses: We looked at some examples above.
* Methods: _Time for TPS!_

### Methods 

_Focus on the basics; the things like `cons`, `car`, and `cdr` that
we'd need to implement the more complex algorithms we're going to
design._

#### Building graphs

#### Changing graphs

#### Extracting information from graphs

Implementing graphs
-------------------

Yay! It's time for LIA! (Layout, Implementation, Analysis)

### Layout

_TPS: How would you store a graph?_

### Implementation and analysis
