---
title: "EBoard 27: Array-based Lists"
number: 27
section: eboards
held: 2023-11-01
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.
It's probably also being transcribed.

_Approximate overview_

* Administrivia
* Questions
* Lab

Administrivia
-------------

* Happy November!
* Happy NaNoWriMo! (for those who celebrate)

### Upcoming Token activities

Academic

* Mediating Polarizing Debates, TODAY at 4pm in the HSSC Kernel
  (aka "Multipurpose Room", A1231).
* Scholars Convocation, Thursday at 11am in JRC 101. Jarvis Givens
  on "Black Reconstructions: Archival Assembly and the History of
  African American Education"
* CS Extras, Thursday at 4pm.  Side-Channel attacks.

Cultural
* Shift, the Documentary about RAGBRAI, 4:15 pm, Thurday, in the
  HSSC Auditorium.
* An evening of Ukranian Poetry and Music, Thursday, November 2, at
  7:30 pm.

Peer

* Dia De Los Muertos Social, TODAY, 4-6pm, Global Living Room
    * Colada Morada and Pan de Muerto
* Swimming vs. Iowa Central CC, Friday, November 3, at 6pm.
* Football vs. UofC, Saturday, November 4, at noon
* Participate in a psychological experiment.  Only for people who are 
  fluent in one language and a beginner in another.  Talk to your peer
  about how you sign up.
  
Wellness

Misc

### Other good things (no tokens)

### Upcoming work

* Two readings for Friday: List iterators and doubly-linked lists.
* MP6 due Thursday.  
* MP7 assigned Friday.

Brain Dump
----------

In the next five minutes, write down everything you can about lists
(normal, Java), array-based lists, and (list) iterators.

Questions
---------

### Registration

Am I prepared to take CSC-324 if I survive 207?

> Yes.

Am I prepared to take CSC-301 if I survive 301?

> Only if you've also survived 208 or MAT-218.

Can I change my waitlist?

> Yes.  There's a great game theory problem sitting there.

Can we design a new registration system that ensures that everyone in this
class gets exactly what they want?

> No.

Should I read the email from Charlie?

> Yes.

What's the status of CSC-395-02?

> Unknown.  It looks like it won't be ready in round 1, which means that
  approximately 20 CS majors (or proto-CS majors) won't get a CS class
  for the spring.  But then we'll add it, and there will be rejoicing.
  Or at least less crying.  Or at least new crying.

How will we prioritize the new CSC-395-02?

> We don't know.

When will I be able to call myself a CS major?

> Around spring break.

If I don't have 208/218, what CS should I take in the spring?

> CSC-324 or CSC-211.  There are more slots in 324.  But the two 324's may
  be different.  Jimenez will probably teach another data visualization
  version, Perlmutter will probably teach something different, but has
  not determined what.

What happens if I get into both CSC classes in round 1?

> 
  
### MP6

I don't understand the recursive call in merge sort.

> We are sorting the elements between lb (inclusive) and ub (exclusive).

> We find a midpoint.  For example, `mid = lb + (ub - lb)/2`.

> sort(arr, lb, mid); // Sorts the first half

> sort(arr, mid, ub); // Sorts the second half

> merge(arr, lb, mid, ub); // Merge those two halves into the same subarray

How does it merge it with that call?

> First, we merge into a temporary array.

> Then, we copy back into the original array.

How do we create that temporary array?

> Java is evil.

> `T[] temp = java.util.Arrays.copyOf(arr, arr.length);`

Can I find a sorting algorithm on the Interweb and translate it to Java?

> Yes.  Provided you cite it.

Are we better off making arrays of objects and then casting?

> It's what many people do.  These days, I get weird error messages.
  YMMV.

Does Java really use TimSort?

> Sometimes.  It may also use a dual-pivot Quicksort.

Can I write FirstLastSort as a call to Arrays.sort?  

> Sure, but you won't get credit for the assignment.

What's the benefit of using a Dual-Pivot quicksort?

> We tend to get better distribution into the various parts (we're
  almost guaranteed that all of othe three parts are <= 1/2 the
  size of the array).

> Make that your solution to FirstLastSort and then we'll see.

What happens if our own sort is very slow?

> Our competition will be boring.

What fruit for the competition?

> Berries (straw, rasp, apples of pine, )

What will the competition look like?

> Sam will generate a few "sufficiently large" arrays of some sort.

> He will then run two sorting algorithms on all the arrays (perhaps
  multiple times) and then check which spends the least total time

How do we determine how long it takes?

> `System.currentTimeMillis()` before and after the sort.

> VSCode tells you how long a test case took.

How big will the arrays be?

> I will run some experiments to see what is big enough for a reasonable
  competition.

 
### Lists

### Administrative

Lab
---

Experiment with mulitple iterators and the original 
