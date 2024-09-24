---
title: "Eboard 08 (Section 2): Exceptional programming"
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
* Reminder: Take cards from outside the jar and drop them in the jar.
* I've been doing my best to respond to questions on Teams and email.
  Please keep them coming. And please ask general questions in the
  Questions channel, rather than via DM.
* Warning! Talk will be long and lab will be short.

### Pre-reflection #3

_Without looking at any resources (e.g., readings, labs, your notes),
write down everything you know that might be useful for this
assignment._

The point of this is that you dump actual code (or pseudocode);
it exercises your brain and your recall ability and builds neural
connections.  Our learning specialists have taught me that "recall
practice" is one of the best ways to develop knowledge.

So not just "Generic types" but rather

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
    * [Submit lab writeup for today's class on Gradescope](https://www.gradescope.com/courses/818402/assignments/5026363)
        * As always, I'd prefer that you submit at the end of class today.
        * You need not complete lab in order to submit the writeup.
* Thursday, 2024-09-26 @ 10:30 p.m.
    * Complete [Mini-Project 3](../mps/mp03)
    * [Submit MP3 on Gradescope](https://www.gradescope.com/courses/818402/assignments/4996582)
    * Mini-Project 4 assigned
* Friday, 2024-09-27 @ 10:30 p.m.
    * Submit [Post-reflection for MP3](https://www.gradescope.com/courses/818402/assignments/4996574) on Gradescope.
        * Recommend that you submit immediately after submitting the MP
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
        * Prefer that you submit at the end of class.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-09-24, noon--1:00 p.m., JRC 224A.
  _CS Table_
* Thursday, 2024-09-26, 11:00 a.m.--noon, JRC 101.
  _Scholars' Convocation: 
  Anthony Pinn - "Thoughts on Why Music Matters for the Study of Religion"_
* Thursday, 2024-09-26, 4:00--5:00 p.m., Science 3821 (I think).
  _CS Extras: Study abroad for CS majors_
* Tuesday, 2024-10-01, noon--1:00 p.m., JRC 224A.
  _CS Table_

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

**I am a bit confused as to how SoLA's are supposed to work. Do we
demonstrate new mastery each week?**

> Each week, you'll get new LAs as well as redos for old LAs. Any topics 
  you get marked Satisfactory, you're done with it. Any topics you haven't
  had marked Satisfactory, you should try again the next week.

**If we don't complete an LA and the comment is "You're missing X", can
I just add X to my LA and turn it in again?**

> In general, you should just correct your answer and turn it in again.

> In a few cases, I may ask you to start from scratch (or you'll be able
  to tell that you should start from scratch).

Should we always do the redos on SoLA N, where N is the current SoLA number?

> Yes. You shouldn't be able to access the old ones.

So if I've mastered an LO, do I just ignore the corresponding LA on the 
next SoLA?

> That's correct. I don't have an easy way to release LAs to only a subset
  of the class.

### Questions on MPs

**If we don't successfully complete an MP, can we just fix the things that
are wrong or should we start again?**

> You should fix the things that are wrong.

**Should we include a note in our README of what we've changed if we
resubmit a mini-project.**

> Yes. Ideally, the graders will have given you a checklist, and you'll
  give us the checklist along with notes as to how you've fixed things.

> If the graders haven't given you a checklist, you should give your own.

**Can we redo MPs with an incomplete or that we didn't turn in at all?**

> Of course. My goal is that you get as many chances as you need. At the
  same time, I want to encourage you to do as much as you can on time, so
  it costs whatever the syllabus says for a redo of an incomplete or 
  non-existent MP.

> The first redo of an R or above is free.

> The first redo of an E is approximately 10,000 tokens.

### Questions on MP3

_All of the questions I've received now appear in MP3. This is just a
placeholder to remind you to ask more questions. I've also included two
that came up indirectly._

**Any hints on horizontally centering a line?** (TPS)

5/11 4/12 5/12

_Suppose our row is five units wide but we want to fit it into something
that is eleven units wide. (E.g., centering "hello" on "abcdefghijk".)
How many spaces do we need before "hello" and how many do we need after?_

> Three on the left and three on the right.

```text
___hello___
abcdefghijk
```

_How did you figure that out?_

* Took the longer length, subtracted the shorter length, divided by two.
  (11 - 5) / 2 = 3.

_Suppose our row is four units wide but we want to fit it into something
that is twelve units wide. (E.g., centering "four" on "abcdefghijkl".)
How many spaces do we need before "four" and how many do we need after?_

> Four on the left and four on the right.

```text
____four____
abcdefghijkl
```
_How did you figure that out?_

* (12 - 4) / 2 = 4

_Suppose our row is five units wide but we want to fit it into something
that is twelve units wide. (E.g., centering "hello" on "abcdefghijkl".)
How many spaces do we need before "hello" and how many do we need after?_

> Three on the left and four on the right.

```text
___hello____
abcdefghijkl
```
_How did you figure that out?_

> See above, plus figuring out that the extra space goes on the right.

_Can you generalize?_

> `(width - str.length()) / 2` on both sides [if it divides evenly]

> `(width - str.length()) / 2` on the left, add 1 on the right.

**Any hints on vertical centering?**

> We calculate "blank lines" above and below, and use that to offset
  within the block.

> So if we're centering something five high (`hello`) on something nine high,
  and we need row `i` of the overall thing, what should we do for the 
  hello part?

> You can assume that `diff` stores the difference between the total height
  and the height of `hello`.

```
   0
   1
HHH2
EEE3
LLL4
LLL5
OOO6
   7
   8
```


> i = 0, enough spaces for the width of the hello block, or 
  `" ".repeat(hello.width())`

> i = 1, The same thing

> i = 2, `hello.row(0)` 

> How do we go from `i` to 0? `i - (diff / 2)`

> i = 3, `hello.row(1)`

> i = 4, `hello.row(2)`

> i = 5, `hello.row(3)`

> i = 6, `hello.row(4)`

> i = 7, spaces (see above), because `i - (diff / 2) >= hello.height()`.

> i = 8, spaces (see above)

Reminder! Sometimes playing with particular examples helps you figure out
a general strategy.

**Do we need spaces after as well as before?**

> Yes! Otherwise, when you do a horizontal composition, things will
  look wrong.

### Administrative questions

**If I turn in a mini-project late, do I need to submit tokens for both the
mini-project and the post-reflection?**

> No, the token for the mini-project suffices for both.

### Check #4

**Can we go over Check #4?**

```
while (scanner.hasNextLine()) {
  pen.print("> ");
  pen.flush();
  String response = scanner.nextLine();
  pen.println(process(response));
} // while
```

**Why didn't that work?**

> `hasNextLine` reads input in order to determine whether there
  is a next line.

**Why this design?**

> It needs to wait for data to make that determination. It can't tell
  until the user types something (or ends the input).

**Can we change our code to make it work the way we'd like?**

```
do {
  pen.print("> ");
  pen.flush();
  String response = scanner.nextLine();
  pen.println(process(response));
} while (scanner.hasNextLine());
```

Nope!

```
while (scanner.hasNextLine()) {
  pen.print("> ");
  pen.flush();
  if (! scanner.hasNextLine()) {
    break;
  } // if
  String response = scanner.nextLine();
  pen.println(process(response));
} // while
```

Ugh! The exceptional version is better.

### Questions on the reading

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

Foreshortened. Sorry.
