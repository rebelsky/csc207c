---
title: "Eboard 05: Building classes and objects"
number: 5
section: eboards
held: 2024-01-31
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed. Of course, the technology failed in my earlier class, so perhaps not.**

_Approximate overview_

* Administrivia
* Questions
* Lab

Preliminaries
-------------

* I'll take attendance today as I work on learning your names.
* Sorry that VSCode has been so non-cooperative to so many of you.
* Sorry that GitHub has been so non-cooperative to so many of you.
* Sorry that I chose a bad name for the `dubble` procedure.

### Upcoming work

* Thursday at 11pm: Readings
    * [Memory](../readings/memory)
    * [Object semantics](../readings/writing-classes)
        * Not yet ready
    * Nothing to submit
* Wednesday at 11pm: Post-reflection for MP1
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/3974722/)
* Friday at 1pm: Today's labs
    * [_Submit on Gradescope_](...)
* Friday at 11pm: Mini-project 2 pre-reflection
    * [_Submit on Gradescope_](...)
* Next Tuesday: [Mini Project 2](../mps/mp02)
    * Not yet on Gradescope.
    * Do you prefer that I have homework due on Wednesday?

### Tokens

Academic/Scholarly

* Thursday, 2024-02-01, 11am, HSSC 2231 (Auditorium),
  _Scholars' Convocation, Being a Pandemic Citizen._
* Thursday, 2024-02-01, 4:15pm, Science 3821,
  _CS Extras: Summer research_

Cultural

Peer

* Tennis, Sunday, 9 and 4pm, Field house,
  _Matches against Augustana_

Wellness

Misc

* Friday, 2024-02-02, 8pm, Harris Concert Hall:
  _Weekend Murder Mystery_.

### Good things to do (no tokens)

* Swim meet this weekend.

Reading notes
-------------

### Self-Check a

_Write a *static* method, `Vec2D dubble(Vec2D v)`, the builds and returns a new `Vec2D` that is twice as long as `v`. (You should not use the `dubble()` method we described above.)_

TPS: What's wrong with the following?

```
public static Vec2D dubble() {
    return new Vec2D(this.radius * 2, this.theta);
}
```

TPS: What's wrong with the following?

```
static Vec2D dubble(Vec2D v) {
  return new Vec2D (this.getTheta(v), this.getRadius(v)*2);
}
```

### `vectorTo`

What's wrong with `vectorTo` from the reading?

```
  /**
   * Build a vector to the point (x,y)
   * @pre
   *   x != 0
   */
  public static Vec2D vectorTo(double x, double y) {
    return new Vec2D(Math.atan(y/x), Math.sqrt(x*x + y*y));
  } // vectorTo(double,double)
```

How do we fix it?

Questions
---------

### Administrative

### GitHub

Why can't I push to my GitHub repo?

Lab
---

### Questions

