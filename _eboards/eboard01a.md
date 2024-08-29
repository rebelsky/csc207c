---
title: "Eboard 01a: Getting started"
number: 1
section: eboards
held: 2024-08-29
link: true
---
# {{ page.title }}

**You are probably being recorded** (and transcribed) (if the technology is working correctly).

_Start of class instructions_

* Optional: Grab a mask
* Grab one of the business cards that have computer names and locations.
* Identify where the corresponding computer is.
* Return the card to the jar.
* When both partners arrive, introduce yourselves.

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Extra credit
    * Questions
* Course goals
* Course structure
* ADTs and data structures
* A quick intro to object-oriented design
* Designing a stack ADT (an exercise)
* Implementing our stack ADT (an exercise)
* Designing an array ADT (another exercise)

Preliminaries
-------------

* Consider grabbing a mask.
* You should know the "pick a card, find a place" process.
* If you don't know the people near you, please introduce yourselves.

### News / Etc.

* Welcome to CSC207!
* I'm Sam (or SamR).
* Our class mentor is Maria Rodriguez.
* We'll be using two "books" for this course: The readings I write (or
  wrote) and CLRS.
* I type class notes in markdown and post to the Web site.
    * It's like magic (I hope).
* You will find that I call on students randomly using a set of cards
  with your names on them.
    * I use this process to give you practice "thinking on your feet",
      as it were.
    * I also use this process to help everyone realize that they are
      not the only one who is puzzled.
    * And I use the process to push you a bit.
    * Feel free to say "I'm not sure" or "I'd prefer not to answer."
    * If you don't want to be called on in class, please let me know.
* We are a community. Treat each other with respect. If you (think you)
  know more than your partner, support, don't overwhelm. 
* Sam is facing some personal issues. There may be some hiccups in the class.

### Upcoming work

