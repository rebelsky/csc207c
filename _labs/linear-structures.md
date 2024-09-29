---
title: Linear structures
summary: | 
  In this laboratory, you will have an opportunity to ground your
  understanding of linear structures, including both array-based
  and linked structures.
repo: <https://github.com/Grinnell-CSC207/lab-linear-structures-maven>
link: true
---

Preparation
-----------

a. Open [the reading on linear structures](../readings/linear-structures), [the reading on stacks](../readings/stacks), and [the reading on queues](../readings/queues) in separate tabs.

b. Fork the repo at {{ page.repo }}. 

c. Clone the repo. Make sure to use the SSH link.

d. Open the cloned repository in VSCode.

e. Add your names to `README.md`.

f. Commit your change.

```
git add README.md
git status
git commit -m "Claim partial responsibility."
git pull
git push
```

Exercises
---------

### Exercise 1: Basic experiments

_Driver: **A**_

Read through `LinearStructureExperiment.java` and `LinkedStackExperiment.java`.  Summarize what the stack should look like at each step.  (A piece of paper or whiteboard might help.)  Note that the `info` method will print information on the stack (is it empty? is it full? what elements are in the structure?) and the `clear` method will repeatedly call `get` until the structure is empty.

Run `LinkedStackExperiment` and see if you get the output that you expect.

### Exercise 2: A faulty implementation

_Driver: **B**_

a. The file `ArrayBasedStack.java` has at least one significant bug. Identify that bug (or those bugs).

b. Correct any bugs you identified.

c. Commit and push your changes.

```text
git add src/main/java/edu/grinnell/csc207/linear/ArrayBasedStack.java 
git status
git commit -m "Squash bugs in ArrayBasedStack.java"
git pull
git push
```

### Exercise 3: Matching parens

_Driver: **A**_

One useful application of stacks is matching things.  For example, we can match the parens in a Scheme expression as follows:

```text
Step through the characters in the expression
    When you encounter an open paren or open square bracket, push it 
      on the stack
    When you encounter a close paren or close square bracket, pop 
      the corresponding opening character off the stack.  If the two
      characters don't match, issue an error.
    If you encounter a closing character with an empty stack, that 
      close paren or bracket is mismatched.
If the stack is not empty, there are unmatched open or closed parens.
```

Implement this algorithm in the class `StringUtils.java`, which should be available in the repository.  (You might also add support for braces and angle brackets.)  That is, write and experiment with a static method, `checkMatching(String str)`, that checks whether the parens, square brackets, and potentially, other characters, match correctly.

You can find experiments to check your code in `CheckMatchingExperiments.java`.

When you are done, push your updated code to GitHub.

```text
git add src/main/java/edu/grinnell/csc207/util/StringUtils.java 
git status
git commit -m "Implement the `checkMatching` method."
git pull
git push
```

### Exercise 4: Exploring linked stacks

_Driver: **B**_

The strategy for implementing a _linked stack_ is relatively straightforward.

* We keep a reference to a node at the top of the stack.  
* To add an element, we create a new node whose next element is 
  the top of the stack, and then update the top of the stack.  
* To remove an element, we save the value at the top and set the
  top to the next element.  (This is Java; we don't have to explicitly 
  free the node we no longer use.)

There are a few more subtleties, but those are the basics.

a. Sketch (that is, write down approximate code on paper or whiteboard, rather than writing code on the computer) implementations of the five basic linear-structure methods: `put`, `get`, `peek`, `isEmpty`, and `isFull`. Don't forget to consider edge cases, such as when the stack becomes empty or adds its first element.

b. The file `LinkedStack.java` provides an implementation of linked stacks.  Compare your notes to that one and suggest anything you've found by comparing the two.  (It may be that you realize you missed something.  It may be that you realize that our implementation is incorrect or incomplete.)

### Exercise 5: Getting started with linked queues

_Driver: **A**_

The strategy for implementing a _linked queue_ is also relatively straightforward.

* We keep two references: One to the front of the queue and one to the back of the queue.  
* To add an element, we put it after the back and update the back reference.  
* To remove an element, we save the value at the front of the queue and update the front reference to the next node.  

a. Sketch (that is, write down approximate code on paper or whiteboard, rather than writing code on the computer) implementations of the five basic linear-structure methods: `put`, `get`, `peek`, `isEmpty`, and `isFull`. Don't forget to consider edge cases, such as when the queue empties or when we add the first element to the queue.

b. The file `LinkedQueue.java` has a partial implementation of this approach.  Finish that implementation.

c. Commit and push your changes.

```text
git add src/main/java/edu/grinnell/csc207/linear/LinkedQueue.java 
git status
git commit -m "Implement the `checkMatching` method."
git pull
git push
```

### Exercise 6: Iterators

_Driver: **B**_

In the early days of programming language design (that is, the mid-1970's), Barbara Liskov at MIT developed the notion of "iterator", an object that traverses an arbitrary collection (stack, queue, associative array, tree, graph, etc.) giving you the elements one at a time.

Java incorporates iterators in two primary ways: First, there is an [`Iterator`]({{ site.java_api }}/java/util/Iterator.html) interface that describes how iterators behave. As importantly, behind the scenes, Java uses iterators for for-each loops.

For our purpose, we can think of the `Iterator<T>` interface as specifying two primary methods.

* `T next()` grabs the next element from the collection without removing it.
* `boolean hasNext()` determines whether we can call `next`.

You can probably imagine the standard iterator loop. Here's code for an iterator over a collection of strings.

```java
Iterator<String> elements = strings.iterator();
while (elements.hasNext()) {
  String val = elements.next();
  process(val);
} // while
```

That loop is standard enough that the `for-each` loop replaces it (and behaves exactly the same way).

```java
for (T val : strings) {
  process(val);
} // for
```

Since iterators are objects, we need to define a class for such objects. We'll start by using our normal techniques to define such classes, but we'll soon discover an advanced Java technique that makes our code more concise.

a. Suppose you were designing a `LinkedQueueIterator<T>` class that implements the `Iterator<T>` interface. What fields would you put in that class? (Write your answer on a piece of paper or whiteboard.)

b. How would you initialize those fields in the constructor? (Write your answer on a piece of paper or whiteboard.)

c. Based on those decisions, what might the `hasNext()` method look like? (You can assume that the queue does not change while we are iterating it.) (Write your answer on a piece of paper or whiteboard.)

d. What might the `next()` method look like? (Write your answer on a piece of paper or whiteboard.)

e. Compare your answer to that in the `LinkedQueue.java` class.

Submitting
----------

Please summarize what you've learned in the lab writeup on Gradescope.

For those with extra time
-------------------------

_If you find that you finish the lab early, you might consider undertaking one or more of the following problems.  You will likely want to consider them in order._

### Extra 1: Matching, revisited

Revise your answer from the earlier parenthesis matching exercise to store the indices of matching symbols.  That is, you will need to push both symbol and index.  Use the indices to provide better error messages (e.g., you can say where the mismatch occurs in the string).

How can you store two kinds of values in stack?  One option is to make it a stack of `Object` values, and alternately push `Character` and `Integer` objects.  Another option is to create a simple class that groups a character and an integer. A third option is to keep two stacks, one for the characters and one for the integers.

### Extra 2: Displaying matching parens

Extend your answer from the previous extra problem to provide a nice picture of the matching parens.  For example, for each pair of matching parens, you might draw a line underneath, as in the following.

```text
(oh (boy) (I am having) ((so) much) fun matching (parens))
    +---+
          +-----------+
	                 +--+
			+---------+
			                         +------+
+--------------------------------------------------------+
```

