---
title: "Eboard 25 (Section 2): Priority queues and heaps"
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
    * Reading: Lots of things on graphs
        * Read: [CLRS B.4: Graphs](https://ebookcentral-proquest-com.grinnell.idm.oclc.org/lib/grinnell-ebooks/reader.action?docID=6925615&ppg=907)
        * Skim: [Tree traversal](../readings/tree-traversal)
        * Read: [Wikpedia: Dijkstra's algorithms](https://en.wikipedia.org/wiki/Dijkstra's_algorithm)
        * Read [`Graph.java`](https://raw.githubusercontent.com/Grinnell-CSC207/graphs/main/src/Graph.java), our class's implementation of graphs.
    * [Submit reading response for class 26](https://www.gradescope.com/courses/818402/assignments/5404446)
* Thursday, 2024-12-05
    * [MP 10](../mps/mp10) due.
    * [Submit MP10 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5380849)
    * [MP 11](../mps/mp11) released.
* Friday, 2024-12-06
    * [Submit post-reflection for MP10](https://www.gradescope.com/courses/818402/assignments/5380852)
* Sunday, 2024-12-08
    * [MP 11 pre-reflection](...)
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

* Wednesday, 2024-12-04, 7:30 p.m., Herrick.
  _Balinese: Song and Dance Ensemble_
* Friday and Saturday, Wall Theatre.
  _One-act festivals_
* Tuesday, 2024-12-03, 7:00 p.m., Sebring-Lewis.
  _Chamber Ensemble_

#### Multicultural

* Friday, 2024-12-06, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: ???_ 

#### Peer

#### Wellness

* Tuesday, 2024-12-03, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-12-03, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.
* Friday, 2024-12-06, 9:00 a.m.--3:00 p.m., CRSSJ.
  _Holiday baking_.
* Saturday, ???, Harris.
  _Winter Waltz_

#### Misc

### Other good things (no tokens)

* Friday and Saturday, all day (1 hour suffices), Osgood Natatorium.
  _Pioneers Swim Meet_

This week's SoLA comments
-------------------------

* Please document your helper methods.
* When describing ranges, please make sure whether each bound is inclusive
  or exclusive.
* Please be accurate and specific in your citations. If you're citing a 
  class, give the date and/or class number and/or URL of the eboard. If
  you're citing a lab or code from the lab, give the GitHub URL.
    * Put USERNAME in for the username in GitHub URLs

### Questions

**What should I do in the ethical reuse LA?**

> Show that you regularly cite your code.

> Show that you make sure that you have permission to use the code you
  borrow from elsewhere.

> Usually, this will be a narrative of a time you've used someone else's code
  along with a copy of your citation and other context.

MP 10
-----

### Hex code to unicode

Big picture:

* Input: Four-digit string giving the hex code of a unicode character
* Output: The unicode character

Our goal: Figure out how to do that

Strategy:

Details:

### More questions

Questions
---------

### Administrative

**When are we getting MPs back?**

> I'm not sure. I've tried to find time to grade them myself, but haven't
  been able to.

**Will we get at least one redo opportunity?**

> That's still the plan.

**Will you be more generous on the MP grading (in terms of the number needed
  for A/B/C)?**

> Almost certainly.

**SoLA 12 will open tonight, right?**

> Yes.

**Will MP 11 be a group project?**

> No.

**Will we still have at least two tries on each LA?**

> Yes. There are five new LAs due Monday of finals week and they will be
  repeated Friday of finals week.

**Why didn't you repost an LA for TOPIC?**

> I intended to. If you notice a missing LA, let me know asap.

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
* `T get()` - get and remove the highest priority value
* `T peek()` - get but not remove the highest priority value

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

* A1: Array, unordered (assume you have a `size` field)
    * `get`.
* A2: Array, ordered from highest priority to lowest
    * `put`:
    * `peek`: 
    * `get`.
* A3: Array, ordered from lowest priority to highest
    * `put`: 
    * `get`:
    * `peek`: 
* L1: Linear singly-linked structure, unordered
    * `put`:
    * `get`.
* L3: Linear singly-linked structure, ordered from lowest priority to highest
    * `put`: 
    * `get`:
      the predecessor of the last node
    * `peek`: O(1) if we keep a pointer to the last node
* T1: BST using priorities. (skipped for complexity)
    * `put`: 
    * `get`:
    * `peek`:

### Observations

* All of these have at least one operation that is O(n).
* Can We Do Better?
* Normal strategy: 

Heaps
-----

Heap operations
---------------

Side note: 

Heaps as array-based structures
-------------------------------

Heap sort
---------
