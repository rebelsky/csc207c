---
title: "Eboard 10 (Section 1): Inheritance"
number: 10
section: eboards
held: 2024-10-01
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  [at least if Sam is here and can get the technology working]

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* Questions
* MP5
* Lab

Preliminaries
-------------

### News / Notes / Etc.

_So much stuff to discuss. Feel free to ask questions as we go._ 

#### Grade reports

* Grade reports distributed Sunday night. I'll try to distribute those each
  week after I grade the SoLA.

#### Learning outcomes on lab reports

* When you fill in learning outcomes on a lab report, I'd recommend that 
  you fill them in a form that you could come back to later and review. 
  Answers like "I learned how a certain code can take different parameter 
  types" or "I learned about inheritance" doesn't let you do so.

#### Pre-assessments

* When you fill in the pre-assessment, please try to ask questions. Asking
  (good) questions is a skill that you need to develop, so practice!
* When I ask you to list resources, you should list specific resources
  (preferably with URLs), such as "the reading on inheritance" and not
  something vague like "readings".

#### General skills

* I put this in my last email, but I'll remind you again. At this point
  in the semester, you should know our core tools.
    * You should be able to compile and test code in Maven.
    * You should be able to run and test code in VSCode.
    * You should be able to debug code in VSCode, particularly failed tests.
    * You should be able to push changes to your code to GitHub.
* Why is that I keep saying "Don't use `git add .`; add the files individually",
  and you folks keep typing `git add .`?
    * This is a rhetorical question. Just don't use `git add .`.

#### Mini-projects

* Note that the primary goals of MP4 are:
    * To give you the experience of building a real data structure that
      others could use.
    * To give you more practice writing tests.
* The potential chaos of the shared testing repo is just a pleasant
  additional outcome.
* Because there were style issues in the original repo, I'm increasing the
  number of style issues permitted for M to 20 and E to 10.
* We've already had issues with the shared testing repo. I've been cleaning
  them up as we go.
    * Incorrect code was pushed (at least twice). Please make sure to
      run `mvn test` and ensure that the errors are only test errors.
    * Extra files were added (`.DS_Store`, presumably by someone who
      used `git add .`)
    * At least one test placed inappropriate restrictions on the order
      in which values are reported in `toString()`.
    * The code got reformatted.
* It's been suggested that I remind you that when you submit code to Gradescope
  from GitHub, and then update the code on GitHub, it doesn't automatically.
  get updated on Gradescope.
    * Also: GitHub submission is the preferred mechanism for Gradescope.
* I'm not sure whether I'll be here on Thursday, so I'll talk a little bit
  about MP5 today.

### Upcoming work

