---
title: "Eboard 07: A mental model of classes and objects."
number: 7
section: eboards
held: 2024-02-05
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed. Of course, the technology failed in my earlier class, so perhaps not.**

_Approximate overview_

* Administrivia
* About mental models
* Thinking about classes
* Thinking about objects
* Compile-time and runtime issues
* Thinking about the rest of the runtime environment

Preliminaries
-------------

### Upcoming work

* 11pm Tuesday, 2024-02-04: Reading Reflections
    * [Unit testing](../readings/unit-testing)
    * [Debugging](../readings/debugging)
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4055828/)
* 11pm Wednesday, 2024-02-05: [Mini Project 2](../mps/mp02)
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4055758/)
* 11pm Friday, 2024-02-07: Mini-Project 2 post-reflections
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4055738)

### Tokens

Academic/Scholarly

* Tuesday, 2024-02-06, Noon in JRC 224A.
  _CS Table: Web browsers, privacy, and advertising._
* Thursday, 2024-02-08, 11am in JRC 101.
  _Scholars' Convocation: A Life Worth Archiving – Excerpts from a Memoir._

Cultural

Peer

* Saturday, 2024-02-10, 10am--1pm, Field House.
  _Darren Young Class_.
* Do we have any womens tennis players? (Tuesday 6pm)

Wellness

* Tuesday, 2024-02-06, noon, BRAC P103 (Multipurpose Dance Studio).
  _HIIT & Strength Fitness Class_.
* Tuesday, 2024-02-06, 12:15, Bucksbaum 131 (the museum).
  _Yoga in the museum_.

Misc

* InfoSec survey (stay tuned for email)

### Good things to do (no tokens)

Questions
---------

### Administrative

### MP2

Mental models
-------------

To understand how our code works (and why it doesn't work), it can be
helpful to form _mental models_ of how the computer stores and processes
our programs.

* In CSC-151, we generally used a _substitutive model_ which broke down
  slightly once we hit procedures with side effects.
    * Subtitution also gets more complicated when you reuse names
      in `let` bindings.
* Our model will be somewhat different for Java, not least because
  Java is explicitly stateful.
* Our model need not precisely mimic what the Java Virtual Machine does;
  rather, our goal is to understand conceptually what it does.
* To model the Java, we need to consider classes, objects, and
  inheritance (which we haven't covered yet).

Classes
-------

TPS: What information should we store for each class?

Objects
-------

TPS: What information should we store for each object?

Compile-time and Runtime issues
-------------------------------

I've been known to say "Java is your nanny". That is, the Java compiler
tries to verify that your code is "safe" (or as safe as it can figure).

TPS: What kinds of issues can it check at compile time?

TPS: What kinds of issues might occur at runtime?

Runtime
-------

Other than objects and classes, what information should we be storing
at runtime?
