---
title: Mini-Project 3
subtitle: Exploring blocks of ASCII
repo: <https://github.com/Grinnell-CSC207/mp-blocks-maven>
summary: |
  We practice with subtype polymorphism by further extending the
  text layout example from the lab on subtype polymorphism.
collaboration: |
  Students should work in pairs on this project.  You may also
  consult other students in the class as you develop your solution.
  If you receive help from anyone, make sure to cite them in your
  responses.
link: true
---
In this mini-project, you will continue our AsciiBlock examples.

## Preparation

a\. Fork and clone the repository at {{ page.repo }}.

b\. `Line` and `Rect` (formerly `Rectangle`) now permit you to mutate the text blocks. Read through those two classes to see that you understand the differences.

c\. One of the challenges of mutable blocks is that the blocks that contain them must also be mutable. Verify that `Boxed` continues to work correctly as we mutate blocks. (You can do so by reading the experiments and checking the output.)

d\. If you haven't done so yet, fill in the pre-assessment for this project on Gradescope.

## Assignment

### Part 1: Surrounding blocks

The assignment repository does not include a working `Surrounded`. Please finish the implementation and make sure that works as we change the things we surround.

### Part 2: Grids

Implement a more general version of `Rectangle` called `Grid`. Instead of an `n`-by-`m` grid of characters, `Grid` has an `n`-by-`m` grid of `AsciiBlock` objects. That is, it consists of `m` rows of `n` objects each.

For example, `new Grid(new Line("Hello"), 3, 4)` should give

```text
HelloHelloHello
HelloHelloHello
HelloHelloHello
HelloHelloHello
```

Similarly, `new Grid(new Boxed(new Empty()), 3, 2)` should give

```text
/\/\/\
\/\/\/
/\/\/\
\/\/\/
```

As you might expect, `Grid` should adapt to changes in the underlying block.

### Part 3: Horizontal Composition

We have replaced `HorizontalCompositionTop` and `HorizontalCompositionCenter` with a more general (and more concise) `HComp`. In the new version, one can compose as many or as few objects as they'd like. In addition, they specify the alignment as part of the constructor, using `VAlignment.TOP`, `VAlignment.CENTER`, or `VAlignment.BOTTOM`.

For example, suppose `a` is a 5x2 rectangle of `A`, `b` is a 3x3 rectangle of `B`, and `c` is a 2x6 rectangle of `C`.

`new HComp(VAlignment.TOP, new AsciiBlock[] {a, b, c})` should give us

```text
AAAAABBBCC
AAAAABBBCC
     BBBCC
        CC
        CC
        CC
```

`new HComp(VAlignment.CENTER, new AsciiBlock[] {a, b, c})` should give us

```text
        CC
     BBBCC
AAAAABBBCC
AAAAABBBCC
        CC
        CC
```

Note that when we could not perfectly center a block, we prioritized being higher than lower.

`new HComp(VAlignment.BOTTOM, new AsciiBlock[] {a, b, c})` should give us

```text
        CC
        CC
        CC
     BBBCC
AAAAABBBCC
AAAAABBBCC
```

Implement `HComp`. Make sure it adapts to blocks that change size.

### Part 4: Vertical composition

Similarly, we have replaced `VerticalCompositionLeft` with a more general (and more concise) `VComp`. Once again, we will provide an alignment (this time, a horizontal alignment rather than a vertical alignment) along with an array of blocks.

Suppose `v1` is the line `"One"`, `v7` is the line `"Seven"`, `v11` is the line `"Eleven"`, and `v19` is the line `"Nineteen"`.

`new VComp(HAlignment.LEFT, new AsciiBlock {v1, v7, v11, v19})` should give us

```text
One
Seven
Eleven
Nineteen
```

`new VComp(HAlignment.CENTER, new AsciiBlock {v1, v7, v11, v19, v1})` should give us

```text
  One
 Seven
 Eleven
Nineteen
  One
```

As that example shows, if we can't perfectly center a line, we should preferentially move it to the left by half a space.

`new VComp(HAlignment.RIGHT, new AsciiBlock {v1, v7, v11, v19})` should give us

```text
     One
   Seven
  Eleven
Nineteen
```

Implement `VComp`. Make sure that it adapts to blocks that change size.

### Part 5: Flipping horizontally

Implement a new class, `HFlip`, which presents a horizontally flipped version of its parameter. That is, each line should appear in reverse order.

For example, if `block` is

```text
this
and
that
```

`new HFlip(block)` should be

```text
siht
 dna
taht
```

