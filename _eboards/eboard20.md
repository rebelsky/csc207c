---
title: "Eboard 20: Analyzing recursive procedures"
number: 20
section: eboards
held: 2024-03-06
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia
* Questions
* Review of our loop problem from last class
* A more formal definition of Big-O
* Analyzing recursive procedures

Preliminaries
-------------

* Looking ahead: 
* The new tokens assignment is posted. I'm working on copying things
  over from the old tokens assignment.
* Sorry that grading is so slow. I'm trying!
* MP6 will be coming out tomorrow. Sorry for the delay.

### Upcoming work

* Wednesday, 2024-03-06, 11pm, [MP5](../mps/mp05)
    * [_Submit MP5 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180584/)
* Friday, 2024-03-08, 1pm, Readings
    * [The Java Tutorial: Lambda expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions)
    * Review [Priority QUeues](../readings/priority-queues).
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

* Thursday, 2024-03-07, 11:00 a.m.,JRC 101.
  _Scholars' Convocation: An American Genocide: The United States and 
   the California Indian Catastrophe, 1846-1873_
* Thursday, 2024-03-07, 4:00 p.m., Science 3821.
  _CS Extras_.
* Tuesday, 2024-03-12, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-02-12, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.

Cultural

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

Questions
---------

### Administrative

### LAs

### Other topics


One more loop to count
----------------------

```
int count;
for (int i = 1; i <= n; i *= 2) {
  for (int j = 0; j < i; j++) {
    count++;
  } // for
} // for
```

Is this O(2.5^n) O(n^2), O(nlogn), O(n), O(logn), O(1) or ...?

It's definitely O(n^100). We want a tighter bound.

A more formal definition
------------------------

Why have Big-O?
---------------

Analyzing recursive algorithms
------------------------------

Practice
--------

Merge sort!
