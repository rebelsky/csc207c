---
title: Standard object methods
link: true
---
_Summarye: We consider the standard methods that all (or most) objects provide.

_Prerequisites_: [Basics of Java](intro-java), [Classes and objects](writing-classes).

## Introduction

In Java, all template classes provide a variety of standard methods. By standard method, I mean that it is a standard that you include the method. You may have already encountered one such method, toString.

Why does Java have standard methods? Because programmers benefit from knowing that certain methods are there. For example, you can easily convert any object to a string with the toString method, and you don't even have to bother to look it up. Similarly, you can compare any two objects in the same class for equality with the equals method.

Java has a few groups of standard methods. Some must be there for every class. These methods include toString and equals. Others you may choose whether or not to include, and you specify in an interesting way that you have included them. These methods include clone and compareTo.

What happens if you don't write the simplest standard methods? Java supplies its own, and they don't always work the way you would expect them to work.

## A `Fraction` class

Here's a simple `Fraction` class that we'll be using for this example.

```java
/**
 * Simple fractions.
 */
public class Fraction {
  // +--------+---------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. */
  int numerator;

  /** The denominator of the fraction.  This should be a positive number.  */
  int denominator;

  // +--------------+---------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build the fraction _numerator/_denominator.
   */
  public Fraction(int _numerator, int _denominator) throws Exception {
    if (_denominator == 0) {
      this.numerator = Integer.MAX_VALUE;
      this.denominator = 1;
    } else if (_denominator < 0) {
      this.numerator = -_numerator;
      this.denominator = -_denominator;
    } else {
      this.numerator = _numerator;
      this.denominator = _denominator;
    }
  } // Fraction(int, int)

  /**
   * Convert an integer to a fraction.
   */
  public Fraction(int value) {
    this.numerator = value;
    this.denominator = 1;
  } // Fraction(in)

  // +---------+--------------------------------------------------------
  // | Methods |
  // +---------+

  // ...

} // class Fraction
```

## Converting to human-readable form with the `toString` method

One of the simplest methods that most classes provide is the toString method, which has the signature `public String toString()`.

As the name of the method suggests, this method converts the object to a string. Why would we want to convert an object to a string? Most typically, so that we can print the object (to the screen, to a file, perhaps even to a dialog box).

The `toString` method is so fundamental that Java uses it implicitly in a number of cases. For example, whenever you try to print an object, Java calls the `toString` method, even if you haven't explicitly listed it in your call. Similarly, if you try too concatenate another object with a string using the + operation, Java converts the object to a string using the `toString` method.

What happens when you don't write the `toString` method? Java supplies a default version that prints the class of the object followed by some other value (which may be the address of the object in memory). Yes, it's a strange default, but it's about as good as anything.

### Example: `Fraction.toString`

Here's a sample `toString` method for our `Fraction` class.

```java
  public String toString() {
    return this.numerator + "/" + this.denominator;
  } // toString()
```

## Comparing values with the `equals` method

Another simple standard method is equals, which you use to determine whether one object is “naturally” the same as another object. You first have a responsibility to determine what “naturally” means. For example, are two decimal numbers the same if they are not precisely equal? Are two fractions the same if one is simplified and one is not? Are two vectors in two-space the same if one has an angle of 360 degrees more than the other? Are two vectors in two-space the same if they have the same radius, and their angles differ by a very small amount (less than 1/1000 of a degree)? It's up to you. But once you've made your decision, document it well.

The standard signature for the `equals` method is `public boolean equals(Object other)`.

Note that it is somewhat difficult to compare an object in a specific class to a more general object. So, what do you do? My standard solution is to provide a second form of equals that takes the specific kind of object as a parameter, and then, in the first equals, call the second while casting the object to that type. (Recall that you cast a value to another type by prefacing the name of the value with the name of the type in parentheses.)

### Example: `Fraction.equals`

For example, in a `Fraction` class, we might write

```java
/**
 * Compare this fraction to another fraction.  They are the same
 * if they have the same numerator and denominator.
 */
public boolean equals(Fraction other) {
  return this.numerator.equals(other.numerator)
      && this.denominator.equals(other.denominator);
} // equals(Fraction)

/**
 * Compare this fraction to another object.  The two are only
 * equal if they are both fractions and have the same numerator
 * and denominator.
 */
public boolean equals(Object other) {
  if (other instanceof Fraction) {
    return this.equals((Fraction) other);
  } // if (other is a Fraction)
  else {
    return false;
  } // if (other is not a Fraction)
} // equals(Object)
```

Of course, you might express that more concisely as follows.

```java
public booleans equals(Object other) {
  return (other instanceof Fraction) && this.equals((Fraction) other);
} // equals(Object)
```

At some point, you should consider comparing fractions to other numeric types.

### More about `equals`

If you don't bother to write `equals`, Java provides a default version that returns true only if the two values share the same memory locations.

