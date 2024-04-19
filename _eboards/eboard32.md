---
title: "Eboard 32: Trees and tree traversal"
number: 32
section: eboards
held: 2024-04-17
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* About trees
* About MP9
* Questions
* Lab

Preliminaries
-------------

* Only two more MPs left! (three, including tonight's)
* For some reason, the reading for today didn't show up on the class
  Web site. I'll try to go over the high points.
* Note: Provided you continue to submit most of the pre-reflections,
  post-reflections, and reading responses, I will not penalize you for
  missing them, even if you've already missed more than I'd like.
* Note that late submissions + tokens were supposed to eliminate the
  need for you to ask for extensions.
* **Please try to attend tomorrow's convocation.**
* **Please fill in the mentor/tutor evaluation.**
* Food!

### Upcoming work

* Wednesday, 2024-04-17, 11:00pm, [Mini-Project 8](../mps/mp08)
    * [_Submit Mini-Project 8 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4363157)
* Thursday, 2024-04-18, 11:00pm, Read about trees and BSTs
    * _Nothing to submit)
* Friday, 2024-04-19, 11:00pm, Post-reflection for [MP8](../mps/mp08)
    * [_Submit post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4340799)
* Friday, 2024-04-19, 11:00pm, Pre-reflection for [MP9](../mps/mp09)
    * [_Submit post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4373433)

### Tokens

Academic/Scholarly

* Wednesday, 2024-04-17, 5:00--6:00pm, HSSC A1231 (Kernel).
  _GrinTECH Project Expo_.  What does TECH stand for?
* **Thursday, 2024-04-18, 11am, JRC 101**.
  **_Ruha Benjamin on "Viral Justice: How We Grow the World We Want"_**
* Thursday, 2024-04-18, 4pm, JRC 2nd Floor Lobby.
  _CS Poster Session, Part 2._
* Thursday, 2024-04-18, 4:15--6:00pm, JRC 101.
  _McKibben Lecture: Athenian Heroes: Re-reading the West Pediment of the Parthenon_.
* Tuesday, 2024-04-23, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-04-23, 8:00pm, Science 3819.
  _Mentor Session_. Make Elene happy. Show up to mentor sessions!

Cultural

* Friday, 2024-04-19, 4:00--5:00pm, HSSC N1170.
  _Middle of Everywhere_. (Ghana?)
* Saturday, 2024-04-20, 1:00--4:00pm, Park Street to the Bear.
  _Carnivale_. 
  Lots of organizations! Get food early, it may run out.
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

* Tuesday, 2024-04-16, 4:00--5:30pm, HSSC N1112.
  _Printmaking Workshop with Digital Studies_. "Drinks and supplies included."
* Saturday, 2024-04-20, 8:00am--5:00pm, JRC 209.
  _Mental Health First Aid Training_. 
* Saturday, 2024-04-20, 11:00am--6:00pm, Mac Field.
  _DAG Field Day_. 

### Other good things to do (no tokens)

* Consider voting for your classmates for SEPC. 
* Wednesday, 2024-04-17, 3:00--5:00pm, Softball Complex.
  _Softball vs. Knox_. (Maybe not.)
* Saturday, 2024-04-20, 1:00--3:00pm, .
  _Softball vs. Ripon._
* Saturday, 2024-04-20, 3:00--5:00pm, .
  _Softball vs. Ripon, revisited._

NO! You do not get tokens for Wonderland Harris.

Trees
-----

A tree is a data structure (or perhaps an ADT) (or perhaps just
a way to think about information) that organizes information
hierarchically.

A _node_ in a tree contains a value (or, at times, a key/value pair),
and zero or more subtrees.

In a binary tree, each node has zero, one, or two subtrees. The
subtrees are usually identified as _left_ and _right_.  (We will
generally work with binary trees.)

Different policies on ordering the values (or keys, for key/value
pairs) in a tree affect how we use them.

### Iterating/Traversing Trees

Suppose we want to visit (process, iterate) all the nodes in a tree.
What are possible orderings?

We can go across the nodes at each level (breadth-first) or we can
fully visit each subtree before visiting the other (depth-first).

We can visit the left subtree before the right (left-to-right) or
the right subtree before the left (right-to-left).

We can visit/process a node before its subtrees (preorder), between
the left and right subtrees (inorder), or after both subtrees
(postorder).  It turns out there can be value in each processing/iteration
strategy.

We'll explore these choices while writing iterators and similar things.

MP9
---

Explorations with a particular kind of binary tree.

Questions
---------

### Administrative

### MP8 - Circularly Doubly Linked Lists with Dummy Nodes

_I hear that the evening tutors had a bunch of basic questions last
night (but not what they were). Note that Elene also had a mentor 
session on the MP._

What should the list look like when it's empty?

> One dummy node. Its `next` field should refer to the dummy node.
  Its `prev` field should also refer to the dummy node.

Lab
---
