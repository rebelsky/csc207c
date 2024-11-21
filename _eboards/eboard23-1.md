---
title: "Eboard 23 (Section 1): Hash tables"
number: 23
section: eboards
held: 2024-11-21
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* About MP10
* Questions
* Hash table overview
    * Key ideas
    * Hashing
* A hash exercise
* Lab?

Preliminaries
-------------

### News / Notes / Etc.

* I had planned today as a talking day, but we may have time to start
  the lab.
* See, I told you loop invariants were important! (Some of you will 
  understand this comment and some will not.)

### Upcoming work

* Thursday, 2024-11-21 
    * MP10 assigned (due in two weeks)
* Sunday, 2024-11-24
    * [MP9](../mps/mp09) (Blockchains) due.
    * [Submit MP9 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5321058)
* Monday, 2024-11-25
    * No reading for Tuesday! We're continuing our study of hash tables.
    * [Submit post-reflection for MP9](https://www.gradescope.com/courses/818402/assignments/5321060)
    * [SoLA 10](../los/sola10) due
        * New: [ADT/DS #5: Dictionaries](https://www.gradescope.com/courses/818402/assignments/5354889)
        * New: [ADT/DS #7: BSTs](https://www.gradescope.com/courses/818402/assignments/5354897)
        * New: [Development #9: Use libraries](https://www.gradescope.com/courses/818402/assignments/5354901)
        * New: [Development #12: Professional ethics](https://www.gradescope.com/courses/818402/assignments/5354912)
* Wednesday, 2024-11-27
    * Lab writeup from class 24.
* Sunday, 2024-12-01
    * Pre-reflection on MP10 due.
* Monday, 2024-12-02
    * Reading response for class 25.
    * SoLA 11 (optional) due
        * New: ADT/DS #4: Priority queues
        * New: Development #11: Ethical reuse
        * This SoLA is "optional" in that I won't send in AAs after it.
* Thursday, 2024-12-05
    * MP 10 due.
    * MP 11 released (also a group MP).

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Sunday, 2024-11-24, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_
* Tuesday, 2024-11-26, noon--1:00 p.m., Day PDR.
  _CS Table:??? 

#### Cultural

* Weekend of November 23, Roberts Theatre.
  _Pity_
* Saturday, 2024-11-23, 4:00--5:00 p.m., Herrick Chapel.
  _YGB Gospel Choir_
* Sunday, 2024-11-24, 2:00--3:00 p.m., Sebring-Lewis.
  _Collegium Musicum Concert_

#### Multicultural

* Friday, 2024-11-22, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Vietnamese Cafe Culture_ 
* Saturday, 2024-11-23, 5:00--8:00 p.m., Harris Concert Hall.
  _Festa Novembrina_

#### Peer

* Thursday, 2024-11-21, 7:00--8:00 p.m., HSSC S1325.
  _GHAMP Study Break_
* Friday, 2024-11-22, 8:00 p.m., Main Lounge.
  _Improv Double Header_.

#### Wellness

* Tuesday, 2024-11-26, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-12-03, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.

#### Misc

* Fill in the peer-educator evaluation form (see email).
* Friday, 2024-11-22, 5:00--8:00 p.m., Downtown Grinnell.
  _Jingle Bell Holiday_.

### Other good things (no tokens)

* Monday, 2024-11-25, 8:00--10:00 p.m., Bob's Underground.
  _Open Mic Night_.

Notes on MP10
-------------

Questions
---------

### Administrative

### MP9

### MP10

### Miscellaneous

Hash table overview
-------------------

### Key ideas 

_TPS: What are five key ideas about hash tables?_

### Hashing

_TPS: How should we compute a hash value?_

Hash exercise
-------------

### Hash exercise

Compute your "hash code" by adding up the letters in your first name.

```
A:1     B:2     C:3     D:4     E:5     F:6     G:7     H:8     I:9
J:10    K:11    L:12    M:13    N:14    O:15    P:16    Q:17    R:18
S:19    T:20    U:21    V:22    W:23    X:24    Y:25    Z:26
```

For example,

* Samuel -> 19 + 1 + 13 + 21 + 5 + 12 = 71

We will put your names into the hash table on the board.

_TPS: What did we discover?_

Lab
---

If there is time, we will conduct lab. We will continue the lab in the next class.
