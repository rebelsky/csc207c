---
title: "Eboard 33: BSTs"
number: 33
section: eboards
held: 2024-04-19
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* About BSTs
* Questions
* Labs

Preliminaries
-------------

* Welcome to any prospective students!
    * Our weather is much more varied than California's, it's definitely 
      a reason to come to Grinnell.
    * Our faculty are nice and never ever threaten to fail students
      for what they say in class.
    * UM: Do you use math in your CS class? Yes!
    * Do folks double major in CS? Yes! Math, Psych, Philosophy,
      Art, Art Again, English, Music
    * How hard is it to double major in Grinnell? It's not too bad as long
      as you plan well. Triple majoring is harder. (But we may eliminate
      that possibilities.)
* **Please fill in the mentor/tutor evaluation.**
* Mentor/Tutor/Grader applications are due soon. If you have classmates
  who (a) seemed to understand the material well and (b) were appropriately
  supportive when working in pairs, you might want to encourage them to
  apply.
* We may have prospective students today. Please treat them kindly.
* There are two labs for today. I don't think you'll get to the second
  one, but let's hope you'll have time to look it over.

### Upcoming work

* Friday, 2024-04-19, 11:00pm, Post-reflection for [MP8](../mps/mp08)
    * [_Submit post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4340799)
* Friday, 2024-04-19, 11:00pm, Pre-reflection for [MP9](../mps/mp09)
    * [_Submit post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4373433)
* Sunday, 2024-04-21, 11:00pm, Reading.
    * [PMO on Hash Tables](https://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/osera/chap12.pdf)
* Wednesday, 2024-04-24, 11:00pm, MP9
    * _Probably not posted yet._

### Tokens

Academic/Scholarly

* Tuesday, 2024-04-23, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-04-23, 8:00pm, Science 3819.
  _Mentor Session_. Make Elene and Sam happy. Show up to mentor sessions!

Cultural

* Friday, 2024-04-19, 4:00--5:00pm, HSSC N1170.
  _Middle of Everywhere_. (Ghana?)
* Saturday, 2024-04-20, 2:00--5:00pm, 8th Avenue.
  _Carnivale_ (or _Carnaval_) (or _Carne Val_)
    * Now on 8th Avenue
* Saturday, 2024-04-20, 2:00--5:00pm, Quad Dining Room.
  _Japanese Spring Festival_.
* Saturday, 2024-04-20, 7:00--9:00pm, Herrick.
  _Michael Londra and the Grinnell Symphony Orchestra_.
* Sunday, 2024-04-21, 2:00--4:00pm, Sebring Lewis Hall.
  _Grinnell Singers with a King Singer (Simon Carrington)._

Peer

* Saturday, 2024-04-20, 10:00am--1:00pm, Track and Field Complex.
  _Dick Young Classic_.
* Sunday, 2024-04-21, 10:00am--1:00pm, Tennis Courts.
  _Men's Tennis vs. Coe._

Wellness

Misc

* Saturday, 2024-04-20, 8:00am--5:00pm, JRC 209.
  _Mental Health First Aid Training_. 
* Saturday, 2024-04-20, 11:00am--6:00pm, Mac Field.
  _DAG Field Day_. 

### Other good things to do (no tokens)

* Consider voting for your classmates for SEPC. Or at least for one
  of them.
* Saturday, 2024-04-20, 1:00--3:00pm, .
  _Softball vs. Ripon._
* Saturday, 2024-04-20, 3:00--5:00pm, .
  _Softball vs. Ripon, revisited._

### Friday PSA

* Please be moderate.
* People care about you.
* Consent is essential. It is also necessary. But not sufficient.

Questions
---------

### Administrative

### MP9

Will it be posted?

> During class.

### Binary Search Trees

What are we doing with them?

> Making sure that we understand them (how they work, how to implement,
  how to write iterators, how to traverse them in one eight or so ways)

How do we handle breadth-first traversal vs depth-first traversal in
an iterator?

> We normally use a queue for breadth-first traversal and a stack for
  depth-first traversal. Clever manipulation of either lets you keep
  track of where you are in the traverdal and the order of traversal
  (preorder, postorder, inorder).

BST Review
----------

* Binary Search Trees are ...
    * Trees
    * With at most two children per node.
    * Organized so that the left subtree has smaller values and
      the right subtree has larger values.
* How do you search a BST?
    * If the key we're searching for is at the node, stop.
    * If the key we're searching for is smaller, recurse on the left.
      (Or move to the left.)
    * If the key we're searching for is larger, recurse on the right.
    * If you run off the end, the key is not there.
* Depending on how they are built, BSTs can end up quite balanced
  (good) or quite imbalanced (bad). 
    * In CSC-301, you'll learn how to rebalance binary search trees
      quickly (i.e., in O(logn)).

### Exercise

Draw a BST for the following strings. Assume we add them one at a time,
in the order given.

koala, llama, gnu, hippo, aardvark, monkey, baboon, chinchilla, dingo

Lab
---

### `set`

* **Do not use the iterator to ipmlement `set`!**
    * You need to follow the path through the tree to implement `set`.
    * Sam forgot to distribute the cards, so you can choose whether to
      use recursion or iteration.
* Sam recommends that you write it recursively, using a recursive helper
  that keeps track of the current node.
* Sam recommends that your recursive helper return the modified tree.
* Sam writes about Samself in the third person.

Let's write `set` together.


###
