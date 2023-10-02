---
title: "EBoard 17: Iterators"
number: 17
section: eboards
held: 2023-10-02
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.

_Approximate overview_

* Administrivia
* Questions
* Lab

Administrivia
-------------

* Tests that identify errors in my code will earn you tokens.
    * That's an incentive to push tests early.
* I spent 24 hours this weekend on a conference.  I'm even further behind.

### Upcoming Token activities

Academic

* CS Table, Tuesday, Noon, Reports from Tapia and GHC.

Cultural

Peer

* Saturday, 1:30, Soccer

Wellness

Misc

### Other good things (no tokens)

### Upcoming work

* Wednesday: CLRS 2.1 (Insertion Sort) and 2.2 (Analyzing Algorithms).
* Thursday: MP4
* Friday: MP4 post-assessment

Questions
---------

### MP4

What do you think about shifting elements down upon `remove()`?

> It seems expensive to me.  I'd like to see a constant-time operation
  (one independent of the size or position in the array).

Do you have hints on how to do that?

> TPS

> One idea: If we're deleting at the front, just do the fancy stuff
  we figured out how to do when dealing with array-based queues.

> Another idea: Leave nulls in the middle.  That may make adding elements
  hard, because we'll have to decide where to add things.

> So what does `add` look like?  Look through as normal (except skipping
  over nulls).  If we find a match, update the KVpair.  If not, we
  go back and look for the first null.  Unfortunately, this causes
  us to loop twice.

> Another option for `add`: Just add at the end (so that you don't
  have to loop twice).  If you run out of space, go through and
  clean up the array.  (We've amortized the work.)

> Another option: The `search` procedure can keep track of the address
  of the first null and return either (a) the address of the matching
  element, if found, or (b) the address of the first null, if not
  found.

> Another option for `add`: Always add at the end, without even looking,
  search now needs to go "backwards" from the end.  Yay!  `add` is
  also constant time.  Cleanup is a PITN.

> A third idea for remove: Take the last element and put it in place of the
  removed element.

How do I run the tests on Windows?

> I don't know how to link directories on Windows.

> One option is to copy the testing file to the `src` directory of
  your project, run tests, and then copy it back to the repo.

> Another option is to use MathLAN.

> Another option is to install Linux Subsystem for Windows.

> Or maybe one of you knows how to link directories on Windows.

> Another option is to figure out how to add the development
  directory to the classpath for the testing file.
  to the classpath

What are we submitting?

> The tests.

> Your associative array code.  It should pass all the (correct) tests.

Lab
---

How do we write an anonymous inner class for our comparator?

```
  Comparator<String> myComparator = new Comparator<String>() {
    public int compare(String s1, String2) {
      ???
    }
  }
  PriorityQueue<String> strings = new PriorityQueue<String>(myComparator);
  ...
  strings.add("Hello");
  strings.add("World");
  strings.add("Aaardvark with an extra a");
  pen.println(strings.get());        // Assumed aardvark
```

What should `compare` return?

> A negative number if `s1` comes before `s2`, zero if they are equal,
  a positive number if `s1` comes after `s2`.
