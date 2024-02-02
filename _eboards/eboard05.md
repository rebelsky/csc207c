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
* Ideas from the readings
* Questions
* Lab

Preliminaries
-------------

* I'll take attendance today as I work on learning your names.
* Sorry that VSCode has been so non-cooperative to so many of you.
* Sorry that GitHub has been so non-cooperative to so many of you.
* I'll try to set up extra "sit down with Sam and try to get things
  working" times.
* Sorry that I chose a bad name for the `dubble` procedure.

### Upcoming work

* Thursday at 11pm: Readings
    * [Memory](../readings/memory)
    * [Object semantics](../readings/object-semantics)
        * Not yet ready
    * Nothing to submit
* Wednesday at 11pm: Post-reflection for MP1
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/3974722/)
* Friday at 1pm: Today's labs
    * [_Submit on Gradescope_](...)
* Friday at 11pm: Mini-project 2 pre-reflection
    * [_Submit on Gradescope_](...)
* Next Wednesday: [Mini Project 2](../mps/mp02)
    * Not yet on Gradescope.

### Mini-Project 2

* Write a calculator (backend and two front ends)
* You'll be responsible for parsing strings on the front end
* You'll be responsible for doing calclations on the back end

Questions

* Does Java permit overloading? Yes, but I'm not sure it's relevant.
* Do our reslts have to be in the simplest form? Yes. You will be
  responsible for having the `BigFraction` class simplify. Note that
  `BigInteger` may be your friend.
    * Learning to read JavaDoc is good!
* Can I use the Javadoc templates that VSCode enters for me? Yes. And
  you need cite VSCode.
* How do you find JavaDoc? Web search. Sometimes Sam adds links.
* Can we use things you haven't taught us? Certainly, but you should cite
  where you learned them. You may not use LLMs like ChatGPT and CoPilot
  (cope eyelet).

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
* Swim meet this weekend. Saturday 1pm in the Natatorium against Augusta.

Wellness

Misc

* Friday, 2024-02-02, 8pm, Harris Concert Hall:
  _Weekend Murder Mystery_.

### Good things to do (no tokens)

Reading notes
-------------

### Key ideas (TPS)

* We are studying classes and objects. Sam used two-dimensional vectors
  as our sample.
* Classes serve as templates for building objects. They tell us what
  information objects store and what kinds of things you can do with
  them.
* Classes have fields (2 kinds), methods (2 kinds), and constructors (1
  kind)
    * 2 kinds: Static and Object methods; Static and Object fields
    * Static fields and methods are associated with the class a whole
    * You need not have all these things
    * You may also have a few other things: Constants, component classes
* To use an object method, you prefix it with the name of an object
  (or `this`, if you're working within an object method)
* To refer to an object field, you prefix it with the name of an
  object (or `this`, if  you're working within an object method)
* TO refer to a class (static) field or method, you usually preface it with
  class name, but you can preface it with an object name as long as the
  object is in the class.
    * So objects can usually access to the static fields of their class.
* Static fields are somewhat like globals, except that they are localized
  to a particular set of objects.
* Side notes
    * We generally expect that others won't access our fields. We can
      ensure that by using `private` before a field (or a method).
        * Objects in other classes. Methods in other classes. Other
          programmers. Ourselves on other days.
    * Java permits overloading: Different classes may have the same
      method names. You can have more than one method with the
      same name, provided they have different parameter types.
* When should we use a static field (or method)? When it doesn't seem
  to be associated with each object we create.
* We use information hiding to permit us to change the underlying representation
  without affecting the client code.

### Example from the white board

Let's assume that we have a class, `Pen`, that we use to describe pens.

Each Pen we create will have a color and a supply of ink. These are
object fields.

We also want to keep track of the total number of working pens. Since that
is shared among the pens (or independent of any particular pen), we make
that a static field.

Pens can write. But we need a particular pen to write. So the `write`
method is an object method.

On the other hand, `getNumberOfWorkingPens()` should not need any
particular pen, so we can make it a static method.

The `write` method might want to change the static `numberOfWorkingPens`
field. For example, a pen might run out of ink.

```
public class Pen {
  /**
   * Write some stuff using the pen.
   *
   * @param stuff
   *  What we want written
   * @param where
   *  Where the stuff goes
   */
  public void write(String stuff, Suface where) {
    this.supply -= stuff.length();
    if (this.supply <= 0) {
      Pen.numberOfWorkingPens -= 1;
    }
    ...
  } // write(String)
} // class Pen
```

### Self check

_Write a *static* method, `Vec2D dubble(Vec2D v)`, the builds and returns a new `Vec2D` that is twice as long as `v`. (You should not use the `dubble()` method we described above.)_

<https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Sp/examples/vec2d/Vec2D.java>

```
  /**
   * Create a new vector that is twice as long as this vector.
   */
  public Vec2D dubble() {
    return new Vec2D(this.getTheta(), this.getRadius()*2);
  } // dubble
```


TPS: What's wrong with the following?

```
public static Vec2D dubble() {
    return new Vec2D(this.radius * 2, this.theta);
}
```

* Bad design. Use methods rather than fields, even internally.
* The parameters are in the wrong order.
* It's a static method, to there's no `this`. We need an object to work
  with. (See the following)

TPS: What's wrong with the following?

```
static Vec2D dubble(Vec2D v) {
  return new Vec2D (this.getTheta(v), this.getRadius(v)*2);
}
```

* `getTheta` and `getRadius` are object methods with no parameters.
* `this` doesn't exist for static methods.

We'd prefer something more like the following.

```
static Vec2D dubble(Vec2D v) {
  return new Vec2D(v.getTheta(), v.getRadius()*2);
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

Lab
---

We will continue doing this lab on Friday!

You will still have readings to do.
