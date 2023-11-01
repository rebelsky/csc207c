---
title: "EBoard 26: Ethics"
number: 26
section: eboards
held: 2023-10-30
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.
It's probably also being transcribed.

_Approximate overview_

* Administrivia
* Quicksort, revisited
* Questions
* Ethics

Administrivia
-------------

* Happy (almost) halloween!  (or Hollow happyween?)
    * Warning!  If you have not had Hershey's milk chocolate before,
      you may find it disgusting.
* How many of you read the code of ethics for CSC-151?

### Upcoming Token activities

Academic

* CS Table, Tuesday at noon, Options for living past death.  Readings
  outside Curtsinger's office and Eikmeier's office.
* Digital Studies Welcome Session, Tuesday at 4pm, Kington Plaza
* Mediating Polarizing Debates, Wednesday at 4pm in the HSSC Kernel
  (aka "Multipurpose Room", A1231).
* Scholars Convocation, Thursday at 11am in JRC 101. Jarvis Givens
  on "Black Reconstructions: Archival Assembly and the History of
  African American Education"
* CS Extras, Thursday at 4pm.

Cultural

* Halloween concert, Tuesday at 8pm, Herrick
* Shift, the Documentary about RAGBAI, 4:15 pm, Thurday, in the
  HSSC Auditorium.
* An evening of Ukranian Poetry and Music, Thursday, November 2, at
  7:30 pm.

Peer

* Dia De Los Muertos exhibit, all week, Global Living Room (HSSC N1170)
* Dia De Los Muertos Social, Wednesday, 4-6pm, Global Living Room
    * Colada Morada and Pan de Muerto
* Swimming vs. Iowa Central CC, Friday, November 3, at 6pm.
* Football vs. UofC, Saturday, November 4, at noon

Wellness

* Vigil for lives lost in Israel and Gaza/Palestine, today, 4:15 pm, JRC 101

Misc

* GrinTech L33+Code event, Tuesday, 5-6 HSSC 1118

### Other good things (no tokens)

### Upcoming work

* Lots of readings for Wednesday.  See the schedule for details.
* MP6 due Thursday.  

Some notes from last lab
------------------------

* Remember: `Comparator.compare(x,y)` returns _a negative integer_ if `x < y`,
  zero if `x == y`, and _a positive integer_ if `x > y`.  Don't count on
  the negative and positive integers returning -1/1.
* We use bounds (`lo` and `hi` or `lb` and `ub`) to keep track of 
  subvectors.  That often permits us to avoid copying subvectors.
* If you modify values from our state/invariant drawings (e.g., by using 
  a different `large` than I do), make sure that you also modify the state 
  drawings.

Experimenting with Quicksort
----------------------------

See [examples/quicksort/Quicksort.java](../examples/quicksort/Quicksort.java).

Writing Quicksort
-----------------

_Without looking at your notes, come up with an invariant for the main
loop of partition._

```
  private static <T> int partition(T[] vals, Comparator<? super T> order, int lb, int ub) 

+-------+---+--------+---------------+----------+-------+
|       | p |  <= p  |  unprocessed  |   > p    |       |
+-------+---+--------+---------------+----------+-------+
|       |   |        |               |          |
0       lb  lb+1     small           large      ub      length
        pivot
```

_Let's translate that to code._

```
  private static <T> int partition(T[] vals, Comparator<? super T> order, int lb, int ub) {
    // If the subvector is small enough, return

    // Initialize small and large

    // Pick the pivot and put at the front

    // Until the unprocessed section is empty
    while (...) {
      // Advance small, if possible

      // Otherwise, retreat large, if possible

      // Otherwise, swap the leftmost unprocessed element (a large value)
      //   with the rightmost unprocessed element (a small value) and
      //   advance small and retreat large.
    } // while

    // Put the pivot at the end of the small section.
  }
```

Checking math

```
+---+---+---+
|   |   |   |
+---+---+---+
    lb=1
        ub=2

        lb=2
        ub=2
```

Why did we swap `small-1` with the pivot, rather than `small`.

```
+-------+---+--------+----------+-------+
|       | p |  <= p  |   > p    |       |
+-------+---+--------+----------+-------+
|       |   |        |          |       |
0       lb  lb+1     small      ub      length
        pivot        large
```

Answer: The thing at index small is large, as counter-intuitive as that
sounds.

Questions
---------

### Registration

Will we have enough courses to cover demand?

> I think so.  Let's do a back-of-the-envelope calculation.

