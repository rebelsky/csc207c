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

You should also make sure to upload the project to GitHub and to use good Git practices, such as regular commits.

The [provided unit tests for this project](../code/calculator/TestMP02.java) should be placed in [`src/test/java/edu/grinnell/csc207/TestMP02.java`](../code/calculator/TestMP02.java). You may also wish to create your own tests.

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

---

Grading rubric
--------------

This rubric may evolve slightly during grading.

### Redo or above

Submissions that fail to meet any of these requirements will get an I.

```
[ ] Passes all the **R** unit tests.
[ ] Passes all the **R** test scripts.
[ ] Includes the five specified classes, correctly named and in the 
    appropriate packages.
[ ] Each class has an introductory Javadoc comment that indicates the author 
    and purpose. 
[ ] Includes a `README.md` file.
[ ] The `README.md` file contains the appropriate information (authors, 
    purpose, URL, acknowledgements if appropriate)
[ ] All files compile correctly.
[ ] The main methods of `QuickCalculator` and `InteractiveCalculator` run.
[ ] All classes include the specified methods.
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```
[ ] Passes all the **M** unit tests.
[ ] Passes all the **M** test scripts.
[ ] Correct organization for a Maven project.
[ ] Reasonable `pom.xml` file.
[ ] No more than ten stylistic errors.
[ ] All data are stored in class fields, so that we can have two 
    `BFCalculator` objects running simultaneously and they will not 
    interfere with each other.
```

Issues checked by the scripts.

```
[ ] Handles expressions with one operator and two numeric operands.
[ ] Handles expressions with one operator, one numeric operand, and 
    one register.
[ ] Handles expressions with one operator and two registers.
[ ] Fractions always appear in simplest form. 
```

### Exemplary / Exceeds expectations

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an M.

```
[ ] Passes all the **E** unit tests.
[ ] Passes all the **E** test scripts.
[ ] All (or most) repeated code has been factored out into individual
    methods, including common code between `QuickCalculator` and 
    `InteractiveCalculator`.
[ ] No stylistic errors are reported by `mvn checkstyle:check -q`.
[ ] All or most variable names are appropriate.
```

Issues checked by the scripts.

```
[ ] Handles expressions without fractional parts, such as `2 + 123`.
[ ] Handles expressions with no operations, such as `a`, `11/2`, or `5`.
[ ] Handles negative numbers. (It need not handle negative registers.)
[ ] Handles expressions with multiple operations, such as `3/2 * 1/5 + 11/7`.
[ ] Whole numbers appear as such and not as something like 11/1.
[ ] Provides an appropriate error message if the expression has the
    wrong form (e.g., two numbers/registers in a row or two operations
    in a row).
```

Grading scripts
---------------

Rather than relying on unit tests for our two main programs, our graders will be relying on "testing scripts" that they will execute by hand. We're using scripts rather than unit tests because that gives you a bit more freedom in what your output looks like.

Note that the graders will look at your code to ensure that you haven't just special-cased all of these scripts.

### Preparation

All commands should be executed in the top-level directory of the project.

```
mvn compile -q
alias ic='java -cp target/classes edu.grinnell.csc207.main.InteractiveCalculator'
alias qc='java -cp target/classes edu.grinnell.csc207.main.QuickCalculator'
```

### **R** script for `InteractiveCalculator`

``` 
$ ic
> 3/2 + 1/3
OUTPUT                  # Program reads input and prints output
> QUIT                  # Program successfully quits
$
```

### **R** script for `QuickCalculator`

```
$ qc "3/2 + 1/3"
OUTPUT          # Note that any output suffices
```

### **M** script for `InteractiveCalculator`

```
$ mvn compile -q
$ java -cp target/classes edu.grinnell.csc207.main.InteractiveCalculator
> 3/2 + 1/3
11/6                    # Correctly adds two fractions
> 1/2 - 1/3
1/6                     # Correctly subtracts two fractions
> 2/3 * 2/5
4/15                    # Correctly multiplies two fractions
> 2/3 / 1/5
10/3                    # Correctly divides two fractions
> 1/12 + 3/12
1/3                     # Simplifies
> 17/12 + 9/12
13/6                    # Simplifies for values greater than 1
> 1/4 + 1/4
1/2
> STORE a
STORED                  # No output necessary
> 1/6 + 1/6
1/3
> STORE b               # No output necessary
> 2/3 + a
7/6                     # Register in second place
> a * 5/3
5/6                     # Register in first place
> a / b
3/2                     # Two registers
> b * b                 
1/9                     # The same register twice
> STORE a
STORED
> a * 1/2
1/18                    # We can change registers
> QUIT
$
```

### **M** script for `QuickCalculator`

```
# Can we add?
$ qc "3/2 + 1/3"
3/2 + 1/3 -> 11/6               # Other forms are also permissible

