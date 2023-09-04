---
title: Getting started with Git on the command line
summary: |
  In this laboratory, you will practice using Git.  You will use the command line to manage your git repositories.  (VSCode has some built-in features that make it easier to interact directly with GitHub.  However, many programmers find it much easier to use Git from the command line, and so we will do so.) In case you've forgotten what you learned in the reading, there is a list of useful commands at the end of this lab.
---

_**Note**: This lab is newly revised to work with VSCode rather than Eclipse.  Expect some infelicities._

_**Note**: In this lab, you will be configuring your account.  The partner who is not logged in will likely have to repeat this work.  Ideally, we'll have a bit of time for that at the end of class._

Preparation
-----------

a. Make sure you’ve read [the Introduction to Git reading](../readings/git.html).

b. Make sure that you've done [the Introduction to VSCode lab](../labs/vscode.html).

c. Log in and open a terminal window.

d. Create a directory to use for this lab.  I'd suggest something like
`~/CSC207/Git`.

e. Open VSCode.

Exercises
---------

### Exercise 0: Make an Account

If you haven't already done so, create a GitHub account at [https://github.com/](https://github.com/)

### Exercise 1: Prepare for ssh connections

a. Create an ssh keypair following the instructions at
   <https://mathlan.sites.grinnell.edu/ssh/fastx/2019/07/22/Public-Private-Key-Pair/>

b. Import the key to GitHub following the instructions at
   <https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account>

### Exercise 2: Configure Your MathLAN account

As you may recall, your life is easier if you do a bit of configuration before working with Git and GitHub.  If you haven't already done so, configure your account (name, email, editor).

* First, open a new terminal window.
* Next, type these commands
    * `git config --global user.name YOUR_NAME`
    * `git config --global user.email USERNAME@grinnell.edu`
* Finally, set your editor.  You can use `emacs`, `vim` (or `vim.basic`), or even `gedit` or `geany`.
    * `git config --global core.editor EDITOR`

### Exercise 3: Create a new repository on GitHub

a. Log in to your GitHub account.

b. Somewhere on the page (along the left-hand column, at the time of this writing, but it changes), there should be a button labeled "Create Repository" (although that name changes, too).  Click that button.  A dialog should appear.

c. Name your repository (e.g., `csc207-git-exercise`).  

d. Click the buttons to make it public.  

e. Do not initialize the repository with a README file.  Do not add a `.gitignore` file.  Do not add a license.  We basically want an empty repository.

f. Click "Create repository".

### Exercise 4: Setting up your project in VSCode.

a. In VSCode, open the command prompt with Ctrl-Shift-P.  

b. At the prompt, enter/select "Java: Create Java Project...".  (Have you figured out what the ellipses stand for yet?)

c. When prompted for your build tool, select "No build tools".

d. When prompted for a directory, use the directory you created in the preparation.  It should be something like `~/CSC207/Git`.

e. Enter a name for your project.  You will generally want it to match the name you chose for your respository.  In this case, it should be something like `csc207-git-exercise`.  Hit return after entering the name.

f. In terminal, verify that the new directory was created.

### Exercise 5: Connect the project to the repository

a. In terminal, cd to that new directory.  For example,

```
$ cd ~/CSC207/Git/csc207-git-exercise
```

b. Type `git init`.  That command initializes the directory as a Git repository.

c. Type `git status`.  That command will tell you the status of all the files.  Since you haven't added any files, it should say that the current directory is untracked.

d. Type `git add README.md`.  That command will add only the `README.md` file to the repository.

e. Type `git status` again.  Now, you should see that you have one file ready to be committed and two untracked directories.

f. Type `git add .vscode src` to add those two directories.

g. Type `git status` once more.  You should see that three files are now ready to be committed.

h. Type `git commit -m "Initial commit"`.  That command commits the three files.

i. Type `git branch -M main`.  That command indicates that we're working on the main branch.  (We'll explore branches later.)

j. Type `git remote add origin git@github.com:USERNAME/REPONAME.git`, substituting your own GitHub username and the name of the repo you chose earlier.  This command links your directory to your repository.

k. Type `git push -u origin main`.  This should send the files to GitHub.  When things go wrong, grab a mentor.

l. Check on GitHub to see if the files have been added.

### Exercise 6: Add some Java