> 80 majors in the class of 2025, 60 majors in the class of 2024, 
  50 students in the class of 2026 in the two CSC-207's = demand for 
  190 seats.  (This ignores the students going abroad, the seniors who 
  need two courses, the mid-year graduates; as I said, it's a "back 
  of the envelope" calculation.)

> 1 section of 211 (24) + 2 sections of 301 (20 each) + 2 sections
  of 324 (20 each) + 2 sections of 341 (20 each) + 2 sections of
  395 (20 each) = 184 seats.

What happens if the second 395 isn't approved before registration?

> Complex stuff that Sam doesn't understand.  "It's above my pay grade."

This seems unfair to people with two majors, both of which are competitive.

> I agree.

### Quicksort

### MP6

What value do you suggest we take as the median in Quicksort?

> I'm a fan of grabbing a few values and taking the median of those
  values.

> One option: Three random values.

> Another option: First, middle, and last.

Have you tried ChatGPTsort yet?

> Nope.  Soon.

Can we get more efficient than merge sort?

> Not asymptotically with arbitrary data.

> But in practice, using wall clock time, yes.

> For particular kinds of data, there are more efficient sorting algorithms.
  Example: I know the contents of my array are 1..100, each value
  appearing once.  Can I sort quickly?  Yes.  O(n).

Is Quicksort quicker than merge sort?

> We'll see in the competition.  Or you can run experiments yourself.

Can I use multithreading?

> No.

Ethics
------

<https://www.acm.org/code-of-ethics>

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

_TPS questions!_

### Which principles did you find surprising (or most surprising)?  Why?

* Do people really need to be told what leaders should do?  (Yes.)
* I didn't expect to read about modifying systems and longevity.
* 2.6: We're always tempted to throw ourselves into new areas.
  It's how we learn.

### Which are your "favorite" principles?

* Valuing work. 1.5.
* 3.5: Create opportunities for people to grow professionally.  It's
  nice to see expectations of employers.
* 3.6: It would be nice to see people follow the "give a warning."
* It's nice to see that this starts with our obligation to society.

### Which principles do you expect to be hardest to follow?

* 2.6: We're always tempted to throw ourselves into new areas.
  It's how we learn.

A case study
------------

_Modified from <https://ethics.acm.org/code-of-ethics/using-the-code/case-dark-ux-patterns/>.  (Please don't look there for analysis.)_

The change request Stewart received was simple enough: replace the web site’s rounded rectangle buttons with arrows and adjust the color palette to one that mixes red and green text. But when Stewart looked at the prototype, he found it confusing. The left arrow suggested that the web site would go back to a previous page or cancel some action; instead, this arrow replaced the button for accepting the company’s default product. The right arrow, on the other hand, upgraded the user to the more expensive category; it also silently added a protection warranty without asking for confirmation. Stewart suggested to his manager that this confusing design would probably trick users into more expensive options that they didn’t want. The response was that these were the changes requested by the client.

Shortly after the updates were released into their production system, Stewart’s team was invited to a celebration. As a result of these changes, revenues at their client had increased significantly over the previous quarter. At the celebration, Stewart overheard some of the client’s managers discussing the small increase for refunds by users who claimed that they didn’t want the protection plan, but there weren’t many. One manager noted several complaints from visually impaired users, who noted that the mixture of red and green text obscured important disclaimers about the product. “So what you’re saying, then, is that the changes worked as planned,” quipped one of the managers.

_TPS: What should Stewart do (or have done)?_

Another case study
------------------

_Modified from <https://ethics.acm.org/code-of-ethics/using-the-code/case-malware-disruption/>.  Please don't read the analysis._

Rogue Services advertised its web hosting services as “cheap, guaranteed uptime, no matter what.” While some of Rogue’s clients were independent web-based retailers, the majority were focused on malware and spam. Several botnets used Rogue’s reliability guarantees to protect their command-and-control servers from take-down attempts. Spam and other fraudulent services leveraged Rogue for continuous delivery. Corrupted advertisements often linked to code hosted on Rogue to exploit browser vulnerabilities to infect machines with ransomware.

Despite repeated requests from major ISPs and international organizations, Rogue refused to intervene with these services, citing their “no matter what” pledge to their customers. Furthermore, international pressure from other governments failed to induce national-level intervention, as Rogue was based in a country whose laws did not adequately proscribe such hosting activities.

Ultimately, Rogue was forcibly taken offline through a coordinated effort from multiple security vendors working with several government organizations. This effort consisted of a targeted worm that spread through Rogue’s network. This denial-of-service attack successfully took Rogue’s machines offline, destroying much of the data stored with the ISP in the process. All of Rogue’s clients were affected. No other ISPs reported any impact from the worm, as it included mechanisms to limit its spread. As a result of this action, spam and botnet traffic immediately dropped significantly. In addition, new infections of several forms of ransomware ceased.

_TPS: Was the response appropriate?  Ethical?  What principles would permit the security vendors and government organizations to write such software._

Yet another case study
----------------------

Read the first five paragraphs of <https://ethics.acm.org/code-of-ethics/using-the-code/case-accessibility-in-software-development/>.  The last paragraph you read should be the one that starts "Nevertheless,the product owner was being pressured to launch the new version despite the accessibility defects." 

_TPS: ...._
