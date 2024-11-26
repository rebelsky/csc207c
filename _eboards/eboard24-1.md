---
title: "Eboard 24 (Section 1): Hash tables, continued"
number: 24
section: eboards
held: 2024-11-26
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* Some SoLA Stuff
* Questions
* Labs

Preliminaries
-------------

### News / Notes / Etc.

* Please, please, please do the basics (e.g., filling in the README.md with
  the URL of your repo) on each mini-project. It increases the graders'
  workload (and delays grading) when you don't.

### Upcoming work

* Wednesday, 2024-11-27
    * Lab writeup from class 24.
* Sunday, 2024-12-01
    * Pre-reflection on MP10 due.
* Monday, 2024-12-02
    * Reading: [Priority Queues](..//readings/priority-queues)
    * Reading response for class 25.
    * SoLA 11 (optional) due
        * New: Development #11: Ethical reuse
        * This SoLA is "optional" in that I won't send in AAs after it.
* Thursday, 2024-12-05
    * MP 10 due.
    * MP 11 released.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-11-26, noon--1:00 p.m., Day PDR.
  _CS Table: ??? _
* Sunday, 2024-12-01, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_
* Tuesday, 2024-12-03, noon--1:00 p.m., Day PDR.
  _CS Table: ???_

#### Cultural

#### Multicultural

* Friday, 2024-12-06, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: ???_ 

#### Peer

#### Wellness

* Tuesday, 2024-11-26, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-12-03, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.

#### Misc

* Fill in the peer-educator evaluation form (see email).

### Other good things (no tokens)

SoLA Stuff
----------

* I'm going to keep saying this until I see more of it: Real programmers
  use "lower-bound inclusive, upper-bound exclusive." You see it in
  `String.substring(lb, ub)`. You see it in `Random.nextInt(lb, ub)`.
* Decompose, decompose, decompose.
    * It makes your code easier to read.
    * It makes your code easier to debug.
    * It makes your code more reusable.
* Try to choose meaningful variable names. `x` and `y` tell usvery
  little, particularly when we're not dealing with coordinates.
* When describing a recursive algorithm, you don't have to trace it 
  down to the base case. Trust the magic recursion fairy.

### Insertion sort

It would be nice to see more of you decompose. Decomposed code is
much easier to read

```java
  for (int i = 1; i < values.length; i++) {
    insert(values, i);
  } // java
```

vs.

```java
  for (int i = 1; i < values.length; i++) {
    int j = i - 1;
    while (j >= 0) {
      ...
      break;
    } // while
  } // for
```

On that note: `break` is ugly and should be used sparingly.

Your insert loop should also stop as soon as you find the right
place. Otherwise, you guarantee that it's O(n^2), even when the
array is already sorted.

Some of you wrote about "sorted half" and "unsorted half". I'd say that
"half" is a bad term. How about "portion"?

### Selection sort

It would be nice to see more of you decompose. An `indexOfSmallest`
procedure would clarify code.

```java
for (int i = 0; i < vals.length; i++) {
  swap(vals, i, indexOfSmallest(vals, i));
} // for
```

### Quicksort

For some reason I don't quite understand, some of you did the recursion
within your partition/DNF procedure. But we want to separate 
partitioning/DNFing from the recursive sorting. Why? It turns out we can
use partition/DNF for other tasks, too.

Quicksort (even the partition-based Quicksort) relies on us splitting
the array into three parts, one of which is the pivot (or the pivot plus
equal values). Why? Because we need to ensure that we recurse on smaller
arrays.

Please don't say "Quicksort is an O(nlogn) sorting algorithm." It's not.
You could say "Quicksort is expected O(nlogn)" or soemthing like that,
but we could repeatedly choose bad pivots and make it an O(n^2) sorting
algorithm.

### Merge sort

Copying arrays and subarrays is slow. Try to do as little as possible.

Some of you computed the `midpoint` with `lb/2 + ub/2`. That doesn't
give the midpoint if both values are odd.

Notes on MP10
-------------

Updates coming soon (including tests).

Demo coming on Tuesday (sorry for the delay).

Questions
---------

### Administrative

### MP10

### Miscellaneous

### Hash tables

Labs
---

Make sure the repo ends in `-maven`.
