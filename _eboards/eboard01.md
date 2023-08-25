---
title: Eboard 01  Getting started
number: 1
section: eboards
held: 2023-08-25
link: true
---
CSC 207 2023S, Class 01:  Getting started
=========================================

_Overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Extra credit
    * Questions
* Course goals
* Course structure
* Academic honesty & LLMs
* ADTs and data structures
* A quick intro to object-oriented design
* Designing a stack ADT (an exercise)

Preliminaries
-------------

### News / Etc.

* Welcome to CSC207!
* I'm Sam (or SamR)
* Our class mentors are Pom Dao and Micah Cantor.
* Since it's the first day of class, I will take attendance.  (_It will take
  me a few weeks to learn all of your names._)
    * "Hi, my name is FORENAME SURNAME."
    * "You can call me PRIMARY_NAME."
    * Optional: "My pronouns are ...."
    * "If you must address me by surname, you can call me
      Mr./Ms./Mx./[nothing] SURNAME."
    * "This semester, I'm excited about TOPIC"

### Excited about

* Seeing people.
* Making money playing card games.
* Holiday season.
* Visit of cool author(s) to campus.  (Sept. 6)
* The heat wave.  Or maybe the end thereof. [x2]
* Pickleball.
* Learning Piano.
* Ceramics.
* Snow.
* Meet new people and learn new things.
* Making snarky suckup comments.
* Collapsing from heatstroke on the soccer field (or ten-minute periods)
* Grading for CS.
* Excelling.
* Bad jokes.
* A/C [x2]
* Learning Java [x2]
* Learning OOP.
* Learn more about CS
* UM
* Fall
* Cooking (and avoiding the dining hall)
* Living in a single [x2]
* Living in a triple
* LIving in a bigger dorm room
* Explore Iowa
* Figuring out why MC Cantor considers this the core of the major.

### Upcoming work

* Read the syllabus and answer questions on it [email]
* Tell me about yourself
* Do some readings
* All will be mailed to you.

### Tokens (Academic/Artistic)

* Scholar's Convocation with President Harris, 11:00 a.m., 31 August 2023, JRC 101.
* Cool book talk on Sep. 6.

### Tokens (Peer)

_None yet._

### Extra credit (Wellness)

_None yet._

### Extra credit (Misc)

_None yet._

### Friday PSA

* There are people who care about you.  Take care of yourself for their
  sake (as well for your own).
* Moderation.  Decide what's right for you; don't give in to 
  peer pressure.
* Consent is ESSENTIAL.

Course goals
------------

* Where you first seriously exercise your skills as a computer scientist
  and as a software developer.
* As a computer scientist, 
    * design and build algorithms
    * algorithms are mathematical formulae that you use to accomplish goals
    * revised: algorithms are sets of unambigious and terminating instructions that you use to accomplish
      goals
        * Goal: That we can use to solve many problems.
    * we often implement the algorithms (and learn from doing so)
    * analyze algorithms: correctness and efficiency
    * design and build data structures and ADTs
    * data structures are ways to represent or organize information (often
      with an understanding of how they are stored in memory)
    * ADT: Abstract Data Type - another way to think about structuring
      data.
    * ADT: Tend to describe *what* we do with the data.
    * Data Structures: Tend to describe *how*
    * We'll look at both.
    * Learn about "the core literature": (many of) the data structures and
      algorithms that every competent computer scientist should know
      about.
* Software developer
    * Collaboration
    * Collaborative version control systems (Git, GitHub)
    * Testing - Building your skills
    * Object-oriented programming
    * Experience building larger systems (or at least systems that
      require more than one or two files).

Course structure
----------------

* See the syllabus.
* We're using mastery grading.
* Not everything is figured out.
* Tokens are available.
* Sam has office hours at random times, use the booiking software if possible.
* Sam responds to DMs and email.
* Warning!  Sam is not as bad as PM, but he's close.  He'll try to do better.
* How do we earn tokens?  Use Gradescope.

Designing a stack ADT (an exercise)
-----------------------------------

Reminder: ADT is "abstract data type", the "what" not the "how".

* PUM
    * Philosophy: A stack is a collection of values with the Last-in, First-out policy
    * Uses (use cases): We would use a stack for ...
        * Brazilian card games.
        * A stack of papers (e.g., grading)
        * Layering in winter.
    * Methods (procedures): These are the most important procedures to provide.
      Sam is a minimalist; 
        * Add (push): in C, we'd write something like add(Stack *s, Value v);
          in Java. we'll write `s.add(v)`
        * Empty: Is the stack empty.  `bool s.empty()`.  In Scheme, we
          could have used the much clearer `empty?`
        * Remove (pop): Remove and return the top thing on the stack
          `Value s.pop()`.
        * NOT reverse; it's not a core application (except for stacks
          used for Brazilian card games).
        * NOT list contents.
        * Look at the top element (top)
          `Value s.top()`.
        * Is the stack full? (maybe)  `bool s.full()`.
        * Create the stack
          `Stack buildStack(TypeOfData, size)`
        * Eliminate the stack
* _**Side note**_: _Write things down!_

Last-minute Stuff
-----------------

* Helpful note: I post these notes on our course Web site.  Stay tuned.
* Less helpful note: I also post recordings.
* PSA: Covid is back on campus.  Consider masking.  Masks available in our classroom.
