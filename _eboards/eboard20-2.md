---
title: "Eboard 20 (Section 2): Pause for breath"
number: 20
section: eboards
held: 2024-11-12
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* DNF algorithm
* Analyzing merge sort
* Quicksort
* Questions
* Discussion

Preliminaries
-------------

### News / Notes / Etc.

* We're back to talking today. Thursday should be lab.
* We will likely spend a bit less time on ethics today than I had originally
  planned. I consider it ethical to make sure that you understand the
  sorting material in order to complete the assignment.
    * We'll be fitting ethics discussions into some subsequent classes.
* New office hour approach: Use the Outlook scheduling assistant to 
  schedule 15-minute or 30-minute appointments. I'll generally say yes 
  to requests during the day for times that I'm not booked..
    * SAM WILL DEMO!
* Just wondering: Many of you said you'd worked with doubly-linked lists
  in CSC-161. But many of you also only made it through Exercise 3. What
  made things difficult?
    * Some confusion as to how nodes are built in Java. Instructions should
      have said "Check the fields and constructor."
    * Didn't quite understand all the methods; needed to step back and
      look at it as a whole.
    * Iterators (or at least ListIterators) add a level of complexity.

### SoLA stuff

* Please review the statement about academic honesty on the SoLA notes
  I sent out yesterday.
    * Make sure to cite the people who contributed to the code you submitted
        * You can cite the name "I did this with Maria"
        * You can just say "I did this with a lab partner."
        * You will often say "Starter code/documentation from Sam" 
          (or be more precise)
    * Original class policy was "No external resources". New class policy
      is no Geeks4Geeks, no StackOverflow, no LLMs. Cite what you looked
      at when solving the SoLA (or where parts of your code came from).
      Textbooks are fine. Class notes from elsewhere are fine. As long
      as it's not one of those crappy "advice from peers" sites, it's
      fine.
    * If you don't refer to something while solving the LA, even though you
      read it to understand the concept, you do not need to cite it.
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
        * You can choose how much to include. I'm okay if you just copy 
          and paste. I'm also okay if you cut it down a bit. If you just
          copy and paste, you run the risk that I'll see something in the
          "irrelevant parts" that I consider "bad" and will comment on it
          and may call it "Insufficient".
    * Client code. "Here's some code that uses that library code."
    * Analysis. "See how that allowed us to ...."
* For the sorting LAs, you will likely want to use this structure.
    * Overview of the sorting algorithm. "Insertion sort works by ..."
    * Quick dump of characteristics. "Insertion sort is an O(n^2) sorting
      algorithm. ..."
    * Code.
    * Any other comments you have.
* _You don't need to cite those rhetorical structures when you use them._
* Many of you seem to be way behind on LAs (mostly in that you aren't
  submitting them). I'll be sending in Academic Alerts once I finish
  grading the current SoLA. I think about 50% completion at any point
  is reasonable, although I'd prefer.

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
    * Redos of MP3 and MP4.
