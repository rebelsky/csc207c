---
title: "Eboard 18 (Section 1): Sorting, continued"
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
* Another exercise in writing loop invariants: Dutch national flag
* Insertion sort and its analysis
* Selection sort and its analysis
* Divide and conquer as an algorithm design strategy
* Merge sort
* Quicksort
* Can we do better?

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
  (listen or make), journal, read, spend time in nature, etc.
* Take care of yourself: Prioritize sleep, eat nutritious food, move
  your body, etc.
* Reach out to your emotional supports: family, friends, mentors,
  coaches, healthcare professionals, faculty, etc.
* Attend campus support events this week
* Take advantage of campus wellness activities, like therapy dogs

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

* Tuesday, 2024-11-05, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table: AI for Archaeology_
* Thursday, 2024-11-07, 4:00--5:00 p.m., Science 3821.
  _CS Extras: ???_
* Sunday, 2024-11-10, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_

#### Cultural

* Weekends of November 16 and November 23, Roberts Theatre.
  _Pity_ (also peer)
    * Get tickets at the box office.
* Saturday, 2024-11-16, 2:00--4:00 p.m. (but there's an intermission).
  _Grinnell Symphony Orchestra plays Mozart's symphony number 40._

#### Multicultural

* Friday, 2024-11-08, Global Living Room.
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

### Administrative

**After Sam finishes grading SoLAs, will he send out another of those 
amazing reports?**

> Yes.

**Will Sam spend the extra time analyzing tokens**

> Perhaps you will get a report without tokens and then a followup report
  with tokens.

**Grading is a good path to destressing, Sam.**

> Thanks for the advice.

**Did you write a script to make the reports?**

> Yes. 

**What language did you use?**

> Perl.

**Snarky comment on Sam.**

> -10 tokens to someone.

**Can SoLA 8 appear today so that I can stress about SoLA problems rather 
than about the election?**

> Yes. When I find a free hour.

### Sorting

**Why does `Arrays.sort()` use merge sort to sort arrays of objects? Is
  it because of the runtime complexities in all cases is $$O(nlogn)$$? If
  so, why would we use any other sort unless we can get to linear?**

> Because it's one of the few $$O(nlogn)$$ algorithms that is stable. 

> Note also that it doesn't use merge sort; it uses a variant of merge sort.

> Remember that there are constant multipliers that Big-O ignores. So
  another $$O(nlogn)$$ algorithm might be better. Also, as I noted, insertion
  sort can be much faster on a mostly-sorted array.

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

> For example, if we are sorting people by last name, and we've already
  sorted them by first name, a stable sorting algorithm will ensure that
  they are now sorted by last and first name.

> Here's another example, suppose we are sorting letters that have some
  hidden extra information. We want to maintain the order.

> Input: A1, Q1, Q2, B1, Q3, A2, B2, C1, F1, D1, Q4

> We want Q1 to be before Q2, Q2 to stay before Q3, and Q3 to stay before Q4
  in the sorted array.

**Can you give a concrete example of when you might need a stable
sorting algorithm?**

> Consider a situation in which we can only compare individual fields
  of a compound object. Suppose we want to sort people by name (separated
  into first name and last name). If we sort by first name and then by
  last name, our elements will be in order by the complete name (provided
  the sorting algorithm is stable).

**What are some specific strategies to ensure stability?**

> It depends on the sorting algorithm. In general, when you are swapping
  elements, don't swap equal elements.

> In selection sort, when there are multiple equal "smallest" elements 
  to select, select the first.

> In insertion sort, if you're inserting from the right, stop when you
  reach an equal element, inserting the element after the equal element.

> In merge sort, if you have equal elements in the two subarrays, take
  an element from the left subarray before the right subarray.

> In Quicksort, you're generally screwed. Quicksort is not stable.

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

> "Loose" analysis: We run the outer loop O(logn) times. We run the inner
  loop O(n) times at worst (when `i` is `n`). We know that we can bound
  nested loops by multiplying worst case for each loop, so we get O(nlogn).

> "Tight" analysis. Let's look at what happens with the inner loop.

> When i is 1, the inner loop adds 1. 
  If n were 1, the sum would be 1.

> When i is 2, the inner loop adds 2. 
  If n were 2, the sum would be 1 + 2 = 3.

> When i is 4, the inner loop adds 4. 
  If n were 4, the sum would be 3 + 4 = 7.

> When i is 8, the inner loop adds 8. 
  If n were 8, the sum would be 7 + 8 = 15.

> When i is 16, the inner loop adds 16. 
  If n were 16, the sum would be 15 + 16 = 31.

> So the total running time is 1 + 2 + 4 + 8 + 16 + ... + n/2 + n. (Assuming
  n is a power of 2).

> Can you come up with a formula for that sum? You may try examples.

> Yes, the pattern is $$2n - 1$$.

> So this algorithm is actually $$O(n)$$. That is our tight bound.

What process should we use for finding the big-O bound?

> For recursive algorithms, write a recurrence relation and then solve it.

> For a loose bound for iterative algorithms, count the times each loop
  runs (with nested loops) and multiply them.  If there are multiple 
  non-nested loops within the algorithm, add them.

> For a tight bound, play with it. Try some examples. Look for patterns.
  Often, we express the inner loop as a formula and see what happens.

> This is math; it may require experimentation and creativity.

> Practice.

Invariants review
-----------------

Loop invariant: A condition that is true about the state of the system
at the beginning of the loop body and then again at the end of the loop
body.

Ideally, it's true before we start the loop. (We must organize the system
to guarantee that.) Showing that the loop invariant holds at the end of
each path through the body ensures that the invariant holds when the loop
terminates (provided we've shown it terminates).

The ability to break things in the middle of the loop body is important.

Loop invariants exercise: Dutch national flag
---------------------------------------------

Given an array of values that are classified as red, white, or blue,
*rearrange* (in place) them so that all the reds are at the beginning,
then all the whites, then all the blues.

Some things wil be known to be red, some will be known to be white, some
will be known to be blue, and some will be unprocessed.

Our loop will grab some unprocessed element and rearrange the array (hopefully
in constant time) to restore the invariant.

What invariant might you choose?

```text
The RWBU invariant.
+---------+-------------+-------------+-----------+
|  Red    |   White     |   Blue      |Unprocessed|
+---------+-------------+-------------+-----------+
          |             |             |
          r             w             b

For all i < r, Red.holds(a[i]).
For all i >= r, i < w, White.holds(a[i])
For all i >= w, i < b, Blue.holds(a[i])
```

```text
The RWUB invariant
+---------+-------------+-------------+-----------+
|  Red    |   White     | Unprocessed |   Blue    |
+---------+-------------+-------------+-----------+
          |             |             |
          r             w             b
```

What loop does this suggest? That is, what does your loop body look like
so that you maintain the invariant?

```
    +---------+-------------+----------+--------------+
    |  Red    |   White     |   Blue   | Unprocessed  |
    +---------+-------------+----------+--------------+
              |             |          |
              r             w          b

    while (b < n) {
      if Red.holds(a[b]) {
         +---------+-------------+----------+---------------+
         |  Red    |   White     |   Blue   |R Unprocessed  |
         +---------+-------------+----------+---------------+
                   |             |          |
                   r             w          b
         swap(a, r, b)
         +---------+-------------+----------+---------------+
         |  Red    |R  White     |   Blue   |W Unprocessed  |
         +---------+-------------+----------+---------------+
                   |             |          |
                   r             w          b
         r++;
         +-----------+-----------+----------+---------------+
         |  Red     R| White     |   Blue   |W Unprocessed  |
         +-----------+-----------+----------+---------------+
                     |           |          |
                     r           w          b
         swap(w, b);
         +-----------+-----------+----------+---------------+
         |  Red     R| White     |W  Blue   |B Unprocessed  |
         +-----------+-----------+----------+---------------+
                     |           |          |
                     r           w          b
         ++w;
         ++b;
         +-----------+-------------+----------+-------------+
         |  Red     R| White      W| Blue    B|Unprocessed  |
         +-----------+-------------+----------+-------------+
                     |             |          |
                     r             w          b
      } else if White.holds(a[b]) {
         +---------+-------------+----------+---------------+
         |  Red    |   White     |   Blue   |W Unprocessed  |
         +---------+-------------+----------+---------------+
                   |             |          |
                   r             w          b
         swap(a, w, b)
         +---------+-------------+----------+---------------+
         |  Red    |   White     |W  Blue   |B Unprocessed  |
         +---------+-------------+----------+---------------+
                   |             |          |
                   r             w          b
         w++;   // Since we don't use the value of w here, we can do pre or post
         b++;
         +---------+---------------+----------+-------------+
         |  Red    |   White      W| Blue    B|Unprocessed  |
         +---------+---------------+----------+-------------+
                   |               |          |
                   r               w          b
      } else if Blue.holds(a[b]) {
         +---------+-------------+----------+---------------+
         |  Red    |   White     |   Blue   |B Unprocessed  |
         +---------+-------------+----------+---------------+
                   |             |          |
                   r             w          b
        b = b + 1;
         +---------+-------------+------------+-------------+
         |  Red    |   White     |   Blue    B|Unprocessed  |
         +---------+-------------+------------+-------------+
                   |             |            |
                   r             w            b
      }
    } // while
    At the end
         +--------------+------------------+-----------------+
         |  Red         |   White          |   Blue          |
         +--------------+------------------+-----------------+
                        |                  |                 |
                        r                  w                 b
```

Why do post increment?

> Becuse the C programmer in me wants to write things like `swap(a, w++, b++)`.

Note: The RWUB version never does more than one swap, so is likely faster.

Analysis of DNF:

* Loop that runs n times.
* Each time through the loop, we do a few increments and a few swaps
* So the overall running time of DNF is $$O(n)$$

Insertion sort and its analysis
-------------------------------

Key idea: Divide the array into two parts, one of which is sorted and the
other of which is unprocessed. We then repeatedly move elements from the
unprocessed part into the sorted part.

+-----------------+-------------------------------+
|    Sorted       |     Unprocessed               |
+-----------------+-------------------------------+
```

It will be easiest if we process the first element in unprocessed.

```
public static void insertSort(int[] values) {
  // Invariant
  //  +-----------------+-------------------------------+
  //  |    Sorted       |?    Unprocessed               |
  //  +-----------------+-------------------------------+
  //                    i  
  // For all j < i-1, values[j] < values[j+1]
  for (int i = 1; i < values.length; i++) {
    insert(values, i); // Insert the value at position i into the left subarray
    //  +-------------------+-----------------------------+
    //  |    Sorted         |   Unprocessed               |
    //  +-------------------+-----------------------------+
    //                      i+1
  } // for
} // insertionSort
```

During insert, the sorted part may be unsorted.

```text
+---+---+---+---+---+---+---+
| 4 | 8 | 1 | 5 | 0 | 7 | 3 |
+---+---+---+---+---+---+---+
```

Initially

```text
+---+---+---+---+---+---+---+
| 4 | 8 | 1 | 5 | 0 | 7 | 3 |
+---+---+---+---+---+---+---+
    |
    i=1
```

Insert the value at position 1.

```text
+---+---+---+---+---+---+---+
| 4 | 8 | 1 | 5 | 0 | 7 | 3 |
+---+---+---+---+---+---+---+
    |
    i=1
```

8 is already in the correct place, so we've finished the insert and can
increment `i`.

```text
+---+---+---+---+---+---+---+
| 4 | 8 | 1 | 5 | 0 | 7 | 3 |
+---+---+---+---+---+---+---+
        |
        i=2
```

Insert the value at position 2.

1 is less than 8. We swap.

```text
+---+---+---+---+---+---+---+
| 4 | 1 | 8 | 5 | 0 | 7 | 3 |
+---+---+---+---+---+---+---+
        |
        i=2
```

We're still in the middle of the insertion. We have to compare 1 to 4.

1 is less than 4. We swap.

```text
+---+---+---+---+---+---+---+
| 1 | 4 | 8 | 5 | 0 | 7 | 3 |
+---+---+---+---+---+---+---+
        |
        i=2
```

1 is in the first spot, there's nothing else to compare to, we've inserted.
Increment `i`.

```text
+---+---+---+---+---+---+---+
| 1 | 4 | 8 | 5 | 0 | 7 | 3 |
+---+---+---+---+---+---+---+
            |
            i=3
```

Loose analysis of insertion sort

* The outer loop is repeated n times.
* Insert takes O(n) steps.
* $$n * O(n)$$ is $$O(n^2)$$

Tighter analysis

* The first insert takes at worst 1 swap.
* The second insert takes at worst 2 swaps.
* The third insert takes at worst 3 swaps.
* The n-1st insert takes at worst n-1 swaps.
* The total running time is 1 + 2 + 3 +  ... + n-1.
* The magic formula/analysis says this is $$n*(n-1)/2 = n^2/2 - n/2$$
* Damn, it's still $$O(n^2)$$.

Selection sort and its analysis
-------------------------------

_Skipped_

Key idea:

Invariant:

Divide and Conquer
------------------

We have two $$O(n^2)$$ sorting algorithms. As computer scientists, we
ask ourselves "can we do better"? We also ask ourselves "how can we do
better"?

A good general strategy for writing better algorithms: Divide and conquer.

Model: Break the input up into two (or more) halves. Solve the problem on
one or more halves, combine the results.

Broadly: Break the array into two halves, recursively sort the two halves,
combine the results.

Note: How we break the array into two halves affects how we combine the
results.

Merge sort and its analysis
---------------------------

Key idea: Divide and conquer positionally.

How do we get from 

```
+--------------------+---------------------+
|       Sorted       |       Sorted        |
+--------------------+---------------------+
```

to

```
+------------------------------------------+
|               Sorted                     |
+------------------------------------------+
```

More concretely. Given the following, how do we combine the two halves
into a sorted array

```text
                |
+---+---+---+---+---+---+---+---+
| 1 | 4 | 5 | 8 | 0 | 3 | 7 | 8 |
+---+---+---+---+---+---+---+---+
                |
```

Compare the first element of each subarray

```text
                |
+---+---+---+---+---+---+---+---+
| 1 | 4 | 5 | 8 | 0 | 3 | 7 | 8 |
+---+---+---+---+---+---+---+---+
  *             | *
```

0 < 1, so we use the right subarray. We'll copy that 0 into a new array.
and move on to the next element in the right subarray.

```text
+---+---+---+---+---+---+---+---+
| 1 | 4 | 5 | 8 | 0 | 3 | 7 | 8 |
+---+---+---+---+---+---+---+---+
  *             |     *

+---+---+---+---+---+---+---+---+
| 0 |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
```

Compare the 1 and the 3. We copy the 1 and advance the left.

```text
+---+---+---+---+---+---+---+---+
| 1 | 4 | 5 | 8 | 0 | 3 | 7 | 8 |
+---+---+---+---+---+---+---+---+
      *         |     *

+---+---+---+---+---+---+---+---+
| 0 | 1 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
```

Compre the 4 and the 3. Copy the 3 and advance the right.

```text
+---+---+---+---+---+---+---+---+
| 1 | 4 | 5 | 8 | 0 | 3 | 7 | 8 |
+---+---+---+---+---+---+---+---+
      *         |         *

+---+---+---+---+---+---+---+---+
| 0 | 1 | 3 |   |   |   |   |   |
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

