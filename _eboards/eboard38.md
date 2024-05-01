---
title: "Eboard 38: Graphs"
number: 38
section: eboards
held: 2024-05-01
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Some LAs
* Questions
* A bit more on heaps (plus practice)
* Modeling problems with graphs
* Some graph terminology
* Designing a graph ADT
* Implementing that ADT (if time)

Preliminaries
-------------

* I spent all day yesterday grading LAs. So you will get many back after
  class.  We'll go over some notes to help everyone. (I prefer to go
  over notes before returning things for obvious reasons.)
* I will set up all the LAs for May 10 on Saturday.
* If I can get those graded promptly, I'll set up a set for Tuesday, May 14.

### Upcoming work

* Wednesday, 2024-05-01, 11:00pm, MP10
    * [_Submit MP10 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4405216/)
* Thursday, 2024-05-02, 11:00pm, More Reading on Graphs. 
* Friday, 2024-05-03, 11:00pm, MP10 post-reflection.
    * [_Submit MP10 post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4405177)
* Friday, 2024-05-03, 11:00pm, New set of LAs, repeated + old LAs
* Friday, 2024-05-10, 11:00pm, New set of LAs, repeated + old LAs

### Tokens

* Thursday, 2024-05-02, 11am, JRC 101.
  _PBK Scholars' Convocation: Cathleen Kaveny on "Can We Be Civil? Prophetic Indictment and Call-Out Culture in American Public Life"._
* Tuesday, 2024-05-07, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-05-07, 8:00pm, Science 3819.
  _Mentor Session_. Make Elene and Sam happy. Show up to mentor sessions!

Cultural

* Most days, 2024-04-xx and 2024-05-xx, 11am-6pm,
  Grinnell College Museum of Art.
  _BAX 2024_. Shouldn't it be BAE?
* Friday, 2024-05-03, 4:00--5:00pm, HSSC N1170.
  _Middle of Everywhere_

Peer

Wellness

* Sunday, 2024-05-05, 10:00am--6:00pm, Mac Field.
  _Bubble Soccer_. (It takes almost as long as cricket!)
* Friday, 2024-05-10, 5:00pm--??:??pm, Merrill Park West.
  _CS Picnic!_ Survey forthcoming.

Misc

* Thursday, 2024-05-02, 4:15--5:30pm, Burling 1st.
  _Conversation with Kathryn Mohrman '67._
* Saturday, 2024-05-04 (aka "Star Wars Day"), 10:00am--11:00pm, Central Campus.
  _The Grinnellian._

### Other good things to do (no tokens)

* Saturday, 2024-05-04 (aka "Star Wars Day"), 1:00--3:00pm, Softball Complex.
  _Softball vs. Lawrence_.
* Saturday, 2024-05-04 (aka "Star Wars Day"), 3:00--5:00pm, Softball Complex.
  _Softball vs. Lawrence_.
* Sunday, 2024-05-05, 1:00--3:00pm, Softball Complex.
  _Softball vs. Illinois_.

### Other questionable things (no tokens)

* Saturday, 2024-05-04 (aka "Star Wars Day"), noon--5:00pm, Cleveland Beach.
  _Alice in Wonderland_.

LAs
---

I got through all of the algorithms LAs and most of the development
LAs. 

Most of the 0's I saw were very close to 1's. They just needed a bit of
correction or extension to show me that you'd mastered the LO.  Here
are things that will help you do better.

* Please put both code and commentary in the top box. The citations
  box is for citations.
* Please take the time to anonymize your code.
* It would be nice if you followed coding conventions. (I don't think anyone
  got a 0 for this, but you should follow coding conventions.)
* Please be reasonable specific in your citations. Not "labs" but
  "the lab on binary search" or URL.
* I worry that many of you seem to have forgotten everything you learned
  about decomposition in CSC-151. Details follow below.
