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

#### Multicultural

* Friday, 2024-12-06, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: ???_ 

#### Peer

* Friday and Saturday, Wall Theatre.
  _One-act festivals_
* Tuesday, 2024-12-03, 7:00 p.m., Sebring-Lewis.
  _Chamber Ensemble_
* Wednesday, 2024-12-04, 7:30 p.m., Herrick.
  _Balinese: Song and Dance Ensemble_
* Friday and Saturday, all day (1 hour suffices), Osgood Natatorium.
  _Pioneers Swim Meet_

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

* Convert the hex code to an integer (hope that that there's something in
  `java.lang.Integer` to do that).
    * You could also do this "by hand" - map each digit to an integer in
      the range 0 .. 15. Multiply the first character by 16*16*16, the
      next by 16*16, the next by 16, the last by 1 and then add all together.
* Convert that integer to a unicode character. (There's probably something
  in `java.lang.Character` to do that.)

Details:

* hex to integer - Integer.valueOf or Integer.parseInt
* integer to Unicode character - Character.toChars (returns byte array)
* Byte array to string - Use the String constructor.

### More questions

**What do you mean by "don't fill in the nodes until necessary"?**

> Consider the call `new BitTree(3)`.

> That could be a tree with four levels (one node at level 0, two nodes at 
  level 1, four nodes at level 2, eight nodes at level 3).

> We could build all fifteen nodes at once, but that would be wasteful. And
  we wouldn't have anything to put in the leaf nodes. So we instead only
  add nodes when we call `set`.

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
    * `put`: Add at the end of the array O(1), if we have enough room.
       O(n) if we have to expand the array. If we double the size of the
       array, it's "amortized O(1)".
    * `get`: O(n) because you have to look at all of the elements
    * `peek`: O(n) ditto
* A2: Array, ordered from highest priority to lowest
    * `put`: O(n) you have to figure out where it goes, which means
      searching through all the elements. (Even if we can find the spot
      in O(logn) by using binary search, it will still be O(n) to shift
      values to make room for it.)
    * `get`: O(n) because you'll have to shift everything down after
      removing the first element (or use that horrid "wrap-around"
      strtegy we used for queues).
    * `peek`: O(1) it's at the front
* A3: Array, ordered from lowest priority to highest
    * `put`: O(n): see aboe
    * `get`: O(1)
    * `peek`: O(1)
* L1: Linear singly-linked structure, unordered
    * `put`: O(1): Update either the pointer to the first node or the
      pointer to the last node.
    * `get`: O(n) because you have to look through all of them
    * `peek`: O(n) because you have to look through all of them
* L2: Linear singly-linked structure, ordered from highest priority to lowest
    * `put`: O(n) because you have to search through the list (at least
      there's no shifting)
    * `get`: O(1) you can easily move front to front.next.
    * `peek`: O(1) it's at the front
* L3: Linear singly-linked structure, ordered from lowest priority to highest
    * `put`: O(n) for similar reasons
    * `get`: O(n) because we have to go through the entire list to find
      the predecessor of the last node
    * `peek`: O(1) if we keep a pointer to the last node
* T1: BST using priorities. (skipped for complexity)
    * `put`: 
    * `get`:
    * `peek`:

### Observations

* All of these have at least one operation that is O(n).
* Can We Do Better?
* Normal strategy: Divide and conquer (for algorithms)
* Normal strategy: Use trees (for data structures)

Heaps
-----

* Trees in which
    * Each node has a higher priority than all of its descendants
      (or equal) - "Heap Property"
    * Nearly complete
        * All the levels except the last are completely full.
        * The last level is filled from left to right.
* The highest priority element is at the top, so `peek` is cheap.
* Because the trees are nearly complete, if we can make `put` and
  `get` be O(height), they will be O(log2n) operations.

Heap operations
---------------

`put`: How do we add an element to the tree and then restore the
two properties? (The heap property and the nearly-complete property.)

* Nearly-complete may be harder, because getting a particular shape
  is difficult.
* Hence, our first step is "put at the end of the last row" (or at
  the beginning of the next row if the last row is filled)
* Next, we "heap up", swapping a value with its parent as long as the
  value is higher priority than the parent
* Running time is O(logn), provided we have parent pointers (or
  something similar) and we can quickly find the last space in the
  last row.
    * Hire a mathematician to give you the approach, which may just
      be based on the binary representation of the size.

`get`: After removing the top element, how do we restore the two properties?
(The heap property and the nearly-complete property.)

* Swap the last element to the top. That turns it back into a tree.
* Heap down: As long as the node is lower priority than at least one
  of its children, swap with the higher-prority child.

Side note: 

Heaps as array-based structures
-------------------------------

Number the nodes left-to-right, breadth first, starting at 0. That gives
their location in a corresponding array.

Given a node at position `i`, 

* its left child is at:
    * 0: 1
    * 1: 3
    * 2: 5
    * 3: 7
    * 2i + 1
* its right child is at:
    * 0: 2
    * 1: 4
    * 2: 6
    * 3: 8
    * 2i + 2
* its parent is at: 
    * 1: 0
    * 2: 0
    * 3: 1
    * 4: 1
    * 5: 2
    * 6: 2
    * 7: 3
    * 8: 3
    * Even: i/2 - 1
    * Odd: i/2
    * Both: (i - 1)/2

Heap sort
---------

How do we sort with a priority queue:

* If you add all of the elements and then remove them one by one, you'll
  end up with the elements (in reverse sorted order).
* In a heap, `put` is O(logn), `get` is O(logn)
* We put n elements, we get n elements, so O(nlogn) for heap sort
