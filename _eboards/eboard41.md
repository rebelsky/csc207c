---
title: "Eboard 41: MSTs"
number: 41
section: eboards
held: 2024-05-08
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Detour: LAs
* Questions
* Lab

Preliminaries
-------------

* You should have received an announcement about grading last night. In
  short.
    * Please do not spend time on MP redos. MPs will not negatively
      affect your grade.
    * Your grade will depend primarily on the number of LAs you get
      correct.
    * Everyone passes.
    * You can debate your grade with me.
* I will be working from home tomorrow afternoon, so office hours will be
  online.
* Please plan to show up for class on Friday! I'll make sure to reserve
  time at the start of Friday's class for LA questions.
    * If you will not be in class on Friday, I have a task for you to
      complete today.
* Friday will be LA questions + some debriefing + community task + 
  EOCEs. I'll make the EOCEs available after Friday's class for those
  of you who can't make it.

### Upcoming work

* Saturday, 2024-05-11, 11:00pm, New set of LAs, repeated + old LAs
* Tuesday, 2024-05-14, 11:00pm, LA redos
* Friday, 2024-05-17, 5:00pm, LA redos (final chance)

### Tokens

Academic

* Thursday, 2024-05-09, 4:00--5:00pm, Science 3819.  
  _CS Extras: Sarah Barks_

Cultural

* Most days, 2024-04-xx and 2024-05-xx, 11am-6pm,
  Grinnell College Museum of Art.
  _BAX 2024_. 

Multicultural

* Friday, 2024-05-10, 4:00--5:00pm, HSSC N1170.
  _Middle of Everywhere_ 

Peer

Wellness

* Friday, 2024-05-10, 5:00pm--??:??pm, Merrill Park West.
  _CS Picnic!_ 

Misc

### Other good things to do (no tokens)

### Other questionable things (no tokens)

LA Notes
--------

### Coding style

* **Decompose!** You learned decomposition in CSC-151. You should continue
  to decompose in all your coding. For example, insertion sort should 
  have an explicit `insert` method.
* **Don't repeat yourself!** I'm stunned at how many of you repeated the
  code for swapping again and again and again.
* **Document!** You methods should have documentation that explains what
  they are supposed to do and what they return. How else will your client
  know what your code is doing/returning? Also: Document any tricky bits
  within your code.
* **Use meaningful names!** There's rarely a good reason to use one-letter
  variable names.
* **Follow language standards.** For example, field names, variable names,
  parameter names, and method names in Java should all start with a lowercase
  letter (or, once in a while, with an underscore). Class names, interface
  names, and type variables start with a capital letter.

### Discussing recursion

I saw way too many narratives that included descriptions like this:

> The array to be sorted is divided into two halves recursively until each 
  subarray has only one element.

In discussing recursion, focus on what the recursive call is. The reader
should understand that the typical base case is one or two elements. For
most of the "divide and conquer" sorting algorithms, dividing until you
reach one element isn't the key idea. It's that you recursively sort the
two halves.

_Trust the magic recursion fairy!_

### Particular LAs

#### Divide and conquer

* **Decomposition** is the idea of breaking a complex problem into
  smaller parts.
* **Divide and conquer** is an algorithm design strategy related
  to decomposition, but that involves breaking the *input* into
  smaller parts.

#### Loop invariants

* Loop invariants tell us something about the state of the system.
  (Usually something relatively formal.)
    * We show that they hold before the loop begins.
    * We assume they hold at the start of each loop iteration.
    * We show that they hold at the end of each loop iteration.
* Loop invariants are *not* the loop termination condition.
* Ideally, knowing that the invariant still holds and that the loop has
  terminated tells us that we've achieved the desired result.

#### IDE

* "I used Intellisense regularly."  Um ...

Questions
---------

### Administrative

### LAs

### Misc

Minimum Spanning Tree
---------------------

_TPS_

### What is an MST?

### What is Kruskal's algorithm?

### What is Prim's algorithm?

### How are they similar? How are they different?

Labs
----
