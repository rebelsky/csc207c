---
title: Getting started with Java
summary: |
  In this lab, you'll explore some basics of Java programming using
  commands in the shell.  (We'll soon switch to the VSCode IDE.)
copyright:  Copyright &copy; Peter-Michael Osera and Samuel A. Rebelsky.
copyright_message: |
  This work is licensed under a Creative Commons Attribution-NonCommercial
  4.0 International License.  To view a copy of this license, visit
  <http://creativecommons.org/licenses/by-nc/4.0/>.
link: true
---

In the spirit of one of the meta-learning goals of the course, we'll use these first weeks not just to learn the Java programming language but also the refine our skills at *learning new programming languages*.  The jump from C to Java is no where near as dramatic as the jump from Racket to C, so we can use this opportunity to develop some best practices for migrating from language to language whether it's from Java to C#, Java to Python, or to some more exotic languages.

## Exercise 0: Preparation

We'll be using Java 17 in this course.  Java 17 may not be the default
Java, so we will check.

a. Open a terminal window.

b. Type `java --version`.

If you see something like the following (using a 17 as the version),
skip ahead to Part 1.

```
$ java --version
openjdk 17.0.12 2024-07-16
OpenJDK Runtime Environment (build 17.0.12+7-Debian-2deb12u1)
OpenJDK 64-Bit Server VM (build 17.0.12+7-Debian-2deb12u1, mixed mode, sharing)
```

If not, continue.

c. Type `which java`.  You should see something like the following

```
$ which java
/usr/bin/java
```

d. Edit the file `~/.bashrc` (aka `/home/username/.bashrc`) and add
the following line to the end.

```text
export PATH=/usr/lib/jvm/java-17-openjdk-amd64/bin:$PATH
```

e. In the terminal window, type `source ~/.bashrc`.  This reloads your updated .bashrc file.

f. In the terminal window, type `which java` again.  This time, you should see something like the following.

```
$ which java
/usr/lib/jvm/java-17-openjdk-amd64/bin/java
```

g. In the terminal window, type `java --version`.    You should see something like the following.

```
$ java --version
openjdk 17.0.12 2024-07-16
OpenJDK Runtime Environment (build 17.0.12+7-Debian-2deb12u1)
OpenJDK 64-Bit Server VM (build 17.0.12+7-Debian-2deb12u1, mixed mode, sharing)
```

## Background: Basic compilation pipeline

When learning a new programming language, our first concern before
worrying about how the programming language operates, *i.e.*, its
*semantics*, is how to get stuff to appear on the screen---anything!
Imagine the computer program development process as a *pipeline*,
a series of steps where the end result is a computer program.  For
Racket, the pipeline was very straightforward:

```text
Type definitions        Use those definitions
into DrRacket's   --->  by typing expressions
definitions pane        into DrRacket's
                        interactions pane
```

which is part of the reason we choose Racket/Scheme for CSC 151!
C is a little bit more involved.  In it's simplest version, the
C workflow is as follows.

```text
Write complete        Compile the        Run the
C programs in   --->  program      --->  program
a text file           using gcc
```

More frequently, we include at least one other step.

```text
Write parts of        Compile the        Link the            Run the 
C program in    --->  parts to .o  --->  parts and any --->  program
text files            with gcc           libraries
```

C doesn't have an interactive environment (commonly known as a
*REPL* or a read-eval print loop) to try our C commands or expressions.
Instead, we must write complete programs, compile them using a
*compiler*, and run the resulting executable.

You may have recalled initially having difficult getting a program
to work because you messed up one of these steps---for example,
getting the syntax of a complete program wrong, not having your
source files in the correct place, or invoking `gcc` with the wrong
parameters.  But once you had that template of a basic program and
the series of commands you needed to invoke, you were set!

Being a descendent of C, Java's pipeline is nearly identical to the
basic C pipeline.

