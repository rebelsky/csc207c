---
title: Mini-Project 4
subtitle: Associative arrays
repo: <https://github.com/Grinnell-CSC207/mp-associative-arrays-maven>
librepo: <https://github.com/Grinnell-CSC207/aaLibrary>
summary: |
  We build our first data structure.  Along the way, we practice with
  generics/parametric polymorphism.
collaboration: |
  Each student should submit their own responses to this project. You may
  consult other students in the class as you develop your solution.  If you
  receive help from anyone, make sure to cite them in your responses.
link: true
---
_Please do not read over this mini-project until we have discussed it in class._

## Introduction

An _associative array_ is a common data structure, similar to the association lists (or hashes) that you may have learned about in CSC-151.  Since it's a data structure, we'll start by considering the layout of the associative array in memory.

In essence, an associative array is an (expandable) array of key/value pairs, intended to support looking up values by key.  I think of them something like the following:

```
        +---+
  size: | 3 |
        +---+

  pairs:
  +---+                                                +---+---+
  | *-------------------------------------------------> | * | * |
  +---+                                +---+---+        +-|-+-|-+
  | *--------------------------------> | * | * |          |   v
  +---+              +---+---+         +-|-+-|-+          | +----------+
  | *--------------> | * | * |           |   v            | | V value0 |
  +---+              +-|-+-|-+           | +----------+   | +----------+
  | / |                |   v             | | V value1 |   v
  +---+                | +----------+    | +----------+ +--------+
  | / |                | | V value2 |    |              | K key0 |
  +---+                | +----------+    v              +--------+
  | / |                |               +--------+
  +---+                |               | K key1 |
  |   |                v               +--------+
    .                +--------+
    .                | K key2 |
    .                +--------+
```

That is, we have an array of Key/Value pairs along with an accompanying `size` field to keep track of how many pairs are in the array.  The array may have some empty space, which we fill with `null` values.  In the diagram, we've put all the nulls at the end.  However, you might decide that it's more natural to leave some nulls in the middle.

Associative arrays are most frequently used to implement the `Dictionary` or `Map` abstract data types.  Both are names for structures that allow you to store associate values with corresponding keys.  (Each key has only one value; multiple valeus may have the same key.)

The central methods for such types include the following:

`public void set(K key, V value)`
  : Set the value associated with a given key.  If there is already another value associated with the given key, this new value replaces that value.

`public V get(K key)`
  : Get the value associated with a given key.  If there is no such key, throws an exception.

`public boolean hasKey(K key)`
  : Determine if the given key appears in the associative array.

`public void remove(K key)`
  : Remove the key/value pair associated with the given key.  If the key does not appear in the associative array, does nothing.

`public int size()`
  : Determine how many different key/value pairs are currently stored in the associative array.

`public String toString()`
  : Return a string of the form `"{key0:value0, key1:value1, ... keyn:valuen}"`  If the array is empty, you should return `"{}"`.

`public AssociativeArray<K,V> clone()`
  : Make a copy of the associative array.

As you might expect, the first four procedures will need to iterate the array of key/value pairs, stopping when they find a matching key or run out of pairs.  We normally use the `equals` method to determine matching keys.

## Getting ready

We will be sharing test cases in this project, which means that we will have two GitHub repositories: One for your `AssociativeArray` code and one for the shared tests. Using the strategy means that we'll have to do a slightly more complex setup. _Cross your fingers that it works correctly._

a. Fork the repository at {{ page.repo }}.

b. Clone that repository.

```text
cd ~/CSC207/MPs                 # Or the directory of your choice
git clone git@github.com:USERNAME/mp-associative-arrays-maven.git
```

c. Open the project in VSCode.

d. Update the `README.md` appropriately.

e. Push the updated `README` to GitHub.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-associative-arrays-maven
git add README.md
git status
git commit -m "Update README to include myself."
git pull
git push
```

f. Add an upstream repository just in case I make changes.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-associative-arrays-maven
git remote add upstream https://github.com/Grinnell-CSC207/mp-associative-arrays-maven
```

In the future, you can grab changes using the following.

