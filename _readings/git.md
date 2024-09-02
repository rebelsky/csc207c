---
title: Getting started with Git
summary: |
  We explore the motivation for source code management systems, grounding
  our understanding in the Git source code management system.
---
A short introduction to source code management
----------------------------------------------

Large projects involve lots of files, people, and updates. Source code management (SCM) systems, or version control systems (VCS), were created to tame the chaos that usually ensues.  SCMs let you keep track of old versions of files, share files them with others, create *branches* where you can do experimental development, keep track of issues to be dealt with, and much much more.

There are many source code management systems.  Their capabilities and approaches have varied over the years.  For example, RCS (Revision Control System), the first version control system that I used, assumed that only one person would work on a file at a time.  CVS (Concurrent Versioning System) added capabilities for multiple people to work simultaneously on the same file.  But CVS wasn't great for Web-based collaboration, so Subversion (sometimes abbreviated as SVN) came along.  Git (no acronym, at least as far as I know), like Subversion, supports simultaneous edits by people spread around the Web, but also distributes the repository to multiple machines.  These days, there are lots of other options too, such as Mercurial (which I will admit to not knowing).  In my experience, the "hot" or "preferred" version control system changes every five years or so.

A quick introduction to Git
---------------------------

For this course, we will be using Git because it is one of the most common source code management systems. It is also the preferred SCM in our department. I use it as part of my daily practice, as do most of the faculty in the department.

Git is powerful, popular, and provides some interesting perspectives on source code management.  Git is also relatively easy to use, although it may take awhile to understand some of its approaches.  One complexity of Git is that there at least three different ways to copy a repository.

