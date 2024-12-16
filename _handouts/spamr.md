---
title: Spam from Sam
---
# {{ page.title }}

_Here you will find most of the email that I sent out this semester, with the newest email at the top and the oldest at the bottom._

## [CSC-207 2024Fa] Some notes on SoLA 12 (2024-12-15)

Dear Students of Liberal Arts,

I've the grading of the new LAs on SoLA 12 as well as the OOP LAs, which puts me about two days behind in grading. Fingers crossed that I can catch up quickly. Unfortunately, there seem to be some academic honesty issues in SoLA 12, and dealing with those has not only slowed me down but also will continue to take time this week. There's also department business and some other professional issues on my docket.

In any case, here are some notes on the most recent LAs (as well as a few more).

**General**

* Please anonymize your submissions.
* It looks like many of you who get credit for LAs don't check for comments. You should.
* Please be careful to cite correctly and well.
* If you provide a variant of code that you received in lab, make sure to describe what changes you've made.
* Please make sure that your code does not end up double or triple spaced.
* Please use code you wrote for the class, not invented code. I definitely don't want to see any examples that involve vehicles or animals.
* When providing code you've written, please try to provide only the relevant code.

**Heap Sort**

* Many of you used a technique to build the heap that we did not discuss in class, but did not cite it. PLEASE CITE CAREFULLY!
* There are two major phases to heap sort. Make sure to describe both of them.

**Heaps**

* `heapUp` happens after we add an element to the end (and in some other situations). Do not include the addition.
* `heapDown` happens after we've swapped the last element to the root in remove (and in some other situations). Do not include the swap.
* If you grab ideas from elsewhere, plesae cite them.

**Hash Tables**

* Make sure to include a description of hash tables in addition to the implementation.
* In the implementation, I'd like to see `set`, `get`, and any fields and methods they depend on.
* Many of you provided an incorrect `remove` method. Since you don't need that method, I'd encourage you to skip it.

**Priority Queues**

* I know that I provided you with a `PriorityQueue` interface. Please don't use mine. Write your own. It need not be the same as mine.
* In describing an implementation, make sure to give the details of how we add elements and get/remove them.

**Lists**

* Remember that we think about ADTs using the "strategy" (what the key idea of the type is), "applications" (which you need not include here), and "methods". Hence, you should make sure to describe the strategy and the methods (optionally as an interface).
* I'm not sure that my doubly-linked list implementation shows that you know how to implement lists.
* A linked queue is not a list. Lists traditionally provide broader access to elements (at the very least, to add elements in various places and to look at various elements).
* Lists do not have to be linked structures. Lists can be implemented with arrays (hence ArrayList) and even with trees (which, when used properly, can give us a compromise been linked lists and ArrayLists).

**Object design**

* You need to provide broader design choices that you're responsible for. For example, the BlockChain MP would not suffice because I specified all of the methods you need to provide and gave you all but one of the classes (with the last class implied).
* Please provide an example of a class (or classes) that you designed "from scratch" as it were.

I hope to have another update tomorrow.

-- SamR

## [CSC-207 2024Fa] Is this the last Spam from Sam for 2024Fa? (2024-12-14)

Dear Completely Special Coders in 207,

Okay, this probably ISN'T the last email message from me this semester, but it's a worthwhile question. At the very least, I'll likely send out short notes when I send out new grade reports. This message mostly serves to answer a variety of questions I've received over the past few days.

**When can I fill in the end-of-course evaluation?**

> The end-of-course evaluation for both sections should now be available at https://grinnell.smartevals.com . Please let me know if you have difficulty reaching it. And please take the time to fill it out.

**When will the graders complete grading MP7 and MP9?**

> They've finished. You should be able to find your graded assignments on Gradescope.

**Where does Sam stand on grading?**

> Far behind where I planned. It turned out that I had no free time on Friday. (Okay, I was free from 7:00--9:30 p.m., but I was out with friends.) I got sucked into more administrative work today. So I'm trying to catch up, but it won't be as efficient as I'd expected.

**Are you adjusting anything to deal with that?**

