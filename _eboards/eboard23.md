---
title: "EBoard 23: Sorting"
number: 23
section: eboards
held: 2023-10-23
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.
It's probably also being transcribed.

_Approximate overview_

* Administrivia
* Questions
* The problem of sorting
* Testing sorting algorithms
* Insertion sort
* Selection sort

Administrivia
-------------

* Welcome back!  I hope you had wonderful breaks and that you are not broken.
* Yay!  Class 23 is on the 23rd.  I'm not sure what that signifies, but I'm
  somehow pleased.
* Registration starts somewhat soon.  Consider going on to CSC-161.
    * Check the priority registration page at <https://grinco.sharepoint.com/sites/Registrars_Office/SitePages/PriorityRegistration.aspx> for our latest registration processes.

### Upcoming Token activities

Academic

* CS Table, Tuesday, The Open Web
    * Tim Berners-Lee. Information Management: A Proposal. CERN. March 1989, updated May 1990. <https://www.w3.org/History/1989/proposal.html>
    * Hossein Derakhshan. The Web We Have to Save. Matter. July 14, 2015. <https://medium.com/matter/the-web-we-have-to-save-2eb1fe15a426> (login required)
    * Copies available outside 3827 and 3809.
* CS Extras, Thursday, ???

Cultural

Peer

* Men's soccer vs. Monmouth, Wednesday, 4pm
* Men's soccer vs. Lawrence, Saturday, 1:30pm
* Cross Country MWC Championships, Saturday, 11am

Wellness

Misc

### Other good things (no tokens)

* Women's soccer, Tuesday, 4pm
* Women's soccer, Saturday, 11am

### Upcoming work

* Readings for Wednesday on sorting.
* MP6 to be assigned on Wednesday.  "Implement the best damn sorting
  algorithm that you can.  Read TimSort for details."

Questions
---------

The problem of sorting
----------------------

### Basics

_What does it mean to sort?_

### Validation, conceptual

_How do you now if you've succeeded? (in English)_

### Validation, problematic

_How do you now if you've succeeded? (in English)_

### Design

_What approaches do we have to design sorting algorithms?_

### Issues

_What restrictions might we put on a sorting algorithm?_

Testing sorting algorithms
--------------------------

_What kinds of tests can you run to ensure that your sorting algorithm works correctly?_

Insertion sort
--------------

Selection sort
--------------

Detour: The Dutch National Flag problem
---------------------------------------

You have an array with three values, which we’ll call red, white,
and blue. They are in no particular order. Your goal is to rearrange
it so that all of the red are at the left, all the blue are at the
right, and all the white are in between.  

_You may not simply count the values; different reds represent different
objects (similarly for blues and whites)._

Sample input:

```
+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
| Ba | Rb | Wc | Wd | Re | Bf | Wg | Rh | Wi | Wj | Wk | Rl | Wm | Bn | Bo | Wp | Rq |
+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
```

### Design

How do you approach the problem?
