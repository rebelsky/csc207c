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
* Debrief from last class
* Questions
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
* Sunday, 4-5pm, CS (Un)Commons

Cultural

Peer

* Les Duke, 10am Saturday, the golf course.

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
* A Big Fraction calculator (or maybe many)

Debrief on Wednesday's lab
--------------------------

* Wrote classes that used `BigInteger` objects.
* In particular, used them in writing `Fraction` objects (that we probably
  should have called `BigFraction` objects.
* We extended the `Fraction` class in interesting ways which helped us
  get a bit more accustomed to programming with objects and classes in Java.
* We implemented `Counter` objects.

What important lessons did we learn?

* Things don't happen magically; we need to write the code when we want,
  say, a `BigFraction` to simplify.
* Sam may provide you with code, but it's usually incomplete.
* Classes can have multiple constructors; we can build things in different
  ways.
    * We might `BigFraction` objects from two ints, two BigIntegers,
      a string, a floating point number (e.g, 2.5 -> 5/2), ....
      a single integer (becomes n/1).
    * Some things are external, such as turning a variable name into
      a BigFraction.  (While our calculators will want to keep track
      of variables, that seems outside the realm of what a fraction
      class should do.)
* We learned about and practiced with `toString`.
* The first parameter to a method is often implied (the first "parameter"
  is the object that is doing the work).
    * This is often how the world works.
    * Mediocre metaphor: student.grab(card); student.findSeat()
      rather than ....

Questions
---------

What does it mean that " All operations behave as if BigIntegers were represented in two's-complement notation (like Java's primitive integer types)"

> Two's complement is one of four or so ways to represent integers in
  binary.

> These mechanisms differ in how they represent negative integers.

> In two's complement, ... we flip all the bits and add 1.

> A leading 0 represents positive, a leading 1 represents negative.

> It's important to know that to understand some of the constructors.

> And, contrary to Sam's minimalistic perspective, they provide a lot
  of bitwise operations.

Why do we have packages?

> Reason one: It's lets us put things that belong together together.

> For example, the `BigFraction` and the `BFCalculator` classes that
  you are writing will be working together, putting them in a package
  reinforces that.

> On the other hand, the `Counter` that we built on Wednesday is unrelated,
  and should probably be in a different class.

> Reason two: Helps us link things together.  Things in the same package
  can refer to each other directly without giving the full package/path
  specification.

> Reason three: There are only so many natural class names.  Packages
  let us distinguish them.

> For example, we're building a `BigFraction`.   But perhaps some
  data science library you're using also has a `BigFraction`.  THe
  package lets us distinguish them.  Ours will be
  `edu.grinnell.csc207.fa2023.rebelsky.BigFraction`; theirs will be
  `org.cool.datasci.analyzer.BigFraction`.

> Reason four: Information hiding.  Things in the same package can access
  fields/methods that have the default protection level; things in other
  packages cannot.

> We created a package, `foo`, with two classes, `A` (field `eh`) and
  `Main`, with a `main` method that accesses that field.  It worked.
  Whoo!

> We created another package, `bar`, which tries to reference the `eh`
  field of `foo.A`.  It fails with a protection error.  Yay!  We have
  limited the availability of fields.
  
> Our protection choices are `public`, `protected`, nothing (package),
  `private`.

> In this class, we will generally restrict ourselves to public and
  package protection.

What is the difference between `protected` and "package"?

> `protected` means "available to the package and to subclasses, even 
  if they are in other packages"`.

Do we ever need to throw exceptions?  If so, when?

> Yes.  Starting September 18.

Given that class A was public in the example above, why couldn't we access the field?

> We get to set different protections for classes and the things they 
  contain.  We often want other programs to be able to create new objects
  in the classes we design, but not to see/modify the internals.

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

* Static: Permanent stuff.  The program code.  Globals.  Some constants.
* Things allocated during our program (in C, with `malloc`; in Java, with
  `new`).
* Parameters and local variables for the procedures we call.

We generally arrange memory something like this.

```
         +--------------+
         |              |
         |              |
         |   Static     |
         |              |
         +--------------+
         |              |
         |              |
         |   Heap       |
         |              |
         |              |
         +--------------+
         |              |
               ...
         |              |
         +--------------+
         |              |
         |              |
         |   Stack      |
         |              |
         +--------------+
```

When we allocate something, it goes in the heap.  The heap expands as necessary
(fingers crossed).

When we call a procedure, we add a "stack frame" to the stack.  It contains
the local variables and parameters to the procedure.

If I have a procedure like the following

```
int foo(int x) {
  int y;
  y = x*x;
  return y;
}
```

Our stack frame needs room for `x`, `y`, and some other housekeeping info.

As programmers, we need to remember that this is happening; it informs
some of what we do, and it helps us understand why we get some errors.

We never explicitly free space in Java.  What's up with that?

> Conceptually, the Java VM "cleans up" when it finds that there's no/little
  space left.  This is called Garbage Collection.

> The things that can be removed are those that will no longer be used in
  the program.

> We usually make the more conservative assessment of "this is not referenced
  by anything currently used in the program"

> These days, garbage collection is done more incrementally (while your
  program is running), rather than all at once.

> Your mentor says that we can configure all of this.

Representing Objects and Classes
--------------------------------

We'll step back a bit from our pure representation of memory ...

Back to expandable arrays
-------------------------

An expandable array provides three primary methods

* `String ExpandableArray(String default)` - Create a new expandable array
  of the specified size.
* `void set(int index, String val)` - Set the value at the given index to
  `val`.
* `String get(int index)` - If we've set something at the given index using
  `set`, return that value.  Otherwise, return `default`.

We want to implement these with chunks of memory (the underlying, fixed-size
Java arrays).

Person closest to the board is the interviewer; person furthest from the board is the interviewee.  

How do you implement these things?  (in Java, conceptually, whatever)

Layout, Implementation, Assessment

* What fields do you want in your class?
* How will you implement `get`?
* How will you implement `set`?
* How will you implement your constructor?

