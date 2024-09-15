---
title: Mini-Project 2
subtitle: Fun with Fractions
summary: |
  In this assignment, you will build a simple calculator that works
  with fractions
collaboration: |
  Each student should submit their own responses to this project. You may consult other students in the class as you develop your solution.  If you receive help from anyone, make sure to cite them in your responses. 
link: true
---
You goal in this project is to build a calculator (or perhaps many calculators) that (a) uses fractions as its basic numeric type and (b) includes registers. (A register is a named storage area, much like a vriable.)

## Project setup

For this project, you'll need to set up Maven yourself. You could copy and modify an existing project or you can follow [the project setup instructions](../handouts/project-setup) to set one up for yourself.

## Required classes

**`edu.grinnell.csc207.util.BigFraction`**  

An extended version of the `Fraction` class you worked on in lab.  You should use a `BigInteger` for the numerator and the denominator. You should make sure to reduce your fractions to the simplest form.  You should also add other constructors as appropriate.  You will also likely need to implement some other operations, such as subtraction and division.

**`edu.grinnell.csc207.util.BFCalculator`**

The primary workhorse.  This class should have a field that stores the last value calculated and provide the following methods. (Note that all of these methods are object methods, not static methods; we should be able to invoke multiple calculators simultaneously.)

* `public BigFraction get()` - gets the last computed value (returns 0 if there is no such value).
* `public void add(BigFraction val)` - adds `val` to the last computed value.
* `public void subtract(BigFraction val)` - subtracts `val` from the last computed value.
* `public void multiply(BigFraction val)` - multiplies the last computed value by `val`.
* `public void divide(BigFraction val)` - divides the last computed value by `val`.
* `public void clear()` - resets the last computed value to 0.

**`edu.grinnell.csc207.util.BFRegisterSet`**.

A set of registers corresponding to the letters `'a'` through `'z'`. It should provide the following methods. As with the case of `BFCalculator`, these should all be object methods so that we can have multiple register sets.

* `public void store(char register, BigFraction val)` - stores the given value in the specified register.
* `public BigFraction get(char register)` - retrieves the value from the given register.

Note that `BFCalculator` does not interact directly with `BFRegisterSet`. The registers are the responsibility of the UIs (see below).

**`edu.grinnell.csc207.main.InteractiveCalculator`**

Here, you will provide a `main` method that will repeatedly read a line the user types, use a `BFCalculator` to compute the result, and print the result for the user. This type interaction is often called a "REPL", for "Read-Eval-Print loop".

**`edu.grinnell.csc207.main.QuickCalculator`**

Here, you will provide a `main` method that will take the expressions from the command line (rather than user input) and then print out the results.

## Input format

What will the input strings for the two main programs look like? They can be expressions, store commands, or quit.

* Expressions are sequence of values (either integers, fractions, or register names) separated by spaces and operators. The implicit meaning of an expression is "evaluate this expression and print the result".
* Store commands will take the form `STORE reg`, where `reg` is a letter of the alphabet. These commands should store the last computed value in the given register.
* We quit with `QUIT`. If you know how, you can also stop at the end of input. For `QuickCalculator`, you should stop when you run out of command-line arguments.

For example, here's a session with `InteractiveCalculator`.

```
$ java edu.grinnell.csc207.main.InteractiveCalculator
> 1/2 + 1/3
5/6
> STORE a
> a + a
5/3                     (or 1 2/3)
> a / 2 + 1
17/12                   (or 1 5/12)
> 1 + a / 2
11/12
> QUIT
```

Here's an example session with `QuickCalculator`.

```
$ java edu.grinnell.csc207.main.QuickCalculator "1/5 + 1/7" "STORE a" "a + 2"
1/5 + 1/7 = 12/35
a + 2 = 82/35
```

There is no precedence; you should evaluate operations from left to right.  There may be an arbitrary number of values and operations on each line.

## Grading rubric

This rubric may evolve slightly during grading.

