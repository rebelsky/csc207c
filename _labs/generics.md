---
title: Java generics
repo: <https://github.com/Grinnell-CSC207/lab-generics-maven>
summary: |
  We explore some basic use of generic types in Java.
prereqs: |
  Classes and interfaces.
---

Preparation
-----------

a. Fork and clone the repository at {{ page.repo }}. When cloning, make sure to use the SSH link.

b. Import the repository into VSCode.

c. Update the `README.md` file to add your names. (Ideally, you'd also update 
the .java files to add your names.)

d. Commit and push the updated files.

```
$ git add README.md
$ git add src/main/java/edu/grinnell/csc207/util/*.java
$ git add src/main/java/edu/grinnell/csc207/experiments/*.java
$ git commit -m "Add our names to the appropriate files."
$ git push
```

e. Open up the lab writeup on Gradescope. You should fill out the writeup as you go.

f. Grab a whiteboard and marker (or piece of paper and writing utensil).

Exercises
---------

For reference: The partner closest to the board is **A**. The partner furthest from the board is **B**.

### Exercise 1: Simple dynamic arrays

_Driver: **A**_

The [reading on generics](../readings/generics.html) shows how we build a generic "dynamic array" class.  You'll find that generic class in the repository for this lab.

a. Read through `SimpleDynamicArrayExperiments.java` and predict what the output will be. You should write your answer on the whiteboard or piece of paper.

b. Compile and run `SimpleDynamicArrayExperiments.java` to see what the output is. You can use VSCode (easy) or you can copy and paste the following commands (differently easy).

```
mvn compile -q
java -cp target/classes edu.grinnell.csc207.experiments.SimpleDynamicArrayExperiments
```

c. `SimpleDynamicArray` is supposed to expand the array when you set a value larger than the size.  Do you expect it to do so for this example?

d.  Within the portion of the `set` method of `SimpleDynamicArray` that expands the array, add a call to `System.err.println` so that you can tell when the array expands.

e. Create a dynamic array of strings, assign some values to it, and print them out.  Here's a start.

```java
  DynamicArray<String> strings = new SimpleDynamicArray<String>();
  ... // code to put values in the array
  for (int i = 0; i < 10; i++) {
    pen.println("strings[" + i + "] = " + strings.get(i));
  } // for
```

f. What do you expect to happen if you assign a string to an element of `numbers` or a number to an element of `strings`??

g. Check your answer experimentally.

h. What do you expect to happen if we leave out the type when we construct `numbers`, as in the following?

```java
  DynamicArray<BigInteger> numbers = new SimpleDynamicArray();
```

i. Check your answer experimentally.

j. What do you expect to happen if we leave out the type when we declare `strings`, as in the following?

```
  DynamicArray strings = new SimpleDynamicArray<String>();
```

k. Check your answer experimentally.

l. What do you expect to happen if we leave out the type on both sides of the declaration, as in the following?

```
  DynamicArray strings = new SimpleDynamicArray();
```

m. Check your answer experimentally.

n. Restore your code to working order. You should also comment out the `System.err.println` statement.

o. Commit your changes.

```
git add src/main/java/edu/grinnell/csc207/experiments/SimpleDynamicArrayExperiments.java
git add src/main/java/edu/grinnell/csc207/util/SimpleDynamicArray.java
git commit -m "Complete work from exercise 1."
git push
```

p. Summarize what you've learned in these exercises.

### Exercise 2: Searching

_Driver: **B**_

The [reading on generics](../readings/generics.html) shows how we build a generic search method.  You'll find that code in the repository.

a. Read through `SearchExperiments.java` and predict what the output will be. Record your predications in Gradescope.

b. Compile and run `SearchExperiment.java` to see what the output is. Once again, you may want to run the program in VSCode (easy) or you may want to type the following (differently easy).

```
mvn compile -q
java -cp target/classes edu.grinnell.csc207.experiments.SearchExperiments
```

d. What do you expect to happen if you try to search `strings` with `OddInteger.PRED` or `numbers` with `SmallString.PRED`?

e. Check your answer experimentally. If necessary, restore your code to working order afterwards.

f. What do you expect to happen if we try to generalize the declaration of `strings`, as in the following?

```java
    Object[] strings = new Object[] { ... };
```

