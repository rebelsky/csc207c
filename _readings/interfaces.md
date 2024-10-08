---
title: "Separating what from how: Interfaces in Java"
summary: |
  Good programming style suggests that you decide *what* methods a class provides before you decide *how* the class will provide those methods. In this reading, we consider Java's *interfaces*, which encourage such separation.
prereqs: |
  Basic understanding of classes.
---
Introduction: Separating the *what* from the *how*
--------------------------------------------------

As you should have discovered by now, a pair of key activities in object-oriented design are (a) describing classes of objects and (b) using objects from those classes. I have also recommended a particular strategy for designing classes: Start by deciding *what* your class should do and then figure out *how* to make the class do that.

Why do I (and most object-oriented designers) make the what/how distinction?  First, because there's good evidence that programmers cannot think carefully about a wide variety of issues simultaneously. That is, if programmers have to think from the start about how they are going to implement a class (and its methods), they may not think as carefully about what methods it should provide. 

Second, because there's good evidence that programmers often decide upon the methods they will provide based on their choice of how they will implement the class. 

Third, because it's difficult to decide when rewriting a class what methods are necessary and what methods are tied to the implementation. 

Finally, because the what/how interface relates closely to the key object-oriented concept of *encapsulation*. That is, because the clients of a class should only know what the class can do, and not how the class does it, class designers should also carefully distinguish the two.

Interfaces in Java
------------------

