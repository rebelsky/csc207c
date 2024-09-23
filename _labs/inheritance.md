---
title: Inheritance
repo: <https://github.com/Grinnell-CSC207/lab-inheritance-maven>
summary: |
  In today's laboratory, you will explore inheritance in Java by
  building and extending some simple classes.
---
Preparation
-----------

a. Fork and clone the repository at {{ page.repo }}. Make sure to use the ssh link when cloning.

b. Open the folder in Visual Studio Code.

c. Update the `README.md` file and push the changed file back to the repository.

```
git add README.md
git status
git commit -m "Personalize the README"
git push
```

d. Read `Counter.java` in package `edu.grinnell.csc207.util` to make sure that you understand what `Counter` objects are expected to do.

e. Open the lab on Gradescope.

Exercises
---------

As always, the person closer to the board is **_A_** and the other person is **_B_**

### Exercise 1: Your base class

_Driver: **A**_

a. Write a class, `BasicCounter`, in package `edu.grinnell.csc207.util`, that implements the `Counter` interface.  The class will allow clients to build objects that count things, starting at some value.

The class should contain

* Two `int` fields, `count` and `start`.  Do *not* make them `private` or `public`.  They can be `protected` or package (i.e., with no explicit modifier).
* One constructor that takes a starting value as a parameter.  The constructor should initialize both `count` and `start` to that value.
* Four methods:
    * `increment()`, which adds 1 to `count` (note that `increment` may throw an exception);
    * `reset()`, which resets `count` to `start`;
    * `toString()`, which returns a string of the form `"[" + this.count + "]"`.
    * `get()`, which returns the value of `count`.

b. Here is a simple, not so systematic, test for that class, that you should add to `CounterTests`. Once you've added it, run the tests and make sure that your class works as expected.

```
  /**
   * Some basic tests of our BasicCounter objects.
   */
  @Test
  public void test1() throws Exception {
    Counter alpha = new BasicCounter(0);
    Counter beta = new BasicCounter(123);
    Counter gamma = new BasicCounter(-5);
    assertEquals(0, alpha.get(), "original alpha");
    assertEquals(123, beta.get(), "original beta");
    assertEquals(-5, gamma.get(), "original gamma");
    for (int i = 0; i < 10; i++) {
      alpha.increment();
      beta.increment();
      gamma.increment();
    } // for
    assertEquals(10, alpha.get(), "updated alpha");
    assertEquals(133, beta.get(), "updated beta");
    assertEquals(5, gamma.get(), "updated gamma");
    alpha.reset();
    beta.reset();
    gamma.reset();
    assertEquals(0, alpha.get(), "reset alpha");
    assertEquals(123, beta.get(), "reset beta");
    assertEquals(-5, gamma.get(), "reset gamma");
  } // test1()
} // class CounterTests
```

c. Fill in the details for the main method of `CounterExperiments`, which you can find in package `edu.grinnell.csc207.experiments`.

```java
  public static void main(String[] args) throws Exception {
    // Set up output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Set up some counters
    Counter alpha = new BasicCounter(0);
    Counter beta = new BasicCounter(123);
    Counter gamma = new BasicCounter(-5);

    // Print original values
    pen.println("Original alpha = " + alpha);
    pen.println("Original beta = " + beta);
    pen.println("Original gamma = " + gamma);
  
    // Print incremented values
    alpha.increment();
    beta.increment();
    gamma.increment();
    pen.println("Updated alpha = " + alpha);
    pen.println("Updated beta = " + beta);
    pen.println("Updated gamma = " + gamma);

    // And we're done
    pen.close();
  } // main(String[])
```

