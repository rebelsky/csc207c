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

Implement a more general version of `Rectangle` called `Grid`. Instead of an `n`-by-`m` grid of characters, `Grid` has an `n`-by-`m` grid of `AsciiBlock` objects. 

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
    return (this.hreps == other.hreps) && (this.vreps == other.hreps)
        && (this.element.eqv(other.element));
  } // eqv(Grid)
```

### Part 12: Make an art

In `Art80x24.java` (in package `edu.grinnell.csc207.main`), make the `main` method print out an "interesting" 80x24 ASCII block created by using the various block types above.

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
[ ] Includes the specified `.java` files, correctly named.  
[ ] Each class has an introductory Javadoc comment that indicates
    the author and purpose. 
[ ] Includes a `README.md` file that contains the appropriate information 
    (authors, purpose, acknowledgements if appropriate)
[ ] All files compile correctly.
[ ] Includes one more text block.
[ ] The `README.md` includes a link to the GitHub repo.
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
[ ] At least three tests in `TestNewBlock.java`.
```

### Exemplary / Exceeds expectations

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an M.

```
[ ] Passes all the E tests.
[ ] All (or most) repeated code has been factored out into individual methods.  
[ ] All or most variable names are appropriate.
[ ] Tests in `TestNewBlock.java` include interesting edge cases, such as 
    empty blocks.
```

## Tests

The tests are not yet available and will be distributed by Tuesday. There is a placeholder for the tests in the repository.

You will pull the new tests into your repository as follows.

First, type the following. (You will only do this once.)

```
git remote add https://github.com/Grinnell-CSC207/mp-blocks-maven
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

> If you've divided the work reasonably, the only place you will likely have
  a merge conflict is on the experiment. You can avoid that problem by 
  creating separate experiment files.

### General

**Do we submit together or separately?**

> Please do only one submission for the two (or three) of you.
