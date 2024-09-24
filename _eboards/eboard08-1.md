---
title: "Eboard 08 (Section 1): Exceptional programming"
number: 8
section: eboards
held: 2024-09-24
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  [at least if Sam is here and can get the technology working]

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* Notes from Thursday's lab
* Questions
* Lab

Preliminaries
-------------

### News / Etc.

* I'm still here. I'm unsure about whether I'll be here on Thursday.

### Pre-reflection #3

_Without looking at any resources (e.g., readings, labs, your notes),
write down everything you know that might be useful for this
assignment._

The point of this is that you dump actual code (or pseudocode); it exercises 
your brain and your recall ability and builds neural connections.  Our learning specialists have taught me that "recall practice" is one of the best ways to develop knowledge.

So not "Generic types" but rather

> A generic type looks like `public class Foo<T>`. Throughout the
  code in the class, I can use `T` as a type. When I create a new
  `Foo`, I fill in concrete type, such as `Foo<String> fs = new
  Foo<String>();`.

Not "The String class" but rather

> `str.toCharArray()` converts a string to a character array,
  `new String(char[] arr)` converts back. I know how to reverse arrays
  by having two "pointers" at the two ends and repeatedly swapping
  elements. `str.substring(int start, int finish)` grabs part of
  the string. `str.substring(int start)` also grabs part of the string.
  `str.length()` gives me the length.

Not "JUnit" but rather

> I write `@Test` before each test. `assertEquals(expected,
  computation, message)` is the pattern, so something like
  `assertEquals("Hello", block.row(0), "Row 0 is correct")` will
  be in my code. For edge cases, I can try empty blocks created
  with `Empty` as well as .... There's a bunch of boilerplate that
  goes at the top; I can copy that from my last assignment.

### Upcoming work

