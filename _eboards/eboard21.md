---
title: "Eboard 21: Anonymous classes (functions?)"
number: 21
section: eboards
held: 2024-03-08
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Pop Quiz [20 min]
* Administrivia [??]
* Questions [??]
* Lab [Whatever's left]

Preliminaries
-------------

* Happy International Women's Day!
* Looking ahead: You will be getting your sleep disrupted this weekend.
* The next set of LAs will be due next Friday. Sorry about the confusion.
* If you have questions for me on a homework assignment, the best thing
  to do is to give me a link to your GitHub repo along with your question.
* Your pop quiz is intended to serve as your "analyze recursive functions
  LA". If you didn't get it today, you'll have another chance.
* I tried to print today's quiz. Unfortunately, I'd given my keys to
  someone else and couldn't get to the printer. Sorry.

### Upcoming work

* Sunday, 2024-03-10, 11pm, [MP1](../mp1) redo
    * [_Submit MP1 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180612/)
    * Please don't submit until it's ready for grading.
* Sunday, 2024-03-10, 11pm, [MP2](../mp2) redo
    * [_Submit MP2 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180615/)
    * Please ask if you're confused about something.
* Sunday, 2024-03-10, 11pm, [MP5](../mps/mp05)
    * [_Submit MP5 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180584/)
* Sunday, 2024-03-10, 11pm, Readings (no reflections)
    * [Searching](../readings/search)
    * [Loop Invariants](../readings/loop-invariants)
* Tuesday, 2024-03-12, 11pm, MP5 post reflection
* Friday, 2024-03-15, 11pm, Third set of LAs.

### Tokens

Academic/Scholarly

* Tuesday, 2024-03-12, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-02-12, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.

Cultural

* Friday at 4pm in the Global Living Room.
  _Middle of Everywhere_.
* Saturday, 2024-03-09, Harris Cinema, ??:??
  _Met Opera: Verdi's La Forza del Destino_.
* Saturday, 2024-03-09, 2:00 pm, Sebring-Lewis.
  _ZAWA!_ (Flute concert).

Peer

* Friday--Saturday, 2024-03-08 to 2024-03-09, 7:30 p.m.
  _Songs of the Scarlet and Wayback_ (play).
* Friday, 2024-03-08, 4:00--6:00 p.m. Art Museum
  International _Women's Day Presentations_.
* Saturday, 2024-03-09, Field House.
  _Men's and Women's Tennis vs. Central._

Wellness

* Tuesday, 2024-03-12, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-03-12, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-03-12, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

### Other good things to do (no tokens)

### Friday PSA

* Please take of yourselves; others care about you.
* Please be moderate in all that you do.
* Obtain consent. Go beyond consent.

Questions
---------

### Administrative

### MP5

### Lambdas

What's an abstract method?

> An abstract method is one that is not implemented; it's provided as
  a signature only.

> Like what we've seen in what I've told you about interfaces.

> Java also permits you to put methods with code in interfaces and allows
  you to skip implementations in clsases, so there's a distinction between
  methods with code and methods without code. The latter are abstract.

### Other topics

Lab
---

To create the list of `Person` objects, can I just write
`List<Person> people = Person.createRoster()`?

> Sure. However, you get a relatively boring set of people.

> Be careful not to use `Person.createRooster()`. The last time I checked,
  roosters weren't people.