```text
Write complete          Compile the        Run the
Java programs in  --->  program      --->  program
a text file             using javac        using java
```

In fact, rather than using `gcc`, you simply use the `javac` program instead which compiles Java programs.  However, unlike `gcc`, the `javac` program produces a *Java class file* as output, a file with a `.class` extension.  This is not a standalone program like what `gcc` produces.  It is a file that contains *Java bytecode* which is your code in a low-level form that the *Java virtual machine* can execute.  The Java virtual machine is located in the `java` program which we can point at a `.class` file to run it.  For example, here is an example workflow for compiling at running the canonical "Hello World!" program:

```
$> ls
HelloWorld.java
$> javac HelloWorld.java
$> ls
HelloWorld.class        HelloWorld.java
$> java HelloWorld
Hello World!
```

Note that when passing the `.class` file to the `java` program, you do not specify the extension.  `java` looks for a file called `HelloWorld.class` for you!

## Exercises

### Exercise 1: Hello World

**Driver: _A_**

With all the above in mind, write the "Hello World!" program in Java (taken from the reading), compile it, and run it to verify that everything works!

_There is nothing to turn in for this exercise._

### Exercise 2: Exploring the negative space

**Driver: _A_**

When trying out a new language, you'll run into plenty of errors and mistakes.  This is helpful because while you might burn more time than you'd like fixing those problems initially, they become trivial to fix if you see them in the future ("oh, I recognize this error message from before---you just need to do this to fix it...").  However, once you've established your basic programming pipeline, it's a good idea to explore the space and intentionally try to break it in various ways.  Because you are starting from a good pipeline, you can diagnose the error immediately on top of knowing exactly what you did to cause it!

Answer this following set of questions by playing around with your working `Hello World!` program.

_Note that you will not be turning in these answers. The questions are there to help you consider some of the things that go wrong when you try to build programs._

a. **File extensions.**
   Is it necessary to use .java extension for a source file?
   If not, what sort of error do you get when you use a different extension?

b. **Missing files.**
   What happens if you specify a source file that does not exist or exists elsewhere on disk?

c. **`.class` and the `java` program.**
   What happens if you specify the program-to-run to `java` with the `.class` extension?

d. **Code formatting - whitespace.**
   Is Java whitespace-sensitive (*i.e.*, do spaces and newlines matter; if so, where)?

e. **Code formatting - case sensistivity.**
   Is Java case-sensitive (*i.e.*, is `main` different from `Main`)?

f. **The main method.**
   Speaking of which, what happens if the signature of `main` is not exactly as presented in the reading, *e.g.*, different function name, return type, or argument name?

g. **Necessary boilerplate #1: classes.**
   The biggest visual difference between C and Java source code is that Java methods (functions in C) must be housed within a class.
   What happens if you write a free-floating function, *i.e.*, a function not declared within a class?

h. **Necessary boilerplate #2: public and static.**
   The other major difference is the presence of `public` and `static` on the class and function declarations.
   Which of these `public` and `static` keywords can you remove?
   For the `public` and `static` keywords you can't remove, what errors do you get?

### Exercise 3: Starting to build your bag of programs

**Driver: _B_**

With a basic programming pipeline established, you are now in the position to begin writing real programs.  Many programmers break down what they can do in a programming language into two buckets:

1. What they can do with the language itself.
2. What they can do with the language's libraries.

For solving more interesting problems, we'll need external libraries (either the built-in libraries or some third-party libraries), for example, to perform file I/O or create graphics.  But it is worthwhile to tackle the two buckets independently.  In particular, learning what primitive operations the language provides gives you insight into how you should model your problems and structure your solutions.

Again, Java is a descendant of C, so much of these primitive operations are carried over without any changes.  In particular, minus some slightly different syntax and subtly different semantics (which will be exposed as we write more Java):

* Basic types,
* Variable declarations and assignments,
* Basic expressions and statements, and
* Method/function declarations.

