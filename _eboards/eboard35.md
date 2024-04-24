---
title: "Eboard 35: Probed hash tables"
number: 35
section: eboards
held: 2024-04-24
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* About MP10
* Questions
* Lab
* Prep for next mini-project.

Preliminaries
-------------

* **Please fill in the mentor/tutor evaluation.** (you are currently
  at slightly under 50%; you want tokens/you need tokens)
* New partners today, no matter what I said on Monday.
* Good luck to any tennis players heading to competitions over the weekend!
   * And to trackers and fielders heading out for Thursday's meet.
* I realize that grades have been slow in getting to you. You will
  definitely pass the class if you turned in semi-working code for every
  assignment, even if you got incompletes because of missing files
  (e.g., README) or bad formatting.
* I'm working on Friday's LAs. About half are out there, but have the
  wrong prompts.

### Upcoming work

* Wednesday, 2024-04-24, 11:00pm, MP9
    * [_Submit MP9 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4373469)
* Friday, 2024-04-26, 11:00pm, Post-reflection for [MP9](../mps/mp09)
    * [_Submit MP9 post-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4373433)
    * [_Submit MP10 pre-reflection on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4405174)
* Friday, 2024-04-26, 11:00pm, New set of LAs
* Sunday, 2024-04-28, MP1 second redo
* Sunday, 2024-04-28, MP2 second redo
* Wednesday, 2024-05-01, 11:00pm, MP10
    * [_Submit MP10 on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4405216/)
* Friday, 2024-05-03, 11:00pm, New set of LAs, repeated + old LAs (I hope)

### Tokens

How many tokens do I have? 

> 10,000 each, plus or minus, as long as at least 63% of the class turned
  in the mentor evaluation.

Academic/Scholarly

* Thursday, 2024-04-25, 11am, JRC 101.
  _Scholars' Convocation: Jonathan Rosa on Languages & Identities Beyond Borders_.
* Thursday, 2024-04-25, 4pm, Science 3821.
  _CS Extras: Alex Hubers on the UIowa 4+1 (U2G) program_.
* Thursday, 2024-04-25, 4pm, HSSC N3118.
  _“Beyond Grey Expectations: Seeing Chekhov in Color” by Anna Ivanov_.
* Tuesday, 2024-04-30, noon, Some PDR.
  _CS Table_.
* Tuesday, 2024-04-30, 8:00pm, Science 3819.
  _Mentor Session_. Make Elene and Sam happy. Show up to mentor sessions!
  (Sam and Elene are currently very sad.)

Cultural

* Wednesday, 2024-04-24, 7:30--8:30pm, Bucksbaum.
  _Cornelia Di Gioia Presentation with GSO_.
* Thursday, 2024-04-25, 7:00--8:00, Grinnell Art Museum.
  _Recital by Eric Mcintyre: Lifetimes of Water_
* Friday, 2024-04-26, 4:00--5:00pm, HSSC N1170.
  _Middle of Everywhere_. 
* Friday, 2024-04-26, 4:30--6:00pm, HSSC A2231 (Auditorium).
  _Conversation with Humanity. Climate Change._
* Saturday, 2024-04-27, Harris.
  _ISO Cultural Event._ Please don't destroy the bathroom ceilings.

Peer

* Saturday, 2024-04-27, 12:00--4:00pm, Kington Plaza.
  _Spring Fest_.
  There might be catered food.

Wellness

Misc

* Wednesday, 2024-04-24, 4:00--5:00pm, JCC Lower-Level Conference Room.
  _Leveraging LinkedIn_.
* Friday, 2024-04-26, 8:30--11:00pm, Harris Concert Hall.
  _Drag_.
* Saturday, 2024-04-27, 6:00--11:30pm, Gardner.
  _Mary B. James_.

### Other good things to do (no tokens)

About MP10
----------

_Our last mini-project!_

Your goal: Parse JSON, the JavaScript Object Notation, a common form for sharing data between programs.

JSON lets you have:

* "Objects" (hash tables with strings as keys). Start with `{`, end with
  `}` and have key/value pairs separated by commas in between.
  'STRING' : value.
* Strings: start with double quote `"`, end with double quote `"`, normal
  rules about backslashing in between.
* Arrays : Start with `[`, end with `]`, values separated by commas.
* Numbers (Integers, Reals) : As you might expect.

For fun, you get to design the hash table; you may not use Java's
`HashMap` or anything similar.

You should work in groups of two or three. You may self-select your groups.

Questions
---------

### Administrative

Will you please give detentions to the SEPC member who keeps showing up
late? I find it distracting?

> What's a detention?

### MP9

Could you explain more about `dump`?

> See whiteboard.

How do I change the unicode data into unicode characters?

```
public class UnicodeExample {
  public static void main(String[] args) {
    for (String str : args) {
      int i = Integer.decode("0x" + str);
      System.err.println(i);
    } // for
  } // main(String[])
} // class UnicodeExample
```

That gives us numbers.  We could also use `Integer.parseInt(str, 16)`.

We convert to unicode with `Character.toChars`.

```
public class UnicodeExample {
  public static void main(String[] args) {
    for (String str : args) {
      int i = Integer.decode("0x" + str);
      System.err.println(Character.toChars(i));
    } // for
  } // main(String[])
} // class UnicodeExample
```

Why didn't you just tell us that to start with?

> Because exploring the Javadoc documentation is one of the learning goals
  of the course.

### Hash tables

### Misc

Lab
---

Time for forming groups
-----------------------