### Redo or above

Submissions that fail to meet any of these requirements will get an I.

```
[ ] Includes the five specified classes, correctly named and in the appropriate packages.
[ ] Each class has an introductory Javadoc comment that indicates the author and purpose. 
[ ] Includes a `README.md` file.
[ ] The `README.md` file contains the appropriate information (authors, purpose, acknowledgements if appropriate)
[ ] All files compile correctly.
[ ] The main methods of `QuickCalculator` and `InteractiveCalculator` run.
[ ] All classes include the specified methods.
[ ] Passes all the **R** tests.
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```
[ ] Correct organization for a Maven project.
[ ] Reasonable `pom.xml` file.
[ ] No more than ten stylistic errors.
[ ] Fractions always appear in simplest form.
[ ] All data are stored in class fields, so that we can have two 
    `BFCalculator` objects running simultaneously and they will not 
    interfere with each other.
[ ] Passes all the **M** tests.
```

### Exemplary / Exceeds expectations

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an M.

```
[ ] All (or most) repeated code has been factored out into individual
    methods, including common code between `QuickCalculator` and 
    `InteractiveCalculator`.
[ ] No stylistic errors are reported by `mvn checkstyle:check -q`.
[ ] All or most variable names are appropriate.
[ ] Handles expressions without fractional parts, such as `2 + 123`.
[ ] Handles expressions with no operations, such as `a`, `11/2`, or `5`.
[ ] Handles negative numbers. (It need not handle negative registers.)
[ ] Handles expressions with multiple operations, such as `3/2 * 1/5 + 11/7`.
[ ] Whole numbers appear as such and not as something like 11/1.
[ ] Provides an appropriate error message if the expression has the
    wrong form (e.g., two numbers/registers in a row or two operations
    in a row).
[ ] Passes all the **E** tests.
```

Questions and answers
---------------------

### User input

**Can I assume that there are spaces between operators and values?**

> Yes.

**Can I assume that input is correct?**

> No. You should issue an error message and move on to the next line (or command-line argument) if one line (command-line argument) is incorrect.

**Having an example of how to ask for user input would be helpful. Does it change based on the type of input you want to take in like scanf vs gets in C? Where does it put the information when you get it?**

> I tend to use `java.util.Scanner` objects. You can use procedures like `nextInt` if you think that's appropriate. However, I tend to prefer to just use `nextLine()` to read the line and manually parse the line.

> ```
    PrintWriter pen = new PrinterWriter(System.out, true);
    Scanner eyes = new Scanner(System.in);
    pen.print("Enter a fraction: ");
    pen.flush();
    String stuff = eyes.nextLine();
    BigFraction f = new BigFraction(stuff);
    pen.print("Enter values separated by spaces: ");
    pen.flush();
    String moreStuff = eyes.nextLine();
    String[] values = moreStuff.split(" ");
    for (String val : values) {
      ...
    } // for
