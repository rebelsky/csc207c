---
title: "Eboard 19: Big-O (for real this time)"
number: 19
section: eboards
held: 2024-03-04
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia
* Some notes on MP5
* Questions
* Algorithm analysis
    * Introduction
    * Terminology and informal notions
    * Some common bounds
    * Analyzing iterative algorithms
    * Analyzing nested loops
    * A more formal definition

Preliminaries
-------------

* I hope you enjoyed the sunny (and windy) weekend.
* The new tokens assignment is posted. I'm working on copying things
  over from the old tokens assignment.
* If you are an irresponsible advisee who did not respond to my email,
  please do so ASAP.

### Upcoming work

* Wednesday, 2024-03-06, 1pm, Readings
    * CLRS 3 (Characterizing Running Times)
    * CLRS 4 (intro)
    * CLRS 4.3 -- 4.5 (Methods for solving recurrences)
    * Make sure to attempt to read the code and math; that's often where
      the important stuff is happening.
* Wednesday, 2024-03-06, 11pm, [MP5](../mps/mp05)
    * [_Submit MP5 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180584/)
* Friday, 2024-03-08, 11pm, MP5 post-reflection
* Friday, 2024-03-08, 11pm, MP6 pre-reflection
* Sunday, 2024-03-10, 11pm, [MP1](../mp1) redo
    * [_Submit MP1 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180612/)
    * Please don't submit until it's ready for grading.
* Sunday, 2024-03-10, 11pm, [MP2](../mp2) redo
    * [_Submit MP2 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180615/)
    * Please ask if you're confused about something.
* Friday, 2024-03-15, 11pm, Third set of LAs.

### Tokens

Academic/Scholarly

* Tuesday, 2024-03-05, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-02-27, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.
* Thursday, 2024-03-07, 11:00 a.m.,JRC 101.
  _Scholars' Convocation: An American Genocide: The United States and 
   the California Indian Catastrophe, 1846-1873_

Cultural

* Monday, 2024-03-04, Sebring Lewis.
  _Des Moines Metropolitan Opera: Beauty and the Beast_
* Thursday, 2024-03-07, JRC 101, 8:00-9:30 pm.
  _Writers@Grinnell: Carl Phillips_
* Thursday--Saturday, 2024-03-07 to 2024-03-09, 7:30 p.m.
  _Songs of the Scarlet and Wayback_ (play).
* Friday at 4pm in the Global Living Room.
  _Middle of Everywhere_.
* Saturday, 2024-03-09, Harris Cinema, ??:??
  _Met Opera: Verdi's La Forza del Destino_.
* Saturday, 2024-03-09, 2:00 pm, Sebring-Lewis.
  _ZAWA!_ (Flute concert).

Peer

* Saturday, 2024-03-09, Field House.
  _Men's and Women's Tennis vs. Central._

Wellness

* Tuesday, 2024-03-05, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-03-05, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-03-05, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.
* Wednesday, 2024-03-06, 4pm, JRC 101.
  _Intimacy Stages_.
* Friday, 2024-03-08, noon, JRC 101.
  _Wellness Bingo_.

Misc

### Other good things to do (no tokens)

Some notes on MP5
-----------------

### Primary goals

* Experience building *part* of a project (e.g., a library for others to
  use).
* Further understanding the use of your `AssociativeArray` class.
* Practice "wrapping" objects/classes (`AACCategory` primarily wraps 
  `AssociativeArray` in that its primary functionality requires us to
  call `AssociativeArray` methods).
* Reflection on your responsibilities as a software developer.
* Some consideration of APIs (Is the one you were given good? How could
  it be improved?)
* Give you the start of something that could become a bigger personal
  project.

### Other comments

Once again, a reminder that _Without looking at any resources (e.g.,
readings, labs, your notes), write down everything you know that
might be useful for this assignment_ exists to encourage you to
start dumping your brain. You can also use it as an opportunity to
do "free writing" on some of the key methods or classes.

Also: I ask you do to the pre-reflection to encourage you to read
the assignment carefully a few days before it is due. Responses
that say "I haven't really read it" should not suffice.

A lot of you seem to be reluctant to get started. What would help
you? Should I reserve time on Fridays for demoing how to get started?

Also: This assignment is less scary than it looks!

mg/Please don't clutter your repo with unnecessary files (e.g., .class).
`.DS_store`.

Demo

Questions
---------

### Administrative

What should we do about the things on Gradescope that you told us not to
submit anything for.

> Remind me and I'll delete them.

### LAs

Sam takes forever to grade. How will I know whether to redo an LA on the
next set?

> Assume you'll do them alternating weeks.

### MP5

When we write to a file in mappings, where does that file go?

> Probably the top level. Try it and see. You get something like
  `AACMappings-New.txt`

What's `AACMappings.txt`?

> It's the file that gets provided to your constructor.

When should you use an adapter and when should use inheritance?

> Wrapper/adapter: When you have a specification for what methods you need
  to provide, and you have something with similar methods, but different
  names.

> If you use inheritance for adapting, you're providing not only the new
  methods, but the inherited methods, too.

> You can adapt multiple things, you can only inherit from one.

