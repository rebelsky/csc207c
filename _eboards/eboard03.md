---
title: "EBoard 03 (Section 1): Surprise"
number: 3
section: eboards
held: 2023-08-30
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.

_Getting started_ (this will be our normal start-of-class sequence)

* Grab a card.  The card will have a computer name and a location.
* Remember the name and location.
* Navigate to the computer.
* When both partners arrive, introduce yourselves.
* Remember to return cards at the end of class!

_Approximate overview_

* Administrivia
* About technical interviews
* ADTs and other TLAs
* Exercise

Administrivia
-------------

### Introductory notes

* Sorry that I did not get the VScode reading written.  See below for 
  excuses.
* Our class site is still under development.  Let me know if you find
  things missing, including images.
    * Those slash things on the syllabus usually indicate something
      that I plan to post.  If they show up for a reading, let me know.
* Normal office hours are in-person (unless you'd prefer to do them
  remotely).
* Apologies: I have some significant personal issues that may make me less
  available in person in the coming weeks.  I will do my best to be available 
  via email and Teams chat.
    * These issues have also put me behind.  Apologies for that, too.
* I've rearranged classes slightly and moved the Git/VSCode labs to Friday.
* You do not need to tell anyone but me (and your partner(s)) your GitHub
  account.
* GitHub will almost certainly scrape your code as training data.

### Upcoming Token activities

Academic

* Convocation, Thursday, 11:00 a.m.  President Harris.
* Guest speaker next week (probably in the Kernel of the HSSC)

Cultural

* Drag Bingo

Peer

Wellness

### MP01 released

* Encryption.
* Yes, you can talk to each other, but acknowledge.

### Upcoming work

* Readings for Friday.  (Do before class; nothing to turn in.  Ask
  questions on Teams.)
* HW 1 due a week from Thursday
* Pre-assignment due Sunday

### Administrative questions (e.g., about the syllabus)

When will the mentors survey us about mentor sessions?

> Soon.  We learned about timeliness from Sam and PM.

About technical interviews
--------------------------

The most common forms of technical interviews are unjust and inequitable.

* They assume that you have large amounts of time to prepare.
    * Prepare: Do lots of practice problems.
    * Prepare: Memorize key things.
    * Prepare: Develop the skills they are looking for.
* Hidden expectation
* There's no good evidence that the traditional technical interview
  actually identifies the best candidates for the position.

In this class, we're going to practice because

* You may get stuck doing tech interviews
* Tech interviews exercise the same skills I want you to develop in
  this class.

As an interviewee, there are normally three parts to each tech interview

* Understand the problem (restate the problem, ask questions, write
  test cases)
* Develop a set of possible solutions
* Write code (+ tests + ...)

ADTs and implementations, revised
---------------------------------

Reminder of TLAs:

* ADT: Abstract Data Type (a way of thinking about organizing data)
* PUM: Philosophy, Uses, Methods (what we design for ADTs)
* LIA: Layout, Implementation, Analysis (data structures, implementations of ADTs)
* TPS: Think, pair, share
* TLA: Three-letter acronym

Sample philosophies
-------------------

Queue: A collection of values that you visit one-by-one that follow the first-in, first-out principle.

Stack: A collection of values that you visit one-by-one that follow the last-in, first-our principle.

Map/Hash: A collection of values indexed by strings.

Priority Queue: A collection of values that you visit one-by-one that follow the "most important out" principle.

Set: A collection of values which exists primarily to check membership.

Tree: A hierachical collection of values.

Today's design problem: Arbitrary size (expandable) "arrays"
------------------------------------------------------------

### Part one: The PUM (TPS)

#### Philosophy

An automatically expandable collection of data indexed by numbers,
usually from 0 to the size.

Note: At least for this example, we're willing to sacrifice constant-time
access in order to get expandability.

#### Uses

* The normal implementation is fast, so we use them whenever we want
  fast access.
