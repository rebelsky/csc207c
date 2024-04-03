---
title: "Eboard 26: Array-Based Lists"
number: 26
section: eboards
held: 2024-04-03
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

**Please set with your MP7 partner.**

_Approximate overview_

* Administrivia 
* Questions
* What is a list, revisited?
* Iterators (and questions on iterators)
* Lab

Preliminaries
-------------

* Remember that post-break masking is a good idea.
* Sorry for the repeated rearrangements to the schedule.

### Upcoming work

_Schedule needs updating. Stay tuned._

* Thursday, MP6: Sorting
* Thursday, Readings on linked lists (and such)
* Friday, MP7 pre-assessment (forthcoming)
    
### Tokens

Academic/Scholarly

* Thursday, 2024-04-04, 11:00am, JRC 101.
  _Scholars' Convocation: Motherblame-stigma, Epistemic Injustice, and the Government’s Failure to Care_ (w Tammy Nyden in Philosophy).
* Thursday, 2024-04-04, 8pm, JRC 101.
  _Book talk: Austin Frerick '12 on Barons: Money, Power, and the Corruption of America’s Food Industry_
* Tuesday, 2024-04-09, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-04-09, 7:00pm, Science 3819.
  _Mentor Session_.

Cultural

* Thursday, 2024-04-04, 4pm, Grinnell College Museum of Art.
  _Writers@Grinnell presents Sam Naikhara '19_.
* Friday, 2024-04-05, 4pm, Global Living Room in HSSC.
  _Middle of Everywhere._

Peer

Wellness

* Tuesday, 2024-04-09, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-04-09, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-04-09, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

* Wednesday, 2024-04-03, 11:45am, JCC Lower-Level Conf. Room.
  _CLS Lunch and Learn with Sam Naikhara '19_.
* Wednesday, 2024-04-03, 4pm, 3821.
  _CS Extras: Study abroad at AIT Budapest_.

### Other good things to do (no tokens)

Questions
---------

### Administrative

### Sorting (in general)

### Quicksort

### MP6

### Other

What is a list, revisited?
--------------------------

Fun with iterators
------------------

Skim through the documentation for "[`java.util.Iterator`]({{
site.java_api }}/java/util/Iterator.html)" and "[`java.util.ListIterator`]({{
site.java_api }}/java/util/ListIterator.html)".  You should identify
the primary methods, their meanings, and any other subtleties.
Make sure that you can answer the following questions.

a. Where, conceptually, is a list iterator relative to the elements of
a list?

b. What element does `remove` remove?

c. Suppose we have a list iterator, `lit`, and call `lit.add(x)`
and then immediately after call `lit.add(y)`.  In what order should
`x` and `y` appear in the list?

d. Suppose we have a list iterator, `lit`, between the b and c in
the list [a,b,c] and that it reached the current position through
a call to `next`.  
Suppose we then call `lit.remove()` and then
immediately after call `lit.remove()` again.  What can or should
happen?

e. Suppose we have a list iterator, `lit`, between the b and c in
the list [a,b,c] and that it reached the current position through
a call to `next`.  What should happen if we call `lit.set(x)` and then
`set(y)`?

f. Suppose we have a list iterator, `lit`, between the b and c in
the list [a,b,c] and that it reached the current position through
a call to `next`.  What should happen if we call `lit.set(x)` and then
`lit.remove()`?

g. Suppose we have a list iterator, `lit`, between the b and c in
the list [a,b,c] and that it reached the current position through
a call to `next`.  What should happen if we call `lit.remove()` and then
`lit.set(y)`?

h. Can we add an element immediately after creating a new list
iterator?

i. Can we remove an element immediately after creating a new list
iterator?

j. Can we set an element immediately after creating a new list iterator?

k. Can we add an element when `hasNext` is false?  If so, where is
the element added?  If not, why not?

l. Can we set an element when `hasNext` is false?  If so, which element
is set?

m. Can we remove an element when `hasNext` is false?  Never?  Sometimes?
Always?

n. Suppose we've created two list iterators, `lit1` and `lit2` for
the list [a,b,c], and both are between the a and the b in the list.
If we call `lit1.add(d)`, what should `lit2.next()` return?

o. Suppose we've created two list iterators, `lit1` and `lit2` for
the list [a,b,c], and both are between the a and the b in the list.
If we call `lit1.remove()`, what should `lit2.next()` return?

p. Are there any other subtleties that you noticed about these
two kinds of iterators?

Lab
---

_See the schedule._
