---
title: "Eboard 04: Objects and classes"
number: 4
section: eboards
held: 2024-09-10
link: true
---
# {{ page.title }}

**You are probably not being recorded** 

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

Preliminaries
-------------

### News / Etc.

* My wife is nearing the end, so I probably won't be in class for the
  few sessions. I'm sorry, but (a) I want to spend as much time as
  possible with her and (b) it seems that I often need to meet with
  people during our class times (doctors, in particular, like to
  round during our morning classes). There will be awesome folks
  here to substitute. I'll also keep working behind the scenes on
  labs and assignments and answering questions.
    * I am happy to try to schedule quick Teams meetings, as long as you
      understand that I may have to back out. Send me times that you would
      be available to meet.
* SoLA 1 should be posted today (as a few separate LAs).
* I've done my best to put the questions from your surveys on the
  course syllabus page.

### Upcoming work

* Readings due Wednesday night
    * [Unit testing](../readings/unit-testing)
    * [Debugging](../readings/debugging)
* Submit [reading responses for class 5](https://www.gradescope.com/courses/818402/assignments/4894859) by 10:30 pm on Wednesday
* Submit [today's lab](https://www.gradescope.com/courses/818402/assignments/4927648) by 10:30 pm on Wednesday (but preferably at the end of class today)
    * Labs will remain "Do as much as you can during class."
    * You may find it useful to complete labs outside of class because
      they will contribute to LAs.
* Complete [mini-project 1](../mps/mp01) by 10:30 p.m. on Thursday, 2024-09-12
    * [Submit MP01 on Gradescope](https://www.gradescope.com/courses/818402/assignments/4927662)
    * Unit tests to be distributed today.
* Submit [Post-reflection for MP01](https://www.gradescope.com/courses/818402/assignments/4899624) by 10:30 p.m. on Friday, 2024-09-13.
* Submit [SoLA 1](../los/sola01) by 10:30 p.m. on Monday, 2024-09-16.
    * [Development #2: Build tools](https://www.gradescope.com/courses/818402/assignments/4927811)
    * [Development #4: IDE](https://www.gradescope.com/courses/818402/assignments/4927696)

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-09-10, noon--1:00 p.m., JRC 224A.
  _CS Table_
* Thursday, 2024-09-12, 11:00 a.m.--noon, JRC 101.
  _Scholars’ Convocation:
   Dr. Jarvis R. Givens - 
   Black Educational History for All Learners_
* Sunday, 2024-09-15, 7:00--8:00 p.m., Noyce 3819.
  _Mentor session_

#### Cultural

#### Multicultural

* Friday, 2024-09-13, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_

#### Peer

#### Wellness

#### Misc

* Wednesday, 2024-09-11, 4:30--6:30 p.m., HSSC A1231 (Kernel/Multipurpose Room).
  _Deloitte Information Session_ (includes at least one CS major)
* Wednesday, 2024-09-11, 7:00--8:00 p.m., HSSC S1325.
  _Saving the Planet One Page at a Time: The Carbon Almanac with Robert Gehorsam ’76_
* Thursday, 2024-09-12, 4:00--7:00 p.m., Central Campus + Kington Plaza.
  _Student Involvement Fair_

### Other good things (no tokens)

* Wednesday, 2024-09-11, 6:00--8:00 p.m., Darby.
  _Volleyball vs. Nebraska Wesleyan._

Notes from Surveys
------------------

Work due

* I try to make the eboard the definitive list of work due.
* The [schedule](../schedule/) should also list most/all things.
* Gradescope should have most things due (although it does not 
  specify readings), but it can be hard to navigate.
* Feel free to ask if you're not sure.

Collaboration

* About 1/3 of Mini-projects will probably be group mini-projects.
* You should feel free to talk to people about mini-projects. You can
  even help someone debug their mini-project. But I had enough instances
  of copying recently that I'd prefer that you not share code with someone
  so that they can learn from it.
* Please don't forget to cite!
* You should feel free to talk about reading problems with others.

Ways to get help from Sam (once things settle down) (in preference order)

* For questions that may apply to multiple people
    * Ask in the reading response (assuming it's relevant)
    * Ask at the start of class
    * Ask in the Q&A channel on Teams
* For individual questions
    * DM me
    * Set up an appointment
    * Wander by during office hours and hope that I don't have an
      appointment
    * Catch me after class
    * Text me
    * Call me

Other resources

* Class mentors (but only during class time and mentor sessions)
    * Do not send your mentors questions
    * Do not interrupt your mentors if you see them doing their own
      work in these classrooms
* Evening tutors (although not for LAs)
    * I think that this semester's evening tutors have all taken
      CSC-207, although not this version
* Each other and other students (although not for LAs)
    * "Other students" will normally be "classmates"
    * Upper-level CS students are also often willing to help
* Other faculty
* We also have individual tutors available for students who request
  them (at least for the time being; the College has been cutting
  funding)
* Academic advising can also help with individual study skills
* Sarah Dahlby Albright, our Peer Education Coordinator, can talk
  with you about CS-related study skills

Questions
---------

### Questions on MP1

I've put these at the end of the mini-project.

### Questions on Maven

**Can you explain a bit more about the reasons for the steps in Maven?**

> Big picture: We want to be able to type commands to accomplish the core tasks related to a project, and do so the same way for each project. These tasks are (a) _compiling the code_ (which we often do to find some syntax errors), _testing the code_ (which we often do to find some implementation issues), _packaging the code_ (which makes it ready for others), _style checking_ (because we want good style), and _running the code_.

> Almost everything else in the reading is how to set up the Maven configuration file, called `pom.xml`, to tell it what we want done for each of those steps.

### Questions on the readings

**Why would you choose to make your own `hashCode` method rather than relying on the built-in one?**

> Because the built-in one tries to give a different hash code to each object, even if two objects are conceptually equal. For example, if I define `v1` as `new Vec2D(0,1)` and `v2` as `new Vec2D(0,1)`, those two objects will likely have different hash codes.

Labs
----

The person closer to the board is **_A_**. The person further from the board
is **_B_**.

You will not be submitting code. Rather, I ask you to reflect on three
important things you learned.