d. Run `CounterExperiments` (either in VSCode or by typing `mvn exec:java`.

e. Push your updated code to GitHub.

```
git add src
git status
git commit -m "Add BasicCounter, along with some tests and some experiments"
git push
```

### Exercise 2: Tally objects

_Driver: **B**_

One of the key ideas of inheritance is that you can create new classes that can inherit behavior from old classes and can stand in for those classes.  So let's try it.  We'll create a class, `Tally`, that behaves much like our `BasicCounter` class.

a. Create a new class, `Tally`, that has the following form:

```java
/**
 * Objects that Tally values.
 */
public class Tally extends BasicCounter {
  /**
   * Create a new Tally.
   *
   * @param start
   *   The initial value of the tally.
   */
  public Tally(int start) {
    super(start);
  } // Tally(int)
} // class Tally
```

b. Change the initialization of `alpha` in the tests and experiments so that it reads

```java
  Counter alpha = new Tally(0);
```

c. What effect to you expect this change to have on the tests or experiments?

d. Check your answer experimentally.

e. How do `Tally` objects differ from `BasicCounter` objects?  Right now, not at all.  How might they differ?  We might want to make `Tally` objects always start at 0, rather than a designated start value.  How can we do that?  With a slightly different constructor.  Replace the constructor of `Tally` with the following.

```java
  /**
   * Create a new Tally.
   */
  public Tally() {
    super(0);
  } // Tally()
```

f. What effect do you expect this change to have?

g. Check your answer experimentally.

h. As you might have predicted, Java issues an error message because you are calling the constructor with the wrong number of parameters.  Rewrite the initialization in `CounterTests` and `CounterExpt` to the following and predict the effect.

```java
  Counter alpha = new Tally();
```

i. Check your answer experimentally.

j. Commit and push your modified code.

```
git add src
git status
git commit -m "Add Tally class and corresponding experiments"
git push
```

k. Summarize what you learned in this exercise.

### Exercise 3: Decrementable BasicCounters

_Driver: **A**_

a. Create a new class, `DecrementableCounter`, that has
the following form:

```java
/**
 * Counters that you can decrement.
 */
public class DecrementableCounter extends BasicCounter {
  /**
   * Create a new decrementable counter.
   *
   * @param start
   *   The initial value of the counter.
   */
  public DecrementableCounter(int start) {
    super(start);
  } // DecrementableCounter(int)
} // class DecrementableCounter
```

b. Change the initialization of `gamma` so that it reads

```java
    Counter gamma = new DecrementableCounter(-5);
```

c. What effect to you expect this change to have on the tests or experiments?

d. Check your answer experimentally.

e. Add a `decrement()` method to `DecrementableCounter`  This method should subtract one from the `count` field.

f. What do you expect to happen if we add the following lines to our 
test and experiment?

```java
    gamma.reset();
    assertEquals(-5, gamma.get(), "reset gamma");
    gamma.decrement();
    assertEquals(-6, gamma.get(), "decremented gamma");
```

g. Check your answer experimentally.

h. Change the declaration of `gamma` to

```java
  DecrementableCounter gamma = new DecrementableCounter(-5);
```

i. What effect do you expect this change to have?

j. Check your answer experimentally.

k. Change the initialization of `gamma` so that it reads

```java
  DecrementableCounter gamma = new BasicCounter(-5);
```

l. What effect to you expect this change to have?  

m. Check your answer experimentally.

n. Restore the initialization of `gamma` to

```java
  DecrementableCounter gamma = new DecrementableCounter(-5);
```

o. Commit and push your changes.

```
git add src
git status
git commit -m "Add DecrementableCounter class"
git push
```

p. Summarize what you learned in this exercise.

### Exercise 4: Naming BasicCounters

_Driver: **B**_

a. Create a new class, `NamedCounter`, that has the following form

```java
/**
 * Counters that have names.
 */
public class NamedCounter extends BasicCounter {
  /**
   * The name associated with the counter.
   */
  String name;

  /**
   * Create a new named counter.
   *
   * @param counterName
   *   The name of the counter.
   * @param start
   *   The starting value (also used for reset).
   */
  public NamedCounter(String counterName, int start) {
    super(start);
    this.name = counterName;
  } // NamedCounter(String, int)
} // class NamedCounter 
```

b. Update your test and experiment so that the initialization of `alpha` reads

```java
    Counter alpha = new NamedCounter("alfa", 0);
```

c. What effect do you expect this change to have?

d. Check your prediction experimentally.

e. Override the `toString` method by inserting the following code into `NamedCounter`.

```java
  /**
   * Convert the counter to a string (e.g., for printing).
   */
  @Override
  public String toString() {
    return this.name + super.toString();
  } // toString()
```

f. What effect do you expect this change to have?

g. Check your prediction experimentally.

h. Swap the two lines in the constructor for `NamedCounter` and determine what errors, if any, you get.  

```
  public NamedCounter(String counterName, int start) {
    this.name = counterName;
    super(start);
  } // NamedCounter(String, int)
```

i. Restore the constructor.

j. Commit and push your changes.

```
git add src
git status
git commit -m "Add NamedCounter class"
git push
```

k. Summarize what you've learned from this exercise.

### Exercise 5: Named counters, revisited

_Driver: **A**_

a. What effect do you expect if we have `NamedCounter` extend `DecrementableCounter` instead of `BasicCounter`?  For example, will we still be able to write the following declaration?

```java
    Counter alpha = new NamedCounter("alfa", 0);
```

b. Check your answer experimentally. That is, change the declaration and then run the experiments and tests again.

c. Add a call to `System.err.println` to each of the constructors so that you can observe when they are called.  For example, you might change the `NamedCounter` constructor to read as follows.

```java
  public NamedCounter(String name, int start) {
    super(start);
    System.err.printf("NamedCounter(%s, %d)\n", name, start); 
  } // NamedCounter(String, int)
```

What do you expect to see as output when your create `alpha`? That is, what constructors are called and in what order?

d. Check your answer experimentally.

e. Comment out the calls to `System.err.println`.

f. Commit and push your code.

```
git add src
git status
git commit -m "Add exploratory messages (now commented out)"
git push
```

f. Summarize what you learned from this exercise.

### Exercise 6: Double counters

_Driver: **B**_

a. Create a new class, `DoubleCounter`, that has the following form

```java
public class DoubleCounter extends BasicCounter {
} // class DoubleCounter 
```

b. What do you expect to happen when you compile this class?

c. Check your answer experimentally.

d. Insert a constructor for `DoubleCounter` of the following form.

```java
public DoubleCounter(int start) {
  super(start);
} // DoubleCounter(int)
```

e. Update your experiment so that the initialization of
`beta` reads

```java
    Counter beta = new DoubleCounter(123);
```

f. What effect do you expect this change to have on your tests or experiments?

g. Check your prediction experimentally.

h. Override the `increment` method by inserting the following code into `DoubleCounter`

```java
  @Override
  public void increment() { 
    super.increment();
    super.increment();
  } // increment()
```

i. What effect do you expect this change to have on your tests and experiments?

j. Check your prediction experimentally.

k. Commit and push your changes.

```
git add src
git status
git commit -m "Add DoubleCounter class"
git push
```

l. Summarize what you've learned from this exercise.

### Exercise 7: Bounded counters

_Driver: **B**_

a. Create a subclass of `BasicCounter` called `BoundedCounter` that includes

* an `int` field named `bound`;
* a constructor that takes two parameters: a starting value and an upper bound (that is, a value for the `bound` field); and
* a modified `increment` method that throws an exception when `count` exceeds the bound.

b. In your test and experiment, determine the results of changing the initialization of `gamma` to

```java
  BasicCounter gamma = new BoundedCounter(-5,3);
```

c. Commit and push.

```
git add src
git status
git commit -m "Add BoundedCounter"
git push
```

d. Summarize what you've learned from this exercise.

### Exercise 8: Double Counters, Revisited

_Driver: **A**_

_Note that for this exercise, you probably just want to use the experiment, rather than the test._

a. Add the following class to your project.

```java
package edu.grinnell.csc207.util;

/**
 * Things that count twice.
 */
public class DblCtr implements Counter {
  /**
   * The underlying counter.
   */
  Counter base;

  /**
   * Build a new counter that counts twice as fast as counter.
   *
   * @param counter
   *   The underlying objet we use for counting.
   */
  public DblCtr(Counter counter) {
    this.base = counter;
  } // DblCtr(Counter)

  /**
   * Increment the counter, twice.
   */
  @Override
  public void increment() { 
    this.base.increment();
    this.base.increment();
  } // increment()

  /**
   * Reset the counter.
   */
  @Override
  public void reset() {
    this.base.reset();
  } // reset()

  /**
   * Get the value.
   *
   * @return
   *   The counter value.
   */
  @Override
  public int get() {
    return this.base.get();
  } // get()

  /**
   * Convert to a string.
   *
   * @return
   *   The counter as a string
   */
  @Override
  public String toString() {
    return this.base.toString();
  } // toString()
} // class DblCtr
```

Note that the technique we are using in `DblCtr` is often referred to as _Delegation_. Delegation usually involves two parts: First, we include another object, the delegate, that we will use to do most of the work. Second, for each function call, we do a corresponding call to the delegate.

b. Update your experiment so that the initialization of `beta` reads

```java
    Counter beta = new DblCtr(new BasicCounter(0));
```

c. What effect do you expect this change to have on the output?

d. Check your prediction experimentally.

e. Update your experiment so that the initialiation of `beta` reads

```java
    Counter beta = new DblCter(new NamedCounter("dc", 0));
```

f. What effect do you expect this change to have on the output?

g. Check your predication experimentally.

h. Update your experiment so that the initialization of
`beta` reads

```java
    Counter beta = new DblCtr(new DblCtr(new BasicCounter(0)));
```

i. What effect do you expect this change to have on the output?

j. Check your prediction experimentally.

k. Commit and push

```
git add src
git status
git commit -m "Add DblCtr."
git push
```

l. Summarize what you learned from this exercise.

## Turning it in

Hopefully, you've been filling in your answers on Gradescope as you go. So check that you've filled in the answers and click **Subit*.

