---
title: Getting started with GitHub
summary: |
  We extend our understanding of Git to consider how we collaborate on Git repositories using GitHub.
---
As you may recall from the reading on Git, although we can use Git locally to keep track of changes to files, we most frequently use Git in connection with a Git server in order to collaborate on projects (or at least make them available to others).

In addition to the basic Git operations of adding, commiting, and deleting, when we're working with a remote repository, we also *pull* from the remote repository, *merge* simultaneous but independent changes, and *push* our changes back to the remote repository. In some cases, instead of pushing changes, we send a *pull request* to ask someone else to pull our changes.

In this reading, we'll consider some basics of working with GitHub.

Setting up a GitHub account
---------------------------

We will be working with Git through GitHub.  Hence, you will need your own account on GitHub.  I would prefer that you do these steps in advance of class.  However, if you have difficulty, you can do them at the start of class.  

Go to <https://GitHub.com/>.  Sign up for an account on the right hand side. Pick a username, email, and password then click the green “Sign up for free” button. Now you have an account on GitHub! GitHub hosts Git projects and gives you a chance to look at other people’s projects. You can collaborate with them or participate in challenges, or simply just put your own projects up on display.

**Important!**: You post much of the work you do in this class as public repositories on GitHub. If you choose a GitHub username that is clearly associated with your identity (as mine is), the work you do in class will be public. In my experience, (a) potential employers understand that you'll have some cruft in your GitHub account and (b) those employers like to be able to see what you do on GitHub. However, Grinnell College notes that you may want to keep your work pseudonomized. Hence, you may want to choose an account for this course that is less easy associated with you.

Setting up keypairs
-------------------

For improved authentication, GitHub now requires that you set up a keypair, such as the one you'd use for ssh. You should make sure to set up such a keypair on MathLAN, but you may also want to set one up on your laptop. The instructions below are for MathLAN. You can use similar instructions for Linux, macOS, and PuTTY on Windows.

1\. Log in to your terminal application.

2\. Determine whether you already have a `.ssh` directory.

    ls -ld ~/.ssh

If you lack that directory, you'll see a message like "No such file or directory". Otherwise, you likely have the directory.

3\. If you don't have a `.ssh` directory, create one.

    mkdir ~/.ssh

4\. Make sure that your `.ssh` directory is private.

    chmod 700 ~/.ssh

5\. Switch to that directory to do the remaining work.

    cd ~/.ssh

6\. Create a keypair with the `ssh-keygen` command.

    ssh-keygen -t rsa

7\. You should get a prompt for a file in which to save the key. The default is `id_rsa`. If you already have such a key, you shouldn't overwrite it. You might want to consider using something like `github`.

    Enter file in which to save the key (/home/USERNAME/.ssh/id_rsa): github

8\. You should then get a prompt for a passphrase. The passphrase provides an additional level of security. You can also use hit return for "no passphrase".

Note that you will not see anything you type when entering a passphrase, not even asterisks.

9\. You'll then get a second prompt. Enter the same passphrase.

10\. Finally, you'll get messages like the following

    Your identification has been saved in github
    Your public key has been saved in github.pub
    The key fingerprint is:
    SHA256:bJOMi6qSWAZclkiNQOqxfQR8rF+j7FtxZ3RsEXNblmw USERNAME@MACHINE.cs.grinnell.edu
    The key's randomart image is:
    +---[RSA 3072]----+
    |=o=.o        +o.+|
    |.o *.o      . +Eo|
    |o.o o.     . +.. |
    |o.+..  * .. o    |
    | + .o.+.S. o     |
    |  o .= oo.o      |
    |.+  o ..         |
    |+  . ..          |
    |o..  ..          |
    +----[SHA256]-----+

You can choose to save the fingerprint and randomart or to ignore them. In most cases, you'll never need them. (I've never used mine in spite of decades using keypairs.)

11\. You should now have files called `github` (your private key) and `github.pub` (your public key). You can check using `ls`.

    $ ls
    github	github.pub

12\. If you named your key anything other than `id_rsa`, you'll need to update the `config` file. Add the following lines. (You may not have a `config` file, in which case these will be the only lines in the file.)

    Host github.com
        HostName github.com
        identityfile ~/.ssh/github

13\. Make sure that your `config` file is private.

    chmod 600 config

14\. You are now ready to connect your keypair to GitHub. Isn't configuration fun?

Connecting your keypair to GitHub
---------------------------------

1\. Log in to GitHub.

