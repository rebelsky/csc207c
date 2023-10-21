---
title: "EBoard 22: Searching"
number: 22
section: eboards
held: 2023-10-13
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.
It's probably also being transcribed.

_Approximate overview_

* Administrivia
* The Beginner's Creed
* Questions
* Lab

Administrivia
-------------

* Beware!  Friday the 13th falls on Friday this month.
* Friendly reminder: Treat your partners with respect.
* Unfortunately, our mentors will not be here today.

### Upcoming Token activities

Academic

* Today: Talk and movie on security (1pm, Strand 3).
  <https://forms.office.com/r/u34bDgj8w2>

Cultural

Peer

* Football, 1pm Saturday, 21 October 2023.

Wellness

* Be well during fall break.

Misc

* Watch the eclipse (but don't stare directly at it)

### Other good things (no tokens)

### Upcoming work

* Saturday: MP5
* Sunday night: MP5 post-assessment
* Break: Nothing (or LAs, or MP redos, or ...)

The Beginner's Creed
--------------------

<http://denninginstitute.com/pjd/PUBS/CACMcols/cacmJul17.pdf>

I am a beginner.  
I am entering a new game about which I know nothing.  
I do not yet know how to move in this game.  
I see many other people playing in this game now.  
This game has gone on for many years prior to my arrival.  
I am a new recruit arriving here for the first time.  
I see value to me in learning to navigate in this domain.  

There is much for me to learn:  
    The basic terminology  
    The basic rules  
    The basic moves of action  
    The basic strategies  

While I am learning these things I may feel various negative reactions:  
    Overwhelmed at how much there is to learn  
    Insecure that I do not know what to do  
    Inadequate that I lack the capacity to do this  
    Frustrated and discouraged that my progress is so slow  
    Angry that I have been given insufficient guidance  
    Anxious that I will never perform up to expectations on which my career depends  
    Embarrassed that everyone can see my mistakes  

But these moods are part of being a beginner. It does not serve my goal and ambition to dwell in them. Instead,  
    If I make a mistake, I will ask what lesson does this teach.  
    If I make a discovery, I will celebrate my aha! moment.  
    If I feel alone, I will remember that I have many friends ready to help.  
    If I am stuck, I will ask for help from my teachers.  

Over time, I will make fewer mistakes.  
I will gain confidence in my abilities.  
I will need less guidance from my teachers and friends.  
I will gain familiarity with the game.  
I will be able to have intelligent conversations with others in the game.  
I will not cause breakdowns for promises that I lack the competence to keep.  
I have an ambition to become competent, perhaps even proficient or expert in this game. But for now,  
I am a beginner.  

—By Peter J. Denning
From _Communications of the ACM_ 60(7), July 2017

Questions
---------

Lab
---

Sam's reflections:

* The looped test is good at catching errors.  I've seen student code
  fail exactly one of the 1024-or-so tests.
    * Rather than writing individual tests, it's nice to write procedures
      that generate lots of tests.
    * The output from your test can help you analyze your code.
* Detour: Famous error: Find the midpoint with `(lb + ub)/2`;
    * Solution: `lb + (ub-lb)/2`;
    * Mathy explanation
        * (lb + ub)/2 = lb/2 + ub/2
        * lb + (ub-lb)/2 = lb + ub/2 - lb/2 = lb - lb/2 + ub/2 = lb/2 + ub/2
* Debugging is your friend.
* Although, intuitively, we want "half the array" in binary search,
  we cannot use `arrayCopy` to get half.  That turns our efficient
  O(logn) algorithm into an O(n) algorithm.