```text
git fetch upstream
git merge upstream/main
```

You can also just click the **Sync Fork** button on your GitHub page for the fork.

g. Make sure that you can run the experiment in VSCode.

h. You should see two sets of testing files. Make sure that you can run the current tests in VSCode.

i. Make sure that you can run the experiment in Maven.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-associative-arrays-maven
mvn exec:java -q
```

j. Make sure that you can run the tests in Maven.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-associative-arrays-maven
mvn tests
```

h. Add some point, you should have received an invitation to our testing repo. If you didn't receive such an invitation, contact SamR asap. **Do not fork the testing repo. You will be pushing directly to that repo.**

i. Clone the testing repository using the name `shared` and place it in `src/test/java/edu/grinnell/csc207`

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-associative-arrays-maven
cd src/test/java/edu/grinnell/csc207
git clone git@github.com:rebelsky/csc207-2024fa-associative-array-tests.git shared
```

j. Make sure that the new folder and test file show up in VSCode. You may have to quit and restart.

k. Make sure that you can run the new tests in VSCode.

l. Make sure that you can run the new tests in Maven.

## The assignment

### Part one: Write tests

As you know, good practice suggests that you should write tests before writing code. So start by writing tests. And the earlier you write tests, the better you support not just yourself, but your classmates.

Add at least three tests, including at least two "normal" cases and at least one edge case, to `TestAssociativeArrays.java` in the shared testing repository.  Please name them with a form like `lastFirstTest1()`, `lastFirstTest2()`, and `lastFirstEdge1()`.  For example, mine would be `rebelskySamuelTest1()`, `rebelskySamuelTest2()`, and `rebelskySamuelEdge1()`.

_Make sure that your tests do not break the test suite!_

Do not test the `toString` method; there are too many potential orders for the K/V pairs.

You should use the following process to add your tests.

a\. Open `TestAssociativeArrays.java` in VSCode.

b\. Add your tests. Do your best to make sure that they are sensible. Ensure that they compile. Make sure that they are in the section of the file with your name. Your tests likely won't pass since we haven't written working code yet.

c\. In the terminal, `cd` to the shared directory.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-associative-arrays-maven
cd src/test/java/edu/grinnell/csc207/shared
```

d\. Verify that you've made the appropriate changes.

```text
git status
git diff
```

e\. Commit your changes.

```text
git add TestAssociativeArrays.java
git commit -m "Add my amazing tests."
```

f\. As you know, you can't push to a repository if it's changed since you last pulled. Hence, it's good practice to pull before pushing. Pull from the repository.

```text
git pull
```

g\. Ideally, you haven't gotten any merge conflicts and you haven't seen any problems. If you have merge conflicts and feel like you can resolve them yourself, please do so. If you have merge conflicts and can't resolve them, or find that the code is broken, please reach out to SamR on Teams. (Don't go on to the next step.)

h\. You should now be able to push your changes (unless someone pushed their own changes while you were looking at the updated file).

```text
git push
```

i\. Drop me a message on teams so that I know that you've completed this step and can check your tests. (I may not check them immediately.)

j\. You should make it a habit to regularly pull the updated tests.

### Part two: Implement Associative Arrays

Implement the `AssociativeArray<K,V>` class in Java.  You may _not_ use any other Java classes that provide similar features, such as `java.util.HashMap`; you must rely on an underlying plain Java array of `KVPair<K,V>` objects.

### Part three: Make sure to test your code

You have three sets of tests to run.

* The tests I may provide, which appear as `TestsFromSam.java`.
* The tests you may decide to add before sharing, which appear as `TestsFromStudent.java`.
* The shared set of tests, which appear as `shared/TestAssociativeArrays.java`.

You should make sure to update the first and last of those with some regularity.

If you prefer visual interfaces, you can update my tests by visiting your repo on GitHub and clicking **Sync Fork**.

If you prefer textual interfaces, you can update my tests by switching to the top level of your project and using the appropriate commands.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-associative-arrays-maven
git fetch upstream
git merge upstream/main
```

You can pull updates to the shared tests using the steps we discussed earlier.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-associative-arrays-maven
cd src/test/java/edu/grinnell/csc207/shared
git pull
```

