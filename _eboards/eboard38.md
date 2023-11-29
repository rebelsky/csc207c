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
* Saturday, 2023-12-02, 5:30pm, Main Hall (aka "Harry Potter Hall"): 
  _AAA Dinner_.

Wellness

* Wednesday, 2023-12-06, 3-5:30pm, Chrystal Palace, _CLS Hot Chocolate_.
* Friday, 2023-12-01, 7:00--9:00pm, Gardner, _SHIC "Positive Play" Game Night_.
* Monday, 2023-12-04, 4:00--5:00pm, HSSC North Atrium, _Therapy Dogs_.

Misc

* Saturday, 2023-12-02, 11am-1pm, HSSC S1325, _Girls Who Code Prsent Tea Time!_

### Other good things (no tokens)

* Psych candidate presentations

### Upcoming work

* Thursday: Mini-project 9
* Reading for Friday: CLRS ?.

Questions
---------

### Graphs

### Heaps

### MP9

How should we test our code for MP9?

> Pick a variety of types of legal JSON and feed them in to the system
  and then verify that it gives the correct object structure.

> Feed in legal JSON, convert back to a JSON string (with `writeJSON` or
  something like that ), compare.

For `writeJSON`, do you care what method we use to generate output?

> Nope.

For `JSONHash`, why are we building an iterator?

> It's good practice to build iterators (or iterables) for each collection 
  class you write.

> For a hash table, the most natural iterator is one that iterates over
  the key/value pairs.

> We often also want to write iterators for just the keys and just
  the values.

> "Get all the elements of this collection" is a standard request from
  any collection. In 151, that was probably a list. In 161, it was
  probably an array. In 207, it's an Iterator (or Iterable).  The
  last is nice because it requires less extra memory.

How do I compute the `hashCode` of a hash table?

> It's up to you.  "Sum of hashCode of individual pairs" is one
  approach, but not great. 

> You could also use the underlying `hashCode` of the underlying 
  array/ArrayList.

> You could use the ideas from PM's chapter.

Do we have to check for `null` in our constructors and/or in the
individual methods we write for the various JSON types?

> No

You provided `JSONConstant`. Why did you do something weird in the
`equals` method like compare the contents field to another object?

> For constants, it made sense to do so.

So should we do the same thing for strings and such?

> It's up to you.

Are there complexities in dealing with hashes?

> Yes, they may not have the same capacities but still have the same content;
  you should probably check for that situation.

How do we write an iterator for hash tables?

> _TPS_.

> Option one: For probed hash tables

> Sam would probably have an integer that keeps track of the index of
  the next cell we might look at.

> `hasNext` will see if there's a value in that cell. If so, return true.
  If not, advance until you (a) find a non-empty cell or (b) run off the
  end of the array. In case (a), you return true.  In case (b), you
  return false.

> `next` does something similar, except that it throws an exception in
  the case that it runs off the end of the array.  It also adds
  one to the position for the next go round.

> ```
public KVPair<K,V> next() {
  if (this.hasNext()) {
    return JSONHash.this.values[pos++];
  } else {
    throw new NoSuchElementException("boom!");
  } // if/else
} // next()
```

> Option two: For chained hash tables

> Similar to the probed one. However, when you reach a bucket, you'll
  need to loop through the bucket/array/ArrayList at the given index.

> We could use a second cursor.

> We could also grab an iterator for the bucket.

> General structure

>```
  public Iterator<KVPair<JSONString,JSONValue>> iterator() {
    return new Iterator<KVPair<JSONString,JSONValue>>() {
      /** The position in the underlying array. */
      int pos = 0;

      public boolean hasNext() {
        ...
      } // hasNext()

      public boolean next() {
        ...
      } // next()
    };
  } // iterator()
```

### Administrative

Could you tell the infamous "Grading in SamR's first Data Structures and
Algorithms in Java" story?

> Sure.

Modeling problems with graphs
-----------------------------

* Core issue of CS (or at least computer programming): Take real-world
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

* What do these problems have in common?

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
    * Costs and capacities are also useful weights for some problems.
* In most situations, we require that weights be non-negative.
* Weights might be integers or reals

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

_Note: The plural is VERTICIES, the singular is VERTEX. 
"VERTISEE" is an abomination._

#### Building graphs

* Start with an initial vertex `public Graph(String initialVertex)`.
* Start with nothing `public Graph()`.
* Add an edge to the graph `void addEdge(String from, String to, double weight)`.  This should also add the vertices if they are not already in the graph.  Throw an error if's already there. Or replace it if it's already there (obviating the need for `changeWeight`).

#### Changing graphs

_Whoops. We didn't name edges._

* Rename a vertex `renameVertex(String old, String new)`.  (Mostly for
  UI issues.)
* Remove an existing edge `removeEdge(String from, String to)`.  Throws
  an exception if the edge does not already exist.
* Change the weight of an edge
  `changeWeight(String from, String to)`.

#### Extracting information from graphs

* Determine whether an edge exists in the graph.  `hasEdge(String from, String to)`.
    * Alternate: `edgeWeight(String from, String to) throws Exception`
* Determine if the graph is empty.  `isEmpty()`.
    * Also `numVerticies()` and `numEdges()`
* Determine how many outgoing edges there are from a vertex: `int numEdgesFrom(String vertex)`
    * `Iterator<Edge> edgesFrom(String vertex)`
    * `Iterable<Edge> edgesFrom(String vertex)`
        * `for (Edge e: g.edgesFrom("start"))`
* In the `Edge` class, `compareTo(Edge other)`.
* Useful to get iterators (or Iterables) for edges and vertices.

#### Things Sam didn't thik about

* Do two edges cross?  (Graphs are so abstract that we can't ask that
  question.)

Implementing graphs
-------------------

Yay! It's time for LIA! (Layout, Implementation, Analysis)

### Layout

_TPS: How would you store a graph?_

### Implementation and analysis
