---
title: Designing your own classes
summary: |
  In this laboratory, you will extend your knowledge of numeric
  values in Java.  You'll also explore the creation of classes
  in Java.
javadoc:
  - "[`java.lang.Integer`]({{ site.java_api }}/java/lang/Integer.html)"
  - "[`java.lang.String`]({{ site.java_api }}/java/lang/String.html)"
  - "[`java.math.BigInteger`]({{ site.java_api }}/java/math/BigInteger.html)"
todo: 
  - Add a few examples in which they learn about static access to
    fields (or fail to access those fields).  Maybe something as
    simple as giving them a procedure.
---

Useful documentation:
---------------------

* [`java.lang.Integer`]({{ site.java_api }}/java/lang/Integer.html)
* [`java.lang.String`]({{ site.java_api }}/java/lang/String.html)
* [`java.math.BigInteger`]({{ site.java_api }}/java/math/BigInteger.html)

Preparation
-----------

a. Fork and clone the repository at <https://github.com/Grinnell-CSC207/lab-intro-classes-maven>. When cloning, make sure to use the SSH link and not the HTTP link.

b. Read through the code to make sure that you have a sense as to what it does and what parts there are.  You don't need to know or understand all of the details, but a big-picture view will be helpful.

c. Make sure to put your name at the top of each `.java` file where it says "YOUR NAME HERE". 

d. Add your name to the `README.md` file.

e. Add the URL of your repository to the `README.md` file.

f. In your Web browser, load the documentation for the three standard classes we'll be using (links above).

g. Compile and run the experiment (either in VSCode or on the command line). The Maven commands would be.

```
mvn clean -q
mvn compile -q
mvn package -q
mvn exec:java -q
```

Exercises
---------

### Exercise 1: Multiplication

a. Extend the `BigFraction` class so that it permits multiplication of two fractions.  That is, you should add an appropriate `multiply` method to the class.

b. Write an experiment that allows you to explore the behavior of the new method.  (The experiment is simply code in `BFExperiment.java` that shows what happens when you multiply two numbers.)

### Exercise 2: Fractional portions

As you may know, we can represent every non-negative rational number as a whole number plus a fractional value no smaller than 0 and strictly less than 1.

a. Write a method of the `BigFraction` class, `fractional`, that identifies and returns this fractional value as a `BigFraction`.  Your procedure need only work for positive numbers.  

Here are some examples that illustrate what it's supposed to do.

```java
  BigFraction f;

  f = new BigFraction(11,3);
  pen.println(f.fractional());  // 2/3

  f = new BigFraction(1,2);
  pen.println(f.fractional());  // 1/2

  f = new BigFraction(5,2);
  pen.println(f.fractional());  // 1/2

  f = new BigFraction(4,2);
  pen.println(f.fractional());  // 0/2 or 0
```

b. Check/test your procedure and correct any errors.

### Exercise 3: A command-line tool

_There is nothing to turn in for this exercise.  It simply serves to get you thinking about the code._

The `BFSum` class is intended to provide a simple command-line tool for adding fractions.  It also provides a nice way to test the not-yet-implemented "build a fraction from a string" constructor.  Read through the code and take notes to yourself as to what `main` does.

a. Compile `BFSum.java`.

b. What do you expect to get as output if we type the following on the command line? 

```
java -cp target/intro-classes-1.0.jar edu.grinnell.csc207.experiments.BFSum 2/7
```

c. Check your answer experimentally.

d. What do you expect to get as output if we type the following on the command line?

```
java -cp target/intro-classes-1.0.jar edu.grinnell.csc207.experiments.BFSum 1/2 1/3 1/7
```

e. Check you answer experimentally.

f. What do you expect to get as output if we type the following on the command line?

```
java -cp target/intro-classes-1.0.jar edu.grinnell.csc207.experiments.BFSum
```

g. Check your answer experimentally.

### Exercise 4: From string to fraction

Write and check/test a third constructor for the `BigFraction` class.  This constructor should accept a string as a parameter, parse that string, and generate the appropriate fraction.  For example,

```java
  BigFraction f;
  f = new BigFraction("1/4");
  pen.println(f.numerator());   // 1
  pen.println(f.denominator()); // 4
  f = new BigFraction("11/5");
  pen.println(f.numerator());   // 11
  pen.println(f.denominator()); // 5
  f = new BigFraction("120/3");
  pen.println(f.doubleValue()); // Approximately 40
```

You can expect that the string will have two positive integers separated by a slash.  You may find it useful to reflect on the `indexOf` method of the `java.lang.String` class and on various static methods of the `java.lang.Integer` class.

### Exercise 5: A counter class

Write and experiment with a class, `Counter`, that generates objects that can count.  Objects in class `Counter` should provide two methods: `increment`, which adds 1 to the counter, and `get`, which gets the current value of the counter.  Your class needs one zeroary constructor which initializes the counter to 0.

Make sure to verify that if you create two separate `Counter` objects, you can change the two objects separately.

### Exercise 6: Printing counters

a. If you've included a `toString` method in `Counter`, comment it out.

b. What do you expect to happen if we print out a `Counter` using instructions like the following?

```
  PrintWriter pen = new PrintWriter(System.out, true);
  Counter c1 = new Counter();
  Counter c2 = new Counter();
  c1.increment();
  c1.increment();
  c2.increment();
  pen.println("c1: " + c1);
  pen.println("c2: " + c2);
```

c. Check your answer experimentally.

d. As you should have discovered, when a class lacks a `toString` method, Java chooses a fairly naive representation for printing objects in that class.  Add an appropriate `toString` method (e.g., one that returns the counter surrounded by angle brackets).  Then verify that the lines above work as you expect.

### Exercise 7: Enhancing counters

a. Update your `Counter` class to include a second constructor that allows the user to specify a starting value.

b. Update your `Counter` class to include a `reset` method that reset the counter to the starting value.

c. Test (or experiment with) both updates to ensure that they work appropriately.

Submitting your work
--------------------

a. Update the `README.md` file to indicate how far you got. You may also add some comments and questions.

b. Commit your changes and push to your repo.

c. Upload your repo to Gradescope.

d. Make sure to provide your partner with the URL of your repo.

For those with extra time
-------------------------

### Extra 1: Simplifying fractions

Update the `BigFraction` class so that we simplify each fraction when we create it.  In case you've forgotten, the simplified version of a fraction has a numerator and denominator with a greatest common divisor of 1; you can create the simplified version by finding the gcd and dividing both numerator and denominator by that gcd.

### Extra 2: Further enhancing counters

Identify other methods that would be useful to include in the `Counter` class and add them.

### Extra 3: Further enhancing fractions

Identify other methods that would be useful to include in the `Fraction` class and add them.

