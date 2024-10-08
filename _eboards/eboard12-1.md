---
title: "Eboard 12 (Section 1): Array-based structures"
number: 12
section: eboards
held: 2024-10-08
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  [at least if Sam is here and can get the technology working]

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* Questions
* Lab

Preliminaries
-------------

### News / Notes / Etc.

* _We have a substitute today. I anticipate that we will continue to have 
  substitutes for the near future._

### Upcoming work

* TODAY: Tuesday, 2024-10-08
    * Consider submitting [Writeup from lab 12: Array-based structures](https://www.gradescope.com/courses/818402/assignments/5119960)
    * [Redo of MP1](https://www.gradescope.com/courses/818402/assignments/5066068)
        * Include the file `CHANGES.md` that indicates what changes you made.
          Our graders have limited time. Don't make them regrade from scratch.
* Wednesday, 2024-10-09
    * [Submit writeup from lab 12: Array-based structures](https://www.gradescope.com/courses/818402/assignments/5119960)
    * Readings
        * [Anonymous inner classes](../readings/anonymous-inner-classes)
        * [Iterators](../readings/iterators)
        * [Comparators](../readings/comparators)
        * [The Java Tutorial: Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
    * [Submit reading responses for class 13 on Gradescope]()
        * These will be on the lambda reading.
* Thursday, 2024-10-10
    * [Mini-Project 5](../mps/mp05) due.
    * [Mini-project 6](../mps/mp06) assigned.
    * [Submit MP5 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5066339).
    * [Consider submitting post-reflection on MP5](https://www.gradescope.com/courses/818402/assignments/5066324)
    * [Consider submitting writeup from lab 13: Comparators and iterators](https://www.gradescope.com/courses/818402/assignments/5119963)
* Friday, 2024-10-11
    * [Submit post-reflection for MP5](https://www.gradescope.com/courses/818402/assignments/5066324)
* Sunday, 2024-10-13
    * [Submit pre-reflection for MP6](https://www.gradescope.com/courses/818402/assignments/5119976)
* Monday, 2024-10-14
    * Readings
        * CLRS 3 (Characterizing Running Times)
    * No reading responses due!
    * [Submit lab writeup from class 13 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5119963)
    * [SoLA 5](../sola05)
        * [ADT/DS #02: Stacks](https://www.gradescope.com/courses/818402/assignments/5120057)
        * [ADT/DS #03: Queues](https://www.gradescope.com/courses/818402/assignments/5120063)
        * [ADT/DS #10: Array-based structures](https://www.gradescope.com/courses/818402/assignments/5120076)
        * [Development #08: Build libraries](https://www.gradescope.com/courses/818402/assignments/5120138)
        * [OOP #09: Mental models](https://www.gradescope.com/courses/818402/assignments/5120088)
        * Consult [the SoLA](../sola05) for links to LA redos (should be
          available by Wednesday).
* Tuesday, 2024-10-15
    * [Redo of MP2](https://www.gradescope.com/courses/818402/assignments/5109213)
        * Include the file `CHANGES.md` that indicates what changes you made.
          Our graders have limited time. Don't make them regrade from scratch.
* Thursday, 2024-10-16
    * [MP6](../mps/mp06) due
    * [Submit MP6 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5119986)
    * [Consider submitting post-reflection for MP6](https://www.gradescope.com/courses/818402/assignments/5119978)
* Friday, 2024-10-18
    * [Submit post-reflection for MP6](https://www.gradescope.com/courses/818402/assignments/5119978)

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-10-08, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table_
* Thursday, 2024-10-11, 11:00 a.m.--Noon, JRC 101.
  _Scholars' Convocation: 
   Kathleen Belew - "White Nationalism and the 2024 Election"_
* Thursday, 2024-10-11, 4:00--5:00 p.m., Science 3821.
  _Something related to jobs_
* Thursday, 2024-10-10, 7:00--8:30 p.m., HSSC A2231 Auditorium.
  _Humanities Speaker: Eric Zimmer - 
   "Reclaiming the Indigenous Midwest: The Meskwaki Settlement as #Landback"_
* Sunday, 2024-10-13, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_
* Tuesday, 2024-10-15, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table_

#### Cultural

#### Multicultural

* Friday, 2024-10-11, 4:00-5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_ 
* Friday, 2024-10-18, 4:00-5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_ 

#### Peer

* Saturday, 2024-10-12, 1:00-4:00 p.m., Osgood Pool.
  _Swimming Triangular_

#### Wellness

* Tuesday, 2024-10-08, 4:30--6:30 p.m., BRAC P103 (Dance Studio).
  _Wellness Yoga_
* Tuesday, 2024-10-08, 4:30--6:30 p.m., ???.
  _Forest Bathing_ (signup required)
* Thursday, 2024-10-10, 6:00--7:00 p.m., HSSC A1231.
  _Procrastination To-Do List Worksohp_
* Monday, 2024-10-14, 5:30--7:30 p.m., JRC 101.
  _Indigenous People’s Day Wellness Tea_

#### Misc

### Other good things (no tokens)

* Saturday, 2024-10-12, 1:00--4:00 p.m., Rosenbloom Field.
  _Football vs. Monmouth_

Questions
---------

### Administrative

### Readings

**Can you explain a bit more about iterators?**

> You'll get more accustomed to iterators as we go. But, in essence,
  an iterator gives you access to the elements of a collection one
  value at a time.

> We have [a reading on iterators](../readings/iterators) for the next
  class period.

### Miscellaneous

**I don't understand what super() and when it should be used.**

> `super()` is generally a call to the constructor of the superclass.
  (`super.X is how you refer to most things in the superclass). You
  can only call the superclass constructor as the first line of your
  constructor; if you don't Java automatically calls the zero-ary
  constructor of the parent.

Lab
---

The person closer to the board is Driver A. The person further from the board is Driver B.

Make sure that the name of the repo ends with `-maven`.

