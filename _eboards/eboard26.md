---
title: "Eboard 26: Array-Based Lists"
number: 26
section: eboards
held: 2024-04-03
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

**Please sit with your MP7 partner.**

_Approximate overview_

* Administrivia 
* Questions
* What is a list, revisited?
* Iterators (and questions on iterators)
* Lab

Preliminaries
-------------

* How was Monday's substitute instructor?
* Remember that post-break masking is a good idea.
* Sorry for the repeated rearrangements to the schedule.

### Upcoming work

_Schedule needs updating. Stay tuned._

* Thursday, MP6: Sorting
* Thursday, Readings on linked lists (and such)
* Friday, MP7 pre-assessment (forthcoming)

### About MP7

Implement a simplified version of BlockChains.

For yourself: Consider extending it.

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
* Saturday, 2024-04-06, 1--4pm, Cleveland Beach (in front of Cleveland
  residence hall on South Campus). 
  _Holi_.
  Beware, your clothes will get stained. Wear white clothes so that you
  enjoy the permanent colorfulness.

Peer

Wellness

* Tuesday, 2024-04-09, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-04-09, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-04-09, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

* Wednesday, 2024-04-03, 4pm, 3821.
  _CS Extras: Study abroad at AIT Budapest_.

### Other good things to do (no tokens)

Questions
---------

### Registration

Do you fully understand our new registration system?

> Nope. Not even after talking to the Registrar.

### Administrative

Is it okay if I miss class on Monday to chase the eclipse?

> Sure. Just let me know in advance.

Is it okay if I miss class a week from Monday to celebrate Eid in Chicago?

> Sure. Just let me know in advance.

### Sorting (in general)

Do we have to write a generalized comparator? 

> No. You will not need to create one for your algorithm. But your algorithm 
  should work with any (reasonable) comparator it is given.

> "reasonable" means things like "consistent", "transitive", etc.

### Quicksort

### MP6

### Other

What is a list, revisited?
--------------------------

Let's try the "PUM perspective"

* A collection of elements in which you can access elements sequentially
* We access elements one at a time.
* Vs. array: Numerically indexed collection of elements (it just so happens 
  you can naturally access numerically indexed collections sequentially).
* Vs. stacks (LIFO or FILO) and queues (FIFO) and priority queues:
  We tend to think of lists as more general than these.
    * Arguably, stacks and queues only let you access one element, with
      the others "hidden" (except when you have an iterator)
    * In stacks and queues, the client does not choose the order of the
      elements, the policy does. In lists, the client controls the order
      of the elements.

Sam's simplified version (for the next two classes)

* Philosophy: A list is something you can iterate.
* Methods:
    * Construct an empty list.
    * `ListIterator<T> listIterator()`

Whoops! How do we add elements?

* The iterator (list iterator) provides operations that let us add and
  remove elements.

Fun with iterators
------------------

Skim through the documentation for "[`java.util.Iterator`]({{
site.java_api }}/java/util/Iterator.html)" and "[`java.util.ListIterator`]({{
site.java_api }}/java/util/ListIterator.html)".  You should identify
the primary methods, their meanings, and any other subtleties.
Make sure that you can answer the following questions.

a. Where, conceptually, is a list iterator relative to the elements of
a list?

> In between elements. (most of the time)

> Before the first when it is first created.

> After the last when there's nothing left.

b. What element does `remove` remove?

> The last element returned by `next` or `previous` (the most recent
  of those two function calls).

b2. Suppose my iterator is between b and c in [a,b,c]. What does
`remove()` remove?

> `b`, provided the most recent call was `lit.next()`.

> `c`, provided the most recent call was `lit.prev()` (e.g., if we
  were after the c and called `lit.prev()`.

> If we had originally been between `a` and `c` and then called `add(b)`,
  the call to `remove` should throw an error. [Note: We need to pay attention
  to "invalid" situations.]

> If had just removed something else (since the latest `prev`/`next`),
  we'd also get an error.

> Perhaps if we had not yet called `next` or `previous` (assuming we can
  magically create another iterator in the middle of a list). [Fortunately,
  that doesn't seem to be possible.]

> If we did not implement `remove`, it should throw an exception.

> If we implemented a `remove` that only works after `next`, it could
  throw an exception.

> If another iterator has changed the list since the last call to
  `next` or `previous`, it might (should) throw an exception.
  <https://docs.oracle.com/javase/8/docs/api/java/util/ConcurrentModificationException.html>

b3. What exception should `remove` throw if the list is empty? 

> It depends on how the list ended up empty. If we just removed an element,
  it's probably `IllegalStateException`. In fact, that seems to be the only
  exception it can really throw (other than "I did not implement this").

> In practice, some of us have seen it throw a `NoSuchElementException`.

c. Suppose we have a list iterator, `lit`, and call `lit.add(x)`
and then immediately after call `lit.add(y)`.  In what order should
`x` and `y` appear in the list?

> `x` will appear before `y` because elements are added immediately
  before the cursor.

d. Suppose we have a list iterator, `lit`, between the b and c in
the list [a,b,c] and that it reached the current position through
a call to `next`.  

Suppose we then call `lit.remove()` and then
immediately after call `lit.remove()` again.  What can or should
happen?

> An exception.

e. Suppose we have a list iterator, `lit`, between the b and c in
the list [a,b,c] and that it reached the current position through
a call to `next`.  What should happen if we call `lit.set(x)` and then
`set(y)`?

> The first time, it should replace `b` with `x`.

> The second time, we're not sure. Some of us think it should replace
  `x` with `y`. Some of us think it should be an error. [Good documentation
  is hard to write.]

> Experimentally, we managed to replace the b with x and then the x with y.

f. Suppose we have a list iterator, `lit`, between the b and c in
the list [a,b,c] and that it reached the current position through
a call to `next`.  What should happen if we call `lit.set(x)` and then
`lit.remove()`?

> We lose the x.

f2. Suppose we have a list iterator, `lit`, between the b and c in
the list [a,b,c] and that it reached the current position through
a call to `next`.  What should happen if we call `lit.set(x)` and then
`lit.add(y)`?

> We add the y after x.

detour. Why am I asking you all these questions?

> Early questions: Help us think about differences between data structures.

> Helps us reflect on the data structure a bit more carefully.

> We need to understand list iterators to make sure that we can use them
  for our mini-project or implement them ourselves.

> To remind you that most "simple" things still have a lot of subtleties
  to consider (design is hard).

detour. There some operations that seem to depend on our most recent
operations and some that are independent and depend only on the position
of the iterator. Which fall into which category?

> Depend on recent operations (and fail in some circumstances): `remove`
  (won't work after a call to `remove` or `add`), `set` (won't work after
  a call to `remove` or `add`)

> Depend on recent operations (and behave differently but generally don't
  fail): 

> Independent of recent operations: `hasNext`, `hasPrevious`, `next`,
  `previous`, `add`,`forEachRemaining`, `previousIndex`, `nextIndex`

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
