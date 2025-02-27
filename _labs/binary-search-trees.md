---
title: Binary search trees
repo: <https://github.com/Grinnell-CSC207/lab-bsts-maven>
summary: |
  We explore binary search trees and their use in implementing the Map ADT.
---
Preparation
-----------

a. Fork and clone the respository at {{ page.repo }}.

b. Import the repository into VSCode.

c. Update the README.md`.

d. Commit and push the updated `README.md` file.

e. Skim the `BSTNode` class and the fields and constructors in
`SimpleBST` to make sure that you understand the organiation of the
BST data structure.

Exercises
---------

### Exercise 1: Getting elements

_Driver: **A**_

As you likely noted, a `BSTNode` has four fields: a key, a value, a pointer to the left subtree, and a pointer to the right subtree.

We compare values in the tree using the `order` field in the `SimpleBST` class.

a. Review the documentation for `get(K key)` in `SimpleMap.java`.

b. Sketch how you would write the `get(K key)` method for the `SimpleBST.java` class.

c. Compare your answer to the extant `get` method in `SimpleBST.java`.

### Exercise 2: Our experiment

_Driver: **B**_

a. Review `BSTExperiment.java` and note to yourself what the experiment checks and what output you would expect.

b. Run the code to see if you get the expected output.

### Exercise 3: Setting elements

_Driver: **B**_

Unfortunately, we have not yet implemented the `set(K key, V value)` method, so the experiment doesn't do all that much. 

That means we should implement `set`. There are two typical approaches  for `set`, one iterative and one recursive.

In the iterative approach, you repeatedly follow the appropriate branch to the left or right subtree until either (a) you find a node that contains the same key or (b) you observe that the subtree you are about to enter is null.  In case (a), you replace the corresponding value and do not change the size of the tree.  In case (b), you build a new node, set the appropriate link, and increment the size.  You will also need a special case for the root.

In the recursive approach, you write a helper procedure that takes a node in addition to the key and value as parameters and returns a modified subtree.  

```text
Node insert(Node node, K key, V value)
  if node is null
    return new Node(key,value);
  else if (key < node.key)
    node.left = insert(node.left, key, value)
  else if (key > node.key)
    node.left = insert(node.right, key, value)
  else // key == node.key
    Remember the old value in node
    node.value = value
```

You can also use a similar mechanism if you choose to have immutable trees.

You don't need a special case for the root, since you can just write `root = insert(root, key, value)`.

However, you may need another field to keep track of the old value associated with the key, if there is one.  (Fortunately, our `SimpleBST` class has a `cachedValue` field for just that purpose.)

a. Review the documentation for the `set` method in `SimpleMap.java`.

b. You should have received a card from one of the course staff noting that you are in group I(terative) or group R(ecursive).  Implement the `set` method using the specified approach.  Be prepared to discuss issues with your peers.

c. Rerun the experiment to determine whether your `set` method seems to be operating correctly.

### Exercise 4: Applying a procedure to each entry

_Driver: **A**_

a. Review the documentation for `forEach`.

b. Implement `forEach`. Since the iterators are not yet implemented, you may not use any of the iterators in implementing `forEach`.

### Excercise 5: Iteration

_Driver: **B**_

Finish implementing `nodes()`.

For those with extra time
-------------------------

_If you find that you have extra time, try any of the following problems._

### Extra 1: An alternate `set`

a. You implemented `set` iteratively or recursively. Implement it in the other way.

b. Which implementation do you prefer?  Why?

### Extra 2: Breadth-first iteration

Revise `forEach` so that it iterates values in a breadth-first rather than depth-first order.  (If you already had it iterate in a breadth-first order, have it iterate in a depth-first order.)

### Extra 3: Removing elements

Sketch how you might implement the primary `remove` method.

Notes
-----

### Simulating recursion

If you need to simulate a recursive method without recursion, the most common strategy is to use a stack.

### Breadth-first traversal

The typical way to do breadth-first iteration is with a queue.

### Set, iterative

If you are assigned the iterative version of `set`, here's pseudocode

```text
if (root is null)
  set the root to a new node
else
  set current to root
  while (...) 
    compare key to current.key
    case =:
      replace the value
      return the old value
    case <:
      if there is a left subtree, 
        current = left
      otherwise
        current.left = new node
        add 1 to size
        return null
    case > (the "else case"):
      if there is a right subtree, 
        current = right
      otherwise
        current.right = new node
        add 1 to size
        return null
```

### Set, recursive

If you are assigned the recursive version of `set`, here's another set of pseudocode.

```text
function set(key, value)
  root = setHelper(root, key, value)
  return cache

function setHelper(node, key, value)
  if node == null
    set cache to null
    add 1 to size
    return a new node
  else
    compare key to node.key
    case =:
      set cache to value in node
      update value in node
      return node
    case <:
      node.left = setHelper(node.left, key, value);
      return node;
    case >: (the "else case")
      node.right = setHelper(node.right, key, value);
      return node;
```
