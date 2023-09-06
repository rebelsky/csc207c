---
title: "EBoard 06 (Section 1): Classes"
number: 6
section: eboards
held: 2023-09-06
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  (There may not be audio,
  but it's being recorded.)

_Getting started_ (this will be our normal start-of-class sequence)

**Updated for Covid**

* Grab a card.  The card will have a computer name and a location.
* Remember the name and location.
* Drop the card back in the jar.
* Navigate to the computer.
* If you arrive first, _grab a disinfectant cloth, clean off the work
  area (particularly the keyboard)_, log in and load the lab, but don't 
  start.
* When both partners arrive, introduce yourselves.

_Approximate overview_

* Administrivia
* Debrief
* Questions
* Lab

Administrivia
-------------

### Introductory notes

* Covid and other illnesses remains issues.  Consider masking.  Clean
  your keyboards.
* Remember: Support is available
    * Mentor sessions: Sundays 4-5 pm somewhere.
    * Evening tutors: Sunday 3-5, Sunday-Thursday 7-10pm in 3813/3815.
    * Sam (via office hours, email, and Teams Chat).
    * Individual tutors.
* GitHub is not being nice to some of you.  I'll try to help during class.

### Upcoming Token activities

Academic

* CS Extras, Thursday, 4:15 pm, Science 3821.  Graduate school
* Convocation, tomorrow, 11am, HSSC A2231 (Auditorium).
  Vincent Lloyd on _Abolitionism: Religious Criticism or Secular Criticism?_
    * Insert Sam's convocation spiel.
* Poetry reading 4:15 today in the Kernel (multi-purpose room) in the HSSC.
  It should be really interesting.  First transgender professor at Yeshiva
  University.  Draws upon book of Isaiah and Cosmopolitan Magazine.

Cultural

Peer

Wellness

### Upcoming work

* Readings for Friday.  (Do before class; nothing to turn in.  _Please_ ask
  questions on Teams.)
    * Not ready yet.  Stay tuned.
* MP 1 due Thursday.
* MP 1 post-assessment due Friday night.  (Do it after you turn in the
  assignment on Thursday.)
* MP 2 distributed Friday.

### Attending class remotely

_Given the illnesses going around campus, some of you may need to
attend class remotely.  That's fine, but please try not to make it
your norm._

a. Let me know via email that you will not be in class.

b. You are still responsible for the work.  Plan to do the lab on your own.

c. Synchronous: If you wish, you can join the Teams Meeting during
   class.  That gives you an opportunity to hear what I say and ask
   me questions.

d. Asynchronous: If not, I recommend that you check the recording
   and the eboard.  (You may want to check those anyway.)

e. Let me know if you need extra time on any assignments.

Debrief on Monday's lab
-----------------------

* Modern programming tools: When they work, they seem transparent.  When
  they don't work, it's often a PITA to figure out what's going wrong.
* Since we each may have different settings, what works for one person
  may not work for another.
* Sam changes labs and other materials regularly.  Make sure you have the
  latest version with ctrl-r (reload)
* Sam is cruel and mean and makes us use command-line tools when the 
  GUIs are much easier to use.
* It appears that the designers of programming tools assume everyone
  knows JSON.
* Output is weird in Java.  If you don't flush the buffer, things
  don't appear.  (If you don't set autoflush to true when creating
  the PrintWriter, you don't even see stuff when you print a newline.)

Questions
---------

Why are you making us use the terminal for GitHub when there are nice UIs?

> The terminal is always a good fallback.  (Your UIs aren't always
  available.)

> May give you a better understanding of the steps.

> You can use the UIs if you'd like.

> I tend to be a command-line person.

Classes lab
-----------

Welcome to the boring part of the recording.

Note: Links to the Javadoc now appear in the lab.  (Hmmm ....)

Note: `toReal` should be `doubleValue`.

Plan to finish up the lab with your partner (or on your own).

Sam will hang around to answer questions.

Debrief / Some important lessons
--------------------------------

* We work at different speeds.
* OOP encourages a different way of thinking.  Instead of "multiply x and
  y", we tend to write "tell x to multiply itself by y". 
    * One of the parameters is (usually) implicit
* When you work with a language that has libraries, you have to get used
  to reading the documentation for those libraries.  For example, strings
  have `indexOf`, `split`, `subString`, and more.
* The core Java libraries are not necessarily designed consistently.  For
  example, why do we create a new `BigInteger` from an `int` with
  `BigInteger.valueOf(i)` rather than `new BigInteger(i)`?
