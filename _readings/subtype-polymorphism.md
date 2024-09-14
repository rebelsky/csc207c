---
title: Reusing and generalizing code with subtype polymorphism
summary: |
  We consider a form polymorphism, one of the key ideas in object-oriented programming. Subtype polymorphism permits us to write methods that can use objects in a variety of related classes.
prereqs: |
  Class basics. 
  [Interfaces](../readings/interfaces).
---
_Warning! This document was significantly rewritten in Fall 2024. Expect some infelicities (and please let Sam know about them)._

Introduction
------------

As we saw at the end of the reading on [interfaces](../readings/interfaces), when we write a method that uses an interface as the type of a parameter, we can call that method using any object from a class that implements the interface. The ability to call a method with an object that belongs to any one of a group of related classes is an aspect of the idea of _polymorphism_. Polymorphism is the idea that you can have many forms of the same thing.

Why have polymorphism?
----------------------

Why include polymorphism in a programming language?  Because it significantly reduces programming effort. In particular, polymorphism allows you to write one method for a variety of types, rather than to write one method per type.

For example, suppose we are modeling an old-fashioned general store (or even a new-fashioned health foods market). Some purchases will be individual items, which have individual prices. Some purchases will be bagged solids, such as flour or sugar, that depend on their weight and the price per ounce. Some purchases will be liquids, which incur a price based on their weight, the price per ounce, and the price of the container they are put in. Ideally, we will be able to get a price per purchase uniformly, rather than doing a different computation for each.

```java
    Purchase[] purchases = ...;
    ...
    int totalPrice = 0;
    for (Purchase p : purchases) {
      totalPrice += p.cost();
    } // for
```

How do we achieve this goal? Using interfaces and the concept of subtype polymorphism. First, we'll specify an interface that includes the `cost` method.

```java
/**
 * Things people might purchase.
 */
public interface Purchase {
  /**
   * Determine the cost of this purchase.
   *
   * @return the cost in cents
   */
  public int cost();
} // interface Purchase
```

Next, we build the individual classes. Let's start with things we buy individually, like hammers or loaves of bread.

```
/**
 * Items purchased individually.
 */
public class Item implements Purchase {
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
  int cost;

  ...

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine the cost of this purchase.
   *
   * @return the cost in cents
   */
  public int cost() {
    return this.cost;
  } // cost()

  ...

} // class Item
```

Fairly straightfoward, right?

Now let's move on to something whose cost depends on the weight, such as flour or screws.

```java
/**
 * Things we buy by weight.
 */
public class BulkLiquid implements Purchase {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  ...

  /**
   * The cost per ounce (in cents).
   */
  int costPerOunce;

  /**
   * The weight, in ounces.
   */
  int weight;

  ...


  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine the cost of this purchase.
   *
   * @return the cost in cents
   */
  public int cost() {
    return this.costPerOunce * this.weight;
  } // cost()

  ...

} // class BulkSolid
```

```java
/**
 * Liquids, which must be stored in containers.
 */
public class Liquid implements Purchase {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  ...

  /**
   * The cost per fluid ounce (in cents).
   */
  int costPerOunce;

  /**
   * The volume, in ounces.
   */
  int volume;

  /**
   * The item the liquid is stored in (e.g., a glass jar or
   * a plastic bottle).
   */
  Item container;

  ...

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine the cost of this purchase.
   *
   * @return the cost in cents
   */
  public int cost() {
    return this.costPerOunce * this.volume + this.container.cost();
  } // cost()

  ...

} // class Liquid
```

We can write something similar for liquids where people may buy varying amounts.

```java
/**
 * Liquids, which must be stored in containers.
 */
public class Liquid implements Purchase {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  ...

  /**
   * The cost per fluid ounce (in cents).
   */
  int costPerOunce;

  /**
   * The volume, in ounces.
   */
  int volume;

  /**
   * The item the liquid is stored in (e.g., a glass jar or
   * a plastic bottle).
   */
  Item container;

  ...

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine the cost of this purchase.
   *
   * @return the cost in cents
   */
  public int cost() {
    return this.costPerOunce * this.volume + this.container.cost();
  } // cost()

  ...

} // class Liquid
```

