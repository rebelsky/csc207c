---
title: "Eboard 19: Big-O (for real this time)"
number: 19
section: eboards
held: 2024-03-04
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia
* Some notes on MP5
* Questions
* Algorithm analysis
    * Introduction
    * Terminology and informal notions
    * Some common bounds
    * Analyzing iterative algorithms
    * Analyzing nested loops
    * A more formal definition

Preliminaries
-------------

* I hope you enjoyed the sunny (and windy) weekend.
* The new tokens assignment is posted. I'm working on copying things
  over from the old tokens assignment.

### Upcoming work

* Wednesday, 2024-03-06, 1pm, Readings
    * CLRS 3 (Characterizing Running Times)
    * CLRS 4 (intro)
    * CLRS 4.3 -- I-4.5 (Methods for solving recurrences)
* Wednesday, 2024-03-06, 11pm, [MP5](../mps/mp05)
    * [_Submit MP5 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180584/)
* Friday, 2024-03-08, 11pm, Third set of LAs.
* Friday, 2024-03-08, 11pm, MP5 post-reflection
* Friday, 2024-03-08, 11pm, MP6 pre-reflection
* Sunday, 2024-03-10, 11pm, [MP1](../mp1) redo
    * [_Submit MP1 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180612/)
    * Please don't submit until it's ready for grading.
* Sunday, 2024-03-10, 11pm, [MP2](../mp2) redo
    * [_Submit MP2 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180615/)
    * Please ask if you're confused about something.

### Tokens

Academic/Scholarly

* Tuesday, 2024-03-05, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-02-27, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.
* Thursday, 2024-03-07, 11:00 a.m.,JRC 101.
  _Scholars' Convocation: An American Genocide: The United States and 
   the California Indian Catastrophe, 1846-1873_

Cultural

* Monday, 2024-03-04, Sebring Lewis.
  _Des Moines Metropolitan Opera: Beauty and the Beast_
* Thursday, 2024-03-07, JRC 101, 8:00-9:30 pm.
  _Writers@Grinnell: Carl Phillips_
* Thursday--Saturday, 2024-03-07 to 2024-03-09, 7:30 p.m.
  _Songs of the Scarlet and Wayback_ (play).
* Friday at 4pm in the Global Living Room.
  _Middle of Everywhere_.
* Saturday, 2024-03-09, Harris Cinema, ??:??
  _Met Opera: Verdi's La Forza del Destino_.
* Saturday, 2024-03-09, 2:00 pm, Sebring-Lewis.
  _ZAWA!_ (Flute concert).

Peer

* Saturday, 2024-03-09, Field House.
  _Men's Tennis vs. Central._

Wellness

* Tuesday, 2024-03-05, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-03-05, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-03-05, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.
* Wednesday, 2024-03-06, 4pm, JRC 101.
  _Intimacy Stages_.
* Friday, 2024-03-08, noon, JRC 101.
  _Wellness Bingo_.

Misc

### Other good things to do (no tokens)

Some notes on MP5
-----------------

### Primary goals

* Experience building *part* of a project (e.g., a library for others to
  use).
* Further understanding the use of your `AssociativeArray` class.
* Practice "wrapping" objects/classes (`AACCategory` primarily wraps 
  `AssociativeArray` in that its primary functionality requires us to
  call `AssociativeArray` methods).
* Reflection on your responsibilities as a software developer.
* Some consideration of APIs (Is the one you were given good? How could
  it be improved?)
* Give you the start of something that could become a bigger personal
  project.

### Other comments

Once again, a reminder that _Without looking at any resources (e.g.,
readings, labs, your notes), write down everything you know that
might be useful for this assignment_ exists to encourage you to
start dumping your brain. You can also use it as an opportunity to
do "free writing" on some of the key methods or classes.

Also: I ask you do to the pre-reflection to encourage you to read
the assignment carefully a few days before it is due. Responses
that say "I haven't really read it" should not suffice.

A lot of you seem to be reluctant to get started. What would help you? Should I reserve time on Fridays for demoing how to get started?

Also: This assignment is less scary than it looks!

### Questions

Questions
---------

### Administrative

### LAs

### Other topics

Analyzing algorithms
--------------------

Our goal as programmers / computer scientists is to build algorithms
that (help us) solve problems.  We also build data structures to help
with that.

We want to know things about our algorithms, so that we can, for
example, decide which algorithm is best for our particular problem.

Terminology/Informal notions
----------------------------

Common classes of functions
---------------------------

Analyzing iterative algorithms
------------------------------

Analyzing loops
---------------

A more formal definition
------------------------