* Please follow custom and write ranges as lower-bound inclusive,
  upper-bound exclusive. [I'll repeat this a few times.]
* Some of you need to work on the clarity of your high-level explanations.
  I don't need a description of every step. Your goal is a few sentences
  that give someone a high-level understanding of the algorithm.
* Please don't ask me to follow links to judge your answers. With 1500+
  LAs to grade, I need everything in one place.

### Algorithms 1: Binary Search

* Make sure your algorithm is correct.
* Make sure you explain the inputs and outputs.
* Please follow custom and write ranges as lower-bound inclusive,
  upper-bound exclusive.

### Algorithms 2: Sequential Search

* "Find smallest" is not usually what we'd call a sequential search
  algorithm, even though it's a sequential algorithm. Searching
  algorithms search for a particular value or one that meets a
  criterion that depends only on that value.

### Algorithms 3: Insertion Sort

* Please make the "insert" in insertion sort explicit in both your
  code (i.e., by writing a separate `insert` procedure) and your
  narrative.

### Algorithms 4: Selection Sort

* Very few people seem to have written an `indexOfSmallest` or
  `indexOfLargest` procedure. Decompose!

### Algorithms 5: Merge Sort

* Please follow custom and write ranges as lower-bound inclusive,
  upper-bound exclusive.

### Algorithms 6: Quicksort

* Some of you used a very different approach to partitioning than we
  discussed. And you had similar bad designs (e.g., using `i` to
  represent the end of the small elements and initializing it to
  something like `low-1`. If you are one of those people, please
  talk to me asap.
* Please follow custom and write ranges as lower-bound inclusive,
  upper-bound exclusive.

### Algorithms 11: Divide and Conquer

* Make sure you clearly explain the basic principles of "divide and
  conquer".

### Algorithms 12: Big-O

* Make sure you understand the "is in" notation and why we use it.

### Development #1: Collaboration

* I need more than "I wrote code with someone else". Please describe
  your process and why it was successful (or how you made it
  successful).

### Development #3: Unit Testing

* Too few of you include comments in your unit tests. But it's nice
  for someone to see what you are testing.
* In some cases, I was hoping for more of a mix of tests and 
  text (either you had tests but almost no text, or text but
  almost no tests).

### Development #5: Version Control

* Please include a git log from a project.
* And remember that it's supposed to show collaboration. That means
  there should be more than one committer (or an explanation as to
  why there's only one committer).

### Develpoment #6: Code Reading

* Code reading is more than "there's a for loop here". You should describe
  the design decisions embedded in the code and the relation of the class
  to a larger ecosystem. (Why did someone create this class?)
* The specification says "_Read, understand, **and modify** code that you 
  did not write._" I'd like to see appropriate modifications.

### Development #7: Documentation

* I'm a bit surprised at what people submitted, so I'm going to give
  some tips.
* Make sure to use Javadoc comments.
* Make sure to use correct spelling.
* Make sure to comment methods, constructors, and fields.
* Make sure that your comments say more than "Helper method".
* Ideally: Document parameters and such. (I don't regularly do so,
  so I won't force you to do so.)
* Ideally: Put in section separators.
* Ideally: Include internal comments to explain more confusing parts
  of code.
* Ideally: Do not include internal comments that simply restate what
  the code does. `// Add one to x` above `x++;` does not help the
  reader.

### Development #9: Use Libraries

* Please focus on libraries in which you don't know the internals.
  (That is, don't say "I used Sam's X class.") You've demonstrated
  knowledge of using such libraries in the Code Reading LO.

### Development #10: Exceptions

_Signal and recover from errors using exceptions._

* Make sure you include an example of throwing an exception.
* Make sure you include an example of catching an exception (or
  being ready to catch an exception).
* Make sure that your recovery is reasonable.
* Narrate both.

### ADTs/DSs #1: Lists

* Even though Java includes it, `get(int i)` is **not** a core
  list operation.

### ADTs/DSs #2: Stacks

* Here and in other ADTs/DSs, start with the PUM, or at least something
  like the PUM. At least the PM.

### ADTs/DSs #7: Binary Search Trees

* Bit trees are not BSTs. Neither are heaps.
* Please include code for `get` and `set`.

### ADTs/DSs #10: Array-Based Structures

* Make sure to explain why we use arrays in implementations.
* Make sure to explain how you are using an array in the implementation.
* Make sure to include code that explicitly works with an array.

Questions
---------

### Administrative

When will my MPs be graded?

> I don't know. Stay tuned. 

### MP10

### LAs

### Misc

Heaps
-----

_TPS: Where were we?_

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

