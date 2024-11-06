---
title: Doubly-linked lists 
summary: |
  We explore the implications of doubly-linked lists.
repo: <https://github.com/Grinnell-CSC207/lab-linked-lists-maven>.
prereqs: |
  [Interfaces](../readings/interfaces).
  [Generics](../readings/generics).
  [Anonymous inner classes](../readings/anonymous-inner-classes).
  [Iterating lists](../readings/list-iterators).
---
Preparation
-----------

a. Fork the repository at {{ page.repo }}.

b. Clone the repository.

c. Load it into VSCode.

d. Update the `README.md` file.

e. Push the updated repository to GitHub.

```text
git add README.md
git status
git commit -m "Add our names to the README."
git pull
git push
```

f. Open [the lab writeup on Gradescope](https://www.gradescope.com/courses/818402/assignments/5280274). You'll be answering questions as you go.

Exercises
---------

### Exercise 1: Exploring doubly linked nodes

_Driver: **A**_

As you may recall, `Node2` is our class for doubly-linked nodes.
Each `Node2` has three fields:

```java
  /**
   * The previous node.
   */
  Node2<T> prev;

  /**
   * The stored value.
   */
  T value;

  /**
   * The next node.
   */
  Node2<T> next;
```

a. Suppose we decided to add a `remove()` method to `Node2`, which is supposed to remove the node (i.e., `this`) from its enclosing list. Sketch how you would implement that method. (I'd suggest sketching both the list and the code.)

b. Suppose we decided to add an `insertAfter(T val)` method to `Node2`, which is supposed to add a value after the current node, creating a new node to hold it. Sketch how you would implement that method.

c. Suppose we decided to add an `insertBefore(T val)` method to `Node2`, which is supposed to add a value before the current node, creating a new node to hold it. Sketch how you would implement that method.

d. Given that we've decided to provide these three methods for the `Node2` class, are there any similar methods you would add?

e. Compare your answers to a-c to the implementation in `Node2.java`. What differences, if any, did you see?

### Exercise 2: Iterating doubly-linked lists

_Driver: **B**_

As you may recall, we've decided that our lists should provide two methods, `iterator()`, which returns a normal `Iterator`, and `listIterator()`, which returns a `ListIterator`. List iterators support a variety of operations, including `next`, `previous`, `hasNext`, `hasPrevious`, `add`, `remove`, `set`, `nextIndex`, and `previousIndex`. List iterators are also conceptually "between" nodes. 

Let's assume that our primary doubly-linked list class has two fields.

```java
  /**
   * The front of the list
   */
  Node2<T> front;

  /**
   * The number of values in the list.
   */
  int size;
```

a. What fields would you expect the list iterator for doubly-linked lists to have?

b. How would you initialize each of those fields?

c. Compare your answers to those in those in `SimpleDLL.java`.

d. Explain the purpose of the `update` field.

e. When would you expect to use `update`?  When would you expect to change `update`?

### Exercise 3: Advancing the cursor

_Driver: **A**_

a. Sketch (picture and code) how you would implement the `next` method in the list iterator.

b. Compare your answer to that in `SimpleDLL.java`. What differences, if any, did you note?

### Exercise 4: Adding elements

_Driver: **B**_

Note that the "heavy lifting" of adding elements can be handled by `Node2.insertBefore()` and `Node2.insertAfter()`. However, that does not mean that the `add` method is trivial.

a. In the "normal" case, when the iterator is in the middle of a list, how should the iterator add an element?

b. Other than adding the element, what fields do you need to update in the "normal" case?

c. What are the special cases you might have to handle?

d. One possible special case is when the cursor is at the back of the list. How does that differ from the "normal" case?

e. Another possible special case is when the cursor is at the front of a nonempty list. How should we handle that differently than the "normal" case?

f. Another possible special case is when the list is empty. How should we handle that case differently than the other cases?  (Or should we handle it differently than the previous cases?)

g. What other special cases did you identify and how should you handle them?

h. Compare your design to that of `add`.

### Exercise 5: Removing elements

_Driver: **A**_

Note that the "heavy lifting" of removing elements can be handled by `Node2.remove()`. However, that does not mean that the `remove` method is completely trivial.

a. In the "normal" case, when the cursor is in the middle of a list, how should the iterator remove an element?

b. Other than removing that element, what fields do you need to update in the "normal" case?

c. What are the special cases you might have to handle?

d. One possible special case is when we are removing the last element in the list. How does that differ from the "normal" case?

e. Another possible special case is when we are removing the front of a nonempty list. How should we handle that differently than the "normal" case?

f. Another possible special case is when we are removing the only element in a list. How should we handle that case differently than the other cases?  (Or should we handle it differently than the previous cases?)

g. What other special cases did you identify and how should you handle them?

h. Compare your design to that of `remove`.

### Exercise 6: Some experiments

_Driver: **B**_

The files `SDLLExpt.java` and `SimpleListExpt.java` contain a collection
of tests for simple doubly-linked lists (or doubly-linked simple lists,
depending on how you think of them).

a. Skim through the two files to identify what the primary tests are.

b. Sketch the expected output from `SDLLExpt`. (Note that it is not 
completely predictable.)

c. Run the experiments and enter the results on Gradescope.

d. Compare the results to your output. Where did things work differently than you expected?

### Exercise 7: Implementing `previous`

_Driver: **A**_

As you may have noted, we have some issues with the random walk experiment. That's because `previous` is not implemented.

a. Write experiments, comparable to `expt2` and `expt3`, that experiment with removing elements using `previous`. You can take advantage of `removeBackwardsExpt` in writing those experiments.

b. Implement the `previous` method.

c. Run the newly extended experiments and correct any errors you discover.

### Exercise 8: Additional testing and experimentation

_Driver: **B**_

We've seen that iterators sometimes have difficulty when we remove sequences of values. While `expt3` is intended to capture some such situations, we should have something a bit more systematic.

Write an experiment that tests the effect of alternately removing three elements in a row, and then keeping two elements. Your experiment should remove elements 0, 1, 2, 5, 6, 7, 10, 11, ....

*Hint*: Use `removeForwardExpt` and a `Counter`.

For those with extra time
-------------------------

### Extra 1: Failing fast

Ideally, list iterators should implement the "fail fast" policy: If the list is structurally modified, all iterators other than the iterator that modifies the list should become invalid. The invalid iterators should then throw a `ConcurrentModificationException`.

Sketch the changes you would make to the `SimpleDLL` class and its iterator to implement a "fail fast" policy.

### Extra 2: A dummy node

The [reading on doubly-linked lists](../readings/doubly-linked-lists) suggested that adding a "dummy node" which comes before the first element and after the last element can help eliminate special cases.

Sketch the changes you would make to the `SimpleDLL` class and its iterator to add a dummy node.

Acknowledgements
----------------

This lab was all new in spring 2019, revised somewhat in spring 2024, and revised again in fall 2024.
