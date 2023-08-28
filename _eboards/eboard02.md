---
title: "EBoard 02 (Section 1): Getting started with Java"
number: 2
section: eboards
held: 2023-08-28
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.

_Getting started_ (this will be our normal start-of-class sequence)

* Grab a card.  The card will have a computer name and a location.
* Remember the name and location.
* Drop the card back in the jar.
* Navigate to the computer.
* If you arrive first, start the lab.
* When both partners arrive, introduce yourselves.

For the future: I'm happy to reserve a (somewhat random) seat at
the front of the classroom for those who need a front seat as an
adjustment or accommodation.  Just let me know.

_Approximate overview_

* Administrative stuff [10--15 min]
* Questions on readings.
* Lab

Administrivia
-------------

### Introductory notes

* I'm still Sam (or SamR).
* Our mentors are still Micah and Pom.
* I tend to respond faster to Direct Messages (Chat) on Teams than email.
* I will do my best to post a link to the Otter.ai transcript on Teams,
  in the recordings channel.
* Even though Sam is providing notes, you should also take your own;
  there is evidence that doing so helps you learn and remember.
* Our class site is still under development.  Let me know if you find
  things missing, including images.
    * I know that one of the two Wednesday readings is missing.  Expect
      it on Tuesday.  (Sorry.)
* I'll attempt quick attendance.

### Upcoming Token activities

Academic

* Convocation, Thursday, 11:00 a.m.  President Harris.

Cultural

Peer

Wellness

### Upcoming work

* Introductory survey and syllabus questions due tonight at 10:30 p.m.
* Readings for Wednesday.  (Do before class; nothing to turn in.  Ask
  questions on Teams.)
* Lab from today due before class on Wednesday.

### Administrative questions (e.g., about the syllabus)

Do we really have SoLAs?

> No.

Are you going to post readings from the book?

> Um ... yeah, that's in the plan.  We'll be using CLRS starting around
  week six.

> We'll mostly be using my readings.  CLRS provides more formality.

> There are old editions of CLRS in the CS learning center and a legal free
  edition online through the library.

Questions on the readings
-------------------------

Lab
---

* Sam will try to figure out problems with the style sheet.  [Done.]
* For the FizzBuzz problem, in `main`, create a `PrintWriter` named `pen` and
  use `fizzbuzz(pen, 100)`.
* Goal is to finish the ArrayProblems.java by next class.
    * Together is great.
    * On your own is fine.

Debrief
-------

* Sam prefers that you use `PrintWriter` objects rather than `System.out`
  because it makes it easier to change the behavior of your program.
    * Print the first 100 lines of FizzBuzz to stdout:
      `fizzbuzz(new PrintWriter(System.out, true), 100)`
    * Print the first 1000 lines of FizzBuzz to the file "killbuzz.txt":
      `fizzbuzz(new PrintWriter(new File("killbuzz.txt"), 1000))`
* FizzBuzz is a traditional problem that early programmers seems to struggle
  with.  (It is, unfortunately, also a drinking game.)

### Two approaches to FizzBuzz

A standard approach: Four cases (multiple of 15, multiple of 5, multiple
of 3, anything else)

```
    if (i % 15 == 0) {
      pen.println("fizzbuzz");
    }
    else if (i % 5 == 0) {
      pen.println("buzz");
    }
    else if (i % 3 == 0) {
      pen.println("fizz");
    }
    else {
      pen.println(i);
    }
```

An alternate approach: Always print fizz when it's a multiple of 3,
always print buzz when it's a multiple of 5, add appropriate extra
stuff.

```
    boolean printed = false;
    if (i % 3 == 0) {
      pen.print("fizz");
      printed = true;
    }
    if (i % 5 == 0) {
      pen.print("buzz");
      printed = true;
    }
    if (!printed) {
      pen.print(i);
    }
    pen.println();
```

