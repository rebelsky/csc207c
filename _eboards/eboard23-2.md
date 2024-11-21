---
title: "Eboard 23 (Section 2): Hash tables"
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
* Applying the ACM guidelines
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

Demo coming on Tuesday (sorry for the delay).

Questions
---------

### Administrative

### MP9

**Are you going to give us a test for the blockchains?**

> Yes. It will be out tonight (if all goes as expected).

### MP10

### Miscellaneous

### Hash tables

_I'll take hash table questions after we discuss them. I'm including them here in case you want to include them in your own discussions._

**I don't understand the `hashCode` method.**

**Can you explain the difference between the hash function and casting types as integers?**

**What does it mean for an object to be 'hashable'? Is it related to the 'hashing' in this reading?**

**It it better for a hash to be an integer, a long, or an array of bytes? Each seem to have their benefits and drawbacks (ints have a relatively small storage size but comparatively few values, longs have a good range of values but a decent size, byte arrays can be any arbitrary size but they are stored as bytes).**

**Just to confirm, if you're chaining and the number of keys in a bucket surpasses the bucket's capacity, we just double the size of that bucket, right? Which means that the main array of buckets is unaffected by this?**

**How is the constant hash function necessarily a problem if we have the solution of chaining where several keys can fall under the same value in the array (that is, they all are under the same sub array). If this doesn't make sense then can you re-explain the constant hash function?**

**Can you explain the hash function for floats?**

**I just wanted to say I don't think I understood hash functions for objects.**

Hash table overview
-------------------

### Key ideas 

_TPS: What are five key ideas about hash tables?_

### Hashing

_TPS: How should we compute a hash value? How about for our `BigFraction` 
class from the start of the semester?_

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

We will put your names into the hash table on the board. (We'll use a probed
hash table with an offset of 1.)

_TPS: What did we discover?_

Questions
---------

_Do you have remaining questions about hash tables?_

**Is it better for a hash to be an integer, a long, or an array of bytes? Each seem to have their benefits and drawbacks (ints have a relatively small storage size but comparatively few values, longs have a good range of values but a decent size, byte arrays can be any arbitrary size but they are stored as bytes).**

ACM guidelines
--------------

Ethics
------

<https://www.acm.org/code-of-ethics>

We will read these aloud so that we reflect a bit more about each.

* 1. GENERAL ETHICAL PRINCIPLES.
    * 1.1 Contribute to society and to human well-being, acknowledging that all people are stakeholders in computing.
    * 1.2 Avoid harm.
    * 1.3 Be honest and trustworthy.
    * 1.4 Be fair and take action not to discriminate.
    * 1.5 Respect the work required to produce new ideas, inventions, creative works, and computing artifacts.
    * 1.6 Respect privacy.
    * 1.7 Honor confidentiality.
* 2. PROFESSIONAL RESPONSIBILITIES.
    * 2.1 Strive to achieve high quality in both the processes and products of professional work.
    * 2.2 Maintain high standards of professional competence, conduct, and ethical practice.
    * 2.3 Know and respect existing rules pertaining to professional work.
    * 2.4 Accept and provide appropriate professional review.
    * 2.5 Give comprehensive and thorough evaluations of computer systems and their impacts, including analysis of possible risks.
    * 2.6 Perform work only in areas of competence.
    * 2.7 Foster public awareness and understanding of computing, related technologies, and their consequences.
    * 2.8 Access computing and communication resources only when authorized or when compelled by the public good.
    * 2.9 Design and implement systems that are robustly and usably secure.
* 3. PROFESSIONAL LEADERSHIP PRINCIPLES.
    * 3.1 Ensure that the public good is the central concern during all professional computing work.
    * 3.2 Articulate, encourage acceptance of, and evaluate fulfillment of social responsibilities by members of the organization or group.
    * 3.3 Manage personnel and resources to enhance the quality of working life.
    * 3.4 Articulate, apply, and support policies and processes that reflect the principles of the Code.
    * 3.5 Create opportunities for members of the organization or group to grow as professionals.
    * 3.6 Use care when modifying or retiring systems.
    * 3.7 Recognize and take special care of systems that become integrated into the infrastructure of society.
* 4. COMPLIANCE WITH THE CODE.
    * 4.1 Uphold, promote, and respect the principles of the Code.
    * 4.2 Treat violations of the Code as inconsistent with membership in the ACM.

Applying the ACM Code of Ethics
-------------------------------

_Modified from <https://ethics.acm.org/code-of-ethics/using-the-code/case-malware-disruption/>.  Please don't read the analysis._

Responsible Services advertised its web hosting services as “cheap, guaranteed uptime, no matter what.” While some of Responsible’s clients were independent web-based retailers, the majority were focused on malware and spam. Several botnets used Responsible’s reliability guarantees to protect their command-and-control servers from take-down attempts. Spam and other fraudulent services leveraged Responsible for continuous delivery. Corrupted advertisements often linked to code hosted on Responsible to exploit browser vulnerabilities to infect machines with ransomware.

Despite repeated requests from major ISPs and international organizations, Responsible refused to intervene with these services, citing their “no matter what” pledge to their customers. Furthermore, international pressure from other governments failed to induce national-level intervention, as Responsible was based in a country whose laws did not adequately proscribe such hosting activities.

Ultimately, Responsible was forcibly taken offline through a coordinated effort from multiple security vendors working with several government organizations. This effort consisted of a targeted worm that spread through Responsible’s network. This denial-of-service attack successfully took Responsible’s machines offline, destroying much of the data stored with the ISP in the process. All of Responsible’s clients were affected. No other ISPs reported any impact from the worm, as it included mechanisms to limit its spread. As a result of this action, spam and botnet traffic immediately dropped significantly. In addition, new infections of several forms of ransomware ceased.

_TPS: Was the response appropriate?  Ethical?  What principles would permit the security vendors and government organizations to write such software._

Lab
---

If there is time, we will conduct lab.
We will continue the lab in the next class. (The partners are the same.)

No lab writeup today.
