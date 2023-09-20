---
title: Exceptions in Java
repo: <https://github.com/Grinnell-CSC207/lab-exceptions-vscode>
summary: |
  We explore some basic use of exceptions in Java
prereqs: |
  Classes and interfaces.
---

Preparation
-----------

a. Fork and clone the repository at {{ page.repo }}.  (You don't really need to fork the repo, but if you don't, it's harder to share your work with your partner.)

b. Import the repository into VSCode.

c. Quickly skim the code to determine the purpose of the various portions.

Exercises
---------

### Exercise 1: Exception basics

a. Remove the `throws Exception` from the `main` method and determine what, if any, error messages you get.  If VSCode permits you to do so, try running the program. 

After you finish exploring the effects of that removal, reinsert the `throws` clause.

b. Remove the `throws Exception` from the definition of `readInt` and determine what, if any, error messages you get.  If VSCode permits you to do so, try running the program with that warning removed.

Do not reinsert the `throws` clause.

c. Within `readInt`, you should have a sequence of lines (or perhaps a single line) that looks something like the following:


```
    String response = br.readLine();
    return Integer.parseInt(response);
```


Enclose those lines in a try/catch clause that returns 0 if an exception is thrown, as in

```
    try {
      String response = br.readLine();
      return Integer.parseInt(response);
    } catch (Exception e) {
      return 0;
    } // Reading/parsing fails.
```

d. Verify that VSCode is no longer concerned about errors in your code.

e. Determine what happens when the user enters an invalid value (such as `Hello`) in response to a request for an integer.

### Exercise 2: Computing A Quadratic Root

Add a static `smallQuadraticRoot(double a, double b, double c)` method to the `MathUtils` class.  The method should compute the smaller of the two roots of a quadratic expression.

Note that you can use the following formula to compute that root: $$(-b - \sqrt{b^2 - 4ac})/2a$$

You will, of course, have to translate that mathematical expression into Java code.

b. Write a few simple unit tests for that procedure.  Note that you are likely to find it easier of you choose quadratics for which you know the solution.  For example,

* If we multiply $$x-2$$ and $$x+5$$, giving us $$x^2 +3x -10$$, we
  know that the roots are $$2$$ and $$-5$$.
* If we multiply $$2x+3$$ and $$3x-4$$, giving us us $$6x^2 + x -12$$,
  we know that the roots are $$-3/2$$ and $$4/3$$.

### Exercise 3: Adding user input

a. Write a new main class, `QR`, which

* prompts the user for coefficients of a quadratic function,
* computes the smaller root of the quadratic,
* prints that root, and
* prints the value of the quadratic at that root.

b. Use your class to compute the smaller root of $$x^2 - x - 2$$.  (The roots of that quadratic are $$2 and $$-1$$.

### Exercise 4: Erroneous input

a. Determine what happens if the user enters 0 for the coefficient of $$x^2$$.

b. Determine what happens if user enters coefficients for which there is no real root.

c. Determine what happens if the user enters values for which the function has only one root (e.g., $$x^2 - 2x + 1$$ has only one root).

### Exercise 5: Indicating potential errors

a. Extend `smallerQuadraticRoot` to indicate that it may throw an exception.  Note that you'll need to change the method signature for `smallerQuadraticRoot` to something like the following.

```
  public static double smallerQuadraticRoot(double a, double b, double c) throws Exception {
```

b. Can you successfully compile your modified code?  If not, make any changes necessary to permit you to compile it.

c. Can you successfully compile `QR`?  If not, get help from one of the class staff.

d. What now happens if you enter the "erroneous" input described
  in the previous exercise?

### Exercise 6: Throwing exceptions

a. Extend `smallerQuadraticRoot` so that it throws an exception if `a` is 0.  For example,

```
    if (a == 0) {
      throw new Exception("Cannot compute quadratic roots of linear functions.");
    } // if (a == 0)
```


b. Extend `smallerQuadraticRoot` so that it throws an exception if the root is not real (i.e., if it has an imaginary component).  Note that the root is not real if the expression that you're taking a square root of is negative.

c. What now happens if you enter the "erroneous" input described above?

### Exercise 7: Catching exceptions

If you've written your `main` method using the recommended template, you have a `throws Exception` clause.  Remove that clause.

a. What effect do you expect removing that line will have?

b. Check your answer experimentally.  Ask one of the class staff if don't understand the results of your experiment.

c. Enclose your call to `smallerQuadraticRoot` in a try/catch block.  For example, 

```
    try {
      double root = f.smallerQuadraticRoot(a,b,c);
      pen.println("The smaller root of the polynomial is: " + root);
      pen.println("Experimentally, " + a + "*" + root + "*" + root
          + "+" + b + "*" + root + "+" + c + " = " 
          + (a*root*root + b*root + c));
    } catch (Exception e) {
      pen.println("Sorry, I could not compute a root.");
    } // catch (Exception)
```


d. Determine what happens with the problematic inputs described above.

### Exercise 8: Catching specific exceptions

a. Update `smallerQuadraticRoot` so that it tries to throw a `DivideByZeroException` if the coefficient of the quadratic term is 0.  You can still throw a generic exception if the result includes an imaginary component.

b. What do you expect to happen when you try to compile the revised program?

c. Check your answer experimentally.

### Exercise 9: Your own exceptions

As you should have determined in the previous exercise, Java does not know by default what a `DivideByZeroException` is.  Hence, you'll need to create your own Exception.  You do so using the strategy described in the [corresponding reading](../readings/exceptions.html).

a. Create and compile a Java file for `DivideByZeroException`.

b. Verify that the previously-modified code now works.

### Exercise 10: Catching specific exceptions

. Extend `QR` so that it has a catch clause for your new `DivideByZeroException` _before_ the catch clause for the generic `Exception`.  For example,

```
    try {
      ...
    } catch (DivideByZeroException dbze) {
      pen.println("Cannot compute a result because the coefficient of the quadratic term is 0.");
    } catch (Exception e) {
      ...
    } // catch (Exception)
```


b. Determine what happens in each of the problematic cases.

c. What do your results for this exercise suggest?