In [the VSCode lab](../labs/vscode.html), you created a simple "Hello World" Java program.  Create a similar program in your new repository.  

a. Create a new class, such as `HelloWorld`.

b. Add a `main` method to the class that has the following form.

```java
  public static void main (String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println ("Hello, GitHub!");
    pen.flush();
  } // main(String[])
```

c. Run your program to make sure that it works as you'd expect.

d. Save your program.

### Exercise 7: Commit and push your code

a. You've updated the repository and so should commit the code to the repository.  You should also push it back to the main repository.  So do so now.  (That is, use the sequence of status, add, commit, and push to get the Java files into the GitHub repository.) (Note that we usually don't push immediately immediately after each commit, but it's handy to do so now.  Normally, we do a series of small commits and only push once we've reached a larger goal.)

b. Go to GitHub and see if the changes you have made are visible.  You may need to navigate a few layers deep, since VSCode makes a directory for
each portion of the package.

### Exercise 8: Making Updates on GitHub

a. Although we normally update code in our local copy of the repository, it is also possible to update code directly on GitHub.  Navigate to the Java code you just wrote and click the "Edit" button.

b. Change the output.  Then scroll to the bottom of the page, enter a commit message, and click "Commit".

### Exercise 9: Pulling updates from GitHub

a. Our primary repository is now updated.  How about our local repository?  Let's see.  Switch back to the terminal window.  Look at the file in the finder using `less`.  

b. It is unlikely that the Java code changed.  Why?  Because you haven't told Git to pull the updated version.  Do so now.

c. Once you've issued the `git pull` command, verify that the file has indeed been updated in your local copy of the repository.

d. Finally, use `git log` to see a list of changes that have been made.

### Exercise 10: Viewing changes in VSCode

a. Switch back to VSCode.

b. Open the Java code you created and edited.  Has it changed?

c. Your are likely to see a message from VSCode that your code is now out of synch, along with instructions for synching.  Follow them.

### Exercise 11: Making changes in VSCode

a. In VSCode, change the output of your program slightly (i.e., change one of the strings).  

b. Save the file.

c. In the terminal, type `git status` to determine whether or not Git saw the change.  (It should note that your file has been changed.)

d. Type `git diff` to see what the change was.  You should see your new code prefixed by plus signs, old code by minus signs, and a bit of context.

e. Commit your change, but don't push it.

### Exercise 12: Conficting Changes

You have a local change that has not been pushed.  Let's see what happens if someone else also makes a change.

a. On GitHub, update the Java file by adding another print statement.

b. Determine what happens when you try to pull the updated version.

If all goes as expected, you should get a message like the following:

```text
Auto-merging *FILE*
CONFLICT (content): Merge conflict in *FILE*
Automatic merge failed; fix conflicts and then commit the result.
```

c. Open the file in VSCode.  You are likely to see lines that look something like this

```text
<<<<<<< HEAD
        *CODE*
=======
        *OTHER CODE*
>>>>>>> 68f7b764bb0e83971245e8db7e58c330c9d9d25c
```

d. These lines show the conflict.  Fix the conflict and save the file.

e. Back in the terminal, add and commit the changed file.  Then try pulling again.  Git should now be happy.

What to submit
--------------

The lab writeup on Gradescope asks a few questions about this lab and the VSCode lab.  Answer those quesitons.

What next?
----------

If you are working with a partner, your partner should configure VSCode and Git too.  (They should create an account and set appropriate characteristics in the terminal.)

For those with extra time
-------------------------

### Extra 1: SSH Connections

You did this lab using HTTPS connections to GitHub.  HTTPS connections are easy and straightforward.  However, they also require you to type a password each time you push code back to GitHub.

GitHub also permits you to create a pair of private and public RSA keys and to use SSH connections with those keys.  In that case, you may have to type the passphrase you associated with your keys, but you won't have to enter your GitHub account info.

Figure out how to set up an SSH connection with GitHub.

### Extra 2: Shared Repositories

You'll need to do this exercise with a partner.

First, figure out how to give someone else administrative access to your repository.

Next, verify that they have administrative access by having them make a change and upload it to the repository.

Finally, figure out what happens if the two of you make changes.

## Some Useful Git Commands

```text
git config --global user.name YOUR_NAME
git config --global user.email YOUR_EMAIL
git config --global core.editor EDITOR

git help
git clone
git add
git commit
git pull
git push
```

