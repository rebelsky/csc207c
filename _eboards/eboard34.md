---
title: "EBoard 34: Hash tables, continued"
number: 34
section: eboards
held: 2023-11-17
link: true
---
# {{ page.title }}

**Warning** This class is being recorded (and transcribed) (assuming Teams succeeds).

_Approximate overview_

* Administrivia
* Questions
* About MP9
* About hash tables
* Lab

Administrivia
-------------

* Please return cards, boards, and markers to the back of the room
  when you finish class today.
* Sorry for missing on Wednesday.
* Happy Friday!
* Technology hates me today.

### Upcoming Token activities

Academic

* Tuesday, 2023-11-21, Noon, Day PDR, _CS Table_.

Cultural

Peer

* Language study!  Talk to your colleague.
* Swim meet, Saturday at 1pm (we think).
* Tuesday, 2023-11-21, 4-6pm, 3rd floor HSSC, somewhere: _Wilson Catalyst_

Wellness

* We need more of these!

Misc

* Subject yourself to a study of types.
* Please fill in the peer educator evaluations

### Other good things (no tokens)

### Upcoming work

* MP9 assigned today (JSON)
* MP9 pre-assessment due Sunday

### Friday PSA

* Please be moderate
* Consent is essential

Questions
---------

### Hash tables

### Administrative

Are you ever going to talk to the graders?

> Yes.  Monday, I hope.

Is MP9 our last mini-project?

> Yes.

When is it due?

> Thursday, November 30

Can we have more time for redos?

> Sure.

Why is the Sample LA there?

> As a reminder to Sam to Please LAs expunge

Are you going to charge for late redos?

> No.

Can I use tokens to turn in pre- and post-assessments really late?

> No.  The point of these is to reflect at the time you do the assignment.

### MP9

Goal: Parse JSON into an appropriate Java structure.

Input `{ "a": "apple", "e": [2,7,1,8], "q": { "x" : "xerox } }`

Output: JSONHash with three KVPairs.

* The first KVPair has a key of the JSONString "a" and a value of the
  JSONString "apple".
* The second KVPair has a key of the JSONString "e" and a value
  of a JSONArray of length four
    * Element 0 of the JSONArray is the integer 2
    * Element 1 of the JSONArray is the integer 7
    * ...
* The third KVPair has a key of "q" and a value of another JSONHash

_We looked at the provided code together.  Whee!_

Hash table review
-----------------

_TPS: Five key ideas._

_Cool.  The screen stopped flickering.  Have I mentioned that I hate
computers?  Of course, now my laptop is running out of power, so the
recording will stop soon._

* A hash table is something that pairs keys and values.  We generally call
  such things "Dictionaries" or "Maps".  Hash tables are a particular
  implementatoin of Dictionaries/Maps.  In fact, they are popular enough
  that some people call Dictionaries/Maps "Hashes".
* Hash tables use arrays to implement dictionaries/maps.
     * Array access is fast.  We'd like to use array access when keys
       are not necessarily numeric.
     * We do so by converting the key to an integer (called hashing)
       in a consistent, reliable, fast way so that (a) we always get
       the same hash code for equal values, and (b) we are likely to
       get different hash codes for different values.
     * We look in the cell based on the hash code (mod table size)
* We can use the arrays to build hash tables in two ways:
     * Chained/bucketed hash tables put a list of values in each cell.
       If you have a different key that maps to the same cell as an
       existing key, you add to the list.
     * Probed hash tables may require you to look elsewhere in the
       hash table.  If you have a key that maps to an already
       filled cell with a different key, you look elsewhere in the table.
* Side note: Badly designed hash functions tend to group things in
  clumps.  For example, "sum the ASCII values" will group length-five
  strings around 5*109 (the ASCII value for "m", the middle letter).
* UM: Hash tables use math (in computing good hash values).
* Hash tables are "better" than binary search trees.
     * Arrays are fast.
     * Our hash function tends to distribute things well, but we'll
       still have collisions.
     * Are there things we can say about the expected number of collisions?
     * In a well-designed hash table, about half of the cells are empty.
       On average, we should find an empty cell fairly quickly when probing.
       [Statistics!]
     * We have to grow the hash table to maintain that property.
* As you will eventually learn, things that are nearby in memory perform
  better in real life, so hash tables (and all array-based structures)
  generally perform better than linked structures.
* Hashing is so important that Java expects each object to provide a
  well-designed `hashCode` method.
    * See the Osera chapter for designing a good method.

Lab
---

Make sure you share contact info with your HW9 partners.

Schedule a meeting with your HW9 partners.

Continue working with probed hash tables using the lab from last class.
