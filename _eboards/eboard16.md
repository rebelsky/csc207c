---
title: "EBoard 16: Priority queues"
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

### Introductory notes

* Still on lab das

### Upcoming Token activities

Academic

* Mentor session Sunday

Cultural

* Jazz band concert Friday night
* SOL heritage event Friday in location tbd.

Peer

* Football vs Lawrence Saturday at 1 pm
* Soccer vs Ripon Saturday at 1:30 pm
* Smash Bros tournament

Wellness

Misc

### Upcoming work

* Monday: More readings.  Iterators

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

What should it look like after a call to `get()`?

What should it look like after a call to `put("D")`?

How do we achieve those pictures?

Questions
---------

What happens if I don't turn in a pre-assessment or a post-assessment?

> From the syllabus,

> > You are allowed to miss up to four total lab assignments and metacognitive reflections in the semester without penalty. If you miss more labs or reflections, your overall letter grade will be lowered by one-third of a letter grade for each two additional labs or reflections you miss. Excesses of one also result in a loss. 

What happens if I turn in something late?

> You lose a token.

Lab
---

Why do we fork and then clone?

> So that you have your own copy of the code.  You can push your changes
  and then share them your partner (or yourself on another computer)
  using the GitHub repo.

Are we paying attention to Sam?

> Probably not.  That means that there's a significant possibility that
  he will make fun of us on the eboard.

What should we call the class for exercise 4?

> `StringUtils.java`

Where can we find the code Sam is writing?

> Reload the lab page.
