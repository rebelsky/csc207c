---
title: "Eboard 29: Sorting competition"
number: 29
section: eboards
held: 2024-04-10
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Rules for the sorting competition
* Sorting competition

Preliminaries
-------------

* It's "April Absurdity" (following "March" Madness)
* Friday's class will be a consideration of ethics.  Make sure to do the
  reading in advance.
* Our graders ask that you
    * Ensure that all files are uploaded to Gradescope.
    * Include a link to your GitHub repo in your README.md file.
    * Include that README.md file.
* We'll look at some of the submissions for MP6

### About MP8

* Still under development.
* Intended to be straightforward.

Key ideas

* Extended DLLs to add a dummy node and circular linking. DO NOT DELETE
  THE DUMMY NODE!
* Reflect on how that made the code easier/harder.

Implement "fail fast" iterators

* Issue: If we have multiple "live" iterators on the same list, and one
  changes the list, the others are now in a somewhat "unknown" state.
* At present, we only notice when something goes wrong.
* We should make sure that an iterator breaks _immediately_ if any other
  iterator has changed the list (when any of the methods are called). 
  Throw an "InvalidStateException".
* The iterator that changed the list does NOT break.
* How can one iterator tell when another iterator changed the list?
    * Idea: Have a shared field that keeps track of when the list was
      last changed. If an iterator is older than that, it dies.
    * Should this be a static field?

```
public class SimpleCDLL<T> implements SimpleList<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  Node2<T> dummy;
  int numChanges = 0;

  ...

  public ListIterator<T> listIterator() {
    return new ListIterator<T>() {
      // +--------+------------------------------------------------------
      // | Fields |
      // +--------+

      Node2<T> prev;
      Node2<T> next;
      int numChanges = SimpleCDLL.this.numChanges;

      // +---------+-----------------------------------------------------
      // | Methods |
      // +---------+

      public T add(T val) {
        if (this.numChanges != SimpleCDLL.this.numChanges) {
          throw new InvalidStateException("Iowa");
        }
        ++this.numChanges;
        ++SimpleCLL.this.numChanges;
        this.prev.addNext(val);
        this.position++;
        ; ...
      } 

      public T next() {
      } // next()
    }; // new ListIterator<T>()
  }
} // class SimpleCDLL
```

Observation:

* We don't want the List `numChanges` to be static because it should
  be independent in each list. (Changes to one list don't affect the
  other.)
* We will probably need a field in the anonymous inner iterator class
  to keep track of the number of changes at the time they were created
  and initialize it.

### Upcoming work

* Wednesday, [MP7](../mps/mp07)
    * Group
    * [_Submit MP7 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4324621)
* Thursday, [ACM Code of Ethics](https://www.acm.org/code-of-ethics)
    * [_Submit reading response on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4340822)
* Friday, [MP7](../mps/mp07) post-reflection
    * [_Submit MP7 post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4340795)
* Friday, [MP8](../mps/mp08) pre-reflection
    * [_Submit MP8 pre-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4340797)
* Sunday, 2024-04-14, [MP3](../mps/mp03) redo
    * [_Submit MP3 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4324626)
* Sunday, 2024-04-14, [MP4](../mps/mp04) redo
    * [_Submit MP4 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4324630)

### Tokens

Academic/Scholarly

* Thursday, 2024-04-11, 4pm, HSSC 1231 (the Kernel).
  _CS Poster Session_.
* Tuesday, 2024-04-16, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-04-16, 7:00pm, Science 3819.
  _Mentor Session_.

Cultural

* Today, 2024-04-10, 7:00-9:00pm, Younker Lounge.
  _Eid Celebration_. Food! Sponsored by PSO.
* Thursday, 2024-04-11, 4:15-5:30pm, HSSC S1325
  _Writers@Grinnell_.
* Thursday, 2024-04-11, 8:00-9:30pm, JRC 101
  _Writers@Grinnell_.
* Friday, 2024-04-12, 4:00-5:00pm, HSSC N1170
  _Middle of Everywhere_.
* Saturday, 2024-04-13, 7:00--??:??, Main Quad  (@nepali_grinnellians on instagram for more info)
  _Celebration of Nepali New Year_. Henna, Food, Photo booth.
* Saturday, 2024-04-13, 1:00--5:00, Cleveland Beach.
  _Holi_. Wear white clothes that you want to become more colorful.
  Food. Dye (colors). Dyed cake. Water pistols.
* Saturday, 2024-04-13, 5:00--8:00, JRC 101.
  Desert with VSA.

Peer

Wellness

* Friday, 2024-04-12, 3:00--5:00pm, JRC Courtyard
  _Get Nostalgic_.
* Tuesday, 2024-04-16, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-04-16, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-04-16, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

### Other good things to do (no tokens)

Questions
---------

### Registration

### Administrative

### Lists

### MP7

### MP8

### Other

Preparation for the sorting competition
---------------------------------------

### The process

* We pair off people.
* We ask them (their code) to sort N arrays.
    * The size is big enough that the slowest takes more than 200 milliseconds.
    * The arrays can be already sorted, reverse sorted, completely
      randomized, slightly randomized from sorted, or slightly
      randomized from reverse sorted.
* In the first phase, each person describes their algorithm, how
  they wrote it, and what they learned.
* The top four or so each earn a token.

### What are N and the probabilities?

* We'll talk about N and the probabilities.
* Please read the code in [examples/sorting/SortTools.java](../examples/sorting/SortTools.java)
    * 5 minutes of reading
    * 3 minutes of pairing
    * 5 minutes of discussin

Discussion


Competition
-----------

We don't quite have 32 competitors (and certainly not 68), so we'll
do the best we can.

No, it doesn't get logged here.

We're down to the elite eight.
