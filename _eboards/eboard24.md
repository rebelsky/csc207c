---
title: "EBoard 24: Merge sort"
number: 24
section: eboards
held: 2023-10-25
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.
It's probably also being transcribed.

_Approximate overview_

* Administrivia
* About MP6
* Questions
* Remaining topics from last class
* Lab

Administrivia
-------------

* Your classmate brought creme brulee (I'm too lazy to type accents)
* Registration starts next Wednesday.  I hope that you consider going on.
    * Check the priority registration page at <https://grinco.sharepoint.com/sites/Registrars_Office/SitePages/PriorityRegistration.aspx> for our latest registration processes.  They have changed since Monday.
    * Check out the the priority rules for each class at <https://grinco.sharepoint.com/:x:/s/Registrars_Office/EQfHJD0_kHlMgqJDvkATg18B8k6Sc5C_SOtUiQ51Ig2LZg?e=HQS7zq>.  CSC's were not yet up-to-date when I last checked.
    * Our chair says that we are adding another section of CSC-301.
    * I have confirmed that we are not prioritizing undeclared second-year students over declared second-year students (or vice versa).
* There are signs around campus for an event at 10:30 a.m. on Wednesday, October 23rd.  Since today is October 25, I assume the event is Wednesday, October 23rd, 2024.

### Upcoming Token activities

Academic

* Scholars' Convocation, Thursday, 11am, HSSC Auditorium (A2231): April Baker-B
ell on _Linguistic Justice: Black Language, Literacy, Identity, and Pedagogy_.
* CS Extras, Thursday, ???

Cultural

Peer

* Men's soccer vs. Monmouth, Wednesday (Today), 4pm
* Swimming vs. Coe college, Friday at 6pm.
* Men's soccer vs. Lawrence, Saturday, 1:30pm
* Cross Country MWC Championships, Saturday, 11am
* I'm still waiting to hear about concerts, plays, and such.

Wellness

Misc

### Other good things (no tokens)

* Women's soccer, Saturday, 11am

### Upcoming work

* Readings for Friday on sorting.
* MP6 due next Thursday.  

Mini-project 6
--------------

Write lots of sorting methods.

You can use ChatGPT, but only for LastFirstSort.

Pre and post will be posted soon.

Questions
---------

### Registration

Designing algorithms
--------------------

Remember that question?  Where do you get started when you have to design 
a new algorithm.

Sam's two initial suggestions:

* "Do it by hand."
* "Look for similar problems and their solutions."

_TPS_: What other techniques do you use?

* Throw out random ideas.
* Bribe a friend with creme brulee to get help.
* Think about how to simplify it
* Think about how to model it in real life
* Review my notes and hope that there's something there
* Review the textbook and hope that there's something there
* UM (it's like PUM, but different).  "Use math."  Convert it into a proof.
* Decompose it into smaller problems.
* Ask ChatGPT for ideas.

What do you do when you have very few ideas?

* Use one of a few standard approachs.
    * Greed.  Try doing something obvious that looks like the best first
      step.
    * Divide and conquer.  Suppose I divide my data in half (how?) and
      then recurse on both halves.  Does that help?
    * Dynamic programming (not in this class): Design a recursive solution
      that may not be efficient and optimize it.
    * Exhaustive search: Build all possible "solutions" and pick the best/correct
      one.
* Take math classes, which help you build intuition (at least about graphs)

Lab
---

Today's algorithm is a divide-and-conquer approach to sorting.

* Split the array in half (conceptually)
* Sort each half.
* Merge together.

Let's implement ... 

Making a new array: (Sam searches for "Arrays Java 17")

```
static <T> T[] java.util.Arrays.copyOfRange(T[] original, int from, int to)
```

Invariants

```
Original Array: A

          |    sorted         |     sorted        |
+---   ---+---------+---------+---------+---------+---   ---+
|  . . .  | done/L  |         | done/R  |         |  . . .  |
+---   ---+---------+---------+---------+---------+---   ---+
|         |         |         |         |         |         |
0         lo        l         mid       r         hi        length

Merging into ...

| Permutation |
| of done/L   |
| plus done/R |
+-------------+-------------------------+
|   sorted    |        ????             |
+-------------+-------------------------+
|  <= A[l]    |                         |
|  <= A[r]    |                         |
|             |                         |
0             i                         (hi-lo)
```

