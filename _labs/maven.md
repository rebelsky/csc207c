---
title: Getting started with Maven
summary: |
  In this laboratory, you will practice using Maven.
---

_Note: There is nothing to turn in for this lab. The lab's primary goal is to ensure that you've practiced a bit with Maven and (potentially) experienced some of the complexities._

_Note: This lab is all new for Fall 2024. There may be unexpected problems._

## Preparation

a. Make sure that you've completed a reasonable amount of the [Getting started with Java](../labs/getting-started) lab. In particular, you should have,

* A file hierarchy for the packages `edu.grinnell.csc207.util`, `edu.grinnell.csc207.main`, and `edu.grinnell.csc207.experiments`.
* A `HelloWorld` class in the `main` package.
* A `FizzBuzz` class in the `util` package.
* An `ArrayUtils` class in the `util` package.
* A `FizzBuzzOne` class in the `main` package.
* A `MinExperiments` class in the `experiments` package.

All of these files should compile successfully.

b. Make sure that you have [the reading on Maven](../readings/maven) available to you.

## Exercises

### Exercise 1: Set up the Maven project

**Driver: _A_**

_As you've learned, when we create a new Maven project, we have to do some configuration. Let's start there._

a. Set up a new project using the instructions. Make sure to use `edu.grinnell.csc207` as the groupId and `maven-sample` as the artifactID.

b. In `edu.grinnell.csc207`, you should have a file called `App.java`. Take a quick look at the file to make sure you understand what it should do.

c. Compile the project with `mvn compile` or `mvn compile -q`.

d. When we compiled using `javac`, we found that the compiled files ended up in the same directory as the `.java` files, which may not be ideal. Determine where the `.class` files end up in Maven.

e. Once you know where the `.class` files end up, run the compiled `App.java`.

f. Make a change to the output in `App.java`, recompile, and re-run to make sure that the change has taken effect.

g. Determine the results of running `mvn clean` or `mvn clean -q`.

h. Update your `pom.xml` to use Java 17.

### Exercise 2: Setting up the project files

**Driver: _B_**

_We have directories set up, but no files. Fortunately, we've started a project, so we'll move them over._

a. `App.java` is a placeholder. Get rid of it.

b. Set up directories for your three Java packages. This will entail making subdirectories of `src/main/java/edu/grinnell/csc207/`.

c. Copy the `.java` files from your previous lab over to this project.

d. Ensure that you can compile all the files with `mvn compile` or 
`mvn compile -q`.

e. Make sure that you can run at least one of the main classes. (Warning: The top level of the Maven project is not the top level of the Java package hierarchy; you may need to change your location.)

### Exercise 3: Create a jar file

**Driver: _A_**

_The normal outcome of a Maven project is a `.jar` file that contains the code and other useful stuff._

a. Create the `.jar` file for this project using `mvn package` or `mvn package -q`.

b. Find the jarfile.

c. Run one of the main files with `java -cp JARFILE edu.grinnell.csc207.main.HelloWorld` (or something similar).

d. Determine what's in the `.jar` file with `jar tf JARFILE`.  Most important is that it includes the `.class` files in the appropriate location.

### Exercise 4: Select a main class for the jar file to run

**Driver: _B_**

_Ideally, if a project is intended to be executed, it has a designated main class that should be run._

a. Add the appropriate code to your `pom.xml` file to ensure that your `FizzBuzzOne` class is used as the default class to run. You will need to check the reading for the particular XML to use.

b. Rebuild your `.jar` file.

c. Try executing your `.jar` file with `java -jar JARFILE` to ensure that you get FizzBuzz to run..

### Exercise 5: Syntax checking and such

**Driver: _A_**

_We should not be able to build the `.jar` file if there are syntax or other errors in our programs._

a. Make a change to one of your `.java` files that is likely to cause problems. For example, remove a semicolon.

b. Try to rebuild the `.jar` file and determine what happens.

c. Repair the error(s) you introduced.

### Exercise 6: Testing

**Driver: _B_**

_Ideally, we will test our code regularly. Since you don't yet know how to write unit tests, we're providing some for you._

a. Update the `pom.xml` file to use JUnit 5. The [reading](../readings/maven) contains instructions how.

b. Run `mvn test` or `mvn test -q` to see what happens.

c. Create the directory `src/test/java/edu/grinnell/csc207/util`

```
mkdir -p src/test/java/edu/grinnell/csc207/util
```

d. Add the file `ArrayMinTests.java` with the following contents.

```
package edu.grinnell.csc207.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests of the ArrayUtils.min method.
 */
public class ArrayMinTests {
  /**
   * An array with one value.
   */
  @Test
  public void oneValueTest() {
    assertEquals(0, ArrayUtils.min(new int[] { 0 }), "Just zero");
  } // oneValueTest()

  /**
   * Smallest at the front.
   */
  @Test
  public void smallestFirstTest() {
    assertEquals(1, ArrayUtils.min(new int[] { 1, 2, 3 }), "Smallest first");
  } // smallestFirstTest()

  /**
   * Smallest at the end
   */
  @Test
  public void smallestLastTest() {
    assertEquals(2, ArrayUtils.min(new int[] { 7, 4, 3, 8, 2 }),
        "Smallest last");
  } // smallestLastTest()
} // class ArrayMinTests
```

e. Run `mvn test` or `mvn test -q` to see what happens.

f. Update `ArrayUtils.min` to return always return 0 rather than the smallest value.

g. Run `mvn test` or `mvn test -q` to see what happens.

h. Restore the `min` method.

### Exercise 7: Checking style

**Driver: _A_**

_Finally, we turn to style. Almost anywhere you end up working, you'll find that there's a "house style" that you should follow. Maven (well, the checkstyle tool that Maven can incorporate) helps you identify stylistic problems. And, unlike failed tests, failed style issues won't stop you from packaging your project. (They will, however, prevent you from getting an M or an E.)_

a. Add the checkstyle plugin information from [the reading](../readings/maven) to  your `pom.xml` file.

b. Download [`csc-207-checks.xml`](../files/csc207-checks.xml) and put it at the top level of your project (that is, in the same directory as your `pom.xml` file).

c. Run `mvn checkstyle:check` or `mvn checkstyle:check -q` to check your style.

d. Fix your stylistic errors. Ask the course staff if you don't understand them.

## Wrapping up

Although there's nothing to turn in for this lab, you should make sure that both partners have access to all the files. One easy way to do so is to zip everything up and send the `.zip` file to your partner.