As always, make sure that `HFlip` adapts to changes to the underlying block.

### Part 6: Flipping vertically

Implement a new class, `VFlip`, which presents a vertically flipped version of its parameter. That is, the lines should appear in reverse order.

For example, if `block` is

```text
this
and
that
```

`new VFlip(block)` should be

```text
that
and
this
```

As always, make sure that `VFlip` adapts to changes in the underlying block.

### Part 7: Trimming blocks

_This part is **completely optional**. Doing it provides no grade benefit. Skipping it incurs no grade penalty._

Sometimes blocks get too big, and we want to make them smaller. Implement a new class `Trimmed`, that trims the underlying block to a particular width and height. Since we may want to trim from different sides (or keep different sides), the `Trimmed` constructor will also take alignments as parameters.

For example, if the original block is

```text
abcde
fghij
klmno
pqrst
uvwxy
```

`new Trimmed(block, HAlignment.LEFT, VAlignment.TOP, 2, 2)` should be

```text
ab
fg
```

`new Trimmed(block, HAlignment.RIGHT, VAlignment.TOP, 2, 2)` should be

```text
de
ij
```

`new Trimmed(block, HAlignment.CENTER, VAlignment.TOP, 3, 2)` should be

```text
bcd
ghi
```

`new Trimmed(block, HAlignment.CENTER, VAlignment.TOP, 2, 2)` should be

```text
bc
gh
```

That is, if the trimmed block cannot be exactly centered horizontally, we prioritize the left.

`new Trimmed(block, HAlignment.CENTER, VAlignment.CENTER, 3, 3)` should be

```text
ghi
lmn
qrs
```

`new Trimmed(block, HAlignment.CENTER, VAlignment.CENTER, 3, 2)` should be

```text
ghi
lmn
```

That is, if the trimmed block cannot be exactly centered vertically, we prioritize the top.

Make sure that your trimmed blocks adapt to changes in the underlying block.

If, when asked for a line, you ever find that the underlying blocks is not wide or high enough, you can do whatever you'd like. (That is, we will assume that people never try to trim too much.)

### Part 8: Padding blocks

_This part is **completely optional**. Doing it provides no grade benefit. Skipping it incurs no grade penalty._

We may also find that our boxes are not big enough and want to "pad" them to a larger size. Implement a new class, `Padded`, that pads blocks to a given width and height.

For example, if our original block is `X`,

`new Padded(x, '.', HAlignment.LEFT, VAlignment.TOP, 3, 3)` should give us

```text
X..
...
...
```

`new Padded(x, '.', HAlignment.CENTER, VAlignment.TOP, 3, 3)` should give us

```text
.X.
...
...
```

`new Padded(x, '.', HAlignment.CENTER, VAlignment.TOP, 4, 3)` should give us

```text
.X..
....
....
```

That is, if we can't evenly pad something centered on both sides, we put more padding on the right.

`new Padded(x, '.', HAlignment.RIGHT, VAlignment.CENTER, 3, 3)` should give us

```text
...
.X.
...
```

`new Padded(x, '.', HAlignment.RIGHT, VAlignment.CENTER, 3, 4)` should give us

```text
...
.X.
...
...
```

That is, if we can't evenly pad something verticaly centered, we put more padding on the bottom.

Make sure that your padded blocks adapt to changes in the underlying block.

If, when asked for a line, you ever find that the underlying blocks is too wide or too tall, you can do whatever you'd like. (That is, we will assume that people never try to trim too much.)

### Part 9: Another new block

Design and implement at least one other new kind of text block.

### Part 10: Testing your new block

Put tests for your new kind of text block in the file `TestOurBlock.java`. Make sure that you test your new kind of text block in conjunction with some of the other kinds.

### Part 11: Equality testing

There are (at least) three models of equality for `TextBlock` objects:

* Two textblocks are the same if they have he same width and height and contain the same lines. We'll call this version `equal`.
* Two textblocks are the same if they were built in the same way. We'll call this version `eqv`.
* Two textblocks are the same if they occupy the same memory location. We'll call this version `eq`.

We have implemented `equal` and `eq`. It's up to you to implement `eqv`.

What does it mean to be "built the same way"? As we've seen, you can have two textblocks that look the same (are `equal`) but are constructed in different ways. For example, `new VFlip(new Flip(block))` looks exactly the same as `block`, but it was constructed differently.

Or consider the following:

```text
XXX
XXX
```

How many ways are there to build that? Let's see ...