We will also rely on [GitHub.com](http://GitHub.com), a popular Git hosting site, which provides a place to store our Git repositories.  If you plan a career in software development, developing a presence on GitHub can be an important place to start.  GitHub gives folks a chance not only to look at your portfolios, but also to observe your work habits.

In Git, many projects have a central repository where all of the official files for a project are stored, although lots of people can have copies of that repository.  A few people (sometimes as few as one) control this repository.  They are the only ones with the permission to make changes to files (or to approve changes that others propose).  But anyone can propose changes.

In most cases, if you're not happy with what changes people allow in a repository, you can make your own copy of the repository on GitHub (or other Git hosting site), and you then control that repository, including the abillty to make changes to files that can then be shared with others.  This kind of copy of a repository is called a *fork*.

More frequently, though, people simply work with a copy of the main repository, proposing changes for others when appropriate.  To start, anyone working in the project can "clone" the latest copy of files from the main repository to work with, creating their own copy on a local machine.  On the local machine, a person can open a file, edit it, and then "add" it to the staging area which holds all of the changes that person makes.  Once a person made a set of related changes that they are comfortable with, they "commit" it to their local repository - adding a note about the changes.

At some point, someone working on a project is comfortable enough with their changes that they want to share them with a larger group.  (Note that you should generally not share with the larger group unless your code compiles and, ideally, passes at least as many tests as the previous version.)  Administrators can "push" these changes back to the main repository.  Other contributors send a "pull request" which the administrators may or may not accept.

Once changes have been propagated back to the main repository, collaborators can "pull" those changes back into their local copies.

So, a typical approach to working with a project that is under Git is something like the following.  First, you clone the repository onto your local machine.  You usually only need to do that once.  In some other situations, you start by forking the repository on GitHub and then cloning your fork.  (See, I said that there's a lot of copying that can go on.)

At the start of each work session, you pull the latest changes from the primary repository.  After all, it doesn't make much sense to work with old code - you might end up redoing changes that someone else made.  (Sometimes when you pull from the main repository, you'll get conflicts with changes you've made but have not sent back to the main repository.  In such cases, you'll need to "resolve" the conflicts and them commit them back to your local copy.)

You spend some time working on the code.  At some point, you're satisfied with a bit of the code.  At that point, you commit your changes to your repository.  Different projects and different people seem to choose different levels of commits.  In Git, commits are cheap, so I generally try to commit whenever I've made changes that fit into a single logical unit.  (I also do this because, while it's easy to undo one or more commits, it's a pain to undo parts of a single commit.)

Finally, at some point you are ready to share your commits with the rest of your group.  (Ideally, you'd have some changes to share at the end of each programming session, but that's rarely the case.)  At that point, you do another pull (just in case someone else has made changes since your last pull), resolve any conflicts, and then send the changes back to the main repository, either via a push or a pull request.

Of course, professional programmers have a much deeper process.  Most work with branches (alternate threads of development), so that folks can independently try different approaches to problems or otherwise attack issues that may require modifying multiple files in different ways.

You may have noticed that we used a lot of terms here.  You may find it helpful to review some of them.

* *clone*: Copy a repository from Git to your computer.
* *add*: Add a file to your local repository.  For a file already in your local repository, `git add FILENAME` adds the file to the list of things to commit.
* *commit*: Save and describe changes.  (These changes are only saved in your local copy.)

The remaining terms are for when you're working with a remote server, such as GitHub.

* *pull*: Grab the latest version of files from the repository.  (In some SCMs, this is called "update".)
* *merge*: Combine the changes made in another branch to your branch.  Afterwards, you will usually need to add the updated file back to the list of things to be committed.
* *push*: Send all of your recent commits back to a repository that you administer.
* Send a *pull request*: Request that the administrator accept your recent commits into the main repository.

Configuring your Linux account
------------------------------

You will find it helpful to configure your Linux account for GitHub. Some configuration steps are useful whether you work locally or communicate with a server. Others are particularly useful when you work with a server.

You will only need to do this once. You can do this now, or you you will have the the opportunity to do this in the upcoming lab.

1\. Open a terminal window.

2\. Type the following command to configure the name used when you commit code.  (Don't type the prompt; substitute your name.)  

    git config --global user.name YOUR_NAME

Of courwse, you should use your name rather than YOUR_NAME.

This command will set up the name that accompanies your commits.

4\. Type the following command to set up your email. Ideally, you'll use the same email address when you sign up for GitHub.

    git config --global user.email USERNAME@grinnell.edu

5\. tach time you commit a change, Git will ask you to enter a commit message.  By default, Git uses the editor Vim.   While I like Vim, I admit that many people find it puzzling.  If you want to change the editor you use (e.g., to Emacs), type the following.

    git config --global core.editor PATH_TO_EDITOR

If you are comfortable with Emacs in a terminal window, you might use

    git config --global core.editor emacs -nw

If you are comfortable with vim, you ight use

    git config --global core.editor vim

If you don't know any editors that work in the terminal, don't reconfigure and try to avoid commands that require an editor.

Using Git: A walkthrough
------------------------

You can convert any folder into a Git (not GitHub) repository.

1\. cd to the folder (often the top-level directory of your project).

2\. Type the following

    git init

You will see a message like

    Initialized empty Git repository in /home/USERNAME/FOLDER/.git/

3\. If you don't have one already, create a file called `README.md` at the top level of the folder/directory. This "README file" provides some basic information about the project. The `md` suffix means that it's a Markdown file. Here's a simple one.

    # My Awesome Project

    This is my awesome project. You should add up the awe.

4\. Type

    git add README.md

This command tells Git that you are adding the README file to the list of files that you plan to commit.

5\. Often, we don't want all of the files in a folder in our project. For example, if we're building a project in C, we don't want the `.o` files in the project. Hence, we should explicitly tell Git which files to include. You've just done so for the README file. Do the same for any other files. (I recommend you do this one by one.)

    git add FILENAME

6\. Type the following

    git commit -m "Initial commit"

This command tells Git that you are committed to including the files you just added. (You can undo an `add` before the commit if you mistakenly add a file you didn't mean to.)

### Adding files and making changes

Now that you have either created your own project.
let's begin editing.

In case that wasn't clear, step away from the reading and start editing files.

Are you done yet?  Good.  Now we're ready to look at getting your changes into both the local repository.

If you're like most programmers, you may have forgotten what files you've created or changed and what changes you've made.  Fortunately, Git provides tools to help you figure this out.

To check if there are any changes/additions to your local repository, type in 

    git status

Git will then tell you a variety of things.  It will tell you how many commits are in your local repository that haven't been pushed back to GitHub.  It will tell you what files are staged for commit.  It will tell you which files that are already in the repository have been modified but not committed.  And it will tell you which new files have been created but not yet added to the repository.

Once in a while, it will tell you that no changes whatsoever have been made.

So far, so good.  You have a list of general changes.  But what if you want to know precisely what happened to an individual file?  Git provides a way of finding that out, too.  

    git diff FILENAME

The `git diff` command will show you the portions of a file that are changed.  Usually added lines are prefixed with a plus sign, deleted lines a prefixed with a minus sign, and a few surrounding lines appear for context.

### Git commands

Typing `git help` into the terminal will bring up a list of the most common Git commands and a brief description of what they do.  You can also get help on a particular command with `git help *command*`.  Also, remember that you need to precede every Git command with `git`.  So, for example, to add something to a repository, you use `git add`, not just `add`.

The Interweb can also be your friend. But it's the Interweb, so tread carefully. Consider the validity of your source. (It's unlikely that you'll end up doing something all that unsafe, but you might do something incorrect that will be hard to undo.)

### Adding files

To add files into the local repository they must first exist in your working directory (the folder you made and initialized).   Once they exist, you simply use the `git add` command.  

    git add FILENAME

Some online tutorials tell you to use `git add .`.  **Do not use that command.**  It adds everything in the current directory, which is often more than you want to add.

### Editing files

Editing files under Git is like editing any file.  Open the file using some type of editor (emacs, vim, gedit, etc) make your changes, and then save.

### Adding/staging changes

You may recall that `git status` tells you not just about modified files and new files, but also files that are "staged" for the next commit.  You know how to stage a new file: Just use `git add`.  How do you stage a modified file?  Exactly the same way, with `git add *filename*`.

Staging puts the files into the staging area, which holds all of the changes made in the working directory that will be committed to the local repository. This distinction is important because only the files that you stage will be the ones that go into the local directory when you commit changes, and only the changes in the local repository will be added to the main repository when you push. It is good practice to only "add" what is necessary, nothing more (no temporary files, no executable files that can be generated, etc). If you do, the repository will only get cluttered, and if you were planning on sending a pull request, adding more than necessary will not be in your favor.  (The student who wrote this paragraph discovered this after Sam criticized zir repeatedly for making his life more difficult.)

### Deleting files

Deleting files from a repository is a bit like deleting files in any Unix system.  The one difference is that you have to tell Git about it.  So, instead of `rm FILE`, you write `git rm FILE`.

Deletion is automatically staged.  (It just seems a bit to contradictory to use `git add` to stage a deletion.) But you still have to use `git commit` to confirm the deletion.

### Committing

At this point, you are ready to incorporate some or all of your changes into the repository.  First, make your that you add the changed or new files.  Next, use Git's commit command, `git commit`.

Git will open the editor you specified above and you can enter information about the change.  Custom is to use present tense in a somewhat imperative mode: "Fix bug 23a" or "Add capability to print".  Enter something that will be useful to you and to others who may see your code, then save and exit the editor.   Congratulations, you have successfully committed changes to your local repository!

Note: To avoid having any text editor pop up, use the -m flag to enter a message directly in the terminal.  For example, `git commit -m "Fix bug 32b"`.  Notice the quotation marks that surround the message.

Wrapping up
-----------

### Important Terms

* Push/pull
* Commit
* Clone
* Fork
* Version Control
* GitHub
* Repository
* Stage

### Review Questions

* Why is Git useful?

### Double-dagger questions (‡)

Pick one of the two following questions

* Git allows you to undo commits (rolling your code back to a previous version).  Figure out how.
* In addition to forks and clones, Git allows you to make variants of a repository using "branches".  Learn what a branch is, how to make one, and how to use branches.
  
Selected sources
----------------

* <http://git-scm.com/book/en/Getting-Started-Git-Basics>
* <http://hoth.entp.com/output/git_for_designers.html>
