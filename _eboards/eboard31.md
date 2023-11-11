---
title: "EBoard 31: Binary search trees"
number: 31
section: eboards
held: 2023-11-10
link: true
---
# {{ page.title }}

**Warning** This class is being recorded (and transcribed) (assuming Teams succeeds).

_Approximate overview_

* Administrivia
* About MP8
* Questions
* Binary search trees
* Lab

Administrivia
-------------

* FYI: There are only two MPs left; I don't think we should have work
  due on Thanksgiving (week 12) or during week 14.
* You can use week 14 and finals week to catch up on MP redos and
  to LAs.
* Please return cards, boards, and markers to the back of the room
  when you finish class today.

### Upcoming Token activities

Academic

* Tuesday, 2023-11-14, Noon, Day PDR: _CS Table_
* Wednesday, 2023-11-15, 4pm, HSSC Kernel: _Madison Van Oort ’08 speaks
  Frictions in the Future of Work_.
* Thursday, 2023-11-16, 4:15pm, HSSC Kernel:  _CS Poster Session_.

Cultural

* Today, 2023-11-10, _Jazz Concert_
* Saturday, 2023-11-11, Drag.

Peer

* Saturday, 2023-11-11, Noon, Football vs. Cornell
* Sunday, 2023-11-12, 2-5pm, HSSC N3170 - Inquiry Learning Lab: 
  _Smash@Grinnell Friendlies_.
* Sunday, 2023-11-12, 5:30-7:30, _International Food Bazar_
* Monday, 2023-11-13, 4-6pm, _3D Printing Workshop_, Stew Makerspace
Wellness
* Tuesday, 4-6pm, 3rd floor HSSC, somewhere: _Wilson Catalyst_

Misc

* Sunday, 2023-11-12, 2-3:30 pm, Sebring-Lewis: _Grinnell Singers_.
* Monday, 2023-11-13, 4-5:30pm, HSSC N1112: _Politics of AI Info Session_.

### Other good things (no tokens)

### Upcoming work

* MP7 post-assessment due Friday
* MP8 pre-assessment due Sunday
* MP8 due next Thursday.  
* MP8 post-assessment due next Friday

### Friday PSA

* You are awesome, please take care of yourself, people care about you
  (even if our registratoin process suggests otherwise).
* Consent is essential.

About MP8
---------

Convert ASCII <-> braille (six-bit) <-> Unicode for braille

Questions
---------

### Registration

### Trees

### Administrative

Will we have two redo opportunities for each mini-project?

> I hope so.

### MP8

Binary Search Trees
-------------------

What do you know about binary search trees?

* They are trees.
* In which each node has 0, 1, or 2 children ("binary")
* You use them to search
* The connections are from parents to children, but not across siblings.
* In many implementations, we terminate with null values.
* How do we arrange a BST to make searching easier?  
    * Bad strategy: No particular arrangement, requires searching
      both halves.
    * Good strategy: Put smaller elements on the left and larger
      elements on the right.  (We normally don't permit duplicates.)
* How do you search a BST?
    * Look at the current node.  If the element in the node matches
      the sought value, you're done
    * Otherwise, if the element in the node is larger than the sought
      value, search in the left subtree
    * Otherwise, we know the element in the node is smaller than the
      sought value, so search in the right subtree.
    * When you run off the tree, you know the element is not there.
* Running time to search a tree of $n$ nodes?  (Big O.)
    * $O(logn)$, in an ideal (balanced) binary tree.
    * $O(n)$, if we arrange the tree badly
    * $O(depth)$
* BSTs encode binary search in the data structure, which *should* make
  it possible to have a structure we can extend while still searching
  efficiently.
* What makes trees efficient?  A balanced/complete tree of $n values 
  has height $logn$, so if we can build such a tree and only need to
  look at one value per level, we generally get $O(logn)$ algorithms.

Detours

* What are the key ideas in quicksort?
    * There's a pivot (ideally, the median, but usually some random
      value)
    * We divide our values into those smaller than the pivot and larger
      than the pivot.
    * We recursively sort both halves.

Draw a BST for the following strings: 

* koala, llama, gnu, hippo, aardvark, monkey, baboon, chinchilla, dingo

Lab
---

Line 24 of `SimpleBST.java` should read
`Comparator<? super K> comparator;`


