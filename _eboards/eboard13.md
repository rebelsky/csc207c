---
title: "Eboard 13: Inheritance"
number: 13
section: eboards
held: 2024-02-19
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed.**

_Approximate overview_

* Administrivia
* Questions
* Our call model, revisited
* Lab

Preliminaries
-------------

* I think today is Junior Visit Day. We'll give our visitors some chance
  to answer and ask questions.
* Sam broke his hearing aids and hears even less well than normal.
* Please DM me your GitHub username if you haven't already. (I'll start
  adding you during the beginning of lab.)
* The first set of LAs have been released. I may add a few more.

### Upcoming work

* No readings for Tuesday.
* Wednesday, 2024-02-21, 1pm: Submit Today's Lab

### Tokens

Academic/Scholarly

* Tuesday, 2024-02-20, noon--1:00pm, Some PDR.
  _CS Table: ???.
* Tuesday, 2024-02-20, 4:15-5:30pm, HSSC A1231 (the Kernel).
  _The Meskwaki and the Amana Colonies_.
* Tuesday, 2024-02-20, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.
* Thursday, 2024-02-22, 11:00-noon, JRC 101.
  _Scholars' Convocation: Luis Fabiano De Assis on Human Trafficking._
* Thursday, 2024-02-22, 4:00-5:00pm, Science ????.
  _CSC Major Declaration Session_

Cultural

* Friday, 2024-02-23, 4:00--5:00pm, HSSC N1170 (Global Living Room).
  _Middle of Everywhere._
* Friday, 2024-02-23, 7:00--9:00pm, Sebring-Lewis.
  _Squatters on Red Earth_.

Peer

Wellness

* Tuesday, 2024-02-20, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-02-20, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._ (I think)
* Tuesday, 2024-02-20, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

* GrinTech Alumni Meetup 4:00-5:00 pm in HSSC N2116.

### Other good things to do (no tokens)

* Monday, 2024-02-20, 9-11pm, Bob's Underground.
  _Bob's undergound open mic night 9-11pm_

Revisiting our mental model
---------------------------

_Note: You can find code in [examples/inheritance](../examples/inheritance)._

We'll address some of the questions from the readings by revisiting
our mental model.

Questions
---------

### Inheritance

Do superclasses include info about their subclasses?

> No

Can you cast from a subclass to a superclass?

> Yes, but there's rarely a reason to so.

Can you explain protection for fields?

> Sure. Remember that we use protection to achieve one of the goals of
  encapsulation: We are free to make changes to our code without
  significantly affecting our clients. Different situations require
  different choices.

> There are four levels: `private`, "package" (write nothing), `protected`
  and `public`.

> `private` means that the field or method is only available to the
  class or other objects in the class.

> "package" expands that availability to other classes in the same
  package as well as objects in those classes.

> `protected` further expands it to subclasses in other packages.

> `public` expands it to everyone.

Can you explain how we use `super` in methods?

> You will most frequently use `super` in constructors to make a call
  to the appropriate constructor in the superclass.

> If you don't do so, Java will look for a zero-ary constructor in the
  superclass and call that.

> At times, when we want to use a method from the superclass that has
  been overridden in the subclass, we can write `super.methodName`.

How do we know when to use interfaces and when to use inheritance?

> Practice.

> In general, we use inheritance when we have fields and methods we want
  to reuse from another class.

> We use interfaces when we don't have that kind of reuse.

> We use either when we want to write functions that work with multiple
  similar objects.

Do you need to specify `public` or `private` for all fields?

> Nope. There's also "package" (writing nothing) and `protected`.

> I prefer package protection because it often achieves the right level
  of protection (available to other classes in the same package, but
  not classes outside the package).

What's wrong with these as solutions to the self checks?

```
public class StaffMember extends Person {
  String department;
}

public class Administrator extends person {
}
```

>

> 

### MP4

### Other topics

Lab
---
