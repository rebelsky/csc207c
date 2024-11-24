---
title: "Eboard 23 (Section 1): Hash tables"
number: 23
section: eboards
held: 2024-11-21
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* About MP10
* Questions
* Hash table overview
    * Key ideas
    * Hashing
* A hash exercise
* Lab?

Preliminaries
-------------

### News / Notes / Etc.

* I had planned today as a talking day, but we may have time to start
  the lab.
* See, I told you loop invariants were important! (Some of you will 
  understand this comment and some will not.)

### Upcoming work

* Thursday, 2024-11-21 
    * MP10 assigned (due in two weeks)
* Sunday, 2024-11-24
    * [MP9](../mps/mp09) (Blockchains) due.
    * [Submit MP9 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5321058)
* Monday, 2024-11-25
    * No reading for Tuesday! We're continuing our study of hash tables.
    * [Submit post-reflection for MP9](https://www.gradescope.com/courses/818402/assignments/5321060)
    * [SoLA 10](../los/sola10) due
        * New: [ADT/DS #5: Dictionaries](https://www.gradescope.com/courses/818402/assignments/5354889)
        * New: [ADT/DS #7: BSTs](https://www.gradescope.com/courses/818402/assignments/5354897)
        * New: [Development #9: Use libraries](https://www.gradescope.com/courses/818402/assignments/5354901)
        * New: [Development #12: Professional ethics](https://www.gradescope.com/courses/818402/assignments/5354912)
* Wednesday, 2024-11-27
    * Lab writeup from class 24.
* Sunday, 2024-12-01
    * Pre-reflection on MP10 due.
* Monday, 2024-12-02
    * Reading response for class 25.
    * SoLA 11 (optional) due
        * New: ADT/DS #4: Priority queues
        * New: Development #11: Ethical reuse
        * This SoLA is "optional" in that I won't send in AAs after it.
* Thursday, 2024-12-05
    * MP 10 due.
    * MP 11 released.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Sunday, 2024-11-24, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_
* Tuesday, 2024-11-26, noon--1:00 p.m., Day PDR.
  _CS Table: ??? 

#### Cultural

* Weekend of November 23, Roberts Theatre.
  _Pity_
* Saturday, 2024-11-23, 4:00--5:00 p.m., Herrick Chapel.
  _YGB Gospel Choir_
* Sunday, 2024-11-24, 2:00--3:00 p.m., Sebring-Lewis.
  _Collegium Musicum Concert_

#### Multicultural

* Friday, 2024-11-22, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Vietnamese Cafe' Culture_ 
* Saturday, 2024-11-23, 5:00--8:00 p.m., Harris Concert Hall.
  _Festa Novembrina_

#### Peer

* Thursday, 2024-11-21, 7:00--8:00 p.m., HSSC S1325.
  _GHAMP Study Break_
* Friday, 2024-11-22, 5:00--8:00 p.m., Downtown Grinnell.
  _Jingle Bell Holiday_.
* Friday, 2024-11-22, 8:00 p.m., Main Lounge.
  _Improv Double Header_.
* Monday, 2024-11-25, 8:00--10:00 p.m., Bob's Underground.
  _Open Mic Night_. 

#### Wellness

* Tuesday, 2024-11-26, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-12-03, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.

#### Misc

* Fill in the peer-educator evaluation form (see email).

### Other good things (no tokens)

Notes on MP10
-------------

Updates coming soon (including tests).

Demo coming on Tuesday (sorry for the delay).

Questions
---------

### Administrative

### MP9

**When we convert integers into bytes, do we need to allocate a byte array that has four bytes?**

> Yes.

> From the Q&A: `md.update(ByteBuffer.allocate(Integer.BYTES).putInt(i).array());`

> Although you probably should allocate the buffer only once and might
  decompose into a separate method.

**Are you going to give us a test for the blockchains?**

> Yes. It will be out tonight (if all goes as expected).

### MP10

### Miscellaneous

### Hash tables

_I'll take hash table questions after we discuss them. I'm including them here in case you want to include them in your own discussions._

**I don't understand the `hashCode` method.**

**Can you explain the difference between the hash function and casting types as integers?**

**What does it mean for an object to be 'hashable'? Is it related to the 'hashing' in this reading?**

**It it better for a hash to be an integer, a long, or an array of bytes? Each seem to have their benefits and drawbacks (ints have a relatively small storage size but comparatively few values, longs have a good range of values but a decent size, byte arrays can be any arbitrary size but they are stored as bytes).**

**Just to confirm, if you're chaining and the number of keys in a bucket surpasses the bucket's capacity, we just double the size of that bucket, right? Which means that the main array of buckets is unaffected by this?**

**How is the constant hash function necessarily a problem if we have the solution of chaining where several keys can fall under the same value in the array (that is, they all are under the same sub array). If this doesn't make sense then can you re-explain the constant hash function?**

**Can you explain the hash function for floats?**

**I just wanted to say I don't think I understood hash functions for objects.**

Hash table overview
-------------------

### Key ideas 

_TPS: What are five key ideas about hash tables?_

* A structure that stores key/value pairs (so a Map or Dictionary)
* Attempts to be efficient by making it like an array.
    * We use a hash function to convert the key to an integer so that
      we can use the efficient integer access of arrays.
* Sometimes keys collide in the hash table.
    * One way to resolve this is to go to another cell in the hash table
      (e.g., the next one). We call this "probing".
    * Another way to resolve this is to put all the key/value pairs with
      the same hashCode in the same cell (which is usually a linked list
      or array). We call this "chaining".
* The order of keys is independent of any natural ordering of the keys
  (in fact, the keys don't need to be orderable).
* If we are lucky and don't get collisions, this should be O(1).
* If we are unlucky and get collisions, this could be O(n).
    * If we're probing, we'll need to probe through O(n) cells.
    * If we're chaining, we'll have a chain of O(n) pairs.
    * Conclusion: Design a good hash function.
    * In part, we get lucky by limiting the percentage of filled cells
      in the hash table (particularly for probed, but also for chained).
* We need to expand the table from time to time.
    * Normal policy: Double the size (more or less).
    * Even though it's O(n) to double the size. We only the double the size
      when we've added more than half the number of values in the table
      n/2. If we think about the total number of adds, that preceded the
      doubling, there are O(n). So the "amortized" cost to double the size
      is only O(1) per add.
    * There's still some slowdown to expand.
    * And we're better off leaving lots of space.

### Hashing

_TPS: How should we compute a hash value? How about for our `BigFraction` 
class from the start of the semester?_

General:

* Convert to a real number between 0 and 1, multiply by something like
  `Integer.MAX_VALUE` and round.
* Convert them to bits and then do something with the bits. (perhaps
  treat them as an integer (not `int`), divide by the largest integer
  with that many bits, and do the previous step).
* Compute the hash code for each part, take prime1^firsthash times prime2^secondhash times ... mod prime.
* Sam's quick hack: Convert to a string and rely on Java's `String.hashCode()` method.

Specific:

```java
public class BigFraction {
  BigInteger numerator;
  BigInteger denominator;

  public int hashCode() {
    ...
  } // hashCode()
} // class BigFraction
```

Option 1: `return this.numerator.add(this.denominator());`

* This isn't an `int`.

Option 2:

Hash exercise
-------------

### Hash exercise

Compute your "hash code" by adding up the letters in your first name.

```
A:1     B:2     C:3     D:4     E:5     F:6     G:7     H:8     I:9
J:10    K:11    L:12    M:13    N:14    O:15    P:16    Q:17    R:18
S:19    T:20    U:21    V:22    W:23    X:24    Y:25    Z:26
```

For example,

* Samuel -> 19 + 1 + 13 + 21 + 5 + 12 = 71
* Mod by the hash table size (in this case, 43)

We will put your names into the hash table on the board. (We'll use a probed
hash table with an offset of 1.)

_TPS: What did we discover?_

* Probing seems to increase the number of collisions because we start
  filling up nearby cells.
* Collisions seemed more common than we expected. (Don't use birthdays
  as hash keys.)
* Potential issue: With linear probing, how do we keep track of what has
  been pushed to a new cell?
    * You can compute the hash code again and compare to the cell number.
* What if we wanted to add KAAM to the table.
* It's important to compute you hash code correctly.
* It would be nice if similar-size words did not have similar hash codes
  This is a BAD hash function.

Questions
---------

_Do you have remaining questions about hash tables?_

**Is it better for a hash to be an integer, a long, or an array of bytes? Each seem to have their benefits and drawbacks (ints have a relatively small storage size but comparatively few values, longs have a good range of values but a decent size, byte arrays can be any arbitrary size but they are stored as bytes).**

> It depends on what you're using the hash for.

> For hash tables: Perhaps `long`, because that gives us more values.
  but `int` is probably the best, because Java (and most languags) won't
  let you create an array of `Integer.MAX_VALUE` elements.

> For verification: Byte array: Gives you more flexibility (and more hash
  codes).

**What does the hash table look like in memory?**

> Sorry, no ASCII art. See board.

**In the real world, do we use chaining or probing?**

> I believe chained hash tables are more popular; remove is easier and
  we don't get the issue of long lines of shifted vales.

**Can we put things in hash tables if they don't have hash functions?**

> Nope. So when you create basic new classes, you should consider building
  a hash function. We usually don't worry about using collections as
  keys.

Lab
---

If there is time, we will conduct lab. We will continue the lab in the next class.

Your partner for Tuesday's lab will be your partner for this lab.
