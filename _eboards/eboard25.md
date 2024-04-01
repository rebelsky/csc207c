---
title: "Eboard 25: Quicksort"
number: 24
section: eboards
held: 2024-04-01
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Loop invariants and the Dutch National Flag problem
* Lab

Preliminaries
-------------

* Apologies. I lost three days of break and they were three days that
  I was planning to use for grading.
* Welcome back from break!
* Remember that post-break masking is a good idea.
* I think the day and the topic match well.
* I brought back some conference swag from the 2024 SIGCSE Technical
  Symposium on Computer Science Education. You can each have one or
  two octocat stickers, one notebook, and one or both of the disability
  stickers.

### Upcoming work

### Tokens

Academic/Scholarly

* Tuesday, 2024-04-02, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-04-02, 7:00pm, Science 3819.
  _Mentor Session_.
* Thursday, 2024-04-04, 11:00am, JRC 101.
  _Scholars' Convocation: Motherblame-stigma, Epistemic Injustice, and the Government’s Failure to Care_ (w Tammy Nyden in Philosophy).
* Thursday, 2024-04-04, 8pm, JRC 101.
  _Book talk: Austin Frerick '12 on Barons: Money, Power, and the Corruption of America’s Food Industry_

Cultural

* Thursday, 2024-04-04, 4pm, Grinnell College Museum of Art.
  _Writers@Grinnell presents Sam Naikhara '19_.
* Friday, 2024-04-05, 4pm, Global Living Room in HSSC.
  _Middle of Everywhere._

Peer

Wellness

* Monday, 2024-04-01, 4pm, HSSC Atrium.
  _Therapy Dogs_.
* Tuesday, 2024-04-02, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-04-02, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-04-02, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

* Wednesday, 2024-04-03, 11:45am, JCC Lower-Level Conf. Room.
  _CLS Lunch and Learn with Sam Naikhara '19_.
* Wednesday, 2024-04-03, 4pm, Some room.
  _CS Extras: Study abroad at AIT Budapest_.

### Other good things to do (no tokens)

Questions
---------

### Administrative

### Sorting (in general)

### Quicksort

### Other

Loop invariants review
----------------------

What are they?

Why do we use them?

The Dutch National Flag Problem
-------------------------------

You have an array with three values, which we’ll call red, white,
and blue. They are in no particular order. Your goal is to *rearrange*
it so that all of the red are at the left, all the blue are at the
right, and all the white are in between.

_You may not simply count the values; different reds represent different
objects (similarly for blues and whites)._

_We rearrange it rather than copy to a new array or arrays because we
are trying to limit space usage._

Sample input:

```
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Ba|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Rq|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

### Design

How do you approach the problem?

```
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```
