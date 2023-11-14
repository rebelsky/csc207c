---
title: "EBoard 33: Hash tables"
number: 33
section: eboards
held: 2023-11-15
link: true
---
# {{ page.title }}

**Warning** This class is being recorded (and transcribed) (assuming Teams succeeds).

_Approximate overview_

* Administrivia
* Questions
* Lab

Administrivia
-------------

* Please return cards, boards, and markers to the back of the room
  when you finish class today.
* Sorry that I can't be here today.  I'll explain Friday.  I will
  do my best to answer questions on Teams and Email.

### Upcoming Token activities

Academic

* Wednesday, 2023-11-15, 4pm, HSSC Kernel: _Madison Van Oort ’08 speaks
  on Frictions in the Future of Work_.
* Thursday, 2023-11-16, 11-noon, JRC 101: _Convocation: Richard Robinson
  on Nanoparticles 101._
* Thursday, 2023-11-16, 4:15pm, HSSC Kernel:  _CS Poster Session_.

Cultural

Peer

* Thursday, 2023-11-14, 7-9pm, 3rd floor HSSC, somewhere: _Wilson Catalyst_
* Saturday, 2023-11-18, 1pm, Osgood: _Swimming vs Augustana._
* Language study!  Talk to your colleague.
* Tuesday, 2023-11-21, 4-6pm, 3rd floor HSSC, somewhere: _Wilson Catalyst_

Wellness

* We need more of these!

Misc

* Subject yourself to a study of types.

### Other good things (no tokens)

### Upcoming work

* MP8 pre-assessment due Sunday
* MP8 due Thursday.  
* MP8 post-assessment due Friday
* MP9 assigned Friday (JSON)

Questions
---------

### Registration

### Trees/BSTs

### Heaps

### Administrative

### MP8

How would you set up the node classes in Bit Trees?

> Option one (preferred): A `BitTreeNode` interface and separate
  `BitTreeInteriorNode` and `BitTreeLeaf` classes that implement it.
  Here's a sketch

        interface BitTreeNode {
          public boolean isLeaf();
        } // interface BitTreeNode

        class BitTreeInteriorNode {
          BitTreeNode left;
          BitTreeNode right;

          public boolean isLeaf() {
            return false;
          } // isLeaf

        } // class BitTreeInteriorNode

        class BitTreeLeaf {
          String contents;

          public boolean isLeaf() {
            return true;
          } // isLeaf()

        } // class BitTreeLeaf

> Option two: Put the left, right, and contents fields in one class,
  and just skip them in the parts that aren't necessary.

### Other

Lab
---
