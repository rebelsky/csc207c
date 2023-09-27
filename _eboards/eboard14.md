---
title: "EBoard 14: List ADTs"
number: 14
section: eboards
held: 2023-09-25
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.

_Approximate overview_

* Administrivia
* Questions
* The design of ADTs, revisited
* Scheme lists
* Broader concepts of lists
* Java lists
* Implementing lists

Administrivia
-------------

### Introductory notes

* Today is a talk day rather than a lab day.
* If you have family members coming to family weekend and would like
  them to visit class, please let me know in advance.
* Changes coming to MPs.  (One fewer, new due dates.)

### Upcoming Token activities

Academic

* CS Table Tuesday
* CS Extras Thursday

Cultural

* Book talk Thursday W@G

Peer

* Football vs. Lawrence (US) Saturday at 1:00 pm
* Football vs. Ripon (elsewhere) Saturday at 1:30 pm

Wellness

Misc

### Upcoming work

* Readings for Wednesday
* MP4 is due a week from Thursday
* MP4 pre-assesment is due next Sunday.

Questions
---------

_You can ask questions about anything related to the class!  Self gov
says that you **should** ask those questions._

### Java

### Administrative stuff

What should I do for an MP redo?

> Fix the things the graders noted made it below an E.

> Add a `CHANGES.md` file that tells the graders what you changed.

Will we get MP2 and MP3 back before MP4 is due?

> I hope so.  It's my fault.

The design of ADTs, revisited
-----------------------------

* It's time for some PUMishment
* What does PUM stand for?
    * Philosphy
    * Use Cases
    * Methods
* Why do we use PUM?
    * The acronym makes it easy to remember.
    * Sam makes us do it.
    * It makes us think through what happens (or should happen) in
      the structure.

Scheme lists
------------

* These aren't quite an ADT, but we can try to pretend they are.
* Philosophy: Heterogeneous immutable collections of values that are
  indexed.  (I.e., we have an element 0, an element 1, an element 2, ...) 
  and are in a fixed linear order controlled by the "client".
* Use cases:
    * To teach people recursion (easy to recurse over)
    * To encourage us to use recursion for looping
    * To represent almost any structure (e.g., key/value pair)
      (e.g., a student record where the car is the given name and the
      cadr is the family name, and caddr is the social security number,
      and ...)
    * Lists of colors in DrRacket.
* Observations:
    * To do recursion, we must be able to decompse the list (with pattern
      matching or explicit procedures)
    * To use them to represent a set of values, we must be able to extract
      different elements.
* The most basic methods (or perhaps values):
    * `(car lst)` - get the first element in the list (some people
      call this `head`
    * `(cdr lst)` - get all but the first element in the list (some
      people call this `tail`
    * `(cons x xs)` - makes a new list by adding `x` to the front of `xs`.
    * `null` - the empty list
    * `(empty? lst)` - is the list empty
* Other central methods:
    * `(make-list n val)` - makes a list of `n` copies of `val`.
    * `list-ref`
    * `index-of`
    * `(length lst)` - determines how many values are in the list.
* Additional methods:
    * `(map fun lst)` - apply fun to each element of the list.

```
(define map
  (lambda (fun lst)
    (if (null? lst)
        null
        (cons (fun (car lst))
              (map fun (cdr lst))))))
```

Sam doesn't like to include too many operations because (a) it limits
our implementatoin and (b) we sometimes forget about the cost.

What is `LIA`.

* Layout: How do we arrange the structure in memory?  (Scheme lists are 
  implemented with cons cells.  Arrays are the other common implementation 
  technique.)
* Implementation:
    * `cons`: Build a new two-memory-cell element, each contains a
      reference, the first to the value the second to the rest.
    * `car`: Follow the first referece.
    * `cdr`: Follow the next reference.
    * `null`: Designated memory location (often 0).
    * `empty?`: Compare a memory location to null.
* Analysis: How efficient are these?
    * `cons`: Constant time
    * `car`: Constant time
    * `cdr`: Constant time
    * <>
    * `empty?`: Constant time
* Analysis, continued
    * `length`: Linear time, depends on the length of the list.

If we had laid this out as an array, `cons` would likely require us to
build a new array.

Broader concepts of lists (or at least 161 lists)
-------------------------------------------------

* Philosophy: Homogeneous mutable collections of values that are in
  a fixed linear order which is controlled by the "client".
* Use cases
    * Ticket tracking: Lists keep track of tickets; the list it's in
      indicates the status of a ticket.  (Sam would have added a field,
      but that's Sam.)
    * Any collection of data that has dynamic size.  (Adding in the
      middle of a list *can* be a quick operation (given the right
      methods.  Adding in the middle of an array is unlikely to be.)
    * Browser history.  Usually means adding at front or back.
      Deleting in the middle.
* Conceptual needs:
    * Adding elements at various locations ("client controlled")
    * Removing elements at various locations
    * Creating new ones
* Core methods, in Java notation.  (`interface OurList<T>`)
    * Constructor `OurList()` - creates an empty list
    * Adding values
        * `void add(int i, T val)` - Adds a value at a particular index
          [Obvious implementation iterates through the list]
             * if `i > length()`, throw an exception
             * if `i == length()`, add to the end of the list
        * `void addToFront(T val)` - Adds a value at the front of the list.
        * `void addToEnd(T val)` - Adds a value to the end of the list.
        * `void append(OurList other)` - add another list to the end of this
    * Removing values
        * `void removeAt(index i)` - remove the element at index i
          (some folks make thist return the removed value)
            * Throws an exception if i < 0 or i >= length.
            * Does this make the list shorter?  (Yes.)
        * `void remove(T val)` - remove a value from the list
            * What should we do if val appears multiple times in
              the list?
            * Typical answer: Removes the first, and we have
              a separate `removeAll` and perhaps even `removeLast`.
            * What if the value does not exist?
                * For `removeAll`, we're fine.
                * For `remove`, might consider throwing an exception
    * Other useful procedures
        * `int length()` - find the number of elements in the list
* Strange methods, in Java notation
    * `isFull()` - determines whether the list is full
    * Constructors `OutList(int n)` - create an empty list that holds
      up to `n` value

Side Note: Linked structures are a way to implement stacks and queues,
but they don't have to be "linked lists".

Worry: Many of these operations take an index, which suggests that they
are going to be slow in practice.  Are there other ways to think about
manipulating a list?

Somewhat bad mechanism: Have a sense of a current location/value in the list.

* `T current()` - Get the current element in the list.
* `void advance()` - Move to the next element in the list.
* `void remove()` - Remove the current element
* `void addBefore(T)` - add something before/after the current value

If we're using a well-designed linked structure, all of these are probably
constant time operations.

Why did Sam call this "somewhat bad"?  Sam read a paper called
"List with current considered harmful."

* Sometimes we need more than one "current" element (e.g., if we're
  sorting or rearranging it)
* An object-oriented way of thinking suggests that we should have a
  separate object that traverses the list.  If they are separate objects,
  we can have more than one of them.

Sam thinks of those separate objects as `Cursors`.

* Lists provide: constructor method, and a `getCursorAtFront()` method.
* Cursors provide `current`, `advance`, `addBefore`, `addAfter`,
  `replace`, `remove`.

Philosophy: "lists are homogeneous, mutable, linear collections that
provide cursors."

Java lists
----------

* I think Sun got it wrong.
* Programmers are dumb.
* So if you give them `removeAt(int i)` and `setAt(int i)`, they
  will use them without considering the cost.

Implementing lists
------------------

* Two basic implementations: Linked lists and array-based lists.
* How well they work depends on what methods you'd implement.
