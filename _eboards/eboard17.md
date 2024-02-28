---
title: "Eboard 17: Iterators"
number: 17
section: eboards
held: 2024-02-28
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed.**

_Approximate overview_

* Administrivia
* Questions
* Lab

Preliminaries
-------------

* I've revised my target for returning the first set of LAs. 
* There is no reading for Friday.
* Those of you planning to declare CS majors should make sure to fill
  out the form by 5pm today. 
    * If you don't fill out the form, you won't get an advisor. 
    * If you don't get an advisor, you won't be able to declare a CS major.
    * If you don't declare a CS major, you probably won't be able to take
      any more CS classes.

### Some comments from LAs

* Please try to use realistic examples rather than contrived ones.
* Please cite carefully. I saw code from labs, which suggests that it
  was done with someone else, that was not cited.
* Make sure to include code. I will not follow links when grading.
* Don't grab code from random places on the Interweb.
* If you can't click the academic honesty statement, we should chat. You
  can find another example to use.
* Please don't include your name in LA answers.

Code concerns

* **Do not use double values for values that should be exact.**
* Do not print error messages from utility functions. We strive to
  be better than 
* Please follow Java standards. For example, capitalize class names.
* Please don't double-space your code.

Encapsulation

* Two key concepts, which are ... TPS.
* Why doesn't Sam like the following? (More TPS)

```
public class Monkey {
  /**
   * The monkey's name.
   */
  String name;

  /**
   * The monkey's age.
   */
  int age;

  /**
   * Build a new monkey.
   */
  public Monkey(String name, int age) {
    if (this.age < 0) {
      System.err.println("Invalid age!");
    }
    if (null == this.name ) {
      System.err.println("Invalid name!");
    }
    this.name = name;
    this.age = age;
  } // Monkey(String, int)

  /**
   * Get the name.
   */
  public String getName() {
    return this.name;
  } // getName()

  /**
   * Set the name.
   */
  public void setName(String newName) {
    this.name = newName;
  } // setName(String)

  /**
   * Get the age.
   */
  public int getAge() {
    return this.age;
  } // setAge()

  /**
   * Set the age.
   */
  public void setAge(int newAge) {
    this.age = newAge;
  } // setAge(int)
} // class Monkey
```

Subtype polymorphism

* Is not the same as inheritance.

### New LAs

* I've released a bunch of new LAs as well as opportunities for
  redos of the prior LAs. (I realize you may not get the originals
  in time to redo. However, not all of you submitted them in the
  first go-round.)
* One LA is not like the others. This one asks you to do something new.
  But you have from now until Friday to do it.

### New MP

* Borrowed from elsewhere and then updated.
* We'll look at it together.

### Upcoming work

* Wednesday, 2024-02-28, 11pm, [MP4](../mps/mp04)
    * [_Submit MP4 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4137145/)
* Friday, 2024-03-01, 1pm: Submit Today's Lab
    * [_Submit iterators lab on Gradescope_](...)
* Friday, 2024-03-01, 11pm, Submit the second set of LAs.
    * _Sorry, no Gradescope links_
* Friday, 2024-03-01, 11pm, MP4 post-reflection
* Friday, 2024-03-01, 11pm, MP5 pre-preflection

### Tokens

Academic/Scholarly

* Thursday, 2024-02-29, 11:00-noon, **HSSC Auditorium**
  _Scholars' Convocation: Peter Michael Osera Grinnell Talk_
* Tuesday, 2024-03-05, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-02-27, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.

Cultural

* Saturday, 2024-03-02, 2pm, in Sebring Lewis.
  _Orchestra_, Bartok. Vegetables. More!
* Monday, 2024-03-04, Sebring Lewis.
  _Des Moines Metropolitan Opera: Beauty and the Beast_
* Thursday, 2024-03-07, JRC 101, 8:00-9:30 pm.
  _Writers@Grinnell: Carl Phillips_
* Thursday--Saturday, 2024-03-07 to 2024-03-09, 7:30 p.m.
  _Songs of the Scarlet and Wayback_ (play).
* Saturday, 2024-03-09, Harris Cinema, ??:??
  _Met Opera: Verdi's La Forza del Destino_.

Peer

Wellness

* Friday, 2024-03-01, 7pm in JRC 101.
  _Spa Night_.
* Tuesday, 2024-03-05, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-03-05, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-03-05, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

### Other good things to do (no tokens)

Questions
---------

### Administrative

### MP4

### LAs

### Iterators

### Other topics

Lab
---
