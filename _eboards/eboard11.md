---
title: "EBoard 11: Testing and debugging"
number: 11
section: eboards
held: 2023-09-18
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.

_Approximate overview_

* Administrivia
* Questions
* Lab

Administrivia
-------------

### Introductory notes

* Make sure that you have your github keys working!  If not, please stay
  after class and I'll work with you on it.
* Congrats to football for its victory at Beloit!
* Today's lab is somewhat rewritten.  Fingers crossed that everything works
  okay.
    * Make sure that you are using the repo named something like
      `lab-unit-testing-vscode`.
      
### Upcoming Token activities

Academic

* CS Table, Tuesday 19 Sept 2023, Noon, Day PDR, Feeding your data to
  plagiarism detectors.
* CS Extras, Thursday 21 Sept 2023, 4:15 pm, Science 3821.  Study Abroad in CS

Cultural

Peer

Wellness

Misc

### Upcoming work

* Wednesday: More readings, today's lab
* Thursday: MP3
    * Bonus token to the first person who spends four hours on MP3
      and TeamsChats me to tell me how far they got.

Questions
---------

_You can ask questions about anything related to the class!  Self gov
says that you **should** ask those questions._

### Java

### Administrative stuff

When are we doing command-line Java?

> We've done a little.  I'm working on the best time to fit it back
  in to the schedule.

### MP2

Damn, Sam.  That was a long assignment.  Will you continue to give us
such long assignments?

> We should talk about what took so much time.  I'll read over the
  post-assessments and think through it.

Sam, you suck at updating deadlines on gradescope.  Please fix the one
for the post-assessment of MP2.

> Done.  TeamsChat me when you notice screwed up deadlines.

### MP3

### Subtype polymorphism

### Parametric polymorphism and Java generics

Can we talk for a bit about how generics work?

> We often want classes that work with "any" type of value, but we still
  want to instantiate the objects to work with particular types of values.

> For example, we may want lists of things.

> If I have a list of students, I want the Java type system to prevent
  me from doing stupid things with it, like putting President Harris
  on my class list.

> Generics are intended to solve that problem.

> When we create the class, we put type parameters in angle brackets.

        public class MyList<T> {
        } // class MyList<T>

> When we create an object in that class, we specify the type.

        public MyList<Student> csc207 = new MyList<Student>();

> Generics allow us to avoid copying code.

> Generics are also called "Parameterized Polymorphism", because the
  types take "many forms" which are determined by their parameters.

It feels a bit complex.  Will it become more natural?

> Yes.

Observation: When we call the constructor, we need to provide *two*
kinds of parameters: The "normal" parameters we would supply to any
constructor AND the type parameters.

Lab
---

Even with our simple configurations, we are hitting issues with different
folks' VSCode working differently.  I've found that uninstalling the Java
extensions and reinstalling them sometimes helps.

What is `(5 / 9)`?

UI: You can run all of your tests at once or just some of them.

UI: Don't those green checkmarks make you happy?

