---
title: "Eboard 17 (Section 2): Sorting"
number: 17
section: eboards
held: 2024-10-31
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* About MP7
* Questions
* About loop invariants
* A exercise in writing loop invariants: Exponentiation, revisited

Preliminaries
-------------

### News / Notes / Etc.

* Happy halloween!
* Grab some candy (or not, as you desire).
* I will not charge tokens for a late reading for class 16 (provided
  you have it in by now), since we were just getting back from break.
* Don't forget to stop your clock for an hour at 1am on Sunday.

### Planning for CS next semester

#### Background: Grinnell's CS Major Requirements

* CSC-151, CSC-161, and CSC-207 (you should have after this class)
* Math appropriate for the discpline
    * MAT/CSC-208 (requires CSC-151 and MAT-131) or 
      MAT-218 (requires MAT-215)
    * One more math or statistics class above 131 creditable to
      the math major. Typically MAT-133 or STA-209.
* Systems ("under the hood class"): CSC-211 or CSC-213
* Algorithm Analysis: CSC-301
* Software Design: CSC-324
* Theory of Computation: CSC-341
* Elective (could be the other CSC-211/CSC-213, CSC-261, CSC-262,
  CSC-395, ...)

#### Recommendations

* If you don't have the "8" math requirement (208 or 218), you should
  probably take it in the spring.
* CSCC-211 (Organization and Architecture) is the natural next class 
  for second-year students. 
* CSC-324 Software Design - An extension of the "build a project"
  stuff we've doing.
* CSC-301 Algorithm Analysis.
* CSC-261 Artificial Intelligence.

#### Questions

### Upcoming work

* Thursday, 2024-10-31
    * No lab writeup! It's a talk day.
    * [Mini-project 7](../mps/mp07) assigned. (Details soon.)
