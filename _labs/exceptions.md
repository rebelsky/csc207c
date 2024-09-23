---
title: Exceptions in Java
repo: <https://github.com/Grinnell-CSC207/lab-exceptions-maven>
summary: |
  We explore some basic use of exceptions in Java
prereqs: |
  Classes and interfaces.
---

Preparation
-----------

a. Fork and clone the repository at {{ page.repo }}. As always, make sure to use the SSH link when cloning.

b. Import the repository into VSCode.

c. Update the `README.md` file to add your names and URL.

d. Commit and push the change.

```text
git add README.md
git status
git commit -m "Personalize the README"
git pull
git push
```

e. Quickly skim the code to determine the purpose of the various portions.

f. Identify the person closer to the board. They are partner **_A_**.  The person further from the board is partner **_B_**B.

Exercises
---------

### Exercise 1: Exception basics

_Driver: **A**_

a. Remove the `throws Exception` from the `main` method in `ReadIntExperiment` and determine what, if any, error messages you get.  If VSCode permits you to do so, try running the program. 

After you finish exploring the effects of that removal, reinsert the `throws` clause.

b. Remove the `throws Exception` from the definition of `readInt` and determine what, if any, error messages you get.  If VSCode permits you to do so, try running the program with that warning removed.

Do not reinsert the `throws` clause.

c. Within `readInt`, you should have a sequence of lines (or perhaps a single line) that looks something like the following:


```java
    String response = br.readLine();
    return Integer.parseInt(response);
```


Enclose those lines in a try/catch clause that returns 0 if an exception is thrown, as in

```java
    try {
      String response = br.readLine();
      return Integer.parseInt(response);
    } catch (Exception e) {
      return Integer.MIN_VALUE;
    } // Reading/parsing fails.
```

d. Verify that VSCode and Maven are no longer concerned about errors in your code.

e. Determine what happens when the user enters an invalid value (such as `Hello`) in response to a request for an integer.

f. Commit and push your changes.

```text
git add src
git status
git commit -m "readInt now returns Integer.MIN_VALUE when something goes wrong"
git pull
git push
```

### Exercise 2: Computing a quadratic root

_Driver: **B**_

a. Write a few simple unit tests for the `smallerRoot` procedure in the `Quadratic` class.  Note that you are likely to find it easier of you choose quadratics for which you know the solution.  For example,

* If we multiply $$x-2$$ and $$x+5$$, giving us $$x^2 +3x -10$$, we
  know that the roots are $$2$$ and $$-5$$.
* If we multiply $$2x+3$$ and $$3x-4$$, giving us us $$6x^2 + x -12$$,
  we know that the roots are $$-3/2$$ and $$4/3$$.

b. Commit and push your changes.

```java
git add src/test/java/edu/grinnell/csc207/TestQuadratic.java 
git status
git commit -m "Add tests for `smallerRoot`."
git pull
git push
```

c. Implement the `smallerRoot()` method in the `Quadratic` class.  The method should compute the smaller of the two roots of a quadratic expression.

Note that you can use the following formula to compute that root: $$(-b - \sqrt{b^2 - 4ac})/2a$$

You will, of course, have to translate that mathematical expression into Java code.

d. Run your tests to ensure that your `smallerRoot()` method works correctly. (Or, I suppose, that your tests are correct.) If you have errors, fix them.

e. Commit and push your changes.

```java
git add src/main/java/edu/grinnell/csc207/util/Quadratic.java 
git status
git commit -m "Add smallerRoot method."
git pull
git push
```

### Exercise 3: Adding user input

_Driver: **B**_

a. Write a new main class, `QR`, which

* prompts the user for coefficients of a quadratic function,
* computes the smaller root of the quadratic,
* prints that root, and
* prints the value of the quadratic at that root.

For example:

```text
Hi! I'm here to help you understand quadratic functions.

Please enter a (the coefficient of the squared term): 1
Please enter b (the coefficient of the linear term) : -5
Please enter c (the constant)                       : 6

The smaller root of 1x^2 + -5x + 6 is 2.

Experimentally, 1*2^2 + -5*2 + 6 = 0.
```