* Monday, 2024-11-18
    * [SoLA 9](../los/sola09) due.
        * New algorithm LAs.
            * [Algorithms #3: Insertion sort](https://www.gradescope.com/courses/818402/assignments/5308265)
            * [Algorithms #4: Selection sort](https://www.gradescope.com/courses/818402/assignments/5308266)
            * [Algorithms #6: Quicksort](https://www.gradescope.com/courses/818402/assignments/5308269)
            * [Algorithms #7: Merge sort](https://www.gradescope.com/courses/818402/assignments/5308271)
            * [Algorithms #15: Loop invariants](https://www.gradescope.com/courses/818402/assignments/5276666). This can have pseudocode.
        * Repeated LAs will be in the SoLA this evening.
    * No reading response!

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Wednesday, 2024-11-13, 4:30--6:00 p.m., the Kernel (HSSC 1231).
  _CS Poster Session_
* Thursday, 2024-11-14, 11:00 a.m.--12:00 noon, JRC 101.
  _Scholars' Convocation: hazel batrezchavez - “Enacting Radical Futures: Art as a Tool for Building Collective Power”_
* Thursday, 2024-11-14, 4:00--5:00 p.m., Science 3821.
  _CS Extras: Securing Emerging Wireless Networks_
* Sunday, 2024-11-17, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_
* Tuesday, 2024-11-19, Noon--1:00 p.m., JRC 224A (Day PDR).
  _CS Table: Students reporting on cool conference_ 

#### Cultural

* Wednesday, 2024-11-13, 4:00 p.m., GCMOA (Bucksbaum 131).
  _Gallery Talk: The Museum as Place of Learning_
* Thursday, 2024-11-14, 7:30--9:30 p.m., Sebring-Lewis.
  _A night of Brazillian music_
* Weekends of November 16 and November 23, Roberts Theatre.
  _Pity_ 
    * Get tickets at the box office.
    * Come for the set.
    * It's cool. 
* Saturday, 2024-11-16, 2:00--4:00 p.m. (but there's an intermission).
  _Grinnell Symphony Orchestra plays Mozart's symphony number 40._

#### Multicultural

* Friday, 2024-11-22, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Somewhere_

#### Peer

#### Wellness

* Tuesday, 2024-11-12, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-11-12, 4:30--6:30 p.m., Secret Place.
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

**How should we initialize `r`, `w`, and `b` to ensure the invariant?**

```
  // +------------+-------------+-------------+--------------+
  // |  Red       |   White     |   Blue      |X Unprocessed |
  // +------------+-------------+-------------+--------------+
  //              |             |             |              |
  //              r             w             b              n

  // +---------------------------------------------------------+
  // |                    Unprocessed                          |
  // +---------------------------------------------------------+
  // |
  // r,w,b
```

```
r = 0;
w = 0;
b = 0;
```

Nothing before `r`, so everything before `r` is red.

Nothing between `r` and `w`, so everything between `r` and `w` is white.

Etc.

**Does the algorithm work correctly if there are not yet any red elements?**

```
  // +------------------+-------------------+------------------+
  // |W     White       |B     Blue         |?     Unprocessed |
  // +------------------+-------------------+------------------+
  // |                  |                   |                  |
  // r                  w                   b                   
```

Yes. Analysis below.

If ? is red

* We swap r and w, we now have `B White W Blue R`
* We swap r and b, we now have `R White W Blue B`
* We advance r, w, and b, and we've achieved what we want.

If ? is white

* Our board work suggests it's okay.

If ? is blue

* We simply increment b, so we don't have to worry about the red part.

**Does the algorithm work correctly if there are not yet any white elements?**

```
  // +------------------+-------------------+------------------+
  // |R     Red        R|B     Blue        B|?     Unprocessed |
  // +------------------+-------------------+------------------+
  //                    |                   |                  |
  //                    r,w                 b                   
```

Yes. Analysis follows.

If ? is W, swap(w,b) and then increment w and b.

(Alternately, `swap(w++,b++)`.

If ? is B, we just advance the blue pointer.

If ? is R, swap(r,w), which has no effect. And then swap(r,b) which puts
a B after b and an R after r (and w). We then increment all three. And
we still have the invariant.

Observation: `w >= r` because whenever we increment `r` we also increment `w`.
(There are times we increment `w` but don't increment `r`.)
(And we always increment blue.)

**Does the algorithm work correctly if there are not yet any blue elements?**

```
  // +------------------+-------------------+------------------+
  // |R     Red        R|W     White       W|?     Unprocessed |
  // +------------------+-------------------+------------------+
  //                    |                   |                  |
  //                    r                   w,b                   
```

No. Analysis follows.

If ? is B, we just increment B and everything is fine.

```
  // +------------------+-------------------+-+----------------+
  // |R     Red        R|W     White       W|B|    Unprocessed |
  // +------------------+-------------------+-+----------------+
  //                    |                   | |                |
  //                    r                   w b                   
```

If ? is W, 

```
  // +------------------+-------------------+------------------+
  // |R     Red        R|W     White       W|W     Unprocessed |
  // +------------------+-------------------+------------------+
  //                    |                   |                  |
  //                    r                   w,b                   
```

we swap elements at w and b, which has no effect, and then increment both.

```
  // +------------------+---------------------+----------------+
  // |R     Red        R|W     White       W W|    Unprocessed |
  // +------------------+---------------------+----------------+
  //                    |                     |                |
  //                    r                     w,b                   
```

If ? is R

```
  // +------------------+-------------------+------------------+
  // |R     Red        R|W     White       W|R     Unprocessed |
  // +------------------+-------------------+------------------+
  //                    |                   |                  |
  //                    r                   w,b                   
```

We swap elements at r and W

```
  // +------------------+-------------------+------------------+
  // |R     Red        R|R     White       W|W     Unprocessed |
  // +------------------+-------------------+------------------+
  //                    |                   |                  |
  //                    r                   w,b                   
```

We swap elements at r and b.

```
  // +------------------+-------------------+------------------+
  // |R     Red        R|W     White       W|R     Unprocessed |
  // +------------------+-------------------+------------------+
  //                    |                   |                  |
  //                    r                   w,b                   
```

We increment all three indices.

```
  // +--------------------+-------------------+----------------+
  // |R     Red        R W|    White       W R|    Unprocessed |
  // +--------------------+-------------------+----------------+
  //                      |                   |                  |
  //                      r                   w,b                   
```

Whoops!

**If the answer to any of those is "No", how do we fix the algorithm?**

The algorithm fails if we don't have any blue elements and the next element 
is red.

Solutions ...

* Special case: In the red case, if `w == b`, only do one swap.
    * Note: We haven't yet analyzed "both red and white are empty" or
      "both red and blue are empty" or "both blue and white are empty".
* Change the swaps: `swap(w,b)` then `swap(r,w)`.
    * Note: We may have to do more analysis (see above) to make sure
      it won't break on other special cases.

Reminder: Pictorial invariants are our friends.

Question: For the RWBU, is a three-way-rotate better than two swaps?

* I haven't analyzed it carefully, but it seems to be.
* You can try implementing it.
* You can try showing it correct.

Analyzing merge sort
--------------------

Merge sort:

* Split the array in half (first half / second half), using bounds. 
* Sort the two halves. 
* Merge 'em together.

Merge algorithm (high level)

* Keep track of where we are in each sorted subarray.
* If the value at the current position in the first subarray is less
  than or equal to the value at the current position in the second
  subarray, copy the first value to the merged array and increment
  the first position.
* Otherwise, copy the second value to the merged array and increment
  the second position.
* When you run out of one array, copy the rest of the other array.

The merge algorithm is $$O(n)$$ because we are going to go through the
whole result array to copy elements into it.

Analyzing Merge sort

Let's start by writing the recurrence relation. We are defining $$T(n)$$,
the time merge sort takes on $$n$$ elements.

$$T(n)$$ =

* Split the array in half: $$O(1)$$ because we're not looking at elements,
  we're just doing simple math.
* Sort the two halves using merge sort: $$T(n/2) + T(n/2) = 2 \times T(n/2)$$
* Merge 'em together. $$n$$

Recurrence relation

$$T(n) = 2 \times T(n/2) + n + c$$

$$T(1) = c$$

Yay! We get to solve a recurrence relation.

*  Expand it bottom up. 
    * $$T(1) = c$$
    * $$T(2) = 2 \times T(1) + n + c$$
    * $$T(2) = 2c + n + c = 3c + n$$
*  Expand it top down.
    * $$T(n) = 2 \times T(n/2) + n + c$$
    * $$T(n) = 2(2 \times T(n/4) + n/2 + c) + n + c$$
* Recursion tree
* Master theorem (no)

Our recursion tree plus some extra math show us that merge sort is in
$$O(n log_2 n)$$.

Can we do better?

* There is a proof that you will see in CSC-301 that a "compare-and-swap"
  algorithm must take at least $$n log_2 n$$ steps.
* However, for certain kinds of data, we can write O(n) algorithms.
* (We know that we can't do better than O(n) since it takes O(n) to
  check whether it's sorted.)

Quicksort
---------

Three key ideas:

* Quicksort is a divide-and-conquer routine
* That attempts to divide the (sub)array into two (or three) parts:
  smaller values and larger values (or smaller, "equal", and larger).
    * Ideally, we divide using the median.
* And does that division using the wonder of randomness.

With a real median.

$$T(n) = $$

* $$O(1)$$ to find the median.
* $$O(n)$$ to DNF (rearrange to put small things at left and large things at right
* $$2 \times T(n/2)$$ to recursively sort the two halves.

IF we can find the median in O(1) (or even O(n)), this is an $$O(n log_2 n)$$ algorithm.

Traditional way to find the median: Sort the array and look in the middle. Whoops!

Additional key idea in Quicksort: If you pick a random element of the (sub)array, things will usually work out almost as well as if you picked the real median. (Sam does not like to do the statistical analysis.)

A tip: DNF should probably return both the red and white indices (the end
of the small section and big section).

```
public int[] dnf(T[] values, int lb, int ub, Comparator<T> order) {
  int r = 0;
  int w = 0;
  int b = ...;

  ...

  return new int[] {r, w};
} //

public void quicksort(T[] values, int lb, int ub) {
  ...
  int[] bounds = dnf(values, lb, ub, ...);
  quicksort(lb, bounds[0]);
  quicksort(bounds[1], ub);
} // quicksort
```

Questions
---------

### Administrative

**Given that you have not been returning graded MPs promptly, do you 
  anticipate changing the MP requirements for A/B/C?**

> Yes. However, I'm still figuring that out.

**Will you be gracious if we don't get our token reflections in within
  72 hours of the event.**

> Probably.

**Should we work with our partners in resubmitting group MPs**

> Ideally.

### Sorting

**Is there a stable version of Quicksort?** 

> I don't know of a stable _in-place_ version of Quicksort. The partition
  routine rearranges things too much.

**In merge sort, we'll need to make helper arrays. Where should we do that?**

> I would use a helper array for the merge, but just use subarrays (given
  by `lb` and `ub`) for the recursive calls.

> If you use this technique, you only need one helper array.

### Readings

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

