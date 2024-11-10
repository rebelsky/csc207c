---
title: "Eboard 20 (Section 1): Ethics, revisited"
number: 20
section: eboards
held: 2024-11-11
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* Questions
* Analyzing merge sort
* Quicksort
* Lab

Preliminaries
-------------

### News / Notes / Etc.

* We're back to talking today. Thursday should be lab.
* We will likely spend a bit less time on ethics today than I had originally
  planned. I consider it ethical to make sure that you understand the
  sorting material in order to complete the assignment.
* New office hour approach: Use the Outlook scheduling assistant to 
  schedule 15-minute or 30-minute appointments. I'll generally say yes 
  to requests during the day for times that I'm not booked..
    * SAM WILL DEMO!
* Please review the statement about academic honesty on the SoLA notes
  I sent out yesterday.

### Upcoming work

* Wednesday, 2024-11-12
    * [Reading on trees and tree traversal](../readings/tree-traversal)
    * [Submit reading response on Gradescope](https://www.gradescope.com/courses/818402/assignments/5300048/submissions)
* Thursday, 2024-11-14
    * MP9 released.
    * [MP8](../mps/mp08) due.
    * [Submit MP8 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5284854)
* Friday, 2024-11-15
    * [Submit post-reflection for MP8](https://www.gradescope.com/courses/818402/assignments/5284861)
* Sunday, 2024-11-17
    * Submit pre-reflection for MP9.
* Monday, 2024-11-18
    * [SoLA 9](../los/sola09) due.
    * No reading response!

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-11-12, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table: ???_ 
* Thursday, 2024-11-14, 4:00--5:00 p.m., Science 3821.
  _CS Extras: Securing Emerging Wireless Networks_
* Sunday, 2024-11-17, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_

#### Cultural

* Weekends of November 16 and November 23, Roberts Theatre.
  _Pity_ (also peer)
    * Get tickets at the box office.
* Saturday, 2024-11-16, 2:00--4:00 p.m. (but there's an intermission).
  _Grinnell Symphony Orchestra plays Mozart's symphony number 40._

#### Multicultural

* Friday, 2024-11-08, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Alumni_

#### Peer

* Sunday, 2024-11-10, 2:00 p.m., Sebring-Lewis.
  _Grinnell Singers: Songs of Earth_.

#### Wellness

* Tuesday, 2024-11-12, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-11-12, 4:30--6:30 p.m., Secret Place.
  _Forest Bathing_.
* Tuesday, 2024-11-19, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.

#### Misc

### Other good things (no tokens)

DNF, revisited
--------------

Analyzing merge sort
--------------------

Let's start by writing the recurrence relation.

High-level overview:

*
*
*

Recurrence relation ...

Quicksort
---------

Three key ideas:

* Quicksort is a divide-and-conquer routine
* That attempts to divide the (sub)array into two (or three) parts:
  smaller values and larger values (or smaller, "equal", and larger).
* And does that division using the wonder of randomness.

Questions
---------

### Administrative

**Given that you have not been returning graded MPs promptly, do you 
  anticipate changing the MP requirements for A/B/C?**

> Yes.

### Sorting

**Is there a stable version of Quicksort?** 

> I don't know of a stable _in-place_ version of Quicksort. The parition
  routine rearranges things too much.

### Readings
