---
title: "EBoard 18: Analyzing algorithms"
number: 18
section: eboards
held: 2023-10-04
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.

_Approximate overview_

* Administrivia
* Questions
* Analyzing algorithms
* Formalizing the notion
* Some practice

Administrivia
-------------

* Rant from Sam
* Don't forget, we do have individual tutors for CSC-207, too.

### Upcoming Token activities

Academic

* CS Extras, Thursday, 4:15 p.m, 3821, Declaring a CS major
    * Hopefully, our Chair will produce a summary.
    * If not, we may also spend a few minutes at the start of the next
      class summarizing what was learned.
    * Pom and Micah can also give you some info on this stuff.

Cultural

Peer

* Soccer Saturday at 1:30

Wellness

Misc

* Thursday is homecoming parade in Grinnell at 5:30 in Central Park.

### Other good things (no tokens)

### Upcoming work

* Thursday: MP4
* Friday: MP4 post-assessment
* Friday: CLRS 2.3, CLRS 3.  Skimming is okay.

Questions
---------

Analyzing algorithms
--------------------

Our goal as programmers / computer scientists is to build algorithms
that (help us) solve problems.  We also build data structures to help
with that.

We generally want to know things about our algorithms, so that we can,
for example, decide which algorithm is best for our particular problem.

We normally think about N things.

* How fast is it? (Based on the size of the input.)
* How much memory does it use? (Based on the size of the input.)
* Is it correct?  (Or which inputs does it work for?)
    * It passes all of our tests.
    * We write (in)formal proofs that our algorithms are correct.
    * As you will learn, checking that an arbitrary proof is correct is
      not computable.

We will be analyzing "speed" and "memory use".

* Two techniques
    * Run a lot of examples and try to fit a curve to them.
    * Model the running time of an algorithm and focus on that.
* We're going to do the latter.
* When modeling, we can be very detailed.
* We will avoid too many details.
* As inputs get large, the shape of the curve matters more than other
  details.
* If algorithm 1 takes 1/1000 * n^2 steps
* And algorithm 2 takes n steps
* Where n is a number that represents the size of the input
* The 1/1000 * n^2 wins on small inputs, but eventually looses.  Badly.

We use a few notations to talk about shape

* Theta(f(n)) - functions that take (approximately) some constant times
  f(n) for sufficiently large input.
* O(f(n)) - functions that are bounded above by some constant times f(n)
  for sufficiently large input.

We generally consider only a few classes of functions.

* O(1) - Those bounded above by a constant (constant-time functions).
* O(logn) - Log n: Those that increase their running time by a constant each
  time you double the size of the input.
* O(n) - Linear: Those who running time depends linearly on the size of the input
* O(nlogn) - NlogN
* O(n^2) - Quadratic
* O(n^3) ...
* O(2^n) - Exponential algorithms
* O(n!)

When designing algorithms, we usually care only about these asymptotic
bounds.

When choosing what algorithm to use for a program we're building, we
usually fall back onto what someone has given us in a library.

Or ... we think carefully about the input and choose one best suited
to the input.

Some constant-time algorithms/functions?

* Almost every basic operation we treat as constant time.
* Including `car`, `cdr`, array references.

Some linear-time algorithms/functions

* Get the nth element of a linked list
* Shift elements in an array (n is the size of the array)

Figuring out the running time of an iterative algorithm
-------------------------------------------------------

* Normal process: 
   * Look at each loop (inside out).
   * Count the number of times the loop runs.
   * Count the number of steps in the loop.
   * Multiply the two.

```
for (i = 0; i < n; i++) {
  pen.println(lst.valueAt(i));
}
```

* The loop runs _n_ times
* `lst.valueAt` takes _i_ time (where `lst` is a linked list)
* `pen.println` takes _1_ time
* So, we multiply ___  times (___ + ____)

Two approaches:

* Assume that `lst.valueAt` is always O(n).
    * O(n * (n + 1)) = O(n^2 + n) = O(n^2)
    * Note that we can throw away lower-order terms in big-O notation.
* Use a slightly different approach, don't multiply n, but instead
  add up all the steps.
    * 1 + 2 + 3 + 4 + ... n/2 + .... n-3 + n-2 + n-1 + n
    * That sum is n*(n+1)/2 which is Theta(n^2) (also O(n^2)).
* Yay!  Both give us the same answer.

Binary search, conceptually

* Input: Sorted array of values, a value we're looking for
* Output: Either the index of the value, if it's in the array
  or -1 if it's not in the array.

```
while (there are elements left to process) {
  look at the middle element (using a comparator)
  if the middle element is equal to the sought value, 
    return its index
  if the middle element is larger than the sought value, 
    throw away everything larger (including the middle element)
  otherwise the middle element is smaller than the sourght value,
    throw away everything smaller (including the middle element)
}
```

* "Look at the middle element" - constant time
    * Find the index - constant time
    * Look at that location - constant time
* Return its index - constant time
* Comparing the middle element to the sought value - Constant time
* Throw away half the array
    * Depends on we do it.
    * If we copy to a new array, linear
    * If we keep track of the lower-bound and upper-bound of the
      portion of interest, it's constant time

How many times does this loop run?  (in terms of n)

Consider the example in which n is 1000; you can approximate.

* 1000 -> 500 -> 250 -> 125 -> 63 -> 32 -> 16 -> 8 -> 4 -> 2 -> 1
* 11 steps.

Consider the example in which n is 2000; you can approximate.

* 12 steps (just one more step and we're down to 1000)

Consider the example in which n is 4000; you can approximate.

* 13 steps (just one more step).

Algorithms in which you add a constant number of steps when you double
the size of the input are ... logn

Formalizing the notion
----------------------

A function f(n) is in O(g(n)) iff there exist values n0 and c, such that
for all n > n0, f(n) <= c*g(n).

* The `<=` is "f(n) is bounded above by"
* The `c` is "ignoring constant multipliers"
* The `for all n > n0` represents for sufficiently large inputs

A function f(n) is in Theta(g(n)) iff there exist values n0, b, and c, such that
for all n > n0, b*g(n) <= f(n) <= c*g(n).

Some exercises
--------------

What is `result` in the following?

```
result = 0;
for (i = 1; i < n; i = i*2) {
  result + i;   // Models a case in which the stuff inside the loop takes O(i)
}
print result;
```

Hypotheses about result

* O(1) - nope, I see an increase
* O(logn) - nope, I don't see a constant increase when doubling.
* O(nlogn) - ??? 

Analysis

* Suppose n is 10
   * 1 + 2 + 4 + 8 = 15
* Suppose n is 20
   * 1 + 2 + 4 + 8 + 16 = 31
* Suppose n is 40
   * 1 + 2 + 4 + 8 + 16 + 32 = 63
* Suppose n is 80
   * 1 + 2 + 4 + 8 + 16 + 32 + 64 = 127
* Suppose n is 100
   * 1 + 2 + 4 + 8 + 16 + 32 + 64 = 127

Is this O(1), O(logn), O(n), O(n log n), ...?

It's O(n), linear

1 + 2 + 4 + 8 + 16 + ... + 2^k = 2^(k+1)-1 = 2*2^k

* k=0: 1 (2)
* k=1: 3 (4)
* k=2: 7 (8)
* k=3: 15 (16)
* k=4: 31 (32)
* k=5: 63
* k=6: 127
* k=7: 255
* k=8: 511
* k=9: 1032
* k=10: 2063
* k=11: 4127

```
result = 0;
for (i = 1; i < n; i = i+1) {
  result += i; // Models a case in which the stuff inside the loop takes O(i)
}
print result;
```

1 + 1/2 + 1/4 + 1/8 + 1/16 + 1/32 + .... + 1/2^k = something a little less than 2. 