* We can loop through values by position.
* You might use it for a hierarchy.
* Knowing the position of data may be useful for ...
* At many companies, people get sequential numeric userids ; an array
  provides quick access to a person by userid.
* We might want to think about ranges of elements (e.g., if person x's
  id is less than person y's ...)
* Implementing vectors for physics.

#### Methods

* `void arr.set(int index, Value v)` - set or change a value
* `Value arr.get(int index)`
* `int arr.length()`
* `Array makeArray(Value default)` or
  `Array makeArray(Type t)` or
  `Array makeArray()`.

#### Potentially useful, but not central methods

* `arr.remove(int index)` - remove a value and then shift everything down
  one.  (SamR says no; can be implemented with simpler operations)
* `int indexOf(Value v)` = `for (int i = 0; i < arr.length(); i++) { if arr.get(i) == v) return i; }`
* `map`
* `void addToEnd(Value v)` = `arr.set(arr.length()+1, v)`
* `boolean isEmpty()` = `arr.length() == 0`

#### Unsure

* `boolean hasRoom()`
* Compare two arrays.
* Is "setSize()" useful (for expanding, for shrinking)?
* `pop` : Remove the last element and decrease the size by one.
  (Not relevant to the core goal of "collection indexed by number")
* `void remove(int index)` - remove the value at the given index
  without shifting.  Requires we change `get` to signal empty cells.

#### Design questions

* If we haven't set a value at a particular location, what result
  do we get when we call `get`?  (We'll set a default value.)
* What happens if there's no enough memory to set something?
  (Crash and burn!)

### Detour: Style

Should you use `return` and `break` in the middle of loops?

> No: It makes analysis much harder.

> Yes: 99% of programmers do so.

```
for (int i = 0; i < arr.length; i++) {
  if predicate(arr.get(i)) {
    return i;
  }
} // for
// Signal failure
```

This is fast, but the early break from the loop can be hard to analyze.
(You'll learn a bit about loop invariants here and in 301.)

```
int result = -1;
for (int i = 0; i < arr.length; i++) {
  if predicate(arr.get(i)) {
    result = i;
  }
} // for
if (result == -1)
  // signal failure
else
  return result;
```

This one is easier to analyze, but potentially much slower.

```
int result = -1;
for (int i = 0; i < arr.length && result == -1; i++) {
  if predicate(arr.get(i)) {
    result = i;
  }
} // for
```

The last one is fast and analyzable, but hard to read.

### Part two: Possible ways to implement (TPS)

How do we structure memory so that we have set(i,v), get(i), length(),
and create(val).

* Continuous chunk of memory (fixed-size arrays)
* Linked lists (or some variant thereof)
* Linked list of continuous chunks of memory
* Binary tree (with integer indices as keys); (more generally, any 
  implementation of dictionaries using integer indices as keys)

### Part three: Implementation one (interview)

Suppose you've decided to implement arbitrary size arrays using
the built-in (fixed-size) arrays.  How do you now implement the
four key operations?

* `Value get(int i)`
* `set(int i, Value v)`
* `size()`
* `create(Value initial)`

---

Hmmm ... since I'm using the fixed-size arrays, I'll need a variable
to keep track of that array.  I'll call it `arr`.

What is the size after we initialize?  _Assume the default size is 0._

Okay, that means that I'll likely have two different sizes at play, the
"size" that the client sees and the "size" of the underlying array.
Let's call the first one `size` and the second one `capacity`.

Can I assume that the built-in arrays have their own `size` function?
_Yes, you're working in Java._

Awesome.  So I don't need `capacity`.  That's just the size of the
underlying array.

At some point, I'll need to allocate more space because someone will
index beyond the end of the array.  Do you have a preferred policy for
how large the new array should be?  _What do you think you should do?_

Hmmm.  One option is to just enlarge to just big enough to support the
new element.  That's easy.  But I seem to recall learning in data structures 
that when I expand an array, I should double the size of the array.  I
don't remember why, though.  I'll figure 
