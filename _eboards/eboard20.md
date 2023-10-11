---
title: "EBoard 20: Lambdas"
number: 20
section: eboards
held: 2023-10-09
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.

_Approximate overview_

* Administrivia
* One more attempt to analyze merge sort
* Lab

Administrivia
-------------

* Who read carefully through the code in the Java Tutorial to understand
  what they were trying to show/tell/teach you?
* The code for today's lab is new this year.  Let me know if you encounter
  difficulties.

### Upcoming Token activities

Academic

* CS Extras Thursday.  ???

Cultural

* Intertribal Pow-Wow, Today, 1:30-4:30, Kington Plaza (30 min suffices)
* "Growing Up Native in Iowa" by Stephanie BadSoldier Snow, Drake Library,
  5:30-6:30 pm.
* Bean Dishes in global kitchen 4pm on Thursday.

Peer

* Football at home second Saturday of break.

Wellness

Misc

### Other good things (no tokens)

### Upcoming work

* Wednesday: Readings on searching
* Thursday: MP5
* Friday night: MP5 post-assessment

Questions
---------

### Administrative

What Java style do you want?

> I want you to follow the [Google Style Guide](https://google.github.io/styleguide/javaguide.html).

> You need not be perfect.

> I really do prefer two-space indentation.

Will I be charged a token for redoing an MP?

> See [the token policies](https://rebelsky.cs.grinnell.edu/Courses/CSC151/2023Fa/handouts/tokens) for details.

> If you got an R or an M, there is no charge for the first redo
  (unless you turn it in late).

> If you got an I or did not turn in the mini-project, you must
  spend one token to turn in the redo (and a second if you turn it
  in late).

> Second redos cost two tokens.  If you didn't turn in the first
  redo, the second redo stil counts as a second redo.

Can I turn in pre-assessments and post-assessments VERY late.

> The original plan was no, but I've been slow at getting things done,
  so perhaps.  Let me think about it.  Yes.

Why don't we have grades?

> Poor communication with graders.  Stay tuned.  The redos will open
  up again.

How do I know how I'm doing with tokens?

> Sam will send you a summary tonight or tomorrow.

Today's repo gives a 404 error.  

> Not anymore.  Thanks for the notification.

### MP5

### Priority queues

There are a variety of ways to implement priority queues.  Two basic
ones are unsorted arrays and sorted arrays.  In a sorted array, get
is O(1) but put is O(n).  In an unsorted array, get is O(n) but put
is O(1).  Does it really make a difference?

> Suppose our program adds n items and then only gets one.  In practice,
the unsorted array is going to be better because we only do the expensive
operation a few times.

> But yes, both will be O(n^2) if we add and remove n elements.

> There are some algorithms that choose unsorted arrays for this reason.

> Of course, there are other implementations of priority queues that
  have better O() running times.  We'll learn one later this semester.

> Intuition: When we want to make things faster and we are going for
  O(logn), use a balanced binary tree.

Analyzing merge sort, continued
-------------------------------

We've currently analyzed merge sort in two ways:

* "Bottom up" - Start with T(1), then compute T(2), then compute
  T(4) (sometimes we do T(3)), ... look for a pattern.
* "Top down" - Start with T(n), expand the recursive parts (stil
  giving T(N), expand some more, ... look for a pattern.

The trees are a bit more straightforward.

Note: Doing a few basic patterns and then remembering them is a good
strategy.

Lab
---

It's time to explore the wonder of lambdas.  (Lab-mdas?)

_I apologize for the gender binary in the `Person` class._
