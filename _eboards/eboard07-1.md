---
title: "Eboard 07 (Section 1): Generics and parametric polymorphism"
number: 7
section: eboards
held: 2024-09-19
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  [at least if Sam can get the technology working again]

_Start of class instructions_

* Optional: Grab a mask
* Grab one of the business cards on the table that have computer names 
  and locations.
* Identify where the corresponding computer is.
* Return the card to the jar.
* Navigate to the computer.
* The first person at the computer logs in (and, if appropriate, forks
  and clones the repo).
* Grab a piece of paper (one per pair should be enough).
* When both partners arrive, introduce yourselves.
    * Recommended: Discuss working strengths and areas to improve

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* About MP3
* Questions
* Lab
* Meet with your MP3 partner.

Preliminaries
-------------

### News / Etc.

* Writing MP3 took me far more time than it should have. I did not have
  time to do anything else yesterday. (Other than personal stuff.) In
  particular, I did not review all of your questions for class.
* I am not sure whether or not I'll be here next week. If not, you'll have
  awesome subs.
* I've tried to rearrange the upcoming work section for clarity. Let me
  know if you have problems with it.
* Only one more week of Java and OOP. Then we (mostly) move on to data
  structures and algorithms!

### Upcoming work

* TONIGHT @ 10:30 p.m.
    * Complete [Mini-Project 2](../mps/mp02) 
    * [Submit MP02 on Gradescope](https://www.gradescope.com/courses/818402/assignments/4979019)
* Friday, 2024-09-20 @ 10:30 p.m.
    * Submit [Post-reflection for MP02](https://www.gradescope.com/courses/818402/assignments/4943647) by 10:30 p.m. on Friday, 2024-09-20.
        * I'd recommend doing the post-reflection immediately after you
          complete the mini-project.
* Sunday, 2024-09-22 @ 10:30 p.m.
    * Submit [Pre-reflection for MP03](https://www.gradescope.com/courses/818402/assignments/4996560)
* Monday, 2024-09-23 @ 10:30 p.m.
    * Reading on [Exceptions](../readings/exceptions)
        * Whoo! Only one reading.
    * Submit [reading responses for class 8](https://www.gradescope.com/courses/818402/assignments/4996552) 
    * Submit [today's lab](https://www.gradescope.com/courses/818402/assignments/4990860)
        * Today's writeup uses the a new style. Open it up at the start of lab.
    * Submit [SoLA 2](../los/sola02)
        * [Development #6: Code reading](https://www.gradescope.com/courses/818402/assignments/4966787)
        * [Development #8: Documentation](https://www.gradescope.com/courses/818402/assignments/4966799)
        * [OOP #1: Encapsulation](https://www.gradescope.com/courses/818402/assignments/4966827)
        * Redo: [Development #2: Build tools](https://www.gradescope.com/courses/818402/assignments/4966771)
        * Redo: [Development #4: IDE](https://www.gradescope.com/courses/818402/assignments/4966772)
* Wednesday, 2024-09-25 @ 10:30 p.m.
    * Readings
    * Submit reading responses on Gradescope
* Thursday, 2024-09-26 @ 10:30 p.m.
    * Complete [Mini-Project 3](../mps/mp03)
    * [Submit MP3 on Gradescope](https://www.gradescope.com/courses/818402/assignments/4996582)
* Friday, 2024-09-27 @ 10:30 p.m.
    * Submit [Post-reflection for MP3](https://www.gradescope.com/courses/818402/assignments/4996574) on Gradescope.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Thursday, 2024-09-19, 4:15--??:?? p.m., Herrick Chapel.
  _Writers@Grinnell:
  Jonathan Meiburg, Readings from A Most Remarkable Creature_
* Friday, 2024-09-20, noon--1:00 p.m., JRC 224B (Livermore Dining Room).
  _Policy Issues and Digital Storytelling with Sarah Labowitz '04_
* Friday, 2024-09-20, 4:15--7:00 p.m., CERA.
  _Writers@Grinnell: Bird Watching with Jonathan Meiburg_.
  (Bus leaves JRC at 4:15; you can also drive yourself.)
* Sunday, 2024-09-22, 7:00--8:00 p.m., Noyce 3819.
  _Mentor Session!_
* Tuesday, 2024-09-24, noon--1:00 p.m., JRC 224A.
  _CS Table_
* Thursday, 2024-09-26, 11:00 a.m.--noon, JRC 101.
  _Scholars' Convocation: 
  Anthony Pinn - "Thoughts on Why Music Matters for the Study of Religion"_

#### Cultural

* Friday, 2024-09-20, 7:30 p.m., Sebring Lewis.
  _Jazz Band: Hits from the 80's, 90's, and naughts_
* Saturday, 2024-09-21, 7:30--8:30 p.m., Sebring Lewis.
  _Grinnell Singers and Oratorio Society_

#### Multicultural

* Friday, 2024-09-20, 4:00-5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_.

#### Peer

* Saturday, 2024-09-21, 2:00--3:00ish p.m., Sebring-Lewis.
  _Grinnell Symphony Orchestra plays Hungarian dances and more._

#### Wellness

#### Misc

### Other good things (no tokens)

* Friday, 2024-09-20, 4:00--6:00 p.m., Darby.
  _Volleyball vs. Loras_
* Friday, 2024-09-20, 8:00--10:00 p.m., Darby.
  _Volleyball vs. Augustanta_ 
* Saturday, 2024-09-21, 11:00 a.m.--1:00 p.m., Springer Field.
  _Men's Soccer vs. Nebraska Wesleyan_
* Saturday, 2024-09-21, 1:00 p.m.--4:00 p.m., Rosenbloom Field.
  _Football vs. Beloit_

About MP3
---------

Like the second half of Tuesday's lab, but extended! Also partnered.
Today's lab partner is your MP partner. If you are not here today, 
Sam will assign you a partner.

I will reserve ten minutes at the end of class today for you to make
plans with your partner (e.g., meeting times).

For `eqv`. Consider the following.

```text
XXX
XXX
```

There are many ways to create this.

```
AsciiBlock v1 = new VComp(HAlignment.LEFT, new Line("XXX"), new Line("XXX"));
AsciiBlock v2 = new VComp(HAlignment.RIGHT, new Line("XXX"), new Line("XXX"));
AsciiBlock x = new Line("X");
AsciiBlock xoverx = new VComp(x,x);
AsciiBlock v3 = new HComp(HAlignment.LEFT, xoverx, xoverx, xoverx);
AsciiBlock v4 = new Rect('X', 3, 2);
AsciiBlock v5 = new HFlip(v4);
```

All of the `vs` are `equal`, but none are `eqv`.

However, `v3` would be equivalent to `new HComp(HAlignment.LEFT, xoverx, new VComp(x,x), xoverx)`. Even though it's built with slightly different commands, it has the same structure.

Notes from Tuesday's lab
------------------------

### "It looks right" vs. "I'm confident that it's right"

The point of the horizontal composition exercise.

Also "What should be the meaning?"

### Code that could be improved

I am stunned to see how many of you wrote the following for row 0 of
the surrounded box.

```
    public String row(int i) {
      if (i == 0) {
        return boxChar + boxChar.repeat(contents.width()) + boxChar;
      } else {
        ...
      } // if/else
    } // row(int)
```

_Why would this disturb me?_ (TPS)

* Math is easy: `return boxChar.repeat(contents.width() + 2)`
* Or we could use our own width: `return boxChar(width())`
* We should use `this` for clarity. `this.boxChar(this.width())`

Questions
---------

### Questions on SoLAs

**Will we have time limits on any LAs?**

> Nope. I hope that you can complete most LAs in about twenty minutes
  The model in most cases is that you should (a) check your
  notes/code/memory for something you've written, (b) find that thing,
  (c) copy/paste/edit, and (d) spend a few minutes adding narrative.

**When do you plan to grade LAs?**

> I will try to have LAs graded by Thursday or Friday each week.

**Will mini-projects always be due on Thursdays and LAs always on Mondays?**

> Yes.

### Questions on MP2

**Can I use my code from the lab in which we worked with `BigFraction`?**

> Certainly. But cite your partner.

**Will we get more unit tests?**

> No.

### Questions on the Reading

_Model: Read over these. Start the lab. At some point, I'll ask if
anyone has questions._

**Can you give examples/situations in which one type of polymorphism
is better over the other?**

> We tend to use parametric polymorphism when we want to build a
  new data type that can hold/work with "any type of object" (or
  perhaps some restricted types of objects).  E.g., "I want a
  homogeneous list."

> We tend to use subtype polymorphism when we want to write methods
  that work with a restricted class of object. E.g., "I can do
  this calculation with anything that acts like a number."

**Does the letter used matter when creating a generic interface that
takes multiple type parameters? In the example, T and U were used,
implying that one would continue adding type parameters named V,
W, X, etc., though the java.util.function.Function documentation
used R and V as type parameters. Is there any correlation or
importance to these?**

> You can use whatever letters you want. (You may even be able to use
  words, but no one seems to do so).

> I thought Function uses `T` and `R`. `T` is used because it stands
  for "type". `R` stands for `Result`.

**Is it possible to specify a type within a type specification (For example,
`DynamicArray<DynamicArray<String>>` to make a jagged 2D array of strings)?**

> Yes.

### Questions I'll try to answer later

Could we dive deeper into type safety with generics and how to
handle runtime exceptions related to generics?

Can you explain more about wildcard types (? super T, ? extends T)
and when they are useful in practice?

How do generics in Java compare to mechanisms similar to those in
other programming languages, such as C++ templates?

### Other questions

**Could you explain `this`?**

> We assume that an object is executing each method. At times, we want
  to refer to that object in a method. We use the word `this` to say
  "the object that is executing the method".

> `this.x` means "the field `x` of the object that is executing the
  method."

> We see a difference if we happen to create a parameter or local
  variable that matches a field.

> ```java
public class Example {
  int x;

  void method(int x) {
    x = 2;      // Parameter
    this.x;     // Field
  } // method(int
} // class Example
```

> If we wanted to pass the current object to another method, we can
  just treat `this` as a variable.

> `pen.println(this)`.

Lab
---

We will stop lab at 9:35 so that you have time to discuss MP3 with
your partner.

If you've gotten through exercise 1, 2, or 3, you can leave the remaining
exercises blank.

Meeting with partner
--------------------

* Pick time(s) to meet. 
* Read through the project to make sure you understand.
* Discuss how you want to collaborate.  
* Etc.
