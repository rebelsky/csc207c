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
_Warning! This assignment is newly written for Fall 2024. There may be some infelicities._

## Introduction

In [a recent assignment](../mps/mp06), we explored the construction of mutable two-dimensional arrays, structures that we called "_games_". While we traditionally think of games as mathematical objects, the Matrix objects we created can also be used as game boards for everything from solo puzzles to multi-player games. For example, a 9x9 matrix of digits is often used for Suduko puzzles.

In this intentionally open-ended assignment, you will create a new game, implemewnting both game logic and the user interface (or user interfaces). You should feel free to implement textual UI (after all, there's a convenient mechanism to print out games). However, you may find it more rewarding to explore how to create a graphical UI.

## A sample game

The repository for this project includes a one-player sample game that does not conform to this assignment, but may give you a sense of how a solution may look. A two-player game may follow in a few days.

The game is mostly intended to show off the matrix operations (e.g., inserting and removing rows and columns). 

* Cells are either empty, contain an X, contain an O, or contain an asterisk. 
    * X's are harmful elements. 
    * O's are good elements. 
    * Asterisks are mindless actors that consume one X or O in a neighboring 
      cell according to a strange algorithm..
* Your goal is to keep as many O's as possible while removing as many X's
  as possible.

The asterisk's algorithm is to look at cells in the order given by the following grid. 

    1|6|7
    -+-+-
    5|*|4
    -+-+-
    8|3|2

That is, it looks up and left, then down and right, then directly down, etc. etc.

For example, given the following setup, it would consume the O directly below it rather than the X's to the left and right.

    +-+-+-+
    | | | |
    +-+-+-+
    |X|*|X|
    +-+-+-+
    | |O| |
    +-+-+-+

Asterisks are processed row by row, left to right (at least I think they are).

You should be able to run the program once you've added working matrix code.

```text
mvn clean compile package -q
mvn exec:java
```

You can also run the jar file if you want to use command-line parameters. For example,

```text
java -jar target/games-1.0.jar -w 10 -h 5 -s 0
```

## The assignment

This assignment has a few basic requirements:

* You must use the `Matrix<T>` interface and the `MatrixV0<T>` class from the previous assignment to represent the game board. You must also use the `set` and `get` methods from that class. (I'd also like you to consider how to use the other methods, such as inserting or removing rows.)
* You should have separate classes for the game logic and the user interface. (The sample game does not.)
* You should implement at least one additional class (e.g., for the game pieces or the game board). (The sample game does not.)

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

h. Commit that code.

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

j. Create a new package for your game (e.g., `edu.grinnell.csc207.othello`) and start working.

## Submitting your work

Make sure to update the `pom.xml` file so that it starts your game, not the sample games.

Make sure to update the `README.md` file to provide appropriate instructions for someone to run your game.

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
[ ] `mvn exec:java` starts a game (other than one of the supplied ones).
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```text
[ ] No more than fifteen errors from `mvn checkstyle:check`.
[ ] The game appears to run through to completion.
[ ] Includes at least three Java files in the game 
    [ ] The game logic
    [ ] A user interface (an ASCII UI is fine)
    [ ] Something else (the board, pieces, etc.)
```

### Exemplary / Exceeds expectations

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an M.

```text
[ ] All (or most) repeated code has been factored out into individual methods.
[ ] All or most variable names are appropriate.
[ ] No more than five errors from `mvn checkstyle:check`.
[ ] Permits configuration of the game (e.g., on the command line or 
    by prompting the user).
```

Questions and Answers
---------------------

### Big picture

### Game choice/design

**Do we have to invent our own game or can we use an existing game like Othello or Sudoku?**

> You may do either.

**Do we have to use matrices as the underlying implementation of our board?**

> Yes. However, you don't have to rely on all the methods. Few games allow you to insert/remove rows/cols.

**Can our game suck as much as yours does?**

> Yes. However, remember that this could be something that you show to prospective employers. Sucky games are not all that interesting.

**Can we implement a card or casino game?**

> Most card games don't use a matrix/grid, so that wouldn't follow the requirement that you use a matrix as the game board. Card games are also a bit more complex because this will likely be a "complete knowledge" situation (that is, everyone sees all the pieces). However, if you can identify a card game that uses a grid, you can feel free to implement it. 

**Can we implement a "zero-player" game, like Conway's game of life?**

> Sure. ALife is an okay approach.

**Can we implement chess or checkers?**

> Sure.

**Can we implement something like Wordle, using cells to show letters?**

> I suppose it meets the requirements.

### GUIs

**Do you have suggestions on making a GUI?**

> Nope. It's been about ten years since I wrote a GUI in Java.

**To what extent can we incorporate code that we find as long as we cite it (i.e. for graphics)?**

> As long as you cite it? As much as you want.

**A demo of using some native java library, like swing, to animate some object would be insightful.**

> I'm sure it would. Unfortunately, I don't have time for that. That's why I've said that an ASCII interface will be fine.

### Miscellaneous

**Who is our partner?**

> Your partner for today's class is your assignment partner.

**How long should this take?**

> My goal is that you should be able to write an E-level project in two-hours per person. That assumes a relatively simple UI and relatively straightforward game logic. You may want to shoot higher.

**How were you able to represent a 8x8 grid by a simple number? There are 64 spots and each spot could have 4 possibilities ( Nothing, X, O, *).**

> It's the number I use to initialize the random number generator. Once the RNG is initialized, it produces a predictable sequence of outputs. I generate a random number for each square and, depending on the value, decide on what to put in the square.

**If there is a game we want to recreate that involves expanding the dimensions of the board (like the grid that we would display to users) to no limit, would it be harmful at a certain point to have the board expand without any set limit?**

> I think it should be okay to keep expanding the board. I suppose we'll find out if we're not.

**If we are making a multiplayer game where players have 'hands' that should be kept hidden from other players, is there a good way to represent this in Java with what we have used thus far (Text IO, Windowed environment)?**

> I don't know of a good way to keep things hidden. This may have to be a "complete information" game like chess or checkers.

**What resources would you recommend us to go over to create the GUI for this assignment? Would you say it's something we can learn from the scratch today and be able to implement a decent one in a few days?**

> Yes, I think you can learn how to build a simple grid-base GUI in a few hours. Unfortunately, I don't have a good recommendation. I might look and see what's going on in the AAC code. But I'd start with text.

**How do you make sure you've thought of all the edge cases for your own code?**

> Practice. Look at common edge cases.

**Are there tips for counting lines of four efficiently?**

> I don't have one, and it may not be worth your time even if there is one, since it's likely to be non-trivial. Start with the naive code and see where you go from there.

**How should I check if the game is a draw?**

> It depends on the game rules. If neither player can play, it's an obvious draw.

**Can the game's difficulty (choose between easy, medium or hard) be considered a configuration for the E requirement?**

> Yes.

Citations
---------

This assignment is loosely based on [an assignment from CSC-152 1998Sp](https://rebelsky.cs.grinnell.edu/Courses/CS152/98S/Assignments/assignment.03.html).
