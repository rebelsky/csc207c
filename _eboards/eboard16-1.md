---
title: "Eboard 16 (Section 1): Searching"
number: 16
section: eboards
held: 2024-10-29
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
* Lab

Preliminaries
-------------

### News / Notes / Etc.

* Welcome back from break!
* Grab an official class pen.
* It's good to be back in the class.
* I'm struggling to catch up on everything, but I'm trying. Please DM me
  with questions.
* I'll do reading responses for today's class on Thursday.
* I'll be leaving class a few minutes early today.

### Upcoming work

* TODAY: Tuesday, 2024-10-29
    * Consider submitting [Writeup from lab 16: Searching](https://www.gradescope.com/courses/818402/assignments/5237052)
* Wednesday, 2024-10-30
   * Submit [Writeup from lab 16: Searching](https://www.gradescope.com/courses/818402/assignments/5237052)
   * Read [Sorting basics](../readings/sorting)
   * Submit [Reading responses for class 17](https://www.gradescope.com/courses/818402/assignments/5237054)
* Thursday, 2024-10-31
    * No lab! It's a talk day.
    * [Mini-project 7](../mps/mp07) assigned.
* Sunday, 2024-11-03
    * [Submit pre-reflection for MP7]()
* Monday, 2024-11-04
    * Some random readings.
* Tuesday, 2024-11-05
    * SoLA 7 (forthcoming)

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-10-29, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table_
* Thursday, 2024-10-31, 4:00--5:00 p.m., Science 3821.
  _CS Extras: Data Science_
* Sunday, 2024-11-03, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_
* Tuesday, 2024-11-05, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table_

#### Cultural

* Friday, 2024-11-01, 7:30--9:00 p.m., Sebring-Lewis.
  _The Infinite Wrench_.

#### Multicultural

* ???, ????-??-??, Day of the Dead Event
* Friday, 2024-11-01, 4:00-5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_ 

#### Peer

#### Wellness

* Friday, 2024-11-01, Noon--1:00 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Yoga_.

#### Misc

### Other good things (no tokens)

Questions
---------

### Administrative

**What did it mean that SoLA 6 was optional?**

> It meant that you didn't have to do it.

**But I don't have to do any SoLAs!**

> It was a bit more optional than most.

**Will the new questions on SoLA 6 appear on other SoLAs?**

> Yes. You can pretend that they are new for SoLA 7. There will also be
  a few other new ones for SoLA 7. (We need about 5--6 new LAs per SoLA.)

**I'm almost out of token space. Will you add more?**

> Yes. I guess I should read those.

**Do therapy dogs count for tokens?**

> Yes. But I prefer if you remind me so that they get on the list (so that
  I can remind others).

**Do yoga and forest bathing count for tokens?**

> Yes. But I prefer if you remind me so that they get on the list (so that
  I can remind others).

### Readings

**Can we talk about loop invariants?**

> We will do a loop invariants problem on Thursday.

### Miscellaneous

Lab
---

The person closer to the board is Driver A. The person further from the board is Driver B.

Make sure that the name of the repo ends with `-maven`.

### Questions

**What's this with `(str) -> ...`?**

> That's a lambda, a cool feature of Java when you have interfaces that
  specify only one function.

> This build a new Predicate with a test method whose body is the ellipses.

> `SearchUtils.search(strings, (str) -> str.length() < 5);`

**Are there other ways to make predicates?**

> Sure. You could use an anonymous inner class or you could even make a
  named class.

**What would the AIC look like?**

> ```
    Predicate<String> lessThanFiveChars = new Predicate<String>() {
      public boolean test(String str) {
        ...
      } // test(String)
    };
```

**How do I iterate an `Iterable`?**

> With a for-each loop.

> ```java
    for (TYPE VAR : ITERABLE) {
      ...
    } // for
```

**How should we find the midpoint of the region given by `lb` and `ub`?**

> Most people use `(lb + ub) / 2`.

> I prefer `lb + (ub - lb) / 2`.

> You could also use `lb / 2 + ub / 2 + ...`, where the ellipses handle the
  issue that both might be odd. This one is probably safest.

### Oh no! It's storytime with Sam!

* Many programmers write binary search wrong, even though it's a well-known
  algorithm.
* Good testing helps.
* Even "provably correct" code can be wrong if we're not careful about what
  we're proving.
