---
title: Unit testing
repo: <https://github.com/Grinnell-CSC207/lab-unit-testing-2019>
summary: |
  In this laboratory, you will explore the JUnit unit testing framework, VSCodes's facilities for using JUnit, and the basics of Unit testing.
todo: 
  - Add something on testing for exceptions (not right now).
---

Preparation
-----------

a. Make sure you’ve read [the related reading](../readings/unit-testing).  You may find it helpful to have it open in a separate tab.

b. Fork and clone the repository at <https://github.com/Grinnell-CSC207/lab-unit-testing-vscode> (alternately <git@github.com:Grinnell-CSC207/lab-unit-testing-vscode.git>).  Then import the project into VScode.

c. Make a copy of the JUnit jar file, [`junit-platform-console-standalone-1.10.0.jar`](https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/junit-platform-console-standalone-1.10.0.jar).

d. Add the JUnit file to your classpath.

* Type Shift-Ctrl-P to bring up the command palette.
* Type "Java: Configure ClassPath".
* Make sure that you are configuring the right project.
* At the bottom of the window, you should see a section entitled "Referenced Libraries".  Click "Add".
* Navigate to the `junit-platform-console-standalone-1.10.0.jar` file and click "Select Jar File".

Exercises
---------

### Exercise 1: Getting started

a. Skim through the file `TestSampleMethods.java` to see what tests we've provided for you.

b. You should see a icon on the left side of your VSCode window that looks a bit like a beaker.  Click on it.

c. You should see a "Play" button (a right facing triangle) within `lab-unit-testing-vscode`.  Click it.  Observe what happens.

d. You may have noted that the successful test succeeded and nothing happened with the failing test.  That's because there was no `@Test` annotation before the failing test.  Add it.

e. Try clicking the "Play" button again.  Observe what happens.

f. Remove the `@Test` annotation.

### Exercise 2: More experiments

a. Create a new method that looks like the following:

```java
  public void test2() {
    fail("Not yet implemented");
  } // test2()
```

b. What do you expect to happen when you run your test?

c. Check your answer experimentally.

d. Insert the annotation `@Test` before the declaration of `test2`.  Then determine what happens when you run your test code.

e. Change the body of `test2` to the following.  Then observe what happens when you run your test code.

```java
    assertEquals(10, 3*5, "stupid test");
```

This test is supposed to fail.  It's there to demonstrate that (a) you can add a message to `assertEquals`, (b) you can include computations in the body of `assertEquals`, and (c) `assertEquals` treats the first non-message value as the expected value and the second value as the received value.

### Exercise 3: Temperature conversion

You've seen how VSCode lets you create and run tests.  Now it's time to write a few of your own.

a. We know that 0 degrees Celsius is 32 degrees Fahrenheit.  Write a test that verifies that `SampleMethods.c2f` computes the expected value.

b. We know that 100 degrees Celsius is 212 degrees Fahrenheit.  Write a test that verifies that `SampleMethods.c2f` computes the expected value.

c. Run your tests.

d. If your tests reveal errors in `c2f`, correct the code.  Then run the tests again.

e. Write any other tests you think are relevant.  If the tests reveal errors, correct the code and then run the tests again.

### Exercise 4: Testing simple sums

a. Read the documentation for `sum`

b. Create a new test class and write some simple tests for `sum`.  Note that you can create an array of integers with an instruction like the following.

```java
    int[] values = { 1, 2, 3 };
```

c. Attempt to fix any errors that your tests revealed.

d. Write a few more tests.  Fix any more errors that you notice.

e. Consider the following test.  Does it meet the preconditions of `sum`?  Do you expect your code to pass the test?  

```java
  public void testExtremes() {
     int tmp = Integer.MAX_VALUE - 10;
     int[] values = { tmp, tmp, -tmp, -tmp };
     assertEquals(0, sum(values), "extreme values");
  } // testExtremes
```

f.  If your code does not pass the test (or if you believe that your code should not pass the test because integer overflows are supposed to break things), you have multiple options.  One option is to fix your code to handle situations like this.  Another is to rewrite the preconditions (e.g., "For every subset of ints, the sum of that subset is greater than `Integer.MIN_VALUE` and less than `Integer.MAX_VALUE`).  Another is to say that the test is so stupid that it shouldn't matter.  _Which approach do you prefer and why?_

### Exercise 5: Writing multiple test cases

Read the documentation for the `expt` method.

Rather than writing individual test cases for this function, we should be able to write a loop that does multiple test cases, something like the following:

```text
Let expected be 1
For power = 0 to K
    Confirm that expected = expt(2,power)
    expected = expected * 2
```

a. Create a new test class and then add a test that follows that strategy.

b. Determine if `expt` works as advertised.  It probably won't.  But debugging the code is a task for another day.  Instead, we're going to write more tests.

c. Right now, your test only uses a base of 2.  Rewrite your test so that it tries multiple bases, both positive and negative.  Strive for concise testing code.

For those with extra time
-------------------------

### Extra 1: Removing A's

Write tests for the `removeAs` method.  Fix the method if necessary.

### Extra 2: Removing B's

Write tests for the `removeBs` method.  Fix the method if necessary.

### Extra 3: Sharing tests

Incorporate tests from other groups for `removeAs` and `removeBs`
and see if your repaired code passes their tests, too.

