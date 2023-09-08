---
title: "EBoard 07: Mental Models of Memory"
number: 7
section: eboards
held: 2023-09-08
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.

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
* About MP2
* Debrief
* On memory
* On the representation of objects
* Back to expandable arrays

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
* I hear that my email sometimes shows up as encrypted.  It's not.
  Microsoft just writes bad software.  I've stopped digitally signing
  my email, which should address the problem.
* Office hours:
    * Please try to book using <https://bit.ly/book-samr>.
    * If I don't seem to have office hours available, it's because (a) they
      are already booked or (b) I have a conflicting obligation.  Feel free
      to use the Outlook scheduling assistant to suggest another time.
    * You can also wander by during my office hours.  If I'm free, I'll
      be there.  However, I am sometimes meeting people elsewhere.
* I'm stopping the Otter.ai transcription.  Let me know if you want me
  to restart it.  (I'll still do the Teams recordings.)

### Upcoming Token activities

Academic

* CS Table, Tuesday, Noon, Day PDR.  ???
* CS Extras, Thursday, 4:15 pm, Science 3821.  ???

Cultural

Peer

Wellness

### Upcoming work

* Tonight: MP2 post-assessment
* Monday (before class): Do the readings.
* Monday evening: MP2 pre-assessment
* Thursday: MP2

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

About MP2
---------

* Still being updated, but the framework is there.

Debrief on Wednesday's lab
--------------------------

Questions
---------

About Memory
------------

We treat memory as one big address space (effectively, an array of bytes 
or words).

```
         +--------------+
      0  |              |
         +--------------+
      1  |              |
         +--------------+
      2  |              |
         +--------------+
      3  |              |
         +--------------+
         |              |

                .
                .
                .

         |              |
         +--------------+
  0xffff |              |       That's a made up address.
         +--------------+
```

There are three kinds of things we need to store in memory (or reference
from memory).

Representing Objects and Classes
--------------------------------

We'll step back a bit from our pure representation of memory ...
