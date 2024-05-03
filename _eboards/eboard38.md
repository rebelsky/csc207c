---
title: "Eboard 38: More about heaps"
number: 38
section: eboards
held: 2024-05-01
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Some LAs
* Questions
* A bit more on heaps (plus practice)
* Group work time

Preliminaries
-------------

* I spent all day yesterday grading LAs. So you will get many back after
  class.  We'll go over some notes to help everyone. (I prefer to go
  over notes before returning things for obvious reasons.)
* I will set up all the LAs for May 10 on Saturday.
* If I can get those graded promptly, I'll set up a set for Tuesday, May 14.

### Upcoming work

* Wednesday, 2024-05-01, 11:00pm, MP10
    * [_Submit MP10 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4405216/)
* Thursday, 2024-05-02, 11:00pm, More Reading on Graphs. 
* Friday, 2024-05-03, 11:00pm, MP10 post-reflection.
    * [_Submit MP10 post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4405177)
* Friday, 2024-05-03, 11:00pm, New set of LAs, repeated + old LAs
* Friday, 2024-05-10, 11:00pm, New set of LAs, repeated + old LAs

### Tokens

* Thursday, 2024-05-02, 11am, JRC 101.
  _PBK Scholars' Convocation: Cathleen Kaveny on "Can We Be Civil? Prophetic Indictment and Call-Out Culture in American Public Life"._
* Tuesday, 2024-05-07, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-05-07, 8:00pm, Science 3819.
  _Mentor Session_. Make Elene and Sam happy. Show up to mentor sessions!

Cultural

* Most days, 2024-04-xx and 2024-05-xx, 11am-6pm,
  Grinnell College Museum of Art.
  _BAX 2024_. Shouldn't it be BAE?
* Friday, 2024-05-03, 4:00--5:00pm, HSSC N1170.
  _Middle of Everywhere_ (maybe Lebanon)

Peer

Wellness

* Sunday, 2024-05-05, 10:00am--6:00pm, Mac Field.
  _Bubble Soccer_. (It takes almost as long as cricket!)
* Friday, 2024-05-10, 5:00pm--??:??pm, Merrill Park West.
  _CS Picnic!_ Survey forthcoming.

Misc

* Thursday, 2024-05-02, 4:15--5:30pm, Burling 1st.
  _Conversation with Kathryn Mohrman '67._
* Thursday, 2024-05-02, 8:00--??:??pm, HSSC Atrium (?).
  _Dessert with trustees._
* Saturday, 2024-05-04 (aka "Star Wars Day"), 10:00am--11:00pm, Central Campus.
  _The Grinnellian._

### Other good things to do (no tokens)

* Saturday, 2024-05-04 (aka "Star Wars Day"), 1:00--3:00pm, Softball Complex.
  _Softball vs. Lawrence_.
* Saturday, 2024-05-04 (aka "Star Wars Day"), 3:00--5:00pm, Softball Complex.
  _Softball vs. Lawrence_.
* Sunday, 2024-05-05, 1:00--3:00pm, Softball Complex.
  _Softball vs. Illinois_.

### Other questionable things (no tokens)

* Saturday, 2024-05-04 (aka "Star Wars Day"), noon--5:00pm, Cleveland Beach.
  _Alice in Wonderland_.

LAs
---

I got through all of the algorithms LAs, all the development LAs, and
some of the ADT/DS LAs. 

Most of the 0's I saw were very close to 1's. They just needed a bit of
correction or extension to show me that you'd mastered the LO.  Here
are things that will help you do better.

* Please put both code and commentary in the top box. The citations
  box is for citations.
* Please take the time to anonymize your code.
* It would be nice if you followed coding conventions. (I don't think anyone
  got a 0 for this, but you should follow coding conventions.)
* Please be reasonably specific in your citations. Not "labs" but
  "the lab on binary search" or URL. Not "I found it with Google" but
  a URL.
* I worry that many of you seem to have forgotten everything you learned
  about decomposition in CSC-151. Details follow below.