### Other topics

Analyzing algorithms
--------------------

Our goal as programmers / computer scientists is to build algorithms
that (help us) solve problems.  We also build data structures to help
with that.

We want to know things about our algorithms, so that we can, for
example, decide which algorithm is best for our particular problem.

Key ways we analyze algorithms:

* Is it correct? Unit testing sometimes helps. Formal verification is better.
    * Formal verification doesn't always work: `int mid = (lb + ub) / 2;`
* Is it fast (or at least comparatively fast)? (We need a metric for measuring
  speed.)
* How much memory does it use?

We need techniques to talk about the running time and space usage of
algorithms.

Important issues that come into play

* The relative speed of operations vary from computer to computer.
    * In the end, these are less important than a bigger picture
      "shape of the running time curve".
* If we double the input size, what happens?
    * A "fast" algorithm that quadruples the time every time you double
      the input size is usually worse than a "slow" algorithm that
      doubles the time every time you double the input size.
    * The same holds for space.
* Algorithms are not completely uniform in their running time. There
  are some algorithms that run faster on one input than another.

Terminology/Informal notions
----------------------------

Big-O, usually notated as O(f(n)). The time or space graph for a
function is bounded above by some constant times f(n), for
sufficiently large inputs.

Big-Omega: The time or space is bounded *below*

Big-Theta: Bounded above and below by the same function.

In 207, we'll do informal analyses of these things (mostly Big-O), in
301, you'll do more formal analyses.

Most computer programmers use Big-O a lot like like "approximately
Big-Theta".

Common classes of functions
---------------------------

* "Constant time": O(1). The running time does not depend on the size
  of the input.
    * `car`
    * `foo[i]`
* "Logarithmic": O(logn). When the input size doubles, the running time
  goes up by a constant. 
    * Binary search
* "Linear": O(n). The running time grows proportionally to the size of
  the input. When the input size doubles, the running time also doubles.
    * `(last lst)`
    * `(index-of val lst)`
    * `find-key(key)` - Note that you won't always have to do twice as
      much work. Maybe the key is at the beginning. But you might have
      to search the whole array, and we're doing an upper bound.
* "N log N": O(nlogn). Merge sort, Heap sort, some other sorts.
* "Quadratic": O(n^2). When the size of the input doubles, the running
  time quadruples.
    * Insertion sort

As good computer scientists, we should analyze our algorithms carefully
and, once we've analyzed an algorithm, ask "Can we do better?"

When we get really good, we prove that we can't do any better.

* There's a proof you'll see in 301 that we can't sort using compare-and-swap
  in fewer than O(nlogn) steps.

Analyzing iterative algorithms
------------------------------

Iterative algorithms are algorithms in which we handle repetition with
loops rather than recursion.

In general, we analyze iterative algorithms by "counting steps" as best
we can.

```
int find(K key) throws KeyNotFoundException {
  for (int i = 0; i < this.size; i++) {
    if (this.values[i].key.equals(key)) {
      return i;
    }
  }
  throw new KeyNotFoundException(key.toString + " does not exist");
} //
```

Since I may do the body of the loop `this.size` times, I'd call this
an O(n) algorithm.

```
int findInSortedArray(K key) {
  int lb = 0;
  int ub = this.size;
  do {
    int mid = lb + (ub - lb) / 2;
    int ordering = key.compareTo(this.values[mid.key]);
    if (ordering < 0) {
      ub = mid - 1;
    }
    else if (ordering > 0) {
      lb = mid + 1
    }
    else {
      return mid;
    }
  while (lb < ub);
  throw new KeyNotFoundException(key.toString + " does not exist");
} //
```

How do we analyze this? We might note that, at ever repetition, the distance
between lb and ub halves. Presuming all the parts of the loop are constant
time, we can do this in O(logn).

Analyzing loops
---------------

Often, we turn algorithmic loops into what I'd call "analysis loops".
Our loop (or loops) will compute the running time on a particular input, 
rather than anything directly related to the original algorithm.

```
int count = 0;
while (n > 1) {
  n = n/2;
  count++;
}
```

```
int count = 0;
for (int i = n; i > 0; i = i/2) {
  count++;
}
```

Analyzing these kinds of loops can be useful.

```
int count;
for (int i = 0; i < n; i++) {
  for (int j = 0; j < n; j++) {
    count++
  }
} // for

How does the value of `count` relate to `n`?  It's in O(n^2). For each
`i`, it runs `n` time. There are `n` repetitions of the outer loops, so
this will be n*n.

```
int count;
for (int i = 0; i < n; i++) {
  for (int j = 0; j < i; j++) {
    count++;
  } // for
} // for
```

How does the value of `count` relate to `n`? It's n(n+1)/2 which is
approximately n*n/2, which is "a constant times n^2". This is also
O(n^2).

```
int count;
for (int i = 1; i <= n; i *= 2) {
  for (int j = 0; j < i; j++) {
    count++;
  } // for
} // for
```

Is this O(2.5^n) O(n^2), O(nlogn), O(n), O(logn), O(1) or ...?

It's definitely O(n^100). We want a closer bound.

A more formal definition
------------------------

