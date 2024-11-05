---
title: "Eboard 18 (Section 2): Sorting, continued"
number: 18
section: eboards
held: 2024-11-05
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* Loop invariants, revisited
* Insertion sort and its analysis
* Another exercise in writing loop invariants: Dutch national flag
* Selection sort and its analysis [optional]
* Divide and conquer as an algorithm design strategy
* Merge sort
* Quicksort [optional]

Preliminaries
-------------

### News / Notes / Etc.

* We're doing another talk day. Sometimes talk days are better than
  lab days. At least they get you to think in a different way.
* New office hour approach: Use the Outlook scheduling assistant to 
  schedule 15-minute or 30-minute appointments. I'll generally say yes 
  to requests during the day for times that I'm not booked..
* Reminder that today is election day in the US. If you are eligible
  to vote in the US and have not yet voted, remember that (a) you should
  vote and (b) you can register to vote in Iowa today.
* If you've had difficulty connecting with your partner for MP7, please
  let me know asap.

### Strategies for coping with added stress

_Adapted from my colleague, Nicole Eikmeier._

* Consider limiting your screen time.
* Engage in activities that nourish you: podcasts (non-political), music 
  (listen or make), journal, read, spend time in nature, hang with friends, etc.
* Take care of yourself: Prioritize sleep, eat nutritious food, move
  your body, etc.
* Reach out to your emotional supports: family, friends, mentors,
  coaches, healthcare professionals, faculty, etc.
* Attend campus support events this week
* Take advantage of campus wellness activities, like therapy dogs
* Focus on your homework (added by SamR after comments from section 1)

### Upcoming work

* Tuesday, 2024-11-05
    * Nothing?
