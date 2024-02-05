---
title: "Eboard 07: A mental model of classes and objects."
number: 7
section: eboards
held: 2024-02-05
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed. Of course, the technology failed in my earlier class, so perhaps not.**

_Approximate overview_

* Administrivia
* About mental models
* Thinking about classes
* Thinking about objects
* Compile-time and runtime issues
* Thinking about the rest of the runtime environment

Preliminaries
-------------

* There are many sick people on campus. Consider masking.

### Upcoming work

* 11pm Tuesday, 2024-02-04: Reading Reflections
    * [Unit testing](../readings/unit-testing)
    * [Debugging](../readings/debugging)
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4055828/)
* 11pm Wednesday, 2024-02-05: [Mini Project 2](../mps/mp02)
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4055758/)
* 11pm Friday, 2024-02-07: Mini-Project 2 post-reflections
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4055738)

### Tokens

Academic/Scholarly

* Tuesday, 2024-02-06, Noon in JRC 224A.
  _CS Table: Web browsers, privacy, and advertising._
* Thursday, 2024-02-08, 11am in JRC 101.
  _Scholars' Convocation: A Life Worth Archiving – Excerpts from a Memoir._

Cultural

Peer

* Saturday, 2024-02-10, 10am--1pm, Field House.
  _Darren Young Classic_.
* Womens Tennis Scrimmage, Thursday 6pm (we think)

Wellness

* Tuesday, 2024-02-06, noon, BRAC P103 (Multipurpose Dance Studio).
  _HIIT & Strength Fitness Class_.
* Tuesday, 2024-02-06, 12:15, Bucksbaum 131 (the museum).
  _Yoga in the museum_.

Misc

* InfoSec survey (stay tuned for email)

### Good things to do (no tokens)

### About pre-assessments

When considering the purpose of mini-projects, try to think more
generally. Not "building a Fraction class" but "learning to build
classes". Not "creating a calculator" but "learning to use the
classes we've built" or "separate UI from backend".

When filling out pre-assessments, please do a brain dump of code/algorithms.
_Don't just list topics you need to look up!_

#### Sample brain dump for MP2

I'm building classes. I need constructions. THose look like public ClassName(Params). I create objects with new ClassName(args).

I'll be working with strings, particularly in the interactive part. I use `str.split(" ")` to break a string apart at spaces (I think the input looks like that).

I'm going to process the command line in the COmmandLineCalculator, `for (String arg : args)`.

I'll need to convert strings to BigIntegers or fractions.  For BigIntegers that `new BigInteger(str)` (I hope), for BigFractions, we wrote that as `new BigFraction(String).

We have to deal with both whole numbers and fractions. I thing there's a `str.contains(String other)`. If not, there's a `str.indexOf(String other)`.

Java has a different syntax for handling objects. `foo.multiply(bar)` rather than `foo*bar`.

I'll need an array for the registers. It will have the form `BigInteger[] registers = new BigInteger[26];` or something like that.

Questions
---------

### MP2

_We'll quickly go through the ones I've received and then see if you 
have others._

Can we crash and burn when we hit division by zero or should we issue
an error or ...?

> You can crash and burn. Or you can issue an error.

Can we crash and burn on invalid input?

> If the person designing the project doesn't specify what to do, 
  you can crash and burn.

> You can crash and burn on `"1 + 2/agh"`

Can I catch exceptions?

> Sure.

Should we handle `"1 + 2 / a"`?

> Yes.

What's an expression with no operations?

> `"5"` -> gives `5`.

> `"a"` -> gives whatever was stored in register a.

### Administrative

Will Sam be in his office during office hours?

> That is currently the plan. But some of those hours are booked.

> You can book office hours at <https://bit.ly/book-samr>, at least
  if bit.ly is working. If not, look at the class home page.

Can you fix VSCode in MathLAN in fifteen minutes?

> Probably. You can also show up before 10am and I'll probably be in
  my office.

Mental models
-------------

To understand how our code works (and why it doesn't work), it can be
helpful to form _mental models_ of how the computer stores and processes
our programs.

* In CSC-151, we generally used a _substitutive model_ which broke down
  slightly once we hit procedures with side effects.
    * Subtitution also gets more complicated when you reuse names
      in `let` bindings.
* C has a more stateful model involving the stack and the heap 
* Our model will be somewhat different for Java, not least because
  Java is explicitly stateful.
* Our model need not precisely mimic what the Java Virtual Machine does;
  rather, our goal is to understand conceptually what it does.
* To model the Java, we need to consider classes, objects, and
  inheritance and subtype polymorphism (which we haven't covered yet).

Classes
-------

TPS: What information should we store for each class?

* Object fields
    * Name
    * Type (useful for typechecking; how much space)
    * Protection level (useful for preventing unauthorized access)
    * Offset in the object (this is one of those hidden things)
* Class fields
    * Name
    * Type
    * Protecvtion level
    * Offset in the class
    * Space for the value
* Methods
    * Name
    * Parameters (note: name + parameter types = signature)
    * Return type
    * Protection level
    * Code
    * Possible offset in the class
* Constructors
    * See methods
* It's useful to think about having a table that tells you where to find
  the code for each method (given method name and parameter types).

### Program state: Active names

Note: We may also want to make the association of names with things
a bit more explicit.

```
+-----+----+
|  x  |  *---------> ...
+-----+----+
|  y  |  *---------> ...
+-----+----+
```

or

```
+-----+------+
|  x  | 0x23 |
+-----+------+
```

Or we might do what we do in C and just write the names on the side.

Objects
-------

TPS: What information should we store for each object?

* All the fields. (Note that the information about them is in the class.)
    * Fields for primitive types store the type directly.
    * Fields for objects store a reference to the object.
* What else might you store in an object?
    * Class
* Is it valuable to count the number of references to an object?
    * Historically, that was one of the techniques used for garbage
      collection; it proved less fruitful than expected.

Garbage collection
------------------

You do not explicitly free unused objects in Java.

How do we avoid running out of memory?

We need something that collects the "garbage" in our program; the things
that occupy memory but will never again be used.

It is impossible to determine whether an arbitrary object will be used
in the future. So we look primarily at the things that we can still be
referred to. Those are not garbage. Anything that is not referred to
directly or indirectly can be treated as garbage.

Two main philosophies of garbage collection:

* Incremental: Collect garbage while other parts of the program run
* All-at-once: Wait until you've run out of useful memory; go through and
  clean up.

Most modern languages mark what is useful and what is not useful.

Compile-time and Runtime issues
-------------------------------

I've been known to say "Java is your nanny". That is, the Java compiler
tries to verify that your code is "safe" (or as safe as it can figure).

TPS: What kinds of issues can it check at compile time?

TPS: What kinds of issues might occur at runtime?

Runtime
-------

Other than objects and classes, what information should we be storing
at runtime?
