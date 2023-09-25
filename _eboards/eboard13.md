---
title: "EBoard 13: Inheritance"
number: 13
section: eboards
held: 2023-09-22
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.

_Approximate overview_

* Administrivia
* About MP4
* Questions
* Lab

Administrivia
-------------

### Introductory notes

* Warning!  Today is Friday the 13th (class).
* Congratulations to our Grinnellian of the week!
* If it looks like VSCode is spending forever Java stuff, click on the
  "see more" link (something like that) and then close the box that
  appears.
* Today is (almost) our last day on Java.  Starting next week, we'll be
  using Java to build ADTs, Data Structures, and Algorithms.
* MP4 released.

### Upcoming Token activities

Academic

* Mentor session Sunday at 4pm.

Cultural

* Book talk Thursday W@G

Peer

Wellness

Misc

### Upcoming work

* Monday: No reading, today's lab

### Friday PSA

MP4
---

See [the assignment](../mps/mp04).

Yay!  Fun!

Questions
---------

_You can ask questions about anything related to the class!  Self gov
says that you **should** ask those questions._

### Java

### Administrative stuff

In CSC-161, we got detailed instructions for each assignment, laying
out each thing we were supposed to do.  Here, we get vague generalities.
That's hard!

> It's at least partially intentional.  I want you to get used to
  (a) dealing with incomplete specifications and (b) asking questions.
  As I hope class on Wednesday suggested, I'm happy to spend time in
  class answering questions.

It sucks that there are people who know much more than me here.

> It does.  I hope that things balance out as the semester progresses.
  We move on to algorithms and data structures next week.

> We'll talk more about the power dynamics of this later.

### Exceptions

### Inheritance

Lab
---


```
  // Assume DecrementableCounter extends BasicCounter and
  // BasicCounter implements Counter.  Is this legal?
  Counter gamma = new DecrementableCounter(10);
  // However, we cannot treat gamma as a DecrementableCounter
  // (we can't access the method).
```

Inheritance basics you might have learned ...

* When you call a method on an object in a subclass, and the subclass
  does *not* implement the method, we get the method from the superclass.
* When you call a method on an object in a subclass, and the subclass
  *does* implement the method, we get the method from the subclass.
* (Similar with fields.)
* You can use a member of a subclass anywhere you can use a member of
  its superclass.  (That's subtype polymorphism in action.)

Things you might have learned that often trip up students ...

* In deciding what methods you *can* call, Java relies on the declared
  type of an object.
* In deciding what version of the method you *do* call, Java relies on
  the actual type of the object.
* Java insists that we call the constructor of the superclass implicitly
  (zero-parameter) or explicitly.
* That call must be the first thing in the constructor.
