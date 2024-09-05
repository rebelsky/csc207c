---
title: "Eboard 03: Getting started with Java development tools"
number: 3
section: eboards
held: 2024-09-05
link: true
---
# {{ page.title }}

**You are probably not being recorded** 

_Start of class instructions_

* Optional: Grab a mask
* Grab one of the business cards on the table that have computer names 
  and locations.
* Identify where the corresponding computer is.
* Return the card to the jar.
* Navigate to the computer.
* The first person at the computer logs in.
* When both partners arrive, introduce yourselves.
    * Recommended: Discuss working strengths and areas to improve

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
* Questions
* Lab one: Getting started with VSCode
* Lab two: Getting strated with Git

Preliminaries
-------------

### News / Etc.

* You have a guest instructor today, so the eboard is just here to
  present info to you (e.g., upcoming work, Q&A). 
    * Please be nice to the guest instructor.

### Upcoming work

* Readings due Monday night
    * [Writing your own classes](../readings/writing-classes)
    * [Standard object methods](../readings/standard-methods)
* Submit [reading responses for class 4](https://www.gradescope.com/courses/818402/assignments/4894859/) by 10:30 pm on Monday
* Submit [today's lab](https://www.gradescope.com/courses/818402/assignments/4894843) by 10:30 pm on Monday (but preferably at the end of class today)
    * A different kind of lab report.
* Submit [mini-project 1](../mps/mp01) by next Thursday
    * Unit tests to be distributed next Tuesday.
    * Gradescope assignment to be posted next week.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Thursday, 2024-09-11, 11:00 a.m.--noon, JRC 101.
  _Scholars’ Convocation:
   Dr. Jarvis R. Givens - 
   Black Educational History for All Learners_

#### Cultural

#### Multicultural

* Friday, 2024-09-06, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_
* Friday, 2024-09-13, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere_

#### Peer

#### Wellness

* Sunday, 2024-09-08, 10:00--11:00 a.m., JRC 101.
  _Chai Time_

#### Misc

* Wednesday, 2024-09-11, 4:30--6:30 p.m., HSSC A1231 (Kernel/Multipurpose Room).
  _Deloitte Information Session_ (includes at least one CS major)
* Wednesday, 2024-09-11, 7:00--8:00 p.m., HSSC S1325.
  _Saving the Planet One Page at a Time: The Carbon Almanac with Robert Gehorsam ’76_
* Thursday, 2024-09-11, 4:00--7:00 p.m., Central Campus + Kington Plaza.
  _Student Involvement Fair_

### Other good things (no tokens)

* Sunday, 2024-09-08, 3:00--5:00 p.m., Springer Field.
  _Men's Soccer vs. Eureka_
* Wednesday, 2024-09-11, 6:00--8:00 p.m., Darby.
  _Volleyball vs. Nebraska Wesleyan._

### Thursday PSA

* Please take of yourself this weekend. You are awesome and should
  preserve that awesomeness.
* Do not fall victim to peer pressure (which is often perceived).
  Decide in advance what is right for you and stick to your plan.
* If you cohabit, consent is necessary (but not sufficient)
    * Necessary: Ensure that your partner agrees to what you want
      to do. Understand that consent can be withdrawn.
    * Insufficient: Cohabitation should be more than "can I do this".
      Discuss what you want to do in advance.

Questions
---------

### Maven

What should our files look like when we're done setting up? I can't shake the feeling that I've done something wrong.

> That's a bit broad. I'll work on getting a description of the file
  hierarchy and the `pom.xml` file. Remind me if I don't have it ready
  soon enough.

### Git

What exactly is the difference between Git and Github? 

> Git is a tool for managing versioned code. It supports local
  repositories and remote servers.

> GitHub is a standard and popular Web-based repository server.

Why are we using Git through GitHub?

> GitHub is one of the most popular Web-based repository servers
  (perhaps the most popular) and it's free.

> The department has generally used GitHub as our server.

I am confused as to how to work with Git.

> You'll get practice in lab.

Would there be future instructions on how to use VScode and github
on personal machines?

> Nope. But the work is quite similar on personal Macs and Linux 
  workstations/laptops. Windows is a bit different, but it should be 
  straightforward. You'll just need to do a bit of Web searching.

How do we get the git commands to work on our personal computers
terminal? Is it necessary?

> Install Git on your computer. It's necessary if you want to do
  homework on your personal computer (although I suppose you can use
  the Git tool in VSCode). Remember that I expect you to follow good
  Git habits, which means regular commits with good messages.

I can't pull from my private Git repository or push to my repository. I
get a message like ""Permission denied (publickey)"

> Make sure that you've set up your keypair correctly.

What do you mean by "Grinnell College notes that you may want to
keep your work pseudonomized"?

> If your work is in a public repo, others can read it. I ask you to
  put most of your class code in public repos. Hence, if your account
  clearly identifies you as you, other people can see the quality of
  your classwork. If the GitHub account is clearly associated with you,
  they'll know that the good and bad parts are yours.

> In my experience, almost everyone who looks at GitHub repos (including
  prospective employers) knows that schoolwork is not necessarily
  representative. (However, I have been told that good code and good Git 
  habits are taken as a positive.)

What happens if you push before pull?

> Git will generally complain if there are changes to the repo and you attempt to push before pulling.

Will you show us how to make a .gitignore file so we can ignore .class file when committing code?

> Yes. There's a [standard .gitignore for this class](../files/gitignore)
  that should serve as your starting point.

Does committing mean that you're saving changes?

> Yes.

Why do we "add a note about the changes"?

> To keep a history (for yourself and for others) about why you've
  made the changes you've made. That helps if you need to decide to
  rollback part or all of your code.

Can you please explain what's happening here: "In some other situations, you start by forking the repository on GitHub and then cloning your fork."

> "Forking the repository" -> Making a copy of the repository on GitHub.

> "Cloning the repository" -> Making a copy of a GitHub repo on your local computer.

Is forking only necessary if we don't have write access (to push a branch, doesn't need to have merge to main access)? If we do, should we just clone?

> Different organizations have different development styles. The
  more complicated a project, the less likely it is to permit direct
  pushes; all code should be reviewed. In some cases, this means using
  forks. In some cases, it means using branches.

> You might also fork if you want to start developing something
  independently of the main project. For larger open-source projects,
  the most often happens when two sets of developers want to move the
  project in different directions.

Will we ever have to merge branches in this class? I've had merging
be a hassle in the past (especially with a large group of people),
and have had it taken a whole day of class before.

> We probably won't have to merge branches, but you will have to deal
  with multiple people potentially making changes to the same file.
  (And yes, that involves merging.)

> The more frequently you bring things up to date, the less frequently
  you'll encounter merge errors.

Can you explain branches? Are they only created in the main repository
or can they also be utilized in the local repository?

> They can be local or on the server. We may get to them later in 
  the semester. Let's get confident with the basics, first.

When should I fork vs create a branch of a repository?

> You may not have write access to a repository, so you would fork it rather than branching.

> You may want to evolve a different project in parallel to the main project, so you would fork it.

> There are also some development practices that recommend one over the other.

Can you explain the differences between merging and rebasing? In
what scenarios should we use each?

> Let's wait until we're a bit more comfortable with Git before
  considering that issue. For now, we'll just use merging.

### VSCode

What do you mean when you say VSCode is "almost open-source software?"

> My understanding is that Microsoft has an open version and a
  closed version that share code.

### Java

What’s the purpose of declaring packages in a file?

> It helps organize larger collections of code. It helps with protection 
  (and ecnapsulation). And it helps us disambiguate when multiple classes 
  have the same name.

What options do we have beyond `public` for protection levels?

> There are four options: public, protected, private, and nothing 
  (which is called "package protection")

> `public`: Any class can use the protected thing. (We generally avoid
  `public` for fields.)

> `private`: As far from public as we can get. Only other methods in
  the class can access the thing. (Many people use this by 
  default for fields.)

> package (aka "don't write anything"): A step up from private. Only 
  methods in classes in the same package can access the thing.

> `protected`: Another step up from package. Subclasses can also
  access the thing.

When you say "thing" in the above, what do you mean?

> You can use these modifiers for classes, fields, methods, constructors,
  constants, and something I'm probably forgetting.

### Administrative

Do we get points off on the Mini-projects if we make multiple classes?

> No. I'd hope that you'd decompose your work appropriately. In
  object-oriented programming, that often mean multiple classes.

Should we submit double-dagger problems on a "Questions on the readings" day?

> Nope. "Questions on the readings" mean the double-dagger problems are
  optional. "Readings for Class NN" means that they are required.

### Miscellaneous

How do you connect to MathLAN on your personal computer?

> Instructions at <https://mathlan.sites.grinnell.edu>.

The reading touched a bit on terminal-based editors. I haven't
encountered those before. How should I get more comfortable using
them?

> Most terminal-based editors now have a tutorial somewhere on the Interweb.
  Start with the tutorial. After that, practice.

> The simplest one to use is `nano`. It tells you the commands.

> I use `vim`, but `vim` is a weird editor. It's "modal", which means
  that you have separate modes for editing text and adding text.

> Historically, we've had students use Emacs in CSC-161. Emacs is nice
  because you can run it with a GUI or run it in a terminal, and the
  two versions are remarkably similar.

Labs
----

The person closer to the board is **_A_**. The person further from the board
is **_B_**.

You will not be submitting code. Rather, I ask you to reflect on three
important things you learned.

If you finish early (including making sure that both partners can use
GitHub), start working on [mini-project 1](../mps/mp01).
