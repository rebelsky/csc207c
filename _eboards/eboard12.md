---
title: "Eboard 12: Exceptions"
number: 12
section: eboards
held: 2024-02-16
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
* Please DM me your GitHub username if you haven't already. (I'll start
  adding you during the beginning of lab.)

### Upcoming work

* 11pm Friday, 2024-02-16: MP3 Post-Reflections
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4102633/submissions)
* 11pm Friday, 2024-02-16: MP4 Pre-Reflections
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4102636)
* 11pm Sunday, 2024-02-18: Reading on Inheritance 
    * [_Submit on Gradescope_](...)

### Tokens

Academic/Scholarly

* Tuesday, 2024-02-20, noon--1:00pm, Some PDR.
  _CS Table: ???.
* Tuesday, 2024-02-20, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.
* Thursday, 2024-02-22, 4:00-5:00pm, Science ????.
  _CSC Major Declaration Session_.

Cultural

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

### Friday PSA

* You are awesome.
* People care about you.
* Please take care of yourselves.
* Be moderate in what you consume.
* CONSENT IS ESSENTIAL.

Questions
---------

When will the LAs start appearing?

> Monday. Thanks for the reminder.

How do we do an LA?

> Respond with some combination of explanation and code. You are choosing
  and providing evidence that you have mastered the learning objective.

> You'll probably end up with about a week.

Are LAs timed?

> No. But they do have a due date/time, so I suppose that's one kind of
  time limit.

How long should an LA take?

> If you've really mastered the material, I would hope that it would
  take you about fifteen minutes to do most LAs.

Wow! Only twelve hours to do all the LAs if I get them right the first
time. Thank you Sam!

> You're welcome.

Lab
---

<https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Sp/labs/exceptions.html>

### Working with packages in VSCode

Note: When you are in VSCode, you should be opening/working with the folder 
that contains the `src` directory.

### Using `git`

Note: Here's the traditional `git push` sequence.

    git add FILE
    git commit FILE -m "commit message"
    git pull
    # Deal with merge errors (hopefully none)
    git push

View -> Source Control lets you use a UI to do the Git stuff.

### NaN

Not a number

### Primary things you learned?

* We got practice testing.
* `assertEquals` expects three parameters when you're comparing doubles.
  (The third parameter is "epsilon", how close the two results should be.)
* `Math.sqrt` does not throw an exception if given a negative parameter.
* You need to say that your code is throwing an exception.
* Adding `throws Exception` in one place may break code elsewhere.
    * You should think about exceptions early in your design.
