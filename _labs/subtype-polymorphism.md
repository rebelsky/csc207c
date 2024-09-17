---
title: Subtype polymorphism in Java
repo: <https://github.com/Grinnell-CSC207/lab-subtype-polymorphism-maven>
summary: |
  We explore issues of polymorphism in Java.
---
_**Warning!** This lab was significantly updated in Fall 2024. There may be infelicities. Please let SamR know if you encounter any._

Preparation
-----------

a. Fork and clone the specified repository: {{ page.repo }}

Remember: When cloning, use the SSH link, not the HTTPS link.

b. Import the cloned repository into VSCode.

c. Make sure to update the `README.md` and `.java` files with your names.

d. If you haven't done so already, grab one of the portable whiteboards, a whiteboard marker, and an eraser.

Exercises
---------

### Exercise 1: Simple stores

_Driver: **A**_

As you may recall, in [the reading](../readings/subtype-polymorphism), we explored a simple model of stores in which we have a `Purchase` interface and a variety of mechanisms for implementing that interface.

a. Skim the classes `edu.grinnell.csc207.experiments.Store`, `edu.grinnell.csc207.store.StoreUtils`, and `edu.grinnell.csc207.store.Item` and predict the output of running the `Store` experiment. (You might, for example, write the expected output down on one of the portable whiteboards.)

b. Check your answer experimentally.

```
$ mvn compile -q
$ java -cp target/classes edu.grinnell.csc207.experiments.Store
```

c. Add another item to the order in the `Store` experiment. (Please use a positive price.) Then recompile and re-run that experiment.

d. Right now, our order consists only of singleton items. Yet we are trying to take advantage of polymorphism. Let's add a different kind of entry to our order.

What do you expect to happen if we add the following line to the array of purchases?

```java
          new BulkItem("saffron", "yellow", "gram", 1111, 2),
```

e. Check your answer experimentally.

### Exercise 2: Adding a new type of purchase

_Driver: **B**_

As you may recall, we claimed that interface permit us to "program for the future".  Let's explore what happens if we add another class to our project.

a. Add the following class to your project.

```
package edu.grinnell.csc207.store;

/**
 * Items purchased in multiples.
 */
public class Multiple implements Purchase {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The name of the item.
   */
  String name;

  /**
   * A description of the item.
   */
  String description;

  /**
   * The cost per item (in cents).
   */
  int costPerItem;

  /**
   * The number of items.
   */
  int items;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new bunch of items.
   *
   * @param itemName
   *   The name of the item.
   *
   * @param itemDescription
   *   A desciption of the item.
   *
   * @param itemCost
   *   The cost per item.
   *
   * @param numItems
   *   The number of items
   */
  public Multiple(String itemName, String itemDescription, int itemCost,
      int numItems) {
    this.name = itemName;
    this.description = itemDescription;
    this.costPerItem = itemCost;
    this.items = numItems;
  } // Multiple(String, String, int)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine the cost of this purchase.
   *
   * @return the cost in cents
   */
  public int cost() {
    return this.costPerItem * this.items;
  } // cost()

  /**
   * Convert to a string.
   *
   * @return the multiple as a string.
   */
  public String toString() {
    return String.format("%d %s (at $%s each)",
        this.items,
        this.items == 1 ? this.name : this.name + "s",
        StoreUtils.centsToDollars(this.costPerItem));
  } // toString()
} // class Multiple
```

b. Make sure that it compiles successfully.

```
mvn compile
```

c. Add `import edu.grinnell.csc207.store.Multiple` to the `Store` experiment.

d. Make sure that the updated code compiles successfully.

e. Add 63 nails at 2 cents per nail to the array of purchases.

f. Confirm that this new class has been incorporated in the project. Your output should look something like the following.

```
hammer (at $8.99) ....................................  8.99
penny candy (at $0.01) ...............................  0.01
coffee (at $0.25) ....................................  0.25
saffron (2 ounces at $11.11 per ounce) ............... 22.22
63 nails (at $0.02 each) .............................  1.26

TOTAL:                                                $32.73
```

### Exercise 3: Basic and boxed AsciiBlocks

_Driver: **B**_

Now let's move on to the AsciiBlocks from the reading. You'll find these in the `edu.grinnell.csc207.blocks` package (stored in `src/main/java/edu/grinnell/csc207/blocks`).

a. Skim through `Blocks.java` in the `experiments` directory and predict the output. (You may want to sketch it on your whiteboard.)