```

> See also [`Interact.java`](../examples/interact/edu/grinnell/csc207/main/Interact.java) in the `examples` section of the Course web site.

**Do we need to support both fractions and mixed numbers?**

> You need not support mixed numbers. However, you should support both fractions and whole numbers.

**If we call `QuickCalculator` with no command line arguments, do we put out an error?**

> I'd just report no output.

### Registers

**What is a register?**

> In general, a register is a place to store information.

> It's something like a variable in a programming language.

**Why are we using registers?**

> Because most modern calculators have them.

**Why are we using letters for registers rather than numbers?**

> In practice, people use letters.

> I also wanted you to continue thinking about the relationship between
  letters and numbers (something you explore in the prior MP).

**Could you say a little bit more about registers?**

> Think of a register as a variable. We can store a value in it (using the `store(char,BigFraction)` method behind the scenes and the `STORE x` command in the UI). We can retrieve a value from it (using the `get(char)` method behind the scenes and by using the name in an expression in the UI).

**Should I use int variables from a to z as registers, or is there a specific variable we should use?**

> I'd suggest an array rather than 26 variables. Since they are storing fractions, I'd suggest that the array store `BigFraction` objects.

### UI

**Should we incorporate precedence?**

> No. The tests will assume that you have not incorporated precedence.

**Should `a/b / c/d` be treated as `(a / b) / (c / d)` or `(((a / b) / c) / d)`?**

> It should be interpreted as "the fraction `a/b` divided by the fraction `c/d`" or `(a / b) / (c / d)`.

**I'm still a little confused on the difference between the interactive calculator and the quick calculator. Do they both take the functions we've made, but the only difference is that one takes from the command line and the other has the user type the message after the command line is run?**

> You seem to have summarized it well. One thing you should be considering in this course is how to present your utilities to the user. It's much faster to write `java edu.grinnell.csc207.main.QuickCalculator "3 + 4"` than to start the interactive calculator.  (We would also likely have an alias so that we don't need to type all of that.)

**How would we set up such an alias?**

> ```
alias qc='java -cp target/classes edu.grinnell.csc207.main.QuickCalculator'
```

> Note that this will run in the top-level folder of your project.

**How would we make a visual version of this same calculator?**

> There are a variety of Java toolkits for making GUIs.  Swing and JavaFX seem to be the most popular.

**Is there a limit to how many times we can use the calculator in a single run?**

> Nope.

**How should I handle invalid user input?**

> Print an error message and go on.

### Maven issues

**Do we need to package and have a `.jar`?**

> It's nice to package, but not strictly necessary.

**If we do create a package or a `exec:java` target, which program should be the main class?**

> I'd use the interactive calculator as the main class.

**Should we commit and push the target?**

> Definitely not! We almost never push generated files.

### Testing

**What edge cases should I consider?**

> Negative numbers. Whole numbers. Zero. No input.

**Will we get tests for this or write it ourselves?**

> You will get tests.

### Miscellaneous

**What methods should BigFraction include?**

> I'd suppose addition, subtraction, multiplication, and division. Also `toString`. You probably want some private (or at least package) methods for things like reducing to simplest form.

**Can I create more methods than those listed?**

> Certainly. I'd even encourage it.

**Can I create additional classes?**

> Certainly.

**How should I store "the result from the last calcluation"?**

> In an object field in your `BFCalculator` class.

**What does it mean to have two `BFCalculator` objects running simultaneously?**

> We can create two calculators and use them separately. (We won't do that
  with the UIs you are creating, but we might do so in testing.)

> ```
BFCalculator calc1 = new BFCalculator();
BFCalculator calc2 = new BFCalculator();
calc1.add(new BigFraction(3));
pen.println(calc2.get());       // Should print 0
```

**Is there is a `BigInteger` GCD function?**

> Yup. You can find it in [the documentation for `BigInteger`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/math/BigInteger.html).

### Beyond the project

**Can constructors be static?**

> Nope. Although constructors aren't called exactly like normal functions, we do not declare them as static. They must also be prefixed by `new` when they are called.

**Do I just use `import` to connect Java files together?**

> More or less, although it is not strictly necessary (`import` mostly introduces shorthand).

> If the files are in the same directory, you need not connect them explicitly.

**Is there an extension we are permitted to use for styling?**

> There's a reformat command in VSCode. Open the command palette in VSCode and enter "Format Document". (Make sure you've installed the style info from the intro lab.)

> However, it does not completely cover all of the requirements of `mvn checkstyle:style`.

**Do you recommend building each class separately and then ensuring they work together or is building them simultaneously better?**

> I tend to build separately and experiment/test as I go.

**Can we use features we might have heard of from elsewhere (e.g. hash tables) that we have not yet learned in Java?**

> You should not need hash tables. I would generally prefer that you not pull in too many things from elsewhere.

---

_**Acknowledgements**: Parts of this assignment are inspired by assignments from past versions of CSC-207 (and perhaps even CSC-152)._
