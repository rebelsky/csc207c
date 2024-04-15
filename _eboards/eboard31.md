---
title: "Eboard 31: Dictionaries"
number: 31
section: eboards
held: 2024-04-15
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* A note on GitHub repos
* Questions
* A Dictionary ADT
* Implementing dictionaries

Preliminaries
-------------

* I should be distributing test cases for MP8 tonight.
* Detour: Could the first years who want to take a CS class in the fall
  ask the "Registration Advisors" about it? ("Will I be able to?")

### Upcoming work

* Wednesday, 2024-04-17, [Mini-Project 8](../mps/mp08)
    * [_Submit Mini-Project 8 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4363157)

### Tokens

Academic/Scholarly

* Tuesday, 2024-04-16, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-04-16, 8:00pm, Science 3819.
  _Mentor Session_. Make Elene happy. Show up to mentor sessions!
* Wednesday, 2024-04-17, 5:00--6:00pm, HSSC A1231 (Kernel).
  _GrinTECH Project Expo_.  What does TECH stand for?
* **Thursday, 2024-04-18, 11am, JRC 101**.
  **_Ruha Benjamin on "Viral Justice: How We Grow the World We Want"_**
* Thursday, 2024-04-18, 4pm, JRC 2nd Floor Lobby.
  _CS Poster Session, Part 2._
* Thursday, 2024-04-18, 4:15--6:00pm, JRC 101.
  _McKibben Lecture: Athenian Heroes: Re-reading the West Pediment of the Parthenon_.

Cultural

* Tuesday, 2024-04-16, 7:00--9:00pm, JRC 101.
  _The Man Without a World_.
* Friday, 2024-04-19, 4:00--5:00pm, HSSC N1170.
  _Middle of Everywhere_.
* Saturday, 2024-04-20, 1:00--4:00pm, Park Street to the Bear.
  _Carnivale_. (Vegetarian festival, I believe.)
  Food trucks. Carribean food.  It should be great.
  But why does it take three hours to go one block?
  Lots of organizations! Get food early, it may run out.
* Saturday, 2024-04-20, 2:00--5:00pm, Quad Dining Room.
  _Japanese Spring Festival_.
* Saturday, 2024-04-20, 7:00--9:00pm, Herrick.
  _Michael Londra and the Grinnell Symphony Orchestra_.
* Sunday, 2024-04-21, 2:00--4:00pm, Sebring Lewis Hall.
  _Grinnell Singers with a King Singer (Simon Carrington)._

Peer

* Saturday, 2024-04-20, 10:00am--1:00pm, Track and Field Complex.
  _Dick Young Classic_.
* Sunday, 2024-04-21, 10:00am--1:00pm, Tennis Courts.
  _Men's Tennis vs. Coe._

Wellness

* Monday, 2024-04-15, 4:00--5:00pm, HSSC Atrium.
  _Therapy Dogs_.
* Tuesday, 2024-04-16, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-04-16, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-04-16, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

* Tuesday, 2024-04-16, 4:00--5:30pm, HSSC N1112.
  _Printmaking Workshop with Digital Studies_. "Drinks and supplies included."
* Saturday, 2024-04-20, 8:00am--5:00pm, JRC 209.
  _Mental Health First Aid Training_. Let me know how many tokens you
  consider appropriate for a full-day event.
* Saturday, 2024-04-20, 11:00am--6:00pm, Mac Field.
  _DAG Field Day_. Why is DAG all caps? (Backronym for duels and games;
  used to be something like dagohir, which is Elvish for duels and games.)

### Other good things to do (no tokens)

* Consider voting for your classmates for SEPC. 
* Wednesday, 2024-04-17, 3:00--5:00pm, Softball Complex.
  _Softball vs. Knox_.
* Saturday, 2024-04-20, 1:00--3:00pm, .
  _Softball vs. Ripon._
* Saturday, 2024-04-20, 3:00--5:00pm, .
  _Softball vs. Ripon, revisited._

NO! You do not get tokens for Wonderland Harris.

Questions
---------

### Administrative

### MP8 - Circularly Doubly Linked Lists with Dummy Nodes

Should we hide our implementation from the user?

> Definitely.

So `hasNext` is false when we hit the "end" of the list (the dummy node).

> Yes.

When we initialize an iterator for an empty list, what should we do
with `next` and `prev`?

> I'd make them both point to the dummy node.

> Sam thinks that this will help avoid special cases.

### Other

Suppose I got an incomplete because my MP did not compile. Could that
be that my files did not end up in the right package?

> Perhaps. Our graders don't like to have to try to figure things out
  (aka; they don't have time and aren't paid enough to do so).

> Please use GitHub.

> Ask me to look at it.

How do we limit what's in our submission given that we're using GitHub?

> Don't put crap in your repo. DON'T USE `git add .`!!!!!!!!

How do we remove cruft from our GitHub repo?

> `git rm STUPID_FILE; git commit -m "Remove stupid file"; git pull; git push`

Suppose I'm using VScode to communicate with GitHub. Is that okay?

> I have no idea how the GitHub module works in VScode, but you should feel
  free to use.

Why doesn't Sam use convenient tools?

> Sam is old. Sam likes the command line. Sam knows what happens when he
  uses the command line.