* Sunday, 2024-11-03
    * [Submit pre-reflection for MP7](https://www.gradescope.com/courses/818402/assignments/5247569)
* Monday, 2024-11-04
    * [Merge sort](../readings/mergesort)
    * [Quicksort](../readings/quicksort)
    * [Submit reading-responses for class 18 (divide-and-conquer sorting)](https://www.gradescope.com/courses/818402/assignments/5247699/)
    * [SoLA 7](../los/sola07)
        * New algorithms LAs
            * [Algorithms #1: Binary search](https://www.gradescope.com/courses/818402/assignments/5247749)
            * [Algorithms #2: Sequential search](https://www.gradescope.com/courses/818402/assignments/5247751)
        * Algorithms LAs from (Optional) SoLA 6
            * [Algorithms #12: Big-O notation](https://www.gradescope.com/courses/818402/assignments/5247707)
            * [Algorithms #13: Analysis of iterative algorithms](https://www.gradescope.com/courses/818402/assignments/5247708)
            * [Algorithms #14: Analysis of recursive algorithms](https://www.gradescope.com/courses/818402/assignments/5247710)
       * Repeated LAs can be found in [SoLA 7](../los/sola7)
* Wednesday, 2024-11-06
    * Submit reading responses for class 19
* Thursday, 2024-11-07
    * [Submit Mini-project 7](https://www.gradescope.com/courses/818402/assignments/5247567)
* Friday, 2024-11-08
    * [Submit post-reflection for MP7](https://www.gradescope.com/courses/818402/assignments/5247571)

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Thursday, 2024-10-31, 4:00--5:00 p.m., Science 3821.
  _CS Extras: Advice and Guidance for Pursuing a Career in Data Science 
  or the Tech Industry_
* Sunday, 2024-11-03, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_
* Tuesday, 2024-11-05, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table_

#### Cultural

* Friday, 2024-11-01, 7:30--9:00 p.m., Sebring-Lewis.
  _The Infinite Wrench_.

#### Multicultural

* Friday, 2024-11-01, 4:00-6:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Day of the Dead_ 
* Friday, 2024-11-08, 4:00-5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_

#### Peer

* Thursday, 2024-10-31, 4:00-6:00 p.m., CRSSJ.
  _Lending Library Trick or Treat Event_.

#### Wellness

* Friday, 2024-11-01, Noon--1:00 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Yoga_.
* Tuesday, 2024-11-05, 4:00--5:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.
* Tuesday, 2024-11-05, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-11-05, 4:30--6:30 p.m., Secret Place.
  _Forest Bathing_.

#### Misc

### Other good things (no tokens)

About Mini-Project 7
--------------------

Write a game. Use a matrix as the board. Use good OO-design. Make it
configurable.

Your partner is your partner from today's class. (Yes, we will eventually 
partner up.)

Questions
---------

### Administrative

### Readings

#### Searching

**Can you go over the running time/analysis for the linear and binary 
  searches again?**

> Yup.

**When is it worth the time spent sorting the array in order to make binary 
  search possible vs when should we just use linear search?**

> If we're only doing a few searches, linear search wins. But if
  we're doing a lot of searches (say, more than the number of elements
  in the array), sorting first wins.

**If we build the array so that it ends up sorted, does that make it any
  quicker?**

> Building a sorted array bit by bit is effectively the same as out-of-place 
  sorting. Hence, it won't be better than a good sorting algorithm.

#### Big-O

**Should we understand the formal definition of Big-O?**

> Yes. The formal definition lets us reason about various aspects of
  Big-O, such as "we can ignore constants" and "we can ignore lower-order
  terms".

**Is it better to be able to analyze algorithms or should we memorize?**

> It's better to be able to analyze. However, if you are going to job
  interviews (or just don't want to embarrass yourself in front of your
  faculty) you should memorize the running times of key algorithms.

**Should we be able to do space analsis?**

> It would be nice. But it's the same concept.

**Can you go over tight Big-O again?**

> Yup. 

**Can we use the master theorm in the SoLA because it was in the textbook?**

> Only if you can prove the master theorem. (So probably not.)

> You can use it to check your work, but I'd prefer that you show another
  mechanism (practice is good and develops intuition).

#### Loop invariants

**I'm not sure that I understand what a loop invariant is.**

> We'll go over loop invariants today.

> In short, a loop invariant is a logical statement about the state of
  the system.

> We expect it to be true at the start of each trip through the body
  of the loop.

> We should ensure that it is true again at the end of each trip through
  the body of the loop.

> We also want it to say something useful (related to our goals).

**In real-world programming, how often do developers formally define
  loop invariants? Are they mainly a teaching tool, or do they find
  use in practical coding?**

> Loop invariants regularly find use in situations in which people
  need to ensure that their code is correct, such as when writing
  mission-critical software.

#### Comparing elements

**Should it always be the case for our Comparator objects that if A
  precedes B and B precedes C, then A precedes C?**

> Yes, we must be able to assume that our `Comparator` objects are
  transitive. In fact, the specification of `java.util.function.Comparator`
  requires it.

**What can we do if this is not the case?**

> We may not be able to tell. But sorting is not necessarily
  meaningful if you have a non-transitive comparator.

**Since `Comparable<T>` is used with objects that have an implied
  natural order, do integers and characters implement that `Comparable`
  interface?**

> Yes, `Integer` implements `Comparable<Integer>` and `Character` 
  implements `Comparable<Character>`

**Is there a way to add an order to existing classes, thereby having them 
  implement `Comparable`?**

> Unless we have access to the code for the underlying class, we
  can't directly make them implement `Comparable`. In such cases, we
  are better off writing a `Comparator` for those objects. We could
  potentially subclass the objects and make the subclass implement
  `Comparable`, but that is likely to be less elegant.

#### Choosing a sorting algorithm

**If one sorting algorithm is known to be more efficient than
  another, then why do we learn multiple different algorithms?**

> Different sorting algorithms work better or worse in different conditions.
  For example, insertion sort works very well on a mostly-sorted array.

> There's also the experience of thinking about different ways to solve the
  same problem.

**What is an ideal use case for insertion sort and selection sort?**

> Insertion sort works well with mostly-sorted arrays.

> Selection sort can be useful when you only need part of a sorted array.

**In which situations would selection sort be preferred over insertion sort, given their similar time complexities?**

> Having the same theoretical complexity does not mean that the running time is the same. Remember that Big-O ignores constant multipliers. So a particular implementation of selection sort might be faster than a particular implementation of insertion sort, even though both have the same Big-O.

> In situations in which we want to start processing the "smaller" elements before the sorting is complete, selection sort is preferred.

#### Sorting, general

**When implementing a sorting algorithm, what are some specific strategies 
  to ensure stability?**

> That's a great question. Pay attention to the locations when
  you're swapping elements and make sure that you never swap equal
  elements.

**Can insertion sort be done not 'in place' since you're always comparing and swapping elements?**

> Insertion sort can be done in place if you're just swapping
  elements. Swapping only pulls one element out of the array at a
  time. You can also do it out-of-place by building a new array bit
  by bit.

> In Scheme,

> ```scheme
(define insertion-sort
  (lambda (lst)
    (if (null? lst)
        null
        (insert (car lst) (insertion-sort (cdr lst))))))
```

**I'm a little confused on selection sort, mainly on how we know
what the smallest remaining element is. Are we just running another
loop during which we iterate the array checking what the smalles
element is? (This seems wrong and very inneficient.)**

> Yes, finding the smallest remaining element requires iterating
  the remaining elements. It's not particularly efficient, but it's 
  not horrible.

**What are some real-world examples where stability in sorting algorithms is crucial?**

> The basic Excel sort mechanism has to be stable since there's an
  assumption that if  you sort by column B and then by column A, things
  are effectively sorted by A+B.

**Are there specific guidelines or best practices for choosing between
  in-place vs. out-of-place sorting implementations in Java?**

> Nope. It depends on the problem you're working with. Functional programmers prefer out-of-place sorting algorithms because they are referentially pure. But in-place sorting algorithms save space.

### Miscellaneous

About loop invariants
---------------------

Concept: Think carefully about the state of the system 

Benefits: 

Loop invariants exercise: Exponentiation, revisited
---------------------------------------------------

We had an exponentiation algorithm using repeated multiplication. 

To compute $$x^n$$, that algorithm required .... 

A computer scientist should always ask "Can we do better?"

