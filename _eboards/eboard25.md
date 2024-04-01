---
title: "Eboard 25: Quicksort"
number: 25
section: eboards
held: 2024-04-01
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Questions
* Loop invariants and the Dutch National Flag problem
* Lab

Preliminaries
-------------

* Apologies. I lost three days of break and they were three days that
  I was planning to use for grading.
* Welcome back from break!
* Remember that post-break masking is a good idea.
* I brought back some conference swag from the 2024 SIGCSE Technical
  Symposium on Computer Science Education. You can each have one or
  two octocat stickers, one notebook, and one or both of the disability
  stickers.

### Upcoming work

_Schedule needs updating. Stay tuned._

* Thursday, MP6: Sorting
    
### Tokens

Academic/Scholarly

* Tuesday, 2024-04-02, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-04-02, 7:00pm, Science 3819.
  _Mentor Session_.
* Thursday, 2024-04-04, 11:00am, JRC 101.
  _Scholars' Convocation: Motherblame-stigma, Epistemic Injustice, and the Government’s Failure to Care_ (w Tammy Nyden in Philosophy).
* Thursday, 2024-04-04, 8pm, JRC 101.
  _Book talk: Austin Frerick '12 on Barons: Money, Power, and the Corruption of America’s Food Industry_

Cultural

* Thursday, 2024-04-04, 4pm, Grinnell College Museum of Art.
  _Writers@Grinnell presents Sam Naikhara '19_.
* Friday, 2024-04-05, 4pm, Global Living Room in HSSC.
  _Middle of Everywhere._

Peer

Wellness

* Monday, 2024-04-01, 4pm, HSSC Atrium.
  _Therapy Dogs_.
* Tuesday, 2024-04-02, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-04-02, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-04-02, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

* Wednesday, 2024-04-03, 11:45am, JCC Lower-Level Conf. Room.
  _CLS Lunch and Learn with Sam Naikhara '19_.
* Wednesday, 2024-04-03, 4pm, 3821.
  _CS Extras: Study abroad at AIT Budapest_.

### Other good things to do (no tokens)

Questions
---------

### Administrative

### Sorting (in general)

### Quicksort

### MP6

Should we test our custom sort?

> I would recommend that you test it. You do want it to work correctly.

### Other

What are DRY and SOLID?

> DRY: "Don't Repeat Yourself".

> There are lots of ways programmers poorly repeat themselves.

> Two identical function calls in the same function. That's inefficient.
  For recursive functions, it can be doom.

> Two or more sets of nearly identical code (copy-paste-change syndrome).
  In this case, you should write a more general function.

> Polymorphism (both kinds) helps with addressing the second issue.

On to SOLID

> Here's what Wikipedia says.

> > The SOLID ideas are

> > * The **S**ingle-responsibility principle: "There should never be more than one reason for a class to change." In other words, every class should have only one responsibility.
> > * The **O**pen–closed principle: "Software entities ... should be open for extension, but closed for modification."
> > * The **L**iskov substitution principle: "Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it." See also design by contract.
> > * The **I**nterface segregation principle: "Clients should not be forced to depend upon interfaces that they do not use."
> > * The **D**ependency inversion principle: "Depend upon abstractions, [not] concretes."

> Our reinterpretation.

> **S**ingle-Responsibility Principle. Anti-Microsoft philosphy (also The Linux
  Philosophy): A class should do one thing and do it well. (In Linux,
  a program should do one thing and do it well.)
* **O**pen-closed Principle.
    * You should be able to change a class w/o modifying it.
    * And you do so by extending it (subclassing)
    * Encapsulation
* **L**iskov Substitution Principle.
    * Another name for subtype polymorphism.
    * Side note: The idea is due to Barbara Liskov.
    * Side note: From long before we really understood OOP. (ca. 1967)
* **I**nterface Segregation Principle.
    * This sounds to Sam like the Single-Responsibility principle as
      applied to interfaces.
* **D**ependency inversion.
    * Encapsulation. 

Loop invariants review
----------------------

What are they?

* Annotations on a loop (that we use to make sure the loop is working).
* Statements about things we expect to be true at the start of each
  repetition of the loop and again true at the end.

Why do we use them?

* To make sure that the loop is working.
* They help document what you're doing, particularly useful when someone
  else is modifying your code.
* UM: They let us Use Math
* They help us ensure that we don't break things (e.g. if we're reversing
  a string in place, the string's length sholdn't change).
* They let you prove that the algorithm works correctly.
* They can help us design algorithms.

Example of proof

* If our invariant is "things at positions [0...p) are sorted"
* And our loop is `for (int p = 0; p < stuff.len; p++);`
* At the end, everything is sorted.

Example of design

* Hmmm ... Start of loop body

```
              p
+-------------+------------+
|   sorted    |  unsorted  |
+-------------+------------+
```

* End of loop body

