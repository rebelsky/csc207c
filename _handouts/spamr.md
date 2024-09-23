---
title: Spam from Sam
---
# {{ page.title }}

_Here you will find most of the email that I sent out this semester, with the newest email at the top and the oldest at the bottom._

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
git remote add https://github.com/Grinnell-CSC207/mp-blocks-maven
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
