---
title: "Eboard 02: A bit of Java"
number: 2
section: eboards
held: 2024-01-24
link: true
---
# {{ page.title }}

_Getting started_ (this will be our normal start-of-class sequence)

* Grab a card.  The card will have a computer name and a location.
* Remember the name and location.
* Drop the card back in the jar.
* Navigate to the computer.
* Whoever arrives first, log in.
* When both partners arrive, introduce yourselves.

For the future: I'm happy to reserve a (somewhat random) seat at
the front of the classroom for those who need a front seat as an
adjustment or accommodation.  Just let me know.

**You are probably being recorded, perhaps even transcribed.**

_Approximate overview_

* Administrivia
* Some notes from the reading
* Questions on readings (and other)
* Lab

Preliminaries
-------------

* Welcome back to CSC207!
* I'm still Sam (or SamR)
* Our class mentor is Elene Sturua
* I hope that you were able to survive the ice.
* Things that worry me: Here are the list of times for the readings.
    * 80 min, an hour, 40 min, 75 min, a bit more than an hour, about
      two hours, about four hours, approximately 20 min, 30 min, 
      1-1.5 hours, 1 hour, 1 hour, roughly an hour, 1 hour 30 minutes,
      about three hours, 20 min, approximately two and a half hours,
      about half an hour, 30--45 minutes, an hour (because I started
      at 10pm), around two hours, a little over an hour, 2 hours,
    * What should I do?

### Upcoming work

* Thursday at 11pm: Readings
    * [Git and GitHub](../readings/git)
    * [VSCode](../readings/vscode)
    * Nothing to submit.
* Friday at 1pm: [Today's lab](../labs/getting-started) on [Gradescope](https://www.gradescope.com/courses/690101/assignments/3995041/).
* Friday at 11pm: [Pre-reflection for MP1](https://www.gradescope.com/courses/690101/assignments/3974719/)
* Tuesday at 11pm: [Mini-Project 1](../mps/mp01) 

### Tokens

Academic/Scholarly


* Friday, 2024-01-26, 6:00--7:30 p.m., JRC 101. 
  _Celebration of MLK day with Alan Page_.

Cultural

* Saturday, 2024-01-27, 11:55 a.m.--3:55 p.m., Harris Cinema.
  _Met Opera presents Carmen_.

Peer

* Saturday, 2024-01-27, 10:00 a.m.--1:00 p.m., Field House.
  _Grinnell Track and Field Invitational_.

Wellness

Misc

Reading responses
-----------------

### Expandable array methods

Here's a sample list of expandable array methods.

```
void set(int index, String str); // Set the value at the given index to `str`.
String get(int index);           // Returns the String at the given index.
int getLength();                 // Returns the length of the array.
void add(String str);            // Adds `str` to the end of the array.
boolean isFull();                // Determines if the array is full.
void remove(int index);          // Removes the value at the given index.
roid eplace(int index, String str);  // Replace the value at the given index.
```

Some of Sam's questions:

* How do we create an expandable array?
* When does the array expand?
* What happens if we call `get` without first having `set` a value at
  the given location?
* What is the "length" of an array / the "end" of the array? Is that
  where the value with greatest index is stored?
* When will an expandable array be full?
* What does it mean to remove a value from an array?

### Implementing expandable arrays in C

An important student question (more coming later).

_I'm confused that it says that arrays are a fixed size in Java,
but then it says we can still expand the array. If the array is a
fixed size, then how do we expand it?_

Questions
---------

### Administrative

Where are the double-dagger problems?

> They were at the end of the arrays reading?

### Readings

I think I am not completely clear on when to use "import"  - For
the 1st reading question, I thought I ought to include it, but
VSCode said it was never used, and the program did run fine without
it. How do I know when to write an `import` statement?

> `import` introduces shorthands, and that's about it. If you write 
  `import java.io.PrintWriter`, you can then write `PrintWriter pen`.
  If not, you must refer to all `PrintWriter` objects using 

Can you give a more detailed explanation of why you recommend using PrintWriter rather than System.out.println to print to standard output?

>  Sure. If we have a method and we decide that the output from the method should go to a file, rather than to the screen, it's much easier to make the update if we've had a PrintWriter as the parameter.

In C, we always had to `#include stdio.h`. Is there something similar that we need to import at the beginning of our Java files?

> Nope.

Do you have a preference if we use the buffered reader class or the scanner class?

> I generally prefer `BufferedReader` objects, but it depends on the context.

A strings mutable?

> No, they are not mutable.

Can you get specific parts of strings?

> Yes, you can get specific parts. Refer to the string documentation
  for details on `substring`. (Web search for Java 17 String.)

How do you compare strings?

> You write `str.compareTo(otherStr)`. It returns values like `strcmp`.  That is, 
> * a negative value if `str` precedes `otherStr`, 0
> * 0 if they are the same, and 
> * a positive value if `str` should follow `otherStr`.

In the special Java loop for (s : args), what does s and args represent?

> `s` is a string variable. (In general, it's any variable.)

> `args` is the command-line array, like `argv` in C.

Is Java a one or zero based index? I'm assuming zero based on example code but just double checking.

> Zero-based. Most languages are.

I am still confused as to why Java is all object based and everything
is encapsulated in a class.

> Because the designers made it that way.

I want general guidelines to understand or "grok" Java transitioning
from C to Java.

> I think you'll figure it out as we go.

Where is Java used in the world today?

> Android phones! Lots of now-legacy software.

### Class

Lab
---