* We could horizontally compose two lines of three X's each.
* We could horizontally compose two lines of one X each, and then
  vertically compose three copies of that.
* We could build a 3x2 rectangle of X's.
* We could build a 5x5 rectangle of X's and then truncate it.
* We could take the empty block and pad it with X's to a 3x2 block.
* We could build a two line block directly.
* ...

For the `eqv` comparison, we want all of those to be treated as different objects.

How might you implement `eqv`? The best strategy we've seen is to require that every `AsciiBlock` also implement `eqv(AsciiBlock other)`. That method should check whether `other` is the same type of block. If not, it can return false. If so, it should decompose the other block and compare each field to the current one.  For example, here's what we might have within the `Grid` class.

```java
  public boolean eqv(AsciiBlock other) {
    return ((other instanceof Grid) && (this.eqv((Grid) other)));
  } // eqv(AsciiBlock)

  public boolean eqv(Grid other) {
    return (this.hreps == other.hreps) && (this.vreps == other.vreps)
        && AsciiBlock.eqv(this.element, other.element);
  } // eqv(Grid)
```

### Part 12: Make an art

In `Art80x24.java` (in package `edu.grinnell.csc207.main`), make the `main` method print out an "interesting" 80x24 ASCII block created by using the various block types above.

Warning! I may demo your artworks in class.

## Collaborating on this project

Students have found multiple modes of collaboration work well in CSC-207. I prefer that at least some of the collaboration involve pair programming, but you will also find that you are more efficient if you split up some of the work.

I would suggest that you begin by reading through the problems together and discussing strategies for each. You might implement a few things together to start with, such as `Surrounded`, `Grid`, the new text block, its tests, and eqv`.

To help ensure that everyone understands all the parts, you should also come back together to discuss what you've done.

In between, you might assign one person to `HComp`, `HFlip`, and `Trimmed` and the other to `VComp`, `VFlip`, and `Padded`.

Or you could just do everything together.

## Grading rubric

The rubric is not yet fully developed. What you see below is mostly the rubric from an old assignment that helped inspire this assignment.

### Redo or above

Submissions that fail to meet any of these requirements will get an I.

```
[ ] Passes all the R tests.
    [ ] Constructors don't crash.
[ ] Includes the specified `.java` files, correctly named.
[ ] Each class has an introductory Javadoc comment that indicates
    the author and purpose.
[ ] Includes a `README.md` file that contains the appropriate information
    (authors, purpose, acknowledgements if appropriate, GitHub URL)
[ ] All files compile correctly.
[ ] Includes one more text block.
[ ] The GitHub repo has at least ten commits.
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```
[ ] Passes all the M tests.
[ ] No more than ten errors from `mvn checkstyle:check`.
[ ] The GitHub repo has at least ten meaningful commits.
[ ] Each commit has an appropriate commit message.
[ ] `TestNewBlock.java` includes at least three tests of the new block.
```

### Exemplary / Exceeds expectations

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an M.

```
[ ] Passes all the E tests.
    [ ] Handle empty blocks appropriately.
    [ ] Handle mutated blocks appropriately.
[ ] All (or most) repeated code has been factored out into individual methods.
[ ] All or most variable names are appropriate.
[ ] `TestNewBlock.java` includes at least six tests of the new block.
[ ] `TestNewBlock.java` include at least two interesting edge cases,
    such as empty blocks.
```

## Tests

The tests are not yet available and will be distributed by Tuesday. There is a placeholder for the tests in the repository.

You will pull the new tests into your repository as follows.

First, type the following. (You will only do this once.)

```
git remote add upstream https://github.com/Grinnell-CSC207/mp-blocks-maven
```

Then, each time I tell you that I've updated the tests, you will type the following.

```
git fetch upstream
git merge upstream/main
```

For example,

```
$ git fetch upstream
remote: Enumerating objects: 17, done.
remote: Counting objects: 100% (17/17), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 9 (delta 2), reused 9 (delta 2), pack-reused 0 (from 0)
Unpacking objects: 100% (9/9), 1.07 KiB | 91.00 KiB/s, done.
From https://github.com/Grinnell-CSC207/mp-blocks-maven
   c4f88de..e2d7ec8  main       -> upstream/main
$ git merge upstream/main
Updating c4f88de..e2d7ec8
Fast-forward
 src/test/java/edu/grinnell/csc207/TestBlocks.java | 45 ++++++++++++++++++++++-
 1 file changed, 44 insertions(+), 1 deletion(-)
```

## Questions and Answers

### GitHub

**How do I let someone else push commits to my GitHub repo?**

