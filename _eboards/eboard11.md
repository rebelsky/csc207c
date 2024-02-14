---
title: "Eboard 11: Generics"
number: 11
section: eboards
held: 2024-02-14
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed.**

_Approximate overview_

* Administrivia
* Questions
* Lab

Preliminaries
-------------

* Sam broke his hearing aids and hears even less well than normal.

### Upcoming work

* 11pm Wednesday, 2024-02-14: [Mini Project 3](../mps/mp03)
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4080604/)
* 11pm Thursday, 2024-02-15: Reading on Exceptions
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4090750)
* 1pm Friday, 2024-02-16: Wednesdays's lab writeup.
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4080411/)

### Tokens

Academic/Scholarly

* Thursday, 2024-02-15, 11:00--noon, JRC 101.
  _Scholars' Convocation: Gaile Pohlhaus on "An Epistemology of 
   the Oppressed: Resisting and Flourishing under Epistemic Oppression"._
     * You can also talk to the speaker.
* Thursday, 2024-02-15, 4:00pm, Science 3821.
  _CS Extras: PM Osera_.
* Tuesday, 2024-02-20, noon--1:00pm, Some PDR.
  _CS Table: ???.
* Tuesday, 2024-02-20, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.

Cultural

* Thursday, 2024-02-15, 7:00--9:00pm, Sebring-Lewis.
  _Jazz Concert w/Carol Welsman_.
* Friday, 2024-02-16, 4:00--5:00pm, HSSC N1170 (Global Living Room).
  _Middle of Everywhere._
* Sunday, 2024-02-18, 7:00--9:00pm, Harris Cinema.
  _The Moth Storytelling Slam_.

Peer

* Friday through Sunday, 2024-02-16 through 2024-02-18. Osgood Pool.
  _Midwest Swimming and Diving Conference Championships_.
    * 30 minutes counts.
    * Up to two separate sessions.
* Saturday, 2024-02-17, 2:00--5:00pm, Field House.
  _Women's Tennis vs. Ottwawa_.

Wellness

* Tuesday, 2024-02-20, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-02-20, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._ (I think)
* Tuesday, 2024-02-20, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

### Good things to do (no tokens)

* Saturday, 2024-02-17, 1:00--3:00pm, Darby.
  _Men's Basketball vs. Monmouth_.
* Saturday, 2024-02-17, 3:00--5:00pm, Darby.
  _Women's Basketball vs. Monmouth_.

Questions
---------

### Administrative

### MP3

### Generics

What is a "functional interface" (from the java documentation for Function)?

> One in which there is only one non-default method, which means that we can implement it with a lambda expression.

What is the difference between `andThen` and `compose`? (from Java documentation for `Function`)

> Both compose functions. `andThen` builds a new function that applies the parameter function *after* the current function while `compose` builds a new function that applies the parameter *before* the current function.

> For example, if `dub` is a function that doubles its parameter and `inc` is a function that adds one, `dub.andThen(inc).apply(5)` would double 5, giving 10, and then add 1, giving 111.

> In contrast, `dub.compose(inc).apply(5)` would increment 5 first, giving 6, and then double it, giving 12.
  