2\. Click on your avatar in the upper-right-hand corner and then select **Settings**

3\. Click on **SSH and GPG keys** on the left.

4\. Click on **New SSH key**.

5\. Under the "Title" field, enter something like "MathLAN". 

6\. Leave the key type as "Authentication Key"

7\. Copy the contents of your `github.pub` file. (You will likely want to `cat` the file or open it with a text editor and then use the normal copy/paste techniques.)

We'll check whether this has worked in some of the subsequent sections.

Using GitHub: A walkthrough
---------------------------

There are multiple approaches to setting up a repository on GitHub. You can _fork_ an existing repository, making a copy of that repository in your account. You can set up an empty repository on GitHub and connect a local repository to that repository. Or you can create a basic repository on GitHub. In the first (fork) and last (basic repo) cases, you'll then copy the repository to your local machine. In the middle case, you'll often start with a repository on your local machine.

In this class, I will often ask you to fork a repository I've already created, particularly when we're working on labs. For mini-projects, I'll ask you to set up a local repository and then connect it to an empty GitHub repository.

### Forking a repository

If you want to be able to share changes to a repository that is not your own, you should often begin by creating a "fork" of the repository. (Also known as "forking" a repository.) When we fork a repository, we make a copy of the repository that we have control over. We can ask the original creator to accept changes in our forked version via a "pull request", and it’s up to their discretion whether or not to accept it. Therefore, the fork is a copy of the repository you want to work with/on.

