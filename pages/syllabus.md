---
title: Syllabus
permalink: /syllabus/
---
# Object-Oriented Problem-Solving, Data Structures, and Algorithms

<dl class="dl-horizontal">
  <dt>Instructor</dt>
  <dd>
    <p><a href="{{ site.instructor_homepage }}">{{ site.instructor }}</a></p>
  </dd>

  <dt>Meeting Times</dt>
  <dd>
    <ul class="list-unstyled">
      {% for item in site.meeting_times %}
        <li>{{ item | markdownify | remove: "<p>" | remove: "</p>" }}</li>
      {% endfor %}
    </ul>
  </dd>

  <dt>Office Hours</dt>
  <dd>
    <ul class="list-unstyled">
      {% for item in site.office_hours %}
        <li>{{ item | markdownify | remove: "<p>" | remove: "</p>" }}</li>
      {% endfor %}
    </ul>
  </dd>

  {% if site.review_sessions %}
    <dt>Review Sessions</dt>
    <dd>
      <ul class="list-unstyled">
        {% for session in site.review_sessions %}
          <li>{{ session }}</li>
        {% endfor %}
      </ul>
    </dd>
  {% endif %}

  {% if site.textbook %}
    <dt>Textbook</dt>
    <dd>
      {{ site.textbook | markdownify | remove: "<p>" | remove: "</p>" }}
    </dd>
  {% endif %}

  {% if site.mentor %}
    <dt>Class Mentor</dt>
    <dd>{{ site.mentor }}</dd>
  {% endif %}

  {% if site.mentors %}
    <dt>Class Mentors</dt>
    <dd>
      <ul class="list-unstyled">
        {% for mentor in site.mentors %}
          <li>{{ mentor }}</li>
        {% endfor %}
      </ul>
    </dd>
  {% endif %}

  {% if site.mentor_sessions %}
    <dt>Mentor Sessions</dt>
    <dd>
      <ul class="list-unstyled">
        {% for session in site.mentor_sessions %}
          <li>{{ session | markdownify | remove: "<p>" | remove: "</p>" }}</li>
        {% endfor %}
      </ul>
    </dd>
  {% endif %}

  {% if site.tutors %}
    <dt>CS Tutors</dt>
    <dd>
      <ul class="list-unstyled">
        {% for tutor in site.tutors %}
          <li>{{ tutor }}</li>
        {% endfor %}
      </ul>
    </dd>
  {% endif %}
</dl>

## Overview

Welcome to CSC 207, _Object-Oriented Problem Solving, Data Structures, and Algorithms_!  The official course description is as follows.

> An introduction to the ideas and practices of object-oriented computation: message passing, information hiding, classes and interfaces, inheritance, polymorphism, and reflection. The course also includes data structures and the associated algorithms, packages and libraries, exceptions, and the use of an integrated software-development environment. Includes formal laboratory work.

My take on this course is that it is where you really start delving deeply into what it means to be a computer scientist, computer programmer, or software designer.  We will continue your exploration of the design of algorithms, data types, and programs, but will delve more deeply into tools and analysis techniques related to each.  We will use Java as our programming language because it supports some tools and techniques you have not learned previously, particularly through its support of the object-oriented paradigm.  As in all Grinnell classes, we will also work on general skills, from group work to "thinking on your feet".

## Time and workload

Grinnell has indicated that a 4-credit course, like this one, should involve approximately 180 hours of work, which matches some guidance from the U.S. government.
Across a 14-week term (plus a week finals), that ends up being approximately 12 hours of work per week.
I have not been able to get anyone to answer the question of "180 hours *for whom* and *for what grade*?", I've been given the impression that I should strive for that workload for the "average" student in a course who seeks to earn a B.
In general, the twelve hours should work out to approximately four hours per week in class, three hours per week on readings (one hour per day), four hours per week on either mini-projects (homework assignments) or SoLAs (exams), and one hour per week for mentor sessions.
If you find yourself working much more than the expected amount in this course, please let me know.
It could be that other approaches to your work, or better support resources, can help.

## Diversity and inclusion