b. Check your answer experimentally.

```
mvn compile -q
java -cp target/classes edu.grinnell.csc207.experiments.Blocks
```

c. In the reading, we claimed that polymorphism means that we can box anything, even another `Boxed`. Verify that claim by adding code to put a box around `b3` or `b4` and call the result `b5`. Also add code to print out the newly created `b5`. Then compile and run your code.

d. Let's keep nesting. Put a block around `b5` and call the result `b6`. Print it out. Etc.

e. We also have an empty block class that creates a 0x0 block. What do you expect to get when we create and try to print one out?

```
    separator(pen);
    pen.printf("b7 = new Empty()\n\n");
    AsciiBlock b7 = new Empty();
    AsciiBlock.print(pen, b7);
```

f. Check your answer experimentally.

```
mvn compile -q
java -cp target/classes edu.grinnell.csc207.experiments.Blocks
```

g. What do you expect to get as output if we put a box around the empty block? Sketch your answer on your whiteboard.

```
    separator(pen);
    pen.printf("b8 = new Boxed(b8)\n\n");
    AsciiBlock b8 = new Boxed(b7);
    AsciiBlock.print(pen, b8);
```

h. Check your answer experimentally.

i. What do you expect to get as output if we put a box around `b8`? Sketch your answer on your whiteboard.

```
    separator(pen);
    pen.printf("b9 = new Boxed(b8)\n\n");
    AsciiBlock b9 = new Boxed(b8);
    AsciiBlock.print(pen, b9);
```

### Exercise 4: Alternate boxes

_Driver: **A**_

Currently, we surround a box with horizontal, vertical, and diagonal lines. But what if we want to surround a box with a particular character, such as an asterisk or even a letter of the alphabet.

For example, if we surround the line "A" with asterisks, we should get

```
***
*A*
***
```

If we surround the line "A" with spaces and then asterisks, we should get

```
*****
*   *
* A *
*   *
*****
```

If we surround the line "A" with "B" and then surround the result with "C", we should get

```
CCCCC
CBBBC
CBABC
CBBBC
CCCCC
```

