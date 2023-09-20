---
title: "EBoard 12: Exceptional programming"
number: 12
section: eboards
held: 2023-09-20
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.

_Approximate overview_

* Administrivia
* Questions
* Two design problems
* Lab

Administrivia
-------------

### Introductory notes

* Today's lab is somewhat rewritten.  Fingers crossed that everything works
  okay.
    * Make sure that you are using the repo named something like
      `lab-exceptions-vscode`.
* Note that you can usually get VSCode to format your code to meet my
  expectations using the command "Format Document".
* Your graders ask that you not clog your repositories with cruft.
    * Just the README and the .java files *for the specific project*.
* When you are opening a Java project in VSCode, use the folder *above* 
  the `src` folder.

### Upcoming Token activities

Academic

* CS Extras, Thursday 21 Sept 2023, 4:15 pm, Science 3821.  Study Abroad in CS.
* GrinTech talk w Karla Erickson and Elizabeth Cave, Thursday, 21 Sept 2023, 
  HSSC N1112.
* Mentor session Sunday.

Cultural

Peer

Wellness

Misc

### Upcoming work

* Thursday: MP3
    * Bonus token to the first person who spends four hours on MP3
      and TeamsChats me to tell me how far they got.
    * Two people have gotten to four hours.  They say that there are
      some important mental hurdles to overcome.
    * We may want to try to get things to click.
* Friday: More readings, today's lab

Questions
---------

_You can ask questions about anything related to the class!  Self gov
says that you **should** ask those questions._

### Java

### Administrative stuff

Do we get to choose which way I meet each LA?

> If I have a paper-based LA, then you should at least try the first
  time on paper.  If that fails, you can provide me with evidence.

> Those may start appearing this weekend.

### MP2

### MP3

What should I get if I center boxed text?

> It depends on the particulars.  Let's say you build
  `new Centered(new BoxedBlock(new TextLine("Hello")), 21)`
  and put it above `new TextLine("012345678901234567890123456789")`.`

              +-----+
              |Hello|
              +-----+
       012345678901234567890123456789

> On the other hand, if you built a block with an expression like
  `new BoxedBlock(new Centered(new TextLine("Hello"), 21))`, that should
  look more like

       +---------------------+
       |        Hello        |
       +---------------------+
       012345678901234567890123456789

> Order of operations matters!

What should `Centered` and `RightJustified` do if the block is too
big (or the size is too small)?

> This will also truncate.

What should `new HorizontallyFlipped(new TextLine("Hello"))` look like?

        olleH

What should `new HorizontallyFlipped(new BoxedBlock(new TextLine("Hello")))` look like?

        +-----+
        |olleH|
        +-----+

What should `new VerticallyFlipped(new VerticallyCompose(new TextLine("Hello"), new TextLine("Goodbye")))` look like?

        Goodbye
        Hello

When centering with an odd number of surrounding spaces, do you care if
we're slightly left or slightly right?

> No.  But that may make my testing harder.

Can you give us some hints as to how we might write `Truncate`?

> Truncate will have two fields, 
    * `TextBlock block`
    * `int w`

> Focus on how you write `row`, `height`, `width` in terms of the
  `row`, `height`, and `width` of your one field.

> If I truncate a block, what's the height of the new block?  It's
  the same.

> If I truncate a block to width `w`, what's the width of the truncated
  block?  It's `w`.

> What is row i of the truncated block?  The first `w` characters or
  row i of the underlying block.  (Usually)

> How would you phrase "The first `w` characters or row `i` of the
  underlying block" in Java?

> Write a for loop to grab the characters from row i of the
  `this.block.row(i)`.

> `return this.block.row(i).substring(0, w);`

> Special case: The width of the ith row may be less than w.  So we need
  to pad it with spaces (at the right) in that case.

> Putting it all together

        /**
         * Blocks of text truncated to a specified width.
         */
        public class Truncated implements TextBlock {
          // +--------+------------------------------------------------------
          // | Fields |
          // +--------+

          /** 
           * The block we are truncating.
           */
          TextBlock block;

          /**
           * The width of the truncated block.
           */
          int width;

          // +--------------+------------------------------------------------
          // | Constructors |
          // +--------------+
          


          // +---------+-----------------------------------------------------
          // | Methods |
          // +---------+

          public int width() {
            return this.width;
          } // width()

          public int height() {
            return this.block.height;
          } // height()

          public String row(int i) {
            return "";  // STUB
          } // row(int)
        } // class Truncated
  
### Testing

When testing, do I write one test method per method I'm testing or
should I write multiple methods?

> It depends on how much you like green checkmarks.  

> It's harder to track down bugs if you put everything in one test method,
  so I generally recommend separate test methods, although I don't always
  follow my own recommendation.

When testing, why would you have multiple test classes?

> Most developers prefer one test class per normal class.

### Exceptions

Two design problems
-------------------

In today's lab, we're working with quadratic polynomials 
(of the form $$ax^2 + bx + c$$).

_TPS_

On paper, by yourself: What does class `Quadratic`, which we use
to represent quadratic polynomials look like?

* **Fields** - Don't forget to include types
* **Constructor(s)** - Don't forget to include parameter types
* **Methods** - Don't forget to include parameter types and return types.
  If the name isn't obvious, you may want to explain them, too.

What I saw

* Two approaches to fields: 
    * three fields, `a`, `b`, and `c`, or `coeff1`, `coeff2`, and `coeff3`.
    * We tend to think of quadratics with a, b, and c, so those are reasonable
      field names.
    * One field which is an array of three values `int[] coeffs = new int[3];`
    * Using an array may be a little harder because we'll have to spend
      mental energy remembering whether coeffs[0] is the coefficient of
      the x^2 term or the constant (or, given the design of light switches
      in Noyce, the x term).
    * Note that we normally make our fields package or protected.
* What type should these fields be?  `int`, `double`, `BigInteger`,
  `BigDouble`, ...
    * `double` seems okay.
* Methods
    * `evaluate(double x)` - find the value of the polynomial
    * `Polynomial derivative()` - find the derivative
    * `double smallerRoot()` - these are sometimes complex; we'll
      need to think of how to deal with that solution.
    * `double biggerRoot()`
    * `double[] realRoots()` - could return the empty array if there
      are no real roots, a size-one array if there's one root, and
      a size-two array if there are two roots.  Might also work with
      a list, which could be easier to handle.
    * `void setA()` - should we be able to mutate our structures?
    * `void setB()` - perhaps we should just create a new one
    * `void setC()`
    * `double getA()` - Useful.  May not be strictly necessary.
    * `double getB()`
    * `double getC()`
    * `String toString()`
    * `String toString(double x)`
    * `Quadratic add(Quadtratic other)`

Lab
---

https://rebelsky.cs.grinnell.edu/Courses/CSC207/2023Fa/labs/exceptions.html

Compute square roots with `Math.sqrt`.

Surprise!  There's nothing to turn in today.