> Yes. I'm skiping the "trivial incompletes" for MP8 and MP10, such as you forgetting to include your name in some files. I've moved the due dates for the MP8/10 redos to Tuesday night. It's not ideal, but it's the best I can do right now.

**When are you running the sorting competition?**

> After I've graded MP8, MP10, and SoLA 12.

**When will I get my next grade report?**

> As soon as I finish grading SoLA 12.

**Can I take an incomplete in this course?**

> I hope that everyone is able to complete all of their work by Friday. However, I am also willing to sign an incomplete form for anyone who would like me to do so. Incomplete forms must be turned in to the Registrar's office on Monday. I should be in my office on Monday afternoon from 1--4pm. You can also Teams Message me during the day to figure out where else I am. (I have a department meeting from 8--10 a.m., I'm proctoring an exam from 10 a.m. to 11:00 a.m., I'm probably going to lunch somewhere in the 11:00 a.m. to 1:00 p.m. range, and I'm meeting with a student in my office at 3:00 p.m.)

> As our syllabus suggests, I follow the guidance of the Committee on Academic Standing and will only permit an incomplete for one mini-project.

**I'm a masochist and want to take another SamR class. What are you teaching next year?**

> If all goes as planned, I'll be on sabbatical next year. I have no idea what I'll be teaching the following year. The upper-level classes I sometimes teach are CSC-301 (Algorithm Analysis) and the "one-credit courses", CSC-281 (Learning from CS Alumni) and CSC-282 (Thinking in C and Unix).

**I have another question. What should I do?**

> Teams message me.

**Will you help me debug my code?**

> Teams message me.

-- SamR

p.s. This probably looks much better on the Web site at <https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/handouts/spamr>

## [CSC-207 2024Fa] MP Redos and Such (2024-12-10)

Dear 'Mazing Programmers,

Here are bunch of assorted notes.

**MP REDOS**

1. Don't forget that when you submit a mini-project redo, you should include a file called `CHANGES.md` or `CHANGES.txt` that summarizes your changes.

2. For the MP5 redos, plesae submit only the following

a. Your `README.md` file (which should include the URL of your GitHub repo).

b. Your `CHANGES.md` or `CHANGES.txt` file.

c. Your `src` directory (which should have all the `.java` files).

**SOLA**

SoLA 13 is now live. Here are the new LAs