The "compute total purchase price" algorithm doesn't care whether someone is buying individual items, solids, or liquids. Since it knows that everything we sell has a `cost` method, it can just call the `cost` method and be confident it works correctly.

This example may also suggest another reason to have polymorphism: If we write a polymorphic method, it will work not only with all existing classes that implement an interface, but also with all future classes that implement that interface. In effect, we have "programmed for the future". For example, if we add a new kind of thing that people can purchase (e.g., maybe we add the ability to hire folks from the store to help with things, where the cost may depend on additional factors, such as time of day), the code to compute the total purchase price need not change.

Yet another reason to have polymorphic methods is that they typically require more careful thought than do type-specific methods. That is, because the methods must be general, programmers cannot rely on features of particular types. Experience suggests that these general-purpose solutions are often somewhat better. (Of course, this better is certainly subjective. At times, the type-specific methods are more efficient and clearly easier to write.)

Side note: Duck typing
----------------------

As you may have noted, Java asks programmers to carefully specify types (classes and interfaces) and relationships between those types. Other object-oriented languages may be a bit more casual. For example, many modern languages support what is called "_duck typing_". Rather than specifying in advance that a class or object implements an interface, the programmer can simply provide a class or object that implements the necessary methods. In that model, we can run our "total cost" algorithm on anything that happens to have a zero-parameter `cost` method, even if it hasn't included an `implements` keyword.

Why is this called "duck typing"? It comes from the aphorism "If it walks like a duck, swims like a duck, and quacks like a duck, it's probably a duck." That is, if it has a `walk()` method, a `swim()` method, and a `quack()` method, our program can use it like it would anything that has those three methods, even if it happens to be, say, a swan.

If you choose to enter the rabbit hole (or anything that has a `fallInto()` method) of that aphorism, you'll likely discover that its origins are disputed and, as importantly, that at least one origin is used to indicate that having all the characteristics doesn't necessarily make something a duck, as our swan example indicated.

An extended example: Abstract ASCII Art
---------------------------------------

Let us consider an example in which polymorphism significantly simplifies our task. Suppose we want to create simple grid-like images using ASCII characters, such as the following.

```
/------------\
|      ....  |
|***   ....  |                TTTTTTT
|***   ....  |                TSSSSST
|   ***      |                TSEEEST
|   ***      |                TSENESTING
|      /----\|                TSEEEST
|      |....||                TSSSSST
|      |....||                TTTTTTT
|      |....||
|      \----/|
\------------/
```

