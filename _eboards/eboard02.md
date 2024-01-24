---
title: "Eboard 02: A bit of Java"
number: 2
section: eboards
held: 2024-01-24
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed.**

_Getting started_ (this will be our normal start-of-class sequence)

* Grab a card.  The card will have a computer name and a location.
* Remember the name and location.
* Drop the card back in the jar.  <-------
* Navigate to the computer.
* Whoever arrives first, log in.
* When both partners arrive, introduce yourselves.

For the future: I'm happy to reserve a (somewhat random) seat at
the front of the classroom for those who need a front seat as an
adjustment or accommodation.  Just let me know.

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
        * Not yet complete.
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

Mini-Project 1
--------------

* Should mostly require C-like knowledge.
* Start early, give yourself breaks.

Reading responses
-----------------

### Expandable array methods

Here's a sample list of methods for simple expandable arrays of strings.

```
void set(int index, String str); // Set the value at the given index to `str`.
String get(int index);           // Returns the String at the given index.
int getLength();                 // Returns the length of the array.
void add(String str);            // Adds `str` to the end of the array.
boolean isFull();                // Determines if the array is full.
void remove(int index);          // Removes the value at the given index.
void replace(int index, String str);  // Replace the value at the given index.
```

Note: The object that's doing the work (and storing the data) is
implicit. We'll write something like

```
myArray.set(5, "hello");
```

### Some of Sam's questions:

What method do we use to create a new expandable array of strings?

> In Java, these will always be named the same thing as our class
  and implicitly return a value in the class.

> When we call them, we write the word `new` before them.

> `new ExpandableStringArray(int initialCapacity)` - Create a new
  expandable array that is guaranteed to hold at least `initialCapacity`
  values.

> `new ExpandableStringArray()` - Create a new expandable array. The client
  shouldn't worry about trivia like how big it initially is.

When does the array expand?

> We expand the expandable array as soon as it fills. (We'll know that
  it's filled because we've kept track of the capacity.)

> We expand the expandable array as soon as we discover it needs more space. **

In what procedures might we discover that we need more space?

> `addToEnd` (only if the length is equal to the capacity)

> `set`. If we discover that the index is beyond the capacity, we
  will have to expand.

What is the "length" of an array / the "end" of the array? Is that
where the value with greatest index is stored?

> The `length` is 1 + the last index we've used.

> The `capacity` is the amount of storage we have.

> The `end` is similar to the length.

How much should we expand when it comes time to expand? (Welcome to a
stupid question that you should know for interviews.)

> For `set`, it must be at least enough that `capacity > index`.

> One option `max(index+1, capacity+1)`

> * We worry about what happens if we call `addToEnd` again and again
    and again.  We'll need to copy all of the data over again and
    again and again.

> * If we add n+1 things, we will copy 1 + 2 + 3 + 4 + ... n = 
    $n(n+1)/2$. That's a lot of data to copy.
    
> Another option. Whenever we need more space, we double the capacity.

> Suppose we add n+1 things again and start with room for 1.
  1 + 2 + 4 + 8 + 16 + 32 + ... + n

> Suppose n = 2^k.  Can we express that sum in terms of 2^k or k or n.

> Let's try some math.

> 1 + 2 = 3 = 2^2 - 1

> 1 + 2 + 4 = 7 = 2^3 - 1

> 1 + 2 + 4 + 8 = 15 = 2^4 - 1

> 1 + 2 + 4 + 8 + 16 = 31 = 2^5 - 1

> 1 + 2 + 4 + 8 + 16 + 32 = 63 = 2^6 - 1

> Oooh! There's a pattern.

> That sum is 2^(k+1) - 1 is approximately 2*n to add n things. So it's
  only about 2 copies per things we add. ("amortized")

What happens if we call `get` without first having `set` a value at
the given location?

> Return `null` to indicate that there's nothing there.

> Issue some other kind of error.

> DO NOT PRINT ERROR MESSAGES!

Are there restrictions on what values we can use as indices for `set`
or `get`?

> `get` between 0 and `length`-1 OR the same value as set; in those
  cases, we return null.

> `set` between 0 and whateverthemaxcapacityofarraysisinourlanguage

When will an expandable array be full?

What does it mean to remove a value from an array?

> It's the same as setting the index to null. (Fast)

> It requires shifting everything in the array. (Slow)

### Implementing expandable arrays in C

_Yes, it's time for LIA_

* Layout: How are we organizing the structure?
* Implementation: How do we implement the individual methods?
* Analysis: How fast are they? (Constant time, Amortized constant time,
  Linear, Amortized linear, other)

An important student question (more coming later).

_I'm confused that it says that arrays are a fixed size in Java,
but then it says we can still expand the array. If the array is a
fixed size, then how do we expand it?_

```C
typedef struct expandableArrayOfStrings {
  char **contents;      // Pointer to an array
  int capacity;         // The number of values we can store in contents.
} Strings;

// Expanding the array
char **oldContents = contents;
contents = (char **) malloc (newsize * sizeof(char *));
// Copy stuff
```

Questions
---------

### Administrative

Where are the double-dagger problems?

> They were at the end of the arrays reading.

### Conceptual

Why are you making us do this?

> We are progressing toward being the people who implement data structures
  rather than just use them.

> But we are also better users if we understand the likely implementations
  and their effects on running time.

Do the people who implement these kinds of things do so in Java, C, or Scheme, or ...?

> We might implement expandable arrays in any language that lacks them
  by default and has fixed-length arrays.

> Throughout the semester, we'll be considering whether we want to implement
  ADTs (data structures) using arrays ("chunks of memory") or as linked
  nodes.

What's "linear" vs. "constant time"?

> Constant time: The number of steps to complete the operation is independent
  of the size of the structure.

> Linear time: The number of  steps to complete the operation varies
  directly with the number of things in the structure (the size of the
  structure).

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