> Choose "Settings" (a gear) from along the top (usually top right).

> Choose "Collaborators and Teams" from the list of settings on the left.

> Click on "Add People".

> Search for your partner's GitHub username.

> Give them write access.

> They should get an email invitation that they will need to accept.

**Are we going to end up with merge conflicts?**

> If you are working on different files, you shouldn't have merge conflicts.

> If you've divided the work reasonably, the only place you will likely have a merge conflict is on the experiment. You can avoid that problem by creating separate experiment files.

**How does pushing or pulling work with a partner in mind?**

> Don't push non-working code. (Or at least don't push code that doesn't compile.)

> Always pull as soon as you sit down for a new session.

**Should we only do it on one computer or use two and merge somehow?**

> You should be able to work separately; that's the whole point of a system like GitHub. If you try not to work on the same file, you are unlikely to have merge conflicts. And most merge conflicts are easy to fix.

### Collaboration

**How do you recommend collaboration for Art80x24?**

> Once you've built your blocks, experiment a bit with your partner and talk about what you might try.

**Does the whole team get graded together?**

> Yes, the project gets one grade.

**How do we ensure that both partners learn all the aspects?**

> If you want to ensure that you both learn the material, I'd suggest doing this as a pure pair programming exercise. (Perhaps you can alternate accounts so that we see pushes from both people.)

> Alternately, you can sketch the main ideas of each part together, implement separately, and then come back together to discuss the unexpected complications.

**Should we collaborate on a single repository with our partner?**

> Yes.

**I also want to understand the best way to break down responsibilities between my partner and me be most efficient.**

> I'm not sure "most efficient" should be your goal (although with the amount of time some projects have taken, I sympathize). I'd shoot for "best ratio of understanding to time".

### Equivalence

**What does it mean to have two structurally equivalent blocks?**

> They were formed in the same way. That is, they have the same outermost block and all constituent blocks are also equivalent.

> For example, if the first block was formed with `HFlip`, the second block must also have been formed with `HFlip`. And the block that the first block flips must be structurally equivalent to the block that the second block flips.

> Similarly, if the first block is a right-aligned horizontal composition of five blocks, the second must also be a right-aligned horizontal composition of five blocks, and each of the corresponding blocks must also be structurally equivalent.

**It sounds like structural equivalence requires recursion. Is that correct?**

> Yes. Although it's effectively a kind of "mutual recursion". Each object will provide its own `eqv` method and they will end up calling each-other's methods.

**What mistakes should I avoid when implementing the eqv model?**

> There's an amazingly large range of possible mistakes, so perhaps I'll respond with what you should do.

> Make sure that you understand the examples. Ask questions if you don't.

> Be sure to recurse on sub-blocks.

