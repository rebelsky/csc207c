---
title: "Eboard 02 (Section 2): Getting started"
number: 2
section: eboards
held: 2024-09-03
link: true
---
# {{ page.title }}

**You are probably being recorded** (and transcribed) (if the technology is working correctly).
    * Otter.ai now times out after ninety minutes, so I may pause after an
      hour to start a second recording.
    * My otter.ai monthly limit has been cut, so I'll do my best to stop
      recording during lab. Hopefully, I'll remember to turn it on for
      announcements. (That probably makes it more convenient, too.)
    * If you talk to me after class, please ensure that I've stopped recording.

_Start of class instructions_

* Optional: Grab a mask
* Grab one of the business cards on the table that have computer names 
  and locations.
* Identify where the corresponding computer is.
* Return the card to the jar.
* Navigate to the computer.
* The first person at the computer logs in.
* When both partners arrive, introduce yourselves.
    * Recommended: Discuss working strengths and areas to improve

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* Questions
* Lab one: Getting started with Java
* Lab two: Getting strated with Maven (take-home)

Preliminaries
-------------

### News / Etc.

* No attendance today, but please say your name when answering or asking
  questions.
    * I'll also walk around and check people off.
* Please do the Maven lab on your own (with help as necessary). There is
  nothing to turn in.
* My wife has taken a turn for the worse, so I will only be on campus
  for my classes (and a few other appointments). I'd prefer asynchronous
  conversations to synchronous, but will set up synchronous appointments
  by request. (Email me or DM me for those requests.)

### Upcoming work

* Readings due Wednesday night
    * [An introduction to Git](../readings/git)
    * [An introduction to GitHub](../readings/github)
    * [An introduction to VSCode](../readings/vscode)
    * [Getting started with Visual Studio Code (video)](https://code.visualstudio.com/docs/introvideos/basics)
* Optional: Submit [reading questions for class 3](https://www.gradescope.com/courses/818402/assignments/4871387/) by 10:30 pm on Wednesday
* Finish the [Getting started with Java lab](../labs/getting-started)
  through "find the minimum in an array". (Nothing to turn in beyond what
  you did in class.)
* Do the [Maven lab](../labs/maven). (Nothing to turn in beyond what you
  did in class.)
* Mini-project 1 to be distributed on Thursday.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

_Today is an exception._

Academic/Scholarly

Cultural

Multicultural

Peer

Wellness

Misc

### Other good things

Questions
---------

Why are you making us create `PrintWriter` objects rather than using 
`System.out`?

> If you use `PrintWriter` objects, it's much easier to change where
  your output goes. You just direct the PrintWriter to a file, or to
  an internet socket, ...

> If you use `System.out`, you have a lot of lines to change.

> Start with good habits.

What if I want to print debugging output?

> Meaning: Insert print statements in a not-quite-working program to 
  see what's happening (and, hopefully, fix it).

> Alternate to print statements: Use a debugger.

> I don't like `System.out` for debugging (in part, because it can
  be hard to distinguish from normal output). Use `System.err` instead.

We have both `BufferedReader` and `Scanner` objects for input. Which
should we use?

> It depends on your goals. If you prefer to have control over what's
  happening (e.g., character-level input), you should use `BufferedReader`
  objects. If you're okay with trusting magic code to parse, say, integers
  or doubles, you can use `Scanner` objects.

Could you explain more about `static` keyword in java? In the reading, it says (`static` indicates that the method can run without having an associated object created), but I don't quite understand.

> In most object-oriented languages, the basic model of a program is 
  to (a) create a bunch of objects, (b) tell those objects to do things
  (or ask them questions) by calling methods (sending messages).

> Some methods don't behave differently for different objects, and doesn't
  rely on state, we make it a `static` method, which means that we don't
  have to create an object in order to use it. (It feels like a normal
  function in C.)

How frequently will we be using static methods?

> If you are doing "real" object-oriented programming, almost never.

> In practice, we'll find some natural locations to write static methods,
  such as when we're writing helper methods for `main`.

How does the `static` modifier affect the program?

> If there isn't a static modifier, you must create an object to use the
  method.

> If there is a static modifier, you can use the method without creating
  a new mobject.

> If there is a static modifier, you can't use the fields of the object
  (because you have no object).

Could you make the `for(String name: names)` thing more clearer because I don't know exactly what name or names represent or String. For example, if String is just where the type goes then just clarify that it is the where the type of the array goes and the same for the rest.

> The normal form of a for each loop is 
  `for (TYPE VARIABLE : COLLECTION) { BODY }`

> For arrays, this is almost exactly like doing an indexed loop, except
  that you can't screw up the index.

```
int[] vals = ...;
int sum = 0;
for (int i = 0; i < vals.length; i++) {
  int val = vals[i];
  sum += val;
  // Or sum += vals[i];
}
pen.printf("The sum is %d\n", sum);
```

> We can use a for-each instead, which is a little cleaner.

```
int[] vals = ...;
int sum = 0;
for (int val : vals) {
  sum += val;
} // for
pen.printf("The sum is %d\n", sum);
```

> We don't have to worry about accidentally screwing up the index variable.

> We don't have to worry about what to name the index variable in nested
  loops.

> This works for other kinds of collections, not just arrays.

> However, you can't normally use for-each to modify the collection.

> You can even do it with an on-the-fly array.

```
int sum = 0;
for (int val : new int[] { 1, 2, 3, 4, 5}) {
  sum += val;
} // for
```

> Note that this code is now in [examples/getting-started/SumThing.java](../examples/getting-started/SumThing.java)

How do Maven and other build tools (like Gradle or Ant) compare in terms of features and ease of use?

> I have no idea.

Is a class interchangeable with a file? In other words, can one file only contain one class?

> For this course, we will generally lmit ourselves to one named class per
  file, with correspondence that CLASS goes into the file CLASS.java
  or FILE.java contains the class named FILE.

In the input and output section where you were making an object of class PrintWriter, how did you know the parameters of that class? 

> I used the Java documentation from Oracle. (Formerly from Sun Microsystems.)

> You could also use other code from the course as references.

> You can use reliable sources on the Interweb.

Is there a difference between `import` in Java and `#include` in C?

> `#include` literally includes the text of the the following file in
  the current file.

> `import` introduces a shorthand. If you write `import java.io.PrintWriter`
  (that is, the PrintWriter class in the java.io package), all you're doing
  is telling the compiler that "When I write `PrintWriter`, I really mean
  `java.io.PrintWriter`).

