---
title: "Eboard 20 (Section 1): Ethics, revisited"
number: 20
section: eboards
held: 2024-11-11
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* Questions
* Analyzing merge sort
* Quicksort
* Lab

Preliminaries
-------------

### News / Notes / Etc.

* We're back to talking today. Thursday should be lab.
* We will likely spend a bit less time on ethics today than I had originally
  planned. I consider it ethical to make sure that you understand the
  sorting material in order to complete the assignment.
* New office hour approach: Use the Outlook scheduling assistant to 
  schedule 15-minute or 30-minute appointments. I'll generally say yes 
  to requests during the day for times that I'm not booked..
    * SAM WILL DEMO!
* Just wondering: Many of you said you'd worked with doubly-linked lists
  in CSC-161. But many of you also only made it through Exercise 3. What
  made things difficult?

### SoLA stuff

* Please review the statement about academic honesty on the SoLA notes
  I sent out yesterday.
* Unfortunately, my SoLA comments are almost always going to be "this is
  something you could improve". If you get it correct, you'll likely just
  get a "sufficient".
    * Insert anecdote.
* My goal is that you are able to provide clear and compelling evidence
  that you understand the stuff. When you use mushy or incorrect language,
  or code that won't be compile, the evidence is not compelling. (It also
  won't be compelling to potential employers/collaborators.)
* A possible standard structure for many MPs. (I did not provide this for you
  before now because I assumed that you learned how to form arguments in
  Tutorial. Not all of you seemed to.)
    * Description of concept. "Parametric polymorphism is ..."
    * Explanation of why we care. "Parametric polymorphism permits us to ..."
    * Library code. "Here's a polymorphic class."
    * Client code. "Here's some code that uses that library code."
    * Analysis. "See how that allowed us to ...."
* For the sorting MPs, you will likely want to use this structure.
    * Overview of the sorting algorithm. "Insertion sort works by ..."
    * Quick dump of characteristics. "Insertion sort is an O(n^2) sorting
      algorithm. ..."
    * Code.
    * Any other comments you have.
* _You don't need to cite those structures when you use them._
* Many of you seem to be way behind on LAs (in that you aren't submitting
  them). I'll be sending in Academic Alerts once I finish grading the
  current SoLA.

### Upcoming work

