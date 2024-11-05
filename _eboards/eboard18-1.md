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
  make)

### Upcoming work

* Tuesday, 2024-11-05
    * Nothing?
* Wednesday, 2024-11-06
    * Lots of readings on lists
        * [List ADTs](../readings/list-adts)
        * [Lists with "current" considered harmful](http://csis.pace.edu/~bergin/papers/ListsWithCurrent.html)
        * [Documentation for java.util.List](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html)
        * [Documentation for java.util.ListIterator](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ListIterator.html)
        * [List iterators](../readings/list-iterators)
        * [Doubly-linked lists](../readings/doubly-linked-lists)
    * [Submit reading responses for class 19](https://www.gradescope.com/courses/818402/assignments/5270104)
* Thursday, 2024-11-07
    * [Submit Mini-project 7](https://www.gradescope.com/courses/818402/assignments/5247567)
* Friday, 2024-11-08
    * [Submit post-reflection for MP7](https://www.gradescope.com/courses/818402/assignments/5247571)
* Monday, 2024-11-11

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

  or the Tech Industry_
* Tuesday, 2024-11-05, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table: AI for Archaeology_
* Thursday, 2024-11-07, 4:00--5:00 p.m., Science 3821.
  _CS Extras: ???_
* Sunday, 2024-11-10, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_

#### Cultural

* Weekend of November 16, Roberts Theatre.
  _Pity_

#### Multicultural

#### Peer

#### Wellness

* Tuesday, 2024-11-05, 4:00--5:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.
* Tuesday, 2024-11-05, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-11-05, 4:30--6:30 p.m., Secret Place.
  _Forest Bathing_.

#### Misc

### Other good things (no tokens)

Questions
---------

### Administrative

### Sorting

**Why does `Arrays.sort()` use merge sort to sort arrays of objects? Is it because of the runtime complexities in all cases is $$O(nlogn)$$? If so, why would we use any other sort unless we can get to linear?**

> Because it's one of the few $$O(nlogn)$$ algorithms that is stable. 

> Note also that it doesn't use merge sort; it uses a variant of merge sort.

> Remember that there are constant multipliers that Big-O ignores. So another O(nlogn) algorithm might be better. Also, as I noted, insertion sort can be much faster on a mostly-sorted array.

> Also: `Arrays.sort` uses Quicksort for many types.

> > The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm offers O(n log(n)) performance on all data sets, and is typically faster than traditional (one-pivot) Quicksort implementations. <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html#sort(int%5B%5D)>

**How does divide-and-conquer lead to a more efficient sorting algorithm?**

> The time analysis tells us that it's more time efficient. Experiments confirm the theory.

> More concretely, by splitting the array in half each time, we limit the number of elements we compare each element to.

### Stability

**Can you explain what 'stable' means?**

> It means that the sorting algorithm preserves the order of equal elements. 

**Can you give a concrete example of when you might need a stable sorting algorithm?**

> Consider a situation in which we can only compare individual fields of a compound object. Suppose we want to sort people by name (separated into first name and last name). If we sort by first name and then by last name, our elements will be in order by the complete name (provided the sorting algorithm is stable).

**What are some specific strategies to ensure stability?**

> It depends on the sorting algorithm. In general, when you are swapping elements, don't swap equal elements.

> In selection sort, when there are multiple equal "smallest" elements to select, select the first.

> In insertion sort, if you're inserting from the right, stop when you reach an equal element, inserting the element after the equal element.

> In merge sort, if you have equal elements in the two subarrays, take an element from the left subarray before the right subarray.

> At times, stability is something we have to analyze after we've completed the algorithm. That is, we check if the algorithm is stable and, if not, we see which instructions break stability and whether we can revise them to ensure stability.

### Merge sort

**Why does merge sort need a new array?**

> Because no one has found a way to merge two halves of one array in place.

### Quicksort

**When would Quicksort worst case $$O(n^2)$$ happen so that we know when to not use it?**

> If the pivot chosen is always the largest or smallest element, Quicksort will be $$O(n^2)$$. We can avoid this by making a sensible pivot choice.

**In Quicksort, why do we need to move the pivot to the front? Isn't it easier to choose the element in the middle to be the pivot, and do the swapping process until the left pointer >= right pointer?**

> You're not guaranteed to have equal numbers of elements on the left and the right. So what happens when you reach the pivot if it's in the middle?

How would you pick a random element from a list to use in Quicksort? With an array, I think you'd generate a random number within the index range of the array, but lists are not indexed.

> You could accept that it takes $$O(n)$$ time to find the pivot. In the analysis, an extra $$O(n)$$ doesn't affect the asymptotic running time.

**Is there a way to make Quicksort iterative?**

> Yes, you can make any recursive algorithm iterative.

> The general strategy is to simulate the recursive call stack.

### Miscellaneous

**I'm still quite confused with the difference between the `Comparable` and `Comparator` interfaces.**

> A `Comparator` is a function object that compares two other objects. It provides the `compare(T obj1, T obj2) method.

> A `Comparable` is an object that can compare itself to similar objects. It provides the `compareTo(T other)` method.

> For example, `Integer` objects are comparable because there's a natural way to compare integers for order (from smallest to largest).

> If, instead, we wanted to compare integers by their absolute value, we'd need to create a `Comparator`.

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

Loop invariants exercise: Dutch national flag
---------------------------------------------

```text
+-------------------------------------------------+
|                                                 |
+-------------------------------------------------+
```

Insertion sort and its analysis
-------------------------------

Key idea:

Invariant:


Selection sort and its analysis
-------------------------------

Key idea:

Invariant:

Merge sort and its analysis
---------------------------

Key idea:

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

