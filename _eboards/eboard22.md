---
title: "Eboard 22: Searching"
number: 22
section: eboards
held: 2024-03-11
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia [??]
* Questions [??]
* Lab [??]

Preliminaries
-------------

* Greetings on the celebration of the revealing of the Quran
* I hope that you are recovering okay from the time changes.
* For reasons I will discuss, I will not be in class on Wednesday. You
  will have a sub.

### Upcoming work

* Monday, 2024-03-10, 11pm, [MP5](../mps/mp05)
    * [_Submit MP5 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180584/)
* Tuesday, 2024-03-12, 11pm, MP5 post reflection
* Wednesday, 2024-03-13, Readings
    * [Sorting](../readings/sorting)
    * [Merge sort](../readings/mergesort)
* Friday, 2024-03-15, 11pm, Third set of LAs.
    * Mostly posted. 
    * Let me know if any look wrong.
    * Let me know if you'd like to see any others posted.
    * Grading is still on my priority queue, near the front.

### Tokens

Academic/Scholarly

* Tuesday, 2024-03-12, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-02-12, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.

Cultural

* Friday at 4pm in the Global Living Room.
  _Middle of Everywhere_.
    * I don't know whether or not that's happening.

Peer

* Friday at 7pm, Nepali students association celebrating Shivaratri
    * RSVP required.
    * Contract your classmate for the link.

Wellness

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

### Searching

### Other topics

Lab
---

### for-each loops

How to do a for-each loop in Java.

```
for (T val : values) {
} // for
```

That's right! There are no indices! (Or indexes!)

### Iterating arrays

Note: Although you can iterate arrays with for-each, they are not
`Iterable` objects.

### Assertions in exercise 3

`assert` and `assertThrows` are not intended to be real procedures.
Rather, they are an indication that you should check that.

For example, `assert(binarySearch(2*i, array) == i)` could be rendered
as

        try {
          int result = binarySearch(2*i, array);
          if (result != i) {
            System.err.println("binarySearch(" + 2*i + ", " + 
              Arrays.toString(array) + ") returned " + result);
          }
        } catch (Exception e) {
          System.err.println("binarySearch(" + 2*i + ", " +
            Arrays.toString(array) + ") threw an unexpected exception");
        } // try/catch

Similarly, `assertThrows(binarySearch(2*i+1, array))` could be rendered as

        try {
          int result = binarySearch(2*i + 1, array);
          System.err.println("binarySearch(" + (2*i+1) + ", " +
              Arrays.toString(array) + ") failed to throw an exception");
        } catch (Exception e) {
        }

### Related LOs

* Algorithm LO#1: Sequential search
* Algorithm LO#2: Binary search

How should I write the code to build all the arrays?


