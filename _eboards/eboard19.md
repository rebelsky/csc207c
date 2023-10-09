---
title: "EBoard 19: Analyzing recursive algorithms"
number: 19
section: eboards
held: 2023-10-06
link: true
---
# {{ page.title }}

**Warning** This class is being recorded and transcribed.  At least I think 
  it is.

_Approximate overview_

* Administrivia
* About MP5
* Our GitHub testing repo
* Summary of yesterday's majors session
* Questions
* Advantages of big-O notation
* Some more practice analyzing iterative algorithms
* Analyzing recursive algorithms
* More practice

Administrivia
-------------

* Happy Friday

### Upcoming Token activities

Academic

* Mentor Session, Sunday, 4pm.

Cultural

Peer

* Soccer Saturday

Wellness

* CS picnic, today, 4pm, Natatorium

Misc

* Second-year spotlight event, today, 4:00-6:30 p.m. in the Kernel 
  or Husk Atrium.
    * Stop by and visit OCS and tell them Sam sent you.
* Fireman's breakfast, Sunday 6am-noon at the firehouse.  Free will donation.
    * I will reimburse you up to $10.

### Other good things (no tokens)

* Volleyball vs. Lawrence Saturday at 1pm (Senior Day).
* Play this weekend.  _Everybody_.  Friday and Saturday
  at 7:30 p.m. in Flanagan.  Sunday at 2:00 also in Flanagan.  Get
  tickets at the box office starting at noon on Thursday.  (Maybe
  before.)  The box office is in Bucksbaum, near the courtyard.

### Upcoming work

* Tonight: MP4 post-assessment
* Sunday night: MP5 pre-assessment
* Monday: Readings on lambda in the Java Tutorial and Priority Queues
* Thursday: MP5

### Friday PSA

* You are awesome.
* I'd like you to be well.
* Think about the legality of what you do.
* Choose what is appropriate for you.
* Consent is essential.

About MP5
---------

* We are writing the back end for an AAC which maps presses on buttons
  to spoken text.
* You get to see what other people's assignments look like.

Our testing repo
----------------

Having a common repo ended up being a good example of what goes wrong
when you have a common repo (and novice GitHub users).  We're going
to talk through some of them.

_Sam: Turn off the recording._

Why do random files get added?

> Because someone typed something like `git add .` or `git add *`,
  rather than the better `git add FILENAME`.

> The other commands sometimes add extra cruft to the repo.

Important note: The `.gitignore` file tells git what *not* to add
when you do something careless like `git add .` (which way too many
guides tell you to do).

_Sam: Turn on the recording._

Some other notes:

* Once you're working with real code and other people, NEVER commit code
  that doesn't run.
* Be careful about putting cruft in the repo.
* Sam needs to teach you about branching.

Summary of yesterday's majors session
-------------------------------------