* Wednesday, 2024-11-12
    * [Reading on trees and tree traversal](../readings/tree-traversal)
    * [Submit reading response on Gradescope](https://www.gradescope.com/courses/818402/assignments/5300048)
* Thursday, 2024-11-14
    * MP9 released.
    * [MP8](../mps/mp08) due.
    * [Submit MP8 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5284854)
* Friday, 2024-11-15
    * [Submit post-reflection for MP8](https://www.gradescope.com/courses/818402/assignments/5284861)
* Sunday, 2024-11-17
    * Submit pre-reflection for MP9.
* Monday, 2024-11-18
    * [SoLA 9](../los/sola09) due.
        * New algorithm LAs.
            * [Algorithms #3: Insertion sort](https://www.gradescope.com/courses/818402/assignments/5308265)
            * [Algorithms #4: Selection sort](https://www.gradescope.com/courses/818402/assignments/5308266)
            * [Algorithms #6: Quicksort](https://www.gradescope.com/courses/818402/assignments/5308269)
            * [Algorithms #7: Merge sort](https://www.gradescope.com/courses/818402/assignments/5308271)
            * [Algorithms #15: Loop invariants](https://www.gradescope.com/courses/818402/assignments/5276666)
        * Repeated LAs are in the SoLA.
    * No reading response!

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-11-12, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table: ???_ 
* Wednesday, 2024-11-13, 4:30--6:00 p.m., the Kernel (HSSC 1231).
  _CS Poster Session_
* Thursday, 2024-11-14, 4:00--5:00 p.m., Science 3821.
  _CS Extras: Securing Emerging Wireless Networks_
* Sunday, 2024-11-17, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_

#### Cultural

* Weekends of November 16 and November 23, Roberts Theatre.
  _Pity_ (also peer)
    * Get tickets at the box office.
* Saturday, 2024-11-16, 2:00--4:00 p.m. (but there's an intermission).
  _Grinnell Symphony Orchestra plays Mozart's symphony number 40._

#### Multicultural

* Friday, 2024-11-08, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Alumni_

#### Peer

* Sunday, 2024-11-10, 2:00 p.m., Sebring-Lewis.
  _Grinnell Singers: Songs of Earth_.

#### Wellness

* Tuesday, 2024-11-12, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-11-12, 4:30--6:30 p.m., Secret Place.
  _Forest Bathing_.
* Tuesday, 2024-11-19, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.

#### Misc

* Monday, 2024-11-18, 7:00 p.m., The Kernel (HSSC A1321) 
  _Considering Technical Roles: Tech Hiring Trends & Alumni in Tech Career Paths with alumni from Microsoft, Google, Intel, and more_
* Friday, 2024-11-22, 5:00--8:00 p.m., Downtown Grinnell.
  _Jingle Bell Holiday_.

### Other good things (no tokens)

DNF, revisited
--------------

### Review

Suppose we have a collection of values. Each value can be red, white, or
blue. We want to rearrange them (in place) so they are in the order
all the reds, then all the whites, then all the blues.

We're going to have a section of reds, a section of whites, a section of blues, and an unprocessed section.

RWBU invariant

```text
+------------+-------------+-------------+-------------+
|   Red      |   White     |   Blue      |XUnprocessed |
+------------+-------------+-------------+-------------+
             |             |             |             |
             r             w             b             n
```

RWUB invariant

```text
+------------+-------------+-------------+-------------+
|  Red       |   White     |XUnprocessed |   Blue      |
+------------+-------------+-------------+-------------+
             |             |             |             |
             r             w             b             n
```

Goal: Get the first remaining unprocessed element into the right section
in constant time. If it's constant time, our DNF algorithm will be $$O(n)$$.

What loop does this suggest? That is, what does your loop body look like
so that you maintain the invariant?

Loop with RWBU invariant

```
int r = ...;
int w = ...;
int b = ...;
while (b < n) {
  // +------------+-------------+-------------+--------------+
  // |  Red       |   White     |   Blue      |X Unprocessed |
  // +------------+-------------+-------------+--------------+
  //              |             |             |              |
  //              r             w             b              n
  if A[b] is Red 
    // +------------+-------------+-------------+--------------+
    // |R Red      R|W  White    W|B  Blue     B|R Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    swap(A, r, w);
    // +------------+-------------+-------------+--------------+
    // |R Red      R|B  White    W|W  Blue     B|R Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    swap(A, r, b)
    // +------------+-------------+-------------+--------------+
    // |R Red      R|R  White    W|W  Blue     B|B Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    r++;
    w++;
    b++;
    // +--------------+-------------+-------------+------------+
    // |R Red      R R| White    W W| Blue     B B|Unprocessed |
    // +--------------+-------------+-------------+------------+
    //                |             |             |            |
    //                r             w             b            n
  else if A[b] is White 
    // +------------+-------------+-------------+--------------+
    // |  Red       |   White     |B  Blue      |W Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    swap(A, w, b);
    // +------------+-------------+-------------+--------------+
    // |  Red       |   White     |W  Blue      |B Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    w++;
    b++;
    // +------------+---------------+-------------+------------+
    // |  Red       |   White      W| Blue       B|Unprocessed |
    // +------------+---------------+-------------+------------+
    //              |               |             |            |
    //              r               w             b            n
  else // if A[b] is Blue
    // +------------+-------------+-------------+--------------+
    // |  Red       |   White     |   Blue      |B Unprocessed |
    // +------------+-------------+-------------+--------------+
    //              |             |             |              |
    //              r             w             b              n
    b++
    // +------------+-------------+---------------+------------+
    // |  Red       |   White     |   Blue       B|Unprocessed |
    // +------------+-------------+---------------+------------+
    //              |             |               |            |
    //              r             w               b            n
} // while
  // +------------------+-------------------+------------------+
  // |       Red        |      White        |      Blue        |
  // +------------------+-------------------+------------------+
  //                    |                   |                  |
  //                    r                   w                  b
```

### Questions!

How should we initial r, w, and b?

Does the algorithm work correctly if there are no red elements?

```
  // +------------------+-------------------+------------------+
  // |      White       |      Blue         |      Unprocessed |
  // +------------------+-------------------+------------------+
  // |                  |                   |                  |
  // r                  w                   b                   
```

Does the algorithm work correctly if there are no white elements?

```
  // +------------------+-------------------+------------------+
  // |      Red         |      Blue         |      Unprocessed |
  // +------------------+-------------------+------------------+
  //                    |                   |                  |
  //                    r,w                 b                   
```

Does the algorithm work correctly if there are no blue elements?

```
  // +------------------+-------------------+------------------+
  // |      Red         |      White        |      Unprocessed |
  // +------------------+-------------------+------------------+
  //                    |                   |                  |
  //                    r                   w,b                   
```

If the answer to any of those is "No", how do we fix the algorithm?

Analyzing merge sort
--------------------

Let's start by writing the recurrence relation.

High-level overview:

*
*
*

Recurrence relation ...

Quicksort
---------

Three key ideas:

* Quicksort is a divide-and-conquer routine
* That attempts to divide the (sub)array into two (or three) parts:
  smaller values and larger values (or smaller, "equal", and larger).
* And does that division using the wonder of randomness.

Questions
---------

### Administrative

**Given that you have not been returning graded MPs promptly, do you 
  anticipate changing the MP requirements for A/B/C?**

> Yes. However, I'm still figuring that out.

**Will you be gracious if we don't get our token reflections in within
  72 hours of the event.**

> Probably.

### Sorting

**Is there a stable version of Quicksort?** 

> I don't know of a stable _in-place_ version of Quicksort. The parition
  routine rearranges things too much.

### Readings

DNF, revisited
--------------

Analysis of merge sort
----------------------

Quicksort
---------

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

Next, we'll move on _TPS questions_.

### Which principles did you find surprising (or most surprising)?  Why?

### Which are your "favorite" principles?

### Which principles do you expect to be hardest to follow?

### What other issues came up?

A case study
------------

_Modified from <https://ethics.acm.org/code-of-ethics/using-the-code/case-dark-ux-patterns/>.  (Please don't look there for analysis.)_

The change request Stewart received was simple enough: replace the web site’s rounded rectangle buttons with arrows and adjust the color palette to one that mixes red and green text. But when Stewart looked at the prototype, he found it confusing. The left arrow suggested that the web site would go back to a previous page or cancel some action; instead, this arrow replaced the button for accepting the company’s default product. The right arrow, on the other hand, upgraded the user to the more expensive category; it also silently added a protection warranty without asking for confirmation. Stewart suggested to his manager that this confusing design would probably trick users into more expensive options that they didn’t want. The response was that these were the changes requested by the client.

Shortly after the updates were released into their production system, Stewart’s team was invited to a celebration. As a result of these changes, revenues at their client had increased significantly over the previous quarter. At the celebration, Stewart overheard some of the client’s managers discussing the small increase for refunds by users who claimed that they didn’t want the protection plan, but there weren’t many. One manager noted several complaints from visually impaired users, who noted that the mixture of red and green text obscured important disclaimers about the product. “So what you’re saying, then, is that the changes worked as planned,” quipped one of the managers.

_TPS: What should Stewart do (or have done)? What ACM principles are relevant?_

Another case study
------------------

_I doubt we'll have time to cover this one._

_Modified from <https://ethics.acm.org/code-of-ethics/using-the-code/case-malware-disruption/>.  Please don't read the analysis._

Rogue Services advertised its web hosting services as “cheap, guaranteed uptime, no matter what.” While some of Rogue’s clients were independent web-based retailers, the majority were focused on malware and spam. Several botnets used Rogue’s reliability guarantees to protect their command-and-control servers from take-down attempts. Spam and other fraudulent services leveraged Rogue for continuous delivery. Corrupted advertisements often linked to code hosted on Rogue to exploit browser vulnerabilities to infect machines with ransomware.

Despite repeated requests from major ISPs and international organizations, Rogue refused to intervene with these services, citing their “no matter what” pledge to their customers. Furthermore, international pressure from other governments failed to induce national-level intervention, as Rogue was based in a country whose laws did not adequately proscribe such hosting activities.

Ultimately, Rogue was forcibly taken offline through a coordinated effort from multiple security vendors working with several government organizations. This effort consisted of a targeted worm that spread through Rogue’s network. This denial-of-service attack successfully took Rogue’s machines offline, destroying much of the data stored with the ISP in the process. All of Rogue’s clients were affected. No other ISPs reported any impact from the worm, as it included mechanisms to limit its spread. As a result of this action, spam and botnet traffic immediately dropped significantly. In addition, new infections of several forms of ransomware ceased.

_TPS: Was the response appropriate?  Ethical?  What principles would permit the security vendors and government organizations to write such software._

