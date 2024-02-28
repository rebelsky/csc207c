---
title: "Eboard 16: Array-based linear structures"
number: 16
section: eboards
held: 2024-02-26
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed.**

_Approximate overview_

* Administrivia
* Questions
* Lab

Preliminaries
-------------

* The second set of LAs should be coming soon. 
* I've set Tuesday night as a target for returning the first set of LAs.
* I'm hoping that today can be mostly a lab day.

### Upcoming work

* Tuesday, 2024-02-27, 11pm, Reading
    * [Iterators](../readings/iterators)
    * [Anonymous inner classes](../readings/anonymous-inner-classes)
    * [Reading response on Gradescope](...)
* Wednesday, 2024-02-28, 11pm, [MP4](../mps/mp04)
    * [_Submit MP4 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4137145/)
* Friday, 2024-03-01, 11pm, Submit the second set of LAs.
    * _Sorry, no Gradescope links_
* Friday, 2024-03-01, 11pm, MP4 post-reflection
* Friday, 2024-03-01, 11pm, MP5 pre-preflection

### Tokens

Academic/Scholarly

* Tuesday, 2024-02-27, noon--1:00pm, Some PDR.
  _CS Table: ???.
* Tuesday, 2024-02-27, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.
* Thursday, 2024-02-29, 11:00am, Science JRC 101.
  _PM Osera Convocation_.

Cultural

Peer

Wellness

* Tuesday, 2024-02-27, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-02-27, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._ (I think)
* Tuesday, 2024-02-27, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

### Other good things to do (no tokens)

Questions
---------

### Administrative

When will MP1 be returned?

> I don't know what you're talking about. It's available.

What's the timeline?

> By the end of the semester. (Before spring break.)

### MP4

After removing more than once, should we only have one null : null pair at end or multiple?

> I wouldn't put any null/null pairs in your array. I would just have nulls
  in the empty cells.

> There are three primary approaches to `remove`.

> * Put a null in the array where the key/value pair is. 
    _This approach complicates things._
> * Shift the array left when we hit the key/value pair with the removed key. 
    _This approach is expensive._
> * Put the last thing in the array in the newly opened slot, shoving a null
    at the end. _Sam finds that this works best, but you can use any of
    them.

> If you're using the last approach, you always need _something_ in each
  cell of the array. I'd use `null` for "nothing here".

> If we remove `n` times (and don't shrink the array), there will be at
  least `n` nulls at the end of the array.

> Its always safest to put a `null` in "empty" cells just so we don't have
  extra references floating around.

> Drawing pictures often helps us figure this out.

Do we add the element at the end of the stuff with values or before the
nulls?

> Yes. Both. In the recommended organization you have all the cells with
  pairs at the left followed by all the cells with nulls.

On the page of the assignment and on the eBoard we have different directions to the latter case. The mini project page says to do no nothing while the eBoard says to throw an exception. What should we do?

Translation: What do we do when we call `remove` and its not in the array?

> Follow the instructions on the assignment. (Do nothing.)

Is it really the case that `==` does a crappy job when comparing `int`
values to `Integer` values?

> Apparently so.

What should we do if the user calls `set` with an extant key?

> The assignment says "Set the value associated with a given key. If there 
  is already another value associated with the given key, this new value 
  replaces that value." (That construction is not parallel. Sorry.)

What should our workflow be for adding our tests?

> Make sure that the code doesn't crash.

> Type `git pull`.

> Make sure that the code doesn't crash.

> Type `git add src/AssociativeArrayTests.java`.

> Type `git commit -m "Add my tests."`

> Type `git push`.

> Cross your fingers and toes.

What if someone else's tests are breaking the repo?

> Option 1: Let Sam know so that he can fix them.

> Option 2: Let that person know so that they can fix them.

> Option 3: Fix them yourself.

> "Self gov the problem."

What happens in the situation in which A pushes, B and C pull, and then
B pushes, then C pushes without pulling B's changes?

> Ideally, C will get an error message.

> No promises.

When you pull, what option should you choose?

> I tend to choose the first one, which it says is the default.

### LAs

When are you grading them?

> Tomorrow. I hope.

### Linear structures

Why can't I run the lab on my laptop?

> We'll look at that.

### Wrappers

### Other topics

### MP1

I failed to meet the specifications. Why did I get an I?

> I think you answered your own question.

> But I won't charge a token for this redo.

> It is important for you to name things correctly.

When will the redo be due?

> Probably a week from Sunday.

Lab
---

Yay! Drawing diagrams is helpful!

Yay! Using the debugger is helpful!

Yay! Sam isn't requiring us to submit this lab.
