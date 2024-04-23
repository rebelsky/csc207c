---
title: "Eboard 34: Hash tables"
number: 34
section: eboards
held: 2024-04-22
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Questions
* A bit about hash tables
* Lab

Preliminaries
-------------

* **Please fill in the mentor/tutor evaluation.** (you are currently
  at slightly under 50%; you want tokens/you need tokens)
* Congratulations to those of you who were elected to the SEPC. Sympathies
  to those of you who were not. (Or is it vice versa? There's a lot of
  work to do next year.)
* You will continue with today's lab partner on Wednesday 
  (with a few exceptions).

### Upcoming work

* Wednesday, 2024-04-24, 11:00pm, MP9
    * [_Submit MP9 on Gradescope_](...)
* Friday, 2024-04-26, 11:00pm, Post-reflection for [MP9](../mps/mp09)
    * [_Submit MP9 post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4373433)
    * [_Submit MP10 pre-reflection on Gradescope_](...)

### Tokens

Academic/Scholarly

* Tuesday, 2024-04-23, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-04-23, 8:00pm, Science 3819.
  _Mentor Session_. Make Elene and Sam happy. Show up to mentor sessions!
* Thursday, 2024-04-25, 11am, JRC 101.
  _Scholars' Convocation: Jonathan Rosa on Languages & Identities Beyond Borders_.

Cultural

* Wednesday, 2024-04-24, 7:30--8:30pm, Bucksbaum.
  _Cornelia Di Gioia Presentation with GSO_.
* Thursday, 2024-04-25, 7:00--8:00, Grinnell Art Museum.
  _Recital by Eric Mcintyre of new composition for gourd and visuals._
* Friday, 2024-04-26, 4:00--5:00pm, HSSC N1170.
  _Middle of Everywhere_. 
* Friday, 2024-04-26, 4:30--6:00pm, HSSC A2231 (Auditorium).
  _Conversation with Humanity. Climate Change._
* Saturday, 2024-04-27, Harris.
  _ISO Cultural Event._ Please don't destroy the bathroom ceilings.

Peer

Wellness

Misc

* Monday, 2024-04-24, 2:00--3:00pm, JRC Lobby.
  _Jelly Belly Buffett_. Any relation to Warren?
* Monday, 2024-04-24, 7:00--10:00pm, HSSC A1231 (Kernel).
  _SPARC Pitch_.
* Wednesday, 2024-04-24, 4:00--5:00pm, JCC Lower-Level Conference Room.
  _Leveraging LinkedIn_.

### Other good things to do (no tokens)

Questions
---------

### Administrative

Could there be new LAs this week?

> Sure.

Can I have a second redo on MP1 and MP2?

> Sure. During lab. Remind me if I forget.

### MP9

Why do we need both BitTreeNodes and BitTreeLeafs?

> Sometimes having separate classes simplifies things. Your interior 
  nodes (`BitTreeInteriorNode`) will need to store links to the subtrees 
  below them. Your leaves (`BitTreeLeaf`) will store only the value.

> Sam might do something like the following.

```
interface BitTreeNode {
} // BitTreeNode

class BitTreeInteriorNode implements BitTreeNode {
  BitTreeNode childZero;
  BitTreeNode childOne;
} // BitTreeInteriorNode

class BitTreeLeaf implements BitTreeNode {
  String value;
} // BitTreeLeaf
```

> We don't store references in the objects that don't need references,
  we don't store values in the objects that don't need values.

> We have an "easy" way to determine if we've reached a leaf.
  `node instanceof BitTreeLeaf`.

Can we do an example on the board?

> Sure.

> For each pair in the spec, we build a path using the first element
  of the pair and then put the second element of the pair at the leaf.

Do we care about the "visual aspect" (tactile arrangement) of 
bits in Braille?

> Only in that we might want to check our answers, particularly our
  Unicode answers.

Will our trees be complete?

> No. Not in general.

Will we need to implement `Iterator` objects?

> No.

Will we need to iterate the tree anyway?

> Yes, when you write `dump`.

Is there an order in which you want us to dump the tree?

> No. I'd find it easiest to do so recursively. If you want to use a
  Queue or a Stack that's fine with me.

Can you write me a test suite?

> Maybe. Stay tuned.

### Binary Search Trees

### Misc

What happens if you say a method throws a RunTimeException?

> I don't know. We'll look at it offline.

Hash table overview
-------------------

### Key ideas 

_TPS: What are five key ideas about hash tables?_

* Hash tables are one of the main implementations of the Dictionary
  (or Map) ADT.
