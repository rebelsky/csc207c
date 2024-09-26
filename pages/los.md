---
title: Learning Objectives and Learning Assessments
summary: What we expect you to learn
permalink: /los/
---
# {{ page.title }}

To directly assess your mastery of the learning objectives of this course, we will conduct a series of learning assessments over the course of the semester.
The use LAs of this course is inspired by [mastery-based testing](https://mbtmath.wordpress.com/) practices found in mathematics.

LAs will be given as take-home problems. 

Each LA will correspond to one of the learning objectives described below.

If you do not complete the learning assessment for a learning objective the first time, you will have multiple chances to retry. 

The objectives may change slightly during the semester as the schedule shifts.

In solving those problems, you should only rely on (a) the course Web site, (b) the standard Java reference pages, (c) your notes, and (d) the code you've written. You _may not_ search the Web for answers, you may not use LLMs, and you definitely may not use StackOverflow or Geeks4Geeks or any such sites. When a problem asks you to provide sample code, you should use code you've already written for the class (or updated version of that code).

## Object-Oriented Design

I expect that by the end of the semester, you will have mastered the basics of object-oriented design.  In particular, I expect that you will be able to

* describe and use four pillars of object-oriented design: 
    * encapsulation (_OOP LO #01: Encapsulation_)
    * inheritance, representing a form of the **is-a** relationship (_OOP LO #02: Inheritance_), 
    * composition, representing a form of the **has-a** relationship (_OOP LO #03: Composition_), and
    * polymorphism, including both 
         * parametric polymorphism (_OOP LO #04: Parametric Polymorphism_) and
         * subtype polymorphism (_OOP LO #05: Subtype Polymorphism_);
* apply object-oriented design principles to separate interface from implentation (_OOP LO #06: Data Abstraction_)
* identify and use a variety of basic design patterns (_OOP LO: 07: Design Patterns_), such as Model-View-Controller, Factory, Singleton, Adapter, and Decorator;
* identify objects and classes that will contribute to a program or solution, design those objects and classes, and implement those objects and classes (_OOP LO #08: Object Design_); and
* describe a common layout of objects in memory (_OOP LO #09: Mental Models_).

## Design and Analysis of Algorithms

I expect that by the end of the semester, you will have significantly extended your skills in the design, implementation, and analysis of algorithms.  In particular, I expect that you will be able to

* describe and implement classic algorithms, including
    * binary search (_Algorithms LO #01: Binary Search_), 
    * sequential search (_Algorithms LO #02: Sequential Search_), 
    * insertion sort (_Algorithms LO #03: Insertion Sort_), 
    * selection sort (_Algorithms LO #04: Selection Sort_) [Optional/Bonus], 
    * heap sort (_Algorithms LO #05: Heap Sort_), 
    * Quicksort (_Algorithms LO #06: Quicksort_), 
    * merge sort (_Algorithms LO #07: Merge Sort_),
    * graph and tree traversal (_Algorithms LO #08: Traversal_), and
    * shortest path (_Algorithms LO #09: Shortest path_)
* design new algorithms using a variety of approaches including 
    * greed (_Algorithms LO #10: Greed_) and
    * divide and conquer (_Algorithms LO #11: Divide and Conquer_);
* read and interpret the formal definition of Big-O (_Algorithms LO #12: Big-O Notation_);
* informally analyze the running time of iterative algorithms and the number of steps in complex nested loops (_Algorithms LO #13: Analysis of Iterative Algorithms_);
* informally analyze the running time of recursive algorithms (_Algorithms LO #14: Analysis of Recursive Algorithms_);
* describe use loop invariants and use loop invariants to better design and verify iterative algorithms (_Algorithms LO #15: Loop Invariants_).

## Design and Analysis of Abstract Data Types and Data Structures

I expect that by the end of the semester, you will have significantly extended your skills in the design, implementation, and analysis of abstract data types and algorithms.  In particular, I expect that you will be able to

* describe and implement classic ADTs and data structures, including 
    * lists (_ADT/DS LO #01: Lists_), 
    * stacks (_ADT/DS LO #02: Stacks_),
    * queues (_ADT/DS LO #03: Queues_),
    * priority queues (_ADT/DS LO #04: Priority Queues_), 
    * dictionaries/maps (_ADT/DS LO #05: Dictionaries_), 
    * hash tables (_ADT/DS LO #06: Hash Tables_), 
    * binary search trees (_ADT/DS LO #07: BSTs_), 
    * heaps (_ADT/DS LO #08: Heaps_), and
    * graphs (_ADT/DS LO #09: Graphs_)
* implement one or more data types using arrays (_ADT/DS LO #10: Array-based Structures_);
* implement one or more data types using linked structures (_ADT/DS LO #11: Linked Structures_);
* design new ADTs using the PUM (philosophy, uses, methods) approach (_ADT/DS LO #12: Design ADTs_); 
* design new data structures using the LIA (layout, implement, analyze) approach (_ADT/DS LO #13: Design Data Structures_); and
* design, implement, and use iterators for one or more compound data types (_ADT/DS LO #14: Iterators_).

## Software Design and Development

I expect that by the end of the semester, you will be a competent beginning software developer.  In particular, in addition to having the skills described above, I expect that you will be able to

* work with one or more other students on the creation of a program (_Development LO #01: Collaboration_);
* manage development of multi-file programs in Java using a build tool (in our case, Maven) (_Development LO #02: Build Tools_);
* design, implement, and run unit tests (_Development LO #03: Unit Testing_);
* develop software using an integrated development environment (in our case, Visual Studio Code) (_Development LO #04: IDE_);
* collaborate on and keep track of the development history of code using a version control system* (in our case, Git) (_Development LO #05: Version Control_);
* read, understand, and modify code that you did not write (_Development LO #06: Code Reading_);
* exercise good practices in documenting code and create Javadoc documentation for Java programs (_Development LO #07: Documentation_);
* design and develop libraries for use in other programs (_Development LO #08: Build Libraries_);
* use libraries in your own programs (_Development LO #09: Use Libraries_); 
* signal and recover from errors using exceptions (_Development LO #10: Exceptions_);
* responsibly incorporate code that you did not write into your own program (_Development LO #11: Ethical Reuse_); and
* understand and explain the responsibilities of a software designer (_Development LO #12: Professional Ethics_).

---

## Typical LA structure

The vast majority of LAs look something like the following

> Please provide evidence that you have mastered this learning objective.  Your evidence will often consist of a combination of program code that you've written for the class (or an updated version of that code) and narrative text to explain the code and its relationship to the objective.

> \[a field for your answer\]

> Please include citations, as appropriate.

> \[a field for your answer\]

> \[ \] I certify that the answers above represent my own work, except as indicated in the citations.

## Some notes for successful LAs

_These notes were developed in response to some student answers to LAs._

### General issues

Many of the LAs have two fields, one for your answer and one for any
citations you might have. Use the top field for *both* commentary and
code. Use the citations field only for citations.

Please take the time to anonymize your code.

Please make sure to include reasonable citations.

* Not "Labs" but the particular labs you used (either "Lab on X" or the URL).
* Not "Google" but the particular sites you found using Google that contributed to your answer.

Please follow coding conventions. (You'll get credit even if you don't, but it's good practice to follow coding conventions.)

Please follow good coding practices.

* Decompose.
* When representing ranges, use "lower-bound inclusive, upper-bound exclusive". There's a reason that so many standard procedures follow that model.

When describing code, start with a high-level explanation. Often, that's all you need.

Do not ask me to follow links. Everything you want me to look at belongs in your answer field.

### Object-oriented Programming

#### OOP 1: Encapsulation

* Make sure that you describe encapsulation.
* Make sure that the code you provide appropriately employs encapsulation.
* Make sure to describe the code you've provided.

#### OOP 3: Composition

* Your example need not employ the more complicated form of encapsulation that is used as an alternative to inheritance and involves delegation. A clear instance of the _has-a_ relationship suffices.
* Make sure to describe what composition is.
* Make sure to include code that employs composition.
* Make sure to indicate how and why your code employs composition.

#### OOP 4: Parametric polymorphism (generics)

Make sure that your description of parametric polymorphism does not also apply to subtype polymorphism. They are both kinds of polymorphism, but they achieve their goals in different ways.

Make sure to include code that demonstrates that you understand and can use parametric polymorphism.

#### OOP 5: Subtype polymorphism

Make sure that your description of subtype polymorphism does not also apply to parametric polymorphism. They are both kinds of polymorphism, but they achieve their goals in different ways.

Make sure to include code that demonstrates that you understand and can use subtype polymorphism.

#### OOP 6: Data abstraction

For data abstraction, think about how we've designed ADTs and their corresponding implementations all semester.

Make sure that you explain *why* we want to use data abstraction (why we want to separate interface from implementation). 

Our textblocks are not a very good example of data abstraction, since the interface there is intentionally open-ended. Look for an interface where there is a clear expectation of what each method does; one in which all implementations should do the same thing on the same series of procedure calls.

Your goal here is to think at the internal design level; not separating user interface from implementation, but separating the interface to a library from the underlying implementation of that library.

#### OOP 8: Object design

_Identify objects and classes that will contribute to a program or solution, design those objects and classes, and implement those objects and classes._

Note that this asks you to give a problem, describe what objects and classes will help you solve that problem,, and give the implementation of those classes. A single class, without context, is unlikely to suffice.

### Algorithms 

#### Algorithms 1: Binary search

Make sure your algorithm is correct.

Make sure you explain the inputs and outputs.

Please follow custom and write ranges as "lower-bound inclusive, upper-bound exclusive".

#### Algorithms 3: Insertion sort

Please make the "insert" in insertion sort explicit in both your code (i.e., by writing a separate `insert` procedure) and your narrative.

#### Algorithms 4: Selection sort

Decompose! You should write an `indexOfSmallest` or `indexOfLargest` procedure.

#### Algorithms 5: Merge sort

Please follow custom and write ranges as "lower-bound inclusive, upper-bound exclusive".

#### Algorithms 6: Quicksort

Please follow custom and write ranges as "lower-bound inclusive, upper-bound exclusive".

#### Algorithms 11: Divide and conquer

Make sure that you clearly explain the principle of "divide and conquer" before you go on to your example of you employing that principle.

#### Algorithms 12: Big-O

* Make sure you understand the "is in" notation and why we use it.

### Abstract data types and data structures

#### ADTs/DSs #1: Lists

Even though Java includes it, `get(int i)` is **not** a core list operation.

#### ADTs/DSs #2: Stacks

Here and in other ADTs/DSs, start with the SAM, or at least something like the SAM. At least the SM. At least the S.

#### ADTs/DSs #7: Binary search trees

Bit trees are not BSTs. Neither are heaps.

Please include code for `get` and `set`.

#### ADTs/DSs #10: Array-based structures

Make sure to explain why we use arrays in implementations.

Make sure to explain how you are using an array in the implementation.

Make sure to include code that explicitly works with an array.

#### ADTs/DSs #11: Linked structures

Make sure to explain why we use linked structures.

Make sure to explain what the linked objects are in your structure.  (The "nodes" or equivalent.)

Make sure to include code that uses your linked objects.

#### ADTs/DSs #12: Design ADTs

This LA is a bit less open-ended. I will give you a particular ADT to design. You are responsible for all the parts.

When I say to give me a Java interface, please give a complete interface that I can compile.

#### ADTs/DSs #13: Design data structures

This LA is also less open-ended. I will give you a particular ADT (or at least interface) to implement. You need not write working Java code.  However, you should explain how you will lay out the data (L) and how you will implement the the operations (I).

The analysis part of data structure design means that you analyze the running time of your methods using bit-O notation (A).

### Software design and development

#### Development #1: Collaboration

I need more than "I wrote code with someone else". Please describe your process and why it was successful (or how you made it successful).

#### Development #2: Build tools

In this instance, your "code" will likely be appropriate selections from your `pom.xml` that you've written or modified. You should explain those selections.

You should also explain the basic use of Maven.

#### Development #3: Unit testing
  
I expect to see a mix of tests and explanatory text. The tests should be sensible, real tests. The text should explain what unit testing is and why we use it. You might also describe the tests. 
 
Make sure to include comments in your unit tests. In my experience, you will
forget why you wrote your tests. The comments help us remember. (These probably aren't necessary in all cases, but they are usually good and should be part of your demonstration of best practices.)
  
* Bad: `assertEquals(Expected, Expression);`
* Good: `assertEquals(Expected, Expression, "Message")`
  
#### Development #4: IDEs

Remember that your goal is to demonstrate that you know what an IDE is and that you are capable of using an IDE.

Make sure that your answer would not apply to a more basic program editor.

Do not provide Java code, unless it helps you tell a story.

#### Development #5: Version control
  
Please include a git log from a project.

Remember that the log is supposed to show collaboration. That means there should be more than one committer (or an explanation as to why there's only one committer).

#### Development #6: Code reading

Code reading is more than "there's a for loop here". You should describe the design decisions embedded in the code and the relation of the class to a larger ecosystem. (Why did someone create this class?)

The specification says "_Read, understand, **and modify** code that you did not write._" I'd like to see appropriate modifications and a description of that modification.

#### Development #7: Documentation

Central tips:

* Make sure to use Javadoc comments.
* Make sure to use correct spelling.
* Make sure to comment methods, constructors, and fields.
* Make sure that your comments say more than "Helper method".
* Document parameters, return values, and such.
* Include internal comments to explain more confusing parts of code.
* Do not include internal comments that simply restate what the code does.  `// Add one to x` above `x++;` does not help the reader and therefore just clogs your code.

#### Development #9: Use libraries

Please focus on libraries in which you don't know the internals.  (That is, don't say "I used Sam's X class.") You've demonstrated knowledge of using such libraries in the Code Reading LO.

Most of the libraries you've used are from the Java API.

#### Development #10: Exceptions

_Signal and recover from errors using exceptions._

Make sure you include an example of throwing an exception.

Make sure you include an example of catching an exception (or being ready to catch an exception).

Make sure that your recovery is reasonable.

Narrate both.

---

## Questions and answers

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

**What code should we use for the LAs?**

> You might use code from a lab. You might use code from a mini-project.
  I would prefer code from mini-projects, since it's more "you wrote" than
  "you adapted".

**Can we use the same code for multiple LAs?**

> Certainly. Thanks for asking.