1\. Find a project you would like to contribute to on GitHub.  (Alternately, find a project we've told you to fork.) If you want to try things out, you can use <https://github.com/Grinnell-CSC207/sample.)

2\. Click the button in the upper right-hand corner that says **Fork**.

3\. GitHub will fork the repository for you.

4\. Now, you have a copy of the repository that will show up under your repositories on GitHub.  You can follow the steps in the section below and clone the forked repository into your machine so that you can work on it.

5\. If you intend to interact with the main repository, you will need to create a "remote" connected to the main repository.  The remote will let you pull updates from that repository and will also allow you to send pull requests back to that repository. Note that you won't execute this command until you've cloned the repo (see below).

    git remote add *name* *uri*

You can name the remote whatever makes sense to you, but it is convention to call it "upstream".  Use the HTTP uri of the repository that you forked.

    git remote add upstream https://github.com/Grinnell-CSC207

Now the main repository will be referred to as upstream, and you can pull
updates from it to your local repository.

### Cloning a repository

*Quick notes!*

Typing `git help` into the terminal will bring up a list of the most common Git commands and a brief description of what they do.  You can also get help on a particular command with `git help *command*`.  Also, remember that you need to precede every Git command with `git`.  So, for example, to add something to a repository, you use `git add`, not just `add`.

1\. Navigate to the repository you will be cloning. It may be one you've forked. It may be one I've asked you to use. It may be one you've created. It may be one you've found on your own.

2\. Click on the **Code** button.

3\. Click on the **SSH** button. You should see something like "git@github.com:USERNAME/sample.git".

4\. Copy that string. It's easiest to use the "Copy to Clipboard" button which appears immediately to the right of that string.

5\. In your terminal, type in 

    git clone URI

substituting the text you just copied.  For example, to clone the fork you may have made, you would type

    git clone git@github.com:USERNAME/sample.git

6\. You will now have a directory on your computer whose name matches that of the repository.  Inside the directory will be all of the files in the original repository that you cloned. You can now edit, add, and/or remove files.

Note that you do not have to have your directory name match the name of the repository.  You can rename the directory.  Alternately, when you clone the repository, you can add a directory name.  

    git clone URI DIRECTORY

When you clone a repository, you can only contribute to it if you are the creator or have been declared as one of the contributors. Otherwise, the code is just there for you to play around with and not upload.

### Creating a GitHub repository from a local folder/directory

Frequently, you'll want to set up a project locally and then copy it to GitHub. Let's consider how to do so.

First, you'll need to convert your local folder into a Git (not GitHub) repository.

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

7\. At this point, you'll need to switch over to GitHub.

8\. After you log into GitHub, you should see a green button labelled **New** or **New Repository** toward the lower right-hand side of the page.  Click that button.  

9\. Give your repository a name and a brief description. For this class, you will generally make your repositories public, but you may choose to make some personal repositories private. **Do not** initialize the repository with a REAMDE. Do not add a `.gitignore` file. Do not add a license. We are creating a blank repository.

10\. Click on **Create Repository**.

11\. Ideally, you'll see a message like "Quick setup — if you’ve done this kind of thing before". Near that message, click the *SSH* button.

12\. Near the bottom of the page, you'll see an area that says **…or push an existing repository from the command line**. Copy the three lines that look something like the following and execute them in the terminal.

    git remote add origin git@github.com:Grinnell-CSC207/sample.git
    git branch -M main
    git push -u origin main

13\. Reload the page on GitHub and you should see all of your files.

### Adding files and making changes

Now that you have either created your own project or joined one,
let's begin editing.

In case that wasn't clear, step away from the reading and start editing files.

Are you done yet?  Good.  Now we're ready to look at getting your changes into both the local and Web repositories.

If you're like most programmers, you may have forgotten what files you've created or changed and what changes you've made.  Fortunately, Git provides tools to help you figure this out.

To check if there are any changes/additions to your local repository, type in `git status`.

Git will then tell you a variety of things.  It will tell you how many commits are in your local repository that haven't been pushed back to GitHub.  It will tell you what files are staged for commit.  It will tell you which files that are already in the repository have been modified but not committed.  And it will tell you which new files have been created but not yet added to the repository.

Once in a while, it will tell you that no changes whatsoever have been made.

So far, so good.  You have a list of general changes.  But what if you want to know precisely what happened to an individual file?  Git provides a way of finding that out, too.  `git diff FILENAME`.

The `git diff` command will show you the portions of a file that are changed.  Usually added lines are prefixed with a plus sign, deleted lines a prefixed with a minus sign, and a few surrounding lines appear for context.

### Adding files

To add files into the local repository they must first exist in your working directory (the folder you made and initialized).   Once they exist, you simply use the `git add` command.  `git add FILENAME`.  Some online tutorials tell you to use `git add .`.  **Do not use that command.**  It adds everything in the current directory, which is often more than you want to add.

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

## Interacting with the GitHub server (or other Git server)

### Pushing

At this point, you have changes in your local repository and you want to upload them to the primary repository.  We'll start with a repository you own.  The most basic command is `git push`.

Git will then prompt you for your username and password and upload the files.

As you become more advanced, you may want to specify the repository and branch you are using.  In that case, you write `git push repository branch`.  By default, the repository is `origin` and the branch is your current working branch.  (If you don't use branches, it's called `master`.)

*Warning!* If you are working in a repository that you share with others, they may have pushed to the repository too.  So make sure to "pull" from the repository before pushing.   (Git will probably warn you if your push will create problems, but it's better to be safe.)

### Pull requests

Pushing works fine if you own the repository.  But what if you forked a repository and want to send a request to have your changes be a part of the main code?  Recall that you are dealing with (at least) three copies of the code: the original repository (out of your control), your fork of the repository (which you control), and your clone of your fork (where you do your editing).

To inform the owners of the primary repository that you have made changes that you think they would like to include, you send what is called a "pull request".  It is difficult (and perhaps impossible) to send a pull request from the terminal; traditionally one does it through GitHub (at least for code stored on GitHub.

Since pull requests will be rare in this class, we'll leave it to you to figure out how to send one.

Once you've sent a pull request, it will be up to the owner of the main repository whether or not to accept the request.

*Note:* Just as you pulled from your repository before pushing, so should you pull from the main repository before sending a pull request.  In this case, you need to name the main repository as described above (traditionally, you name it "upstream") and then issue the following command: 

    git pull upstream master

Keeping your local repository up to date
----------------------------------------

*We've described this step a few times, but it's useful to hear it again.*

You are going to want the latest version of the main repository in your local repository, so to do this you will need to pull. If your repository was not empty to begin with, you would have had to pull from it before pushing.  Type in the following to pull your the repository you cloned.  `git pull`.

If you forked your repository before cloning and want to grab updates from the original repository, you need to name that original repository and then pull from that repository.

    git remote add upstream URI
    git pull upstream master

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
* What is forking and when would you use it?
* What is cloning and when would you use it?
* What is the normal sequence of working operations a programmer should use when dealing with a Git project?

### Exploratory Questions

* Git allows you to undo commits (rolling your code back to a previous version).  Figure out how.
* In addition to forks and clones, Git allows you to make variants of a repository using "branches".  Learn what a branch is, how to make one, and how to use branches.
  
Selected sources
----------------

* <http://git-scm.com/book/en/Getting-Started-Git-Basics>
* <http://hoth.entp.com/output/git_for_designers.html>
