---
title: "Eboard 07 (Section 1): Parametric polymorphism"
number: 7
section: eboards
held: 2024-09-19
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  [at least if Sam can get the technology working again]

_Start of class instructions_

* Optional: Grab a mask
* Grab one of the business cards on the table that have computer names 
  and locations.
* Identify where the corresponding computer is.
* Return the card to the jar.
* Navigate to the computer.
* The first person at the computer logs in (and, if appropriate, forks
  and clones the repo).
* Grab a piece of paper (one per pair should be enough).
* When both partners arrive, introduce yourselves.
    * Recommended: Discuss working strengths and areas to improve

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* About MP3
* Questions
* Lab

Preliminaries
-------------

### News / Etc.

* Writing MP3 took me far more time than it should have. I did not have
  time to do anything else yesterday. (Other than personal stuff.) In
  particular, I did not review all of your questions for class.
* I am not sure whether or not I'll be here next week. If not, you'll have
  awesome subs.
* I've tried to rearrange the upcoming work section for clarity. Let me
  know if you have problems with it.

### Upcoming work

* TONIGHT @ 10:30 p.m.
    * Complete [Mini-Project 2](../mps/mp02) 
    * [Submit MP02 on Gradescope](https://www.gradescope.com/courses/818402/assignments/4979019)
* Friday, 2024-09-20 @ 10:30 p.m.
    * Submit [Post-reflection for MP02](https://www.gradescope.com/courses/818402/assignments/4943647) by 10:30 p.m. on Friday, 2024-09-20.
        * I'd recommend doing the post-reflection immediately after you
          complete the mini-project.
* Sunday, 2024-09-22 @ 10:30 p.m.
    * Submit [Pre-reflection for MP03](https://www.gradescope.com/courses/818402/assignments/4996560)
* Monday, 2024-09-23 @ 10:30 p.m.
    * Reading on [Exceptions](../readings/exceptions)
        * Whoo! Only one reading.
    * Submit [reading responses for class 8](https://www.gradescope.com/courses/818402/assignments/4996552) 
    * Submit [today's lab](https://www.gradescope.com/courses/818402/assignments/4990860)
        * Today's writeup uses the a new style. Open it up at the start of lab.
    * Submit [SoLA 2](../los/sola02)
* Wednesday, 2024-09-26 @ 10:30 p.m.
    * Readings
    * Submit reading responses on Gradescope
* Thursday, 2024-09-26 @ 10:30 p.m.
    * Complete [Mini-Project 3](../mps/mp03)
    * [Submit MP3 on Gradescope](https://www.gradescope.com/courses/818402/assignments/4996582)
* Friday, 2024-09-27 @ 10:30 p.m.
    * Submit [Post-reflection for MP3](https://www.gradescope.com/courses/818402/assignments/4996574) on Gradescope.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Thursday, 2024-09-19, 4:15--??:?? p.m., Herrick Chapel.
  _Writers@Grinnell:
  Jonathan Meiburg, Readings from A Most Remarkable Creature_
* Friday, 2024-09-20, noon--1:00 p.m., JRC 224B (Livermore Dining Room).
  _Policy Issues and Digital Storytelling with Sarah Labowitz '04_
* Friday, 2024-09-20, 4:15--7:00 p.m., CERA.
  _Writers@Grinnell: Bird Watching with Jonathan Meiburg_.
  (Bus leaves JRC at 4:15; you can also drive yourself.)
* Sunday, 2024-09-22, 7:00--8:00 p.m., Noyce 3819.
  _Mentor Session!_
* Tuesday, 2024-09-24, noon--1:00 p.m., JRC 224A.
  _CS Table_
* Thursday, 2024-09-26, 11:00 a.m.--noon, JRC 101.
  _Scholars' Convocation: 
  Anthony Pinn - "Thoughts on Why Music Matters for the Study of Religion"_

#### Cultural

* Friday, 2024-09-20, 7:30 p.m., Sebring Lewis.
  _Jazz Band: Hits from the 80's, 90's, and naughts_
* Saturday, 2024-09-21, 7:30--8:30 p.m., Sebring Lewis.
  _Grinnell Singers and Oratorio Society_

#### Multicultural

* Friday, 2024-09-20, 4:00-5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_.

#### Peer

* Saturday, 2024-09-21, 2:00--3:00ish p.m., Sebring-Lewis.
  _Grinnell Symphony Orchestra plays Hungarian dances and more._

#### Wellness

#### Misc

### Other good things (no tokens)

* Friday, 2024-09-20, 4:00--6:00 p.m., Darby.
  _Volleyball vs. Loras_
* Friday, 2024-09-20, 8:00--10:00 p.m., Darby.
  _Volleyball vs. Augustanta_ 
* Saturday, 2024-09-21, 11:00 a.m.--1:00 p.m., Springer Field.
  _Men's Soccer vs. Nebraska Wesleyan_
* Saturday, 2024-09-21, 1:00 p.m.--4:00 p.m., Rosenbloom Field.
  _Football vs. Beloit_

About MP3
---------

Like the second half of Tuesday's lab, but extended! Also partnered.
Today's lab partner is your MP partner. If you are not here today, 
Sam will assign you a partner.

I will reserve ten minutes at the end of class today for you to make
plans with your partner (e.g., meeting times).

Notes from Tuesday's lab
------------------------

### "It looks right" vs. "I'm confident that it's right"

The point of the horizontal composition exercise.

Also "What should be the meaning?"

### Code that could be improved

I am stunned to see how many of you wrote the following for row 0 of
the surrounded box.

```
    public String row(int i) {
      if (i == 0) {
        return boxChar + boxChar.repeat(contents.width()) + boxChar;
      } else {
        ...
      } // if/else
    } // row(int)
```

_Why would this disturb me?_ (TPS)

Questions
---------

### Questions on SoLAs

**Will we have time limits on any LAs?**

> Nope. I hope that you can complete most LAs in about twenty minutes
  The model in most cases is that you should (a) check your
  notes/code/memory for something you've written, (b) find that thing,
  (c) copy/paste/edit, and (d) spend a few minutes adding narrative.

### Questions on MP2

**Can I use my code from the lab in which we worked with `BigFraction`?**

> Certainly. But cite your partner.

### Questions on the Reading

_Model: Read over these. Start the lab. At some point, I'll ask if
anyone has questions._

Lab
---
