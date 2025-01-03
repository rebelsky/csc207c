---
title: "Eboard 21 (Section 2): Tree traversal"
number: 21
section: eboards
held: 2024-11-14
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* MP9 - Blockchains
* Questions
* The ACM Code of Ethics
* First discussion on code of ethics
* Lab

Preliminaries
-------------

### News / Notes / Etc.

* We have both talking and lab today.
* Some issues about the next few weeks.
* If you haven't done so yet, please sign up for 
  <https://passwordreset.grinnell.edu>.
* Feel free to take Github stickers.

### Upcoming work

* Thursday, 2024-11-14
    * [MP9](../mps/mp09) (Blockchains) released.
    * [MP8](../mps/mp08) due.
    * [Submit MP8 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5284854)
* Friday, 2024-11-15
    * [Submit post-reflection for MP8](https://www.gradescope.com/courses/818402/assignments/5284861)
* Sunday, 2024-11-17
    * [Submit pre-reflection for MP9](https://www.gradescope.com/courses/818402/assignments/5321060)
    * [Submit redo of MP3](https://www.gradescope.com/courses/818402/assignments/5295648)
    * [Submit redo of MP4](https://www.gradescope.com/courses/818402/assignments/5295649)
* Monday, 2024-11-18
    * [Submit lab-writeup for class 21](https://www.gradescope.com/courses/818402/assignments/5321026)
    * [SoLA 9](../los/sola09) due.
        * New algorithm LAs.
            * [Algorithms #3: Insertion sort](https://www.gradescope.com/courses/818402/assignments/5308265)
            * [Algorithms #4: Selection sort](https://www.gradescope.com/courses/818402/assignments/5308266)
            * [Algorithms #6: Quicksort](https://www.gradescope.com/courses/818402/assignments/5308269)
            * [Algorithms #7: Merge sort](https://www.gradescope.com/courses/818402/assignments/5308271)
            * [Algorithms #15: Loop invariants](https://www.gradescope.com/courses/818402/assignments/5276666)
        * Repeated LAs are in the SoLA.
    * No reading response!
* Thursday, 2024-11-21
    * [MP9](../mps/mp09) (Blockchains) due.
    * [Submit MP9 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5321058)
    * MP10 assigned (due in two weeks)
* Friday, 2024-11-22
    * [Submit post-reflection for MP9](https://www.gradescope.com/courses/818402/assignments/5321060)

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Thursday, 2024-11-14, 4:00--5:00 p.m., Science 3821.
  _CS Extras: Securing Emerging Wireless Networks_
* Sunday, 2024-11-17, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_
* Tuesday, 2024-11-19, Noon.
  _CS Table_

#### Cultural

* Thursday, 2024-11-14, 7:30--9:30 p.m., Sebring-Lewis.
  _A night of Brazillian music_
* Weekends of November 16 and November 23, Roberts Theatre.
  _Pity_ 
* Saturday, 2024-11-16, 2:00--4:00 p.m. (but there's an intermission).
  _Grinnell Symphony Orchestra plays Mozart's symphony number 40._

#### Multicultural

* Friday, 2024-11-22, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Somewhere_

#### Peer

#### Wellness

* Tuesday, 2024-11-19, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-11-19, 4:30--6:30 p.m., Secret Place.
  _Forest Bathing_.
* Tuesday, 2024-11-19, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.

#### Misc

* Friday, 2024-11-15, 8:30--11:30 p.m., Harris.
  _Fall Drag Show_.
* Monday, 2024-11-18, 7:00 p.m., The Kernel (HSSC A1321) 
  _Considering Technical Roles: Tech Hiring Trends & Alumni in Tech Career Paths with alumni from Microsoft, Google, Intel, and more_
* Friday, 2024-11-22, 5:00--8:00 p.m., Downtown Grinnell.
  _Jingle Bell Holiday_.

### Other good things (no tokens)

MP9 - Blockchains
-----------------

See the assignment for details.

Today's lab partner is your MP partner.

It will be wicked fun!

Questions
---------

### Administrative

**Will you decrease the number of LAs for each level?**

> I'll consider it. However, I'm unlikely to drop each category by more
  than one. Last year, most students were able to complete most LAs to
  my satisfaction by the end of the semester, and I have confidence that
  you will be able to, too.

**Can we still have one MP at redo and still get an A?**

> Yes, that's what the syllabus says.

> But it will probably change. Likely one more R and one fewer E at each level.

**We get a free redo on each MP (provided we get R or more). Can we do 
  second redos?**

> Yes, but it costs you tokens.

**How many MPs will we have?**

> Eleven!

### Sorting

How does the standard Java library pick the pivot?

> It uses Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, 
  and Joshua Bloch

> Read the paper. 

> Here's an example of why I don't think you should trust Geeks4Geeks.

> Quote 1: "Dual pivot quick sort is a little bit faster than the original 
  single pivot quicksort. But still, the worst case will remain O(n^2)."
  <https://www.geeksforgeeks.org/dual-pivot-quicksort/>

> Quote 2: "The answer is yes, we can achieve O(nLogn) worst case. The idea is 
  based on the fact that the median element of an unsorted array can be found 
  in linear time." 
  <https://www.geeksforgeeks.org/can-quicksort-implemented-onlogn-worst-case-time-complexity/>

> One of these has to be wrong. Both could be wrong.

On the part where we use LLMs, how much of the code has to be ours?

> None. But it's likely that you'll have to do a bit of translation to
  get it in the form I asked for.

> You will still have to describe how the sort works (to the best of
  your ability) and write a paragraph about the experience of having
  the LLM write the sort for you.

Is there any reason to optimize the four basic sorting algorithms?

> Fun?

> A sense of accomplishment?

> Energy efficiency.

My merge sort runs forever on some cases. Why?

> Hypotheses: You aren't (correctly) checking for a one-element array, 
  and so you keep recursing on the same one-element array.

> Hypotheses: You aren't choosing a midpoint in the middle.
  
> Solving strategy: Insert a print statement where you print the lower bound
  and the upper bound (but not the array).

How should we pick a pivot in Quicksort?

> However you'd like. I prefer "median of three randomly-selected elements".

### Readings

The ACM Code of Ethics
----------------------

<https://www.acm.org/code-of-ethics>

We will read these aloud so that we reflect a bit more about each.

* 1\. GENERAL ETHICAL PRINCIPLES.
    * 1.1 Contribute to society and to human well-being, acknowledging that all people are stakeholders in computing.
    * 1.2 Avoid harm.
    * 1.3 Be honest and trustworthy.
    * 1.4 Be fair and take action not to discriminate.
    * 1.5 Respect the work required to produce new ideas, inventions, creative works, and computing artifacts.
    * 1.6 Respect privacy.
    * 1.7 Honor confidentiality.
* 2\. PROFESSIONAL RESPONSIBILITIES.
    * 2.1 Strive to achieve high quality in both the processes and products of professional work.
    * 2.2 Maintain high standards of professional competence, conduct, and ethical practice.
    * 2.3 Know and respect existing rules pertaining to professional work.
    * 2.4 Accept and provide appropriate professional review.
    * 2.5 Give comprehensive and thorough evaluations of computer systems and their impacts, including analysis of possible risks.
    * 2.6 Perform work only in areas of competence.
    * 2.7 Foster public awareness and understanding of computing, related technologies, and their consequences.
    * 2.8 Access computing and communication resources only when authorized or when compelled by the public good.
    * 2.9 Design and implement systems that are robustly and usably secure.
* 3\. PROFESSIONAL LEADERSHIP PRINCIPLES.
    * 3.1 Ensure that the public good is the central concern during all professional computing work.
    * 3.2 Articulate, encourage acceptance of, and evaluate fulfillment of social responsibilities by members of the organization or group.
    * 3.3 Manage personnel and resources to enhance the quality of working life.
    * 3.4 Articulate, apply, and support policies and processes that reflect the principles of the Code.
    * 3.5 Create opportunities for members of the organization or group to grow as professionals.
    * 3.6 Use care when modifying or retiring systems.
    * 3.7 Recognize and take special care of systems that become integrated into the infrastructure of society.
* 4\. COMPLIANCE WITH THE CODE.
    * 4.1 Uphold, promote, and respect the principles of the Code.
    * 4.2 Treat violations of the Code as inconsistent with membership in the ACM.

TPS Questions
-------------

### Which principles did you find surprising (or most surprising)?  Why?

### Which are your "favorite" principles?

### Which principles do you expect to be hardest to follow?

### What other issues came up?

Lab
---

Make sure that the lab repo ends with `-maven`.

How do I initialize an anonymous iterator? (Or any anonymous inner class.)

> By putting the initialization code in braces.

```
return new Iterator<T>() {
  Stack<T> stack;
  ...
  {
    stack = new Stack<T>();
    stack.push(root);
  }

  public boolean hasNext() {
    ...
  }

  public boolean next() {
    ...
  }
} 
