---
title: "EBoard 10: Parametric polymorphism"
number: 10
section: eboards
held: 2023-09-15
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.

_Approximate overview_

* Administrivia
* Some notes from the last lab
* About MP3
* Questions
* Lab

Administrivia
-------------

### Introductory notes

* Make sure that you have your github keys working!  If not, please stay
  after class and I'll work with you on it.
* Apologies for being perpetually behind.  For example, the JUnit reading
  for Monday still references Eclipse because I've been fighting with
  VSCode.
* As noted in the email, you have an extension on MP2
    * Obligatory story.

### Upcoming Token activities

Academic

* Sunday, 4-5pm, CS (Un)Commons, Mentor Session
* CS Table, Tuesday 19 Sept 2023, Noon, Day PDR, Feeding your data to
  plagiarism detectors.
* CS Extras, Thursday 21 Sept 2023, 4:15 pm, Science 3821.  Study Abroad in CS

Cultural

Peer

Wellness

Misc

### Upcoming work

* Monday: More readings, today's lab, preassessment for MP3
* Thursday: MP3

Notes and lessons from Wednesday's lab
--------------------------------------

_Another TPS activity._

* When you have access to source code, it's good to ask how you would
  implement something and then see how it's implemented.  (We'll try
  to remember to ask you to do this.)
* Separate interface from implementation.
    * The interface says *What*.
    * The implementation says *How*.
    * When you implement an interface in Java, you must implement all
      of the specified methods.
* Java interfaces can also be used to obtain polymorphism: If something
  provides *these methods*, I can do *this* with it.
    * E.g., If something provides width, height, and getLine, I can
      print it out (and put a box around it, and put it side-by-side
      with something else that provides the same methods, ...).
* As we've seen before, good programming involves things building from
  other things.  In this case, we can have objects (and classes) build
  on top of each other.
* Classes are still a bit confusing.  It was good to get practice.
* Java is able to handle it when things have the same name.
    * You can have `main` in multiple classes.  Usually the Java
      environment is smart enough to know which one you want.
    * You can have the same method name in multiple classes.  When
      you call that method on an object, it looks in its class to
      figure out which to use.
    * You can repeat the same method name in the same class, as long
      as it has different parameter types (a different "signature");
      Java figures out which one you mean by the types of the arguments.
      the one associated with
* We're fighting with Java.
* You still have to call `new` whenever you call a constructor.
* Just so you know, the stuff we're doing with textblocks is somewhat
  similar to how many UI layout packages work (or used to work).

About MP3
---------

* A chance to extend what we just did.
* Four new mechanisms for building text blocks.
* Three equality predicates.
* Testing!

Questions
---------

_You can ask questions about anything related to the class!  Self gov
says that you **should** ask those questions._

### Java

How do I have classes reference each other?

> If they are in the same package and have the appropriate protection, 
  using the basic class name.

> If they are in different packages, you must either use the full
  specification (e.g., `java.math.BigInteger`) or use an `import`
  statement (e.g., `import java.math.BigInteger`).

How can we check if an arbitrary value is of a certain type?

> For primitive types (e.g., `char`, `int`, `double`), we generally trust
  the Java type system.

> For objects, you can write `(var instanceof Class)`.  Also
  `(var instanceof Interface)`.

> If we want to determine whether, say, `ch` is a lowercase letter,
  we probably have a helpful procedure in the `Character` class.

> As C programmers, we might also write `((ch >= 'a') && (ch <= 'z'))`

### Administrative stuff

What will LAs look like for this class?

> Option one: I may ask you to do something related to the topic of 
  the day that draws upon knowledge you should already have for a
  learning outcome.  For example, when we study queues, I might ask
  "Under the PUM approach, what methods would you specify for a
  queue?  Write them down on a piece of paper."  (Note that I do
  this already; we'll just have you showing off your knowledge on
  paper.)

> Option two: I may ask you to fill out a form indicating where
  you had demonstrated mastery of something.  For example, if
  "Parsing strings" were a learning outcome, you could write "I
  demonstrated my knowledge of parsing strings on Mini-Project 2.
  Here's the relevant code."

### MP2

How should I implement the registers?  It strikes me that an array is a
good idea?

> I would use `BigFraction registers[26]`, with the 26 registers corresponding
  to the 26 lowercase letters.

> We already know how to convert a lowercase letter to a number between 0
  and 25 because we did so on MP1.

> Given a lowercase letter, the value stored in the register is
  `registers[convert(ch)]`.

> You can store in it with `registers[convert(ch)] = someBigFraction;`

What do I store when I encounter `STORE letter`?

> The value of the last expression calculated.

How do I keep track of that?

> I'd suggest a field in your `BFCalculator` object.

Does the `QuickCalculator` have to store in registers?

> Yes.

What does the QuickCalulator have to print out?

> Something reasonable.  (Incomplete specs mean freedom.)

> Option 1: Each expression followed by its value.

> Option 2: Value of each expression.

> Option 3: Value of the last expression.

Will the post-assessment still be due tonight?

> No.  I'm moving it.

### MP3

Is it due on Thursday?

> Yes, unless VSCode/MathLAN crash again.

> Please don't try to make them crash.

Lab
---