* Wednesday, 2024-11-06
    * Lots of readings on lists
        * [List ADTs](../readings/list-adts)
        * [Lists with "current" considered harmful](http://csis.pace.edu/~bergin/papers/ListsWithCurrent.html)
        * Skim [Documentation for java.util.List](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html)
        * Skim [Documentation for java.util.ListIterator](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ListIterator.html)
        * [List iterators](../readings/list-iterators)
        * [Doubly-linked lists](../readings/doubly-linked-lists)
    * [Submit reading responses for class 19](https://www.gradescope.com/courses/818402/assignments/5270104) "How long did you spend?" "Do you have any questions?"
* Thursday, 2024-11-07
    * [Submit Mini-project 7](https://www.gradescope.com/courses/818402/assignments/5247567)
* Friday, 2024-11-08
    * [Submit post-reflection for MP7](https://www.gradescope.com/courses/818402/assignments/5247571)
* Monday, 2024-11-11
    * Another SoLA. Sam hopes to have grades on the prior SoLAs ready 
      long before this is due.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Thursday, 2024-11-07, 4:00--5:00 p.m., Science 3821.
  _CS Extras: Decisions Diagrams_
* Sunday, 2024-11-10, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_
* Tuesday, 2024-11-12, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table: TBD_

#### Cultural

* Weekends of November 16 and November 23, Roberts Theatre.
  _Pity_ (also peer)
    * Get tickets at the box office.
* Saturday, 2024-11-16, 2:00--4:00 p.m. (but there's an intermission).
  _Grinnell Symphony Orchestra plays Mozart's symphony number 40._

#### Multicultural

* Friday, 2024-11-08, 4:00--5:00 p.m., Global Living Room.
  _Middle of Everywhere_

#### Peer

#### Wellness

* Tuesday, 2024-11-05, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-11-05, 4:30--6:30 p.m., Secret Place.
  _Forest Bathing_.
* Tuesday, 2024-11-05, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.

#### Misc

* Wednesday, 2024-11-06, Noon--1:00 p.m., JRC 101.
  _Election debrief_.
* Wednesday, 2024-11-06, Noon--1:00 p.m., Whale room.
  _Election therapy_.
* Friday, 2024-11-08, 4:00--5:15 p.m., Somewhere.
  _Election analysis_.

### Other good things (no tokens)

Questions
---------

### Registration and related stuff

**Will preregistering for two CS courses increase our chance of getting 
  one CS class?**

> Probably not. But we haven't done the full game-theoretical analysis.
  PM suggests that you should only preregister for two CS classes if you
  want two CS classes.

> Note that I'm not counting 208 as a CS class.

**How likely is it that second-year students will get two CS classes?**

> Not very likely.

**How likely is it that third-year students will get two CS classes?**

> Fairly likely.

**Can I enroll in two sections of the same CS course?**

> Nope.

**Can I preregister for CSC-105?**

> Sure.

**How does declaration of major and selection of advisors work in CS?**

> For equity issues, we have everyone declare at the same time (more or less).

> In early spring, we'll have a CS Extras in which each faculty member
  taking advisees will discuss their advising approaches.

> You will then provide a ranked list of advisors along with some additional
  information (e.g., whether you are planning a double major).

> The Chair will run some software that attempts to provide a reasonably
  fair match.

**Is Sam taking advisees?**

> Yes. 

> However, I will be on leave (in Grinnell) next year.

### Administrative

**After Sam finishes grading SoLAs, will he send out another of those 
amazing reports?**

> Yes.

**Will Sam spend the extra time analyzing tokens**

> Perhaps you will get a report without tokens and then a followup report
  with tokens.

**Grading is a good path to de-stressing, Sam.**

> Thanks for the advice.

**Did you write a script to make the reports?**

> Yes. 

**What language did you use?**

> Perl.

**Can SoLA 8 appear today so that I can stress about SoLA problems rather 
than about the election?**

> Yes. When I find a free hour. Probably by 7pm or so.

**Do you know when mini-projects will be graded?**

> No.

**Do you know when mini-project redos will be posted?**

> No.

### Sorting

**Why does `Arrays.sort()` use merge sort to sort arrays of objects? Is
  it because of the runtime complexities in all cases is $$O(nlogn)$$? If
  so, why would we use any other sort unless we can get to linear?**

> Because it's one of the few $$O(nlogn)$$ algorithms that is stable. 

> Note also that it doesn't use merge sort; it uses a variant of merge sort.

> Remember that there are constant multipliers that Big-O ignores. So
  another $$O(nlogn)$$ algorithm might be better. Also, as I noted, 
  insertion sort can be much faster on a mostly-sorted array.

> Also: `Arrays.sort` uses Quicksort for many types.

> > The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm offers O(n log(n)) performance on all data sets, and is typically faster than traditional (one-pivot) Quicksort implementations. <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html#sort(int%5B%5D)>

**How does divide-and-conquer lead to a more efficient sorting algorithm?**

> The time analysis tells us that it's more time efficient. Experiments 
  confirm the theory.

> More concretely, by splitting the array in half each time, we limit the 
  number of elements we compare each element to.

### Stability

**Can you explain what 'stable' means?**

> It means that the sorting algorithm preserves the order of equal elements. 

> Here's an example, suppose we are sorting letters that have some
  hidden extra information. We want to maintain the order.

> Input: A1, Q1, Q2, B1, Q3, A2, B2, C1, F1, D1, Q4

> We want Q1 to be before Q2, Q2 to stay before Q3, and Q3 to stay before Q4
  in the sorted array.

> For example, if we are sorting people by last name, and we've already
  sorted them by first name, a stable sorting algorithm will ensure that
  they are now sorted by last and first name.

**Can you give a concrete example of when you might need a stable
sorting algorithm?**

> Consider a situation in which we can only compare individual fields
  of a compound object. Suppose we want to sort people by name (separated
  into first name and last name). If we sort by first name and then by
  last name, our elements will be in order by the complete name (provided
  the sorting algorithm is stable).

> Sorted by first name

> ```
    Audry Smith
    Bishop Jones
    Charlie Davidson
    Devon Jones
    Echo Jones
    Fern Davidson
    Gabe Smith
```

> Sort by last name, preserving order

> ```
    Charlie Davidson
    Fern Davidson
    Bishop Jones
    Devon Jones
    Echo Jones
    Audry Smith
    Gabe Smith
```

**What are some specific strategies to ensure stability?**

> It depends on the sorting algorithm. In general, when you are swapping
  elements, don't swap equal elements.

> In selection sort, when there are multiple equal "smallest" elements 
  to select, select the first.

> In insertion sort, if you're inserting from the right, stop when you
  reach an equal element, inserting the element after the equal element.

> In merge sort, if you have equal elements in the two subarrays, take
  an element from the left subarray before the right subarray.

> In Quicksort, you're generally screwed. In-place Quicksort is not 
  stable.

> At times, stability is something we have to analyze after we've
  completed the algorithm. That is, we check if the algorithm is stable
  and, if not, we see which instructions break stability and whether we
  can revise them to ensure stability.

### Merge sort

**Why does merge sort need a new array?**

> Because no one has found a way to merge two halves of one array in place.

### Quicksort

**When would Quicksort worst case $$O(n^2)$$ happen so that we know when
  to not use it?**

> If the pivot chosen is always the largest or smallest element, Quicksort
  will be $$O(n^2)$$. We can avoid this by making a sensible pivot choice.

> We generally cross our fingers and assume that we'll choose good pivots.

**In Quicksort, why do we need to move the pivot to the front? Isn't it
  easier to choose the element in the middle to be the pivot, and do the
  swapping process until the left pointer >= right pointer?**

> You're not guaranteed to have equal numbers of elements on the left and
  the right. So what happens when you reach the pivot if it's in the middle?

How would you pick a random element from a list to use in Quicksort? With
an array, I think you'd generate a random number within the index range
of the array, but lists are not indexed.

> You could accept that it takes $$O(n)$$ time to find the pivot. In the
  analysis, an extra $$O(n)$$ doesn't affect the asymptotic running time.

**Is there a way to make Quicksort iterative?**

> Yes, you can make any recursive algorithm iterative.

> The general strategy is to simulate the recursive call stack.

> We may discuss more after we've covered Quicksort.

### Miscellaneous

**I'm still quite confused with the difference between the `Comparable`
  and `Comparator` interfaces.**

> A `Comparator` is a function object that compares two other objects. 
  It provides the `compare(T obj1, T obj2)` method.

> A `Comparable` is an object that can compare itself to similar
  objects. It provides the `compareTo(T other)` method.

> For example, `Integer` objects are comparable because there's a natural
  way to compare integers for order (from smallest to largest).

> If, instead, we wanted to compare integers by their absolute value,
  we'd need to create a `Comparator`.

> Since people have no natural ordering (I hope), we would use `Comparator`
  objects to compare people according to some criterion (e.g., height,
  distance of home from our classroom)

**Can you help me do a tight bound on the following loop?**

```java
count = 0;
for (i = 1; i < n; i = i*2) {
  for (j = 1; j <= i; j++) {
    ++count;  
  } // for j
} // for i
```

> Sure.

> Loose bound technique: Count the number of times the outer loop runs;
  Count the worst case of number of times the inner loop runs for each 
  instance of the outer loop. Multiply.

> Outer loop is O(logn)

> Inner loop is O(n)

> Loose upper bound is O(nlogn).

> Tight bound technique: Do much more careful counting.

> Think of the inner loop as just computing `count += i`.

> When i is 1, the inner loop runs one time.
  The total cost for n of 1 is therefore 1.

> When i is 2, the inner loop runs 2 times.
  The total cost for n of 2 is therefore 1 + 2 = 3.

> When i is 4, the inner loop runs 4 times.
  The total cost for n of 4 is therefore 3 + 4 = 7.

> When i is 8, the inner loop runs 8 times.
  The total cost for n of 8 is therefore 7 + 8 = 15.

> When i is 16, the inner loop runs 16 times.
  The total cost for n of 16 is therefore 15 + 16 = 31.

> The pattern (based on n): 2n-1.

> $$2n-1 \in O(nlogn)$$. But we have a tighter bound (not $$O(n^2logn)$$.

> Central things for tight bounds: Drop constant multipliers; drop
  lower-order terms. The constant multipler is 2, the lower-order
  term is -1, so it's in $$O(n)$$.
  
**What process should we use for finding the big-O bound?**

> For recursive algorithms, write a recurrence relation and then solve it.

> For a loose bound for iterative algorithms, count the times each loop
  runs (with nested loops) and multiply them.  If there are multiple 
  non-nested loops within the algorithm, add them.

> For a tight bound, play with it. Try some examples. Look for patterns.
  Often, we express the inner loop as a formula and see what happens.

> This is math; it may require experimentation and creativity.

> Practice.

**Why is the outer loop O(logn)?**

> Pattern of outer loop. i = 1. i = 2. i = 4. i = 8. ... i = n/2. i = n.

> We want to count how many times we doubled i.

> Fortunately, there's a mathematical formula for "the number of times you
  have to double 1 to get n" (alernately, the number of times you have to
  divide n by 2 to get 1). It's log2(n).  

> log2(n) and log(n) are equivalent
  in Big-O terms.

Loop invariants review
-----------------------

A loop invariant is a statement about the state of the program.

If they are true before the execution of the body of a loop, they should
be true at the end of the body of the loop.  

Ideally, the invariant is a *useful* statement. In fact, if we know the
loop terminates, the invariant should tell us that the loop has achieved
its goal.

We can write invariants as text, as drawings, as mathematical statements.

Insertion sort and its analysis
-------------------------------

Key idea of in-place insertion sort: Split the array into two parts.
The first part is a sorted version of the first `i` elements; the
other part contains the remaining (unprocessed) elements.

Invariant:

```text
+-------------------+-----------------------------+
|     Sorted        |     Unprocessed             |
+-------------------+-----------------------------+
                    |
                    i
```

We want to write insertion sort using this invariant.

```
public static void insertionSort(int[] ints) {
  // +-------------------+-----------------------------+
  // |     Sorted        |     Unprocessed             |
  // +-------------------+-----------------------------+
  //                     |
  //                     i
  for (i = 1; i < n; ++) {
    // +-------------------+-----------------------------+
    // |     Sorted        |X    Unprocessed             |
    // +-------------------+-----------------------------+
    //                     |
    //                     i
      
    // Insert X into the appropriate place in Sorted
    //   ...

    // +---------------------+---------------------------+
    // |     Sorted (inc. X) |   Unprocessed             |
    // +---------------------+---------------------------+
    //                       |
    //                       i+1
  } // for
} // insertionSort
```

Is the invariant true throughout the body of the loop? While we're looking
for the correct place to put the element, the sorted portion may become
unsorted.

Example:

```text
+---+---+---+---+---+---+---+
| 8 | 1 | 2 | 7 | 7 | 0 | 7 |
+---+---+---+---+---+---+---+
```

Initially

```text
+---+---+---+---+---+---+---+
| 8 | 1 | 7 | 2 | 7 | 0 | 7 |
+---+---+---+---+---+---+---+
    |
    i=1
```

Insert the 1

1 is less than 8, so we swap with the 8.

```text
+---+---+---+---+---+---+---+
| 1 | 8 | 7 | 2 | 7 | 0 | 7 |
+---+---+---+---+---+---+---+
    |
    i=1
```

1 is at the left border, so we can't do anything else. We're done inserting.

Increment i

```text
+---+---+---+---+---+---+---+
| 1 | 8 | 7 | 2 | 7 | 0 | 7 |
+---+---+---+---+---+---+---+
        |
        i=2
```

Insert 7

7 is less than 8, so we swap

```text
+---+---+---+---+---+---+---+
| 1 | 7 | 8 | 2 | 7 | 0 | 7 |
+---+---+---+---+---+---+---+
        |
        i=2
```

7 is not less than 1, so we're done inserting. Increment i

```text
+---+---+---+---+---+---+---+
| 1 | 7 | 8 | 2 | 7 | 0 | 7 |
+---+---+---+---+---+---+---+
            |
            i=3
```

Insert the 2. Is 2 less than 8? Yes. Swap.

```text
+---+---+---+---+---+---+---+
| 1 | 7 | 2 | 8 | 7 | 0 | 7 |
+---+---+---+---+---+---+---+
            |
            i=3
```

Does the invariant hold? No. But that's okay.

Is 2 less than 7? Yes. Swap.

```text
+---+---+---+---+---+---+---+
| 1 | 2 | 7 | 8 | 7 | 0 | 7 |
+---+---+---+---+---+---+---+
            |
            i=3
```

Is 2 less than 1? No. Stop. Increment i.

```text
+---+---+---+---+---+---+---+
| 1 | 2 | 7 | 8 | 7 | 0 | 7 |
+---+---+---+---+---+---+---+
                |
                i=4
```

Is 2 less than 1? No. Stop. Increment i.

### Analysis of insertion sort

Loose analysis: Outer loop runs n times; inner loop could be as bad as n-1. $$O(n^2)$$

Tight analysis: The first instance of the inner loop runs 1 time. The second runs two times. The third runs three times. ... THe last one runs n-1 times.

1 + 2 + 3 + ... + n-1.

Formula: $$n(n-1)/2 = n^2/2 - n/2 \in O(n^2)$$. Damn.

Loop invariants exercise: Dutch national flag
---------------------------------------------

The Dutch national flag consists of three stripes, red, white, and blue.
Suppose we have a collection of values. Each value can be red, white, or
blue. We want to rearrange them (in place) so they are in the order
all the reds, then all the whites, then all the blues.

We're going to have a section of reds, a section of whites, a section of blues, and an unprocessed section.

```text
+------------+-------------+-------------+-------------+
|   Red      |   White     |   Blue      |XUnprocessed |
+------------+-------------+-------------+-------------+
             |             |             |             |
             r             w             b             n
```

```text
+------------+-------------+-------------+-------------+
|  Red       |   White     |XUnprocessed |   Blue      |
+------------+-------------+-------------+-------------+
             |             |             |             |
             r             w             b             n
```

Goal: Get the first remaining unprocessed element into the right section
in constant time. If it's constant time, our DNF algorithm will be $$O(n)$$.

What loop does this suggest? That is, what does your loop body look like
so that you maintain the invariant?

RWUB invariant

```
int r = ...;
int w = ...;
int b = ...;
while (b < n) {
  // +------------+-------------+-------------+--------------+
  // |  Red       |   White     |   Blue      |X Unprocessed |
  // +------------+-------------+-------------+--------------+
  //              |             |             |              |
  //              r             w             b              n
  if A[b] is Red 
    // +------------+-------------+-------------+--------------+
    // |R Red      R|W  White    W|B  Blue     B|R Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    swap(A, r, w);
    // +------------+-------------+-------------+--------------+
    // |R Red      R|B  White    W|W  Blue     B|R Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    swap(A, r, b)
    // +------------+-------------+-------------+--------------+
    // |R Red      R|R  White    W|W  Blue     B|B Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    r++;
    w++;
    b++;
    // +--------------+-------------+-------------+------------+
    // |R Red      R R| White    W W| Blue     B B|Unprocessed |
    // +--------------+-------------+-------------+------------+
    //                |             |             |            |
    //                r             w             b            n
  else if A[b] is White 
    // +------------+-------------+-------------+--------------+
    // |  Red       |   White     |B  Blue      |W Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    swap(A, w, b);
    // +------------+-------------+-------------+--------------+
    // |  Red       |   White     |W  Blue      |B Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    w++;
    b++;
    // +------------+---------------+-------------+------------+
    // |  Red       |   White      W| Blue       B|Unprocessed |
    // +------------+---------------+-------------+------------+
    //              |               |             |            |
    //              r               w             b            n
  else // if A[b] is Blue
    // +------------+-------------+-------------+--------------+
    // |  Red       |   White     |   Blue      |B Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    b++
    // +------------+-------------+---------------+------------+
    // |  Red       |   White     |   Blue       B|Unprocessed |
    // +------------+-------------+---------------+------------+
    //              |             |               |            |
    //              r             w               b            n
} // while
  // +------------+-------------+-------------+
  // |  Red       |   White     |   Blue      |
  // +------------+-------------+-------------+
  //              |             |             |              |
```

Selection sort and its analysis (if time)
-----------------------------------------

_Skipped_

Key idea:

Invariant:

Divide and Conquer
------------------

We've seen two O(n^2) sorting algorithms: insertion sort and selection sort.

When faced with an algorithm, a computer scientist should ask "Can I do better?"

One strategy: Divide and conquer. Divide the input into two (or more) parts. Recursively solve the problem for some or all of the parts. Combine the solutions.

The combination will depend upon how we divide (and our goals).

Divde-and-conquer sorts will divide the input in half, recurse on each half, and then combine.

The combination will depend upon how we divide.

Merge sort and its analysis
---------------------------

Key idea: Divide and conquer, using positions to determine the middle.

```text
+---+---+---+---+---+---+---+---+
| 1 | 2 | 7 | 8 | 7 | 0 | 7 | 3 |
+---+---+---+---+---+---+---+---+
```

Magically sort both halves.

```text
+---+---+---+---+---+---+---+---+
| 1 | 2 | 7 | 8 | 0 | 3 | 7 | 7 |
+---+---+---+---+---+---+---+---+
```

Combine those into one sorted array. Create a new array. Add "pointers"
to the current position in each subarray. Copy appropriately and advance
pointers.

```text
+---+---+---+---+---+---+---+---+
| 1 | 2 | 7 | 8 | 0 | 3 | 7 | 7 |
+---+---+---+---+---+---+---+---+
  *               *

+---+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
```

0 is smaller than 1, copy the 0, advance the right pointer.

```text
+---+---+---+---+---+---+---+---+
| 1 | 2 | 7 | 8 | 0 | 3 | 7 | 7 |
+---+---+---+---+---+---+---+---+
  *                   *

+---+---+---+---+---+---+---+---+
| 0 |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
```

1 is smaller than 3, copy the 3, advance the left pointer.

```text
+---+---+---+---+---+---+---+---+
| 1 | 2 | 7 | 8 | 0 | 3 | 7 | 7 |
+---+---+---+---+---+---+---+---+
      *               *

+---+---+---+---+---+---+---+---+
| 0 | 1 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
```

2 is less than 3, copy the 2, advance the left pointer.

```text
+---+---+---+---+---+---+---+---+
| 1 | 2 | 7 | 8 | 0 | 3 | 7 | 7 |
+---+---+---+---+---+---+---+---+
          *           *

+---+---+---+---+---+---+---+---+
| 0 | 1 | 2 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
```

Quicksort
---------

Key idea:

Some spare arrays
-----------------

```text
+-------------------------------------------------+
|                                                 |
+-------------------------------------------------+
```

```text
+---+---+---+---+---+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+---+---+---+---+
```

```text
+---+---+---+--   --+---+---+---+--   --+---+---+
|   |   |   | . . . |   |   |   | . . . |   |   |
+---+---+---+--   --+---+---+---+--   --+---+---+
```

