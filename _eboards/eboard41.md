---
title: "EBoard 41: Shortest paths"
number: 41
section: eboards
held: 2023-12-06
link: true
---
# {{ page.title }}

**Warning** This class is being recorded (and transcribed) (assuming Teams succeeds).

_Approximate overview_

* Administrivia
* Questions
* Lab
* Implementing graphs (maybe)

Administrivia
-------------

* I have no scheduled office hours during Finals Week. I will be in
  my office as much as I can. Feel free to DM me to check if I'm there
  or to ask questions.
* Since we'll be doing EOCEs in class on Friday and have fewer
  computers than students, it would be nice if some of you brought 
  your laptops on Friday.

### Upcoming Token activities

Academic

Cultural

* Wednesday, 2023-12-06, Noon--1:30pm, Bucksbaum,
  _Vox Feminae Christmas Concert_
* Saturday, 2023-12-09, 11:55am--2:40pm, Harris Cinema,
  _Florencia en el Amazonas_

Peer

* Friday, 2023-12-08, 1:00-2:50 pm, Psych Commons, _Poster Session_

Wellness

Misc

### Other good things (no tokens)

### Upcoming work

* MP redos: As you can do them.  Last possible moment is 5pm on Dec 15th.
* LAs: As you can do them. Last possible moment is 5pm on Dec 15th.

Questions
---------

### Graphs

### Administrative

Lab
---

* Finish implementing Prim's.
    * See [the prior eboard](eboard40.html) or the end of
      [the prior lab](../labs/minimum-spanning-trees.html) for
      notes about some of the details.
* Implement Dijkstra's.

### Questions

What comparator might I use for the priority queue of edges?

> A comparator takes two parameters and is supposed to return 
    * A negative number, if the first parameter "comes before" the
      second parameter.
    * Zero, if the two parameters are equal.
    * A positive number, if the second parameter "comes after" the
      first parameter.

> We can write comparators with lambdas.

> `(e1,e2) -> e1.weight() < e2.weight() ? -1 : e1.weight() == e2.weight() ? 0 : 1`

> `(e1,e2) -> e1.weight() - e2.weight()`

Could we have a sample graph?

> Sure.

> * 0 1 1
> * 0 2 3
> * 0 3 3
> * 1 2 2
> * 1 4 4
> * 2 3 2
> * 3 4 1
> * 4 5 5

> The MST for that graph is `(0 1 1, 0 3 3, 1 2 2, 3 4 1, 4 5 5)`.  At
  least I think it is.

### WHat made this harder for some people?

* Treating the MST as a Graph, which required dealing with some of the
  subtleties of the Graph implementation. The MST is just a list of
  edges.
* Using extant fields in the Graph class. Those were already serving
  a purpose. Reusing them for other purposes is **dangerous**.
