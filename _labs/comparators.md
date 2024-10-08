---
title: Comparators
repo: <https://github.com/Grinnell-CSC207/lab-comparators-maven>
summary: |
  We explore comparators in Java. We also touch a bit on anonymous inner classes and lambdas.
javadoc:
  - "[`java.util.Comparator`]({{ site.java_api }}/java/util/Comparator.html)"
  - "[`java.util.PriorityQueue`]({{ site.java_api }}/java/util/PriorityQueue.html)"
---
_This lab was newly written for Fall 2024. There may be some infelicities. Please let Sam know about any issues you identify._

Useful documentation
--------------------

* [`java.util.Comparator`]({{ site.java_api }}/java/util/Comparator.html)
* [`java.util.PriorityQueue`]({{ site.java_api }}/java/util/PriorityQueue.html)

Preparation
-----------

a. Fork the repo at {{ page.repo }}.

b. Clone your fork. Make sure to use the ssh link.

c. Open the repo in VSCode.

d. Add your names to the `README.md` file.

c. Commit and push your changes.

```text
git add README.md
git status
git commit -m "Claim ownership of project"
git pull
git push
```

Exercises
---------

### Exercise 1: Rehashing the reading

_Driver: **A**_

The file `SortInts.java` (in package `edu.grinnell.csc207.Experiments`) contains much of the code from [the reading on comparator](../readings/comparators). It's also set as the default executable in our `pom.xml`.

a. Read through `SortInts.java` to make sure that you understand how it should behave.

b. Compile the code with `mvn compile package -q`. (Since we'll be entering information on the command line, we'll find it easier to use Maven than VSCode.)

c. Look at the `pom.xml` file to ensure that it uses `SortInts.java` as the main class in the package.

d. Predict what output you'll get if you type the following.

```text
java -jar target/*.jar 5 -4 3 -8 2 9 1
```

e. Try a few other inputs, too.

### Exercise 2: Rehashing the reading, revisited

_Driver: **B**_

a. The reading claimed that we would get the same result if we used `AbsoluteValueComparator2` rather than `AbsoluteValueComparator1`. Check that claim experimentally. (That is, update the class to use `AbsoluteValueComparator2`, recompile and repackage, and then run the same command.)

b. What output do you expect for the following command? (`2147483647` is `Integer.MAX_VALUE)

```text
java -jar target/*.jar 0 2147483647
```

c. Check your answer experimentally.

d. What output do you expect for the following command?

```text
java -jar target/*.jar 0 -2147483647
```

e. Check your answer experimentally.

f. What output do you expect for the following command? (`-2147483648` is `Integer.MIN_VALUE`)

```text
java -jar target/*.jar 0 -2147483648
```

g. Check your answer experimentally.

### Exercise 3: Rehashing the reading, re-revisited

_Driver: **A**_

a. Replace the call to `sort` with `new AbsoluteValueComparator2()` (or `new AbsoluteValueComparator1()`) to one that uses a call to a similar comparator created as an anonymous inner class. (Check the reading for what this anonymous inner class might look like.)

b. Compile, package, and run your code to make sure it works correctly.

c. Comment out that call to `sort` and write a new one using a lambda. (Check the reading for what this might look like.)

d. Compile, package, and run your code to make sure it works correctly.

e. Add, commit, and push your modified code.

```text
git add src/main/java/edu/grinnell/csc207/experiments/SortInts.java
git status
git commit -m "Experiment with various comparitors"
git pull
git push
```

### Exercise 4: New integer comparators

_Driver: **B**_

a. Update the code to sort the integers by their last digit. Please name the comparator before using it, as in,

```java
    Comparator<Integer> compareByLastDigit =
        (i1, i2) -> ...
    Arrays.sort(vals, compareByLastDigit);
```

You should see a result something like this.

```
$ mvn compile package -q
$ java -jar target/*.jar 805 -22 33 9 1111
[805, -22, 33, 9, 1111] -> [1111, -22, 33, 805, 9]
```

Note that you should treat two numbers as equal if they have the same last digit (e.g., 101, 31, 1, and -1 should all be treated as equal).

Note that you can get the last digit of a number by `Math.abs(num % 10)`.

b. Add, commit, and push.

```
git add src/main/java/edu/grinnell/csc207/experiments/SortInts.java
git status
git commit -m "Add 'compare by last digit'"
git pull
git push
```

### Exercise 5: String comparators

_Driver: **A**_

a. Update the `pom.xml` file to use `SortStrings` rather than `SortInts`.

b. Read through `SortStrings.java` to understand what it does.

c. Compile, package, and run your code to see that it behaves as expected.

```
mvn compile package
java -jar target/*.jar the quick Brown fox Jumped over the Lazy dog
```

d. Write a new comparator that compares strings by length. If two strings have the same length, treat them as equal.

e. Extend the comparator so that if two strings have the same length, they should be compared alphabetically.

f. Add, commit, and push

```text
git add pom.xml
git status
git commit -m "New primary class: SortString"

git add src/main/java/edu/grinnell/csc207/experiments/SortStrings.java
git status
git commit -m "Update SortStrings to sort by length."

git pull
git push
```

### Exercise 6: Anonymous comparators and priority queues

_Driver: **B**_

a. Update the `pom.xml` file to use `PirorityQueueExperiment` rather than `SortStrings`.

b. Finish writing `PriorityQueueExperiment`. You'll need to add all the strings in `args` (using `put`) and then remove the strings (with `get`) and print them in turn.

c. Check that it works as expected.

d. Update `PriorityQueueExperiment` so that the priority queue orders by string length, rather than alphabetically.

e. Check that it works as expected.

f. Add, commit, and push.

```text
git add pom.xml
git status
git commit -m "New primary class: PriorityQueueExperiment"

git add src/main/java/edu/grinnell/csc207/experiments/PriorityQueueExperiment.java
git status
git commit -m "Finish PriorityQueueExperiment"

git pull
git push
```


Submitting your work
--------------------

You will submit your work on Gradescope.