* Wednesday, 2024-09-25 @ 10:30 p.m.
    * Readings:
        * [Inheritance](../readings/inheritance)
        * [Composition](../readings/composition)
        * [Mental models of Java](../readings/mental-models)
    * [Submit reading responses on Gradescope](https://www.gradescope.com/courses/818402/assignments/5023796)
        * As always, I'd prefer that you submit at the end of class today.
    * [Submit lab writeup for today's class on Gradescope](https://www.gradescope.com/courses/818402/assignments/5026363)
* Thursday, 2024-09-26 @ 10:30 p.m.
    * Complete [Mini-Project 3](../mps/mp03)
    * [Submit MP3 on Gradescope](https://www.gradescope.com/courses/818402/assignments/4996582)
    * Mini-Project 4 assigned
* Friday, 2024-09-27 @ 10:30 p.m.
    * Submit [Post-reflection for MP3](https://www.gradescope.com/courses/818402/assignments/4996574) on Gradescope.
* Sunday, 2024-09-29 @ 10:30 p.m.
    * Submit [Pre-Reflection for MP4](https://www.gradescope.com/courses/818402/assignments/5025090)
* Monday, 2024-09-30 @ 10:30 pm.
    * Submit [SoLA 3](../los/sola03)
        * [OOP #3: Composition](https://www.gradescope.com/courses/818402/assignments/4966829)
        * [OOP #4: Parametric polymorphism](https://www.gradescope.com/courses/818402/assignments/5012081)
        * [OOP #5: Subtype polymorphism](https://www.gradescope.com/courses/818402/assignments/5012093)
        * [Development #3: Unit testing](https://www.gradescope.com/courses/818402/assignments/5015346)
        * Redo: [Development #2: Build tools](https://www.gradescope.com/courses/818402/assignments/5015347)
        * Redo: [Development #4: IDE](https://www.gradescope.com/courses/818402/assignments/5015348)
        * Redo: [Development #6: Code reading](https://www.gradescope.com/courses/818402/assignments/5015349)
        * Redo: [Development #8: Documentation](https://www.gradescope.com/courses/818402/assignments/5015350)
        * Redo: [OOP #1: Encapsulation](https://www.gradescope.com/courses/818402/assignments/5015351)
    * Readings
    * Submit reading response on Gradescope
    * [Submit lab writeup for class 9 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5024091)

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-09-24, noon--1:00 p.m., JRC 224A.
  _CS Table_
* Thursday, 2024-09-26, 11:00 a.m.--noon, JRC 101.
  _Scholars' Convocation: 
  Anthony Pinn - "Thoughts on Why Music Matters for the Study of Religion"_

#### Cultural

#### Multicultural

* Friday, 2024-09-27, 4:00-5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_.

#### Peer

#### Wellness

#### Misc

### Other good things (no tokens)

Notes from Thursdays's lab
------------------------

### The Singleton Pattern

You may have noted that I said that the predicates we provided follow
"the Singleton pattern". We use the Singleton pattern when we have designed
a class that we'd like to ensure is only instantiated once. For example,
since every `OddInteger` predicate will be exactly the same, we should only
create one such object.

To achieve the Singleton pattern, we usually do the following.

* Create a static public field that contains the one instance of the
  object. Clients will refer to it as `ClassName.FIELD`. In our example,
  that would be `OddInteger.PRED`.
* Create a private constructor. Since the constructor is private, no
  one else can call it.

Questions
---------

### Qustions on SoLAs

**I am a bit confused as to how SoLA's are supposed to work. Do we demonstrate new mastery each week?**

> Each week, you'll get new LAs. Any topics you get marked Satisfactory, you're done with. Any topics you haven't had marked Satisfactory, you should try again the next week.

### Questions on MP3

_All of the questions I've received now appear in MP3. This is just a
placeholder to remind you to ask more questions. I've also included two
that came up indirectly._

**Any hints on horizontally centering a line?**

**Any hints on vertical centering?**

### Administrative questions

**If I turn in a mini-project late, do I need to submit tokens for both the
mini-project and the post-reflection?**

> No, the token for the mini-project suffices for both.

### Questions on the reading

**Can you answer Check #4?**

> [To be answered in class]

**In try/catch, what happens when there is no way to recover?**

> If you can't recover, you should pass on an exception to your caller.

**What does the `super` method in the `YourException` class do?**

> Calls the constructor in `Exception`.

**I still don't understand how we might prefer exceptions rather
than printing error messages. Why and in which situations we might
prefer using exceptions for error handling?.**

> If we are writing library code, we should *never* (or almost
  never) print error messages. Library code should be communicating
  with its caller, rather than with the user. Do you want random text
  to appear on your screen when something goes wrong behind the scenes?

> In terms of exceptions vs. special return values, exceptions seem
  to be cleaner than special return values. We don't have to remember
  what the special return values are. We don't have to pick them.
  And, perhaps most importantly, we're forced to deal with them,
  rather than just say "I'll get to it later."

**Are the errors in try catch predefined in the library or they
should be define by the person writing the code?**

> There are a variety of predefined exceptions we can use, but we can
  also define our own.

> The designer of a method decides what exceptions it might throw.

**When would we choose to print to error and continue or exit program graciously like we did in the last mini-project? Or is it better to throw Exception, try catch and in catch exit program?**

> It depends on what part of the program you're in. If you are writing code deep in the internals, you should throw an Exception so that the calling code can decide what to do. If you're writing a user interface (which is the only time you should be exiting a program or printing error messages), then you must decide what is most appropriate for your user. Personally, I prefer programs that give me a chance to choose whether to recover or quit.

**I struggle with printing to error for the fractions calc project in that I have error print checks in many parts of my program, if I had used throw, then it would print and stop at where it first fail. But then that wouldn't let the program continue processing like the requirements said.**

> Judicious use of the try/catch in the main method should permit you to keep going.

**I saw this from the reading a bit, can you share a bit about errors happening at runtime and compile time?**

> Compile-time errors are issues that we can tell will happen before we even run the program. We should (and must) fix those immediately. Run-time errors happen because something not-quite-expected went wrong: Perhaps the user entered something incorrect; perhaps a device misbehaved. We should design our programs to handle such situations.

**What is a `NumberFormatException`? What is the difference that and a regular `Exception`?

> A `NumberFormatException` is a specific exceptions that we throw to indicate that we were processing a number as a string, and it was formatted it incorrectly. We throw it instead of a regular exception so that the client code can decide how to recover. You can find the details at <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/NumberFormatException.html#>.

**When is it appropriate to use RuntimeException, more specifically? It seems like a cop-out for real error handling.**

> I'd agree. But there are some situations from which we can't recover, such as running out of memory. (E.g., there may not even be enough memory to handle any more steps in recovering.) So we want all the bases covered.

**What are some best practices for handling exceptions in large-scale Java applications?**

> Other than "use them" and "utility code shouldn't print error messages", I don't know of other best practices.

**How can we effectively document custom exceptions to ensure they are used correctly by other developers?**

> Javadoc should suffice. Look at the standard Exceptions for examples.

### Other questions

Lab
---

