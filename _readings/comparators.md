---
title: Comparators
summary: |
  We consider a standard "functional" interface, comparators. Comparators
  are objects that are used to compare other objects for their order,
  generalizing notions like "less than" and "greater than".
---
_This reading was newly written in Fall 2024 and may have infelicities. Please let SamR know if you find any._

As we've seen in our initial exploration of priority queues, if a priority queue is to order elements by priority, it needs a way to compare them by priority. In a functional language, like Scheme, we could have a procedure, `higherPriority?`, that takes two values as parameters and determines if the first is higher priority than the second.

However, functions are not first-class values in Java. Hence, instead of a function that compares two values, we should create objects that have one method that we use to compare to objects. In Java, those objects are in class `Comparator<T>` (or, more precisely, `java.util.Comparator<T>`) and the one method they provide is called `int compare(T val1, T val2)`.

You'll note that `compare` returns an integer, rather than a Boolean. That's because `compare` follows the model of `strcmp` from C. That is, it should return 

* _a negative number_, if `val1` is less than (or higher priority than) `val2`;
* _zero_, if `val1` is equal to (same priority as) `val2`; and
* _a positive number_, if `val2` is greater than (or lower priority than) `val2`.

For example, here's a comparator for `Integer` values that compares values based on their absolute value.

```java
class AbsoluteValueComparator implements Comparator<Integer> {
  public int compare(Integer i1, Integer i2) {
    int abs1 = Math.abs(i1.intValue());
    int abs2 = Math.abs(i2.intValue());
    if (abs1 < abs2) {
      return -1;
    } else if (abs1 == abs2) {
      return 0;
    } else {
      return 1;
    } // if else
  } // compare(Integer, Integer)
} // class AbsoluteValueComparator
```

We might use, say, this to sort an array of `Integer` values with

```java
    Arrays.sort(vals, new AbsoluteValueComparator());
```

or, in a slightly more extensive program,

```java
/**
 * Fun with sorting.
 */
public class SortFun {
  /**
   * Sort all the integers on the command line.
   *
   * @param args
   *   Command-line arguments (the values to sort).
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    Integer[] vals = new Integer[args.length];
    for (int i = 0; i < args.length; i++) {
      vals[i] = Integer.valueOf(args[i]);
    } // for
    pen.print(Arrays.toString(vals));
    pen.print(" -> ");
    pen.flush();
    Arrays.sort(vals, new AbsoluteValueComparator());
    pen.println(Arrays.toString(vals));
    pen.close();
  } // main(String[])
} // class SortFun
```

Of course, many programmers (or at least many C programmers) would write a much more concise `compare` method if they were comparing for absolute value.


```java
class AbsoluteValueComparator2 implements Comparator<Integer> {
  public int compare(Integer i1, Integer i2) {
    return Math.abs(i1.intValue()) - Math.abs(i2.intValue());
  } // compare(Integer, Integer)
} // class AbsoluteValueComparator2
```

The ability to write methods like this is one of the reasons that the specifications for `compare` only indicate that it returns _a negative number_ if the first one is smaller (comes first) and _a positive number_ if the second is smaller (comes first).

## Anonymous comparators with anonymous inner classes

Now that you've started to think about anonymous inner classes, you have no doubt realized that it may not be worth it to define a full `AbsoluteValueComparator2` class. Rather, we could just create a new class "on the fly" when sorting. That way, we don't need to write as much.

```java
    Arrays.sort(vals, new Comparator<Integer>() {
      public int compare(Integer i1, Integer i2) {
        return Math.abs(i1.intValue()) - Math.abs(i2.intValue());
      } // compare(Integer, Integer)
    });
```

## Anonymous comparators with lambdas

At some point, the designers of Java realized the benefits of ideas from functional programming languages like Scheme. (It helps that Guy Steele, one of the designers of Scheme, is also a lead designers on Java.) And those designers came up with an interesting idea for handling functions as first-class values in an object-oriented language when the language is not designed to do such.

Any interface that specifies only a single function for objects that implement that interface is called a "functional interface". And, just as you can write a function using lambdas, you can create an object in a class that implements a functional interface with Java's version of lambda.

What does Java's version of lambda look like?

A pair of parens with parameters inside. An arrow (`->`). The "body" of the method (enclosed in braces if it requires multiple steps; skipping the braces if it doesn't). That's it.

For example, here's a lambda expression that is equivalent to the comparator above.

```java
(i1,i2) -> Math.abs(i1.intValue()) - Math.abs(i2.intValue())
```

And here's it's use in sorting.

```java
    Arrays.sort(vals,
        (i1,i2) -> Math.abs(i1.intValue()) - Math.abs(i2.intValue()));
```

"Wait!", you may say, "Where do I specify the interface we're implementing or the name of the method or the parameter types or ..."?

We don't need the name of the method. There's only one method in a functional interface. We don't need the name of the interface because the Java compiler can figure it out from context. And we don't need the parameter types because the Java compiler can figure them out from context.

Isn't that cool?

Now, it does take a bit to get used to reading and writing Java's lambdas. Once you do, you'll find them invaluable in a wide variety of circumstances.

## Other functional interfaces

Can we use lambdas to write iterators? Unfortunately, no. `Iterator` is not a functional interface because it includes three methods, not one.

However, there are other functional interfaces. JUnit 5 includes an `Executable` interface that specivies one method, `void execute() throws Exception`. Seems kind of boring, doesn't it? But it ends up being very nice for writing tests when we want to check whether code throws an exception. Up to now, we've been writing something like this.

```java
    try {
      codeWeExpectToThrowAnException();
      fail("Whoops, the exception wasn't thrown");
    } catch (ExpectedExceptionType e) {
      // Do nothing
    } // try/catch
```

A bit verbose, but it gets the job done.

Now that we understand lambdas and the `Executable` interface, we can rely on a `assertThrows` method.

```java
    assertThrows(ExpectedExceptionType, 
      () -> codeWeExpectToThrowAnException(),
      message);
```

We do we need the lambda? Because the normal method call mechanism in Java insists that it exececute all of the parameters to a method before calling a method. In this case, the lambda builds an object, but does not execute the method in the object. That's left to `assertThrows`. 

Another important functional interface is, of course, `Function` (or, more precisely, `java.util.function.Function<T,R>`), which can be used to discuss functions from values of type `T` to values of type `R`.

There's a lot more to learn about functions in Java and about thinking with functions. Unfortunately, most of that is out of the scope of the course. For now, we'll focus on comparators.

## Wrapping up

What should you take from all this?

1\. `java.util.Comparator` is an interface we will use in many situations, including building priority queues and sorting.

2\. `Comparator<T>` objects provide one method, `compare(T val1, T val2)`.

3\. `compare` should return a negative number if the first val comes first / is smaller, zero if the two are equal, and a positive number if the first val comes second / is larger.

4\. Although some implementations of `compare` always return -1 for the first case and 1 for the third case, not all do. If you use comparators in your code, make sure not to assume the -1/0/1 results.

5\. We will often write comparators using lambda expressions.
