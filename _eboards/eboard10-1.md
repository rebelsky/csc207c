---
title: "Eboard 10 (Section 1): Inheritance"
number: 10
section: eboards
held: 2024-10-01
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

### News / Etc.

* Why is that I keep saying "Don't use `git add .`; add the files individually",
  and you folks keep typing `git add .`?
* It's been suggested that I remind you that when you submit code to Gradescope
  from GitHub, and then update the code on GitHub, it doesn't automatically.
  get updated on Gradescope.
    * Also: GitHub submission is the preferred mechanism.

### Another note on pre-reflections

_#4: What resources (e.g., individual procedures you've written, readings, labs) will be helpful as you work on this assignment?_

This question is intended to encourage you to gather resources.

I don't want to see "labs and readings". I want to see particular labs and particular readings, along with URLs, so that it's clear that you've pulled resources together.

### Upcoming work

* Today, 2024-10-01
    * Consider submitting [lab writeup for class 10](https://www.gradescope.com/courses/818402/assignments/5024091)
* Wednesday, 2024-10-02
    * Readings
        * [Linear Structures](../readings/linear-structures)
        * [Stacks](../readings/stacks)
        * [Queues](../readings/queues)
        * [Priority queues](../readings/priority-queues)
    * [Submit reading response on Gradescope](https://www.gradescope.com/courses/818402/assignments/5041948)
    * [Submit lab writeup for class 10 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5024091)
        * I'd prefer that you submit after the lab.
* Thursday, 2024-10-03
    * Consider submitting [lab writeup for class 11](...)
    * [Mini-project 4](../mps/mp04) due (including tests).
    * [Submit MP4 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5025153)
    * Consider submitting [post-reflection for MP4](https://www.gradescope.com/courses/818402/assignments/5025144).
* Friday, 2024-10-04
    * [Submit post-reflection for MP4](https://www.gradescope.com/courses/818402/assignments/5025144)
* sunday, 2024-10-06
    * [Submit pre-reflection for MP5](...)
* Monday, 2024-10-07
    * Readings
    * [Submit readings on Gradescope](...)
    * [Submit today's lab on Gradescope](...)
    * [SoLA 4](../sola04)
        * New OOP LAs
            * OOP #2
            * OOP #6
        * New Development LAs
            *
            *
            *
            *
        * Consult [the SoLA](../sola04) for redos.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-10-01, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table: When Robots Attack (or something like that)_
* Sunday, 2024-10-06, 7:00--9:00 p.m., Science 3819.
  _Mentor Session_

#### Cultural

* Tuesday, 2024-10-01, 11:00a.m.--Noon, Bucksbaum 131.
  _Royce Wolf Recital_

#### Multicultural

* Tuesday, 2024-10-01, 1:00--2:15 p.m., Steiner 205.
  _Crip SpaceTime watch party_
* Friday, 2024-10-04, 4:00-5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_

#### Peer

* Friday, 2024-10-04, 5:30--8:30 p.m., Natatorium.
  _Scarlet and Black_

#### Wellness

* Tuesday, 2024-10-01, 4:30--6:30 p.m., BRAC P103 (Dance Studio).
  _Wellness Yoga_
* Tuesday, 2024-10-01, 4:30--6:30 p.m., ???.
  _Forest Bathing_ (signup required)

#### Misc

* Friday, 2024-10-04--Sunday, 2024-10-06. JRC 101.
  _Pioneer Weekend_

### Other good things (no tokens)

* Tuesday, 2024-10-01, 4:30--6:30 p.m., Springer Field.
  _Men's Soccer vs. Knox_
* Tuesday, 2024-10-01, 7:00--9:00 p.m., Darby.
  _Volleyball vs. Beloit_
* Wednesday, 2024-10-02, 4:00--6:00 p.m., Springer Field.
  _Women's Soccer vs. Knox_

Questions
---------

### Questions on SoLAs

**Why does it take you so long to get SoLAs back to us?**

> It's the nature of the beast. I probably spend five minutes on each submission. 5 x 40 x 5 = 600, or about ten hours. (I expect time to go down as you start getting used to LAs, so I can just check "Satisfactory".)

### Questions on MP4

### Other administrative questions

### Questions on the readings

#### Old

**Is the way inheritance works in a way that pointers do?**

> Inheritance requires pointers (or "references") behind the scenes,
  but it's more the concept that you automatically delegate method
  calls to the parent class, which I'd say is independent of pointers.

**What should I do if I want to inherit from three classes, ex
SmileStudentTeacherChef? (I felt composition + inheritence could
only deal with 2 parent classes.)**

> Use composition. Composition can handle an arbitrary number of
  delegated classes. It's just a bit more work on your end.

#### New

### Other questions

Lab
---

The person closer to the board is Driver A. The person further from the board is Driver B.

Make sure that the name of the repo ends with `-maven`.

