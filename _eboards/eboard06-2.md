---
title: "Eboard 06 (Section 2): Inheritance and subtype polymorphism"
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
* Grab a sheet of paper. (This should be a whiteboard, but ....)
* Navigate to the computer.
* The first person at the computer logs in (and, if appropriate, forks
  and clones the repo).
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
* The lab mentions whiteboards. But those seem to have disappeared.
  Use a sheet of paper instead.

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
* Tuesday, 2024-09-24, noon--1:00 p.m., JRC 224A.
  _CS Table_
* Thursday, 2024-09-26, 11:00 a.m.--noon, JRC 101.
  _Scholars' Convocation: 
  Anthony Pinn - "Thoughts on Why Music Matters for the Study of Religion"_

#### Cultural

* Friday, 2024-09-20, 7:30 p.m., Sebring Lewis.
  _Jazz Band: Hits from the 80's, 90's, and naughts._
* Saturday, 2024-09-21, 2:00--3:00ish p.m., Sebring-Lewis.
  _Grinnell Symphony Orchestra plays Hungarian dances and more._

#### Multicultural

* Friday, 4:00 p.m., Middle of Everywhere

#### Peer

#### Wellness

* Tuesday, 2024-09-17, 4:00--5:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_
* Tuesday, 2024-09-17, 6:00--7:00 p.m., Harris Concert Hall.
  _Apple Nachos with ResLife (Not-chos)_
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

### Questions on LAs

**How much time can we spend on an LA?**

> As much as you want.

**How much time _should_ we spend on an LA?**

> Here's my model.

> (a) Hmmm ... I know I did this. But where? (5 min). 

> (b) Find that thing, copy, paste, edit (5 min). 

> (c) add commentary (5 min) 

> (d) stuff Sam forgot (5 min)

> So about twenty minutes.

**Will you grade SoLA 1 before we have to turn in SoLA 2?**

> That's my goal. However, life is complicated.

** What code should we use for the LAs?**

> You might use code from a lab. You might use code from a mini-project.
  I would prefer code from mini-projects, since it's more "you wrote" than
  "you adapted".

**Can we use the same code for multiple LAs?**

> Certainly. Thanks for asking.

### Questions on MP2

I've put the ones you've sent at the end of the mini-project. But I'll
take new ones now if you have any.

### Please describe polymorphism

**This is not a question but can you go over polymorphism in class?
Just say more things about it? I mean I believe I know what I am
supposed to do but I feel like I want to know more about the process
in a high level way?**

> I will try.

> General meaning: "Many forms".

> In CS, the idea that we can write code that accommodates many forms of
  input (or something like that). We like that because we don't want to
  copy/paste/change code. Keep your code DRY! "Don't Repeat Yourself".
  (If you find yourself writing the same code, write something you can
  reuse instead.)

> Subtype polymorphism: Let's suppose we know that a class has a particular
  method. E.g., "If I know something has a `cost` method, I can add it to
  a shopping cart and compute the total expense."

> We need to be able to have a way to say (a) "This class provides this 
  method"; (b) this other method relies on that first method; (c) make
  Java check it all for us so that we don't write broken code.

> Here's one example we already knew about: Every class provides a 
  `toString` method. That means that we can write code that takes
  an arbitrary object and prints it out in a certain way.

> Example: I want to print things right justified. In a non-polymorphic
  world, I'd need printStringRightJustified, printIntRightJustfiied,
  printRealRightJustfified, ...

> Because I know that all values have a `toString` method, I can write
  one method that will do right-justified printing.

> ```
    public static void rightJustify(PrintWriter pen, Object obj, int width) {
      String str = obj.toString();
      String result;
      if (str.length() > width) {
        result = str.substring(0, width);
      } else {
        result = " ".repeat(width - str.length()) + str;
      }
      pen.println(result);
    } // rightJustify
```

> `rightJustify` is polymorphic.

> The idea for today's class is that interfaces help us write polymorphic
  procedures; we write procedures that an interface as a parameter and will
  then work for anything that implements that interface.

> The basic idea is that we can write a single function (method) that will 
  work with a bunch of types (but not necessarily all types).

### Other questions on the readings

_New approach. Read through the questions and answers on the eboard. Let me 
know if any are puzzling or if you have followup questions._

#### Stores (or purchases)

**For the cost interface, can you give an example of what calling the cost method would look like for an object BulkSolid?**

> ```
    BulkSolid threePoundsFlour = new BulkSolid("flour", 3, 30);
    pen.println(threePoundsFlour + " costs " + threePoundsFlour.cost() 
        + "cents");
```

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

> If there's only one clear implementation, you might start with a
  class. But if we're designing something general, we tend to start with
  interfaces.

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

### Questions and answers

**What Git commands should I use?**

> They are now in the lab. Reload to see.

**Where does the "(at $8.99)" come from in the store output?**

> It's from the `toString()` method of `Item`.

**What is `String.format()`?**

> It's like `sprintf`, but a little nicer. (If you don't know `sprintf`,
  it's like `printf`, but it prints to a string rather than to a stream/fd.)

**Can I just run the main programs from VSCode?**

> Sure.

