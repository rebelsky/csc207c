---
title: "Eboard 11: Generics"
number: 11
section: eboards
held: 2024-02-14
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed.**

_Approximate overview_

* Administrivia
* A design exercise
* Questions
* Lab

Preliminaries
-------------

* Happy Valentine's Day (or happy Ash Wednesday). I brought you stickers.
* Sam broke his hearing aids and hears even less well than normal.
* Please DM me your GitHub username.

### Upcoming work

* 11pm Wednesday, 2024-02-14: [Mini Project 3](../mps/mp03)
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4080604/)
* 11pm Thursday, 2024-02-15: Reading on Exceptions
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4090750)
* 1pm Friday, 2024-02-16: Wednesdays's lab writeup.
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4080411/)
* 11pm Friday, 2024-02-16: MP3 Post-Reflections
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4102633/submissions)
* 11pm Friday, 2024-02-16: MP4 Pre-Reflections
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4102636)

### Tokens

Academic/Scholarly

* Thursday, 2024-02-15, 11:00--noon, JRC 101.
  _Scholars' Convocation: Gaile Pohlhaus on "An Epistemology of 
   the Oppressed: Resisting and Flourishing under Epistemic Oppression"._
     * You can also talk to the speaker.
* Thursday, 2024-02-15, 4:00pm, Science 3821.
  _CS Extras: PM Osera_.
* Tuesday, 2024-02-20, noon--1:00pm, Some PDR.
  _CS Table: ???.
* Tuesday, 2024-02-20, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.

Cultural

* Thursday, 2024-02-15, 7:00--9:00pm, Sebring-Lewis.
  _Jazz Concert w/Carol Welsman_.
* Friday, 2024-02-16, 4:00--5:00pm, HSSC N1170 (Global Living Room).
  _Middle of Everywhere._
* Sunday, 2024-02-18, 7:00--9:00pm, Harris Cinema.
  _The Moth Storytelling Slam_.

Peer

* Friday through Sunday, 2024-02-16 through 2024-02-18. Osgood Pool.
  _Midwest Swimming and Diving Conference Championships_.
    * 30 minutes counts.
    * Up to two separate sessions.
* Saturday, 2024-02-17, 2:00--5:00pm, Field House.
  _Women's Tennis vs. Ottwawa_.

Wellness

* Tuesday, 2024-02-20, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-02-20, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._ (I think)
* Tuesday, 2024-02-20, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

### Good things to do (no tokens)

* Saturday, 2024-02-17, 1:00--3:00pm, Darby.
  _Men's Basketball vs. Monmouth_.
* Saturday, 2024-02-17, 3:00--5:00pm, Darby.
  _Women's Basketball vs. Monmouth_.

A design exercise
-----------------

PUM

* P: Philosophy (the underlying principle)
* U: Use Cases (why we have this thing / what situations would we
     use it)
* M: Methods (what operations ground the structure)

LIA