Could you explain the difference between ADTs and Data Structures in a less abstract way? I'm still a bit confused about that. 

> Not today.

Why do we put `static` on the main class?

> Because we don't want to have to create a new object before running
  our program.

Please explain why we need to use 'new' in Java. What's the functionality?

> Wait until next Tuesday.

Can we use VSCode to edit files?

> Sure. I had assumed that CSC-161 was still using Emacs, but I've since
  learned otherwise.

Where are these questions?

> They came from the reading responses.

> The answers should be in the eboard.

Will there be situations in Java where we need to use pragmas?

> Not in this class.

What is the "throws Exception"

> "Something can go wrong".

What is the difference between the base name and the full qualification?

> For something like `java.io.PrintWriter`, the `PrintWriter` is the base
  name and the `java.io.PrintWriter` is the fully qualified name.

> The benefit of fully qualified names is that because computer scientists
  have limited English creativity, they often reuse names. Fully qualified
  names let us distinguish between, say, the `Arrays` class that comes
  with Java (`java.util.Arrays`) and the one that we're going to build
  (`edu.grinnell.csc207.2024fa.rebelsky.Arrays`).

What is buffering?

> We'll see on Thursday.

Lab: Getting Started with Java
------------------------------

The person closer to the screen is partner A. The person further from the 
screen is partner B.

### Questions

What folder should I use?

> I'd suggest something like `/home/USERNAME/CSC207/Labs/getting-started`.

### Comments

If we give you a name for a file, please use that name. For example,
the `HelloWorld.java` program should have that name. Not `hello.java`.
Not even `helloworld.java`.

If we give you the name for a package, and don't seem to be using 
placeholders, please use the package name. (E.g., `edu.grinnell.csc207.main`)

Learn how to us `mkdir` well.

```
mkdir -p edu/grinnell/csc207/main
```

### Wrapping up ...

* Remove your `.class` files, if you can do so easily.
* Make a zip file of your directory.
  `zip -r lab-getting-started.zip DIR`
* Upload your zip file to Gradescope.

Lab: Getting Started with Maven
-------------------------------

Please finish the prior lab up to the `min(int[] arr)` problem (on your own
or with your partner or with anyone).

Please do this one on your own (or with your partner or with anyone). There
is nothing to turn in; this is a "practice to understand" lab.

Side note: Tab is your friend.
