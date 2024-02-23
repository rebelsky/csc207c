---
title: Linear structures
summary: | 
  In this laboratory, you will have an opportunity to ground your
  understanding of linear structures, including both array-based
  and linked structures.
repo: <https://github.com/Grinnell-CSC207/linear-structures>
repo2: <git@github.com:Grinnell-CSC207/linear-structures.git>
todo:
  - Come up with some linked queue questions.
  - Consider how to address iterators.
link: true
---

Preparation
-----------

a. Open [the reading on linear structures](../readings/linear-structures), [the reading on stacks](../readings/stacks), and [the reading on queues](../readings/queues) in separate tabs.

b. Fork and clone the repo at {{ page.repo }} or {{ page.repo2 }}.

Exercises
---------

### Exercise 1: Basic experiments

_Driver: **A**_

Read through `LinearStructureExpt.java` and `LinkedStackExpt.java`.  Summarize what the stack should look like at each step.  (A piece of paper might help.)  Note that the `info` method will print information on the stack (is it empty? is it full? what elements are in the structure?) and the `clear` method will repeatedly call `get` until the structure is empty.

Run `LinkedStackExpt` and see if you get the output that you expect.

### Exercise 2: A wrapper class

_Driver: **B**_

Skim through `ReportingLinearStructure.java`.  Summarize the main approach of the class.  What ideas from the class might you apply in other situations?  (Pick at least one or two.)

Note that you need not record anything for this problem, other than notes to yourself for future programs.

### Exercise 3: A faulty implementation

_Driver: **A**_

The file `ArrayBasedStack.java` has at least one significant bug. Identify and correct any bugs you identify.

### Exercise 4: Matching parens

_Driver: **B**_

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

Implement this algorithm.  (You might also add support for braces and angle brackets.)  That is, write and experiment with a static method, `checkMatching(String str)`, that checks whether the parens, square brackets, and potentially, other characters, match correctly.

You should put your static method in a new class, `StringUtils.java`.

```
import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+

  /**
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) {
    Stack<Character> parens = new LinkedStack<Character>();
    return false;       // STUB
  } // checkMatching

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+
  /**
   * A quick set of experiments with checkMatching.
   */
  static void checkMatchingExperiments(PrintWriter pen) {
    checkMatchingExperiment(pen, "");
    checkMatchingExperiment(pen, "()");
    checkMatchingExperiment(pen, "(");
    checkMatchingExperiment(pen, ")");
    checkMatchingExperiment(pen, "[]()");
    checkMatchingExperiment(pen, "[()([])]");
    checkMatchingExperiment(pen, "[a(b]c)");
    checkMatchingExperiment(pen, "Hello (there) (world (!!))");
    checkMatchingExperiment(pen, "alphabetical");
    checkMatchingExperiment(pen, "((((((((a))))))))");
    checkMatchingExperiment(pen, "((((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a))))))])");
    checkMatchingExperiment(pen, "((((b)(((((a)(c)))(d))))))");
    // Feel free to add your own
  } // PrintWriter()

  /**
   * A single experiment with checkMatching.
   */
  static void checkMatchingExperiment(PrintWriter pen, String str) {
    pen.print("checkMatching(\"" + str + "\") = ");
    pen.flush();
    try {
      pen.println(checkMatching(str));
    } catch (Exception e) {
      pen.println("*** ERROR *** " + e.toString());
    }
  } // checkMatchingExperiment(PrintWriter, String)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run a few experiments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    checkMatchingExperiments(pen);
    pen.close();
  } // main(String[])
} // class StringUtils
```

### Exercise 5: Exploring linked stacks

_Driver: **A**_

The strategy for implementing a linked stack is relatively straightforward.

* We keep a reference to a node at the top of the stack.  
* To add an element, we create a new node whose next element is 
  the top of the stack, and then update the top of the stack.  
* To remove an element, we save the value at the top and set the
  top to the next element.  (This is Java; we don't have to explicitly 
  free the node we no longer use.)

There are a few more subtleties, but those are the basics.

a. Sketch (that is, write down approximate code on paper, rather than writing code on the computer) implementations of the five basic linear-structure methods: `put`, `get`, `peek`, `isEmpty`, and `isFull`.

b. The file `LinkedStack.java` provides an implementation of linked stacks.  Compare your notes to that one and suggest anything you've found by comparing the two.  (It may be that you realize you missed something.  It may be that you realize that our implementation is incorrect or incomplete.)

### Exercise 6: Getting started with linked queues

_Driver: **B**_

The strategy for implementing a linked queue is also relatively straightforward.

* We keep two references: One to the front of the queue and one to the back of the queue.  
* To add an element, we put it after the back and update the back reference.  
* To remove an element, we save the value at the front of the queue and update the front reference to the next node.  

a. Sketch (that is, write down approximate code on paper, rather than writing code on the computer) implementations of the five basic linear-structure methods: `put`, `get`, `peek`, `isEmpty`, and `isFull`.

b. The file `LinkedQueue` has a partial implementation of this approach.  Finish that implementation.

Submitting
----------

Please submit your updated code on Gradescope.

For those with extra time
-------------------------

_If you find that you finish the lab early, you might consider undertaking one or more of the following problems.  You will likely want to consider them in order._

### Extra 1: Matching, revisited

Revise your answer from the earlier parenthesis matching exercise to store the indices of matching symbols.  That is, you will need to push both symbol and index.  Use the indices to provide better error messages (e.g., you can say where the mismatch occurs in the string).

How can you store two kinds of values in stack?  One option is to make it a stack of `Object` values, and alternately push `Character` and `Integer` objects.  Another option is to create a simple class that groups a character and an integer.

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