Many programming languages accept this important need to distinguish between what a piece of code does and how it accomplishes that task, and incorporate in the language a mechanism for distinguishing these two key issues. When you learned C, you probably discovered that the header files (`.h`) specified the capabilities of libraries and the library code specified the implementations. In Java, the primary mechanism for distinguising what from how is something called an *interface*. Interfaces contain only method headers (a method declaration without the body) and, optionally, static fields. (Recently, Java added the ability to put some code in interfaces; we're generally going to ignore that ability, with the eception being when we write static inteface methods.)

Interface declarations look much like class declarations, except: (a) interfaces use the keyword `interface`, rather than the keyword `class`; (b) interfaces contain no constructors, object fields, or static methods; (c) method declarations in interfaces lack bodies.

Hence, an interface declaration looks much like the following:

```java
public interface InterfaceName {
  // +-----------+---------------------------------------------------------
  // | Constants |
  // +-----------+

  // ...

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  // ...
} // interface InterfaceName
```

For example, here is a portion of an interface declaration for a point in two-space.

```java
/**
 *  Points in two-space.
 *
 *  @author Samuel A. Rebelsky
 */
public interface Point2D {
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the X coordinate of the point.
   *
   * @return the X coordinate
   */
  public double getX();

  /**
   * Get the Y coordinate of the point.
   *
   * @return the Y coordinate
   */
  public double getY();

  /**
   * Get the distance of this point from the origin.
   *
   * @return that distance (also known as the radius)
   */
  public double getDistanceFromOrigin();

  /**
   * Translate this point by deltaX in the x direction and 
   * deltaY in the y direction. Note that this method
   * mutates the underlying point.
   *
   * @param deltaX
   *   the horizontal offset
   *
   * @param deltaY
   *   the vertical offset
   */
  public void translate(double deltaX, double deltaY);

  /**
   * Make a copy of this point.
   *
   * @return another point with the same X and Y coordinates
   */
  public Point2D clone();
// interface Point2D
```

Interfaces and classes
----------------------

What happens after you've defined an interface?  You must then build a class that corresponds to the interface. When we build that class, we tell Java that the class corresponds to the interface with the `implements` keyword. That is, we write

```java
public class ClassName implements InterfaceName {
  // ...
} // class ClassName
```

For example, if we chose to implement `Point2D` as a class with a pair of fields, the x coordinate and the y coordinate, we might write the following code.

```java
/**
 * An implementation of points in two space using an X coordinate
 * and a Y coordinate.
 *
 * @author Samuel A. Rebelsky
 */
public class Point2DPair implements Point2D {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The x coordinate of the point
   */
  double x;

  /**
   * The y coordinate of the point.
   */
  double y;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a point.
   *
   * @param initX
   *   The initial value of the X coordinate.
   *
   * @param initY
   *   The initial value of the Y coordinate.
   */
  public Point2DPair(double initX, double initY) 
  {
    this.x = initX;
    this.y = initY;
  } // Point2DPair(double,double)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the X coordinate of the point.
   *
   * @return the X cooredinate
   */
  public double getX() {
    return this.x;
  } // getX() 
  
  /**
   * Get the Y coordinate of the point.
   *
   * @return the Y coordiante
   */
  public double getY() {
    return this.y;
  } // getY()

  /**
   * Get the distance of this point from the origin.
   *
   * @return that distance
   */
  public double getDistanceFromOrigin() {
    return Math.sqrt(this.x*this.x + this.y*this.y);
  } // getDistanceFromOrigin()

  /**
   * Translate this point by deltaX in the x direction and
   * deltaY in the y direction. Note that this method
   * mutates the underlying point.
   *
   * @param deltaX
   *   The X offset
   *
   * @param deltaY
   *   The Y offset
   */
  public void translate(double deltaX, double deltaY) {
    this.x = this.x + deltaX;
    this.y = this.y + deltaY;
  } // translate(double, double)

  /**
   * Make a copy of this point.
   *
   * @return a point with the same coordinates
   */
  public Point2D clone() {
    return new Point2DPair(this.x, this.y);
  } // clone()
} // class Point2DPair
```

Alternative implementations
---------------------------

One particularly important aspect of Java's interface mechanism is that you, as programmer, are not limited to only one implementation per interface. That is, you can implement the same interface in multiple ways and then later choose with implementation is best for a particular task. For example, if we found that we were frequently checking the distance of points from the origin, we might instead choose to implement them as a radius/theta pair.

```java
/**
 *  An implementation of points in two space using a radius/theta pair
 *  which specify the distance of the point from the origin and the
 *  angle between the positive x-axis and a line from the origin to
 *  the point.
 *
 *  @author Samuel A. Rebelsky
 */
public class Point2DPolar implements Point2D {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  
  /**
   * The radius, which represents the distance of the point from 
   * the origin.
   */
  double radius;
  
  /**
   * Theta, which represents the angle between the positive X axis
   * and a line from the origin to the point.
   */
  double theta;
  
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  
  /**
   * Create the point (x,y)
   */
  public Point2DPolar(double x, double y) {
    this.radius = Math.sqrt(x*x + y*y);
    this.theta = Math.atan(y/x);
  } // Point2DPolar(double,double)
  
  /**
   * Create a point radius 0 and angle 0 (with the expectation that
   * we'll change it almost immediately).
   */
  private Point2DPolar() {
    this.radius = 0.0;
    this.theta = 0.0;
  } // Point2DPolar()
  
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  
  /**
   * Get the X coordinate of the point.
   *
   * @return the X coordinate
   */
  public double getX() {
    return this.radius * Math.cos(this.theta);
  } // getX() 
  
  /**
   * Get the Y coordinate of the point.
   *
   * @return the Y coordinate
   */
  public double getY() {
    return this.radius * Math.sin(this.theta);
  } // getY()
  
  /**
   * Get the distance of this point from the origin.
   *
   * @return that distance (also known as the radius)
   */ 
  public double getDistanceFromOrigin() 
  {
    return this.radius;
  } // getDistanceFromOrigin()
  
  /**
   * Translate this point by deltaX in the x direction and
   * deltaY in the y direction. Note that this method
   * mutates the underlying point.
   *
   * @param deltaX
   *   the horizontal offset
   *
   * @param deltaY
   *   the vertical offset
   */
  public void translate(double deltaX, double deltaY) {
    // Left as an exercise to the reader.
  } // translate(double, double)
  
  /**
   * Make a copy of this point.
   *
   * @return another point with the same X and Y coordinates
   */
  public Point2D clone() {
    Point2DPolar tmp = new Point2DPolar();
    tmp.radius = this.radius;
    tmp.theta = this.theta;
    return tmp;
  } // clone()
} // class Point2DPolar
```

As suggested above, we can use *either* of these implementations and expect that they will behave the same (except, of course, in terms of speed/efficiency). How do clients write code that accepts either implementation?  They write code that uses the interface, rather than a particular class. For example, we can write a method to compare points by distance from the origin as follows:

```java
/**
 * Compare two points. 
 *
 * @return 
 *    A negative number if p1 is closer to the origin than p2, 
 *    0 if the two are the same distance from the origin, and 
 *    a positive number if p1 is further from the origin.
 */
public static int compare(Point2D p1, Point2D p2) {
  return Double.compare(p1.distanceFromOrigin(), p2.distanceFromOrigin());
} // compare(Point2D, Point2D)
```

It is now perfectly acceptable to call this `compare` method with two `Point2DPair` objects, with two `Point2DPolar` objects, or even with one object of each class. We return to this idea in the reading on [subtype polymorphism](../readings/subtype-polymorphism).

Another sample interface: Indexed collections
---------------------------------------------

As you start designing different classes and structures, you'll regularly discover that your programming will benefit from interfaces. Interfaces are also useful as we work to separate *what* a class can do from *how* the class achieves those goals.

Let's consider one of our favorite data structures, the array. Arrays let you access values by index. We typically implement arrays as a chunk of memory, and use the index to determine an offset into that chunk of memory. But there are other kinds of structures that might permit us to access values by index. Some designers even consider that an appropriate feature of lists. (I dislike this decision, but I accept that some people make it.)

Since there's unlikely to be any common code between a "chunk of memory" indexed structure and a "linked" indexed structure, we could treat indexed structures are a type of interface.

```
/**
 * Indexed collections of strings.
 */
public interface IndexedCollectionOfStrings {
  /**
   * Get element i of the collection.
   *
   * @param i
   *   the index
   *
   * @return the element at index i.
   *
   * @pre 0 <= i < this.length()
   */
  public String get(int i) throws IndexOutOfBoundsException;

  /**
   * Set element i of the collection to str.
   *
   * @param i
   *   the index
   *
   * @param str
   *   the value to set
   */
  public void set(int i, String str) throws IndexOutOfBoundsException;

  /**
   * Determine the number of elements in the collection (1 + the
   * last valid index).
   */
  public int length();
} // interface IndexedCollectionOfStrings
```

Implementing such collections is left as an exercise for the reader.

Self checks
-----------

### Check 1: Other interfaces

Suggest another interface that might be useful to develop.