I believe that any college-level course should challenge you and put you outside of your comfort zone.
My mission as an instructor is to help you manage that discomfort so that you can grow in knowledge and maturity.
Therefore, I strive to create a fully inclusive setting so that we all can ultimately succeed in the classroom.

### Learning needs

I welcome you to talk to me as early as possible about your distinctive learning needs.
I particularly encourage students with disabilities to meet with me and discuss how our classroom and course activities could impact their work and what accommodations would be essential.
I will also make adjustments for students without documented disabilities.  However, I recommend that you seek official accommodations if it is possible and appropriate to do so.
In particular, I recommend talking to our Coordinator for Student Disability Resources for guidance and further instructions:

+ Jae Baldree, Steiner 209, x3089, baldreej@grinnell.edu

You can find some additional details in [my statement on accommodations and adjustments](../handouts/accommodations).

### Religious observance policy

I also support the class's religious diversity and anyone who needs to balance academic work with religious observations.  Please let me know by the end of **week two** if you will need to be absent from class for any religious holidays this semester, and we can work out an appropriate schedule for making up absences or missed work.

### Community guidelines

Our class is a community.  We should behave as such.  Among other things, that means treating others with respect, not only in the language that we use (no slurs, please), but also in taking others' ideas, approaches, perspectives, and identities seriously.  We will discuss appropriate guidelines for the class throughout the semester, developing those guidelines as a community.

### Basic needs security

