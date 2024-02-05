---
title: "Eboard 06: Building classes and objects, continued"
number: 6
section: eboards
held: 2024-02-02
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed. Of course, the technology failed in my earlier class, so perhaps not.**

_Approximate overview_

* Administrivia
* Questions
* Lab

Preliminaries
-------------

* I hope that VSCode and GitHub are now working better for many of you.
  I helped everyone who visited yesterday.
* As you've probably learned, I believe in adapting the class and the
  schedule to what I observe. If you find yourself confused by a topic,
  ask and I'll usually spend time on it.
    * But don't do so just to slow down the course.
* Today's distraction: Remember that GitHub and Copilot normally use
  your prompts as training data unless you stop them from doing so.
    * In GitHub, there's a "don't record" setting. It also stops
      your history. 
    * It looks like Grinnell's license with Microsoft ensures that
      Copilot does not record. Yay!
* My office hours are now posted.
* If I don't respond to email within 24 hours, I've probably lost it or
  forgotten about it, so email again.

### Upcoming work

* Tonight at 11:00 pm Mini-project 1 post-reflection
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/3974722)
* Friday at 11pm: Mini-project 2 pre-reflection
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4043118)
* Sunday at 11pm: Readings
    * [Memory](../readings/memory)
    * [Object semantics](../readings/object-semantics)
        * Not yet ready; should be ready sometime Saturday
    * [_Submit reading on response on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4043126)
* Monday at 1pm: Today's lab
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4031594)
    * Let's hope that we get them finished today.
* Next Wednesday: [Mini Project 2](../mps/mp02)
    * Not yet on Gradescope.

### Tokens

Academic/Scholarly

Cultural

Peer

* Tennis, Sunday, 9 and 4pm, Field house,
  _Matches against Augustana_
* Swim meet this weekend. Saturday 1pm in the Natatorium against Augusta.
* GameDev works-in-progress expo, Saturday, 2-4pm in a room in the HSSC.
  One of the games is "Can you find the room?" (N2110)

Wellness

Misc

* Friday, 2024-02-02, 8pm, Harris Concert Hall:
  _Weekend Murder Mystery_.
* InfoSec survey (stay tuned for email)

### Good things to do (no tokens)

### Friday PSA

* Please take of yourselves and those around.
* Please be moderate.
* Please do not try to mimic what you believe others do; choose what is
  right for you.
* Consent is essential.

Questions
---------

### Administrative

### MP2

Do we have to handle order of operations?

> There is no precedence; you should evaluate operations from left to
  right. There may be an arbitrary number of values and operations on
  each line.

Do we have to use Git for this mini-project?

> No. But this is a good project to expand as a sample of your awesome
  coding abilities.

Can there be multiple operations of different types in the same expression?

> Yes, you can expect `1/2 * 3/4 - 2/3` or `a * 1/2 - b * 1/2`.

> But it's still left-to-right

Should we support parentheses?

> There will not be parentheses in the input.

> If you decide to expand the capabilities, that would be great.

## Miscellaneous

Do we have to use Git/GitHub in the future?

> Yes. And I expect that you do regular commits, too.

Can I see our class on GitHub?

> Probably. I tend to be a believer in openness.

Lab
---

### Preliminaries

Let's hope that everyone can finish!

Make sure to work on the big workstation, not on your individual laptop.
(I suppose LiveShare is fine.)

### Things we might be learning

* As we get started, it often feels like we're missing a parameter. That's
  because there's always an implicit "this" that's doing the work.
* I find it useful to think of method calls as telling objects to do things.
    * "Hey, 1/2, multiply yourself by 1/3"
* It's important to read the documentation (e.g., to figure out how to
  convert strings to `BigInteger` values).
* Clean coding: Put your experiments and tests in a separate file from
  your utility code.
* Pay attention to special cases.
* When you create a new objects, you generally need to call `new Type(params)`.
* The Java libraries are woefully inconsistent.
    * Convert a string to an `int`: `Integer.parseInt(str)`.
    * Convert a string to an `Integer`: `Integer.valueOf(str)`.
    * Convert a string to a `BigInteger`: `new BigInteger(str)`.
* Sam is more excessive on these things than most faculty.

### The wonderful `Fraction(String str)` constructor

What happens when you create the following fractions?

```
f5 = new Fraction("2147483649/2");
f6 = new Fraction("42");
f7 = new Fraction("9223372036854775808/3");
```

### What to submit

I prefer that you submit `Fraction.java` and `Counter.java`.
