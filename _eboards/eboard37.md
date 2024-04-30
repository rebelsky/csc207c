---
title: "Eboard 37: Heaps"
number: 37
section: eboards
held: 2024-04-29
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Questions
* Priority queues, reviewed
* Introducing heaps
* Designing and analyzing the heap operations
* Implementation details: Storing heaps
* Sorting using heaps
* Sorting in-place using heaps

Preliminaries
-------------

* Just in case you missed the Buffalo sentence, you can read
  about it [on my 'blog](https://rebelsky.cs.grinnell.edu/musings/buffalo-2024-04-28).
* The CS picnic is coming up. Make sure to sign up.
* I've updated the grading policies for the course. We'll go over them
  quickly. I think they appropriately accommodate grading (or lack
  thereof).
* Congratulations to Men's Tennis, particularly to your classmate
  for No. 2 Singles/No. 1 Doubles.
* I will be working from home tomorrow, but should be available for email
  and teams message. Office hours will be via Teams video chat.

### Upcoming work

* Tuesday, 2024-05-30, 11:00pm, Reading on Graphs. 
    * [CLRS B.4](https://ebookcentral-proquest-com.grinnell.idm.oclc.org/lib/grinnell-ebooks/reader.action?docID=6925615&ppg=907)
    * _If you're taking graph theory, you can skip this reading._
* Wednesday, 2024-05-01, 11:00pm, MP10
    * [_Submit MP10 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4405216/)
* Friday, 2024-05-03, 11:00pm, MP10 post-reflection.
    * [_Submit MP10 post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4405177)
* Friday, 2024-05-03, 11:00pm, New set of LAs, repeated + old LAs (I hope)
* Friday, 2024-05-10, 11:00pm, New set of LAs, repeated + old LAs (I hope)

### Tokens

Do I really have 10,000 tokens?

> Yes, unless you missed class on Friday. In that case, you have only 9,999.

Academic/Scholarly

* Tuesday, 2024-04-30, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-04-30, 8:00pm, Science 3819.
  _Mentor Session_. Make Elene and Sam happy. Show up to mentor sessions!
* Thursday, 2024-05-02, 11am, JRC 101.
  _PBK Scholars' Convocation: Cathleen Kaveny on "Can We Be Civil? Prophetic Indictment and Call-Out Culture in American Public Life"._

Cultural

* Most days, 2024-04-xx and 2024-05-xx, 11am-6pm,
  Grinnell College Museum of Art.
  _BAX 2024_. Shouldn't it be BAE?
* Friday, 2024-05-03, 4:00--5:00pm, HSSC N1170.
  _Middle of Everywhere_

Peer

Wellness

* Monday, 2024-04-29, 4:00--5:00pm, HSSC Atrium.
  _Therapy Dogs_.
* Sunday, 2024-05-05, 10:00am--6:00pm, Mac Field.
  _Bubble Soccer_. (It takes almost as long as cricket!)
* Friday, 2024-05-10, 5:00pm--??:??pm, Merrill Park West.
  _CS Picnic!_ Survey forthcoming.

Misc

* Monday, 2024-04-29, 4:00--5:00pm, HSSC A1231 (Kernel).
  _Quality Initiative Update: What We've Learned By Mapping the
   Advising Ecosystem._
* Thursday, 2024-05-02, 4:15--5:30pm, Burling 1st.
  _Conversation with Kathryn Mohrman '67._
* Saturday, 2024-05-04 (aka "Star Wars Day"), 10:00am--11:00pm, Central Campus.
  _The Grinnellian._

### Other good things to do (no tokens)

* Saturday, 2024-05-04 (aka "Star Wars Day"), 1:00--3:00pm, Softball Complex.
  _Softball vs. Lawrence_.
* Saturday, 2024-05-04 (aka "Star Wars Day"), 3:00--5:00pm, Softball Complex.
  _Softball vs. Lawrence_.
* Sunday, 2024-05-05, 1:00--3:00pm, Softball Complex.
  _Softball vs. Illinois_.

### Other questionable things (no tokens)

* Saturday, 2024-05-04 (aka "Star Wars Day"), noon--5:00pm, Cleveland Beach.
  _Alice in Wonderland_.

Questions
---------

### Administrative

When will my MPs be graded?

> I don't know. Stay tuned. 

### MP10

Why are you keeping track of a position in `JSON.java`?

> So that your error message can say "Error at position 1432: Unexpected close brace."

Do we have to do that?

> No.

How should I store "\n"?

> As a string.

> With one character. A newline. (Decimal 10.)

> Which means you'll have to do some conversion when you print it out.

> Sorry.

Should we implement `remove` in our hash tables?

> Only if you'd like a sense of accomplishment. It will not affect your
  grade on the assignment.

Do we have to deal with mulitple JSON objects?

> Nope. Just one.

Can we use magic numbers, like 97 and 49?

> No. `(int) 'a'` is much better than 97.

> `0` is better than 49.

When should `JSONstring.equals(X)` return true?

> When X is a JSONstring and it's the same string.

Should a real and an integer be equal?

> Nope.

### LAs

### Misc

Priority queues (a quick review)
--------------------------------

_TPS!_

### What's a priority queue?

Philosophy: A linear collection in which we use "highest priority" as
the policy for `get` or `peek`.

Use cases: Prioritized to-do list.

Methods: `get`, `put`, `peek`, `isEmpty`, `isFull`.

Optional methods: Iterator, highest to lowest.

### How do we determine priorities (in Java)?

* We could include a numeric priority when you put it.
* Elements might have natural priorities. `Comparable` objects have
  a natural way to determine order.
* We could provide a `Comparator` when we create the PQ object.
* Design question: Is smallest or largest the highest priority?

### How can we implement priority queues?

* Unordered arrays. Each time we call `get` or `peek`, traverse the
  array until you find the highest priority element. In `get` we
  grab that element and then (either shift everything in the array
  or move the last element into that space). For `put`, we add
  at the end (either crashing when it's full or expanding the array).
    * `get` - O(n)
    * `peek` - O(n)
    * `put` - O(1) if we don't expand the array
* Ordered arrays with highest priority at the end. `get` or `peek`:
  Look at the last element.
    * `get` - O(1)
    * `peek` - O(1)
    * `put` - O(n)
* Ordered link lists. (Much like the arrays.)
    * `get` - O(1)
    * `peek` - O(1)
    * `put` - O(n)

Sorting with priority queues: PQSort.

* Put all the elements in the priority queue: `n` puts.
* Grab all the elements out and put them into list/array. They will be
  in order. `n` gets.
* With our current implementations, this is O(n^2).

_Can we do better?_ Yes.

Using binary trees may help.

Heaps
-----

_The heap data structure is not the same thing as heap memory. Computer
scientists suck at terminology._

Heaps are Binary trees with some special properties

* "Heap property": The value at any node is higher priority than the
  values of all its descendents. (Equal is also okay.)
* "Nearly complete": All of the levels except the last are comletely
  full; the last level is "shoved to the left".

Designing and analyzing the heap operations
-------------------------------------------

### `peek`

Return the root. O(1).

### `put`

In order to put, we need to maintain/restore two properties.

Which will be harder to implement?

* Heap property [+1]
* Nearly complete [+1] ***

When we put a value, we add it to the end of the last level (or
start a new level if the last level is full). That maintains the
"nearly complete" propery.

Once you've done that, we need to "heap up" to restore the heap 
property: As long as a node is higher priority than it's parent,
swap with the parent.

`put` takes O(log2n) because the height of a nearly-complete tree
is O(log2n). (Alternately, a tree of height k has approximately 2^k
odes.)

Node: O(logn) and O(log2n) are the same because logn = clog2n and
Sam is too lazy to figure out that constant.

### `get`

We remove the highest priority node at the root and then we have
two properties to restore: "Nearly complete" and "Heap Property".

Take the rightmost value on the last level and put it at the root

Repeatedly swap with higher priorty child, provided that child
has a higher priority than the value.

This is O(logn)

### Observation:

PQSort with heaps is O(nlogn)!

### Questions

How do we know when a level is full?

> When there are 2^n-1 items in the tree.

Could we perhaps implement something more complicated involving
swapping subtrees?

> Perhaps. But this is simple. Let's stick with this for now.

Swap up involves identifying your parent. How do we find the parent?

> We build nodes that have a parent link in addition to the two
  children links. "Ugh"

Implementation details: Storing heaps
-------------------------------------

We can store heaps in arrays, using a breadth-first, left-to-right, 
preorder numbering of the nodes.

The left child of the node at index i is at index `2*i+1`

* Left child of 0 is 1.
* Left child of 1 is 3.
* Left child of 3 is 7.
* Left child of 2 is 5.

The right child of the node at index i is at index `2*i+2`

* Um ... one more than the left child.
* Right child of 0 is 2.
* Right child of 1 is 4.
* Right child of 3 is 8.
* Right child of 2 is 6.

The parent of the node at index i is at index ???

* We should be able to invert the last two functions.
* If i is even, (i-2)/2.
* If i is odd, (i-1)/2.
* With integer division, we can just use `(i-1)/2`.

We save space. We don't have to worry about left pointers, right pointers,
or parent pointers.  Yay!

Any binary tree can be stored in this manner. You'll just have gaps.

Now it's really easy to find the last node on the last level. We don't
even have to ask our friends in math for a formula.

Sorting using heaps
-------------------

Done.

Sorting in-place using heaps
----------------------------

```
+------------------------+--------------+
|      heap              |   sorted     |
+------------------------+--------------+
```

```
+------------------------+--------------+
|l|    heap              |   sorted     |
+------------------------+--------------+
```

to 

```
+----------------------+-+--------------+
|      heap            |l|   sorted     |
+----------------------+-+--------------+
```

If we do that repeatedly, we end up with a sorted array.

Heap sort: 

* Turn the array into a heap. O(nlogn)
* Repeatedly grab the largest remaining element, shove to end. O(nlogn)

Selection sort, but much faster.

All that's left is to turn an unsorted array into a heap.

The obvious strategy.

```
for (int i = 1; i < n; i++) {
  swapUp(i);
}
```


Another one (coming next class)

Is this better than other ways of sorting?

> Merge sort: Requires a helper array. This is better.

> Quicksort: Isn't always O(nlogn); you can choose bad pivots.

In practice?

> Things get more complicated.

> It's also unstable.
