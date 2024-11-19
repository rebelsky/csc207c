---
title: "Eboard 22 (Section 1): Binary search trees"
number: 22
section: eboards
held: 2024-11-19
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* Questions
* Second discussion on code of ethics
* Designing a Dictionary ADT
* Binary search trees, reviewed
* Lab

Preliminaries
-------------

### News / Notes / Etc.

* We have both talking and lab today.
* If you haven't done so yet, please sign up for 
  <https://passwordreset.grinnell.edu>.
* Note that "lower-bound inclusive, upper-bound exclusive" is a common
  approach.  Think about, say, `String.substring(lb, bu)`. I strongly
  ecnourage you to use it.
* I've added a three-day extension for MP9. It's now due on Sunday to
  give you another weekend.
* Grading updates
    * MPs/A: Was 5E, 5M, 1R, now 4E, 5M, 2R
    * MPs/B: Was 3E, 6M, 2R, now 2E, 5M, 3R
    * MPs/C: Was 2E, 5M, 4R, now 1E, 5M, 5R
    * MPs/D: Remains 4M, 5R, 2I
    * LAs/A: Was 46/48, now 45/48
    * LAs/B: Was 44/48, now 43/48
    * LAs/C: Was 42/48, now 41/48
    * LAs/D: Remains 15/48

### Upcoming work

* Wednesday, 2024-11-20
    * Reading for class 23: 
      [Osera 12: Hashing](https://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/osera/chap12.pdf)
    * [Submit reading response for class 23 on Gradescope](???)
    * [Submit lab writeup from class 22](???)
* Thursday, 2024-11-21
    * MP10 assigned (due in two weeks)
* Sunday, 2024-11-24
    * [MP9](../mps/mp09) (Blockchains) due.
    * [Submit MP9 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5321058)
* Monday, 2024-11-25
    * [SoLA 10](../los/sola10) due
        * New LAs
    * [Submit post-reflection for MP9](https://www.gradescope.com/courses/818402/assignments/5321060)
* Tuesday, 2024-11-26

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-11-19, noon--1:00 p.m., Day PDR.
  _CS Table: Gopher_
* Tuesday, 2024-11-19, 4:15 p.m., Burling Lounge.
  _Fernanda Eliott Harris Lecture, 
   "Can Insights from the Multi-Agent Systems’ Coordination/Cooperation 
    Dichotomy Enlighten Empathy Investigation?"_
* Thursday, 2024-11-21, 4:00--5:00 p.m., Science 3821.
  _CS Extras_
* Sunday, 2024-11-24, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_

#### Cultural

* Weekend of November November 23, Roberts Theatre.
  _Pity_ (also peer)

#### Multicultural

* Friday, 2024-11-22, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Somewhere_

#### Peer

#### Wellness

* Tuesday, 2024-11-19, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-11-19, 4:30--6:30 p.m., Secret Place.
  _Forest Bathing_.
* Tuesday, 2024-11-19, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.

#### Misc

* Fill in the peer-educator evaluation form (see email).
* Friday, 2024-11-22, 5:00--8:00 p.m., Downtown Grinnell.
  _Jingle Bell Holiday_.

### Other good things (no tokens)

Notes on MP9
------------

* Goals of assignment
    * Build something like a linked list
    * Build iterators for the structure
    * In a non-trivial context
    * Reading documentation for library classes
* Due date extended until Sunday (with late assignments accepted until Tuesday).
* These hashes are not the same as the hash values/hash codes we use for 
  hash tables.
    * The also aren't the same as hash tables.
    * These hashes are values we compute so that we can validate data in the future. If we compute a hash now and compute a hash later, the two hashes should be the same. (Hashes are generally smaller than the data.)

Questions
---------

### Administrative

The ACM Code of Ethics
----------------------

Designing a Dictionary (Map) ADT
--------------------------------

Strategy: 

* A generalized way to create a collection in which you can look up values
  by their corresponding keys.
* "Arrays with homogeneous keys of types other than integer".

Applications:

* Keep track of deposits in a block chain.
* Keep track of the relationship between images and words that those
  images represent.
* Keep track of student grades.

Methods:

Implementing the Dictionary (MAP) ADT
-------------------------------------

Arrangements

* Associative Array: An array of key/value pairs.
* Association List: A list of key/value pairs.
* Binary search tree: A tree in which smaller keys fall to the left
  and larger keys fall to the right. (This holds at every node.)
* Heap: Forthcoming.
* Hash table: Forthcoming.

Binary search trees
-------------------

Let $$n$$ be the number of elements in the tree and $$h$$ be the height of the tree.

Lab
---

Make sure that the lab repo ends with `-maven`.