b. Use your class to compute the smaller root of $$x^2 - x - 2$$.  (The roots of that quadratic are $$2$$ and $$-1$$.

c. Commit and push your changes.

```text
git add src/main/java/edu/grinnell/csc207/main/QR.java
git status
git commit -m "Add instructions to QR."
git pull
git push
```

### Exercise 4: Erroneous input

_Driver: **A**_

a. Determine what happens if the user enters 0 for the coefficient of $$x^2$$.

b. Determine what happens if user enters coefficients for which there is no real root.

c. Determine what happens if the user enters values for which the function has only one root (e.g., $$x^2 - 2x + 1$$ has only one root).

d. You've made no changes, so there's nothing to commit or push.

### Exercise 5: Indicating potential errors

_Driver: **A**_

a. Extend `smallerRoot` to indicate that it may throw an exception.  Note that you'll need to change the method signature for `smallerRoot` to something like the following.

```java
  public double smallerRoot() throws Exception {
```

b. Can you successfully compile your modified code?  If not, make any changes necessary to permit you to compile it.

c. Can you successfully compile `QR`?  If not, make any necessary changes. If you can't figure out those changes, get help from one of the class staff.

d. What now happens if you enter the "erroneous" input described
  in the previous exercise?

e. Commit and push your changes.

```text
git add src
git status
git commit -m "Prepare to support exceptions in smallerRoot."
git pull
git push
```

### Exercise 6: Throwing exceptions

_Driver: **B**_

a. Extend `smallerRoot` so that it throws an exception if `a` is 0.  For example,

```java
    if (a == 0) {
      throw new Exception("Cannot compute quadratic roots of linear functions.");
    } // if (a == 0)
```


b. Extend `smallerRoot` so that it throws an exception if the root is not real (i.e., if it has an imaginary component).  Note that the root is not real if the expression that you're taking a square root of is negative.

c. What now happens if you enter the "erroneous" input described above?

d. Commit and push your changes.

```
git add src/main/java/edu/grinnell/csc207/util/Quadratic.java 
git status
git commit -m "Throw exceptions in smallerRoot"
git pull
git push
```

### Exercise 7: Catching exceptions

_Driver: **B**_

If you've written your `main` method using the recommended template, you have a `throws Exception` clause.  Remove that clause.

a. What effect do you expect removing that line will have?

b. Check your answer experimentally.  Ask one of the class staff if don't understand the results of your experiment.

c. Enclose your call to `smallerRoot` in a try/catch block.  For example, 

```java
    try {
      double root = qpoly.smallerRoot();
      pen.printf("The smaller root of %s is %f\n", qpoly.toString(), root);
      pen.printf("Experimentally, %s is %f\n", qpolty.toString(root),
          qpoly.evaluate(root));
    } catch (Exception e) {
      pen.printf("Sorry, I could not compute a root for %s.\n",
          qpoly.toString());
    } // try/catch
```

d. Determine what happens with the problematic inputs described above.

e. Commit and push your changes.

```text
git add src/main/java/edu/grinnell/csc207/main/QR.java 
git status
git commit -m "QR now handles exceptions appropriately."
git pull
git push
```

### Exercise 8: Catching specific exceptions

_Driver: **A**_

a. Update `smallerRoot` so that it tries to throw a `DivideByZeroException` if the coefficient of the quadratic term is 0.  You can still throw a generic exception if the result includes an imaginary component.

b. What do you expect to happen when you try to compile the revised program?

c. Check your answer experimentally.

### Exercise 9: Your own exceptions

_Driver: **A**_

As you should have determined in the previous exercise, Java does not know by default what a `DivideByZeroException` is.  Hence, you'll need to create your own Exception.  You do so using the strategy described in the [corresponding reading](../readings/exceptions.html).

a. Create and compile a Java file for `DivideByZeroException`.

b. Verify that the previously-modified code now works.

c. Commit and push your changes.

```text
git add src/main/java/edu/grinnell/csc207/util/DivideByZeroException.java 
git status
git commit -m "Add DivideByZeroException"
git pull
git push
```

### Exercise 10: Catching specific exceptions

_Driver: **B**_

. Extend `QR` so that it has a catch clause for your new `DivideByZeroException` _before_ the catch clause for the generic `Exception`.  For example,

```java
    try {
      ...
    } catch (DivideByZeroException dbze) {
      pen.println("Cannot compute a result because the coefficient of the quadratic term is 0.");
    } catch (Exception e) {
      ...
    } // try/catch
```

b. Determine what happens in each of the problematic cases.

c. Commit and push your changes.

```text
git add src/main/java/edu/grinnell/csc207/main/QR.java 
git status
git commit -m "QR now handles exceptions appropriately."
git pull
git push
```

Submitting your work
--------------------

Fill out the lab report on Gradescope.