As the examples may suggest, there are a variety of ways we might combine these kinds of objects to make new ones. We might place two side-by-side. We might plane one over another. We might outline something (either using a particular character or using one of the "boxes" we used in the first image.

How might we describe such combinations? Let's take the one on the right.

We start with the letter `N`. We surround it by `E`. We surround that by `N`. We surround that by `T`. That gives a seven-by-seven square. We then pair that with "ING", side-by-side, center aligned.

Of course, that sounds very imperative. We want to think more in terms of objects. So we'll rephrase that in more object-oriented terms.

First, we build the Abstract ASCII Art object corresponding to the letter `N`. Then we build another object that surrounds that object with `E`. Then we build another object that surrounds that by `S`. And so on and so forth.

Why is it useful to think of these as objects? If they are objects, we can make multiple copies and more.

How can we print these out? It depends on what methods the objects provide. Since the objects are grids, we might provide methods that give a particular line and the total number of lines. We'll call those methods `row` and `height`.

```
  public static void print(PrintWriter pen, AsciiBlock block) {
    for (int i = 0; i < block.height(); i++) {
      pen.println(block.row(i));
    } // for
  } // print(PrintWriter, AsciiBlock)
```

What other methods should these ASCII blocks provide? It might be nice to have their width in addition to their height. But three methods is a nice, compact set to get started.

Putting it all together, we get the following interface:

```java
import java.io.PrintWriter;

/**
 * Blocks of ASCII text.
 */
public interface AsciiBlock {
  // +----------------+----------------------------------------------
  // | Static methods |
  // +----------------+

  /**
   * Print out a block.
   */
  public static void print(PrintWriter pen, AsciiBlock block) {
    for (int i = 0; i < block.height(); i++) {
      pen.println(block.row(i));
    } // for
  } // print(PrintWriter, AsciiBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
 
  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @pre
   *   0 <= i < this.height()
   *
   * @exception Exception
   *   if the row number is invalid.
   */
  public String row(int i) throws Exception;

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height();

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width();
} // interface AsciiBlock
```

The simplest kind of AsciiBlock is a single line of text. We'll use these single lines as the building block of more complex blocks.

```java
/**
 * One line of text.
 */
public class TextLine implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The contents of the line.
   */
  String line;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new line.
   *
   * @param contents
   *   The contents of the line.
   */
  public TextLine(String contents) {
    this.line = contents;
  } // TextLine(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception
   *   if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    if (i != 0) {
      throw new Exception("Invalid row " + i);
    } // if
    return this.line;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return 1;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.line.length();
  } // width()
 
} // class TextLine
```

Perhaps the next simplest `AsciiBlock` is a rectangle of all the same
characgter.

```java
/**
 * A rectangle composed of a single character.
 */
public class Rectangle implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * One row of the rectangle.
   */
  String row;

  /**
   * The height of the rectangle.
   */
  int height;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a rectangle.
   *
   * @param ch
   *   The character from which we build the rectangle.
   */
  public Rectangle(char ch, int rectWidth, int rectHeight) 
      throws Exception {
    // Sanity check
    if (rectWidth <= 0) {
      throw new Exception("Rectangle width must be positive");
    } else if (rectHeight <= 0) {
      throw new Exception("Rectangle height must be positive");
    } // if/else
    // Set up the fields
    this.height = rectHeight.
    this.row = new String(new char[] { ch, ch });
    while (this.row.length() < rectWidth) {
      this.row = this.row.append(this.row);
    } // while
    this.row = this.row.substring(0, rectWidth);
  } // Rectangle(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception
   *   if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    if ((i < 0) || (i >= this.height())) {
      throw new Exception("Invalid row " + i);
    } // if
    return this.row;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.height;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.row.length();
  } // width()
 
} // class Rectangle
```

How can we combine lines, rectangles (and the combinations of lines and rectangles)?  We might combine them horizontally, vertically, or even put a box around them. Let's consider the last of those. To put a box around an AsciiBlock , we simply need to figure out what to return for the calls to `row`, `height`, and `width`. The height of a boxed block is only slightly bigger than the height of the underlying block, with room for a row above and a row beneath. Similarly, the width of a boxed block is only slightly bigger than the width of the underlying block, with room for a character on the left and a character on the right.

The hardest of the three methods to write is `row`. If the height of the underlying block is `h`, for rows 1 to `h`, we surround the i-1th row of the underlying block with the left and right symbols of the box (e.g., vertical bars). For row 0, we return the top row of the box symbol, such as `/-----\`. For row `h`, we return a similar string.

Putting it all together, we get the following.

```java
/**
 * A text block surrounded by a box.
 *
 * @author Samuel A. Rebelsky
 */
public class BoxedBlock implements AsciiBlock {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+
      
  /** 
   * A backslash.
   */ 
  static final String BACKSLASH = "\\";
      
  /** 
   * A slash.
   */ 
  static final String SLASH = "/";
  
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as
   * the program operates.
   */
  static String lotsOfDashes = "--";

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the box
   */
  AsciiBlock contents;

  // +---------------+-----------------------------------------------------
  // | Class Methods |
  // +---------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This method is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0,len);
  } // dashes(int)

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param blockContents
   *   The contents of the block.
   */
  public BoxedBlock(AsciiBlock blockContents) {
    this.contents = blockContents;
  } // BoxedBlock(AsciiBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception
   *   if the precondition is not met
   */
  public String row(int i) throws Exception {
    int h = this.contents.height();
    if (i == 0) {
      // The top of the box
      return SLASH + dashes(this.contents.width()) + BACKSLASH;
    } else if (i == h+1) {
      // The bottom of the box
      return BACKSLASH + dashes(this.contents.width()) + SLASH;
    } else if ((i > 0) && (i <= h)) {
      // Stuff within the box
      return "|" + this.contents.row(i-1) + "|";
    } else {
      throw new Exception("Invalid row " + i);
    } // if/else
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return 2 + this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the numbrer of columns
   */
  public int width() {
    return 2 + this.contents.width();
  } // width()
 
} // class BoxedBlock
```

Because `BoxedBlock` objects can be created from any `AsciiBlock` objects, we can create them from lines of text or even from other text blocks. For example, consider the following instruction.

```java
AsciiBlock block  = new BoxedBlock(new BoxedBlock(new TextLine("Hello")));
```

If we print out `block`, we get something like the following:

```text
/-------\
|/-----\|
||Hello||
|\-----/|
\-------/
```

Once we add in horizontal and vertical composition (which we will do in [the lab](../labs/subtype-polymorphism), we can build a wide variety of interesting images.

Self Checks
-----------

### Check 1: Horizontal composition (width & height) (‡)

Suppose we are horizontally composing two `AsciiBlock` objects into a new `AsciiBlock`, which we'll call `left` and `right`? We will top-align them.

a. What is the width of the resulting object? You should express it in terms of `left.width()` and `right.width()`.

b. What is the height of the resulting object? You should express it in terms of `left.height()` and `right.height()`?

### Check 2: Horizontal composition (rows) (‡)

Suppose we are horizontally composing two `AsciiBlock` objects into a new `AsciiBlock`, which we'll call `left` and `right`? We will top-align them.

Suppose also that `left.width() is 3, `left.height()` is 1, `right.width() is 4, and `right.height()` is 2.

a. How should we form row 0 of the horizontally composed object?

b. How should we form row 1 of the horizontally composed object?

Suppose instead that `left.width() is 3, `left.height()` is 2, `right.width() is 4, and `right.height()` is 1.

c. How should we form row 0 of the horizontally composed object?

d. How should we form row 1 of the horizontally composed object?

### Check 3: From concept to code

Here's the start of a `HorizontalCompositionTop` class that represents the top-aligned horizontal composition of two blocks. 

```java
/**
 * The top-aligned horizontal composition of two blocks.
 */
public class HorizontalCompositionTop implements AsciiBlock {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left side.
   */
  AsciiBlock left;

  /**
   * The right side.
   */
  AsciiBlock right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new horizontal composition.
   */
  public HorizontalCompositionTop(AsciiBlock leftBlock, AsciiBlock rightBlock) {
    this.left = leftBlock;
    this.right = rightBlock;
  } // HorizontalCompositionTop()

  ...
} // class HorizontalCompositionTop
```

a. Given your analysis from check 1, write the `width()` method for this class.

b. Given your analysis from check 1, write the `height()` method for this class.

c. Given your analysis from check 2, write the `row()` method for this class.

### Check 4: Horizontal composition, revisited

How would your `row` method differ if we wanted the horizontal composition of two blocks to be vertically centered, something like the following?

```
LEFT
LEFTRIGHT
LEFTRIGHT
LEFTRIGHT
LEFT
```

Note that we might have issues in which the difference between the two blocks might differ by an odd number. In that case, we'll prefer shifting up to down.

```
LEFT
LEFTRIGHT
LEFTRIGHT
LEFT
LEFT
```

or

```
    RIGHT
    RIGHT
LEFTRIGHT
LEFTRIGHT
LEFTRIGHT
    RIGHT
    RIGHT
    RIGHT
```
