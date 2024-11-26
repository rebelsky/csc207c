---
title: "Eboard 24 (Section 2): Hash tables, continued"
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

* Sit where you were last class.
* Please, please, please do the basics (e.g., filling in the README.md with
  the URL of your repo) on each mini-project. It increases the graders'
  workload (and delays grading) when you don't.

### Upcoming work

* Sunday, 2024-12-01
    * [Submit pre-reflection on MP10](https://www.gradescope.com/courses/818402/assignments/5380851)
* Monday, 2024-12-02
    * Reading/Skimming: [Priority Queues](../readings/priority-queues)
    * [Submit reading response for class 25](https://www.gradescope.com/courses/818402/assignments/5381101)
    * [Submit lab writeup from class 24](https://www.gradescope.com/courses/818402/assignments/5381099)
    * [SoLA 11](../los/sola11) (optional) due
        * New: Development #11: Ethical reuse
        * This SoLA is "optional" in that I won't send in AAs after it.
* Thursday, 2024-12-05
    * [MP 10](../mps/mp10) due.
    * [Submit MP10 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5380849)
    * [MP 11](../mps/mp11) released.
* Friday, 2024-12-06
    * [Submit post-reflection for MP10](https://www.gradescope.com/courses/818402/assignments/5380852)

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

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
* Try to choose meaningful variable names. `x` and `y` tell us very
  little, particularly when we're not dealing with coordinates.
* When describing a recursive algorithm, you don't have to trace it 
  down to the base case. Trust the magic recursion fairy.

### Insertion sort

It would be nice to see more of you decompose. Decomposed code is
much easier to read.

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
      T tmp = values[j];
      values[j] = values[j-1];
      values[j-1] = tmp;

      break;
    } // while
  } // for
```

On that note: `break` is ugly and should be used sparingly.

* Break is bad because it makes it much harder to analyze your loop for
  correctness. You may, for example, break out of the loop before we've
  restored the loop invariant.
* Break also makes it harder for your reader.
* For the particular example, you could write something like
  `while ((j >= 0) && (order.compare(a[j], value) >= 0))`
* If it's really really hard to write without a break, you can do so.

Your insert loop should also stop as soon as you find the right
place. Otherwise, you guarantee that it's O(n^2), even when the
array is already sorted.

Some of you wrote about "sorted half" and "unsorted half". I'd say that
"half" is a bad term. How about "portion"? (More generally, be careful
about the terms you use.)

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
You could say "Quicksort is expected O(nlogn)" or something like that,
but we could repeatedly choose bad pivots and make it an O(n^2) sorting
algorithm.

### Merge sort

Copying arrays and subarrays is slow. Try to do as little as possible.

Some of you computed the `midpoint` with `lb/2 + ub/2`. That doesn't
give the midpoint if both values are odd.

* E.g., if `lb` is 3 and `ub` is 3, 3/2 = 1, so we compute 2.
* E.g., if `lb` is 3 and `ub` is 5, 3/2 = 1, 5/2 = 2, so we compute 3
  (rather than 4).
* `(lb + ub) / 2` is more correct, but potentially dangerous if the
  `lb` and `ub` are qire large (overflow).
* Most of us use `lb + (ub - lb) / 2`.
* Some folks use `lb / 2 + ub / 2 + (lb % 2 + ub % 2) / 2`.

Notes on MP10
-------------

Updates coming soon (including tests).

Demo coming on Tuesday (sorry for the delay).

**Can we get rid of the hidden field thing in `mvn checkstyle:check`?**

> Yes.

Questions
---------

### Administrative

**SoLA 11 will open tonight, right? And it's optional?**

> Yes and yes.

**MP5?**

> Graders had as much trouble as you did. Hopefully soon.

### Miscellaneous

### Hash tables

Labs
---

Two labs today, one on chained hash tables and one on probed. Do them in
either order or do a bit of each. They use the same repository.

Make sure the repo ends in `-maven`.

### Observations/Comments

* Don't use `==` to compare keys. Use `.equals`.
* When writing `find`, the first place you should look is the hash of
  the key.
    * More precisely, the absolute value of the hash of the key mod the
      table size. (Which gives a valid index.)
* Make sure you check whether a KVPair is null _before_ you try to get its
  key or value.
* We set up the size of the table in the `clear` method.

### Questions

**For probed hash tables, are we really any better off using a probe
  offset of 17 than 1?**

> If we worry about clustering, using larger probe offsets helps us
  avoid collisions.
