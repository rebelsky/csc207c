---
title: "Eboard 14: List ADTs"
number: 14
section: eboards
held: 2024-02-21
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed.**

_Approximate overview_

* Administrivia
* Notes on setting up and running Java projects
* Questions
* Design: Lists
* Maybe some lab time

Preliminaries
-------------

* Sam has hearing aids again. He is back to mediocre hearing.
* We have finished most of the Java you need for the semester and are
  moving on to more on ADTs/Data Structures and Algorithms.
    * Don't worry, we'll still learn more Java.
* Today is a (planned) talk day.
* I've updated the schedule for the change in MP4. Note that you need one
  fewer E for A/B/C.

### Upcoming work

* Thursday, 2024-02-23, 11pm, Reading responses
    * [Linear structures](../readings/linear-structures)
    * [Stacks](../readings/stacks)
    * [Queues](../readings/queues)
    * [Priority Queues](../readings/priority-queues)
    * [_Submit reading responses on linear structures on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4137129/)
* Friday, 2024-02-23, 1pm: Submit Monday's Lab
    * [_Submit inheritance lab on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4136964)
* Friday, 2024-02-23, 11pm, Submit the first set of LAs.
    * _Sorry, no Gradescope links_
* Wednesday, 2024-02-28, 11pm, [MP4](../mps/mp04)
    * [_Submit MP4 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4137145/)

### Tokens

Academic/Scholarly

* Thursday, 2024-02-22, 11:00-noon, JRC 101.
  _Scholars' Convocation: Luis Fabiano De Assis on Human Trafficking._
* Thursday, 2024-02-22, 4:00-5:00pm, Science 2022 
  _CSC Major Declaration Session_
* Tuesday, 2024-02-27, noon--1:00pm, Some PDR.
  _CS Table: ???.
* Tuesday, 2024-02-27, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.

Cultural

* Friday, 2024-02-23, 4:00--5:00pm, HSSC N1170 (Global Living Room).
  _Middle of Everywhere._
* Friday, 2024-02-23, 7:00--9:00pm, Sebring-Lewis.
  _Squatters on Red Earth_.

Peer

Wellness

* Tuesday, 2024-02-27, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-02-27, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._ (I think)
* Tuesday, 2024-02-27, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

### Other good things to do (no tokens)

Setting up Java projects for VSCode
----------------------------------

Broadly: You have to be much more careful with directories than you've
been in the past.

* Please don't put one project within another project.
* Projects generally have `src` directory.
* You should open the project from the folder that includes the `src`
  directory.

### New projects

Please do "New Java Project", select folder, choose name.

When you are using packages, make sure that the package name matches
the folder its in within the src directory.

### Existing projects


Questions
---------

### Administrative

Please write the self checks tonight!

> I'll do my best. I'll Teams Announce in the Q&A channel when I do.

### MP4

Everything looks broken

> Sam is working on it.

What should we submit?

> Just your Java code from the structures package. You need not submit 
  the tests.

> Gradescope says you can just submit your GitHub link.

How do we get things from the upstream repo?

> I need to check the docs. Ask on Teams. Then ask again.

Set is supposed to throw an exception; the test cases aren't ready for
that. Can you please fix that?

> See "Everything looks broken" above. We need to fix the test cases
  to say that they can throw an exception (I think).

Should we fork the testing repo?

> Probably not. (It's good practice, but I wanted you to experience the
  horrific joy of multiple people committing to the same repo.)

### LAs

If Sam started a project and we added stuff, can we use that?

> Certainly.

Do I really have to paste code?

> Yes. Whatever you think I might need to read.

### Other topics

The design of ADTs, revisited
-----------------------------

* Yup, it's time for PUMishment
* You all remember what it means, right?
    * Philosophy
    * Uses
    * Methods
* Why use PUM?
    * It's a good way to think about the design of many things, but
      particularly abstract data types
    * ADTs: Ways to collect information, specified at a high level.

