---
title: "EBoard 32: Binary search trees, continued"
number: 32
section: eboards
held: 2023-11-13
link: true
---
# {{ page.title }}

**Warning** This class is being recorded (and transcribed) (assuming Teams succeeds).

_Approximate overview_

* Administrivia
* Questions
* Binary search trees
* Lab

Administrivia
-------------

* Please return cards, boards, and markers to the back of the room
  when you finish class today.
* New policy: Overspent tokens and missing labs/reflections cannot drop you
  below a B-.  
* New policy: Up to six missing labs/reflections permitted.
* I was unsuccessful at getting grading done this weekend.  I apologize.
  It's high on my priority list.
* Starting Wednesday, we are doing a week of hash tables (yay!); start
  with a reading by Osera.

### Upcoming Token activities

Academic

* Tuesday, 2023-11-14, Noon, Day PDR: _CS Table: Cell Phone Addiction_.
* Wednesday, 2023-11-15, 4pm, HSSC Kernel: _Madison Van Oort ’08 speaks
  on Frictions in the Future of Work_.
* Thursday, 2023-11-16, 11-noon, JRC 101: _Convocation: Richard Robinson
  on Nanoparticles 101._
* Thursday, 2023-11-16, 4:15pm, HSSC Kernel:  _CS Poster Session_.

Cultural

Peer

* Monday, 2023-11-13, 4-6pm, _3D Printing Workshop_, Stew Makerspace
* Tuesday, 2023-11-4, 4-6pm, 3rd floor HSSC, somewhere: _Wilson Catalyst_
* Thursday, 2023-11-4, 7-9pm, 3rd floor HSSC, somewhere: _Wilson Catalyst_
* Saturday, 2023-11-18, 1pm, Osgood: _Swimming vs Augustana._
* Language study!  Talk to your colleague.

Wellness

* We need more of these!

Misc

* Monday, 2023-11-13, 4-5:30pm, HSSC N1112: _Politics of AI Info Session_.
* Subject yourself to a study of types.

### Other good things (no tokens)

### Upcoming work

* MP8 pre-assessment due Sunday
* PM's reading on Hash tables due Tuesday night
* MP8 due Thursday.  
* MP8 post-assessment due Friday
* MP9 assigned Friday (JSON)

Questions
---------

### Registration

### Trees/BSTs

### Administrative

When will we get MP1 redos back?

> I'll check with the graders.

Where are the LAs?

> Coming soon.  All take-home.  All open-ended.  All infinite (well,
  arbitrarily finite) redos.

### MP8

### Other

Binary Search Trees
-------------------

Um, Aardvark, Penguin, Cat, Panda, Frog, Elk, Squid, Dog, Jellyfish

How do we remove things?

* Leaves: Easy.  Just remove the link to the child.
* Interior nodes with only one child: Build the link over the node.
* Interior nodes with two children.
    * Rebuild the tree (expensive)
    * What's more efficient (remaining $$O(height)$$)?
    * Delete the rightmost thing in the left subtree (or the leftmost
      thing in the right subtree) and put its value in the current node.
    * Historically: "And rebalance, if we can do it efficiently" (301)

Lab
---

Same places, same partners.

"Wow, writing `set` recursively is much easier than writing it iteratively."