* To achieve efficiency, we use arrays.
* Since keys are rarely integers, we use a "hash function" to convert
  each key into an integer, and then mod by the size of the hash table
  to figure out where to put the key/value pair.
    * Given the same key, the hash function should always give the same
      integer.
    * Given different keys, the hash function should try to give different
      integers.
    * Ideally, the hash function takes "nearby" keys and gives them very
      different hash values.
* Since there are many more potential keys than cells in our array
  (and maybe even more keys than integers), we may encounter
  conflicts. We'll need to handle those.
    * There are two basic approaches to handline conflicts: Probing and
      chaining.
    * In probing, you keep looking elsewhere in the table using some
      policy as to where to look next.
    * In chaining, you keep a list in each cell in the array, rather
      than a single key/value pair.
* When our table gets too full, we need to expand the array.
* Well designed hash tables are "amortized expected O(1)" for
  `set`, `get`, and `hasKey`.
    * "expected" - when randomness works the way we expect
    * "amortized" - sometimes we will do a really expensive operation
      (e.g., when call `set` and decide to expand the table), but
      if average it out ("amortize") it over all the different operations
      it's still constant time.
        * E.g., One call to `set` may take O(n) time. But if we do O(n)
          calls to `set`, and the rest of them are O(1), all of them
          are "amortized" O(1).

### Hashing

_TPS:Sometimes having separate classes simplifies things. Your interior
nodes will need to store links to the subtrees below them. Your leaves
will store only the value. How should we compute a hash value?_

* A "hack" answer: In Java, you can call the `hashCode` method for most
  of the built-in types.
* For really complex types, we use the memory address, and nothing is
  equal to anything that's not in the same memory location.
* For compound types: 
    * PM suggests: Take the hash code of each field, multiply by
      a prime, mod by maxint (more or less), and then add them
      together. (Alternatively: Take a prime to the hash code power.)
* For primitive types:
    * For letters:  Use the ASCII value
    * For integers: Use the integer
    * For reals: (remove the decimal point or turn the bits into the
      corresonding integer)

Policies:

* The same object should always have the same hash value.
* Different objects should have different hash values.

What does MDDigest do?

> It computes a different kind of hash value for byte strings. The
  same byte string should always give you the same value. Nearby byte
  strings should give different vales.

### Hash exercise

Compute your "hash code" by adding up the letters in your first name.

```
A:1     B:2     C:3     D:4     E:5     F:6     G:7     H:8     I:9
J:10    K:11    L:12    M:13    N:14    O:15    P:16    Q:17    R:18
S:19    T:20    U:21    V:22    W:23    X:24    Y:25    Z:26
```

Samuel = 19 + 1 + 13 + 21 + 5 + 12 = 71

Q: Is this a good hash function?

A: It feels like we'll get a lot of conflicts. (Of course, there are
more strings than integers, so we're guaranteed conflicts.)

A: We're supposed to distribute keys to different integers. This doesn't 
seem to do that.

A: It's not very "random" looking. Nearby words will have similar values.

We learned that ...

* The probe we chose can be really bad. Don't use 10 for a table of
  60 elements; it means you won't look everywhere.
* Particlarly with a bad hash function, you need a lot of empty space
  in the array. (Usually #cells = 2x#pairs is okay.)
* UM: You have to use math to do hash tables.
* We want good hash functions.
* A bad hash function might group values.
* Probing sucks. Use chaining.

We wanted to decide

* What happens when we try to add a name and we have a probe cycle?
    * We should expand the table.
    * We should choose a probing number that is relatively prime to
      the size of the table. Two numbers are relatively prime if
      gcd(n,m) = 1.  We wouldn't want to use 25 for our size 60 table,
      even though 60 is not evenly divisible by 25.
    * Or we can choose a probing "function". E.g., try 1, then 2 from
      there, then 3 from there, then 5 from there, then 7 from there, ..

What happens when we decide to remove something from a probed hash table?

* Either too much rearranging or we have to insert a dummy vale.
* Osera used something weird.

What happens when we decide to expand our probed hash table?

* Can I just add ten cells? Maybe. But we generally double the size
  each time. (Careful analysis helps explain why.)
* Can I just double the size? No. I have to rehash *everything*.
  O(n), where n is the number of things in the hash table.

What happens when we decide to remove something from a chained hash table?

* Remove from a linked list is (relatively) fast for short linked lists.

What happens when we decide to expand our chained hash table?

* We still have to rehash everything.

Lab
---

_We will continue this lab on Wednesday._