Once you start writing your own `equals` methods, you should make sure that you understand [the specifications for equals]({{ site.java_api }}/java/lang/Object.html#equals(java.lang.Object)).

## Comparing objects with `compareTo`

The `equals` method provides the simplest form of comparison. At times, we need more complex comparison, such as when we want to put a sequence of values in order from smallest to largest. For such situations, objects may (but need not) provide the `compareTo` method.

This method has the signature `public int compareTo(Class other)`, where `Class` is typically the class you're defining. For example, in a `Fraction` class, we would write

```java
public int compareTo(Fraction other) {
  ...
} // compareTo(Fraction)
```

The `this.compareTo(other)` method returns

* a negative number, if `this` naturally precedes `other`;
* zero, if `this.equals(other)`;
* a positive number, if `other` naturally precedes `this`.

How should you decide if one object "naturally precedes" another? Once again, that's up to you. What if you can't choose such a relationship? Then you shouldn't bother implementing `compareTo`. What if there are many possible relationships, as in the case of of students, who you might compare by name, by age, by student ID, by height, by GPA, or by something completely different? Then you can either pick one as a default or decide that by default, students are not comparable. In a subsequent reading, we'll consider how to support multiple kinds of comparisons.

The ordering given by `compareTo` should be transitive and reflexive. When we say that it is transitive, we mean that if `a.compareTo(b)` returns a negative number and `b.compareTo(c)` returns a negative number, then `a.compareTo(c)` should also return a negative number. (We can say something similar when it reutrns positive numbers.) When we say that it is reflexive, we mean that if `a.compareTo(b)` returns a negative number, then `b.compareTo(a)` should return a positive number (and vice versa).

Because this standard method is not always implementable (that is, there is sometimes no natural ordering), you need not include it. If you do you should add the following line to the header of your class

```java
  implements Comparable<Class>
```

You must also import `java.util.Comparable`.

For example,

```java
import java.util.Comparable;

public class Fraction implements Comparable<Fraction> {
  // ...
  public int compareTo(Fraction other) {
    // ...
  } // compareTo(Fraction)
  // ...
} // class Fraction
```

Note that for the `compareTo` method, you need not follow the "two method" strategy that you had to use in equals. Only one `compareTo`, which compares to objects in the same class, is all that is necessary.

## Copying objects with the `clone` Method

At times, you have one copy of an object and you need another copy. For example, you may have created a `StringBuffer` and want to keep the original and make a copy that you will modify. To support such situations, Java encourages you to provide a method called `clone`.

The signature of this method is `public Object clone()`. You may find it strange that `clone` returns an `Object` rather than explicitly returning a member of the specified class. This form of return was all that was supported in an early version of Java (that is, there was no way to have multiple methods with the same name and parameter types, but different return types), and it seems to have been retained.

### Example: Cloning fractions

Here's a simple `clone` method for our `Fraction` class.

```java
  public Fraction clone() {
    return new Fraction(this.numerator, this denominator);
  } // clone()
```

### Using `clone`

Because `clone` returns an object, you need to cast the return value. For example, the Java compiler will complain about the following code.

```java
Fraction frac2 = frac1.clone();
```

Instead, you must write:

```java
Fraction frac2 = (Fraction) frac1.clone();
```

### More about cloning

Although `clone` is a standard method, it is also optional. If you supply the method, you should indicate that your class implements `Cloneable`. For example,

```java
public class Fraction implements Cloneable, Comparable<Fraction> {
  // ...
} // class Fraction
```

## The mysterious `hashCode` method

The last of the standard methods is somewhat strange. The `hashCode` method returns "some integer that represents this object". What integer should you return? It's up to you. However, there are two rules you should follow:

* Two objects that are equal (according to the `equals` method) should have the same value returned by `hashCode`.
* Two objects that are not equal should be unlikely to have the same number.

Of course, it is impossible to guarantee that unequal objects have different numbers, since there are typically more objects than there are integers. You should simply _try_ to give unequal objects different numbers.

Why does Java include the `hashCode` method as a standard method? That method is very useful for hash tables, which we will consider later in the semester. (The designers of Java made some strange decisions as to what to make default. Some folks find this one of the stranger ones.)

Do you have to write the `hashCode` method? It's not a bad idea. The Java standard suggests that if you write `equals`, then you must write `hashCode`.

What is the default behavior of `hashCode`? By default `hashCode` returns some value computed from the memory location of the object. Hence, two equal values are unlikely to have the same hash code unless you write the method.

And yes, it's okay if your method is relatively naive, provided you make some attempt to provide different numbers when values are different. For example, the following would be acceptable for the Fraction class, assuming that you either decided that (a) fractions are stored in simplified form or (b) fractions with different numerators are different. (And yes, this method does create lots of duplicate hash codes.)

```java
public int hashCode() {
  return 11 * this.numerator() + 17 * this.denominator();
} // hashCode()
```

We will return to the computation of hash codes when we explore hash tables.

Wrapping up
-----------

Important methods

* `String toString()`
* `boolean equals(Object other)`
* `int compareTo(Type other)`
* `int hashCode()`