Any student who has difficulty affording groceries or accessing sufficient food to eat every day, or who lacks a safe and stable place to live, should know that these difficulties are likely to affect their performance in the course. Such students are urged to contact the [Dean of Students](https://www.grinnell.edu/profiles/student-affairs/staff) or the [CRSSJ](https://www.grinnell.edu/about/offices-services/crssj) for support. You may also notify me, if you feel comfortable doing so, and I will do my best to help you identify and arrange other resources.

### Other accommodations and adustments

There are many other ways in which it may be appropriate to adjust course policies and it is not possible to attempt to address them all in a few policies.  These may include other issues best addressed earlier in the semester (*e.g.*, student-athlete scheduling) or as they arise (*e.g.*, chronic health flare-ups).  I will do my best to be flexible in these cases with the overall goal of facilitating your growth in this course.  Please keep me informed!

In some cases, I will recommend consulting with the Academic Advising staff. They are an excellent resource for developing strategies for academic success and can connect you with other campus resources as well: <http://www.grinnell.edu/about/offices-services/academic-advising>. If I notice that you are encountering difficulty, in addition to communicating with you directly about it, I will also likely submit an academic alert via Academic Advising's SAL portal. This reminds you of my concern, and it notifies the Academic Advising team and your advisor(s) so that they can reach out to you with additional offers of support.

## Evaluation and grading

This course employs a grading system based on [*mastery grading* and *specifications grading*](https://docs.google.com/document/d/13V1fsPve19IU-tFNt4AeQ78VepuqVakp3xizJrj5KwY/edit) to evaluate your work.
These systems, inspired by adult learning theory, are designed to create a "low-threat" learning environment where:

+ Mastery obtained via exploration, experimentation, and failure is encouraged and valued as highly as "getting it right" the first time.
+ Your final grade accurately reflects your mastery of the learning goals of the course.
+ The expectations for grades should be easy to understand and easily trackable.

Ideally, all of you should be able to meet all of the goals in a reasonable amount of time (see the note about time and workload above).
To achieve high grades, some of you may find that you have to redo some of the work in the class.
Many of the components of the course have "no penalty" redos available.
See the notes below and in the [handouts](../handouts) for more details.

### Deliverables

I rely on five kinds of work to assess your mastery of the material.

+ **Lab exercises**: practice problems worked on during class, frequently collaboratively, with a partner.  _**Lab exercises are generally due immediately before the next class**_ (e.g., the problems associated with the lab from Wednesday's class are due Friday at 8:30 a.m. and the problems associated with the lab from Friday's class are due Monday at 8:30 a.m.).
+ **Mini-Projects**: individually completed, small-scale programming projects that apply the weekly concepts to the themes of the course.  (We may, on occasion, refer to "mini-projects" as "demos", using the terminology from the prior term.)  To earn an A, one must do an excellent job on most of the mini-projects and the group project.  (You will be able to re-do any project that earns less than excellent.)  _**Mini-Projects are generally due on Tuesdays at 10:30 p.m.**_
+ **Learning assessments**: individually completed problems that directly assess your mastery of the learning goals of the course.  To earn an A, one must pass learning assessments for N of the M learning objectives.  (You will have the opportunity to retake any of the learning assessments you do not pass.)  I'm going to try a new approach to LAs this semester. In most cases, I will simply ask you to provide evidence that you've mastered the topic, rather than having you solve a new problem. In a few cases,  I will ask you to solve a new problem.
+ **Metacognitive reflections**: Short reflective pieces given before and after most assignments and exams.  _**Pre-task reflections are generally due a day or two after a task is assigned.  Post-task reflections are generally due a day or two after the task is due.**_

*Lab exercises* are designed for you to practice and explore the concepts of the course in a supportive environment.  Consequently, you may collaborate on these problems with your classmates, consult external resources, or ask the course staff for questions, provide that you cite them in your produced deliverable.  These deliverables are checked primarily for completion and effort rather than total correctness.  

*Mini-projects* are designed to give you the opportunity to demonstrate your knowledge and mastery on more complex problems.  Work you turn in for mini-projects should be your own.  You may consult others for ideas and help, provided you appropriately acknowledge that help.  

*Learning assessments* are designed to demonstrate your mastery of the courses naturally measurable learning goals.  You may only discuss these deliverables with the course staff.  These deliverables are checked for both correctness and appropriate design. 

*Metacognitive reflections* are intended to help you build your broader metacognitive skills and will generally ask you to reflect on what you expect from each project (assignment) (e.g., "What will be the hardest part of this project?" and what you discovered from each project (e.g., "What aspect of the project took you the most time and why?").

The details of and rationale for the policies are complex enough that I have moved them to [a separate document on grading](../handouts/grading).

### Letter grades

Letter grades for the course are determined by *bundles*, a collection of required grades for each of the deliverable categories.  You will receive the grade corresponding to the bundle for which you meet *all* of the requirements.  All bundles list *minimum amounts*, you may exceed the requirements for a bundle and still qualify for it.

Note that I reserve the right to update requirements for grades as circumstances dictate over the course of the semester, *e.g.*, if a deliverable is cut.  I will generally update the requirements so that they are no stricter than they were previously.

---

<table class="table">
<thead>
<tr>
<th scope="col">Overall</th>
<th scope="col">Projects ({{ site.data.bundles.totals.projects }})</th>
<th scope="col">LAs ({{ site.data.bundles.totals.las }})</th>
</tr>
</thead>
<tbody>
{% for tier in site.data.bundles.tiers %}
<tr>
<th scope="row">{{ tier.grade }}</th>
<td>{{ tier.projects }}</td>
<td>{{ tier.las }}</td>
</tr>
{% endfor %}
</tbody>
</table>

### Plus/minus grades

If your two primary grades are at the same level, you will earn that letter as the base grade.  I hope that you can all demonstate learning at the A level.

If your two primary grades are at different levels (e.g., projects at the B level and learning assessments at the A level), you will generally earn a grade between the two, with the particular level dependent on where in the range of each you fall.  Note that if you receive a C on one primary grade and an A on the other, your base grade will be a B-.

Your grade may also be affected by reading problems, labs, metacognitive reflections, and tokens.

Note that Grinnell does not permit grades of C-, D+, or D-.  A grade below C and at least D will be recorded as a D.  A grade below a D will be recorded as an F.

### Laboratory assignments and metacognitive reflections

You are allowed to miss up to four total lab assignments and metacognitive reflections in the semester without penalty.  If you miss more labs or reflections, your overall letter grade will be lowered by one-third of a letter grade for each two additional labs or reflections you miss. Excesses of one also result in a loss.  For example,

* If you miss three lab writeups and one reflection, you've missed *four* total things and there is *no penalty*.
* If you miss three labs and three reflections, you've missed *six* total things, which is two more than you are permitted.  *Your overall letter grade drops by one-third*, such as from a B to a B- or from an A- to a B+.
* If you miss one lab writeup and four reflections, you've missed *five* total things, which is one more than you are permitted.  Once again, *your total letter grade drops by one-third*.
* If you miss four labs and three reflections, you've missed *seven* total things, which is three more than you are permitted.  *Your overall letter grade drops by two-thirds*, such as from a B to a C+ or from an A- to a B.
* If you miss eight labs and zero reflections, yo've missed *eight* total things, which is four more than you are permitted.  *Your overall letter grade drops by a full letter*, such as from a B to a C, from an A- to a B-, or from a B- to a D (there is no C-).

I hope that you will do your best to miss as few labs and reflections as possible.

### Redos

Because I care more that you learn the material than that you learn it by a particular deadline, I permit redos for the major work in this course.  Redos on learning assessments are automatically available. In general, you may try them again on the next set of learning assessments (SoLA).  Redos on lab writeups and metacognitive reflections are rarely permitted.  Please speak with me if you would like to redo a reading response or lab writeup.

Your first redo on a mini-project is generally free.  Subsequent redos on mini-projects may require tokens; see [the handout on tokens](../handouts/tokens) for details.  When you receive a graded mini-project, it will generally include a checklist of issues that you must address to get a higher grade.  Please reproduce the checklist in your re-done project.  Where appropriate, you should indicate how you addressed the issues we have described.

### Final deadline for all work

Note that *all* work must be submitted by {{ site.all_work_deadline }}.
This is College policy and cannot be waived for any reason.  If you find yourself needing to turn in work past this deadline, you must consult with me as soon as possible to submit an *incomplete request* for the course.  If you take an incomplete in the course, the only work you can make up will be one of the mini projects.

### Tokens

To provide a consistent and clear mechanism for dealing with the issues that regularly come up during the semester (e.g., late work, extra resubmissions), I rely on a variant of the "[token system](../handouts/tokens)" designed by my colleague Peter-Michael Osera.  In short, you begin the semester with a few tokens and use them up as you turn in work late, show up to class late, or miss class without notifying me.  You may earn additional tokens by attending events that I deem appropriate, such as talks related to the course or your colleages' performances and competitions.

You can usually check your token status on Gradescope.  The regular status reports may also include information on tokens.

Please read [the handout on tokens](../handouts/tokens) for more details.

### Course breakpoints

Our grading system offers flexibility.  However, it adds a cost of giving the illusion that if you fall behind in your work, there is always an opportunity to catch up. While this is true in theory, in practice, it is difficult to do so in many situations because of personal issues, competing courses, extracurricular obligations, etc. This flexibility also makes it difficult---for both you and me---to determine when you have fallen behind in the course and need external help whether that it is from the course staff, tutors, or academic advising.

We encourage you to also preemptively come to any member of the course staff---the instructor, the course mentor, our Peer Education Coordinator---for help and guidance if you feel like you are falling behind. However, to be more clear about when you might be falling behind in the course, I will do my best to track the following _course breakpoints_ in your progress. In particular, when one of the following situations occurs, I will follow up with you as well as academic advising (via an academic alert) to check in. 

* You miss two or more days of classes in a row.
* You have used all of your tokens.
* You receive an I on a mini-project.
* You do not turn in a revision for a mini-project graded as an R.
* After a SoLA, you have completed less than 60% of the LAs to date.
* You are otherwise at substantial risk of earning below a C in the course.

If any of those issues happen, we should also talk so that I might provide guidance and help you develop a plan for getting back on track, e.g., by assigning an individual tutor.

## Software, textbooks, references, technology, and such

There are several software packages we use in this course both for learning how to program as well as conducting learning online.

+ [Visual Studio Code](https://code.visualstudio.com), a general-purpose Integrated Development Environment (IDE).
+ The Java Programming Language.
+ The JUnit Testing Framework.
+ Your [Grinnell Office365 account](https://office365.grinnell.edu) for email and [Microsoft Teams](https://teams.microsoft.com) for discussion and collaboration.
+ [Gradescope](https://gradescope.com) for assignment submission and feedback communication.

Please make sure you can access all of these resources, and please let me know if you have any problems with access.

### Books

There is no required textbook for this course, as the primary material is written by Grinnell faculty and posted on the course website.  However, there are some useful textbooks and references you may want to bookmark or keep handy.  I will make regular reference to CLRS4.

Cormen, Thomas, Leiserson, Charlies, Rivest, Ron, and Stein, Cliff (2022).  _Introduction to Algorithms_, 4th edition.  Cambridge, MA: MIT Press.

Our library has purchased electronic access to this text, but you may also find it useful to purchase a physical copy.  Please do not illegally download copies of this text.  Given that you have legal access, you should avail yourself of that access.

### Other references

Oracle (2022).  [_Java 17 API: Module java.base_](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/module-summary.html)

> The primary reference pages for the standard Java classes.  PM notes
  that "[T]he Java standard library documentation is the best organized
  API document out there, and is a large reason why Java is so
  popular."  We're using version 17 of Java, rather than version 20,
  because it's the newest version that can easily be installed on 
  MathLAN machines.

Oracle (2016).  [_The Java Tutorials_](https://docs.oracle.com/javase/tutorial/)

> The Java Tutorials were once the go-to guides for learning new concepts
  in Java.  Unfortunately, Oracle has not updated them since Java 8.
  Nonetheless, they still provide a wealth of useful information.

Google (n.d.).  [_Google Java Style Guide_](https://google.github.io/styleguide/javaguide.html)

> The style guide you should use for your code in this course.

## Help, collaboration, academic honesty, and academic integrity

To help expedite your learning, you can rely on me, our class mentor, and your peers as outlets in this course.

### The Instructor, course staff, and other resources

When contacting the course staff, please use direct messages (DM) on Microsoft Teams.  While we will generally not respond immediately—--we generally check our messages at fixed times throughout the day—--we will prioritize responses to student questions over Teams versus queries sent through other means, *e.g.*, email.

The **course mentor** also holds weekly *mentor sessions* outside of regular class time.  In these sessions, the mentor guides you through practice problems designed to help you master the material and answer any questions you have about the material.  I highly recommend you attend each of these sessions, even if you feel like you understand the material.  You never know what you don't know, and the purpose of these sessions is to bring these blind spots to light!

The CS department provides **evening tutors** from 7--10 p.m. most nights of the week (Sunday through Thursday).  I encourage you to make use of the evening tutors.  

The CS department also provides **individual tutors** as needed.  If you find yourself struggling with the material, please let me know and I'll work with our peer education coordinator to get one assigned to you.

Finally, if you would like to discuss things in more detail—--course content, more general questions about computer science, or other things—--feel free to schedule a (virtual) meeting with me, either [during office hours](https://bit.ly/book-samr) or, if those don't work, by sending me a message with available times.

Note that if I find that you have fallen behind on assignments or are showing difficulty on quizzes or learning assessments, I will invite you to meet with me.  Please accept those invitations; they are intended to be supportive, not punative.

### Peer learning

Utilizing discussion with peers to facilitate your learning is a critical skill for success in computer science.  However, at the same time, you must be aware that getting stuck and pushing through challenging problems is essential for robust learning.  To this end, we allow the following forms of collaboration.

+ You are encouraged to collaborate with your peers on reading exercises, labs, and projects.  You may also consult the course staff as well as other people and external resources.  In all cases, you (or your group in the case of group work) should independently write up your solutions and cite all the resources you used in authoring your work, including the other students.
+ You may only discuss learning assessments and quizzes with the course staff.
  When completing assessments and quizzes, you may only consult the course website and any additional documentation we provide.  You may not collaborate with peers, consult external resources beyond the ones mentioned above, or share information about these assignments with others.

Keep in mind that *adaptation of pre-existing code* whether it comes from a peer, myself, or the Internet, requires a citation in cases where it is allowed.  Also, whenever you are expected to show your code's output, you are expected to reproduce the output faithfully.  In other words, you should not forge the results of your programs!

In all cases, the work that you produce should be your own.  In general, you should be capable of reproducing any part of your deliverable with minimal effort if it was accidentally deleted.

If you feel that the stress and pressure of the course or the semester are leading you to consider violating the academic honesty policies of the course and the College as explained in the [student handbook](https://catalog.grinnell.edu/content.php?catoid=12&navoid=2537#Honesty _in_Academic_Work), **please talk to me as soon as possible**.  The course's grading policies as designed to help you manage your time in light of the different stressors in your life.  I will do my best to work with you to figure out how to help you better manage your time relative to your learning goals and desired achievement level for the course.

And just if that wasn't enough, you should check out [my extended statement on academic honesty and integrity](../handouts/academic-honesty).

### Sharing of course materials

Our goal is to create an inclusive learning environment where people feel free to share, fail, and ultimately grow in knowledge.  To create such an environment, it is imperative that we be mindful of what we share outside of our learning space.  To this end, I request that you refraining from sharing any recordings of our class meetings with others.  Recordings of class meetings that we provide, *e.g.*, recorded through Microsoft Teams, are meant for your *personal use* and should not be shared outside of the class.

Furthermore, while you retain [copyright](https://www.plagiarism.org/blog/2017/09/25/do-i-own-my-work-even-if-im-just-a-student) of the work you produce in this course, we must still uphold the academic integrity of this course.  To this end, you may not share copies of your assignments with others (unless otherwise allowed by the course policies) or upload your assignments to third party websites unless substantial changes are made to the assignment (*e.g.*, significant extensions and improvements to your code) so that it is clear that the end product is significantly different from what was asked in original assignment.

I recognize that there are times where you want to do this, *e.g.*, uploading projects to Github for your resume or to show to friendds and family, and so I encourage you come talk to me in advance, so that we can ensure that you upload a meaningful project that does not run afoul of this policy.

ITS has released and then temporarily withdrawn policies that may limit your ability to share your work with others.  I consider those policies inappropriate for many reasons.  The CS department managed to convince the College to revisit them, but we are not sure what the new policies will look like.  Stay tuned.

### AI programming assistants

Please avoid the use of AI-based programming assistants, such as ChatGPT or GitHub Copilot in this course.  You should also review [my policy on AI programming assistants](../handouts/ai).

## Practice for technical interviews

It turns out that both the topics we cover (e.g., ADTs and algorithms) and the approaches we use in this course (e.g., testing and design) are often emphasized in technical interviews.  Hence, we'll spend some time on interview-like activities in the course.  Stay tuned for further details.

## Accessibility

I hope to incorporate a variety of assignments exploring accessibility in computers as part of the course.  Programmers don't pay enough attention to accessibility issues, and I hope that some assignments that explore these issues may help you consider people with different capabilities.

## Other issues

### Asking questions

We prefer that you ask general questions in the Questions and Answers channel on Teams. Doing so helps ensure that everyone has access to the answers. If you ask us questions in other ways, we will encourage you to use the Q&A channel.

We also prefer that you title your questions on Teams. After clicking "New Conversation", click on the icon with an A and a pencil. That will give you the opportunity to add a subject.  Click on the paper airplane in the lower-right-hand corner to post the question.

Feel free to answer each others' questions.

We understand that not all students are comfortable asking questions in public and that not all questions are appropriate for the whole class. Feel free to ask us questions via Teams chat, via email, and in person.

### Office hours

I have a different approach to office hours than most faculty. I prefer that you book my office hours in advance, rather than just showing up during office hours. You can book office hours at <https://bit.ly/book-samr>. In general, you should book a fifteen-minute slot unless you've discussed using a longer slot with me.

You may, of course, show up during office hours without booking them. In those circumstances, I will be happy to meet with you if no one has booked the time or if someone finishes early. I am also often happy to meet with students outside my regular office hours. If my door is open, feel free to knock and ask.

If my office hours do not work for you, I am happy to meet with you at other times. You can propose a meeting time with the Microsoft Scheduling Assistant. You can also email me. Please stick to the normal workday (8am to 5pm).

I tend to respond to questions submitted on Teams (preferably on the Questions and Answers channel, but also sent via direct message) outside of office hours, including in the evening.

I have some complex personal circumtances that may require that I hold office hours remotely or cancel office hours. I will do my best to keep you posted about such issues.

### Technology

This may be your first semester learning with Teams.  Things will likely mess up from time to time.  That's okay; it's part of the process.

This may be your first semester using Gradescope.  Gradescope does some things well and some things less wengll.  Things will likely mess up from time to time.  That's okay; it's part of the process.  I'll make adjustments when you have difficulty.  I hope you'll accept my apologies when I do something wrong (or at least fail to adjust my processes to the way Gradescope thinks they should be done).

This may be your first semester using VSCode and a modern build tool.  It's certainly my first semester using VSCode with Java and Gradle.  That's okay; we'll learn together.

### Multiple sections

There are multiple sections of this course.  The primary learning goals for both sections should be the same (although we may phrase them differently).  The ways in which we measure your success at achieving those will differ.  There are also section-specific learning goals that reflect the individual perspectives of the instructors.

### Names

I get names wrong.  I get names wrong all the time.  Evidence suggests that I am not just bad at remembering names, I also have some brain differencees that regularly lead me to mix up peoples' names.  I think, for example, of two of my favorite research students, one with blonde hair, from Minnesota, who also served as a teaching assistant for my software design course; the other with dark hair, from Massachusetts, who brought a wealth of background in education to my research projects.  I can tell you a lot about each student (although I wouldn't without their permission), including hobbies, where they studied abroad, what they are doing now (or at least what they were doing a year so so ago), and more.  But I inevitably reversed their names, calling Minnesota Massachusetts and Massachusetts Minnesota.

When I discussed this issue with my family, my sons laughed and said "Dad, you get *our* names backwards, too; we just ignore you when you do so." And I've heard from other students I value highly that I do this and don't always notice.  (The other day, I almost referred to an alum by a different name.)

If I use the wrong name for you, it is not a sign that I do not respect your or that I do not care about you.  It's a deficiency in my processing, and one that I seem unable to fix.  Please accept and understand that disability, just as I will do my best to accept and understand your own differences.

### Teaching is performative

I believe that all teaching is a form of performance.  That performance may not always be explicit.  Nonetheless, I perform a particular role, perhaps even roles.  In my roles, I may say some things that seem strange.  Remember; it's a performance.

### Feeling overwhelmed

You may feel a bit overwhelmed by this point.  I know that I do after re-reading most of it and re-writing some of it.  **Don't worry!**  CSC-207 has a great support system, a carefully designed pedagogical methodology, and an incredibly awesome topic.  (Yes, I know I am biased.) Most students who take the course excel.  We'll enjoy this together.

I will also try to be respectful of your time.  Please let me know if you find yourself regularly spending more than twelve of so hours per week on this class, which is what the College considers appropriate for a four-credit course.  (We have four hours in class each week, we suggests that you have eight hours out-of-class for readings, review, and mini projects.)

## Frequently (and not-so-frequently) asked questions

I'm confused about the grading scheme.  Could you explain more?

> In short: The grading scheme is designed to assess you on what you've learned, not when in the semester you've learned it.  There's also a strong incentive built in for you to keep up with the work.  Doing regular work, even if it's not perfect, and receiving feedback on that work, is one of the best ways to learn.

> Broad overview: To succeed in the class, you must do the learning assessments (LAs) and projects (MPs and the final project).  Since not everyone learns at the same rate, you will have the opportunity to make additional attempts at  LAs (although with new problems) and projects.  In addition, you must keep up with regular work for the class: readings (and reading responses), labs (and lab writeups), and reflections.  If you keep up with the work and achieve appropriate results on the LAs and projects by the end of the semester, you are likely to do well in the course.  Additional details are found above and in [the page on grading](../handouts/grading).

> If that's not enough information, feel free to ask questions about particular points.

I plan to leave early for Spring break and won't be in class on Friday, 15 March 2024. What are the penalties for missing that class?

> As long as you let me know in advance, there is no penalty for your absence.

>  However, you will not be able to take the quiz that day, which means that you will have to complate that learning assessment in one of the following SoLAs.  In addition, you are responsible for making up the work from class on your own, and you are still responsible for turning in that labs.

I need a mental health day.  What should I do?

> Send me an email message telling me that you need a mental health day. Plan to make up the lab on your own and submit it before the next class. If you need extra time for the lab, you'll need to use a [token](../handouts/tokens).
  
> More importantly, please take care of yourself.

How do I book your office hours?

> <https://bit.ly/book-samr>