are nearly identical between Java and C.

With this in mind, try writing a program that solves the FizzBuzz problem.

a. In the file `FizzBuzz.java`, create a method `public static void fizzbuzz(java.io.PrintWriter pen, int n)` that takes an integer `n` and prints the integers from 0 to `n` (inclusive), one integer per line, using the specified `PrintWriter`.  However:

* When `n` is a multiple of 3, print `fizz` instead of the integer,
* When `n` is a multiple of 5, print `buzz` instead of the integer, and
* When `n` is both a multiple of 3 and 5, print `fizzbuzz` instead of the inter.

For example, if `n` is 20, you would print

```
0
1
2
fizz
4
buzz
fizz
7
8
fizz
buzz
11
fizz
13
14
fizzbuzz
16
17
fizz
19
buzz
```

b. In a file called `FizzBuzzOne.java`, create a class with the following `main` method.

```java
    /**
     * Print 100 rounds of FizzBuzz to stdout.
     *
     * @param args
     *   The standard command-line arguments (which we ignore).
     * @exception Exception
     *   When something goes wrong with the I/O.
     */
    public static void main(String[] args) throws Exception {
      java.io.PrintWriter stdpen = new java.io.PrintWriter(System.out, true);
      FizzBuzz.fizzbuzz(stdpen, 100);
      stdpen.close();
    } // main(String[])
```

Note that this class and file reference a method in another class. The `FizzBuzz` in `FizzBuzz.fizzbuzz` says which class to look in, and the `fizzbuzz` says what method to call.

c. Try compiling and running your `FizzBuzzOne` class.

d. In a file called `FizzBuzzTwo.java`, create a class with the following `main` method.


```java
    /**
     * Print 1000 rounds of FizzBuzz to the file zz.txt.
     *
     * @param args
     *   The standard command-line arguments (which we ignore).
     * @exception Exception
     *   When something goes wrong with the I/O.
     */
    public static void main(String[] args) throws Exception {
      java.io.PrintWriter filepen = 
          new java.io.PrintWriter(new java.io.File("zz.txt"));
      FizzBuzz.fizzbuzz(filepen, 1000);
      filepen.close();
    } // main(String[])
```

e. Run that program, too.

Note: The `fizzbuzz` problem is an example of one of the standard programs PM tries to write whenever he learns a new language.  It's ideal for this purpose because:

1. It is a short program to write, yet is complex enough to be non-trivial.
2. It tests the language's expressiveness.
   In other words, how does one express repetitive and conditional behavior?

Over the course of the next few weeks, we'll be working through some of the canonical programs that PM likes to write when learning a new language.  Feel free to add these to your arsenal whenever you pick up a new language, too!

### Exercise 4: Java packages

**Driver: _B_**

Another way that Java differs from C is that Java generally expects you to put code in groups called "packages". For example, the standard Java classes are in the `java.io` package and the even more standard language options are in `java.lang`. By tradition, user-defined packages are usually named with something we might call a "reverse url". In the most extreme, we might name a package something like `com.company.division.project` or `edu.school.deparatment.class.semester`. We aren't going to be quite that extreme, but we will try to use the package `edu.grinnell.csc207` (or a subpackage of that) for most of our work.

