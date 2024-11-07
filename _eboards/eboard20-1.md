---
title: "Eboard 20 (Section 1): Ethics, revisited"
number: 20
section: eboards
held: 2024-11-11
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
* Quicksort
* Lab

Preliminaries
-------------

### News / Notes / Etc.

* We're back to talking today. Thursday should be lab.
* New office hour approach: Use the Outlook scheduling assistant to 
  schedule 15-minute or 30-minute appointments. I'll generally say yes 
  to requests during the day for times that I'm not booked..
    * SAM WILL DEMO!

### Upcoming work

* Wednesday, 2024-11-12
* Thursday, 2024-11-14
    * [MP8](../mps/mp08) due.
    * [Submit MP8 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5284854)
* Friday, 2024-11-15
    * [Submit post-reflection for MP8](https://www.gradescope.com/courses/818402/assignments/5284861)

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Thursday, 2024-11-07, 4:00--5:00 p.m., Science 3821.
  _CS Extras: Decision Diagrams_
* Sunday, 2024-11-10, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_
* Tuesday, 2024-11-12, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table: ???_ 

#### Cultural

* Weekends of November 16 and November 23, Roberts Theatre.
  _Pity_ (also peer)
    * Get tickets at the box office.
* Saturday, 2024-11-16, 2:00--4:00 p.m. (but there's an intermission).
  _Grinnell Symphony Orchestra plays Mozart's symphony number 40._

#### Multicultural

* Friday, 2024-11-08, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Alumni_

#### Peer

* Sunday, 2024-11-10, 2:00 p.m., Sebring-Lewis.
  _Grinnell Singers: Songs of Earth_.

#### Wellness

* Tuesday, 2024-11-12, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-11-12, 4:30--6:30 p.m., Secret Place.
  _Forest Bathing_.
* Tuesday, 2024-11-19, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.

#### Misc

* Thursday, 2024-11-07, ???. Harris.
  _Blood Drive_.
* Friday, 2024-11-08, 4:00--5:15 p.m., Somewhere.
  _Election analysis_.

### Other good things (no tokens)

About mini-project 8
--------------------

Fun with sorting!

Questions
---------

### Preregistration

**Do you get to choose your CS advisor?**

> Kind of.

> You provide us with a ranked list, we use a program to pick from your
  ranked list, trying to give everyone someone near the top of the list.

### Administrative

**Will the past solas be graded before the new solas be due?**

> That's certainly my goal. I'm hoping to have everything done by Saturday night.

**Do you charge tokens for late post-reflections if we submit the MP late?**

> No.

### MP7

**We have an AI that chooses randomly between the available moves. Can we use an `ArrayList` for that?**

> I'd prefer that you didn't. `ArrayList.remove` is likely to be $$O(n)$$. 
  You should be able to design this with an array so that it's $$O(1)$$.

> In fact, let's do it "together" (TPS).

```
/**
 * A way to make random moves.
 */
public class RandomMove {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The total number of possible moves.
   */
  public static final int NUM_TOTAL_MOVES = 100;

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * A random number generator.
   */
  Random rand;

  /**
   * All possible remaining moves.
   */
  Move moves[];

  /**
   * Only the first size moves are still valid.
   */
  int size;

  // Others as appropriate

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new random move thingy.
   */
  public RandomMove() {
    this.rand = new Random();
    this.moves = new Move[NUM_TOTAL_MOVES];
    for (int i = 0; i < NUM_TOTAL_MOVES; i++) {
      this.moves[i] = ...;
    } // for
    this.size = NUM_TOTAL_MOVES;
  } // RandomMove()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get and make unavailable a random move.
   */
  public Move nextMove() {
    int pos = this.rand.nextInt(this.size);
    Move m = this.moves[pos];
    // What next? THIS IS WHAT YOU SHOULD TALK ABOUT WITH YOUR PARTNER
    this.size--;
    return m;
  } // nextMove()

} // class RandomMove
```

Options for "What next?"

* Swap the move we selected with the last element. O(1)
* Swap the last element into the place. Set the last element to null. O(1)
* Do the same thing as ArrayList and shift evrryting. O(n)

Note: We've seen this kind of idea before. We used a similar idea in
implementing `remove` in associative arrays.

Lessons:

* Think about the cost of the methods you call.
* Ask yourself whether you can do better.
* In object-oriented programs, decomposition can involve building new 
  (small) classes.
* Try to remember "side" ideas from prior projects.

### Doubly linked lists

**Can you draw a doubly-linked list on the board and go through some of the operations?**

> Certainly.

**Why don't I have to deallocate things when they get removed?**

> Welcome to the wonder of garbage collection. Java regularly looks through
  your objects and removes any that are not referenced.

**Why don't all languages use garbage collection?**

> The original garbage collectors had odd behavior, which was "the program
  runs fine until it's time to garbage collect, then it stops for five 
  minutes".

> Some programmers want finer-grained control.

> Many languages (e.g., C) were invented before garbage collection was a
  well-known technique.

**What are some real-world uses for doubly-linked lists?**

> Any situation in which you need a mutable list. A to-do list is one
  common application. I believe one version of CSC-161 has students use
  lists to represent a ticketing system.

**Why would we use a circular doubly-linked list rather than a doubly-linked
  list?**

> It turns out that over the long term, cdlls are easier to implement
  correctly.

**In what scenarios would you still choose a singly linked list
  over a doubly-linked list? Are there specific performance or memory
  considerations that make singly linked lists preferable in certain
  cases?**

> If we don't need to move backwards in the list, a singly-linked list
  will suffice.

**How do Java’s garbage collection and memory management processes
  handle the nodes in linked lists when elements are removed or when
  lists are no longer needed? Would explicit nulling of node references
  be beneficial in Java, or does garbage collection handle this
  automatically?**

> Nulling of references from nodes is beneficial primarily in that it
  helps avoid problems in cases in which there are stray references to
  the nodes around.

> Nulling isn't necessary in most garbage collection systems. If the
  object can't be reached, it can be garbage collected.

**Is the Iterator is an easier way so that client doesn't have to
  initialize their own pointer to `while (curr.next)` through the linked
  list?**

> Iterators let us hide the internals of the class but still allow people
  to visit all of the elements.

**How can I create a heterogenous linked list class by myself?**

> Just just any of the linked-list strategies and make the value field 
  in each node hold `Object` values.

**To clarify, do list iterators in Java add elements kind of like in
  the front of a list? Assuming next is the second element in the list.**

> Iterators add elements wherever they are in the list. If an iterator
  is between the first two elements, it would add a new element after the
  first element but before the second element.

**In the List Javadocs, why is the `List.copyOf` method unmodifiable? Is
  it just because it is (I'm assuming) a deep copy of a List? If so,
  why couldn't the copyOf method have been a shallow copy implementation?**

> Unfortunately, I don't have deep enough knowledge of the Java design
  decisions (and I'm too lazy to look them up). My guess is that they want
  to make it easier/faster to make copies of unmodifiable lists (e.g.,
  you can just return the same list). I don't think it has anything to do
  with shallow/deep copying.

### Miscellaneous

Lab
---

You know the drill.

A different kind of lab. Write up as you go. Mostly "propose what to do and
then compare to what we've done".


