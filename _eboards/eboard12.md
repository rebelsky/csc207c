---
title: "EBoard 12: Exceptional programming"
number: 12
section: eboards
held: 2023-09-20
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.

_Approximate overview_

* Administrivia
* Questions
* Two design problems
* Lab

Administrivia
-------------

### Introductory notes

* Today's lab is somewhat rewritten.  Fingers crossed that everything works
  okay.
    * Make sure that you are using the repo named something like
      `lab-exceptions-vscode`.
      
### Upcoming Token activities

Academic

* CS Extras, Thursday 21 Sept 2023, 4:15 pm, Science 3821.  Study Abroad in CS.
* GrinTech talk w Karla Erickson and Elizabeth Cave, Thursday, 21 Sept 2023, HSSC N1112.
* Mentor session Sunday.

Cultural

Peer

Wellness

Misc

### Upcoming work

* Thursday: MP3
    * Bonus token to the first person who spends four hours on MP3
      and TeamsChats me to tell me how far they got.
* Friday: More readings, today's lab

Questions
---------

_You can ask questions about anything related to the class!  Self gov
says that you **should** ask those questions._

### Java

### Administrative stuff

Do we get to choose which way I meet each LA?

> If I have a paper-based LA, then you should at least try the first
  time on paper.  If that fails, you can provide me with evidence.

### MP2

### MP3

What should I get if I center boxed text?

> It depends on the particulars.  Let's say you build
  `new Centered(new BoxedBlock(new TextLine("Hello")), 21)`
  and put it above `new TextLine("012345678901234567890123456789")`.`

              +-----+
              |Hello|
              +-----+
       012345678901234567890123456789

> On the other hand, if you built a block with an expression like
  `new BoxedBlock(new Centered(new TextLine("Hello"), 21))`, that should
  look more like

       +---------------------+
       |        Hello        |
       +---------------------+
       012345678901234567890123456789

> Order of operations matters!

### Testing

### Exceptions

Two design problems
-------------------

Lab
---

