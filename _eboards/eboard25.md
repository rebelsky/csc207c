---
title: "EBoard 25: Quicksort"
number: 25
section: eboards
held: 2023-10-27
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.
It's probably also being transcribed.

_Approximate overview_

* Administrivia
* Questions
* Lab

Administrivia
-------------

* Reminder; Document _before_ coding.
* Reminder: Write tests as early as possible.

### Upcoming Token activities

Academic

Cultural

Peer

* Swimming vs. Coe college, Friday at 6pm.
* Men's soccer vs. Lawrence, Saturday, 1:30pm
* Cross Country MWC Championships, Saturday, 11am

Wellness

Misc

### Other good things (no tokens)

* Women's soccer, Saturday, 11am

### Upcoming work

* Reading for Monday on the ACM code of professional ethics.
* MP6 due next Thursday.  

### Friday PSA

* You are awesome.  Take care of yourselves.

Questions
---------

### Registration

### Quicksort

### MP6

Lab
---

_Make sure that you have the correct version of the lab._

There is no starter code.  Sorry!

Sam wrote an incorrect Quicksort.  Sorry!

Sam ... how should we experiment with our `partition` method?

How about

```
    Integer[] vals = new Integer[] { 3, 9, 2, 8, 6, 4, 1, 7, 5 };
    Comparator<Integer> compareInts = (x,y) -> x.compareTo(y);
    Quicksort.partition(vals, compareInts, 0, vals.length);
    System.err.println(Arrays.toString(vals));
```