* L: Layout (do we use a pointer structure or an array/chunk 'o memory)
* I: Given that layout, how do we implement the methods
* A: Analysis (how fast are these methods likely to be in terms of
  some size or sizes)

A data structure we know: The array

* Philosophy: A structure that lets us map integers in the range [0 .. n)
  to values of a particular type.
* Use cases: Implementing other data types. Mapping student IDs to student
  records. Storing the pixels in an image.

A similar data structure: The Associative Array

* Philosophy: A structure that lets us map values of one type (keys) to values
  in another type (values).
    * Also called "Map", "Table", "FunctionWithAVeryLimitedDomain", ...
* Use cases
    * Store data that we would not normally be indexed.
    * Implementating a data type: The initial type is the names of the
      "fields", the result type is the contents.  The field names in
      an object are keys, the contents of those fields are values.
    * Convert student names to lists of grades (or tables of grades).
      (Whoo! Recursion!)
    * Associate first names with last names (crossing our fingers that
      we have no duplicate last names).
        * `faculty.set("Rebelsky", "Samuel")`
        * `faculty.set("Weinman", "Jerod")`
        * `faculty.set("Rebelsky", "Fred")`
* Methods

```
/**
 * Things that let us associate values of type V with values of type K,
 * where we look them up with the K values.
 */
public class AssociativeArray<K,V> {
   /**
    * Get the value associated with a key.
    *
    * @exception KeyNotFoundException
    *   When the key is not in the AA.
    */
   public V get(K key) throws KeyNotFoundException {
     return null;       // STUB
   } // get(K)

   /**
    * Associate a value with a key.
    *
    * @exception OutOfRoomException
    *   If there is not space to add another value.
    * @exception NullKeyException
    *   If there is not space to add another value.
    */
   public void set(K key, V value) throw OutOfRoomException, NullKeyException {
     // STUB
   } // set(K,V)

   /**
    * Remove a key/value pair.
    *
    * @exception KeyNotFoundException
    *   If the key is null or not already in the associative array.
    */
   public void remove(K key) throws KeyNotFoundException {
     // STUB
   } // remove(K)

   public boolean containsKey(K key) {
     return false;
   } // containsKey(K)

  public boolean isEmpty() {
    return false;       // STUB
  }

  public boolean isFull() {
    return false;       // STUB
  } isFull()

  public int size() {
    return 0;           // STUB
  }

  // +-------------------------+-------------------------------------
  // | Standard object methods |
  // +-------------------------+

  /**
   * Convert to a string (e.g., for printing).
   */
  public String toString() {
    return "{ }";       // STUB
  } // toString()

  /**
   * Compare for equality.
   */
  public boolean equals(Object other) {
    return false;       // STUB
  } // equals(Object)

} // class AssociativeArray
```

Some design questions

* Should we cap the number of values we can store?
    * Decision: We should permit it.
* Does `set` require that the key already be in the association list?
    * Yes: We need a procedure to add a key.
    * No: Followup: Can you replace something already set using `set`
      or do we need a separate `replace` operator?
    * Decision: `set` does everything. Adds, replaces, mixes, 

LIA

Layout: Store them in an expandable array of key/value pairs.

```
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * All of the k/v pairs.  Added to the end of the array as we go.
   * The array magically expands when needed.
   */
  KVPair<K,V> pairs[] = ...;

  /**
   * How many values are stored.
   */
  int size;
```

Implementation: How would you implement `get` and `set`? 

```
  public V get(K key) throws KeyNotFoundException {
  } // get(K)

  public void set(K key, V value) throws NullKeyException {
  } // set(K, V)
```

Get (Conceptually)

* Search through all of the K/V pairs in the array, stopping
  when the key of the pair matches the sought key or when we
  get to the end.
    * In the former case, return the corresponding value
    * In the latter case, throw a KeyNotFoundException

Set (Conceptually)

* Search through all the K/V pairs in the array, stopping when
  we find a matching key or when we run out of pairs. 
    * In the former case, set the value
    * In the latter case, append to the end of the array (expanding
      the array if necessary)
        `this.pairs[this.size++] = new KVPair<K,V>(key,value);`

Remove (Conceptually)

* Note: Drawing pictures might help

```
+---+---+---+---+---+
| * | * | * | / | / |
+-|-+-|-+-|-+---+---+
      |   v
      | +-------------+
      | | Last: Smith |
      | | First: Jane |
      | +-------------+
      v
```

Strategy one:

* Search through all the key/value pairs until we find the pair or
  run out of pairs.
    * In the former case, shift everything left by one until we hit the end.
      Then put a null at the end.
    * In the latter case, throw an exception
* Running time depends on the number of values stored in the associative array.

Strategy two:

* Build a new array, copying each thing that doesn't have a matching key
  over.
* If the size of the new array is the same as the old array, throw an
  exception.
* Running time depends on the number of values stored in the associative array.

Strategy three:

* Like strategy one, except that you just put a null there rather than
  shifting.
* May affect how we write `get` or `set`.  E.g., `size` has a different
  meaning; may require a separate `last-element`.
* Or the semantics of `remove` could be "doesn't necessarily change
  the size". People who believe this write programs that run out of
  memory.
* May make `toString` a bit harder.
* Running time is constant.

Strategy four:

* Like strategy one, but only shove elements once in a while.  (E.g.,
  flip a coin to decide whether or not to move.)
* Running time is confusing.

Strategy five:

* Like strategy three, but we move the last element into the place
  we just freed. (We do have to clear out the last element.)
* Running time is constant.

Question: What is an ADT? I didn't quite understand?

* An ADT is the PUM part of a structure. It's a way of thinking about
  how we organize a collection of data.  
    * It's abstract in that the implementatoin is not part of our
      initiail analyis.

Questions
---------

### Administrative

### MP3

### Generics

What is a "functional interface" (from the java documentation for Function)?

> One in which there is only one non-default method, which means that we can implement it with a lambda expression.

What is the difference between `andThen` and `compose`? (from Java documentation for `Function`)

> Both compose functions. `andThen` builds a new function that applies the parameter function *after* the current function while `compose` builds a new function that applies the parameter *before* the current function.

> For example, if `dub` is a function that doubles its parameter and `inc` is a function that adds one, `dub.andThen(inc).apply(5)` would double 5, giving 10, and then add 1, giving 111.

> In contrast, `dub.compose(inc).apply(5)` would increment 5 first, giving 6, and then double it, giving 12.
 
Lab
---