Lists, version 1: Scheme lists
------------------------------

### Philosophy

_What's the underlying (overarching) philosophy of Scheme lists?_

* A way to store a bunch of values.
   * In a user-defined order.
* That is easy to recurse over to process all the values.
* That are immutable!
   * Getting "all but the first" does not change the list
   * Adding to the front of the list builds a new list (and does not
     change the old list).
   * The only place we can add elements is the front.

### Uses

* To force people to use recursion.
* Represent a piece of music as a sequence of sounds.
* Represent an image as a sequence of pixels/colors.
* Represent a structure that maps strings to <anything> (association list)

### Key methods

_These are the ones we couldn't write ourselves._

* `(car lst)` - Get the first element in the list.
* `(cdr lst)` - Get all but the first element in the list.
* `(cons val lst)` - Add something to the front of a list 
  (short for "construct")
* `null` - Build the empty list. (We need a starting place.)
* `null?` - Determine if we have an empty list.

Do we really need `null?`. Can we just use `(eq? lst null)`.

> If we don't know the implementation, or want to support implementations,
  we might want both.

### Other methods

_These are ones we could write ourselves, but would prefer to have a 
standard implementation._

* `(length lst)` - Determine how many values are in the list.

```
(define length 
  (lambda (lst)
    (if (null? lst)
        0
        (+ 1 (length (cdr lst))))))
```

### Layout

### Implementation

### Analysis

Lists, version 2: CSC-161 lists
-------------------------------

### Philosophy

_What's the underlying (overarching) philosophy of the lists you built
in 161? Don't think about the implementation. Think about how they are
organizing information._

* Something to store a bunch of values 
* Mutable
    * We can add values.
    * We can remove values.
* The values are stored in a "consecutive" (linear) structure. Each
  one except the first has a predecessor; each one except the last has
  a successor.
* Users might be able to control placement (e.g., by only adding to the
  front or adding to the end); pehraps adding in the middle, perhaps
  removing from the middle.

### Uses

* Represent an image as a list of lists of pixels (or something like that).
* Paranoia (uses cyclic list)
* Store tickets (uses things that look somewhat like queues)

### Key methods

_You need these; unless they are provided by the implementer, you probably
can't get full use out of lists._

* `List create()` - in Java, it's the constructor `List<T>()`.
* `void addToFront(T val) throw NoDamnNullsException`
* `boolean contains(T val) throws NoDamnNullException`
    * In Scheme, we could build this with the five basic things.
    * In the lists we design, do we need this as a core operation?
* `int size()` - returns how many values are in the list.
* `boolean removeFirst(T val) throws NoDamnNullsException` - removes the
  first instance of a value.  Returns true if it the value was in the list; 
  returns false if it was not.
    * Sam thinks that `remove` is ambiguous. Why?
      `(remove 3 '(1 2 3 4 3 2 1))` ->
    * Is it "remove one" or "remove all".
* `int removeAll(T val) throws NoDamnNullsException` - removes all copies
  Returns how many values we removed.
* Our decisions end up being based, a bit, on our use cases. If we have
  too many use cases, we end up with too many procedures.
* We could have a notion of a current element.
    * advance
    * retreat
    * remove
    * addBefore
    * addAfter
* You will read a paper called "lists with current considered harmful"

### Other methods

_You'd like these, but could probably implement them with the key methods._

* Randomly remove

### Layout

### Implementation

* Linked structures are presumably more memory effective than array-based
  structures.

### Analysis

* Reverse in place is O(n) if done right.

Lists, version 3: Sorted list
-----------------------------

Philosophy

* A collection of values
* Stored in "sorted order"; each value precedes all larger values.

Lists, version 4: Cyclic lists
-------------------------------

### Philosophy

Like a list, except that there are no designated first/last elements,
so that *every* element has a successor and predecessor (and those are
inverse relations).

Lists, version 5: Iterable lists
-------------------------------

### Philosophy

### Uses

### Key methods
