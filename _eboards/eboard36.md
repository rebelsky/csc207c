---
title: "EBoard 36: Heaps and heapsort"
number: 36
section: eboards
held: 2023-11-22
link: true
---
# {{ page.title }}

**Warning** This class is being recorded (and transcribed) (assuming Teams succeeds).

_Approximate overview_

* Administrivia
* Questions
* Priority queues
* Implementing priority queues
* The heap data structure
* Finding the highest-priority element in a  heap
* Adding elements to heaps
* Removing elements from heaps
* Storing heaps

Administrivia
-------------

* Happy Turkey break!
* I'll keep trying to update due dates. Email me if you need one fixed.
* I'll be working on the real whiteboard for the second half of class.  I'll try to
  remember to have the camera on. Perhaps I should ask someone to take photos.
* I asked President Harris what I should say to you about not getting into CS classes.
* On a more positive note, the person teaching CSC-301 makes me feel old.
* NO mentor session this Sunday.

### Upcoming Token activities

Academic

* Tuesday, 2023-11-28, Noon, Day PDR, _CS Table: TBD._

Cultural

* ACSU Karaeoke night, Friday

Peer

* Friday, 2023-12-01, 5:30pm, Natatorium: _Swimming (Pioneer Classic)_
* Friday, 2023-12-01, 5:00pm, Field House: _Indoor track and field_
* Saturday, 2023-12-02, all day, Natatorium: _Swimming (Pioneer Classic)

Wellness

_We need more of these!_

* Be thankful.

Misc

* Subject yourself to a study of types.
* Please fill in the peer educator evaluations

### Other good things (no tokens)

### Upcoming work

* I may send out a link for a reading for Monday. (We're starting on graphs.)

Questions
---------

### Hash tables

### MP9

### Administrative

Priority queues
---------------

_TPS: Fill out the PUMS for Priority Queues_

PUM!  What does it stand for?

Philosophy: A linear structure (like queues or stacks) with a "highest
priority out" policy for the `get` method.

Use cases: Registration system, Improved to-do lists, Vehicle 
systems that admit emergency vehicles.

Methods: 

* `Object get()` - Returns (and removes) the most important thing
  (For priority queues, many people call this `poll`.)
* `void add(Object thing)` - Adds something to the priority queue
* `Object peek()` - Finds but does not remove the highest-priority thing

How do we determine priority?

* Associate an integer with each object in the queue.
    * `void add(Object thing, int priority)` - Adds something to the priority queue
* Every priority queue could have an associated comparator.
* Only put `Comparable` objects in the priority queue.

Implementing priority queues
----------------------------

_TPS: How would you implement priority queues?_

LIA! What does it stand for?

* Layout (are we using arrays or linked structures; how do we lay out the arrays and linked structures)
* Implementation (what does that imply for how we implement the methods)
* Analysis (how efficient are these methods)

### Idea one:

Layout: Just shove 'em in an array and deal with the unordered aspect
of the array.

I:

* add: put it on the end.
* get: look at all the elements to find the highest-priority,
  remove it, move the end thing where it was.
* peek: look at all the elements to find the highest-priority.

A:

* add: amortized O(1), at least if we leave free space at the end
  and use the normal mechanism for expanding arrays.
* get: O(n)
* peek: O(n)

### Idea two: Sorted arrays

L: Values are in order from highest to lowest

IA:

* `add` - find the correct location O(logn) + shift O(n): O(n)
* `peek` - it's at the front: O(1)
* `remove` - probably have to shift everything, O(n)

L: Values are in order from lowest priority to highest priority

* `add` - find the correct location O(logn) + shift O(n): O(n)
* `peek` - it's at the end: O(1)
* `remove` - it's at the end, shrink the usable portion by 1: O(1)

### Idea three: Unsorted linked lists

* A whole like like unsorted arrays

### Idea four: Sorted linked lists.

* A whole like like sorted arrays

### Followup questions

_Can we do better?_

TPS: What are techniques we use to do better?

* Use divide-and-conquer
* Restrict the organization of the data in some way
* Use randomness
* Out-of-the-box idea, such as hash tables

The heap data structure
-----------------------

* A nearly complete tree (every node has two children until we get 
  to the bottom row).  This helps ensure that height(tree) = log(n)
* Add "the heap property": Every node is higher priority than its
  children (or equal priority to children).

Peek: Finding the highest-priority element
------------------------------------------

The highest priority element is at the root.  We should be able to
find that in O(1) steps.

Add: Adding elements to heaps
-----------------------------

Two key properties to maintain: 

* Nearly complete
* Heap property: Each element is higher or equal priority to the one
  below it.

We can maintain the shape (nearly complete) by adding the element to
the end of the lowest level.

_TPS_: How might we now EFFICIENTLY restore the heap property?_

We can "swap up", comparing the value to its parent and swapping if
they are out of order.  Repeat until you reach the root or they are
in order.

Why don't we have to look at the other subtree?  Because we know the parent was higher priortiy than everything in the other subtree, if we swap, this is higbher priority than the parent, and we assume priority is a transitive relationship.

This is O(logn)

Poll: Removing elements from heaps
----------------------------------

Two key properties to maintain: 

* Shape (mostly complete)
* Heap property: Higher-prioity elements above lower-priority elements

Put the rightmost thing on the last level at the root, preserves the
shape property.

Need to restore the heap property.

Swap with the smaller of the two children. That ensures that the value
being swapped up is of higher priority than both sides

Keep swapping down the tree until things are in order or you reach
a leaf.

This is O(logn)

A nice use

Heapsort
--------

* Put everything in the heap $$O(nlogn)$$
* Remove everything from the heap $$O(nlogn)$$
* Since they come out in order, it's sorted.
* Note: With some clever tricks, you can do this in-place.
* Fast O(nlogn), uses memory well, but not stable.

Storing heaps
-------------

_TPS: How do you find "the last element in the last row" or "the last space in the last row"?_

* UM: Use math

Or ...

Store the tree in an array using a breadth-first numbering system.

If there are k elements in the heap, the last element is at index k-1 in
the array and the first free spot is at index k.

How do we efficiently find children and parent?

* UM: Use math
* Observation: If we can find the left child, we can find the right
  child, since it's one more than the left child.
* What do see as patterns?
    * left(0) = 1
    * left(1) = 3
    * left(2) = 5
    * left(3) = 7
    * left(4) = 9
    * left(5) = 1
* left(k) = 2k+1
* right(k) = 2(k+1)
* parent(k) = (k-1)/2