* Today, 2024-10-01
    * Consider submitting [lab writeup for class 10](https://www.gradescope.com/courses/818402/assignments/5024091)
* Wednesday, 2024-10-02
    * Readings
        * [Linear Structures](../readings/linear-structures)
        * [Stacks](../readings/stacks)
        * [Queues](../readings/queues)
        * [Priority queues](../readings/priority-queues)
    * [Submit reading response on Gradescope](https://www.gradescope.com/courses/818402/assignments/5041948)
    * [Submit lab writeup for class 10 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5024091)
        * I'd prefer that you submit after the lab.
* Thursday, 2024-10-03
    * [Mini-project 5](../mps/mp05) assigned.
    * Consider submitting [lab writeup for class 11](https://www.gradescope.com/courses/818402/assignments/5066251)
    * [Mini-project 4](../mps/mp04) due (including tests).
    * [Submit MP4 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5025153)
    * Consider submitting [post-reflection for MP4](https://www.gradescope.com/courses/818402/assignments/5025144).
* Friday, 2024-10-04
    * [Submit post-reflection for MP4](https://www.gradescope.com/courses/818402/assignments/5025144)
* sunday, 2024-10-06
    * [Submit pre-reflection for MP5](https://www.gradescope.com/courses/818402/assignments/5066323)
* Monday, 2024-10-07
    * Readings
        * Array-based linear structures
    * [Submit readings on Gradescope](https://www.gradescope.com/courses/818402/assignments/5066370)
    * [Submit lab writeup from class 11 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5066251)
    * [SoLA 4](../sola04)
        * New OOP LAs
            * [OOP #2: Inheritance](https://www.gradescope.com/courses/818402/assignments/5066254)
            * [OOP #6: Data Abstraction](https://www.gradescope.com/courses/818402/assignments/5066257)
        * New Development LAs
            * [Development #01: Collaboration](https://www.gradescope.com/courses/818402/assignments/5066311)
            * [Development #05: Version control](https://www.gradescope.com/courses/818402/assignments/5066313)
            *
        * Consult [the SoLA](../sola04) for links to LA redos.
* Tuesday, 2024-10-08
    * [Redo of MP1](https://www.gradescope.com/courses/818402/assignments/5066068)
        * Include the file `CHANGES.md` that indicates what changes you made.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-10-01, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table: When Robots Attack (or something like that)_
* Sunday, 2024-10-06, 7:00--9:00 p.m., Science 3819.
  _Mentor Session_
* Tuesday, 2024-10-08, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table_

#### Cultural

* Tuesday, 2024-10-01, 11:00a.m.--Noon, Bucksbaum 131.
  _Royce Wolf Recital_

#### Multicultural

* Tuesday, 2024-10-01, 1:00--2:15 p.m., Steiner 205.
  _Crip SpaceTime watch party_
* Friday, 2024-10-04, 4:00-5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_

#### Peer

* Friday, 2024-10-04, 5:30--8:30 p.m., Natatorium.
  _Scarlet and Black_

#### Wellness

* Tuesday, 2024-10-01, 4:30--6:30 p.m., BRAC P103 (Dance Studio).
  _Wellness Yoga_
* Tuesday, 2024-10-01, 4:30--6:30 p.m., ???.
  _Forest Bathing_ (signup required)
* Tuesday, 2024-10-08, 4:30--6:30 p.m., BRAC P103 (Dance Studio).
  _Wellness Yoga_
* Tuesday, 2024-10-08, 4:30--6:30 p.m., ???.
  _Forest Bathing_ (signup required)

#### Misc

* Friday, 2024-10-04--Sunday, 2024-10-06. JRC 101.
  _Pioneer Weekend_

### Other good things (no tokens)

* Tuesday, 2024-10-01, 4:30--6:30 p.m., Springer Field.
  _Men's Soccer vs. Knox_
* Tuesday, 2024-10-01, 7:00--9:00 p.m., Darby.
  _Volleyball vs. Beloit_
* Wednesday, 2024-10-02, 4:00--6:00 p.m., Springer Field.
  _Women's Soccer vs. Knox_

Questions
---------

### Questions on SoLAs

**Why does it take you so long to get SoLAs back to us?**

> It's the nature of the beast. I probably spend five minutes on
  each submission. 5 LAs x 40 submissions/LA x 5 minutes/submission
  = 600 minutes, or about ten hours. (I expect time to go down as you
  start getting used to LAs, since I can often just check "Satisfactory"
  for correct LAs.)

### Questions on MP4

_See [the assignment](../mps/mp04) for most of the Q&A. This section is here to give you the chance to ask more questions._

**I'm worried that people will push incorrect tests.**

> It's a reasonable worry. We all write incorrect tests (even me). But
  I'll be running tests against my code and will try to correct them as
  I find them.

> If you find what seems to be an incorrect test before I do, please 
  let me know.

### Other administrative questions

#### New

### Other questions

MP3
---

### New AsciiBlocks

#### Basic blocks

`Alphabetical`
  : Fill a rectangle with the alphabet.

`Chessboard`
  : Build a "chessboard" of alternating spaces and some character.

`Circle`
  : A filled circle.

`DiagonalFlip`
  : Diagonally "flip" a block.

`Ladder`
  : A ladder of a character side with vertical repetions.

#### Building new blocks from old

`BezierCurveStamp`
  : Another block with a Bezier curve superimposed on it.

`Borders`
  : Grabs only the "borders" of the block (first row, last row, first column,
    last column).

`Checkerboard`
  : Create a checkerboard of two blocks.

`DropShadow`
  : Another block with a drop shadow added.

`DShift`
  : Diagonally shift another block.

`Encrypted`
  : Another block with every character encrypted using something like 
    a Caesar cipher.

`Hollow`
  : The outer edges of another block.

`Matrice`
  : Make a matrice (matrix?) from another block.

`PatternBorder`
  : Another block surrounded by a pattern of letters

`Quartered`
  : Another block broken into four parts with lines around them.

`RandomBlock`
  : Randomizes the characters in each row of a block.

`ReplaceChar`
  : Replace all instances of one character in a Block with another one.

`Transpose`
  : Transposes the block (flips the axes).

### Ascii Art

MP5
---

Goals:

* Get you to think about accessibility.
* Write code that fits into a larger project (even more so than in the
  AsciiBlocks project).
* Reuse your `AssociativeArray`s.
* See a different model of project and assignment design.

Note:

* No Maven!
* Not yet much of a testing infrastructure (hopefully forthcoming).

Lab
---

The person closer to the board is Driver A. The person further from the board is Driver B.

Make sure that the name of the repo ends with `-maven`.

