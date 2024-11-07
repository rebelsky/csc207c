---
title: "Eboard 19 (Section 2): Linked lists"
number: 19
section: eboards
held: 2024-11-08
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* About mini-project 8
* Questions
* Lab

Preliminaries
-------------

### News / Notes / Etc.

* We're back to lab today. Tuesday will be a talk day. We'll also spend a
  bit of time on Tuesday revisiting Quicksort.
* New office hour approach: Use the Outlook scheduling assistant to 
  schedule 15-minute or 30-minute appointments. I'll generally say yes 
  to requests during the day for times that I'm not booked..
* Each of us is reacting differently to the election results. If there are
  things I can do to help you (e.g., give you extra time on something),
  please let me know. We can also talk about class-wide adjustments.

### Strategies for coping with added stress

_Adapted from my colleague, Nicole Eikmeier._

* Consider limiting your screen time.
* Engage in activities that nourish you: podcasts (non-political), music 
  (listen or make), journal, read, spend time in nature, etc.
* Take care of yourself: Prioritize sleep, eat nutritious food, move
  your body, etc.
* Reach out to your emotional supports: family, friends, mentors,
  coaches, healthcare professionals, faculty, etc.
* Attend campus support events this week
* Take advantage of campus wellness activities, like therapy dogs

### Upcoming work

* Thursday, 2024-11-07
    * [Mini-project 8](../mps/mp08) released.
    * [Submit Mini-project 7](https://www.gradescope.com/courses/818402/assignments/5247567)
* Friday, 2024-11-08
    * [Submit post-reflection for MP7](https://www.gradescope.com/courses/818402/assignments/5247571)
* Sunday, 2024-11-10
    * [Submit pre-reflection for MP8](https://www.gradescope.com/courses/818402/assignments/5284860)
* Monday, 2024-11-11
    * [Submit today's lab writeup](https://www.gradescope.com/courses/818402/assignments/5280274/outline/)
    * Read [The ACM Code of Ethics and Professional Conduct](https://www.acm.org/code-of-ethics)
    * [Submit reading response for class 19 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5284468) (this is a real reading response)
    * [SoLA 8](../los/sola08)
        * New ADT/DS LAs
            * [ADT/DS 11: Linked structures](https://www.gradescope.com/courses/818402/assignments/5276571)
            * [ADT/DS 12: Design ADTs](https://www.gradescope.com/courses/818402/assignments/5276572)
            * [ADT/DS 13: Design data structures](https://www.gradescope.com/courses/818402/assignments/5276574)
            * [ADT/DS 14: Iterators](https://www.gradescope.com/courses/818402/assignments/5276576)
        * New OOP LA
             * [OOP 8: Object design](https://www.gradescope.com/courses/818402/assignments/5276578)
        * Sam expects to be have prior SoLAs graded by the weekend.
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

* Sunday, 2024-11-10, 2:00 p.m., Sebring-Lewis.
  _Grinnell Singers: Songs of Earth_.
* Weekends of November 16 and November 23, Roberts Theatre.
  _Pity_ (also peer)
    * Get tickets at the box office.
* Saturday, 2024-11-16, 2:00--4:00 p.m. (but there's an intermission).
  _Grinnell Symphony Orchestra plays Mozart's symphony number 40._

#### Multicultural

* Friday, 2024-11-08, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Alumni_

#### Peer

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

Note: We've seen this kind of idea before. When?

Lessons:

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

You know the drill. However, today's drill is a bit different.
