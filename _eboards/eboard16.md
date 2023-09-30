---
title: "EBoard 16: Array-based queues and priority queues"
number: 16
section: eboards
held: 2023-09-29
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.

_Approximate overview_

* Administrivia
* Questions
* Lab

Administrivia
-------------

* Welcome to any parents who are here.
* I believe I've added everyone to the testing repo.  If you did not
  get an invitation, please let me know.
* Don't forget that we have evening tutors here most nights.  Not all
  of them can help you, but many can.
* Tests that identify errors in my code will earn you tokens.
    * That's an incentive to push tests early.

### Upcoming Token activities

Academic

* Mentor session Sunday at 4pm
* CS Table, Tuesday, Noon, Reports from Tapia and GHC.

Cultural

* Jazz Ensemble, Friday, 7:30 p.m. Sebring-Lewis
* SOL Heritage Event, Friday, 5:00-6:00 p.m., HSSC Kernel
* Grinnell Symphony, Saturday, 2:00 p.m. Sebring-Lewis
* Pieta Brown, Saturday, 7:00 p.m. Central Campus

Peer

* Football vs Lawrence Saturday at 1 pm
* Soccer vs Ripon Saturday at 1:30 pm
* Smash @ Grinnell Monthly Tournament #1, 1:00-5:00 p.m. Saturday, 
  HSSC N3170 - Inquiry Learning Lab

Wellness

Misc

### Other good things (no tokens)

* Neverland players

### Upcoming work

* Sunday: MP4 pre-assessment
* Monday: More readings.  Iterators.  And "wrappers".
* Thursday: MP4
* Friday: MP4 post-assessment

Visualizing linked structures
-----------------------------

I find it incredibly important to draw pictures whenever I work with
linked structures.  Consider our linked queues.

```
  front                    back
    |                       |
    v                       v
  +---+---+   +---+---+   +---+---+
  | * | *---> | * | *---> | * | / |
  +-|-+---+   +-|-+---+   +-|-+---+
    v           v           v
   "A"         "B"         "C"
```

What should it look like after a call to `put("D")`?

```
  front                               back
    |                                  |
    v                                  v
  +---+---+   +---+---+   +---+---+   +---+---+
  | * | *---> | * | *---> | * | *---> | * | / |
  +-|-+---+   +-|-+---+   +-|-+---+   +-|-+---+
    v           v           v           v
   "A"         "B"         "C"         "D"
```

How do we achieve that?

* `Node<T> tmp = new Node<T>("D"); // implicit `tmp.next = null;`
* `this.back.next = tmp;`
* `this.back = tmp;`

What should it look like after a call to `get()`?

```
   tmp        front                   back
    |           |                      |
    v           v                      v
  +---+---+   +---+---+   +---+---+   +---+---+
  | * | *---> | * | *---> | * | *---> | * | / |
  +-|-+---+   +-|-+---+   +-|-+---+   +-|-+---+
    v           v           v           v
   "A"         "B"         "C"         "D"
```

We achieve this with

```
  tmp = this.front;
  this.front = this.front.next;
  tmp.next = null;
  return tmp.value;
```

Why are we clearing out the `tmp.next`?

* Safety.  We will likely see earlier errors.  We will likely avoid
  corrupting the list.  (In cases in which we accidentally keep a reference.)
* Garbage collection.

Note: Drawing pictures of edge cases also helps

```
  if (this.front == null) {
    this.back == null;
  }
```

Morals:

* Use paper or whiteboards or ASCII art to think abou these issues.
* When I ask you to predict the output of a series of operations,
  I'd like to see you write it down somewhere.

Questions
---------

Why do we fork and then clone?

> So that you have your own copy of the code.  You can push your changes
  and then share them your partner (or yourself on another computer)
  using the GitHub repo.

How do I know how I'm doing on tokens?

> I hope to get that updated next weekend.

Lab
---
