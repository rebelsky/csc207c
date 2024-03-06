---
title: "Eboard 20: Analyzing recursive procedures"
number: 20
section: eboards
held: 2024-03-06
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia
* Questions
* Review of our loop problem from last class
* A more formal definition of Big-O
* Analyzing recursive procedures

Preliminaries
-------------

* Looking ahead: You will be getting your sleep disrupted this weekend.
* The new tokens assignment is posted. I'm working on copying things
  over from the old tokens assignment.
* Sorry that grading is so slow. I'm trying!
* MP6 will be coming out tomorrow. Sorry for the delay.

### Upcoming work

* Wednesday, 2024-03-06, 11pm, [MP5](../mps/mp05)
    * [_Submit MP5 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180584/)
* Friday, 2024-03-08, 1pm, Readings
    * [The Java Tutorial: Lambda expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions)
    * Review [Priority Queues](../readings/priority-queues).
* Friday, 2024-03-08, 11pm, Third set of LAs.
* Friday, 2024-03-08, 11pm, MP5 post-reflection
* Friday, 2024-03-08, 11pm, MP6 pre-reflection
* Sunday, 2024-03-10, 11pm, [MP1](../mp1) redo
    * [_Submit MP1 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180612/)
    * Please don't submit until it's ready for grading.
* Sunday, 2024-03-10, 11pm, [MP2](../mp2) redo
    * [_Submit MP2 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180615/)
    * Please ask if you're confused about something.

### Tokens

Academic/Scholarly

* Thursday, 2024-03-07, 11:00 a.m.,JRC 101.
  _Scholars' Convocation: An American Genocide: The United States and 
   the California Indian Catastrophe, 1846-1873_
* Thursday, 2024-03-07, 4:00 p.m., Science 3821.
  _CS Extras_.
* Tuesday, 2024-03-12, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-02-12, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.

Cultural

* Thursday, 2024-03-07, JRC 101, 8:00-9:30 pm.
  _Writers@Grinnell: Carl Phillips_
* Friday at 4pm in the Global Living Room.
  _Middle of Everywhere_.
* Saturday, 2024-03-09, Harris Cinema, ??:??
  _Met Opera: Verdi's La Forza del Destino_.
* Saturday, 2024-03-09, 2:00 pm, Sebring-Lewis.
  _ZAWA!_ (Flute concert).

Peer

* Thursday--Saturday, 2024-03-07 to 2024-03-09, 7:30 p.m.
  _Songs of the Scarlet and Wayback_ (play).
    * Tickets go "on sale" tomorrow at noon.
    * Thursday is a "pre-view" performance.
* Friday, 2024-03-08, 4:00--6:00 p.m. Art Museum
  _Women's Day Presentations_.
* Saturday, 2024-03-09, Field House.
  _Men's and Women's Tennis vs. Central._

Wellness

* Wednesday, 2024-03-06, 4pm, JRC 101.
  _Intimacy Stages_.
* Friday, 2024-03-08, noon, JRC 101.
  _Wellness Bingo_.
* Tuesday, 2024-03-12, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-03-12, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-03-12, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

### Other good things to do (no tokens)

Questions
---------

### Administrative

How do you know Sam has read the requests for tokens?

> He hasn't.

When will we know?

> Some day. By the end of break.  I cancelled MP6 to give you some (slack) 
  teams.  Give me some, too.

### MP5

Do I have to modify `AAC.java`?

> No. But you may want to read it.

What's the hidden assumption in `getCategory`?

> You'll return the empty string for the top-level category.

AAC.java doesn't seem to handle exceptions. What should we do?

> Ignore them?

> Let it crash (or print the exception to a terminal).

Where should I add the `try/catch` clause to handle the exceptions
in `AssociativeArray`?

> Probably in `AACCategory.java` and `AACMappings.java`.

The specs are inconsistent. What should I do?

> Whatever you think is better.

### Other topics

One more loop to count
----------------------

```
int count;
for (int i = 1; i <= n; i *= 2) {
  for (int j = 0; j < i; j++) {
    count++;
  } // for
} // for
```

Is this O(2.5^n) O(n^2), O(nlogn), O(n), O(logn), O(1) or ...?

It's definitely O(n^100) or O(n!) or O(2^n). We want a tighter bound.

One analysis:

* The outer loop runs O(logn) times.
* At worst, the inner loop runs O(n) times.
* If each time we run the outer loop, we have the worst case of the
  inner loop, that will be O(nlogn).

Some experimental notes:

* When n is 1: 1
* When n is 2: 3 = 1 + 2
* WHen n is 3: 3
* When n is 4: 7 = 1 + 2 + 4
* When n is 5: 7
* WHen n is 6: 7
* When n is 7: 7
* When n is 8: 15 = 1 + 2 + 4 + 8
* When n is 16: 31 = 1 + 2 + 4 + 8 + 16
* When n is 32: 63 = 1 + 2 + 4 + 8 + 16 + 32

