---
title: "Eboard 25 (Section 1): Priority queues and heaps"
number: 25
section: eboards
held: 2024-12-03
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * This week's SoLA comments
    * Upcoming work
    * Tokens
    * SoLA notes
    * MP 10 notes
    * Questions
* Priority queue basics
* Introducing heaps
* Heap operations
* Implementing heaps with arrays
* Heap sort

Preliminaries
-------------

### News / Notes / Etc.

* Today is a talk day. But you could tell that.
* I broke a tooth, so I will be answering my phone in case it's the
  dentist's office.

### Upcoming work

* Wednesday, 2024-12-04
    * Reading/Skimming: Lots of things on graphs
    * [Submit reading response for class 26](???)
* Thursday, 2024-12-05
    * [MP 10](../mps/mp10) due.
    * [Submit MP10 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5380849)
    * [MP 11](../mps/mp11) released.
* Friday, 2024-12-06
    * [Submit post-reflection for MP10](https://www.gradescope.com/courses/818402/assignments/5380852)
* Monday, 2024-12-09
    * [SoLA 12](../los/sola12) due
        * New: [ADT/DS 4: Priority queues](https://www.gradescope.com/courses/818402/assignments/5402118)
        * New: [ADT/DS 6: Hash tables](https://www.gradescope.com/courses/818402/assignments/5402119)
        * New: [ADT/DS 8: Heaps](https://www.gradescope.com/courses/818402/assignments/5402114)
        * New: [Algorithms 5: Heap sort](https://www.gradescope.com/courses/818402/assignments/5402117)
        * Dropped: OOP #07: Design Patterns

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-12-03, noon--1:00 p.m., Day PDR.
  _CS Table: Google's Monopoly_
* Thursday, 2024-12-05, 4:00--5:00 p.m., Science 3821
  _CS Extras_
* Sunday, 2024-12-08, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_

#### Cultural

#### Multicultural

* Friday, 2024-12-06, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: ???_ 

#### Peer

#### Wellness

* Tuesday, 2024-12-03, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-12-03, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.

#### Misc

### Other good things (no tokens)

This week's SoLA comments
-------------------------

* Please document your helper methods.
* When describing ranges, please make sure whether each bound is inclusive
  or exclusive.
* Please be accurate and specific in your citations. If you're citing a 
  class, give the date and/or class number and/or URL of the eboard. If
  you're citing a lab or code from the lab, give the GitHub URL.

MP 10
-----

### Hex code to unicode

Big picture:

* Input:
* Output:

Questions
---------

### Administrative

**SoLA 12 will open tonight, right?**

> Yes.

**Will MP 11 be a group project?**

> No.

### MP 10

### Priority queues

**Are priority queues considered FIFO just like queues? The first element to enter may not be the first one to be removed if it has a low priority. But then why is this structure considered a queue?**

> Welcome to the wonderful world of CS terms. Priority queues are not FIFO. They aren't really queues. They are simply linear structures with a "highest-priority first" policy.

**What are some practical use cases where the linked implementation of a priority queue would outperform the array implementation?**

> Presumably, if we ended up inserting things in reverse order of priority, the linked structure would win out.

> In practice, we use neither a linear linked structure nor a standard array-based approach.

**What are the practical scenarios where an unordered array implementation is preferred over an ordered one?**

> If we do many more calls to `put` than `get`, an unordered array is likely to be much more efficient.

**How does the choice of data structure (e.g., binary heaps) improve the performance of priority queues?**

> We'll cover this in class.

> But if you know what a binary heap is, you should know the answer.

**For an array-based implementation of priority queues, could you also store elements in descending order (highest priority to lowest priority)? Or generally, why would it be better to consider one form of ordering for either array-based or linked-based implementations as opposed to the opposite ordering?**

> To be discussed in class.

**With priority queues, what should be done if two items are considered to have equal priority? This is only important if the objects are different. For example, what should be done if length determines priority (less is better) and "two" is put in after "one"?**

> They are equal priority and can therefore be returned in either order. We might try to make our priority queue more like a queue and return the first one added.

### Hash tables

### Miscellaneous

Priority queues
---------------

### Strategy

Linear structures with "highest priority first" as the policy.

#### Applications

* To-do lists
* Simulating TSA

### Methods

* `void put(T val)`
* `T get()`
* `T peek()`

### Arrangements (submitted by students)

* A1: Array, unordered
* A2: Array, ordered from highest priority to lowest
* A3: Array, oredered from lowest priority to highest
* L1: Linear singly-linked structure, unordered
* L2: Linear singly-linked structure, ordered from highest priority to lowest
* L3: Linear singly-linked structure, ordered from lowest priority to highest
* T1: BST using priorities (lower-priority values to the left, higher-priority
  values to the right)

### Algorithms + Analysis

_TPS_

* A1: Array, unordered
    * `put`: 
    * `get`:
    * `peek`:
* A2: Array, ordered from highest priority to lowest
    * `put`: 
    * `get`:
    * `peek`:
* A3: Array, oredered from lowest priority to highest
    * `put`: 
    * `get`:
    * `peek`:
* L1: Linear singly-linked structure, unordered
    * `put`: 
    * `get`:
    * `peek`:
* L2: Linear singly-linked structure, ordered from highest priority to lowest
    * `put`: 
    * `get`:
    * `peek`:
* L3: Linear singly-linked structure, ordered from lowest priority to highest
    * `put`: 
    * `get`:
    * `peek`:
* T1: BST using priorities.
    * `put`: 
    * `get`:
    * `peek`:

### Observations

Priority queue sort
-------------------

Heaps
-----

Heap operations
---------------

Heaps as array-based structures
-------------------------------

Heap sort
---------