* Readings due Monday night
    * [An introduction to Java](../readings/intro-java)
    * [Simple Java for C progammers](../readings/simple-java-c)
    * [Arrays in Java](../readings/arrays)
    * [Build systems and Maven](../readings/maven) (Not yet ready.)
    * Submit double dagger problems 
      [on Gradescope](https://www.gradescope.com/courses/818402/assignments/4844431/submissions)
* Also due Monday night
    * [Syllabus review](https://www.gradescope.com/courses/818402/assignments/4803162/)
    * [Introductory survey](https://www.gradescope.com/courses/818402/assignments/4803174/)

### Tokens

_I don't know what your prior experience with tokens is. I give them
for academic/scholarly events, cultural events, peer events, wellness
events, and a few other things. Only those I record in the daily eboards
are available. Please log them within three days._

_If you'd like to suggest token events, please let me know in advance of 
class._

Academic/Scholarly

* Thursday, 2024-08-29, 11:00 a.m., JRC 101.
  President Anne F. Harris - 
  _Moving Knowledge into Action: Initiatives and Actions in Year Two 
  of the Strategic Plan_.

Cultural

* Thursday, 2024-08-29, 6:00 to 8:00 p.m., Grinnell Museum of Art and environs.
  _Student Night at the Museum_.

Multicultural

* Friday, 2024-08-30, 4:00 to 5:00 p.m., HSSN N1170 - Global Living Room.
  _Middle of Everywhere: Iowa_.

Peer

Wellness

Misc

* Thursday, 2024-08-29, 3:00 p.m. to 7:00 p.m., Central Park.
  _Ag Appreciation Day_.

### Other good things

### Thursday PSA

_I historically give a "Friday PSA" (public service announcement).
Students have encouraged me to continue doing so. Unfortunately,
our class does not meet on Fridays, so I will pretend that we're a
state school, and give you a Thursday PSA. If you find these
annoying, let your class mentor know and they'll tell me to stop._

### Attendance

* Since it's the first day of class, I will take attendance.  
    * It will take me at least a few weeks to learn all of your names.
    * _For the first few weeks of class, please say your name before 
      you ask or answer questions._
        * Please do so even if I've called on you by name. Even if
          I know your name, your classmates may not.
* Today's attendance protocol. When I say your name, answer as follows.
    * "Hi, my name is FORENAME SURNAME."
    * Optional: "My pronouns are ...."
    * "You can call me PRIMARY NAME."
    * "If you must address me by surname, you can call me
      Mr./Ms./Mx./Sr./Srta./etc. SURNAME [San]."
    * "This semester, I'm looking forward to ...."
    * Optional: A question

### Excited about

### Questions

Questions from the reading responses
------------------------------------

Was there a reading?

> Yes. It was on the schedule. I thought it was also in 
  [the email](../handouts/spamr). Did you not get the email?

Could you explain the relationship between traits, mixins, and
Java's forms of polymorphism?

> Perhaps after we've discussed Java's forms of polymorphism.

Maybe explain the concept of Polymorphism and Inheritance, because
I remember learning it from CSC 161, but have forgotten some things
that I don't remember specifically.

> We'll do those in depth in a week or two.

How should we know what strategy to choose for SAM to be efficient?
It feels like we can choose anything but I don't understand the
differences until I start writing the methods.

> Our goal in ADT design is not efficiency; it's to think through
  how we want to use the data. What do we want to be able to do? It's
  only once we look at implementations that we start thinking about
  costs.

How does the Layout of LIA affect the outcome? Is there anything
specific to look out for when choosing the layout for ADT?

> Different layouts will lead to different costs. We should see
  that when we explore different implementations of stacks.

I felt sloppy answering these questions. I mostly used what I knew
from C, and I had trouble envisioning how this would work in an OO
environment. If you could go into more detail about these data
structures are implemented in Java that would be splendid.

> We haven't done any Java or OOP yet. I wouldn't think that you'd
  approach them that way. We'll look at them as C structures or
  functions for the time being. We'll return to stacks and such in
  an OO model in a few weeks. 

How would the basic data structures we learned in 161 (stacks and
queues) be implemented within Java/OOP without using pseudo-code?

> We'll cover those in a few weeks, once we've learned about objects 
  (and perhaps even generics).

For the arrangement question, what were you thinking about as "other 
data"?

> For context, that question reads "Describe a way you might arrange
  a stack in memory. (You might represent the stack as a linked
  structure or an array; what other data would you store in each
  case?)"

> If I were storing the stack as an array in C, in addition to the array,
  I would also store the size of the array (I might call that the
  "capacity" of the stack) and the number of elements in the stack.

```
struct StackOfStrings {
   char **elements;
   int capacity;
   int size;
};
```

> Although a linked implementation of stacks might only require one
  pointer, a linked implementation of queues often requires two (one
  for the front of the queue and one for the back of the queue).

I've read that there are 4 principles: Abstraction, Polymorphism, Encapsulation, Inheritance. The way the reading laid it out is a bit different: Encapsulation, Inheritance, Polymorphism, Composition. Especially in the Encapsulation part, it seems a bit difficult to differentiate between that and Abstraction. Can you go deeper into these 2?

> Great question! Let's wait until we've played with them a bit more.

If there is time maybe an example of a minimalist design ADT?

> Yup, we'll do that for stacks today.

If possible just re-explain how ADT and data structures work together

> The ADT is the **what**. That is, what you want to do with your data. The data structure is the **how**. That is, how we achieve those goals.

> Alternately, the ADT is the `.h` file and the data structure is the 
  `.c` file. At least that holds if we're thinking about collections
  of values.

Course goals
------------

_Get started learning how to be a computer scientist / software developer._

Course structure
----------------

ADTs and data structures
------------------------

_Don't forget to ask me when I use a TLA that you don't understand._

Designing a stack ADT (an exercise)
-----------------------------------

We will use the Think-Pair-Share (TPS) process. You've already _thought_
to yourself (or should have, since it was an assignment). Now it's
time to _pair_ with another person and discuss your answers. Then we
will _share_ with each other.

ADT: Use the SAM approach for ADTs.

* S: Strategy (organizing principle)
* A: Applications
* M: Methods

_Note: This used to be the PUM approach. I thought SAM was easier to remember._

### Strategy

* Stacks are collections of data in which you can add and remove data.
  You add and remove data only at the "top" of the stack.
* Stacks follow a last-in, first-out policy; the thing you remove
  is the most-recently-added of the things still on the stack.

### Applications

* This
* That
* Something else

### Methods

_We will assume that it's a stack of strings. We will also assume that
we're implementing it in C._

_Please make sure you consider parameters, return types, preconditions,
potential questions the client of your stack might have, etc._

_I'll divide your answers into "core methods" (the ones we probably
can't do without) and "optional methods" (the ones we could implement
with the core methods if we wanted to).

#### Core methods

#### Almost-core methods

#### Optional methods

Implementing our stack ADT
--------------------------

We'll use the AAA approach (which used to be the LIA approach and may get 
renamed again).

* Arrangement: How do you lay out the structure in memory?
* Algorithms: Given that arrangement, how do you implement the methods?
  (Broadly; we don't need all the code.)
* Analysis: Given those implementations, how efficient are the methods?
    * We will usually ask how many steps they do as a function of
      the number of values we're working with.
    * We might also ask how much space we use.

### Stack arrangements

*
*
*

### Algorithms, Arrangement 1 (???)

### Analysis, Arrangement 1 (???)

### Algorithms, Arrangement 2 (???)

### Analysis, Arrangement 2 (???)

### Algorithms, Arrangement 3 (???)

### Analysis, Arrangement 3 (???)

Another ADT: Unsized arrays
---------------------------

One of the skills I hope you'll develop in the course is the ability
to design new things (most often, ADTs and data structures). Hence,
in addition to labs, we'll spend a reasonable amount of class time on
design problems. You had a lot of time to think about stacks. You'll
have less time for this.

I'll ask you to take a full minute to _think_ to yourself before you
_pair_ and then _share_.

### Unsized arrays: Strategy

I want things that I can use like arrays, but I don't want to have to
specify their capacity in advance. They should always be big enough
for how I'm using them.

I'd also prefer not to have a different syntax for arrays than for the
structures I build myself.

### Unsized arrays: Applications

### Unsized arrays: Methods

#### Core methods

#### Almost-core methods

#### Optional methods

Implementing ADTs
-----------------

_If we're lucky, we'll have the time to talk through some of these._

### Arrangement

### Algorithms

### Analysis

_Probably not this one._