The Java compiler expects that files in a package are stored in folders that correspond to the package. For example, if `HelloWorld.java` is in package `edu.grinnell.csc207.main` (the package we're using for classes with a main method), it should be in the folder `edu/grinnell/csc207/main`. Similarly, if `FizzBuzz.java` is in the package `edu.grinnell.csc207.util`, it should be in the folder `edu/grinnell/csc207/util`.

a. Set up those folder hierarchies. I'd recommend that you put them somewhere like `/home/USERNAME/CSC207/Labs/GettingStarted`, but it's up to you how you organize your files.

b. Edit `HelloWorld.java` to add the following "package declaration" at the top of the file.

```java
package edu.grinnell.csc207.main
```

c. Put your `HelloWorld.java` in the appropriate directory.

d. As you might guess, if we're in the top-level directory (above `edu`), we need a slightly different command to compile `HelloWorld.java`

```
$ javac edu/grinnell/csc207/main/HelloWorld.java
```

Make sure that the command works as expected. Remember that tab-based autocomplete is your friend. (If you don't know what that means, ask one of the class staff.)

e. We will also type a similar command to run the main method.

```
$ javac edu.grinnell.csc207.main.HelloWorld
```

Make sure that that command runs as expected, too.

### Exercise 5: More greetings (and more hierarchies)

**Driver: _A_**

In the same directory as `HelloWorld.java`, create a file, `HiWorld.java`, that is much like `HelloWorld.java` except that the program prints `Hi, World!`.

Make sure that you can compile and run that file.

### Exercise 6: Moving our other files

**Driver: _A_**

Using similar steps, but `FizzBuzz.java` in the `edu.grinnell.csc207.util` package and `FizzBuzzOne.java` and `FizzBuzzTwo.java` in the `edu.grinnell.csc207.main` package. Then compile and run the two main programs.

Note that in addition to adding the `package` command to each of those files, you will likely need to update `FizzBuzzOne.java` and `FizzBuzzTwo.java` to provide more information on where to find the `FizzBuzz` class. Consider how we referenced the `PrintWriter` class for ideas and ask the class staff if you get stuck.

### Exercise 7: Getting started with Java arrays

**Driver: _B_**

We should also explore some of the more significant, heavyweight features of Java and how they improve over what C provides.  One example of this is the `array` which is a data structure that holds a *homogeneous* (*i.e.*, same type), fixed-size collection of values.  When working with a new type of data, you should always ask yourself the following two questions:

1. How do I *create* values of this type?
2. How do I *use* or *consume* values of this type?

Luckily, the array syntax is largely identical to C:

* The type of an array that holds values of type `T` in Java is `T[]`, *e.g.*, `int[]` for an array of integers.
* To create a new array, we use either an *array literal* or a *new* expression passing in the size of the array.

For example, the following code snippet creates an array of 5 elements.  The first initializes the array:

```java
    int[] arr1 = { 0, 1, 2, 3, 4 };     // An array literal
    int[] arr2 = new int[5];            // A "new" expression
```

Array indexing (`arr1[0]`) works identically to C. Finally, one nice convenience is that Java arrays, unlike C arrays, know their own length:

```java
    pen.println(arr2.length);    // Prints 5
```

With all this in mind, try writing some code to answer the following questions.

_Once again, you will not be turning in this code. Instead, you are doing these problems to explore what does and does not typically work in a Java program._

a. **Initialization.** Perhaps the largest departure from C is that the following code snippet in C

```c
int arr[5];
```

is how you declare an array with five elements in C.  Note that there is no array literal or new expression present.  What do you expect to happen if you try this with Java? *i.e.*, declare a variable with an array type, do not use an array literal or new expression to initialize it, and then use that array.  Try it to check.

b. **New Expressions.**  Note that the array literal allows you to specify the contents of the array (if you know them at compile time).  What value(s) does the `new` expression use to initialize each element of an array?

c. **Out-of-bounds.**  Recall that with C arrays, you are free to walk off the end of the array into arbitrary parts of memory (because an array is morally a pointer)!  Can you do this in Java?  If not, what error(s) do you get when you try to do this?  Do the errors happen at compile time, or runtime?  Can you think of a legitimate use case for walking off the end of an array?

### Exercise 8: Minima and maxima

**Driver: _A_**

In this and the next few exercises, you will be exercising your array manipulation skills. Please put your solutions to all of these problems in a class called `ArrayUtils` in the package `edu.grinnell.csc207.util`. Please put your experiments in the package `edu.grinnell.csc207.experiments`. (Each experiment will need its own `main` method.)

a. Create an empty `ArrayUtils` class in the appropriate directory.

```
package edu.grinnell.csc207.util;

/**
 * Various array utilities.
 *
 * @author YOUR NAME HERE.
 */
public class ArrayUtils {
} // class ArrayUtils
```

b. Write a static method, `min(arr)`, that takes a nonempty array of integers as an input and returns the smallest value in that array. Add that method to `ArrayUtils`.

b. Add the following class to the folder `edu/grinnell/csc207/experiments`. (You'll need to create that folder.)

```
package edu.grinnell.csc207.experiments;

/**
 * Some experiments with the <code>min</code> method.
 */
public class MinExperiments {
  /**
   * Run one experiment on the `min` method.
   *
   * @param pen
   *   Where we print the output
   * @param vals
   *   The values we'll be printing.
   */
  static void minExperiment(java.io.PrintWriter pen, int[] vals) {
    pen.print("min(" + java.util.Arrays.toString(vals) + ") = ");
    pen.flush();
    pen.println(edu.grinnell.csc207.util.ArrayUtils.min(vals));
  } // minExperiment(java.io.PrintWriter, int[])

  /**
   * Run our experiments.
   *
   * @param args
   *  Command-line arguments (ignored)
   */
  public static void main(String[] args) {
    java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
    minExperiment(pen, new int[] {3, 7, 10, 2, 9, 1});
    minExperiment(pen, new int[] {1, 2, 3, 4, 5});
    minExperiment(pen, new int[] {-50, -40, -10, -80, -5});
  } // main(String[])
} // class MinExperiments
```

c. Compile the experiment and run it.

```
javac edu/grinnell/csc207/experiments/MinExperiments.java
java edu.grinnell.csc207.experiments.MinExperiments
```

d. Write a similar static method, `max(arr)`, that returns the maximum value of the array.

e. Create and run a main class, `MaxExperiment` that behaves much like `MinExperiment`, except with the `max` method.

### Exercise 9: Reversing arrays

**Driver: _B_**

a.  Write a static method , `rev(arr)`, that takes an array of integers as input and mutates the array so that its elements are reversed.

b. Create and run a main class, `RevExperiment`, that conducts experiments with the `rev` method.

### Exercise 10: Longest increasing subsequence

**Driver: _A_**

a.  Write a static method `longestIncreasingSubsequence(arr)` that returns the *size* of the longest increasing subsequence found in the given array of integers.  For example, if the input array is `{3, 7, -10, 2, 8, 9, 5, 1}`, then the function returns `4` corresponding to the sub-sequence `{-10, 2, 8, 9}`.

b. Write and run a main class, `LISExperiment`, that conducts experiments with your `longestIncreasingSubsequence` method.  You should demonstrate that your function works on this sample array.

### Exercise 11: Fibonacci numbers

**Driver: _B_**

a. Write a static method, `fibs(n)`, that takes an integer `n` and returns an integer array of size `n` where the *i*-th element of that array contains the *i*-th fibonacci number.  For example, `fibs(10)` should return an integer array containing the elements `{1, 1, 2, 3, 5, 8, 13, 21, 34, 55}`.

*Use a loop to do this computation instead of recursion.*

b. Write and run an appropriate experiment.

## Submitting your work

When you are done (or run out of time), submit your code on Gradescope.

a. Remove all of your `.class` files, since we don't want those uploaded. If you're feeling lucky, you can try this command.

```
rm `find . -name *.class`
```

b. Create a zip file from the `edu` folder.

```
zip -r lab-getting-started.zip edu
```

c. Upload the `zip` file.

---

## Bonus: Project Euler

For additional problems to help you exercise a new programming language, we recommend checking out [Project Euler](https://projecteuler.net) which is a repository of math-based programming problems for you to solve.  If you have gotten to this point, feel free to head over to Project Euler and try writing Java programs to solve the first couple of problems!
