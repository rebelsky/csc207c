---
title: "EBoard 39: Traversing graphs"
number: 39
section: eboards
held: 2023-12-01
link: true
---
# {{ page.title }}

**Warning** This class is being recorded (and transcribed) (assuming Teams succeeds).

_Approximate overview_

* Administrivia
* Questions
* Lab
* Implementing graphs

Administrivia
-------------

### Upcoming Token activities

Academic

* Monday, 2023-12-04, noon--1pm, _Lunch & Learn: Summer Research_
    * Email barks@grinnell.edu with dietary restrictions or to
      request accommodations.

Cultural

* Saturday, 2023-12-02, 2pm--4pm, _Grinnell Singers & Oratorio Society_
* Sunday, 2023-12-03, 2:00--3:30pm, _Collegium Musicum_
* Wednesday, 2023-12-06, Noon--1:30pm, _Vox Feminae Christmas Concert_

Peer

* Friday, 2023-12-01, 5:30pm, Natatorium: _Swimming (Pioneer Classic)_.
* Friday, 2023-12-01, 5:00pm, Field House: _Indoor track and field_.
* Saturday, 2023-12-02, all day, Natatorium: _Swimming (Pioneer Classic)_.
* Saturday, 2023-12-02, 5:30pm, Main Hall (aka "Harry Potter Hall"): 
  _AAA Dinner_.
* Monday, 2023-12-01, 5:00-6:30, ???: _GrinTech Open Source Workshop_

Wellness

* Friday, 2023-12-01, 4:30--5:30pm, JRC 101, _Grinnell Social Hour:
  Mocktails and Games_.
* Friday, 2023-12-01, 7:00--9:00pm, Gardner, _SHIC "Positive Play" Game Night_.
* Friday, 2023-12-01, 7:00--9:00pm, JRC 101, _Mixer: Disability Cultural Association_
* Monday, 2023-12-04, 4:00--5:00pm, HSSC North Atrium, _Therapy Dogs_.

Misc

* Saturday, 2023-12-02, 8am-2pm, Drake Library, _Book Sale!_
* Saturday, 2023-12-02, 11am-1pm, HSSC S1325, _Girls who code study break_
* Sunday, 2023-12-03, 7:00--9:00pm, JRC 101, _Winterfest_
* Monday, 2023-12-04, noon--1pm, JRC 101, _Registration Feedback_

### Other good things (no tokens)

### Upcoming work

* Reading for Monday: Wikipedia on Prim's algorithm and Kruskal's algorithm

### Friday PSA

* You are awesome, please take care of yourselves.
* Consent is essential.

Detour
------

_A report from conversations with Sam's therapist._

Questions
---------

### Graphs

### MP9

### Administrative

Lab
---

### Questions on the Graph implementation

Can you explain `marked`?

> Many graph algorithms require you to mark the vertices as part of
  the algorithm.

> For example, a typical traversal of the graph will require us to
  visit vertices and, at at each vertex, add its neighbors to the
  list of things we want to traverse.

> But we don't want to visit a vertex more than once. So we need
  a way to keep track of the ones we've traversed already.

> Although people could do this by hand, the designers (Sam) decided
  it should be part of the `Graph` class.

> Plus, it's a fun way to play with bytes.

What's the underlying representation?

> We use arrays to keep track of the vertices. Internally, we think of
  a vertex as a number.

> One array maps vertex numbers to vertex names.  `vertexNames`.

> For going backwards (from Name to number) we use a hash table.

> Another array map vertices to all the edges eminating from that 
  vertex.  That's called `vertices`.

> We hide it from the client by providing lots of utility methods.

What's this `failFast` thing?  (Or what have you observed?)

> "Sam, tracing code that relies on multiple assumptions is hard!"

> Goal: We want <something> to fail quickly, rather than later.
  
> Background: Every time we modify the graph, we update `this.version`.

> It's helpful to know how many times we modify the graph.

> If we're iterating the graph and the graph changes, we probably 
  need to signal that to the client.

> Each iterator has it's own information about the version that
  was current when it was created. `failFast` compares that to
  the current version and throws an exception if they aren't the 
  same.

Followup: Won't `this.version` change, so we won't know?

> Sam is insufficiently creative. Sam chose the same field name for 
  the iterators and the graph. In both cases, it's `version`.

> In the iterator, `this.version` refers to the `version` field
  associated with the iterator.

> In the graph, `this.version` refers to the `version` field associated
  with the graph.

How do we interpret the word `this`?

> It always corresponds to the object's class.

> For an anonymous inner class, it's the anonymous class.

What if we want to refer to a field in the class that encloses
the anonymous inner class?

> `ClassName.this.fieldName`.

Can you explain this code?

```
  public Iterable<Edge> edges() {
    return () -> {
      return new Iterator<Edge>() {
        ...
      }; // new Iterator<Edge>
    };
  } // edges()
```

> `return new Iterator<Edge>()` builds a iterator using anonymous inner
  classes.

> Anonymous inner classes are designed for the situations in which we just
  need one-off classes that might reference the enclosing class.

> Conveniently, `Iterable` is a functional class.  That is, it has only
  one required function.

> When you have a functional class, you can use a lambda to build an
  object in that class. (It's a simpler syntax that aic.)

> Why did Sam make `edges()` return an `Iterable` rather than an `Iterator`/

> O: Obnoxious? Object-oriented? (NOpe)

> You can use the for-each syntax with Iterables but not iterators.

> WIth the current design, we can write

```
  for (Edge e : g.edges()) {
    ...
  } // for
```

> With the iterator design, we'd have to write something like

```
  Iterator edges = g.edges();
  while (edges.hasNext()) {
    Edge e = edges.next();
    ...
  } // while

### Questions on the Lab

Isn't the new `dump` implemented already?

> Um, yes. It appears that I screwed things up in updating the `Graph`
  repo for this semester.

Implementing graphs
-------------------

_Skipped._

Yay! It's time for LIA! (Layout, Implementation, Analysis)

### Layout

_TPS: How would you store a graph?_

### Implementation and analysis
