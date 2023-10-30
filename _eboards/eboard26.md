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
  outside Curtsinger's office and Eikmeier's offce.
* Digital Studies Welcome Session, Tuesday at 4pm, Kington Plaza
* Mentor Session, Tuesday at 7pm
    * Review for the SoLA
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

* Swimming vs. Iowa Central CC, Friday, November 3, at 6pm.
* Football vs. UofC, Saturday, November 4, at noon

Wellness

* Vigil for lives lost in Israel and Gaza/Palestine, today, 4:15 pm, JRC 101

Misc

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

Testing Quicksort
-----------------

Writing Quicksort
-----------------

_Without looking at your notes, come up with an invariant for the main
loop of partition._

...

_Let's translate that to code._

Questions
---------

### Registration

Will we have enough courses to cover interest?

> I think so.

### Quicksort

### MP6

What value do you suggest we take as the median in Quicksort?

> I'm a fan of grabbing a few values and taking the median of those
  values.

> One option: Three random values.

> Another option: First, middle, and last.

Have you tried ChatGPTsort yet?

> Nope.  Soon.

Ethics
------

<https://www.acm.org/code-of-ethics>

_TPS questions!_

### Which principles did you find surprising (or most surprising)?  Why?

### Which are your "favorite" principles?

### Which principles do you expect to be hardest to follow?

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
