---
title: "Eboard 19: Big-O (for real this time)"
number: 19
section: eboards
held: 2024-03-04
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed.**

_Approximate overview_

* Administrivia
* Some notes on MP5
* Questions
* Alumni visit

Preliminaries
-------------

* I hope you enjoyed the sunny weekend.

### Upcoming work

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

Peer

Wellness

* Tuesday, 2024-03-05, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-03-05, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-03-05, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

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

### Questions

In the `AACCategory` class methods do we have to use `getCategory` to check if the image is in the category in the `getImages`, `getText`, and `hasImage` function or are we making an assumption that everything that we call in this class is part of the same category?

> You do not need to use it to check if an image is in a particular category.
  Rather, we use it primarily in case the client code needs to identify
  the category (e.g., to speak it aloud).

> We wil use it primarily to support the `getCurrentCategory` method in
  `AACMappings`.

> In a hidden design issue, the UI looks for a category of `""` to decide
  whether it's working with the top level.

Questions
---------

### Administrative

### LAs

### Other topics

Big-O Notation
--------------