# Can we do multiple binary operations?
$ qc "3/2 - 1/3" "3/2 * 5/7"  "1/3 / 1/5"
3/2 - 1/3 -> 7/6
3/2 * 5/7 -> 15/14
1/3 / 1/5 -> 5/3

# Does it simplify?
$ qc "5/12 + 11/12"
5/12 + 11/12 -> 4/3

# Can we store in variables?
$ qc "1/3 + 1/3" "STORE a" "a * 4"
1/3 + 1/3 -> 2/3
STORE a -> STORED
a * 4 -> 8/3

# Can we write expressions with variables?
$ qc "2/3 * 1/2" "STORE a" "1/4 + 1/4" "STORE b" "a + b" "a - b" "a * b" "a / b"
2/3 * 1/2 -> 1/3
STORE a -> STORED
1/4 + 1/4 -> 1/2
STORE b -> STORED
a + b -> 5/6
a - b -> -1/6
a * b -> 1/6
a / b -> 2/3
```

### **E** script for `InteractiveCalculator`

```
$ ic
> 3/2 + 5/2
4               # Whole numbers output as whole numbers
> 1 + 2 * 3 - 4
5               # Input only involves whole numbers
> 3
3               # Input is a whole number
> STORE a
STORED
> a
3               # Input is just a register
> 1/2
1/2             # Input is just a fraction
> STORE b
STORED
> a + b * 2
7               # Expression with two operators and three operands
> 1/2 - 1/3 + 1/4 - 1/5 + 1/6
23/60           # Lots of operators and operands
> -3/5
-3/5            # Negative inputs
> 1 / -3/5
-5/3            # Negative inputs
> -1/2 * -2/3 + 5/2
17/6            # Negative inputs
> + 2
*** ERROR [Invalid expression] ***
> 2 +
*** ERROR [Invalid expression] ***
> 2 + 3 -
*** ERROR [Invalid expression] ***
> 2 x 3
*** ERROR [Invalid expression] ***
> STORE Q
*** ERROR [STORE command received invalid register] ***
> 2 * Q
*** ERROR [Invalid expression] ***              # Could be more helpful
```

### **E** script for `QuickCalculator`

```
# Whole number output
$ qc "3/2 + 5/2"
3/2 + 5/2 -> 4

# Singleton input
$ qc "1/2" "STORE a" "a" "5" "-2/3" 
1/2 -> 1/2
STORE a -> STORED
a -> 1/2
5 -> 5
-2/3 -> -2/3

# Complex expressions
$ qc "1/2" "STORE a" "STORE b" "a * b * a + b"
1/2 -> 1/2
STORE a -> STORED
STORE b -> STORED
a * b * a + b -> 5/8

# Another complex expression
$ qc "1 + 2 * 3 - 4 / -1/3"
1 + 2 * 3 - 4 / -1/3 -> -15

