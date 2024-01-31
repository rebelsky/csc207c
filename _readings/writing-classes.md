---
title: Writing your own classes
link: true
---
*Summary:* We consider how and why to create your own classes that serve as templates for the creation of new objects.

Prerequisites: [Basics of Java](intro-java) and [Basics of Object-Oriented Programming](oop-basics).

## Making the transition From imperative to object-oriented programming

You have probably heard that Java is an _object-oriented_ language. What does that mean? It means that the focus of programming in Java is supposed to be on the design of objects and they ways in which they interact. In particular, Java supports objects, encapsulation, inheritance, and polymorphism. (It's okay if you don't remember those last few terms; we'll revisit them frequently.)

You may find that emphasis surprising, given that most of the programs you've written have focused primarily on using objects, rather than on designing objects. It turns out that Java supports two models of problem solving, imperative and object-oriented. Computer science educators have mixed opinions on which model to teach first.

We will assume that you have encountered many of the imperative aspects of Java, the ways in which Java is basically just a more verbose version of C. It is time to move on to the object-oriented paradigm. We begin by considering how to build and use what I'll call “template classes” in Java.

(No, “template class” is not standard terminology. Mostly, folks just call them classes. But I find it useful to distinguish between the different ways in which we use classes - as templates, to provide a set of static methods (“utility classes”), and as a place to start the program (“main classes”).)

## What is a template class?

Different object-oriented languages provide a variety of mechanisms by which programmers describe objects. In Java, as in many languages, programmers typically describe objects through classes.  Classes provides a template for building individual objects. Template classes typically contain three parts:

* The _fields_ of a class (and of an object) provide the data associated with each object. Each field in a template class has a name and a type. When we build individual objects from the class, we fill in a value for each field.
* The _methods_ of a class describe how objects within that class do things (compute values, input information, output information, update their state, etc.). We often distinguish between “observers”, methods that simply observe the state of an object, and “mutators”, methods that change the state of an object.
* The _constructors_ of a class provide instructions for building new objects in the class. Constructors typically fill in values for fields.

We will consider each in turn.

## The structure of a Java template class

In Java, a template class typically has the following structure.

```java
package packagename;

import otherpackagename.NeededClass;

/**
 * A helpful introductory comment that describes the class.
 */
public class ClassName
{
  // +--------+---------------------------------------------------------
  // | Fields |
  // +--------+

  Field declarations

  // +--------------+---------------------------------------------------
  // | Constructors |
  // +--------------+

  Constructors

  // +---------+--------------------------------------------------------
  // | Methods |
  // +---------+

  Methods

} // class ClassName
```

You can also include portions of a utility class (one that primarily provides static fields and methods) or a main class (one that provides a `main` method), such as static fields, static methods, constants, and a `main` method.

## Object fields

As suggested above, object fields provide a place to hold the data associated with an object. They may be information the object contains (e.g., a list might contain a particular value as its first element), or they may describe the object (e.g., a book has a title).

Each field declaration has three parts:

* The _name_ of the field.
* The _type_ of the field. That is, the kinds of values it can take on.
* An optional _protection level_. We won't specify protection levels right now.

Field declarations have the form:

```java
protection Type name;
```

For example, to say that we have a field named `title` with type `String` and the standard package protection, we would write

```java
String title;
```

Similarly, to say that we have an integer field named `count` that is accessible to anyone, we would write

```java
public int count;
```

The custom in Java is to have field names begin with a lower case letter.  (I expect you to follow that custom.)  When you reference an object's fields within that object, you typically preface the name of the field with the keyword `this`. For example, we would refer to the `title` field as `this.title`. (Ideally, you will only directly reference an object's fields within that object.)

You may note that field declarations look a lot like variable declarations. However, they differ in a number of ways. First, variable declarations are nested within method definitions; field declarations appear directly within the class definition. Next, variables are available only within the declaring method, while fields are available to any method in the class. Finally, fields have protection levels, variables do not.

You may also note that field declarations look a lot like global variable declarations within a utility class. Global variables look much like field declarations, except that they also have the keyword static. Global variables are accessible to all the static methods of a class and all the object methods in a class. (In contrast, fields are available only to objects, not to state methods.)

### Example: A vector in two-space

As an example, let's consider a simple class that we see in many sciences, a vector in two space rooted at the origin. If you have no idea what a vector in two space is, think of it as a line from the origin, (0,0), to a point, (x,y).

What fields might we have for a vector in two space? One possibility is to have the location of the head, that is, the x and y coordinates. Another is to use the angle of the vector from the positive x axis and the radius. Which do we choose? It depends on our application. (In fact, you will find that choosing the appropriate fields is one of the difficult aspects of object design.) For now, let's just use the radius and the angle.

```java
  /** The length of the vector. */
  double radius;
  /** The angle of the vector from the positive X axis in radians. */
  double theta;
```

## Constructors

How do the fields of a new object get set? Traditionally, they get initialized when you build (or “construct”) a new object in the class. To initialize the fields, you write something called a constructor that fills in those fields (and, perhaps, does other initialization).

The form of a constructor is fairly simple,

```java
protection NameOfClass(parameters) OptionalThrowsClause {
  body;
} // NameOfClass(ParameterTypes)
```

The body of the constructor contains a sequence of imperative operations to fill in the fields and do other initialization. The parameters provide the information necessary to fill in those fields.

As you have seen, you typically call a constructor using the `new` keyword, as in

```java
PrintWriter pen = new PrintWriter(System.out, true);
```

or

```java
Vec2D alpha = new Vec2D(Math.PI/2, 1.0);
```

### An example: Constructing vectors

For the case of vectors in two-space, we might want an angle and a radius to build a vector. Here's the definition of such a constructor, assuming that we've called the class Vec2D.