> Use `.equals` to compare strings rather than `==`. (Okay, that's one mistake to avoid.)

**Can I use `AsciiBlock.equal` in defining the individual `eqv` methods?**

> You can, but I wouldn't recommend it.

**Aren't `equal` and `eqv` the same?**

> Nope. `equal` deals with appearance, `eqv` deals with construction. For
  example ...

> ```java
    AsciiBlock exes0 = new Rect('X', 4, 3);
    AsciiBlock exes1 = new Grid(new Line("X"), 4, 3);
    AsciiBlock exes2a = new Rect('X', 1, 3);
    AsciiBlock exes2 =
        new HComp(VAlignment.LEFT,
            new AsciiBlock[] {exes2a, exes2a, exes2a, exes2a});
    AsciiBlock exes3 =
        new HComp(VAlignment.LEFT,
            new AsciiBlock[] {new Empty(), exes0, new Empty(), new Empty()});
    AsciiBlock exes4 =
        new HComp(VAlignment.RIGHT,
            new AsciiBlock[] {new Empty(), exes0, new Empty(), new Empty()});
    AsciiBlock exes5 =
        new HComp(VAlignment.RIGHT,
            new AsciiBlock[] {new Empty(), new Empty(), exes0, new Empty()});
```

> ```java
    assertTrue(AsciiBlock.equals(exes0, exes1));
    assertFalse(AsciiBlock.eqv(exes0, exes1),
        "Rect vs. Grid");
    assertTrue(AsciiBlock.equals(exes0, exes2));
    assertFalse(AsciiBlock.eqv(exes0, exes2),
        "Rect vs. HComp");
    assertTrue(AsciiBlock.equals(exes2, exes3));
    assertFalse(AsciiBlock.eqv(exes2, exes3),
        "Two HComps with different elements");
    assertFalse(AsciiBlock.eqv(exes3, exes4),
        "Two HComps with different alignments");
    assertFalse(AsciiBlock.eqv(exes4, exes5),
        "Two HComps with different elements");
```

### Expectations

**What is the minimum you expect for our own block?**

> Don't worry too much about your own block. We're going to be fairly generous in the grading. But you should strive for something you'd be proud of.

> Also make sure that it's something that you can test.

**For the Art80x24.java, what is the E standard for "interesting"?**

> Whatever satisfies you, as long as it's not a grid of identical characters.

> Warning! I may be showing them off in class.

**Do we submit our assignment together or separately?**

> Please do only one submission for the two (or three) of you.

### Theoretical

**It seems this "composite pattern," in more official words, plays really well to the strengths of OOP. Is this something that can even be easily achieved in other paradigms?**

> Is that the official term for this? I didn't know.

> We should be able to achieve something similar in a functional paradigm (although we'd likely avoid having mutable blocks). If we think of a "block" as a function from some input to an ASCII block, we could write something that takes other block functions as input and returns a new block function.

> It would be hard to implement this well in a more imperative language. Not impossible, but harder.

### Mutation

**I am concerned about the instructions mentioning that the functions
should be able to "adapt to changes in the underlying block". Are
we not passing an object that, while it is being used to make another
object, does not change, and if we were to change that underlying
object and make another object with the changes, would be an entirely
new object? The created object does not update in place if changes
to its elements are made? Or should the created objects be changed
if their constituents are changed? Phrased differently perhaps,
should the new object 'know' it was made from A and B(and update
if they are changed), or simply that it was made and it is now AB?**

> We are working with objects, not functions. I agree it would be
  difficult if we were using a purely imperative model. And yes,
  if `AB` is made from `A` and `B`, and `A` changes, then `AB`
  should change.

> However, the changes are restricted. Objects only change when
  certain methods are called (or when their subobjects change
  when certain methods are called). Right now, those methods
  are the `Line` object's `update` method and the `Rect` objects
  `wider`, `narrower`, `taller`, and `shorter` methods.

> More concretely, if we set `a` to the line `"eh"` and `b` to the
  line `"bee"`, the right-aligned vertical composition of `a` and
  `b` will be

> ```
 eh
bee
```

> If we then change `a` to `"alphabet"` (using `a.update("alphabet")`),
  our vertical alignment should now be

> ```
alphabet
     bee
```

> Note that you are only expected to support changes based on the
  underlying objects. There is no natural way for you to tell if
  someone reassigns a variable.

**What should the `Surrounded` class do to work well with mutable blocks?**

> Follow the lead of `Boxed` and only look at the underlying blocks when someone calls `row`, `width`, or `height`.

### Miscellaneous

**Are we allowed to create helper functions for each AsciiBlock?**

> Of course. You should always feel free to create helpers.

**Are there any built-in functions for reversing the strings?**

> No. But you should be able to figure this out. There's also a note
  in eboard 8.

**Are there any built-in functions for centering strings?**

> No. But you should be able to figure this out. For horizontal centering, you'll need to add spaces on the left and right. For vertical centering, you'll need to figure out which row to take from each block and whether to use spaces instead of a row.

**Can you show us an example of Part 12: Make an Art?**

> I'll add that to my "to-do" list.

**Are enums in Java similar to how they work in C?**

> Pretty much, except that you have to put the enum name in front of the value. You should write things like `HAlignment.LEFT`.

**How do I tell what method was used to create an object?**

> You can't. But you can tell whether it's a particular kind of object with the `instanceof` operator. E.g. `(block instanceof HFlip)` returns true if `block` is an `HFlip` and false otherwise.

**How do I tell what method was used to modify an object?**

> You can't. You can just get the characteristics of the object after the change. For what we're doing, knowing the width, height, and number of rows in the mutated object should suffice.

**What do you mean by "an `n`-by-`m` grid?**

> It's an arrangement in which we have `n` columns and `m` rows, each of which contains the same thing. For example, if we've managed to make an ASCII cat, `new Grid(cat, 5, 3)` would create fifteen cats, arranged in three rows of five each.

**What should we do if there is an odd number for flipping? Do we just leave the middle alone?**

> Yes. I think the examples show that.

**What should we do if there's an odd difference in heights for a centered `HComp` or an odd difference in widths for a centered `VComp`?**

> Prioritize the top for a centered `HComp`. Prioritize the left for a centered `VComp`. There are examples in the assignment. Let me know if you need more explanation after looking at them.