* Please follow custom and write ranges as lower-bound inclusive,
  upper-bound exclusive. [I'll repeat this a few times.]
    * `(substring str lb ub)`
    * Applies to binary search, merge sort, Quicksort
* Some of you need to work on the clarity of your high-level explanations.
  I don't need a description of every step. Your goal is a few sentences
  that give someone a high-level understanding of the algorithm.
* Please don't ask me to follow links to judge your answers. With 1500+
  LAs to grade, I need everything in one place.

### Algorithms 1: Binary Search

* Make sure your algorithm is correct.
* Make sure you explain the inputs and outputs.
* Please follow custom and write ranges as lower-bound inclusive,
  upper-bound exclusive.

### Algorithms 2: Sequential Search

* "Find smallest" is not usually what we'd call a sequential search
  algorithm, even though it's a sequential algorithm. Searching
  algorithms search for a particular value or one that meets a
  criterion that depends only on that value.

### Algorithms 3: Insertion Sort

* Please make the "insert" in insertion sort explicit in both your
  code (i.e., by writing a separate `insert` procedure) and your
  narrative.

### Algorithms 4: Selection Sort

* Very few people seem to have written an `indexOfSmallest` or
  `indexOfLargest` procedure. Decompose!

### Algorithms 5: Merge Sort

* Please follow custom and write ranges as lower-bound inclusive,
  upper-bound exclusive.

### Algorithms 6: Quicksort

* Some of you used a very different approach to partitioning than we
  discussed. And you had similar bad designs (e.g., using `i` to
  represent the end of the small elements and initializing it to
  something like `low-1`. If you are one of those people, please
  talk to me asap.
* Please follow custom and write ranges as lower-bound inclusive,
  upper-bound exclusive.

### Algorithms 11: Divide and Conquer

* Make sure you clearly explain the basic principles of "divide and
  conquer".

### Algorithms 12: Big-O

* Make sure you understand the "is in" notation and why we use it.

### Development #1: Collaboration

* I need more than "I wrote code with someone else". Please describe
  your process and why it was successful (or how you made it
  successful).

### Development #3: Unit testing

Too few of you include comments in your unit tests. In my experience, you will
forget why you wrote your tests. The comments help us remember.

* Bad: `assertEquals(Expected, Expression);`
* Good: `assertEquals("Message", Expected, Expression)`

I expect to see a mix of tests and explanatory text. The text should explain
what unit testing is and why we use it. It might also describe the tests. The
tests should be sensible, real tests. 

### Development #5: Version control

Please include a git log from a project.

Remember that the log is supposed to show collaboration. That means
there should be more than one committer (or an explanation as to
why there's only one committer).

### Develpoment #6: Code reading

Code reading is more than "there's a for loop here". You should describe
the design decisions embedded in the code and the relation of the class
to a larger ecosystem. (Why did someone create this class?)

The specification says "_Read, understand, **and modify** code that you 
did not write._" I'd like to see appropriate modifications and a 
description of that modification.

### Development #7: Documentation

Central tips:

* Make sure to use Javadoc comments.
* Make sure to use correct spelling.
* Make sure to comment methods, constructors, and fields.
* Make sure that your comments say more than "Helper method".

The following things would be nice, but are not strictly necessary.

* Document parameters and such. (I don't regularly do so, so I won't force 
  you to do so.)
* Put in section separators.
* Include internal comments to explain more confusing parts of code.
* Do not include internal comments that simply restate what the code does. 
  `// Add one to x` above `x++;` does not help the reader and therefore
  just clogs your code.

### Development #9: Use libraries

Please focus on libraries in which you don't know the internals.
(That is, don't say "I used Sam's X class.") You've demonstrated
knowledge of using such libraries in the Code Reading LO.

Most of the libraries you've used are from the Java API.

### Development #10: Exceptions

_Signal and recover from errors using exceptions._

Make sure you include an example of throwing an exception.

Make sure you include an example of catching an exception (or
being ready to catch an exception).

Make sure that your recovery is reasonable.

Narrate both.

### ADTs/DSs #1: Lists

Even though Java includes it, `get(int i)` is **not** a core list operation.

### ADTs/DSs #2: Stacks

Here and in other ADTs/DSs, start with the PUM, or at least something
like the PUM. At least the PM. At least the P.

### ADTs/DSs #7: Binary search trees

Bit trees are not BSTs. Neither are heaps.

Please include code for `get` and `set`.

### ADTs/DSs #10: Array-based structures

Make sure to explain why we use arrays in implementations.

Make sure to explain how you are using an array in the implementation.

Make sure to include code that explicitly works with an array.

Questions
---------

### Administrative

When will my MPs be graded?

> I don't know. Stay tuned. 

### MP10

Do we have to deal with nested structures?

> Yes.

Do we really have to deal with unicode?

> No.

Should we enforce the form of real numbers?

> Yes.

Will Java handle the scientific notation?

> Probably.

### LAs

How many chances will we have?

> This Friday (almost everything). Next Friday (everything), 
  Friday the 17th (everything). Maybe some time between the 10th and the
  17th.

### Misc

Could you post a second redo for MP4?

> If you ask me on Teams and then ask again in twelve hours if I haven't
  done so.

Heaps
-----

_TPS: Where were we?_

### Learned

* A heap is a binary-tree data structure used to store comparable values.
* It implements the Priority Queue ADT.
* Heaps are organized according to two properties:
    * Each value is higher-priority than its descendants.
    * The tree is nearly complete; all levels are full, except the last,
      which is aligned to the left.
* To add to a heap, we put an element at the end of the last level and
  then "heap up", swapping with smaller parents.
* To remove from a heap, we remove the top element, put the last element
  at the root, and then "swap down", swapping with the larger of the
  children.
* We store heaps in arrays. That makes it easier to find the parents
  and children.
* Like all priority queue implementations, heaps can be used for
  sorting.

What's left

* Not lab.
* In-place heap sort. With an example.
    * Two versions.

In-place heap sort.

* Turn the array into a heap.
* Repeatedly shift the largest value in the heap to the "end"

How do I turn an array into a heap?

* Option: Put the largest value at the root O(n). Put the second
  largest after it O(n) ... whoops. building the heap will be O(n^2)
* `For (int i = 1; i < n; i++) { heapUp(i); }`  THe loop runs n times.
  heapUp is O(logn). Hence, it's `O(nlogn)`.

How long did it take to pull things out of the heap and put them into
the back end of the array?

* O(nlogn): We have to do every elements (n times). For each element,
  we swap O(1) and then call swapdown O(logn). 

Heap sort: Guaranteed O(nlogn) in-place sorting algorithm

Is it stable? No. Sam said it wasn't. Sam never lies. Better yet, swapping
down is unlikely to preserve order.

What would happen if we gave it an array in ascending order?

* 1|2,3,4,5,6
* 2,1|3,4,5,6
* 3,1,2|4,5,6
* 4,3,2,1|5,6
* 4,5,2,1,3|6
* 5,4,2,1,3|6
* 6,4,5,1,3,2

```
     6
   /   \
  4     5
 / \   /   
1  3  2
```

* 6,4,5,1,3,2
* 5,4,2,1,3|6
* 4,3,2,1|5,6
* 3,1,2|4,5,6

Hmmm ... It's not very good with already-ordered lists.

### One other thing

In practice, people build the heap in a very different way.

```
for (int i = n/2; i >= 0; i--) {
  heapDown(i)
}
```

Think about why that would still build a heap.

