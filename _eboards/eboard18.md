---
title: "Eboard 18: Big-O"
number: 18
section: eboards
held: 2024-03-01
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed.**

_Approximate overview_

* Administrivia
* Questions
* Review of Wednesday's lab
* Big-O notation and asymptotic analysis
* Alumni visit

Preliminaries
-------------

* It looks like we have about 70 majors in the class of 2026. Welcome to
  the prospective new majors in this class.
    * Even though some of you ranked me as second to last, I will not
      hold that against you. Not everyone thrives in chaos.
* Some of you didn't seem to start MP4 until this Tuesday. I would
  recommend that you start much earlier.
* Happy March!
* We may have an alum visit today.

### Upcoming work

* Friday, 2024-03-01, 11pm, Submit the second set of LAs.
    * _Sorry, no Gradescope links; there are too many_
* Friday, 2024-03-01, 11pm, MP4 post-reflection 
    * [_Submit MP4 post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4136968/)
* Friday, 2024-03-01, 11pm, MP5 pre-reflection
    * [_Submit MP5 pre-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180581/)
* Wednesday, 2024-03-06, 11pm, [MP5](../mps/mp05)
    * [_Submit MP5 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180584/)
* Friday, 2024-03-08, 11pm, Third set of LAs.
* Friday, 2024-03-08, 11pm, MP5 post-reflection
* Friday, 2024-03-08, 11pm, MP6 pre-reflection
* Sunday, 2024-03-10, 11pm, [MP1](../mp1) redo
    * [_Submit MP1 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180612/)
    * Please don't submit until it's ready for grading.
* Sunday, 2024-03-10, 11pm, [MP2](../mp2) redo
    * [_Submit MP2 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4180615/)
    * Please don't submit until it's ready for grading.
    * Please ask if you're confused about something.

### Tokens

Academic/Scholarly

* Tuesday, 2024-03-05, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-02-27, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.

Cultural

* Friday at 4pm in the Global Living Room.
  _Middle of Everywhere_.
* This weekend, The Wall Theatre.
  _Neverland Players_.
    * There are tickets, but there's also a waiting list. Try to get tickets.
    * 12-5pm today for tickets at Bucksbaum Box Boffice.
    * There are about three shows.
    * You are competent enough to see when they are.
* Monday, 2024-03-04, Sebring Lewis.
  _Des Moines Metropolitan Opera: Beauty and the Beast_
* Thursday, 2024-03-07, JRC 101, 8:00-9:30 pm.
  _Writers@Grinnell: Carl Phillips_
* Thursday--Saturday, 2024-03-07 to 2024-03-09, 7:30 p.m.
  _Songs of the Scarlet and Wayback_ (play).
* Saturday, 2024-03-09, Harris Cinema, ??:??
  _Met Opera: Verdi's La Forza del Destino_.

Peer

* Saturday, 2024-03-02, noon? probably the Tennis Courts 
  (the Field House is backup).
  _Tennis (men's and women's)_
* Saturday, 2024-03-02, 2pm, in Sebring Lewis.
  _Orchestra_, Bartok. Vegetables. More!

Wellness

* Friday, 2024-03-01, 7pm in JRC 101.
  _Spa Night_. Prizes! Scented oils. "A chance to relax with friends."
* Tuesday, 2024-03-05, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-03-05, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-03-05, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

### Other good things to do (no tokens)

### Friday PSA

* You are awesome. I'd like you to remain such. Please take care of yourselves.
* Make choices based on your own needs and person, not your perceptions of
  what others are doing or want you to do.
* Please stay moderate.
* Consent is essential, but focus on shared understanding, too.

Questions
---------

### Administrative

Will more tokens become available?

> I am revising the token system. Stay tuned.

Will there be a limit to the number of token activities we can submit?

> Just physical limits. If I don't set up enough slots, let me know and
  I'll add more.

What happens if I don't submit the mini-project by its late submit date?

> You have to wait until the redo.

What happens if I don't submit the redo by its late submit date?

> You have to wait until the re-redo.

### LAs

### Other topics

AICs, Reviewed
--------------