Setting up GitHub, revisited
----------------------------

Enough of you seem to be having difficulty that I'm going to try to
walk through it one more time. Please stop me as soon as you get lost.

Step one: Set up a new project on VSCode.

* Shift-Ctrl-P for the Command Palette
* Java: New Java Project ... [The ellipses suggest that you will get prompted
  for more input]
* No Build Tools
* Select an appropriate directory
* Enter a project name.
* Cross your fingers.

Step one-eh: Remove the unnecessary App.java

Step one-bee: Edit the README.md and save it.

Step two: Set up a new repository on GitHub

* Log in to GitHub
* Select "new repository"
* Do not add a README.md or LICENSE Or gitignore (at least for the time
  being).

Step three: In the terminal, in the directory for the project, type something 
like the following

```
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:rebelsky/csc207-mini-project-eight.git
git push -u origin main
```

Step four: Write some Java files.

Step five: Add them to the repo.

```
git add src/stuff/Util.java
git commit -m "Add my amazing Java file."
git pull
git push
```

What if we fork and clone?
--------------------------

In this case, you will generally *not* create the Java project in VSCode.
Rather, you'll hope that the project is organized correctly and you can
just open it in VSCode.

A Dictionary or Map API
-----------------------

"PUM"

* Philosphy: Associate values with keys. Each key may have at most one
  associated value.
* Use cases: Almost every database.
* Methods: _TPS_

Essentials

* `boolean hasKey(K key)`
* `void set(K key, V value)` 
    * boolean returns "true" if it sets and "false" otherwise.
    * `boolean set(K key, V value) { return false; }`
    * Other design possibility: Return `void` by default, throw an exception
      if it's not possible to set. The exception can explain the problem.
      E.g., `FullDictionaryException` or `InvalidKeyException`.
    * Other design possibility: Return the value set (or the old value if
      there was one there). `V set(K key, V value)`. Still use exceptions
      for failure.
* `void remove(K key)` - Remove the key/value pair with the given key.
    * If the key isn't there, we could throw a `KeyNotFound` exception.
    * If the key isn't there, we could do nothing; after all, it's clearly
      gone afterwards.
    * We could also return the corresponding value. `V remove(K key)`.
      Return `null` if there is no corresponding value (or throw an
      exception).
* `V get(K key)` - Get a value.

Sam won't let you add

* `void add(K key, V value)`
    * Differs from `set` in that `set` is supposed to change an existing
      thing while `add` adds a new key/value pair.
    * We'll do without the `add`/`set` pair, but it can be useful.
* `boolean isEmpty()` - Do we have any key/value pairs?
    * Skipped because we have `size`.

Sam will let you add

* `Iterator<KVPair<K,V>> iterator()`
    * A nice starting iterator. Much better than returning an array.
* `int size()` - Determine how many key/value pairs are in the dictionary.
* `boolean isFull()` - Can we add more key/value pairs?
* `Iterator<K> keys()` - Get all the keys in a dictionary. 

Implementing the Dictionary API
-------------------------------

"LIA"

How many implementations can we come up with?

How do they do on the different methods?

* AssociativeArray: We store key/value pairs in no particular order
  in an array. (We've done this already. Yay!)
    * set: O(n) because we have to look through all the pair
    * get: O(n)
    * remove: O(n)
    * hasKey: O(n)
* Alternate implementatoin of AssociativeArray: Instead of an array
  of key/value pairs, we have one array of keys and one array of values.
* Alternate implementatoin of AssociativeArray: One array, with the keys
  at even indices and the values at odd indices. (Likely to break type
  systems.)  `Object[] stuff;`
* AssociationList: A linked list in which each node contains a key, a value,
  and the next (and previous?) links.
    * set: O(n)
    * get: O(n)
    * remove: O(n)
    * hasKey: O(n)
    * But ... adding new elements is likely "easier" b/c you don't have
      to worry about growing the array.
* Hash tables: Compute a "hash value" for each key (lock those from
  blockchains): [We'll come back to this.]
* Ordered list.
    * Note: Requires that either (a) keys are Comparable or (b) we have
      a Comparator for keys.
    * set: O(n)
    * get: O(n)
    * remove: O(n)
    * hasKey: O(n)
* Ordered Array
    * Note: Requires that either (a) keys are Comparable or (b) we have
      a Comparator for keys.
    * set: O(n)
    * get: O(logn) - use binary search
    * remove: O(n)
    * hasKey: O(n)
* Binary search trees! (We learned those in 151, right?)
    * Note: Requires that either (a) keys are Comparable or (b) we have
      a Comparator for keys.
    * Divide and conquer is a great strategy, even for data structure
      design.
    * Binary search tree:
        * A binary tree is a structure in which each node has a "left" and a
          "right" pointer as well as a value (or in this case, a key and
          a value).
        * Things with smaller keys are to the left, things with larger
          keys are to the right.
    * set: O(height)
    * get: O(height)
    * remove: O(height) [may be hard to implement]
    * hasKey: O(height)
    * If the tree is perfectly balanced, the height is O(logn)
* Coming Wednesday: Trees. Coming Friday: Binary Search Trees.
  Coming Monday: Hash Tables. I think.

Enjoy the Sun.
    