```
                p
+-------------+-+----------+
|   sorted      |unsorted  |
+-------------+-+----------+
```

* How do we achieve that? 
* We put the thing at position `p` into the right place in the sorted
  stuff and then advance `p`.

Observations

* In addition to loop invariants, we also need to show loop termination.
  (Argue/prove that the loop terminates.)

The Dutch National Flag Problem
-------------------------------

You have an array with three values, which we’ll call red, white,
and blue. They are in no particular order. Your goal is to *rearrange*
it so that all of the red are at the left, all the blue are at the
right, and all the white are in between.

_You may not simply count the values; different reds represent different
objects (similarly for blues and whites)._

_We rearrange it rather than copy to a new array or arrays because we
are trying to limit space usage._

Sample input:

```
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Ba|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Rq|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

O(n^2): Use insertion sort with an appropriate comparator.

Can we do better? In particular, can we write an O(n) algorithm?

Idea: Two indices; one moves right from the beginning, one moves
left from the end.

Goal: Red, white, blue

```
left                                               right
|                                                  |
v                                                  v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Ba|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Rq|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

* If left points to red, increment it.
* If left points to white, increment it.
* If left points to blue, swap to right-1

```
   left                                         right
   |                                            |
   v                                            v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

```
      left                                      right
      |                                         |
      v                                         v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

```
         left                                   right
         |                                      |
         v                                      v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

### Design

How do you approach the problem?

```
left                 middle                        right
|                    |                             |
v                    v                          .  v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

* Everything before left is red.
* Everything after right is blue.
* Everything between left and middle is white.
* Everything between middle and right is unprocessed.

### Initialization

```
middle
left                                               right
|                                                  |
v                                                  v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Ba|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Rq|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

* If middle points to red, swap left and middle, advance left 
  and advance middle
* If middle points to white, advance middle
* If middle points to blue, swap to end, move right left

The thing at `middle` is blue. Swap and move right left. (`swap(middle, --right)`)


```
middle
left                                            right
|                                               |
v                                               v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is red. Swap and increment both `left` and `right`.
(`swap(middle++, left++)`).

```
   middle
   left                                         right
   |                                            |
   v                                            v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is red. Swap and increment both `left` and `right`.

```
      middle
      left                                      right
      |                                         |
      v                                         v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is white. Increment `middle`.

```
         middle
      left                                      right
      |  |                                      |
      v  v                                      v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is white. Increment `middle`.

```
            middle
      left  |                                   right
      |     |                                   |
      v     v                                   v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Wc|Wd|Re|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is red. `swap(left++, middle++)

```
               middle
         left  |                                right
         |     |                                |
         v     v                                v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Re|Wd|Wc|Bf|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Wp|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is blue. `swap(middle, --right)`

```
               middle
         left  |                             right
         |     |                             |
         v     v                             v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Re|Wd|Wc|Wp|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Bf|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

When do we stop?

* When middle reaches right (or crosses right, depending on how we design
  things).

Sam continues the example ....

```
                  middle
         left     |                          right
         |        |                          |
         v        v                          v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Re|Wd|Wc|Wp|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Bf|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is white. `++middle`.

```
                     middle
         left        |                       right
         |           |                       |
         v           v                       v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Re|Wd|Wc|Wp|Wg|Rh|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Bf|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is red. `swap(left++,middle++)`

```
                        middle
            left        |                    right
            |           |                    |
            v           v                    v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Re|Rh|Wc|Wp|Wg|Wd|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Bf|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is white. `++middle`. (Two steps skipped.)

```
                                 middle
            left                 |           right
            |                    |           |
            v                    v           v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Re|Rh|Wc|Wp|Wg|Wd|Wi|Wj|Wk|Rl|Wm|Bn|Bo|Bf|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is red. `swap(left++,middle++)`

```
                                    middle
               left                 |        right
               |                    |        |
               v                    v        v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Re|Rh|Rl|Wp|Wg|Wd|Wi|Wj|Wk|Wc|Wm|Bn|Bo|Bf|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is white. `++middle`.

```
                                       middle
               left                    |     right
               |                       |     |
               v                       v     v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Re|Rh|Rl|Wp|Wg|Wd|Wi|Wj|Wk|Wc|Wm|Bn|Bo|Bf|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is blue. `swap(middle, --right)`.

```
                                       middle
               left                    |  right
               |                       |  |
               v                       v  v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Re|Rh|Rl|Wp|Wg|Wd|Wi|Wj|Wk|Wc|Wm|Bo|Bn|Bf|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The thing at `middle` is blue. `swap(middle, --right)`.

```
                                       middle
               left                    right
               |                       |
               v                       v
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
|Rq|Rb|Re|Rh|Rl|Wp|Wg|Wd|Wi|Wj|Wk|Wc|Wm|Bo|Bn|Bf|Ba|
+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
```

The `middle` pointer has reached `right`. We're done.  Woo!
