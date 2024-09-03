---
title: "Eboard 01 (Section 1): Getting started"
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
* Lab two: Getting strated with Maven

Preliminaries
-------------

### News / Etc.

* No attendance today, but please say your name when answering or asking
  questions.
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

> Because it makes your code more general (at least once things get more
  complex). It takes a moment to switch your `PrintWriter` from stdout
  to a file, while you'd have to change a lot of lines if you were
  using `System.out`.

> Start with good habits, rather than bad.

> It feels a bit more object-oriented, since you are explicitly creating
  an output object.

What if I want to print debugging output?

> You are generally better off using the debugging tool.

> However, I accept that some debugging output is useful. Please
  use `System.err.println` in such cases.

Could you explain more about `static` keyword in java? In the reading, it says (`static` indicates that the method can run without having an associated object created),, but I don't quite understand.

> "We'll cover it in two weeks."

> The standard model in object-oriented languages is that you (a) create
  an object and then (b) ask the object to do things (by calling methods)
  (also "sending messages").

> Sometimes, there's no natural object.

> We use `static` for the "free-floating" procedures (and variables),
  even if they aren't quite free floating. (Almost) everything must
  be in a class.

> Static methods you can call (somewhat) like you call C functions;
  non-static method require a bit more work.

Can we call a static method on an object?

> Yes, but it's discouraged.

Why is it discouraged?

> Because it can be confusing to the reader. We like to see static methods
  associated with classes and non-static methods associated with objects.

Could you make the `for(String name: names)` thing more clearer because I don't know exactly what name or names represent or String. For example, if String is just where the type goes then just clarify that it is the where the type of the array goes and the same for the rest.

> Sure.

> We often need to do something for each element in an array.

```java
  int[] vals = ...;
  int sum = 0;
  for (int i = 0; i < vals.length; i++) {
    sum += vals[i];
  } // for
```

> We aren't using `i` except to keep track of where we are in the array.
  Java will do that for us in the for-each form ("syntactic sugar").

```java
  int[] vals = ...;
  int sum = 0;
  for (int val : vals) {
    sum += val;
  } // for
```

> This does the same thing as the code up above.

> It's nicer because (a) we don't have to worry about about accidentally
  changing the iteration variable; (b) we don't have to come up with different
  iteration variables for nested loops; (c) we can actually use for-each
  loops for many kinds of collections, not just arrays, so it's
  easy to switch the collection and not change the rest of our code.

How do Maven and other build tools (like Gradle or Ant) compare in terms of features and ease of use?

> I have no idea.

Is a class interchangeable with a file? In other words, can one file only contain one class?

> For the purposes of this course, we'll (generally) expect a one-to-one
  correspondence.  FILE.java will contain the class FILE. (Alternately,
  CLASS will be in the file CLASS.java)

In the input and output section where you were making an object of class PrintWriter, how did you know the parameters of that class? 

> Java reference pages are your friend.

> Reference code is your friend.

> Random internet pages may or may not be your friend.

Is there a difference between import in Java and #include in C?

> Yes! `#include` explicitly puts the text of another file into the
  including file. 

> `import` basically says "Here's a shorthand."

> `import java.io.PrintWriter` just says "When I write `PrintWriter`, I
  mean `java.io.PrintWriter`.

Could you explain the difference between ADTs and Data Structures in a less abstract way? I'm still a bit confused about that. 

Why we put `static` on the main class?

> So that we don't need an object to start our program.

Please explain why we need to use 'new' in Java. What's the functionality?

> Wait until next Tuesday.

Lab: Getting Started with Java
------------------------------

The person closer to the screen is partner A. The person further from the 
screen is partner B.

### Questions

I used VSCode in CSC-161. Can I use VSCode for this lab?

> Certainly.

What folder should I use?

> I'd suggest something like `/home/USERNAME/CSC207/Labs/getting-started`.

Wrapping up ...

* Make a zip file (see instructions).
* Upload your zip file to Gradescope.

Lab: Getting Started with Maven
-------------------------------

Please finish the prior lab up to the `min(int[] arr)` problem (on your own
or with your partner or with anyone).

Please do this one on your own (or with your partner or with anyone). There
is nothing to turn in; this is a "practice to understand" lab.

Side note: Tab is your friend.
