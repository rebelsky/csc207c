---
title: "Eboard 06 (Section 1): Inheritance and subtype polymorphism"
number: 6
section: eboards
held: 2024-09-17
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
* Questions
* Lab

Preliminaries
-------------

### News / Etc.

_Trigger Warning! Death and Cancer._

* Life remains complicated in the Rebelsky household.
* I am happy to try to schedule quick Teams meetings, as long as you
  understand that I may have to back out. Send me times that you would
  be available to meet.

### Upcoming work

* Reading due Wednesday night
    * [Generics and parametric polymorphism](https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/readings/generics.html)
* Submit [reading responses for class 7](https://www.gradescope.com/courses/818402/assignments/4966887) by 10:30 pm on Wednesday
* Submit [today's lab](https://www.gradescope.com/courses/818402/assignments/4966896/) by 10:30 pm on Wednesday (but preferably at the end of class today)
    * Labs will remain "Do as much as you can during class."
    * You may find it useful to complete labs outside of class because
      they will contribute to LAs.
    * Today's writeup uses the "what lessons did you learn" style.
* Complete [Mini-Project 2](../mps/mp02) by 10:30 p.m. on Thursday, 2024-09-19
    * [Submit MP02 on Gradescope](https://www.gradescope.com/courses/818402/assignments/4979019)
* Submit [Post-reflection for MP02](https://www.gradescope.com/courses/818402/assignments/4943647) by 10:30 p.m. on Friday, 2024-09-20.
    * I'd recommend doing the post-reflection immediately after you
      complete the mini-project.
* Submit [SoLA 2](../los/sola02) by 10:30 p.m. on Monday, 2024-09-23.
    * [Development #6: Code reading](https://www.gradescope.com/courses/818402/assignments/4966787)
    * [Development #8: Documentation](https://www.gradescope.com/courses/818402/assignments/4966799)
    * [OOP #1: Encapsulation](https://www.gradescope.com/courses/818402/assignments/4966827)
    * Redo: [Development #2: Build tools](https://www.gradescope.com/courses/818402/assignments/4966771)
    * Redo: [Development #4: IDE](https://www.gradescope.com/courses/818402/assignments/4966772)

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-09-17, noon--1:00 p.m., JRC 224A.
  _CS Table_
* Wednesday, 2024-09-18, 7:00--8:15 p.m., HSSC S1325.
  _Writers@Grinnell: 
  Jonathan Meiburg, Communicating the Harmonies of Art and Science_
* Thursday, 2024-09-19, 4:15--??:?? p.m., Herrick Chapel.
  _Writers@Grinnell:
  Jonathan Meiburg, Readings from A Most Remarkable Creature_
* Friday, 2024-09-20, noon--1:00 p.m., JRC 224B (Livermore Dining Room).
  _Policy Issues and Digital Storytelling with Sarah Labowitz '04_
* Friday, 2024-09-20, 4:15--7:00 p.m., CERA.
  _Writers@Grinnell: Bird Watching with Jonathan Meiburg_.
  (Bus leaves JRC at 4:15; you can also drive yourself.)
* Thursday, 2024-09-26, 11:00 a.m.--noon, JRC 101.
  _Scholars' Convocation: 
  Anthony Pinn - "Thoughts on Why Music Matters for the Study of Religion"_

#### Cultural

* Friday, 2024-09-20, 7:30 p.m., Sebring Lewis.
  _Jazz Band: Hits from the 80's, 90's, and naughts._

#### Multicultural

#### Peer

* Saturday, 2024-09-21, 2:00--3:00ish p.m., Sebring-Lewis.
  _Grinnell Symphony Orchestra plays Hungarian dances and more._

#### Wellness

* Tuesday, 2024-09-17, 4:00--5:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_
* Tuesday, 2024-09-17, 6:00--7:00 p.m., Harris Concert Hall.
  _Apple Nachos with ResLife_
    * As far as I can tell, Apple Nachos are almost completely unlike
      real nachos.  No chips. No cheese. No beans. No salsa. No guac.

#### Misc

### Other good things (no tokens)

* Wednesday, 2024-09-18, 6:00--8:00 p.m., Darby Gym.
  _Volleyball vs. Simpson_
* Friday, 2024-09-20, 4:00--6:00 p.m., Darby.
  _Volleyball vs. Loras_
* Friday, 2024-09-20, 8:00--10:00 p.m., Darby.
  _Volleyball vs. Augustanta_ 

Questions
---------

### Questions on MP2

I've put these at the end of the mini-project.

### Questions on the readings

#### Please describe polymorphism

**This is not a question but can you go over polymorphism in class?
Just say more things about it? I mean I believe I know what I am
supposed to do but I feel like I want to know more about the process
in a high level way?**

> I will try.

> Literally, polymorphism means "many forms". In programming, it is often
  the idea that we can write one piece of code that serves multiple purposes
  (adapts nicely to different situations). We want to write such general
  code because we believe in the DRY Principle. (Don't repeat yourself.)

> In subtype polymorphism, we rely on knowledge of methods that an object
  will provide. If I know that an object has a `cost` method, I can purchase
  it, put it on a receipt, etc. etc.  So, the "put on a receipt method" need
  not involve different code for different objects.

> We've aleady been relying on subtype polymorphism in noting that everything
  seems to have a `toString` method.

> ```
  public static void printCentered(PrintWriter pen, Object thing, int width) {
    String thingString = thing.toString();
    pen.println(" ".repeat((width - thingString.length())/2) + thingString);
  } // printCentered(PrintWriter, Object, int)
```

> Polymorphism: `printCentered` will work for any type of object.

> In general, as programmers, we will be designing our own interfaces and
  writing polymorphic methods that take advantage of those interfaces.

#### Stores (or purchases)

**For the cost interface, can you give an example of what calling the cost method would look like for an object BulkSolid?**

> ```
    BulkSolid threePoundsFlour = new BulkSolid("flour", 3, 30);
    pen.println(threePoundsFlour + " costs " + threePoundsFlour.cost() 
        + "cents");
```

> `BulkSolid` objects are `Purchase`s, and `Purchase`s have a `cost`
  method.

**When we implement `Purchase`, we are required to implement `cost`. Where
do we do that?**

> Java will force you to implement `cost` within any class that claims
  to implement Purchase.

#### Blocks

**How should we handle odd-sized differences between horizontally composed objects when centering them vertically?**

> We will preferentially shift them up, with k-1 rows of only one block above, and k rows of one block below.

> Five on the left, two on the right, difference of 3. 1 above, 2 below.

> ```
LEFT
LEFTRIGHT
LEFTRIGHT
LEFT
LEFT
```

> One on the left, two on the right, difference of 1. 0 above, 1 below.

> ```
LEFTRIGHT
    RIGHT
```

#### Design

**How does one decide to start writing an interface instead of a
class? It seems to be very beneficial later on if we want to change
the implementation of the classes. But then this makes me feel like
I should write an interface first all the time because it helps me
define my goals and what I want to achieve.**

> If there's only one clear implementation, you might start with a class. But if we're designing something general, we tend to start with interfaces.

**With the concept of minimalist and maximalist design in mind, if
we knew ahead of time that horizontal composition would be something
these objects would be utilized for, should we have altered some
of the methods in the classes to play nice with composition, or
just leave them as they are? Or is it on a case by case basis for
similar occurrences?**

> I'm not sure what other methods would help with horizontal
  composition. But if we expected to include it, we'd want to make
  sure that there was appropriate support. For the purposes we have,
  it turns out that `width`, `height`, and `row` are surprisingly
  powerful.

**How do I create the best interfaces? It shouldn't be too specific
but at the same time it shouldn't be to general right? But I feel
like that can be hard to balance? or maybe not…?**

> I don't expect you to write the best interfaces right now. You
  are just a novice. You learn to write them with practice. Write
  something, critique it with colleagues, try again.

#### Duck typing, overloading, and polymorphism

**To clarify, Java does not support duck typing?**

> Java does not support duck typing.

**Can you "ducktype" two methods that have same name, return type,
and variable name but different variable types? For example, `int
cost(double i)` and `int cost(int i)`**

> This is called "overloading" rather than "duck typing". For duck
  typing, we really want to be able to have identical calls (same
  parameter types). Overloading is using the same function name
  but different parameter types.

> You've already seen us overload constructors. All the constructors
  for a class have the same name (the name of the class), but different 
  parameter types.

**Is the thing where you make multiple methods that work regardless
of solid or liquid or bulk called function overloading polymorphism
or is that something else? I heard the term in a video for Mini-Project
1 but I'm not sure what it means.**

> We use the term "subtype polymorphism" when we write multiple
  classes that implement the same method with the same parameter.
  (Actually, the more important thing is that we write another method
  that takes advantage of all of the classes having that method.)

> We use the term "overloading" when we write multiple methods with
  the same name but different paraemters.

#### Miscellaneous

**Can interfaces have static methods?**

> Yes.

**What is the difference between `extends` and `implements` and how
do we decide which one to use?**

> You haven't learned `extends` yet. But `extends` is used for
  inheritance (where a class adds to another class) and `implements`
  is used with interfaces. You extend a class; you implement an
  interface.

**When you say "how should we form" were you asking for code or
just a written response?**

> I was just looking for a written response.

**If it was code, what would that look like?**

> If you were writing code, I would expect things like

> ```
int height() {
  return Math.max(left.height(), right.height());
} // height()
```

**Another not question but can we have more pictures? Like maybe
to show how things are connected with each other. I understand if
you can't do that but I think I am a visual learner and that helps
a lot.**

> When I have time to make pictures, I will. I believe that pictures are good.

> We will be doing visual models of objects in the near future.

> Note that psychologists have mostly disproven that learning
  preferences affect learning.

Labs
----

Make sure that you have a whiteboard, marker, and eraser.

The person closer to the board is **_A_**. The person further from the board
is **_B_**.

You will not be submitting code directly (although you will be
giving me the URL of your GitHub repo). Rather, I ask you to reflect
on three important things you learned.