## Submitting your work

Please submit all of your work on the project to Gradescope by using the GitHub submission mechanism. 

## Approximate rubric

_I am likely to revisit this rubric._

### Redo or above

Submissions that fail to meet any of these requirements will get an I.

```text
[ ] Passes all the R tests.
[ ] Each class has an introductory Javadoc comment that indicates the author and purpose.
[ ] Includes a `README.md` file that contains the appropriate information
    (authors, purpose, acknowledgements if appropriate).
[ ] All files compile correctly.
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```text
[ ] Passes all the M tests.
[ ] No more than ten errors from `mvn checkstyle:check`.
[ ] Added three tests to the `AssociativeArrayTests.java` file.
[ ] One of those three tests is an edge case (preferably named as such).
[ ] The `toString()` method appears to behave correctly. (Since the ordering
    of key/value pairs is somewhat open, we can't readily check this with
    unit tests.)
```

### Exemplary / Exceeds expectations

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an M.

```text
[ ] Passes all of the E tests.
    [ ] Correctly handles `null` keys in `set`, `get`, and `hasKey`.
[ ] All (or most) repeated code has been factored out into individual methods.
[ ] All or most variable names are appropriate.
[ ] No errors from `mvn checkstyle:check`.
```

Questions and Answers
---------------------

_More forthcoming._

### Design

**Why does `set` potentially throw a `NullKeyException`?**

> We want to disallow the client from calling `aa.set(null, something)`. Our options are either (a) ignore the call altogether, (b) don't check for the null, and let whatever happens happen, or (c) inform the client they've done something improper. I've chosen the last of the three.

### Testing

**When will you provide us with more tests (in `TestsFromSam`)?**

> Since a key part of this assignment is writing tests, I may never provide you with such tests. One would hope that 40+ students working together should be able to catch most errors.

**What happens if someone pushes a faulty test?**

> If someone pushes a faulty test, we hope that someone catches it quickly and lets me know. (Or that I catch it quickly.)

**Since we're pushing tests before we write, how should we approach writing tests? I would imagine too complicated tests from the beginning defeat the purpose of test driven.**

> There are multiple perspectives on test-drive design. One is that you write a few tests, make your code pass them, write a few more, make your code pass them, and so on and so forth.

> I find that there are disadvantages to that strategy. Foremost among those is that once you've started to write code, you've developed a mental model of what should be happening. Writing the tests first let you think more broadly about what could go wrong. Hence, I prefer to see early tests, even if we don't pass them all.

> In terms of what happens, we'll want some simple tests and some more complicated tests. When using tests, our hope is that each test gets us closer to correct code. The count of remaining tests to pass gives us a sense of progress.

**Is it okay to have tests similar to other peoples?**

> I expect that few people will be looking at the tests, so I assume that we'll see some similar tests.

**Since everyone will be uploading tests, how reasonable is it to look through everyone's before pushing our own?**

> You can fill free to read or ignore other people's tests. 

> If you base your test on someone else's code, you should cite them in the comment for that test.

> Looking at other people's tests so that you can find something to test that they haven't would be awesome.

**How do you write tests with generic variables?**

> You don't really write tests with generic variables. Your tests will need to instantiate the types. For example, you might test an AssociativeArray that maps `String`s to `BigInteger`s or vice versa. We hope that different people will try to test with different types.

**Can multiple people write the same tests?**

> Yes, I assume it is inevitable that we will get similar tests.

### Miscellaneous

**Can we reuse code from this assignment on other assignments as long as we cite ourselves??**

> Certainly.

**Does Java have a `Pair` class?**

> I don't know of a standard one, but the assignment repo comes with a `KVPair`
  class. (If I hadn't provided one, you could also have written your own.)

**What does 'git diff' do? You used it in the setting up section of MP4 instructions, but I don't think we've seen that call before.*

> `git diff` compares the current state of the repository (or a file, if you write `git diff file`) to the last commit. Along with `git status`, it's an easy way to review your changes.


