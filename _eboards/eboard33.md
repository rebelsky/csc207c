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
* Lab

Preliminaries
-------------

* Only two more MPs left!

### Upcoming work

### Tokens

Academic/Scholarly

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

* Saturday, 2024-04-20, 8:00am--5:00pm, JRC 209.
  _Mental Health First Aid Training_. 
* Saturday, 2024-04-20, 11:00am--6:00pm, Mac Field.
  _DAG Field Day_. 

### Other good things to do (no tokens)

* Consider voting for your classmates for SEPC. 
* Saturday, 2024-04-20, 1:00--3:00pm, .
  _Softball vs. Ripon._
* Saturday, 2024-04-20, 3:00--5:00pm, .
  _Softball vs. Ripon, revisited._

NO! You do not get tokens for Wonderland Harris.

Questions
---------

### Administrative

### MP9

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

Draw a BST for the following strings.

koala, llama, gnu, hippo, aardvark, monkey, baboon, chinchilla, dingo

Lab
---