# Invalid inputs
$ qc ""
FAILED [Invalid expression]
$ qc "1 +"
1 +: FAILED [Invalid expression]
$ qc "3" "+ 2 3" "1/2 * 1/3"
3 -> 3
+ 2 3 FAILED [Invalid expression]
1/2 * 1/3 -> 1/6
```

---

Questions and answers
---------------------

**Could you give a broad overview of the concepts we will practice in this MP?**

> * Project development: Setting up a Maven project.
> * Project development: GitHub.
> * OOP basics; Setting up classes and methods.
> * OOP basics: Creating multi-class projects.
> * Java: Using standard classes, such as `String` and `BigInteger`. Also reading the Java documentation to understand such classes.
> * General programming: Input, output, and parsing.
> * General programming: Program decomposition.

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

> It should be interpreted as "the fraction `a/b` divided by the fraction `c/d`" which is `(a / b) / (c / d)`.

**I'm still a little confused on the difference between the interactive calculator and the quick calculator. Do they both take the functions we've made, but the only difference is that one takes from the command line and the other has the user type the message after the command line is run?**

> You seem to have summarized it well. One thing you should be considering in this course is how to present your utilities to the user. It's much faster to write `java edu.grinnell.csc207.main.QuickCalculator "3 + 4"` than to start the interactive calculator.  (We would also likely have an alias so that we don't need to type all of that.)

**How would we set up such an alias?**

> ```
alias qc='java -cp target/classes edu.grinnell.csc207.main.QuickCalculator'
```

> Note that this will run in the top-level folder of your project.

**What is an alias?**

> An alias is a shorthand for a longer command. You set one up in the terminal window.

**How would we make a visual version of this same calculator?**

> There are a variety of Java toolkits for making GUIs.  Swing and JavaFX seem to be the most popular. But making such a calculator is not part of this assignment?

**Is there a limit to how many times we can use the calculator in a single run?**

> Nope.

**In the requirements for an E, you write that we must "Handle[] expressions with no operations, such as `a`, `11/2`, or `5`." Could you explain?**

> Each of your programs will take those as expressions (as an input for the interactive calculator, as one of the commands on the command-line in the quick calculator).

> For example,

> ```
$ java -cp target/classes edu.grinnell.csc207.main.QuickCalculator "11/2" "STORE b" "3 + 2" "b"
11/2
5
11/2
```

> ```
$ java -cp target/classes edu.grinnell.csc207.main.InteractiveCalculator 
> 11/2
11/2
> 5
5
> STORE a
> a
5
```

**Do I have to report anything for the `STORE` command?**

> Nope.

**I see two different output formats for `QuickCalculator`, one which shows the individual input expressions and one which does not. Which should I use?**

> Use whichever you'd prefer.

For the interactive calculator I need a loop. When does the loop stop? 

> When the user types "QUIT". Ideally, when the user ends the input (but that's a bit harder to check for).

### UI Errors

**Are you wanting exact error messages to what is in the tests?**

> Nope. Print anything you consider reasonable.

**If it's a mixed fraction do I say "error"?**

> Yes. We only accept fractions in the n/d form.

**How should I handle invalid user input?**

> Print an error message and go on.

I’m curious about how we should handle invalid input, like two operators in a row. 

> Print an error message and go on to the next input (the next line for the interactive calculator and the next command-line parameter for the command-line calculator).

### Maven issues

**Do we need to package and have a `.jar`?**

> It's nice to package, but not strictly necessary.

**If we do create a package or an `exec:java` target, which program should be the main class?**

> I'd use the interactive calculator as the main class.

**Should we commit and push the target?**

> Definitely not! We almost never push generated files.

**Should we put this in a GitHub repository?**

> Yes.

### Testing

**What edge cases should I consider?**

> Negative numbers. Whole numbers. Zero. No input.

**Will we get tests for this or write it ourselves?**

> You will get unit tests (and testing scripts).

**For the registers, does each letter store a fraction? or like the whole expression (1/2 + 1/1)?**

> Each letter should correspond to a fraction. You will probably have lost the expression by the time you need to store something in a register.

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

**What kinds of helper functions will be helpful?**

> Part of the goals of the assignment are for you to think about this.

**Are there any additional classes you would recommend using?**

> I created a class to handle the common work between the two UIs (main classes).

**Could you explain constructors in more detail?**

> Constructors are like methods with the explicit purpose of initializing objects. They differ from methods in that (a) they must have the same name as the class, (b) they have no explicit return type (they return a new object), and (c) they have a slightly different calling form, `new Class(arg1, arg2, …)` rather than `obj.method(arg1, arg2, …)`.

**How should we store fractions? Can we use `float` values?**

> Your fractions should mimic those from the first object lab and contain two `BigInteger` values. Using something like a `float` will almost certainly lead to a loss of precision.

How is the Javadoc like a style comment? That has the parameters and what the thing does? Do i just search up how to do a Javadoc comment?

> You should be able to follow the examples from the various sample code. If not, you can do a search.

I worked on `BigFraction` objects in the lab. Can I use code from the lab in my mini-project?

> Certainly. However, you should make sure to cite your partner.

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

## Acknowledgements

Parts of this assignment are inspired by assignments from past versions of CSC-207 (and perhaps even CSC-152).

The current version of the assignment was designed in Fall 2024.