* What classes are being offered in the future?  See the diagram.
* How do I get an advisor?  We'll have an advisor session in the spring.
  You will attend, hear about our advising philosophy (Sam's is "Make
  fun of your advisees"), fill out a form giving preferences, and cross
  your fingers.
* Your advisor is usually one of the CS faculty (or Sarah Dahlby Albright)
  (or Henry Walker) (or Liz Rodrigues).  Sam will ask Charlie (Our
  department chair, not a tuna with good taste).
* If I've declared another major will I get closed out of classes this
  spring?  Potentially.  I haven't seen the priority list lately for
  things like 211 and 324 lately, but it's something like "CS seniors
  who need this for graduation"; "CS seniors who need some course for
  graduation"; "CS third-years who still need the course"; "Undeclared
  second-years".
    * Concentrations should not affect this.
* Do I have to make a new four-year plan if I declare a second major?
  Every major declaration form needs a four-year plan.  If you saved
  it and it works, you don't need to make a new one.  If you didn't
  save it, you must make a new one or hope your advisor has a copy.

Questions
---------

Advantages of big-O notation
----------------------------

Big-O and Big-Theta are useful notations because they simplify our
descriptions in many ways.

For example, O(n^2 + n) = O(n^2).  You can throw away lower-order terms.

In fact, O(n^2 + 1000n*lgn) = O(n^2).

In addition, we can throw away constant multipliers.  O(100n^2) = O(n^2).

HOWEVER, we have to be careful about when we throw them away; it's usually
after we've developed a formula.

O(f(n)) is a SET of functions (all the functions that are bounded above
by some multiple of f(n) when n is sufficiently large).  So it is appropriate
to say g(n) IS IN O(f(n)) not g(n) is O(f(n)).

Some more practice
------------------

Our goal in assessing/analyzing iterative algorithms is "count the steps".

* Sometimes we count the number of steps within a loop and multiply by
  the number of times the loop runs.
* Sometimes we count the number of steps in each iteration (which varies)
  and add them all up.

```
result = 0;
for (i = 1; i < n; i = i*2) {
  result = result + i;   // Models a case in which the stuff inside the loop takes O(i)
}
print result;
```

For this one, since we spend different "steps" (have a different `i`) each
time through, we use the second technique.  1 + 2 + 4 + 8 + ...

```
result = 0;
for (i = 1; i < n; i = i*2) {
  result = result + 1;   // Models a case in which the stuff inside the loop takes O(i)
}
print result;
```

This time, I do the same amount of work every time (or add the same value
to i each time), so I can multiply the number of times the loop runs by
the work each time through.

Hypothesis one: The loop runs n/2 times, so we should end up with a number
like n/2 for result.

Watch Sam fail at writing C code.

We'll do f(100)

* i = 1, result becomes 1
* i = 2, result becomes 2
* i = 4, result becomes 3
* i = 8, result becomes 4
* i = 16, result becomes 5
* i = 32, result becomes 6
* i = 64, result becomes 7
* i = 128; stop

This function is logarithmic.

If you see something doubling or halving each time through, it's likely
logarithmic (or nlogn).

```
result = 0;
for (i = 1; i < n; i = i*2) {
  for (j = 0; j < n; j++) {
    result = result + 1;   // Models a case in which the stuff inside the loop takes O(i)
  }
}
print result;
```

Suppose n is 100.  What should we see?

Hypothesis: n log n.

Analysis:

* How long does the j loop take: O(n) (or it just adds n)
* The outer loop runs O(log2n) time.
* We multiply the number of times the outer loop runs by the cost
  of the stuff inside the loop.  O(n*log2n)

Analyzing recursive algorithms
------------------------------

Merge sort (in arrays)!  (One of Sam's favorite recursive algorithm examples.)

* If the array is small enough (0 or 1 elements), it's already sorted.
* Otherwise
    * Sort each half with mergesort (trusting the magic recursion fairy)
    * Combine the elements back together into a sorted array

Let's put on our mathematician's hat and write a function T(n) that
says how long merge sort takes on an array of size n.

* T(0) = 0
* T(1) = 1
* T(n) = T(n/2) + T(n/2) + n = 2T(n/2) + n

Can we write T(n) in a closed form (not recursively)?

How do we handle the problem?  Three approaches.

Approach 1: Bottom up

* T(1) = 1
* T(2) = 2*T(1) + 2 = 2 + 2 = 4 (2*2) 2*2^1
* T(4) = 2*T(2) + 4 = 2*4 + 4 = 12 (3*4) 3*2^2
* T(8) = 2*T(4) + 8 = 2*12 + 8 = 32 (4*8) 4*2^3
* T(16) = 2*T(8) + 16 = 2*32 + 16 = 80 (5*16) 5*2^4
* T(32) = 2*T(16) + 32 = 2*80 + 32 = 192 (6*32) 6*2^5

Observation: Each time we double the size we add 1 to first multiplier
and double the multiplicand.  The multiplicand in the last case is
2^5

* T(2^k) = (k+1)*2^k [formula used below]
* If n = 2^k, k is log2n, so T(n) = (log2n+1)*n = nlog2n + n is in O(nlog2n)

That last step again.

* n = 2^k
* We'll take log2 of both sides
* log2(n) = log2(2^k)
* log2(2^k) = k (by the definition of log)
    * log2(m) is the number of times you have to multiply 2 by itself
      to get m.
* T(n) = T(2^k) [because n = 2^k]
* = (k+1)*2^k [by the formula above]
* = (k+1)*n [because 2^k = n]
* = (log2n + 1) * n [because k = log2n]
* = nlog2n + n [by the distributive property]
* in O(nlog2n) [by the definition of O]

We can also try this "top down".

* T(n) = 2*T(n/2) + n
    * Side note: T(n/2) = 2*T(n/4) + n/2 [plugging in n/2 into the formula]
* T(n) = 2*(2*T(n/4) + n/2) + n [substituting T(n/2) into the prior eqn.]
* T(n) = 4*T(n/4) + n + n [Distribution]
* T(n) = 4*T(n/4) + 2n [Combining the n's]
    * T(n/4) = 2*T(n/8) + n/4 [plugging n/4 into the formula]
* T(n) = 4*(2*T(n/8) + n/4) + 2n [Substituting T(n/4)
* T(n) = 8*T(n/8) + n + 2n [Distribution]
* T(n) = 8*T(n/8) + 3n [Combining the ns]

If we think about this in terms of powers of 2

* T(n) = (2^3)*T(n/(2^3) + 3n

Generalize

* T(n) = 2^k*T(n/(2^k)) + kn

Let n = 2^k (or k = log2n)

* T(n) = n*T(n/n) + log2n*n
* T(n) = n*T(1) + (log2n)*n
* T(n) = n*1 + (log2n)*n
* T(n) in O((log2n)*n)


Practice
--------


