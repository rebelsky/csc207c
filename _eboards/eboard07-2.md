---
title: "Eboard 07 (Section 2): Generics and parametric polymorphism"
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
* Notes from the prior lab
* Questions
* Lab
* Time to meet with MP3 partner

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
* Saturday, 2024-09-21, 2:00--3:00ish p.m., Sebring-Lewis.
  _Grinnell Symphony Orchestra plays Hungarian dances and more._
* Saturday, 2024-09-21, 7:30--8:30 p.m., Sebring Lewis.
  _Grinnell Singers and Oratorio Society_

#### Multicultural

* Friday, 2024-09-20, 4:00-5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_.

#### Peer

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

### Questions

**Do we submit one project each or one project together?**

> Just one project for the two (sometimes three) of you.

**Should we share one GitHub repository?**

> Yes. One of my goals is that you have experience working with another
  person in the same repository. (It gets better on the next assignment.)

Notes from Tuesday's lab
------------------------

### "It looks right" vs. "I'm confident that it's right"

The point of the horizontal composition exercise.

Also "What should be the meaning?"

Good tests are important

### Code that could be improved

I am stunned to see how many of you wrote the following for row 0 of
the surrounded box.

```java
    public String row(int i) {
      if (i == 0) {
        return boxChar + boxChar.repeat(contents.width()) + boxChar;
      } else {
        ...
      } // if/else
    } // row(int)
```

_Why would this disturb me?_ (TPS)

* We could just write `boxChar.repeat(contents.width() + 2)`. It's more
  concise.
* We should use `this`. `boxChar.repeat(this.contents.width() + 2)`.
* We should use `this`. `this.boxChar.repeat(this.contents.width() + 2)`.
* Something people might debate: Since we have a `return` do we really
  need an `else`? (Sam's okay with it.)
* We should use `this`. `this.boxChar.repeat(this.width())`.

Questions
---------

### Questions on MP2

**Can I use my code from the lab in which we worked with `BigFraction`?**

> Certainly. But cite your partner.

**Can I have an extension?**

> Sure.

**Should I throw exceptions for illegal input?**

> In `InteractiveCalculator` and `QuickCalculator`, the answer is no.
  You should print an error message and go on.

> In `BFCalculator`, `BFRegisterSet`, `BigFraction`, the answer is also
  no. You should assume they have correct input. Let them fail however
  they fail.

From Sam: What are the stumbling blocks?

> Basic concepts of how to solve it? (a few)

> Maven setup + VSCode is taking more time than it should. (many)

> I didn't start soon enough. (similar)

> It's a long assignment, nothing in particular. (many more)

> Some parts of the assignment are hard, such as parsing strings.

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

Lab
---

We'll try to end at 3:35 so that you have time to meet with your partner(s).

You can submit whatever you've done, whether you are at 1, 2, 3, or 4.

Partner meeting
---------------

* What is your preferred working methodology for this project?
* What is your contact information?
* When can/should we meet? (I'd suggest at least a starting meeting and a
  wrapup meeting.)
* Who creates the repo?
* What should we do before the first meeting?
* Let's read through the project and start thinking about parts.
