---
title: "Eboard 27: Linked Lists"
number: 27
section: eboards
held: 2024-04-05
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

**Please sit with your MP7 partner.**

_Approximate overview_

* Administrivia 
* Lab

Preliminaries
-------------

* Thanks to whoever told our mentor to tell me that I'm not giving you 
  enough time for lab. 
    * Note that Wednesday was intentionally a "let's figure out
      list iterators" day (based on my experiences last semester).
      We'll still have time for that lab on Monday.
* Note: Class is "virtual" on Monday. You should do the lab on your own
  (with or without a partner), checking in with me if/when you need help.
* We understand lists best when we diagram them. Consider grabbing a
  whiteboard and marker.

### Upcoming work

_Schedule needs updating. Stay tuned._

* Friday, 2024-04-05, [MP6](../mps/mp06) post-assessment
    * [_Submit MP6 post-assessment on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4324612)
* Friday, MP7 pre-assessment
    * Individual
    * [_Submit MP7 pre-assessment on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4324617)
* Wednesday, MP7
    * Group
    * [_Submit MP7 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4324621)
* Sunday, 2024-04-14, [MP3](../mps/mp03) redo
    * [_Submit MP3 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4324626)
* Sunday, 2024-04-14, [MP4](../mps/mp04) redo
    * [_Submit MP4 redo on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4324630)

### Tokens

Academic/Scholarly

* Tuesday, 2024-04-09, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-04-09, 7:00pm, Science 3819.
  _Mentor Session_.
* Thursday, 2024-04-11, 4pm, HSSC 1231 (the Kernel).
  _CS Poster Session_.

Cultural

* Friday, 2024-04-05, 4pm, Global Living Room in HSSC.
  _Middle of Everywhere._
* Saturday, 2024-04-06, 1--4pm, Cleveland Beach (in front of Cleveland
  residence hall on South Campus).
  _Holi_.
  Beware, your clothes will get stained.
    * Follow the instagram page for info. @umwhatiscalledshibam [no].
      @shibamquick [no]. @saso_grinnell [maybe]
* Saturday, 2024-04-06, 7:00-8:00pm, Global Living Room.
  _Eid extravaganza_.
* Sunday, 2024-04-07, 1:00-4:30pm, Harris.
  _Purim Carnival_.
* Sunday, 2024-04-07, 2:00-3:30pm, Sebring-Lewis.
  _Eugene Gaub Recital_.
* Thursday, 2024-04-11, 4:15-5:30pm, HSSC S1325
  _Writers@Grinnell_.
* Thursday, 2024-04-11, 8:00-9:30pm, JRC 101
  _Writers@Grinnell_.
* Friday, 2024-04-12, 4:00-5:00pm, HSSC N1170
  _Middle of Everywhere_.
* Saturday, 2024-04-13, ???  (@nepali_grinnellians on instagram for
  more info)

Peer

* Saturday, 2024-04-06, 9am--noon, Field House (?)
  _Men's Tennis vs. Illinois College_.
* Saturday, 2024-04-06, 3pm--6pm, Field House (?)
  _Men's Tennis vs. Monmouth_.

Wellness

* Tuesday, 2024-04-09, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-04-09, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-04-09, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.
* Friday, 2024-04-12, 3:00--5:00pm, JRC Courtyard
  _Get Nostalgic_.

Misc

* Monday, 2024-04-08, 1:00--3:00pm (approx), where appropriate.
  _Watch the eclipse (but don't stare at the sun)_.
    * Eclipse glasses being given away at Burling (we think) and
      by the Physics SEPC (we know).

### Other good things to do (no tokens)

### Friday PSA

* You're awesome. People care about you. (At least one person, as long
  as you consider me a person.) -> You have a responsibility to take
  care of yourself.
* Be moderate.
* Watch your drink container.
* Consent is essential (discussion is better).

Questions
---------

_Please avoid distracting questions._

### Registration

### Administrative

### Lists

### MP7

### Other

Lab
---

### Kudos

I appreciate how readily you talk to each other about design.

### On lab design

At some times, it's better to plan and read rather than just implement.

* You'll likely miss everything the first time through; this makes you
  a bit more efficient.
* [But you knew that; it's a theme of the labs in the course.]

### Exploring `remove`

a. Why do we have the last two lines of `remove`?

```
  void remove() {
    if (this.prev != null) {
      this.prev.next = this.next;
    }
    if (this.next != null) {
      this.next.prev = this.prev;
    }
    this.prev = null;
    this.next = null;
  } // remove()
```

b. Where's the call to `free`?

### Interface vs. implementation

Even if we implement a List (abstract) as a CircularlyDoublyLinkedList
(implementation), all of the operations should assume that it's just a
List. Hence, even though there's a `next` node for the last node in
the list, `hasNext` should return false.

### Some morals (if there's time)

* At times, Sam (or someone) writes beautifully weird code. E.g., 
    * `removeExpt(stuff, (str) -> ((counter.get() % 2) == 0))`
* We understand much better when we draw pictures [x3]
    * We can also trace code on paper.
    * It's easy to get lost in lists unless you draw pictures.
* We understand cursors/iterators better. [+1]
* We should remember what we've done before; it helps.
* Take more notes while working.
* Iterators can be complex to learn.
* It's hard to keep track of all the fields.
* It's weird that we have two `remove` functions (one for the node and
  one for the iterator). But it makes sense (one is conceptual, one is
  implementation).
* There are a lot of nuances and special cases, at least if you make
  some design decisions.