* [ADT/DS #9: Graphs](https://www.gradescope.com/courses/818402/assignments/5442577)
* [Algorithms #8: Graph and tree traversal](https://www.gradescope.com/courses/818402/assignments/5442584)
* [Algorithms #9: Shortest path](https://www.gradescope.com/courses/818402/assignments/5442590)
* [Algorithms #10: Greed](https://www.gradescope.com/courses/818402/assignments/5442593)
* [Algorithms #11: Divide and conquer](https://www.gradescope.com/courses/818402/assignments/5442594)

Please let me know if any repeat LAs seem to be missing.

**DIJKSTRA'S SHORTEST PATH ALGORITH**

We'll use the last 30 minutes or so of Thursday's class to allow you to finish implementing Dijkstra's shortest path algorithm.

**MISSING READINGS, LABS, METACOGNITIVE REFLECTIONS**

Although the course policies suggest that more than six missing items will decrease your computed grade, I will not be applying that policy this semester. Your grade will be determined by your MPs and LAs.

I should have the ungraded readings, labs, and metas graded by the middle of the day tomorrow (Wednesday).

Let me know if you have questions. See you Thursday!

-- SamR

## [CSC-207 2024Fa] Notes on SoLAs 6 and 7

Dear Bored Gamers,

Although I've graded the new LAs on SoLAs 6 and 7, I have not yet finished grading the other LAs. I'm still plugging ahead, but thought I should send you some notes now.

**Academic honesty**

The course policies said the following about LAs:

"In solving those problems, you should only rely on (a) the course Web site, (b) the standard Java reference pages, (c) your notes, and (d) the code you’ve written. You may not search the Web for answers, you may not use LLMs, and you definitely may not use StackOverflow or Geeks4Geeks or any such sites. When a problem asks you to provide sample code, you should use code you’ve already written for the class (or updated version of that code)." <https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/los/>

However, many of you seem to have missed those policies. I'll take responsibility, since I didn't restate the policies on each LA. However, from now on (including on SoLA 8), I expect you to follow a revised version of these policies.

"In solving those problems, you should rely primarily on (a) the course Web site, (b) the standard Java reference pages, (c) your notes, (d) the code you've written, and (e) CLRS. You should not search the Web for answers, you may not use LLMs, and you definitely may not use StackOverflow or Geeks4Geeks. When a problem asks you to provide sample code, you should use code you've already written for the class (or updated version of that code).

If you use resources other than your own code, such as those mentioned above and including code I've written, you should make sure to cite those resources."

**Academic honesty, revisited**

* "I searched the Internet for information on …" is not a citation. Please give the Web page or pages you used.

* "My lab on X" or "Lab N" is not a sufficient citation. Make sure to cite your partner!

**General notes**

* Many of you need to be more careful about language use. For example, a linked structure is not necessarily a linked list. Queues and stacks are different structures. A list is not an array (and vice versa).

**Big-O bounds**

* At least one of you wrote something like "f(n) is in O(n^2 * logn). Since logn is a lower-order term, we can ignore it." Unfortunately, that's not the case. We can drop lower order terms when we *add* them. We cannot drop them when we *multiply by* them.

**Solving recurrence relations**

* As I mentioned in class, you may only use the master theorem to check your work. Please solve these by bottom-up or top-down analysis.

**Binary search**

* Some of you described binary search as an algorithm that works on lists. I'll admit that I don't know that there's a way to find the middle element of a (sorted) list in constant time, at least if it's implemented as a linked structure.

* Some of you just said that binary search works on arrays. Binary search doesn't work on most arrays. You need some particular characteristics.

**Other**

As always, feel free to ask questions. As you've seen, I'll sometimes even answer parts of LAs in class.

There have been a few cases in which I missed something in an answer. (That happens when I'm reaading 100's of answers.) If that's the situation, you should put in a regrade requestr.

Regards,

-- SamR

## [CSC-207 2024Fa] Notes on SoLA 3 (2024-10-02)

**Important!**

* Don't worry if you're getting LAs wrong on the first try! Last semester, many students went from missing their first attempts at most of the LAs to getting an overall A on LAs.

* Some of you have been asking about tokens and LAs. Retaking LAs is free. No tokens charged, whether you retake an LA one time or ten times (or any number in the middle).

**General**

* Please make sure to keep your LA submissions anonymous!

* Please try to avoid introducing blank lines when you copy and paste code.

* Please make sure that you've written a nontrivial portion of the sample code you provide. It's okay to include something I wrote/supplied that fits into a broader structure, but some of the code must be yours.

* Please consider code excerpts rather than copying and pasting full files. For example, there's no reason the Subtype Polymorphism LA needed the full AsciiBlock code. Focusing on the three methods we need to implement (plus, perhaps, one polymorphic method) would suffice.

* Please be careful about your terminology

* Please use real examples, based on what we've done in class, not contrived ones. Last semester, we encountered enough issues with students borrowing code from the InterWeb and not citing it properly that I'd like to avoid such problems this semester. For example, what should I do when five of you use `BankAccount` as an example for encapsulation? Requiring that you rely on work you've done for the class helps ensure that there aren't appearances of miseuse of other code. Also, most contrived examples end up being code that no one would ever write. (In the BankAccount example, many people used a `double` for the balance. But `double` values round. You should not round the amount of money someone has.)

* Please cite the original source of any of my code that you use.

* Please follow our Java style guidelinese when writing code.

* The people who work with your code are "client programmers", not "users".

**Subtype Polymorphism**

* There's more to subtype polymorphism than "I can write a class that implements an interface" or "I can subclass another class" or even "I can make multiple classes that all have methods with the same name and broad semantics". *Why* do we care about the ability to do so?

* Make sure to include code that demonstrates subtype polymorphism.

* There's no reason to discuss parametric polymorphism in your answer to the question on subtype polymorphism. Focus on what subtype polymorphism is, rather than what it is not.

**Parametric Polymorphism**

* Make sure you include an example in which you instantiate a parametric-polymorphic class with different specific types and then use the resulting object (i.e., call a method). Then explain what's going on in the method call.

* There's no need to compare/contrast parameteric to subtype. Just focus on how and why we achieve and use parametric polymorphism.

**Composition**

* Make sure that your composition example is used in the construction of objects that include other objects; don't use a Main class to show composition.

* Make sure to describe the benefits of composition other than just "I can have these fields". Your code should demonstrate you making use of the fields.

**Unit Testing**

* Make sure that your comments match the test you are conducting.

--

I think that's it. Let me know via DM if you have questions.

-- SamR

## [CSC-207 2024Fa] Grade reports (2024-09-29)

Dear Collaborative Testers,

In the next few minutes, you should receive an email message from me that includes a grade report. I'll try to send out a grade report approximately once per week. In general, grade reports provide an opportunity for you to see how you're doing in the course, particularly what LAs you still need to work on and which mini-projects you might redo. (MP grading is going a bit slow, so only the first one is on the report. Tokens are also not on the report.)

Please let me know if you see any innacuracies in your grade report.

--

I generally suggest that you not compare your grades with other students. However, I thought it would be useful to provide a distribution of how folks are doing on LAs. Among other things, the distribution suggests that if you are having trouble figuring out how to meet my expectations on LAs, you are not alone. I would suggest that the folks at 0/5 or 1/5 check in with me on Teams.

```text
0/5: 10
1/5:  6
2/5:  8
3/5: 13
4/5:  4
5/5:  4
```

Some of you didn't seem to try redos on the SoLA 1 LAs. Note that the day or so after you get back a graded LA is probably the best time for your redo as the comments are fresh in your mind. You can keep trying redos on LAs until we reach the end of the semester with no token charges.

I'd also recommend that you try at least one or two new LAs each week so that you can keep moving forward. (It's better if you can try all of them, but not everyone has that time.)

--

Since it's come up a few times: We've hit the point that I expect that you should be capable of using our basic tools in the way they are intended.

* You should know what commands to type in Maven.
* You should be able to run the debugger in VS Code. In particular, if you have a failing test, you should be able to trace the steps the program issues in the failing test to help identify the likely source of the error.
* You should be able to push to and pull from a GitHub repository.

If you are having difficulty with any of those issues, it's probably a good idea to visit with the evening tutors.

--

As always, questions and comments are welcome. I prefer DMs on Teams.

Regards,

-- SamR

## [CSC-207 2024Fa] Notes on new LAs from SoLA 2 (2024-09-28)

Dear Do-Re-Mi-Fas,

I hope that you are well and that you have some fun things planned for this weekend. (Remember: Moderation in everything.)

I've finished grading the new LAs from SoLA 2 and have a few notes on the various topics. (I will generally not add these to the LAs.)

I should be able to get to the old LAs by this evening.

### General

* Remember that our policies are that for LAs, you should rely only on (a) your notes, (b) our course Web site, (c) me, and (d) the Oracle Java reference pages. It appears that some of you went beyond those resources. For example, I saw references to "setters" and "getters" in some answers, even though they aren't discussed in the course site. (Or perhaps one of our guest lecturers mentioned the.)

* Please don't ask me to look at things outside of what you submit in the primary answer field. Your goal is to get the key information in that field.

* Please try to keep your answers anonymous. Among other things, don't put your name in the citations field and don't include a link to a GitHub repo.

* Provide good code that follows the standards we've covered, explicitly and implicitly, in the class. Soon, I will mark as "Please try again" if I see "System.out.println" in the code you provide.

* I prefer to see code that you've written for class, rather than code you generate for the particular LA.

* Utility code should not print error messages. Only UI code should communicate with the user.

* Some of you seem to have forgotten "The Zen of Booleans".
    * Don't write `if (TEST == true) { … }`, write `if (TEST) { … }`.
    * Don't write `if (TEST) { return true; } else { return false; }`, write `return TEST;`.

* I'm worried that some of you attempted no LAs on SoLA 2. I'll be sending academic alerts about such issues.

* Since most of you are still figuring out what your LA answers should look like, I'll wait at least another week to send in academic alerts for those who haven't sucessfully completed a reasonable number.

### Encapsulation

* If you are unsure what encapsulation is, please revisit the appropriate reading in the section on OOP basics.

* The primary aspect of encapsulation we've been considering is protecting data/state, so I generally gave credit for descriptions that focused on that issue. But encapsulation also involves bringing things together, specifically data and the methods that directly manipulate those data. (The former implies the latter, since you need to use methods to access/indirectly manipulate the data/state, but it's nice to make that explicit.)

* Encapsulation is not the same as functional abstraction. Having a function that is used in multiple classes is not encapsulation.

* Encapsulation is a general object-oriented concept. Private fields are one way Java helps enforce encapsulation. But private fields are not the key aspect of encapsulation, and you should not focus on them.

* It is good to provide both the encapsulated code and the client code.

* If you provide methods that permit the client to set the value of any field and get the value of any field, have you really achieved encapsulation.

* If you return a mutable object when the client asks for information about a field, have you really encapsulated the data?

### Documentation

* I prefer that you don't use "side comments", where the comment is on the same line as the code you're commenting. It's better to put the comment above the code. (That helps prevent too-long lines.)

* For redos, I want to see (at minimum), a class Javadoc comment, a field Javacod comment, a constructor Javadoc comment, a method Javadoc comment, and an internal comment.

* Many of you are commenting end braces with things like `} // end of for loop that checks …`. You can do that if you wish. However, I'll note that (a) the `end` is implicitly given by the end brace and (b) the main purpose of these is to help us match braces. So `} // for` generally works better.

* Please try to spell correctly. (I make enough spelling mistakes that I generally won't take off for it, but please try.)

### Code reading

* The assignment says ""Read, understand, and modify code **that you did not write**." So you need to start with code that someone else wrote. Given the context of our class, you should probably use code I wrote (although I suppose you could use code that a partner wrote).

* Some of you seem to have missed the advice on what to write, so I'll repeat it here (now slightly rewritten): Code reading is more than "there's a for loop here". You should describe the design decisions embedded in the code. You should also describe the relation of the class to a larger ecosystem. (Why did someone create this class?)

* As that suggests, in describing the underlying code, you should make sure to mention key points. For example, if you used the `BigFraction` class as an example, I'd expect you to say something like "We're storing fractions using `BigInteger` values for numerator and denominator. That means that we need to use the various `BigInteger` methods when we do computations." For the AsciiBlocks example, if you were discussing "Surrounded", I'd expect you to write something like "Since every AsciiBlock provides a `row` method, we can rely on the ``row` method from the block we're surrounding, as well as the `width` and `height` methods."

* The "original code" that you discuss should be the original code, not your rewrite of the original code. For example, this is not the original of `BigFraction`.

```
//class
public class BigFraction {
  …
  // Fields
  BigInteger num;
  BigInteger denom;
```

The code may look similar, but it's been modified already (in this case, in ways that violate our style/commenting guidelines.

-

I think that's it for now. Have a great weekend! Feel free to send along questions. I won't be online all the time, but I'll be online off and on.

-- SamR

## [CSC-207 2024Fa] MP4, MP3, and more (2024-09-27)

Dear students who associate with arrays,

I hope your weeks have wrapped up well and that you have some time to participate in the Renfrow Festivities. Ms. Renfrow is a wonder, and worth celebrating.

A few notes on MP4 and MP3.

--

First, MP4.

1. I sent everyone an invitation to the testing repo for MP4. If you included your GitHub link in the README for MP2 (which you were supposed to do), I got your GitHub username from there. If you didn't include your GitHub link in the README, I used your email address. If you'd like a new invitation, drop me a message on Teams with your GitHub username.

2. Please accept that invitation soon. They do expire. If you find that you can no longer accept the invite, DM me on teams with your GitHub username.

3. I see that some of you are already pushing tests. That's great! Please remember to DM me when you've done so.

--

Next, MP3 (since not all of you are done).

4. As I mentioned in class, there's an error in `Grid.eqv` (or there was). You'll need to either fetch changes from upstream or fix it yourself.

5. Note that `AsciiBlock.eqv` is not implemented. You will have to implement it. (It will likely be an appropriate call to a different `eqv` method.)

6. Because of the `eqv` issues, I've extended the deadline until tonight. (The late deadline doesn't change.)

7. While many teams collaborated well on this mini-project, some did not. We'll spend some time discussing appropriate behavior and brainstorming strategies before the next team mini-project.

--

Finally, some other stuff.

8. In case it wasn't clear, THERE ARE NO ADDITIONAL READINGS FOR TUESDAY'S CLASS. Since we spent Thursday's class on design, we'll spend Tuesday's class on Inheritance.

9. There is also no lab writeup to turn in before Tuesday's class. You can focus on your pre-reflection for MP4, your unit tests for MP4, and SoLA 3. (And yes, I'm in the midst of grading SoLA 2. More details on that tonight.)

10. There are a few readings for Thursday, all on ADTs and their implementation. If you find that you have extra time over the weekend, you might want to start those.

--

Don't forget that we have a mentor session on Sunday! And I continue to answer questions I receive on Teams. (I'll probably be AFK from 6:00--8:00 p.m. tonight.)

-- SamR

## [CSC-207 2024Fa] More tests for MP3 (2024-09-25)

Dear Partnering Producers of Pictures,

I've finally written a bunch of tests for the `eqv` method. It's likely that some erroneous code can pass these tests, but they should catch a lot of issues.

You should be able to pull everything into your repo on the terminal using command-line Git commands.

```text
git remote add upstream https://github.com/Grinnell-CSC207/mp-blocks-maven
git fetch upstream
git merge upstream/main
```

You should only need to type the first command once (provided it works).

On a semi-related note, I've written a 'blog post about writing those tests. You can see it at <https://rebelsky.cs.grinnell.edu/musings/brain-fog-2024-09-25>.

Let me know if you have problems or questions.

Regards,

-- SamR

## [CSC-207 2024Fa] MP3 Pre-Assessments Graded (2024-09-23)

Dear Pre-Assessed Pre-Assessors,

I've read through and responded to all of the pre-assessments for MP3 that I've received so far. You can see my notes on Gradescope. I've also put most of the Q&A from those pre-assessments into the Q&A section of the assignment.

I'm happy to take additional questions on Teams or via email or at the start of class tomorrow.

Don't forget that SoLA 2 is due tonight!

Regards,

-- SamR

## [CSC-207 2024Fa] Re: Tests for MP3 are now (mostly) ready + A note on SoLA 2 (2024-09-22)

Dear Amazing Students Constructing Intuitive Instructions,

It appears that I neglected to write tests for `Trimmed` and `Padded`. The only natural response is to make the corresponding problems completely optional. The only gains you will get for doing them are knowledge and experience. There are no penalties for skipping them.

-- SamR

## [CSC-207 2024Fa] Tests for MP3 are now (mostly) ready + A note on SoLA 2 (2024-09-22)

Dear Collaborative Text Constructors,

I've written lots of tests of the classes for your edification. I haven't completed writing the tests for `eqv`, but everything else seems to be done. (It would help if I wasn't such a completist.) I've pushed those tests to the project repository.

If you've started MP3 already (and forked the original project), you should use the following terminal commands to get the tests.

```
git remote add upstream https://github.com/Grinnell-CSC207/mp-blocks-maven
git fetch upstream
git merge upstream/main
```

You should only need to execute the first command once. You should do the fetch and merge each time I tell you that I've updated the tests.

As always, questions are welcomed. I'll be running through your pre-assessments tomorrow morning.

--

There was a request that I provide you with a bit more guidance on each of the LAs. Part of my goal for the course is that you figure out what is the appropriate way for you to demonstrate knowledge of each subject, so I am reluctant to give you too many specifications. But I have added a few notes to each LA, which you can find at the bottom of the LA.

Regards,

-- SamR

## [CSC-207 2024Fa] SoLA 1 returned (2024-09-20)

Dear Initially Assessed Learners,

I hope that your week has wrapped up well and that you are looking forward to the excitement of family weekend. (It's family weekend, right?) Don't forget the concerts and other events that are happening this weekend!

I've returned SoLA #1. Unfortunately, most of you need to do a bit more to reach "Sufficient". (Don't worry; last semester, most people missed their first LAs, too.) Here are a few quick notes to supplement the notes I've included in the individual LAs.

--

LA (Development #02): Build tools 

This is a case in which I'd like to see some code, in particular, appropriate parts of the `pom.xml` along with some discussion of the updates you made to that file and why. 

I'd also like a discussion of common Maven commands to illustrate that you know what you can do. ("Compile and Run" is not enough.) You could even copy and paste a session (and add some comments), provided you use the -q flag.

--

LA (Development #04): IDE

This was a case in which I didn't need to see code (although I did appreciate that some of you provided a config file and a discussion of how you had configured VSCode).

Many of you just gave me some Java and said "I created this in VSCode". But that doesn't really demonstrate that you know how to use an IDE or what an IDE is. You can create Java code in any editor; many editors even have a "Java mode".

What do you do in an other IDE other than edit and type in a terminal window? What is "integrated" about the development?

Also: If you are going to provide me with Java code, make sure it's good Java code.

Many of the best answers to this problem provided me with a narrative of how the author worked with VSCode to go from assignment to working code, including issues along the way and how VSCode helped.

---

As this may suggest, I can be a tough grader. But don't worry, I have confidence that all of you can reach the levels I expect. Certainly, most students did in 207 last year.

As always, your questions are welcome.

Regards,

-- SamR

## [CSC-207 2024Fa] MP2 Pre-Assessments and such (2024-09-15)

Dear Calculating Students,

1. I've responded to all the MP2 pre-assessments that I have received so far. You can find comments on Gradescope (and, in most cases, in the assignment itself). If you haven't submitted your pre-assessment, you should do so soon.

2. Just in case you weren't sure, my biggest goals for this project are that (a) you get used to writing/designing classes, including the idea that many methods, such as multiplication, seem to have one fewer parameter than you might expect (the implicit "this object); and (b) you continue to get used to building multi-file projects.

3. The current set of unit tests are attached. You should store the file in `src/test/java/edu/grinnell/csc207`. I may make a few additions, but I don't expect to make many.

4. I've also added some "scripts" to the assignment that we'll use to check your main classes. You may want to run the scripts yourself, too.

As always, let me know if you have questions.

Regards,

-- SamR

## [CSC-207 2024Fa] Quick notes on mini-projects (2024-09-13) 

Dear Mini-Projectors,

A variety of notes on mini-projects 1 and 2.

0. You do not need to tell me that you're using a token for an extension; I'll charge it automatically.

1. Because of the late release of the tests for mini-project 1, everyone gets a free two-day extension.

2. Mini-project 2 is ready for public release.

2'. I hope to have the autograder for mini-project 2 ready for you a bit more quickly.

As always, feel to reach out via email or Teams. (And if I don't respond with a reasonable amount of time, such as twelve hours, reach out again.)

Regards,

-- SamR

# [CSC-207 2024Fa] Some notes from SamR on MP1 (2024-09-07)

Dear Decipherers (of enciphered text and CS assignments),

I have a variety of things to share with you about MP1.

1. I've "graded" the first few pre-reflections (preflections?) and have released the graded work on Gradescope. You can check out my comments there.

2. I've posted answers to all the questions I received to the end of the mini project in the Questions and Answers section.

3. If you haven't done the pre-reflections yet, for #3, I'd really like you to attempt a "brain dump". Don't just say "I'll need to write static methods and import methods from elsewhere. The goal is to actually get near-code out of your brain because it builds brain connections. What do static methods look like? What do main methods look like? What does an import statement look like?

4. Don't forget that there's a mentor session on Sunday night at 7pm in 3819. You earn a token for attending mentor sessions (and reporting on them to the extra credit page).

5. I should have unit tests ready for you by Tuesday. We'll be using those instead of an autograder on Gradescope.

6. Also a reminder: Our class mentors are only available to you during class and at mentor sessions. If you need help at other times, you should rely on the evening tutors. If you happen to see our class mentors in our classroom or on Noyce 3rd at other times, they are likely working on their own work.

Regards,

-- SamR

## [CSC-207 2024Fa] Maven reading posted (2024-09-01) 

Dear Array-ngers

The Maven reading is now posted at <https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/readings/maven.html> . It has way too much output, particularly in comparison to the content. Feel free to skim.

-- SamR

## [CSC-207 2024Fa] Reading responses for Tuesday (2024-08-31)

Dear Stack Specifiers,

I hope you are well and that your weekend is going well.

I'm still working on the reading on Maven. But I can tell you in advance that there will be no double-dagger problems in that reading. So feel free to do the other readings. I hope to have the Maven reading ready tonight.

As always, questions are welcome via teams and email.

Regards,

-- SamR

## [CSC-207-02 2024Fa] The second half of Thursday's class / the start of Tuesday's class (2024-08-31)

Dear CSC-207-02 Students,

I hope you are well and that you have some time to enjoy the weekend.

Sorry for leaving class early on Friday. We spent some time in the ER and then they admitted my wife.

Since you missed the second half of the class, the best thing is probably to watch the video recording of the second half of section 1 to get a sense of the kinds of things we'd talk about in designing things. (You can also check out the eboard.)

We have some doctor's appointments on Tuesday. I expect to be back in time for class, but if I'm not, you should start the lab without me. The instructions should be fairly clear and Garikai can help with the confusing parts.

Regards,

-- SamR

## [CSC-207 2024Fa] Reading 1 graded (partially); Token opportunities (2024-08-28)

Dear CSC-207 Students,

I hope you are well and that you enjoyed today's campus gathering (if you chose to participate).

I've responded to all of the reading responses I've received so far and you can see them on Gradescope. My normal approach will be to give quick responses to all of the responses I receive by some time on the night before class and then to check off the remaining ones when I have a chance. Sometimes I'll just look at your questions.

Since some token activities are before section 2 on Thursday, I thought I'd mention the token activities for Thursday.

* Thursday, 2024-08-29, 11:00 a.m., JRC 101.
  President Anne F. Harris -
  _Moving Knowledge into Action: Initiatives and Actions in Year Two of the Strategic Plan_.
* Thursday, 2024-08-09, 6:00 to 8:00 p.m., Grinnell Museum of Art and environs.
  Student Night at the Museum.
* Thursday, 2024-08-29, 3:00 p.m. to 7:00 p.m., Central Park.
  _Ag Appreciation Day_.

See you Thursday!

 -- SamR

## [CSC-207 2024Fa] Welcome to the course! (2024-08-26)

Dear CSC-207 Students,

Welcome to the course!

I hope you've had a great summer and that you're energized for a new semester of learning. I'm glad to see so many awesome students I know moving on to CSC-207, and I look forward to meeting those I don't know.

This message is your first course message ("Spam from Sam") for the semester.

The draft course Web site is now up and running at <https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/> .

You'll be able to see the syllabus, schedule, and the normal variety of handouts. There will probably be some changes before the start of the semester, but most of the key information is there.

You have some assignments to complete before the first day of class.

* Skim [the syllabus](https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/syllabus/) and bring questions to class.
* Skim [the schedule](https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/schedule/) and bring questions to class.
* Read "[Basics of object-oriented problem-solving](https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/readings/oop-basics.html)" at <https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/readings/oop-basics.html>.
* Read "[Designing abstract data types](https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/readings/designing-adts.html)" at <https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/readings/designing-adts.html>.
* Read "[Designing data structures](https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/readings/designing-data-structures.html)" at <https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/readings/designing-data-structures.html>.
* Fill in [the reading response on Gradescope](https://www.gradescope.com/courses/818402/assignments/4803432/). The reading response will ask you to apply the techniques for designing ADTS and data structures.

You should also check that you can log in to the class Team and to the class Gradescope instance.

Feel free to send along questions via email or Teams DM.

Regards,

-- SamR