What's the pattern? When n is a power of 2 (2^k), it's the next power
of two minus 1. (2^(k+1) - 1). 2n-1. Which is in O(n)

* When n is 2048: 4095

A more formal definition of Big-O
---------------------------------

A function, f(n) is in O(g(n)) iff exists c > 0, n_0 > 0, such that, for all
n greater than n_0, f(n) <= c*g(n).

Example, we know that f(n) = n is in O(g(n)) where g(n) = 2n-1.

Let c = 1, let n_0 = 5.  Is n < 2n-1 for n > 5?  

* n <= 2n-1
* iff 0 <= n - 1
* iff 1 <= n

Parsing the original

* `<=` : "is bounded above above"
* `c*g(n)` : a constant times g(n); "something with the same shape as
  g(n)"
* `n > n_0` : "for sufficiently large input

Another way to think of Big-O.

f(n) is in O(g(n)) iff exists a constant, d, s.t., lim as n approaches
infinity of |f(n)/g(n)| <= d.

Why have Big-O?
---------------

* Informal usage: Lets us bound algorithms.
* Formal definition: Lets us prove things about how we can use the notation.
    * If f(n) is in O(q*g(n)), where q is a constant, f(n) is also in O(g(n)).
        * We can ignore leading constants. O(2n) = O(n) = O(1/2 * n) = O(1000n).
    * If f(n) is in O(g(n) + h(n)) and g(n) is in O(h(n)), then
      f(n) is in O(h(n))
        * We can throw away lower-order terms. E.g., if f(n) is in O(n^2 + 2n),
          then f(n) is also in O(n^2).
    * If f(n) is in O(g(n)) and g(n) is in O(h(n)), then f(n) is in O(h(n)).
        * Transitive property.

Analyzing recursive algorithms
------------------------------

We will write a lot of recursive algorithms. Some recursive algorithms
are difficult to make iterative. So we should analyze them directly.

We start by developing a recurrence relation. I.e., a set of equations
or inequalities that tell us about the running time of our function.

* T(1) = 1.
* T(n) = 2T(n/2) + n

Is T(n) in O(n)? O(n^2)? O(logn)? ...

Goal: Turn T(n) into a non-recursive formula.

(At least) four approaches:

* Substitution
    * Top-down
    * Bottom-up
* Draw a recursion tree
* The poorly named "master method". Express according to a particular
  form and then plug into a formula.

_Side note: This is why faculty give quizzes and reading reflections._

Back to our example up approach.
* T(1) = 1.
* T(n) = 2T(n/2) + n

Bottom-up (much like what we did for the loop)>

* T(1) = 1
* T(2) = 2*T(1) + 2 = 2*1 + 2 = 4 = (2*2)
* T(4) = 2*T(2) + 4 = 2*4 + 4 = 12 = (3*4)
* T(8) = 2*T(4) + 8 = 2*12 + 8 = 32 = (4*8)
* T(16) = 2*T(8) + 16 = 2*32 + 16 = 80 = (5*16)
* T(2^k) = (k+1)*(2^k)

Let n = 2^k. That means that k = log_2(n)

* T(n) = (log2n+1)*n = O(nlog2n + n) = O(nlog2n) = O(nlogn)

Top-down approach (substitution)

* T(m) = 2T(m/2) + m

Analysis 

* _T(n) = 2T(n/2) + n._
    * T(n/2) = 2T(n/4) + n/2
* T(n) = 2*(2T(n/4) + n/2) + n
* T(n) = 4*T(n/4) + n + n 
* _T(n) = 4*T(n/4) + 2n_
    * T(n/4) = 2T(n/8) + n/4
* T(n) = 4*(2T(n/8) + n/4) + 2n
* T(n) = 8T(n/8) + n + 2n
* _T(n) = 8T(n/8) + 3n_
    * T(n/8) = 2*T(n/16) + n/8
* T(n) = 8*(2*T(n/16) + n/8) + 3n
* T(n) = 16*T(n/16) + n + 3n
* _T(n) = 16*T(n/16) + 4n_

We see a pattern. Maybe. Something involving 2^k.

* T(n) = (2^k)*T(n/2^k) + kn.

Let n = 2^k.

* T(n) = n * T(n/n) + log_2(n)*n
* T(n) = n * T(1) + log_2(n)*n
* T(n) = n * 1 + log_2(n)*n
* T(n) = n + log_2(n)*n
* T(n) is in O(nlogn).

Third option: Pictures! (See whiteboard)

* Each level of the tree requires O(n) work.
* There are O(logn) levels.
* There is therefore O(nlogn) total work.

Which of these is best?

* Each of us responds differently.

Practice
--------

### First problem

* T(n) = 2T(n/2) + 1
* T(1) = 1

Solution

* T(n) is in O(n)

Bottom-up approach

   * T(1) = 1
   * T(2) = 3
   * T(4) = 7
   * T(8) = 15
   * T(16) = 31

Second problem

* T(n) = T(n/2) + n
* T(1) = 1

Third problem

* T(n) = T(n/2) + 1
* T(1) = 1