There are a number of situations in which we need "one use" things. For
example, if I'm sorting students by some formula, it seems wastful to
build a whole new function for that. In Scheme, we write a lambda.

`(sort students (lambda (s1 s2) (or (better? (major s1) (major s2)) (> (donation-from-family s1) (donation-from-family s2)))))`

We want to do the same thing in Java. Except Java is object oriented rather
than functional, so we do "anonymous classes".

Lab problem: Create a priority queue of strings that orders the strings
by length (if different lengths) and alphabetically (if the same length).

```
import java.util.PriorityQueue;
import java.util.Comparator;
import java.io.PrintWriter;

/**
 * A quick experiment with priority queues.
 *
 * @author CSC 207 2024Sp
 */
public class PQE {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    PriorityQueue<String> pq =
    new PriorityQueue<String>(new Comparator<String>() {
      public int compare(String s, String t) {
        int tmp = s.length() - t.length();
        if (0 == tmp) {
          return s.compareTo(t);
        } else {
          return tmp;
        }
      }
    });

    // Add all the value
    pq.add("alpha");
    pq.add("beta");
    pq.add("bill");
    pq.add("bart");
    pq.add("c");
    pq.add("aardvark");
    pq.add("television");
    pq.add("um");

    // Print them out, clearing the queue
    // while pq still has values
    //   remove the highest-priority value and print it
    while (!pq.isEmpty()) {
      pen.println(pq.poll());
    }
    pen.close();
  } // main
} // class PQE
```

Iterators, Reviewed
-------------------

Iterators are used to allow us to visit all of the elements in a collection
(ideally, any kind of collection: list, stack, queue, tree, graph, heap,
hash table, set).

Most important methods: `next()` - gets the next unvisited element, 
and `hasNext()`.

Conceptually, we think of the elements of the collection as being in a
sequence (list).

```
 H E L L O W O R L D
^
```

The iterator is between elements. `next` means "go over the element and
return it".

```
 H E L L O W O R L D
  ^
```

Some iterators provide a `remove()` method. `remove()` removes the last
element returned by `next()` (at least at the first level of accuracy).

Why do we have iterators?

* It's a uniform and convenient way to give people access to all the elements
  in a collection.
* If we provide `remove`, it's also a uniform and general way to remove elements.

```
while students.hasNext() {
  if (students.next().hasAdvisor()) {
    students.remove():
  }
}
```

How do we write iterators? Often, as anonymous inner classes.

Here's an instance in which we don't use an anonymous inner class.

```
class ArrayBasedQueueIterator<T> implements Iterator<T> {
  // Notes
  //   Fields are front, size, values

  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  int i;  // How many values I've seen.
  ArrayBasedQueue<T> q;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new iterator.
   */
  public ArrayBasedQueueIterator(ArrayBasedQueue<T> q) {
    this.i = 0;
    this.q = q;
  } // ArrayBasedQueueIterator

  // +---------+---------------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public T next() throws NoSuchElementException {
    if (!this.hasNext()) {
      throw new NoSuchElementException("no elements remain");
    } // if no elements
    return q.values[(q.front + i++) % q.values.length];
  } // next()

  @Override
  public boolean hasNext() {
    return this.i < this.q.size;
  } // hasNext()

  @Override
  public void remove() throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  } // remove()
} // ArrayBasedQueueIterator<T>
```

Question: Where do we put that.

Answer: Often in the same file as the class.  We still define this as
a class.

Observation: If we make the fields of the primary class private, this won't
work, because there access issues.

Can we put one class inside another class to solve that? Yes.

Where does `Iterator` come from?

> `java.util.Iterator` (there's also a `java.util.ListIterator`)

Can we look at a use of the `remove` method?

```
    Iterator<String> sit = expt.iterator();
    while (sit.hasNext()) {
      String s = sit.next();
      pen.println(s);
      if (s.equals("B")) {
        sit.remove();
      }
    }
    for (String t : expt) {
      pen.println(t);
    }
```

Alumni Visit?
-------------

You have to keep on learning as a full-time employee.

It's useful that Grinnell makes you learn multiple languages.

Projects? AppDev. One of the random Sam one-credit courses.

"Commits on GitHub count."