```java
/**
 * Create a new vector with angle _theta and radius _radius.
 */
public Vec2D(double _theta, double _radius) {
  this.theta = _theta;
  this.radius = _radius;
} // Vec2D(double, double)
```

You'll note that I've given the parameters similar names to the fields, the main difference being that they begin with an underscore. You may choose whatever name you want for the parameters, but I find that when the parameters match the fields, it's convenient to choose similar names. Note that Java is very lenient about naming, so you could also have named these parameters theta and radius and it would have distinguished those parameters from the field. But I find programmers get confused much more easily than Java.

Once we've designed the constructor, we might call it as follows.

```java
  Vec2D alpha = new Vec2D(Math.PI/2, 1.0);
```

We can create more than one constructor. In this case, we might also want to permit clients to construct a unit vector (that is, with a radius of 1.0) at any angle.

```java
/**
 * Create a unit vector with angle _theta.
 */
public Vec2D(double _theta)
{
  this.theta = _theta;
  this.radius = 1.0;
} // Vec2D(double)
```

We can call this constructor with

```
  Vec2D northeast = new Vec2D(Math.PI/4);
```

We might even want to permit clients to construct vectors given the x and y position of the head of the vector. It would be tempting to write such a constructor as

```
/**
 * Create a new vector from (0,0) to (x,y).
 */
public Vec2D(double x, double y)
{
  this.theta = Math.atan(y/x);
  this.radius = Math.sqrt(x*x + y*y);
} // Vec2D(double, double)
```

Unfortunately, Java will not permit you to write two constructors that take identical types as parameters. After all, if the constructors have the same names and the same types, Java will be unable to tell which one you mean. What is the alternative? We can create a special method that builds the vector (which we describe below) or we can choose different parameter types.

```
/**
 * Create a new vector from (0,0) to (x,y).
 */
public Vec2D(int x, int y)
{
  this.theta = Math.atan(((double) y)/((double) x));
  this.radius = Math.sqrt(x*x + y*y);
} // Vec2D(int, int)
```

## Object methods

Finally, we're ready to consider the methods of the class. Object methods look much like static methods, except that (a) they do not require the keyword static and (b) they can refer to the fields of the class.

The general form of an object method is

```java
/**
 * Helpful introductory comment.
 */
protection Type methodName(parameters) optionalThrowsClause {
  body;
} // methodName(parameterTypes)
```

Calling a method is fairly simple: You write the name of the object (that you've already constructed), followed by the name of the method, followed by parameters. For example,

```java
pen.println("Hi!");
```

or

```
Vec2D newvec = alpha.add(northeast);
```

### Example: Some methods for 2D vectors

The simplest methods that we can call are the methods that extract simple information from an object. Such methods are typically called “observers” or, when the extracted information matches a field, “getters”. Here's one that gets the radius.

```java
/**
 * Determine the radius of this vector.
 */
public double getRadius() {
  return this.radius;
} // getRadius()
```

Similarly, here's one that gets the angle from the positive x axis.

```java
/**
 * Determine the angle of this vector from the positive x axis.
 */
public double getTheta() {
  return this.theta;
} // getTheta()
```

Here's a silly program fragment that uses those two methods.

```java
int x = ...;
int y = ...;
Vec2D sample = new Vec2D(x,y);
pen.println("Info about the point "(" + x + "," + y + ")");
pen.println("  That point is " + sample.getRadius()
            + " units from the origin.");
pen.println("  The angle between the X-axis and the line to that point is "
            + sample.getTheta());
```

We can certainly write methods that compute new values, too.

```java
/**
 * Compute the x position of the head of this vector.
 */
public double getX() {
  return this.radius * Math.cos(this.theta);
} // getX()
```

We can even write methods that build new objects.

```java
/**
 * Create a new vector that is twice as long as this vector.
 */
public Vec2D double() {
  return new Vec2D(this.getTheta(), this.getRadius()*2);
} // double
```

Given that we can build new objects, we might even write static methods that act very much like constructors. (As mentioned above, this approach is one of the ways we can deal with wanting multiple constructors that have the same parameter types.)

```java
/**
 * Build a vector to the point (x,y)
 * @pre
 *   x != 0
 */
public static Vec2D vectorTo(double x, double y) {
  return new Vec2D(Math.atan(y/x), Math.sqrt(x*x + y*y));
} // vectorTo(double,double)
```

We can even use these techniques to write a method that uses the current information and constructor-like methods to build new objects.

```java
/**
 * Add another vector to this vector.
 */
public Vec2D add(Vec2D addend) {
  return Vec2D.vectorTo((this.getX() + addend.getX()),
                        (this.getY() + addend.getY()));
} // add(Vec2D)
```

You may have noted that we didn't write any mutators. While mutators are useful and necessary in many situations, for types like vectors we often find it more useful to build immutable values that retain their values.

Self checks
-----------

### Self check 1: Static vs object methods (‡)

a. Write a *static* method, `Vec2D double(Vec2D v)`, the builds and returns a new `Vec2D` that is twice as long as `v`. (You should not use the `double()` method we described above.)

b. Suppose `vee` is a 2D vector created as follows.

```
  Vec2D vee = new Vec2D(Math.pi/3, 1);
```

i. How do we create something twice as long as `vee` using the static `double` method?

ii. How do we create something twice as long as `vee` using the object method from the text?

c. What do you see as the advantages of each approach to writing `double`? Why might we decide to make it an object method? Why might we decide to make it a static method?

### Self check 2: Close reading

a. There's an error in `vectorTo` that will cause it to crash in certain situations. In what situations might it crash?

b. Rewrite `vectorTo` to resolve that issue.
