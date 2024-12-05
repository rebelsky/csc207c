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

* Thursday, 2024-12-05, 4:00--5:00 p.m., Science 3821
  _CS Extras_
* Sunday, 2024-12-08, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_

#### Cultural

* Tuesday, 2024-12-03, 7:00 p.m., Sebring-Lewis.
  _Chamber Ensemble_
* Wednesday, 2024-12-04, 7:30 p.m., Herrick.
  _Balinese: Song and Dance Ensemble_
* Friday and Saturday, Wall Theatre.
  _One-act festivals_

#### Multicultural

* Friday, 2024-12-06, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Leiden_ 

#### Peer

* Friday, 2024-12-06, 5:00--8:00 p.m ish, Field House.
  _Track Meet_

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

* Advent of code - Random computing problems. Lots of fun.
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

> Show that you regularly cite code you borrow.

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

Our goal: Figure out how to do that (TPS)

Strategy:

* We can use `java.lang.Integer.toBinaryString` to convert to a series of
  0'1 and 1's. [Whoops; that's the strategy for character to Braille]

New strategy

* Convert the hex to an integer.
    * Use `Integer.parseInt`
    * Create our our own method: 
        * Convert each digit (0-9 subtract '0', 'A' through 'F', 
          subtract 'A' and add 10)
            * E.g., "AF92" -> 10, 15, 9, 2
        * Multiply based on their on position 
            * E.g., 10*16*16*16 + 15*16*16 + 9*16 + 2
* Convert the integer to a unicode character (or unicode character string)
    * You could cast it

Details:

* See code file.

### More questions

**Can we assume the input we get from `load` is valid?**

> Yes.

**Can we assume the input we get in `get` is valid?**

> No. Be prepared to throw an exception.

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
    * `put`: Constant - O(1), unless you have to expand the array.
      If we double the size of the array when we expand it, we can say
      it's "amortized O(1)" - N puts is O(N) [n constant plus one big
      one], so it averages out to constant.
    * `peek`: O(n) because you have to search
    * `get`: O(n) because you have to search and you also have to fill
      in the hole you create (which could be O(1) if you just grab the
      last element)
* A2: Array, ordered from highest priority to lowest
    * `put`: Find where it belongs: O(logn) because you can use binary
      search. Shifting is O(n). O(n + logn) = O(n).
    * `peek`: O(1): It's the first value
    * `get`. O(n): You can get the first value in constant time, but
      you'll then have to shift, which is O(n). Or we could use the
      evil wrap-around technique from our array-based queues.
* A2prime: See above.
* A3: Array, ordered from lowest priority to highest
    * `put`: O(n) see above
    * `peek`: O(1) if we keep track of the size/end
    * `get`: O(1), since we can just decrease the size/end by 1
* L1: Linear singly-linked structure, unordered
    * `put`: O(1): Put it at the start (or at the end if you have an end pointer)
    * `peek`: O(n): You have to search for it
    * `get`: O(n): You have to search for it. At least deletion is easier
      than in arrays.
* L2: Linear singly-linked structure, ordered from highest priority to lowest
    * `put`: O(n) because we have to look through the linked structure
    * `peek`: O(1)
    * `get`: O(1) because you grab the first element and then do something
      like `first = first.next`.
* L3: Linear singly-linked structure, ordered from lowest priority to highest
    * `put`: O(n) see above
    * `peek`: O(1) if you keep track of the last node
    * `get`: O(n) because you have to iterate the whole damn list to get the
      one before it.
      O(1) if you keep track of the last node and make it doubly linked.
* T1: BST using priorities. (skipped for complexity)
    * `put`: 
    * `get`:
    * `peek`:

### Observations

* All of these have at least one operation that is O(n).
* Can We Do Better?
* Normal strategy: 
    * Divide and conquer works well for algorithms
    * Use binary trees for data structures

Heaps
-----

Note: Unrelated to the heap from memory management.

A (max-)heap is a binary tree with two properties:

* The heap property: The value in each node is higher priority than the
  the values in all the nodes below it. (Could also be equal)
* Nearly complete: All the levels are completely full except, possibly,
  for the last one, where all the elements must be shifted all the way
  to the left.

Because our heaps are nearly complete, we know that the height is
O(log2n). If we can implement `put` and `get` in O(height), we have
a more efficient priority queue.

Heap operations
---------------

`peek`: The root has the highest priority element. O(1).

Observations for `put` and `get`:

* We will need to find a location to add (or start adding) the new element.
* We will need to then restore both properties.
* One property may be harder to restore than the other.

`put`:

* Put the new value at the end of the last level (or the start of the
  next level if the last level is full). This means we get the right
  "shape" (nearly complete).
* Heap-up: Repeatedly swap the value with its parent as long as the value 
  is greater priority than the parent.
    * Future problem: How do we find the parent?
* O(logn)

`get`:

* Remove the root, which is the highest priority.
* Put the last thing at the last level at the root. We have now restored
  near-completeness.
    * Future problems: How do we find the last element at the last level?
* Repeatedly swap the value with the larger (higher priority) of its children
  as long as it has a lower priority than the larger of its children.

Outstanding issues:

* How do we find the parent of a node?
    * Add a parent field.
* How do we find the location of the last node on the last level?
    * Hire a mathematician

Heaps as array-based structures
-------------------------------

Although heaps are trees, and we generally implement trees as linked 
structures, we can implement heaps (and, I suppose any binary tree) as
arrays.

Primary idea: Number the nodes in the tree using top-down, left-to-right,
breadth-first traversal.

If we know the size, it's easy to find the first empty space and the last
full space.

How about finding children and parents.

Left child of position i:

* i = 0, left = 1
* i = 1, left = 3
* i = 2, left = 5
* i = 3, left = 7
* i = 4, left = 9
* In general, left = 2i + 1

Right child of position i

* i = 0, right = 2
* i = 1, right = 4
* i = 2, right = 6
* i = 3, right = 8
* i = 4, right = 10
* In general, right(i) = left(i) + 1  = 2(i + 1)

Parent of position i

* i = 1, parent = 0
* i = 2, parent = 0
* i = 3, parent = 1
* i = 4, parent = 1
* i = 5, parent = 2
* i = 6, parent = 2
* In general, parent(i) = (i - 1)/2

Heap sort
---------

Suppose you have a cool implementation of a priority queue. Can you use
that priority queue to sort? You get two operations: put(val) and get(),
which returns the largest value.

* First, put everything into the array. n*Cost(put)
* Next, retrieve them from largest to smallest n*Cost(get)
* In a heap, the cost of put and get are both O(logn)
* Sorting with a heap is O(nlogn).

Heap sort

* Magically turn your array into a heap
* Invariant: Heap and small | Sorted and large
* Repeatedly grab the largest element in the heap, swap to
  end of the heap, move the barrier left, heap-down from the root.

Magically turn the array into the heap

```
for (i = 1; i < size; i++) {
  heap-up(i);
} // for
```

Alternately

```
for (i = size-1; i >= 0; i--) {
  heap-down(i);
} // for
```
