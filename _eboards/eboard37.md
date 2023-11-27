---
title: "EBoard 37: Heaps and heapsort, continued"
number: 37
section: eboards
held: 2023-11-27
link: true
---
# {{ page.title }}

**Warning** This class is being recorded (and transcribed) (assuming Teams succeeds).

_Approximate overview_

* Administrivia
* Questions
* Lab

Administrivia
-------------

* I hope you had a great Turkey break.
* I missed many of you last Wednesday. Very few of you who missed class
  notified me that you were going to miss class, in spite of the policy
  that you are supposed to do so.
* Prof. Jimenez and I bought you presents. The official class pen.

### Upcoming Token activities

Academic

* Tuesday, 2023-11-28, Noon, Day PDR, _CS Table: TBD._

Cultural

* Thursday, 2023-11-30, 11am, JRC 101: _Let's talk institutional memory_.

Peer

* Friday, 2023-12-01, 5:30pm, Natatorium: _Swimming (Pioneer Classic)_
* Friday, 2023-12-01, 5:00pm, Field House: _Indoor track and field_
* Saturday, 2023-12-02, all day, Natatorium: _Swimming (Pioneer Classic)

Wellness

_We need more of these!_

Misc

* Subject yourself to a study of types.
* Please fill in the peer educator evaluations

### Other good things (no tokens)

### Upcoming work

* Reading for Wednesday: CLRS B.4.
* Thursday: Mini-project 9

Questions
---------

### Heaps

### MP9

### Administrative

I forgot to fill in the pre-assessment for mini-project 9 even though I 
knew that I had to do so to make up for the prior missing pre-assessments
and you reminded us to do so. Could I please turn it in today?

> Sure.

Lab
---

Should we create a min-heap or a max-heap?

> Please create a min-heap.

Does it matter if I write `heapUp` iteratively or recursively?

> Nope. I think it's easier to write recursively, but I ended up writing
  it iteratively when I did the lab.

Does it matter if I write `heapDown` iteratively or recursively?

> Nope. I think it's easier to write recursively, and I ended up writing
  it recursively when I did the lab.

Do you have hints on `heapDown`?

> Strategy one: Write a helper procedure that returns the index of the
  smaller child.  You can then compare `i` to that index.  (Make sure
  that you check whether there is a right child.)

> Strategy two: Keep track of the index of the smallest element seen
  so far. Initially, that's `i`. If you have a left child and the left
  child is smaller, you can update that index. If you have a right child
  and the right child is smaller, you can update that index. Once you're
  done, you can compare that index to `i`. If they are different, swap
  and recurse (recur).  (I think CLRS use this strtegy.)