g. Check your answer experimentally. If necessary, restore your code to working order afterwards.

h. Create a new `SmallObject` predicate whose `hold` method takes an object as a parameter, converts it to a string, and sees if that string has fewer than five characters.  Do you expect that new predicate to work with the updated `strings`?

i. Check your answer experimentally. If necessary, restore your code to working order afterwards.
 
j. Commit your changes.

```
git add src/main/java/edu/grinnell/csc207/util/predicates/SmallObject.java
git commit -m "Add SmallObject predicate.."
git add src/main/java/edu/grinnell/csc207/experiments/SearchExperiments.java
git commit -m "Complete work from exercise 2."
git push
```

k. Summarize what you've learned in these exercises.

### Exercise 3: Predicates

_Driver: **A**_

a. What do you expect to happen if we restore the original declaration of `strings` and use the new comparator we just developed?

```java
    String[] strings = new String[] { ... };
    pen.println("A small string: " + SearchUtils.search(strings, SmallObject.PRED));
```

b. Check your answer experimentally. If necessary, restore your code to working order afterwards.


c. What do you expect to happen if we use the new `SmallObject.PRED` predicate to search `numbers`?

```java
    pen.println("A small integer: " + SearchUtils.search(numbers, SmallObject.PRED));
```

d. Check your answer experimentally. If necessary, restore your code to working order afterwards.


e. Commit your changes.

```
git add src/main/java/edu/grinnell/csc207/experiments/SearchExperiments.java
git commit -m "Complete work from exercise 3."
git push
```

f. Summarize what you've learned in this exercise.

### Exercise 4: Boxes

_Driver: **B**_

As you've noted, when two variables refer to the same mutable object, we can change the object through one variable and see the effect through the other variable.  At times, that effect is undesirable, but at others it is desirable.

However, if the two variables refer to the same immutable object, such as a string, we can't propagate the change to one variable to the other variable.  The typical solution to this problem is to have what is typically called a "box".  You can set the value in a box or get the value in a box. (Note that this box is unrelated to the box from our AsciiArt exapmle.)

```java
    Box<String> s1 = new Box<String>("Hello");
    Box<String> s2 = new Box<String>("Hello");
    Box<String> s3 = s1;
    pen.println(s1.get());        // Prints "Hello"
    pen.println(s2.get());        // Prints "Hello"
    pen.println(s3.get());        // Prints "Hello"
    s1.set("Goodbye");
    pen.println(s1.get());        // Prints "Goodbye"
    pen.println(s2.get());        // Prints "Hello"
    pen.println(s3.get());        // Prints "Goodbye"
    s3.set("Whatever");
    pen.println(s1.get());        // Prints "Whatever"
    pen.println(s2.get());        // Prints "Hello"
    pen.println(s3.get());        // Prints "Whatever"
  
    Box<Integer> i1 = new Box<Integer>(42);
    Box<Integer> i2 = i1;
    pen.println(i2.get() + 3);          // Prints 45
    i2.set(21);
    pen.println(i1.get() * 2);          // Prints 42
```

a. Explain what these experiments are supposed to illustrate. (Answer the question on Gradescope.)

b. Implement `Box` using generics. You should include 

* a constructor that sets the initial value; 
* a mutator, `set`, that changes the value; and 
* an observer, `get`, that extracts the value.

In case it wasn't clear, `Box` belongs in package `edu.grinnell.csc207.util`.

c. Put the code from above in a `BoxExperiments` class and ensure that it works as expected.

In case it wasn't clear, `BoxExperiments` belongs in package `edu.grinnell.csc207.experiments`.

d. Commit and push your work.

```
git add src/main/java/edu/grinnell/csc207/util/Box.java
git add src/main/java/edu/grinnell/csc207/experiments/BoxExperiments.java
git commit -m "Add new 'Box' class (and some experiments)."
git push
```

Submitting your work
--------------------

Submit the URL of your GitHub repo as well as your answers to questions above on Gradescope.

For those with extra time
-------------------------

Finish the following alternate implementation of `DynamicArray`. You'll need to look up Java vectors.

```java
public class VectorBasedDynamicArray {
  Vector<T> values;
  ...
} // class VectorBasedDynamicArray
```

