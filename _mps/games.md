---
title: Mini-Project 7
subtitle: Abstract games
repo: <https://github.com/Grinnell-CSC207/mp-games-maven>
summary: |
  We build a more complex ADT. Along the way, we continue
  to explore multiple ways to implement such data structures.
collaboration: |
  Students will work in assigned teams on this project. Teams may consult 
  other students in the class as you develop your solution.  If you
  receive help from anyone, make sure to cite them in your responses.
link: true
---
_Warning! This assignment is in a very early draft form!_

## Introduction

In [a recent assignment](../mps/mp06), we explored the construction of mutable two-dimensional arrays, structures that we called "_games_". While we traditionally think of games as mathematical objects, the Matrix objects we created can also be used as game boards for everything from solo puzzles to multi-player games. For example, a 9x9 matrix of digits is often used for Suduko puzzles.

In this intentionally open-ended assignment, you will create a new game, implemewnting both game logic and the user interface (or user interfaces). You should feel free to implement textual UI (after all, there's a convenient mechanism to print out games). However, you may find it more rewarding to explore how to create a graphical UI.

## Sample games

The repository for this project includes two sample games, a one-player game (perhaps a "puzzle") and a two-player game that can also be played by multiple players.

...

## The assignment

This assignment has a few basic requirements:

* You must use the `Matrix<T>` class from the previous assignment to represent the game board. You must also use the `set` and `get` methods from that class. (I'd also like you to consider how to use the other methods, such as inserting or removing rows.)
* You should have separate classes for the game logic and the user interface.
* You should implement at least one additional class (e.g., for the game pieces).

## Getting ready

a. Fork the repository at {{ page.repo }}.

b. Clone that repository.

```text
cd ~/CSC207/MPs                 # Or the directory of your choice
git clone git@github.com:USERNAME/mp-games-maven.git
```

c. Open the project in VSCode.

d. Update the `README.md` appropriately.

e. Push the updated `README` to GitHub.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-games-maven
git add README.md
git status
git commit -m "Update README to include my team members."
git pull
git push
```

f. Add an upstream repository just in case I make changes.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-games-maven
git remote add upstream https://github.com/Grinnell-CSC207/mp-games-maven
```

In the future, you can grab changes using the following.

```text
git fetch upstream
git merge upstream/main
```

You can also just click the **Sync Fork** button on your GitHub page for the fork.

g. Add your matrices code in `src/main/java/edu/grinnell/csc207/util/`.

h. Commit that codee.

```text
git add src/main/java/edu/grinnell/csc207/util
git status
git commit -m "Add Matrix code from NAME's MP6."
git pull
git push
```

i. Make sure that you can run the first sample game from the command line.

```
mvn exec:java
```

j. Update the `pom.xml` file to replace the game.

```
```

## Submitting your work

Make sure to update the `pom.xml` file so that it starts your game, not the sample games.

Please submit all of your work on the project to Gradescope by using the GitHub submission mechanism. 

## Approximate rubric

_I am likely to revisit this rubric._

### Redo or above

Submissions that fail to meet any of these requirements will get an I.

```text
[ ] Each class has an introductory Javadoc comment that indicates the author and purpose.
[ ] Includes a `README.md` file that contains the appropriate information
    (authors, purpose, link to GitHub repo, acknowledgements if appropriate).
[ ] All files compile correctly.
[ ] `mvn exec:java` starts a game (other than the supplied ones).
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```text
[ ] No more than fifteen errors from `mvn checkstyle:check`.
[ ] The game appears to run through to completion.
```

### Exemplary / Exceeds expectations

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an M.

```text
[ ] All (or most) repeated code has been factored out into individual methods.
[ ] All or most variable names are appropriate.
[ ] No more than five errors from `mvn checkstyle:check`.
```

Questions and Answers
---------------------

Citations
---------

This assignment is loosely based on [an assignment from CSC-152 1998Sp](https://rebelsky.cs.grinnell.edu/Courses/CS152/98S/Assignments/assignment.03.html).