a. Implement the `Surrounded` class. (You'll find template code already there; you just need to implement the three main methods.)

b. Add a few experiments to `Blocks` to verify that your class works. You may want to consider mixing `Boxed` and `Surrounded` to see what happens. You may also want to try your `Surrounded` with the empty block. Here are some simplified versions of each of those experiments.

```
  AsciiBlock.print(new Surrounded(new Line("A"), '*'));
  AsciiBlock.print(new Surrounded(new Surrounded(new Line("A"), ' ')), '*');
  AsciiBlock.print(new Surrounded(new Surrounded(new Line("A"), 'B')), 'C');
```

### Exercise 5: Horizontally composing text, take one

_Driver: **A**_

Suppose we want to create a new class that we use to horizontally compose two blocks, top aligning the two bocks. It will have fields `left` (for the left block) and `right` (for the right block).

For example, `new HorizontalCompositionTop(new Rectangle('X', 3, 5), new Rectangle('O', 4, 2))` should create the following.

```
XXXOOOO
XXXOOOO
XXX
XXX
XXX
```

a. Write code for the `width` method of `HorizontalCompositionTop`. The result should depend on `left.width()` and `right.width()`.

b. Write code for the `height` method of `HorizontalCompositionTop`. The result should depend on `left.height()` and `right.height()`.

c. Write code for the `row` method of `HorizontalCompositionTop`. The result will likely depend on `left.row(i)`, `right.row(i)`, and perhaps other aspects of the two.

d. Look at the code of `HorizontalCompositionTop` and see how the solution compares to yours. Make notes of any differences or concerns.

e. Add the following to `Blocks` to check the code and verify that the output looks as you'd expect.

```
    AsciiBlock exes = new Rectangle('X', 3, 5);
    AsciiBlock ohs = new Rectangle('O', 4, 2);

    separator(pen);
    AsciiBlock.print(new HorizontalCompositionTop(exes, ohs));
    separator(pen);
    AsciiBlock.print(new HorizontalCompositionTop(ohs, exes));
    separator(pen);
    AsciiBlock.print(new HorizontalCompositionTop(exes, exes));
```

f. There's a bug in `HorizontalCompositionTop`. Spend no more than five minutes trying to identify it.

### Exercise 6: Horizontal Composition, revisited

_Driver: **B**_

Here are some experiments that might help you identify the bug (or at least the intentional bug) in `HorizontalCompositionTop`.

a. Arguably, top-aligned horizontal composition should be associative. In particular, both of the following should be the same.

```
    AsciiBlock comp1 =
      new HorizontalCompositionTop(exes, new HorizontalCompositionTop(ohs, exes));
    AsciiBlock comp2 =
      new HorizontalCompositionTop(new HorizontalCompositionTop(exes, ohs), exes);
```

Are they?

b. It can also be helpful to box blocks to see what's happening. Let's try that.

```
    AsciiBlock boxedcomp = new Boxed(new HorizontalCompositionTop(exes, ohs));
```

c. Fix the error in `HorizontalCompositionTop`.

### Exercise 7: Center-aligned horizontal composition, part one

_Driver: **A**_

a. How would your `row` method differ if we wanted the horizontal composition of two blocks to be vertically centered, something like the following?

```
LEFT
LEFTRIGHT
LEFTRIGHT
LEFTRIGHT
LEFT
```

or

```
    RIGHT
LEFTRIGHT
LEFTRIGHT
LEFTRIGHT
    RIGHT
```

For this part of the exercise, you may assume that the number of rows in `left` and `right` differ by an even number.

b. Update the `row` method in `HorizontalComputationCenter` to incorporate your algorithm.

c. Check your algorithm with these examples.

```
    AsciiBlock threeLeft = new Rectangle('L', 4, 3);
    AsciiBlock fiveLeft = new Rectangle('L', 4, 5);
    AsciiBlock threeRight = new Rectangle('R', 5, 3);
    AsciiBlock fiveRight = new Rectangle('R', 5, 5);

    AsciiBlock.print(pen, new HorizontalCompositionCenter(fiveLeft, threeRight));
    AsciiBlock.print(pen, new HorizontalCompositionCenter(threeLeft, fiveRight));
    AsciiBlock.print(pen, new HorizontalCompositionCenter(fiveLeft, fiveRight));
    AsciiBlock.print(pen, 
        new Boxed(new HorizontalCompositionCenter(fiveLeft, threeRight)));
```

### Exercise 8: Center-aligned horizontal composition, extended


_Driver: **B**_

You might find yourself asking "What should we do if the left and right blocks differ by an odd number of rows?" In that case, we can't quite center-align the two blocks. As a matter of principle, we'll prioritize having the smaller block higher rather than lower, as in the following.

```text
LEFTRIGHT
LEFT
```

```text
    RIGHT
LEFTRIGHT
    RIGHT
    RIGHT
```

```text
LEFTRIGHT
LEFTRIGHT
LEFTRIGHT
    RIGHT
```

```
LEFT
LEFTRIGHT
LEFTRIGHT
LEFT
LEFT
```

a. Determine what your code currently does with those kinds of examples.

b. If your code does not behave as expected, correct it so that it does.


### Exercise 9: Left-aligned vertical composition

_Driver: **B**_

Guess what? We're almost done. All that is left is to vertically compose two blocks. We'll left-align the composition because that seems easiest. Here's a start.

```
/**
 * The left-assigned vertical composition of two blocks.
 */
public class VerticalCompositionLeft implements AsciiBlock {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The block on the top.
   */
  AsciiBlock above;

  /**
   * The block on the bottom.
   */
  AsciiBlock below;

} // class VerticalCompositionLeft
```

a. What should the width of the vertical composition be? You should be able to express this in terms of `above.width()` and `below.width()`.

b. What should the height of the vertical composition be? You should be able to express this in terms of `above.height()` and `below.height()`.

c. What should the `row` method look like? You should be able to express this in terms of `above.row()`, `below.row()`, and `above.height()`.

d. Compare your answers to those in `VerticalCompositionLeft`.

Submitting
----------

a. Push your project to GitHub.

b. Make sure to share the repo with your partner.

c. Fill in the questions on the lab writeup.

For those with extra time
-------------------------

### Extra 1: More composition classes

You still have `HorizontalCompositionBottom`, `VerticalCompositionCenter`,
and `VerticalCompositionRight` left to implement. So implement them.

### Extra 2: Grids

Write a new class `Grid(AsciiBlock, width, height)`, that makes a `width`-by-`height` grid of the given block. For example, `new Grid(new Line("Hello"), 3, 4)` should give you the block

```text
HelloHelloHello
HelloHelloHello
HelloHelloHello
HelloHelloHello
```

